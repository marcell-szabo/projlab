package game;

import graphics.Draw;
import graphics.Drawable;

/**
 * Igloo �s s�tor megk�l�nb�ztet�s�re szolg�l� oszt�ly.
 */
public class Igloo implements Drawable {

    /**
     * Default constructor
     */
    public Igloo(){
    }

    /**
     * Virtu�lis �res f�ggv�ny, ami csak visszat�r OK-kal.
     *
     * @return OK
     */
    public Result aging(){
        return Result.OK;
    }

    /**
     * TRUE �rt�kkel t�r vissza, mert megv�di a mez�n tartozkod� embereket a jegesmedv�t�l.
     *
     * @return true
     */
    public boolean protectFromBear(){
        return true;
    }

    /**
     * A Drawable interf�szb�l implement�lt f�ggv�ny. Megh�vja a saj�t mag�t kirajzol� f�ggv�nyt a Draw oszt�lyban.
     * @param draw - Draw oszt�ly p�ld�nya amelyben implement�lva van az iglut kirajzol� f�ggv�ny.
     * @param x - kirajzol�s hely�nek X koordin�t�ja
     * @param y - kirajzol�s hely�nek Y koordin�t�ja
     */
    @Override
    public void draw(Draw draw, int x, int y) {
        draw.iglooDraw(x,y);
    }
}
