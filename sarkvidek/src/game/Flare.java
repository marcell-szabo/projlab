package game;

import graphics.Draw;
import graphics.Drawable;

public class Flare extends FlareGun implements Drawable {
    /**
     *A Flare nev�nek ki�r�s��rt felel�s f�ggv�ny
     */
    @Override
    public void namestate(){
        System.out.print("flare");
    }

    @Override
    public void draw(Draw draw, int x, int y) {

    }
}
