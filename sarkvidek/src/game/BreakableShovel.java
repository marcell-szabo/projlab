package game;

import graphics.Draw;
import graphics.Drawable;

import java.util.*;

/**
 * Törékeny ásó kezelésére szolgáló osztály.
 * A törékeny ásó 3 használat után széttörik,
 * így ennek és az ásásnak a lekezelésére szolgáló osztály.
 */
public class BreakableShovel extends Shovel {
    /**
     * Reprezentálja, hogy hányszor használták már az ásót.
     * Alapértéke mindig 3, és amennyiben 0-ra csökken az értéke, akkor eltörik és megsemmisül.
     */
    private int used = 3;

    /**
     * Default constructor
     */
    public BreakableShovel() {}


    /**
     *Akkor hívódik meg, ha az ásást végzõ játékosnál van törékeny ásó.
     * Ekkor a függvény meghívja a Field osztály clean() metódusát,
     * ezzel megpróbálva még egy réteg havat letakarítani a mezõrõl.
     * Amennyiben ez NOTHING-gal tér vissza, akkor a õ is NOTHING-gal fog. Ha ez OK-kal térne vissza,
     * akkor a függvény csökkenti eggyel a used attribútumot, majd ellenõrzi, hogy a used értéke 0-ra csökkent-e.
     * Abban az esetben ha igen, akkor DISAPPEAR-rel tér vissza, különben pedig OK-kal.
     *
     * @param f A mezõ, amin az ásást kell végrehajtani
     * @return Result a lapátolásról és egyben azásó állapotáról (elhasználódott-e).
     */
    @Override
    public Result clean(Field f){
        Result r = f.clean();
        if (r == Result.OK){
            used--;
            if(used == 0) r = Result.DISAPPEAR;
        }
        return r;
    }
}
