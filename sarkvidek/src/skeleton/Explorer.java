package skeleton;

import java.util.*;

/**
 * Sarkkutató karaktertípus esetén megadja a maximális testhő mértékét, illetve kezeli a sarkkutató különleges képességét, tehát egy szomszédos mező teherbírásának vizsgálatát. 
 */
public class Explorer extends Player {

    /**
     * Default constructor
     */
    public Explorer(Game g, Field actual) {
        super(g, actual);
    }

    /**
     * Statikus attribútum. A sarkkutató testhő szintjének maximális számát adja meg.
     */
    private static int heatlimit = 4;

    /**
	* A Player osztályban lévő absztrakt függvény megvalósítása. Először bekér egy irányt, majd erre meghívja a checkNeighbour(Direction) függvényt. Amennyiben ez NULL értékkel tér vissza, akkor a játékosnak újra meg kell adnia egy irányt. Amikor sikerül egy jó irányt megadni, tehát nem NULL visszatérési értéke lesz, akkor a visszakapott mezőre meghívja a getCapacity() függvényt. Minden esetben OK-al té vissza.
     * @return Result - minden esetben OK
     */
    public Result specialSkill(){
        System.out.println(this.toString() + ".specialSkill()");
        actualfield.addNeighbour(new IceField(), Direction.RIGHT);
        for (Direction d: Direction.values()) {
            Field i = actualfield.checkNeighbour(d);
            if (i != null){
                int capacity = i.getCapacity();
                return Result.NOTHING;
            }
        }
        System.out.println(this.toString() + ".specialSkill() returned Result res");
        return Result.NOTHING;
    }

}