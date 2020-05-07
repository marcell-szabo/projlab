package game;

import graphics.Draw;
import graphics.Drawable;

import java.util.*;

/**
 * A jelz�pisztoly alkot�elemeinek felv�tel�vel foglalkoz� oszt�ly.
 */
public class FlareGun implements Item, Drawable {
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
     *A FlareGun nev�nek ki�r�s��rt felel�s f�ggv�ny
     */
    @Override
    public void namestate(){ }

    @Override
    public void draw(Draw draw, int x, int y) {

    }
}