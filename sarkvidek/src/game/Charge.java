package game;

import graphics.Draw;
import graphics.Drawable;

public class Charge extends FlareGun implements Drawable {

    @Override
    public void draw(Draw draw, int x, int y) {
        draw.chargeDraw(x, y);
    }
}
