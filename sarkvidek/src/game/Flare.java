package game;

import graphics.Draw;
import graphics.Drawable;

/**
 * A jelz�rak�ta jelz�f�ny oszt�lya.
 */
public class Flare extends FlareGun {

    /**
     * A Drawable interf�szb�l implement�lt f�ggv�ny. Megh�vja a saj�t mag�t kirajzol� f�ggv�nyt a Draw oszt�lyban.
     * @param draw - Draw oszt�ly p�ld�nya amelyben implement�lva van a jelz�f�nyt kirajzol� f�ggv�ny.
     * @param x - kirajzol�s hely�nek X koordin�t�ja
     * @param y - kirajzol�s hely�nek Y koordin�t�ja
     */
    @Override
    public void draw(Draw draw, int x, int y) {
        draw.flareDraw(x, y);
    }
}
