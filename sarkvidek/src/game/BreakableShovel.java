package game;

import graphics.Draw;
import graphics.Drawable;

import java.util.*;

/**
 * T�r�keny �s� kezel�s�re szolg�l� oszt�ly.
 * A t�r�keny �s� 3 haszn�lat ut�n sz�tt�rik,
 * �gy ennek �s az �s�snak a lekezel�s�re szolg�l� oszt�ly.
 */
public class BreakableShovel extends Shovel {
    /**
     * Reprezent�lja, hogy h�nyszor haszn�lt�k m�r az �s�t.
     * Alap�rt�ke mindig 3, �s amennyiben 0-ra cs�kken az �rt�ke, akkor elt�rik �s megsemmis�l.
     */
    private int used = 3;

    /**
     * Default constructor
     */
    public BreakableShovel() {}


    /**
     *Akkor h�v�dik meg, ha az �s�st v�gz� j�t�kosn�l van t�r�keny �s�.
     * Ekkor a f�ggv�ny megh�vja a Field oszt�ly clean() met�dus�t,
     * ezzel megpr�b�lva m�g egy r�teg havat letakar�tani a mez�r�l.
     * Amennyiben ez NOTHING-gal t�r vissza, akkor a � is NOTHING-gal fog. Ha ez OK-kal t�rne vissza,
     * akkor a f�ggv�ny cs�kkenti eggyel a used attrib�tumot, majd ellen�rzi, hogy a used �rt�ke 0-ra cs�kkent-e.
     * Abban az esetben ha igen, akkor DISAPPEAR-rel t�r vissza, k�l�nben pedig OK-kal.
     *
     * @param f A mez�, amin az �s�st kell v�grehajtani
     * @return Result a lap�tol�sr�l �s egyben az�s� �llapot�r�l (elhaszn�l�dott-e).
     */
    @Override
    public Result clean(Field f){
        Result r = f.clean();
        if (r == Result.OK){
            used--;
            if(used == 0) r = Result.DISAPPEAR;
        }
        return r;
    }
}
