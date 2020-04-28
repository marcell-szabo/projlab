package game;

import java.util.*;

import static game.Result.NOTHING;
import static game.Result.OK;

/**
 * ?	Mezõk kezelésére szolgáló absztrakt osztály. Segítségével a játékosok, illetve
 * a vihar által a mezõn végzett tevékenységeket lehet megvalósítani.
 */
public abstract class Field
{
    protected String name;

    /**
     * Az adott mezõn lévõ hóréteg mennyiségét tárolja.
     */
    protected int snow;

    /**
     * Az adott mezõ teherbíró képességét tárolja el. Stabil jégtábla esetén a max játékosok száma,
     * lyuk esetén pedig nulla az értéke.
     */
    protected int capacity;


    /**
     * Tárolja a 4 irányban elhelyezkedõ mezõt.
     */
    protected Map<Integer, Field> neighbours = new HashMap<>();

    /**
     * Tárolja, hogy az adott mezõn melyik játékosok vannak rajta.
     */
    protected List<Player> players = new ArrayList<>();

    /**
     * A játékban szereplõ medvét tárolja el.
     */
    protected static PolarBear polarbear;

    public Field(int snow, int capacity, String name) {
        this.snow = snow;
        this.capacity = capacity;
        this.name = name;
    }

    /**
     * Absztrakt függvény. A Hole vagy az IceField osztály storm() függvénye kerül meghívásra.
     *
     * @return Result enum
     */
    public abstract Result storm();

    /**
     * Absztrakt függvény. A Hole vagy az IceField osztály stepOn() függvénye kerül meghívásra.
     *
     * @param p : Player melyik játékos
     * @return Result enum
     */
    public abstract Result stepOn(Player p);

    /**
     * Az átadott irány alapján visszatér az abban az irányban levõ objektum referenciájával.
     * Ha arra tenger van, akkor ez az érték NULL lesz.
     *
     * @param d - Direction, melyik irány
     * @return Field, annak a mezõnek a referenciájával amire lépett
     */
    public Field checkNeighbour(int d)
    {
        return neighbours.get(d);
    }

    public void addNeighbour(Field f, int d) { neighbours.put(d, f); }

    /**
     * Akkor tér vissza OK értékkel, ha az adott mezõrõl megoldható a vízbe esett játékos vízbõl való kimentése.
     * Ennek eldöntéséhez meghívja sorra összes rajta álló játékos getTools() függvényét,
     * majd a megkapott Tool-okat tartalmazó listákra meghívja a help metódust.
     * Ha legalább egy OK értékkel tér vissza, akkor õ is, különben pedig DIE-al.
     *
     * @return Result OK vagy DIE - attól függõen, hogy ki lehet-e menteni a játékost
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
     * Megvizsgálja, hogy az adott mezõn áll-e az összes játékos, tehát összehasonlítja a
     * megkapott allplayer attribútumot a rajta állók számával. Ha ez megegyezik, akkor TRUE értékkel,
     * ellenkezõ esetben FALSE értékkel tér vissza.
     *
     * @param allplayer összes játékos száma
     * @return boolean TRUE or FALSE
     */
    public boolean haveAllPlayer(int allplayer)
    {
        return players.size() == allplayer;
    }

    /**
     * Üres virtuális függvény, nem csinál semmit sem csak visszatér egy OK-al. Ez a függvény nem
     * lesz meghívva a mûködés során, hanem ezen keresztül az IceField osztályban felülírt változata fog meghívódni.
     *
     * @return OK
     */
    public Result build(Igloo igloo)
    {
        return OK;
    }

    /**
     * Az attribútumban megkapott játékost kiveszi a players attribútumban tárolt játékosok referenciái közül (mivel a játékos elmozdult a mezõrõl).
     *
     * @param p mozgatni kívánt Player
     */
    public void leaveField(Player p)
    {
        players.remove(p);
    }

    public void leaveField() {polarbear.setActualfield(null);}

    /**
     * Megvizsgálja a snow attribútum értékét. Amennyiben ez nem nulla, akkor eggyel csökkenti, majd pedig OK-kal tér vissza.
     * Ellenkezõ esetben nem történik meg a csökkentés, és a visszatérési érték NOTHING lesz.
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
     * Megvizsgálja a rajta található hó mennyiségét.
     * Ha ez nulla, és található rajta jégbe fagyott tárgy, akkor meghívja az Item osztály pickMeUp(Player) függvényét.
     * Sikeres tárgyfelvétel esetén OK-kal tér vissza, egyébként pedig NOTHING-gal.
     *
     * @param p mezõn álló Player
     * @return OK or NOTHING
     */
    public Result pickUp(Player p)
    {
        return null;
    }

    /**
     * Visszaadja az  mezõ teherbíró képességét.
     *
     * @return capacity
     */
    public int getCapacity()
    {
        return capacity;
    }

    public abstract Result stepOn(PolarBear pb);

    public void aging(){}

    public abstract void state();

    /**
     *A mezõ nevének kiírásáért felelõs függvény
     */
    public void namestate(){
        System.out.print(name);
    }
}