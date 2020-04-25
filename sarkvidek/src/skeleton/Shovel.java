package skeleton;

import java.util.*;

/**
 * Az ásó felvételének, illetve az ásóval rendelkezõ játékosok hóréteg ellapátolásának kezelésére szolgáló osztály.
 */
public class Shovel extends Tool {

    /**
     * Default constructor
     */
    public Shovel() {
    }

    /**
     * Mindig TRUE értékkel tér vissza (hiszen csak akkor hívódik meg, ha egy Shovel példány szeretné magát
     * összehasonlítani vele).
     *
     * @param s az összehasonlításhoz szükséges Shovel példány
     * @return true
     */
    public boolean isSame(Shovel s) {
        return false;
    }

    /**
     * Mindig TRUE értékkel tér vissza (hiszen csak akkor hívódik meg, ha egy BreakableShovel példány szeretné magát
     * összehasonlítani vele).
     *
     * @param bs az összehasonlításhoz szükséges BreakableShovel példány
     * @return true
     */
    public boolean isSame(BreakableShovel bs) {
        return false;
    }

    /**
     * Akkor hívódik meg, ha az ásást végzõ játékosnál van ásó. Ekkor ez a függvény meghívja a
     * Field clean() metódusát, ezzel még egy réteget ellapátolva arról (persze, ha ez lehetséges).
     * Void visszatérésû, mivel nincs jelentõsége, hogy ez a mûvelet sikerült-e vagy sem.
     *
     * @param f A mezõ, amin az ásást kell végrehajtani
     * @return Result a lapátolásról
     */
    public Result clean(Field f) {
        f.clean();
        return Result.Ok;
    }

}