package game;

import graphics.Draw;
import graphics.Drawable;

/**
 * Igloo és sátor megkülönböztetésére szolgáló osztály.
 */
public class Igloo implements Drawable {

    /**
     * Default constructor
     */
    public Igloo(){
    }

    /**
     * Virtuális üres függvény, ami csak visszatér OK-kal.
     *
     * @return OK
     */
    public Result aging(){
        return Result.OK;
    }

    /**
     * TRUE értékkel tér vissza, mert megvédi a mezõn tartozkodó embereket a jegesmedvétõl.
     *
     * @return true
     */
    public boolean protectFromBear(){
        return true;
    }

    /**
     * A Drawable interfészbõl implementált függvény. Meghívja a saját magát kirajzoló függvényt a Draw osztályban.
     * @param draw - Draw osztály példánya amelyben implementálva van az iglut kirajzoló függvény.
     * @param x - kirajzolás helyének X koordinátája
     * @param y - kirajzolás helyének Y koordinátája
     */
    @Override
    public void draw(Draw draw, int x, int y) {
        draw.iglooDraw(x,y);
    }
}
