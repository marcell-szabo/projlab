package game;

import graphics.Draw;
import graphics.Drawable;

import java.util.*;

/**
 * A jelzõpisztoly alkotóelemeinek felvételével foglalkozó osztály.
 */
public class FlareGun implements Item, Drawable {
    /**
     * Default constructor
     */
    public FlareGun() {
    }

    /**
     * Attribútumként átadva önmaga referenciáját meghívja a Player osztály addPart(FlareGun) függvényét.
     *
     * @param p Jelzõpisztoly egy elemének felvétele
     * @return OK
     */
    public Result pickMeUp(Player p) {
        p.addPart(this);
        return Result.OK;
    }

    /**
     *A FlareGun nevének kiírásáért felelõs függvény
     */
    @Override
    public void namestate(){ }

    @Override
    public void draw(Draw draw, int x, int y) {

    }
}