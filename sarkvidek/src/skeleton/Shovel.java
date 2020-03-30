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
     * a param�terknt megadott karakter felvesz egy �s�t
     *
     * @param p a karakter aki felveszi az �s�t
     * @return Result a felv�tel sikeress�g�r�l
     */
    @Override
    public Result pickMeUp(Player p) {
        System.out.println(this.toString() + ".pickMeUp(p);");
        p.addTool(this);
        System.out.println(this.toString() + ".pickMeUp(p) returned Return res;");
        return null;
    }

    /**
     * Mindig TRUE �rt�kkel t�r vissza (hiszen csak akkor h�v�dik meg, ha egy Shovel p�ld�ny szeretn� mag�t
     * �sszehasonl�tani vele).
     *
     * @param s shovel p�ld�ny
     * @return true
     */
    public boolean isSame(Shovel s) {
        // TODO implement here
        return false;
    }

    /**
     * Akkor h�v�dik meg, ha az �s�st v�gz� j�t�kosn�l van �s�. Ekkor ez a f�ggv�ny megh�vja a
     * Field clean() met�dus�t, ezzel m�g egy r�teget ellap�tolva arr�l (persze, ha ez lehets�ges).
     * Void visszat�r�s�, mivel nincs jelent�s�ge, hogy ez a m�velet siker�lt-e vagy sem.
     *
     * @param f actualfield
     */
    public void clean(Field f) {
        System.out.print(this.toString() + ".clean(Field f);\n");
        f.clean();
    }

}