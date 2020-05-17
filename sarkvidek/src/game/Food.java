package game;

import graphics.Draw;
import graphics.Drawable;


/**
 * �tel felv�tel�nek kezel�s�re szolg�l� oszt�ly.
 */
public class Food implements Item {

    /**
     * Default constructor
     */
    public Food() {
    }

    /**
     * A felvett �tellel n�veli a testh�t
     * Megh�vja a Player oszt�ly increaseHeat() f�ggv�ny�t. Amivel az �ltala h�vott met�dus t�r vissza,
     * az lesz ennek a f�ggv�nynek is a visszat�r�si �rt�ke.
     *
     * @param p �telt felvenni k�v�n� j�t�kos
     * @return Result az eredm�nnyel visszat�r
     */
    public Result pickMeUp(Player p) {
        return p.increaseHeat();
    }

    /**
     * A Drawable interf�szb�l implement�lt f�ggv�ny. Megh�vja a saj�t mag�t kirajzol� f�ggv�nyt a Draw oszt�lyban.
     * @param draw - Draw oszt�ly p�ld�nya amelyben implement�lva van az �telt kirajzol� f�ggv�ny.
     * @param x - kirajzol�s hely�nek X koordin�t�ja
     * @param y - kirajzol�s hely�nek Y koordin�t�ja
     */
    @Override
    public void draw(Draw draw, int x, int y) {
        draw.foodDraw(x, y);
    }
}