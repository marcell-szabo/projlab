package game;

import graphics.Draw;
import graphics.Drawable;

import java.util.*;

/**
 * A jelz�pisztoly alkot�elemeinek felv�tel�vel foglalkoz� oszt�ly.
 */
public class FlareGun implements Item {
    /**
     * Default constructor
     */
    public FlareGun() {
    }

    /**
     * Attrib�tumk�nt �tadva �nmaga referenci�j�t megh�vja a Player oszt�ly addPart(FlareGun) f�ggv�ny�t.
     *
     * @param p Jelz�pisztoly egy elem�nek felv�tele
     * @return OK
     */
    public Result pickMeUp(Player p) {
        p.addPart(this);
        return Result.OK;
    }

    /**
     * A Drawable interf�szb�l implement�lt f�ggv�ny. Megh�vja a saj�t mag�t kirajzol� f�ggv�nyt a Draw oszt�lyban.
     * @param draw - Draw oszt�ly p�ld�nya amelyben implement�lva van a jelz�pisztoly r�szeit kirajzol� f�ggv�ny.
     * @param x - kirajzol�s hely�nek X koordin�t�ja
     * @param y - kirajzol�s hely�nek Y koordin�t�ja
     */
    @Override
    public void draw(Draw draw, int x, int y) {

    }
}