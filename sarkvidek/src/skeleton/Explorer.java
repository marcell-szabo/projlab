package skeleton;

import java.util.*;

import static skeleton.Result.*;


/**
 * Sarkkutat� karaktert�pus eset�n megadja a maxim�lis testh� m�rt�k�t,
 * illetve kezeli a sarkkutat� k�l�nleges k�pess�g�t, teh�t egy szomsz�dos mez� teherb�r�s�nak vizsg�lat�t.
 */
public class Explorer extends Player {
    /**
     * Statikus attrib�tum. A sarkkutat� testh� szintj�nek maxim�lis sz�m�t adja meg.
     */
    private static int heatlimit = 4;

    /**
     * Default constructor
     */
    public Explorer(Game g, Field actual, char c, int h) {
        super(g, actual, c, h);
    }

    @Override
    /**
     * Legel�sz�r megvizsg�lja, hogy az adott j�t�kos heat attrib�tum�nak �rt�ke a maxim�lis �rt�k alatt van-e.
     *      * Amennyiben igen, akkor megn�veli eggyel az �rt�k�t, majd OK visszat�r�si �rt�ket ad.
     *      * Ellenkez� esetben kimarad a n�vel�s, �s NOTHING �rt�kkel t�r vissza.
     */
    public Result increaseHeat() {
        if (heat < heatlimit) {
            heat++;
            return OK;
        }
        return NOTHING;
    }

    @Override
    /**
     * A Player oszt�lyban l�v� absztrakt f�ggv�ny megval�s�t�sa.
     * El�sz�r bek�r egy ir�nyt, majd erre megh�vja a checkNeighbour(Direction) f�ggv�nyt.
     * A megkapott ir�nyban l�v� szomsz�d mez�re megh�vja a getCapacity() f�ggv�nyt.
     * Minden esetben OK-al t� vissza.
     *
     * @return Result - minden esetben OK
     */
    public Result specialSkill(String c) {
        int capacity;
        switch (c) {
            case "W":
                if (actualfield.checkNeighbour(0) != null) {
                    capacity = actualfield.checkNeighbour(0).getCapacity();
                    return OK;
                }
                break;
            case "A":
                if (actualfield.checkNeighbour(1) != null) {
                    capacity = actualfield.checkNeighbour(1).getCapacity();
                    return OK;
                }
                break;
            case "S":
                if (actualfield.checkNeighbour(2) != null) {
                    capacity = actualfield.checkNeighbour(2).getCapacity();
                    return OK;
                }
                break;
            case "D":
                if (actualfield.checkNeighbour(3) != null) {
                    capacity = actualfield.checkNeighbour(3).getCapacity();
                    return OK;
                }
                break;
        }
        return OK;
    }

    /**
     * Az Explorer adatainak ki�r�s��rt felel�s f�ggv�ny.
     * Megjelen�ti a sarkkutat� nev�t, testh�m�rs�klet�t, marad�k munk�j�t,
     * a n�la l�v� eszk�z�ket �s annak a mez�nek a nev�t amelyiken �ll.
     */
    @Override
    public void state() {
        System.out.println("Explorer:");
        System.out.println("color: " + this.color);
        System.out.println("heat: " + this.heat);
        System.out.println("work: " + this.work);
        System.out.print("tools: ");
        for(Tool t: getTools()) {
            t.namestate();
            System.out.print(", ");
        }
        System.out.print("\n");
        System.out.print("Actualfield: " );
        actualfield.namestate();
        System.out.print("\n");
    }


}


