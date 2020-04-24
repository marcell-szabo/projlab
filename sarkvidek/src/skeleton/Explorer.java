package skeleton;

import java.util.*;
import static skeleton.Result.*;


/**
 * Sarkkutató karaktertípus esetén megadja a maximális testhõ mértékét,
 * illetve kezeli a sarkkutató különleges képességét, tehát egy szomszédos mezõ teherbírásának vizsgálatát.
 */
public class Explorer extends Player {
    /**
     * Statikus attribútum. A sarkkutató testhõ szintjének maximális számát adja meg.
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
     * Legelõször megvizsgálja, hogy az adott játékos heat attribútumának értéke a maximális érték alatt van-e.
     *      * Amennyiben igen, akkor megnöveli eggyel az értékét, majd OK visszatérési értéket ad.
     *      * Ellenkezõ esetben kimarad a növelés, és NOTHING értékkel tér vissza.
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
     * A Player osztályban lévõ absztrakt függvény megvalósítása.
     * Elõször bekér egy irányt, majd erre meghívja a checkNeighbour(Direction) függvényt.
     * Amennyiben ez NULL értékkel tér vissza, akkor a játékosnak újra meg kell adnia egy irányt.
     * Amikor sikerül egy jó irányt megadni, tehát nem NULL visszatérési értéke lesz, akkor a visszakapott
     * mezõre meghívja a getCapacity() függvényt. Minden esetben OK-al té vissza.
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