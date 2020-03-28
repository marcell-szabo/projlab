package skeleton;

import java.util.*;

/**
 * A kötél felvételére, illetve a köteles kimentés kezelésére szolgáló osztály.
 */
public class Rope extends Item {

    /**
     * Default constructor
     */
    public Rope() {
    }

    /**
	*Mindig TRUE értékkel tér vissza (hiszen csak akkor hívódik meg, ha egy Rope példány szeretné magát összehasonlítani vele).
     * @param r 
     * @return
     */
    public boolean isSame(Rope r) {
        // TODO implement here
        return false;
    }

    /**
	* Meghívja a paraméterként megkapott Player példány changeField(Field) metódusát, átadva neki a paraméterként a kapott Field példányt. A changeField függvény visszatérési értéke lesz a help függvény visszatérése is.
     * @param f 
     * @param p 
     * @return
     */
    public Result help(Field f, Player p) {
        // TODO implement here
        return null;
    }

}