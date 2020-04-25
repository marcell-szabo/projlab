package skeleton;

import java.util.*;

/**
 * Az �s� felv�tel�nek, illetve az �s�val rendelkez� j�t�kosok h�r�teg ellap�tol�s�nak kezel�s�re szolg�l� oszt�ly.
 */
public class Shovel extends Tool {

    /**
     * Default constructor
     */
    public Shovel() {
    }

    /**
     * Mindig TRUE �rt�kkel t�r vissza (hiszen csak akkor h�v�dik meg, ha egy Shovel p�ld�ny szeretn� mag�t
     * �sszehasonl�tani vele).
     *
     * @param s az �sszehasonl�t�shoz sz�ks�ges Shovel p�ld�ny
     * @return true
     */
    public boolean isSame(Shovel s) {
        return false;
    }

    /**
     * Mindig TRUE �rt�kkel t�r vissza (hiszen csak akkor h�v�dik meg, ha egy BreakableShovel p�ld�ny szeretn� mag�t
     * �sszehasonl�tani vele).
     *
     * @param bs az �sszehasonl�t�shoz sz�ks�ges BreakableShovel p�ld�ny
     * @return true
     */
    public boolean isSame(BreakableShovel bs) {
        return false;
    }

    /**
     * Akkor h�v�dik meg, ha az �s�st v�gz� j�t�kosn�l van �s�. Ekkor ez a f�ggv�ny megh�vja a
     * Field clean() met�dus�t, ezzel m�g egy r�teget ellap�tolva arr�l (persze, ha ez lehets�ges).
     * Void visszat�r�s�, mivel nincs jelent�s�ge, hogy ez a m�velet siker�lt-e vagy sem.
     *
     * @param f A mez�, amin az �s�st kell v�grehajtani
     * @return Result a lap�tol�sr�l
     */
    public Result clean(Field f) {
        f.clean();
        return Result.Ok;
    }

}