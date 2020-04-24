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
    public Explorer(Game g, Field actual, char c) {
        super(g, actual, c);
    }

    @Override
    /**
     * Legel�sz�r megvizsg�lja, hogy az adott j�t�kos heat attrib�tum�nak �rt�ke a maxim�lis �rt�k alatt van-e.
     *      * Amennyiben igen, akkor megn�veli eggyel az �rt�k�t, majd OK visszat�r�si �rt�ket ad.
     *      * Ellenkez� esetben kimarad a n�vel�s, �s NOTHING �rt�kkel t�r vissza.
     */
    public Result increaseHeat() {
        if(heat < heatlimit) {
            heat++;
            return OK;
        }
        return NOTHING;
    }

    @Override
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
        Scanner scan = new Scanner(System.in);
        Field field = null;
        int capacity;
        while(field == null){
            String  c = scan.next();
            switch(c){
                case "W":
                    if(actualfield.checkNeighbour(Direction.UP) != null) {
                        capacity = actualfield.checkNeighbour(Direction.UP).getCapacity();
                        return OK;
                    }
                    break;
                case "A":
                    if(actualfield.checkNeighbour(Direction.LEFT) != null) {
                        capacity = actualfield.checkNeighbour(Direction.LEFT).getCapacity();
                        return OK;
                    }
                    break;
                case "S":
                    if(actualfield.checkNeighbour(Direction.DOWN) != null) {
                        capacity = actualfield.checkNeighbour(Direction.DOWN).getCapacity();
                        return OK;
                    }
                    break;
                case "D":
                    if(actualfield.checkNeighbour(Direction.RIGHT) != null) {
                        capacity = actualfield.checkNeighbour(Direction.RIGHT).getCapacity();
                        return OK;
                    }
                    break;
            }
        }

        return Result.NOTHING;
    }



}