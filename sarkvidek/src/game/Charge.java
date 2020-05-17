package game;

import graphics.Draw;
import graphics.Drawable;

/**
 * A jelzõrakéta töltény osztálya.
 */
public class Charge extends FlareGun {
    /**
     * A Drawable interfészbõl implementált függvény. Meghívja a saját magát kirajzoló függvényt a Draw osztályban.
     * @param draw - Draw osztály példánya amelyben implementálva van a Charge-ot kirajzoló függvény.
     * @param x - kirajzolás helyének X koordinátája
     * @param y - kirajzolás helyének Y koordinátája
     */
    @Override
    public void draw(Draw draw, int x, int y) {
        draw.chargeDraw(x, y);
    }
}
