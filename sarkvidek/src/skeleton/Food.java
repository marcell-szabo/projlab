package skeleton;

import java.util.*;

/**
 * Étel felvételének kezelésére szolgáló osztály.
 */
public class Food extends Item {

    /**
     * Default constructor
     */
    public Food() {
    }

    /**
     * A felvett étellel növeli a testhőt
     * Meghívja a Player osztály increaseHeat() függvényét. Amivel az általa hívott metódus tér vissza,
     * az lesz ennek a függvénynek is a visszatérési értéke.
     *
     * @param p az ételt felvevő játékos
     * @return Result az eredménnyl visszatér
     */
    public Result pickMeUp(Player p) {
        System.out.println(this.toString() + ".pickMeUp(p);");
        Result r = p.increaseHeat();
        System.out.println(this.toString() + ".pickMeUp(p) returned Return res;");
        return Result.OK;
    }

}