package game;

import graphics.Draw;
import graphics.Drawable;

import java.util.*;
import java.util.List;

import static game.Result.NOTHING;
import static game.Result.OK;

/**
 * ?	Mez�k kezel�s�re szolg�l� absztrakt oszt�ly. Seg�ts�g�vel a j�t�kosok, illetve
 * a vihar �ltal a mez�n v�gzett tev�kenys�geket lehet megval�s�tani.
 */
public abstract class Field implements Drawable {
    protected String name;

    /**
     * Az adott mez�n l�v� h�r�teg mennyis�g�t t�rolja.
     */
    protected int snow;

    //A Fielden l�v� t�rgy referenci�ja
    private Item item;

    /**
     * Az adott mez� teherb�r� k�pess�g�t t�rolja el. Stabil j�gt�bla eset�n a max j�t�kosok sz�ma,
     * lyuk eset�n pedig nulla az �rt�ke.
     */
    protected int capacity;

    /**
     * T�rolja a 4 ir�nyban elhelyezked� mez�t.
     */
    protected Map<Integer, Field> neighbours = new HashMap<>();

    /**
     * T�rolja, hogy az adott mez�n melyik j�t�kosok vannak rajta.
     */
    protected List<Player> players = new ArrayList<>();

    /**
     * A j�t�kban szerepl� medv�t t�rolja el.
     */
    protected static PolarBear polarbear;

    /**
     * Field konstruktora. Be�ll�tja az attrib�tumait a param�terk�nt kapott h�mennyis�gre, kapacit�sra �s n�vre.
     * @param snow - az adott mez� h�mennyis�ge
     * @param capacity - az adott mez� teherb�r�sa
     * @param name - az adott mez� neve
     */
    public Field(int snow, int capacity, String name) {
        this.snow = snow;
        this.capacity = capacity;
        this.name = name;
    }

    /**
     * Absztrakt f�ggv�ny. A Hole vagy az IceField oszt�ly storm() f�ggv�nye ker�l megh�v�sra.
     *
     * @return Result enum
     */
    public abstract Result storm();

    /**
     * Absztrakt f�ggv�ny. A Hole vagy az IceField oszt�ly stepOn() f�ggv�nye ker�l megh�v�sra.
     *
     * @param p : Player melyik j�t�kos
     * @return Result enum
     */
    public abstract Result stepOn(Player p);

    /**
     * Az �tadott ir�ny alapj�n visszat�r az abban az ir�nyban lev� objektum referenci�j�val.
     * Ha arra tenger van, akkor ez az �rt�k NULL lesz.
     *
     * @param d - Direction, melyik ir�ny
     * @return Field, annak a mez�nek a referenci�j�val amire l�pett
     */
    public Field checkNeighbour(int d)
    {
        return neighbours.get(d);
    }

    public void addNeighbour(Field f, int d) { neighbours.put(d, f); }

    /**
     * Akkor t�r vissza OK �rt�kkel, ha az adott mez�r�l megoldhat� a v�zbe esett j�t�kos v�zb�l val� kiment�se.
     * Ennek eld�nt�s�hez megh�vja sorra �sszes rajta �ll� j�t�kos getTools() f�ggv�ny�t,
     * majd a megkapott Tool-okat tartalmaz� list�kra megh�vja a help met�dust.
     * Ha legal�bb egy OK �rt�kkel t�r vissza, akkor � is, k�l�nben pedig DIE-al.
     *
     * @return Result OK vagy DIE - att�l f�gg�en, hogy ki lehet-e menteni a j�t�kost
     */
    public Result canHelp(Player player)
    {
        for (Player p : players)
        {
            for (Tool t : p.getTools())
            {
                if (t.help(this, player) == OK)
                    return OK;
            }
        }
        return NOTHING;
    }

    /**
     * Megvizsg�lja, hogy az adott mez�n �ll-e az �sszes j�t�kos, teh�t �sszehasonl�tja a
     * megkapott allplayer attrib�tumot a rajta �ll�k sz�m�val. Ha ez megegyezik, akkor TRUE �rt�kkel,
     * ellenkez� esetben FALSE �rt�kkel t�r vissza.
     *
     * @param allplayer �sszes j�t�kos sz�ma
     * @return boolean TRUE or FALSE
     */
    public boolean haveAllPlayer(int allplayer)
    {
        return players.size() == allplayer;
    }

    /**
     * �res virtu�lis f�ggv�ny, nem csin�l semmit sem csak visszat�r egy OK-al. Ez a f�ggv�ny nem
     * lesz megh�vva a m�k�d�s sor�n, hanem ezen kereszt�l az IceField oszt�lyban fel�l�rt v�ltozata fog megh�v�dni.
     *
     * @return OK
     */
    public Result build(Igloo igloo)
    {
        return OK;
    }

    /**
     * Getter f�ggv�ny a h�mennyis�gre.
     * @return az adott mez� h�mennyis�ge
     */
    public int getSnow(){
        return snow;
    }

    /**
     * Az attrib�tumban megkapott j�t�kost kiveszi a players attrib�tumban t�rolt j�t�kosok referenci�i k�z�l (mivel a j�t�kos elmozdult a mez�r�l).
     *
     * @param p mozgatni k�v�nt Player
     */
    public void leaveField(Player p)
    {
        players.remove(p);
    }

    /**
     * Amikor a jegesmedve elhagyja a mez�t, akkor be�ll�tja null-ra.
     */
    public void leaveField() {polarbear.setActualfield(null);}

    /**
     * Megvizsg�lja a snow attrib�tum �rt�k�t. Amennyiben ez nem nulla, akkor eggyel cs�kkenti, majd pedig OK-kal t�r vissza.
     * Ellenkez� esetben nem t�rt�nik meg a cs�kkent�s, �s a visszat�r�si �rt�k NOTHING lesz.
     *
     * @return Result OK or NOTHING
     */
    public Result clean()
    {
        if (snow != 0)
        {
            snow--;
            return OK;
        }
        return Result.NOTHING;
    }

    /**
     * Megvizsg�lja a rajta tal�lhat� h� mennyis�g�t.
     * Ha ez nulla, �s tal�lhat� rajta j�gbe fagyott t�rgy, akkor megh�vja az Item oszt�ly pickMeUp(Player) f�ggv�ny�t.
     * Sikeres t�rgyfelv�tel eset�n OK-kal t�r vissza, egy�bk�nt pedig NOTHING-gal.
     *
     * @param p mez�n �ll� Player
     * @return OK or NOTHING
     */
    public Result pickUp(Player p)
    {
        return null;
    }

    /**
     * Visszaadja az  mez� teherb�r� k�pess�g�t.
     *
     * @return capacity
     */
    public int getCapacity()
    {
        return capacity;
    }

    /**
     * Absztrakt f�ggv�ny, a jegesmedve mez�re l�p�s�t val�s�tj�k meg a lesz�rmazottak.
     * @param pb - jegesmedve referenci�ja
     * @return a medve mez�re l�p�s�nek eredm�nye
     */
    public abstract Result stepOn(PolarBear pb);

    /**
     * A mez� �reg�t�s�t v�gzi, azaz a letelt k�r�k f�ggv�ny�ben �reg�ti a p�ly�t.
     */
    public void aging(){}

    /**
     * Getter f�ggv�ny, visszaadja a mez�n l�v� iglu vagy s�tor referenci�j�t.
     * @return iglu vagy s�tor referenci�ja
     */
    public Igloo getProtection(){return null;}

    /**
     * Getter f�ggv�ny, visszaadja a mez�n l�v� Item referenci�j�t.
     * @return Item referencia
     */
    public Item getItem(){return null;}

    /**
     * Absztrakt f�ggv�ny. A Drawable interf�szb�l implement�lt f�ggv�ny.
     * @param draw - Draw oszt�ly p�ld�nya amelyben implement�lva van a mez�ket kirajzol� f�ggv�ny.
     * @param x - kirajzol�s hely�nek X koordin�t�ja
     * @param y - kirajzol�s hely�nek Y koordin�t�ja
     */
    public abstract void draw(Draw draw, int x, int y);
}