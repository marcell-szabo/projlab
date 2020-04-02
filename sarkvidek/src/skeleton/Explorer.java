package skeleton;

import java.util.*;

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
    public Explorer(Game g, Field actual) {
        super(g, actual);
    }

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
        System.out.println(this.toString() + ".specialSkill()");
        actualfield.addNeighbour(new IceField(), Direction.RIGHT);
        for (Direction d : Direction.values()) {
            // TODO átírni skeleton tervezése alapján
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