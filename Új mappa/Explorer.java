
import java.util.*;

/**
 * Sarkkutató karaktertípus esetén megadja a maximális testhő mértékét, illetve kezeli a sarkkutató különleges képességét, tehát egy szomszédos mező teherbírásának vizsgálatát. 
 */
public class Explorer extends Player {

    /**
     * Default constructor
     */
    public Explorer() {
    }

    /**
     * Statikus attribútum. A sarkkutató testhő szintjének maximális számát adja meg.
     */
    private static void heatlimit = 4;

    /**
     * 
     */
    public void specialSkill() {
        // TODO implement here
    }

    /**
	* A Player osztályban lévő absztrakt függvény megvalósítása. Először bekér egy irányt, majd erre meghívja a checkNeighbour(Direction) függvényt. Amennyiben ez NULL értékkel tér vissza, akkor a játékosnak újra meg kell adnia egy irányt. Amikor sikerül egy jó irányt megadni, tehát nem NULL visszatérési értéke lesz, akkor a visszakapott mezőre meghívja a getCapacity() függvényt. Minden esetben OK-al té vissza.
     * @return Result - minden esetben OK
     */
    public Result specialSkill();

}