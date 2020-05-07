package game;

import graphics.Drawable;

import java.util.*;

/**
 * Interfész, amely a tárgyak egységes kezelését biztosítja, ez szolgál a tárgyak felvételének kezelésére.
 */
public interface Item extends Drawable {
    /**
     * Absztrakt függvény. A FlareGun, a Food vagy a Tool osztály pickMeUp(Player) függvénye kerül meghívásra.
     *
     * @param p Tárgyat felvenni kívánó személy
     */
    Result pickMeUp(Player p);

    /**
     *Az Item nevének kiírásáért felelõs függvény
     */
    void namestate();
}