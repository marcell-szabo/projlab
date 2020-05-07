package game;

import graphics.Draw;
import graphics.Drawable;

public class Gun extends FlareGun implements Drawable {
    /**
     *A Gun nevének kiírásáért felelõs függvény
     */
    @Override
    public void namestate(){
        System.out.print("gun");
    }

    @Override
    public void draw(Draw draw, int x, int y) {
        draw.gunDraw(x, y);
    }
}
