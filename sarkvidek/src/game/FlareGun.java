package game;

import graphics.Draw;
import graphics.Drawable;

import java.util.*;

/**
 * A jelzõpisztoly alkotóelemeinek felvételével foglalkozó osztály.
 */
public class FlareGun implements Item {
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
     * A Drawable interfészbõl implementált függvény. Meghívja a saját magát kirajzoló függvényt a Draw osztályban.
     * @param draw - Draw osztály példánya amelyben implementálva van a jelzõpisztoly részeit kirajzoló függvény.
     * @param x - kirajzolás helyének X koordinátája
     * @param y - kirajzolás helyének Y koordinátája
     */
    @Override
    public void draw(Draw draw, int x, int y) {

    }
}