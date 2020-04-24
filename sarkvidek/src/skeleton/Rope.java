package skeleton;

import java.util.*;

/**
 * A k�t�l felv�tel�re, illetve a k�teles kiment�s kezel�s�re szolg�l� oszt�ly.
 */
public class Rope extends Tool {

    /**
     * Default constructor
     */
    public Rope() {
    }

    /**
     * Mindig TRUE �rt�kkel t�r vissza (hiszen csak akkor h�v�dik meg, ha egy Rope p�ld�ny
     * szeretn� mag�t �sszehasonl�tani vele).
     *
     * @param r az �sszehasonl�t�shoz sz�ks�ges Rope p�ld�ny
     * @return true
     */
    public boolean isSame(Rope r) {
        return true;
    }

    /**
     * Megh�vja a param�terk�nt megkapott Player p�ld�ny changeField(Field) met�dus�t, �tadva neki a
     * param�terk�nt a kapott Field p�ld�nyt.
     * A changeField f�ggv�ny visszat�r�si �rt�ke lesz a help f�ggv�ny visszat�r�se is.
     *
     * @param f Az a field amire a player l�pni akar
     * @param p Az a j�t�kos amelyik a m�sik fieldre l�pne
     * @return Result a seg�ts�gr�l
     */
    public Result help(Field f, Player p) {
        return p.changeField(f);
    }

}