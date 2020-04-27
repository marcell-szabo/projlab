package skeleton;

import java.util.*;

import skeleton.Result;

import static skeleton.Result.*;

/**
 * J�gt�bl�k/J�gmez�k kezel�s�re szolg�l� oszt�ly. Egyr�szt a j�gmez�k teherb�r�s�nak vizsg�lat�t v�gzi el, m�sr�szt
 * pedig vihar eset�n kezeli, hogy ha az adott mez�n esik a h�, akkor az milyen krit�riumok mellett
 * (van-e igloo vagy nincs) milyen k�vetkezm�nyekkel j�r (mez�n lev� h�r�tegek sz�m�t mindig n�velj�k, viszont a
 * testh� cs�kkent�se csak az iglooval v�detlen mez�k�n t�rt�nik meg).
 */
public class IceField extends Field
{
    /**
     * Megadja, hogy adott j�gmez�re (icefield-re) van-e �p�tve b�rmi.
     */
    protected Igloo protection;
    /**
     * T�rolja, hogy a mez�n milyen t�rgyat lehet felvenni.
     */
    protected Item item;

    /**
     * Default constructor
     */
    public IceField(int snow, int capacity, Item item, String name) {
        super(snow, capacity, name);
        this.item = item;
    }

    /**
     * A Field oszt�lyban l�v� absztrakt f�ggv�ny megval�s�t�sa. Az adott mez� snow attrib�tum�nak �rt�k�t megn�veli
     * eggyel. Amennyiben az adott mez� nem tartalmaz igloo-t, akkor az ilyen mez�n �ll� j�t�kosokra megh�vja a
     * decreaseHeat() met�dust. Amivel ez a f�ggv�ny visszat�r, azzal t�r vissza a storm() is.
     *
     * @return
     */
    public Result storm()
    {
        snow++;
        Result r = NOTHING;
        if (protection == null)
        {
            for (Player ps : players)
            {
                r = ps.decreaseHeat();
                if (r == DIE)
                    return r;
            }
        }
        return r;
    }

    /**
     * A Field oszt�lyban tal�lhat� absztrakt f�ggv�ny megval�s�t�sa.
     * Legel�sz�r megn�zi, hogy tart�zkodik-e az adott mez�n jegesmedve, ha igen, megn�zi, hogy a rajta lev� igloo megv�di-e t�le,
     * ha nem, akkor a f�ggv�ny DIE-al t�r vissza.
     * Ha ezt a vizsg�latot k�vet�en nem keletkezett visszat�r�si �rt�k, akkor az adott
     * mez�n l�v� j�t�kosok sz�ma ker�l vizsg�latra. Amennyiben elb�rja az ott tart�zkod� karaktereket a
     * j�gt�bla, akkor OK, ellenkez� esetben DIE �rt�kkel t�r vissza a met�dus.
     *
     * @param p
     * @return Result
     */
    public Result stepOn(Player p)
    {
        if(protection != null)
            if (polarbear.getActualfield() == this && !protection.protectFromBear())
                return  DIE;
        if (players.size() > capacity)
            return  DIE;
        players.add(p);
        return OK;
    }

    /**
     * Ha van igloo a mez�n, akkor TRUE-val t�r vissza, ellenkez� esetben pedig FALSE-szal.
     *
     * @return
     */
    public boolean haveIgloo()
    {
        return protection != null;
    }

    /**
     * A Field oszt�ly virtu�lis build(Igloo) met�dus�nak a fel�ldefini�l�sa. Megvizsg�lja, hogy a mez�n, tal�lhat�-e �p�tm�ny(s�tor vagy igloo).
     * Ha igen, akkor visszat�r NOTHING-gal, k�l�nben pedig OK-kal
     *
     * @return res Result
     */
    public Result build(Igloo i)
    {
        if (protection == null)
            return NOTHING;
        return OK;
    }

    /**
     * Megvizsg�lja a rajta tal�lhat� h� mennyis�g�t. Ha ez nulla, �s tal�lhat� rajta j�gbe fagyott t�rgy,
     * akkor megh�vja az Item oszt�ly pickMeUp(Player) f�ggv�ny�t.
     * Sikeres t�rgyfelv�tel eset�n OK-kal t�r vissza, egy�bk�nt pedig NOTHING-gal.
     *
     * @return Result az eredm�nnyel
     */
    public Result pickUp(Player p)
    {
        if(snow == 0 && item != null)
        {
            return item.pickMeUp(p);
        }
        return NOTHING;
    }

    @Override
    public Result stepOn(PolarBear pb)
    {
        polarbear = pb;
        if(players == null)
            return OK;
        else if (protection == null)
            return  DIE;
        else if (protection.protectFromBear())
            return  OK;
        return DIE;
    }

    public void aging()
    {
        if (protection != null)
        {
            if (protection.aging() == DISAPPEAR)
                protection = null;
        }
    }

    /**
     * Az IceField adatainak ki�r�s��rt felel�s f�ggv�ny.
     * Megjelen�ti a j�gmez�n tal�lhat� h�r�tegek sz�m�t, a j�gmez� teherb�r�s�t,
     * hogy j�gmez�n tal�lhat�-e valamilyen v�delem, a j�gmez�be fagyott t�rgy nev�t,
     * a j�gmez�n �ll� j�t�kosok nev�t �s hogy tal�lhat�-e jegesmedve a j�gmez�n
     */
    @Override
    public void state() {
        System.out.println("IceField:");
        System.out.println("snow: " + this.snow);
        System.out.println("capacity: " + this.capacity);
        if (protection == null) System.out.println("protection: false");
        else System.out.println("protection: true");
        System.out.print("item: ");
        this.item.namestate();
        System.out.print("\n");
        System.out.print("players: ");
        for (Player p : players) {
            p.namestate();
            System.out.print(", ");
        }
        System.out.print("\n");
        if (polarbear == null) System.out.println("polarbear: false");
        else System.out.println("polarbear: true");
    }
}
