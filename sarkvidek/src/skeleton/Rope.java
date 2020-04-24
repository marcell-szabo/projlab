package skeleton;

import java.util.*;

/**
 * A kötél felvételére, illetve a köteles kimentés kezelésére szolgáló osztály.
 */
public class Rope extends Tool {

    /**
     * Default constructor
     */
    public Rope() {
    }

    /**
     * Mindig TRUE értékkel tér vissza (hiszen csak akkor hívódik meg, ha egy Rope példány
     * szeretné magát összehasonlítani vele).
     *
     * @param r az összehasonlításhoz szükséges Rope példány
     * @return true
     */
    public boolean isSame(Rope r) {
        return true;
    }

    /**
     * Meghívja a paraméterként megkapott Player példány changeField(Field) metódusát, átadva neki a
     * paraméterként a kapott Field példányt.
     * A changeField függvény visszatérési értéke lesz a help függvény visszatérése is.
     *
     * @param f Az a field amire a player lépni akar
     * @param p Az a játékos amelyik a másik fieldre lépne
     * @return Result a segítségrõl
     */
    public Result help(Field f, Player p) {
        return p.changeField(f);
    }

}