package game;

import graphics.Draw;
import graphics.Drawable;

public class Charge extends FlareGun implements Drawable {
    /**
     *A Charge nevének kiírásáért felelõs függvény
     */
    @Override
    public void namestate(){
        System.out.print("charge");
    }

    @Override
    public void draw(Draw draw, int x, int y) {
        draw.chargeDraw(x, y);
    }
}
