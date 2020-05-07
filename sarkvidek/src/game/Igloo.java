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
     * TRUE értékkel tér vissza, mert megvédi a mezőn tartozkodó embereket a jegesmedvétől.
     *
     * @return true
     */
    public boolean protectFromBear(){
        return true;
    }

    @Override
    public void draw(Draw draw, int x, int y) {
        draw.iglooDraw(x,y);
    }
}
