package skeleton;

import java.util.*;

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
    public Explorer(Game g, Field actual) {
        super(g, actual);
    }

    /**
     * A Player oszt�lyban l�v� absztrakt f�ggv�ny megval�s�t�sa.
     * El�sz�r bek�r egy ir�nyt, majd erre megh�vja a checkNeighbour(Direction) f�ggv�nyt.
     * Amennyiben ez NULL �rt�kkel t�r vissza, akkor a j�t�kosnak �jra meg kell adnia egy ir�nyt.
     * Amikor siker�l egy j� ir�nyt megadni, teh�t nem NULL visszat�r�si �rt�ke lesz, akkor a visszakapott
     * mez�re megh�vja a getCapacity() f�ggv�nyt. Minden esetben OK-al t� vissza.
     *
     * @return Result - minden esetben OK
     */
    public Result specialSkill() {
        System.out.println(this.toString() + ".specialSkill()");
        actualfield.addNeighbour(new IceField(), Direction.RIGHT);
        for (Direction d : Direction.values()) {
            // TODO �t�rni skeleton tervez�se alapj�n
            Field i = actualfield.checkNeighbour(d);
            if (i != null) {
                int capacity = i.getCapacity();
                System.out.println(this.toString() + ".specialSkill() returned Result res\n\n");
                return Result.NOTHING;
            }
        }
        System.out.println(this.toString() + ".specialSkill() returned Result res\n\n");
        return Result.NOTHING;
    }

}