package game;

import graphics.Draw;
import graphics.Drawable;

public class Charge extends FlareGun implements Drawable {
    /**
     *A Charge nev�nek ki�r�s��rt felel�s f�ggv�ny
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
