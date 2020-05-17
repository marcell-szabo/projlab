package game;

import graphics.Draw;
import graphics.Drawable;

/**
 * A jelzõrakéta pisztoly részének osztálya
 */
public class Gun extends FlareGun {

    /**
     * A Drawable interfészbõl implementált függvény. Meghívja a saját magát kirajzoló függvényt a Draw osztályban.
     * @param draw - Draw osztály példánya amelyben implementálva van a pisztolyt kirajzoló függvény.
     * @param x - kirajzolás helyének X koordinátája
     * @param y - kirajzolás helyének Y koordinátája
     */
    @Override
    public void draw(Draw draw, int x, int y) {
        draw.gunDraw(x, y);
    }
}
