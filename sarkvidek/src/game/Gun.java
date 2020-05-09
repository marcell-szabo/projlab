package game;

import graphics.Draw;
import graphics.Drawable;

public class Gun extends FlareGun implements Drawable {

    @Override
    public void draw(Draw draw, int x, int y) {
        draw.gunDraw(x, y);
    }
}
