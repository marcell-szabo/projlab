package game;

import graphics.Draw;
import graphics.Drawable;

public class Flare extends FlareGun implements Drawable {
    /**
     *A Flare nevének kiírásáért felelõs függvény
     */
    @Override
    public void namestate(){
        System.out.print("flare");
    }

    @Override
    public void draw(Draw draw, int x, int y) {

    }
}
