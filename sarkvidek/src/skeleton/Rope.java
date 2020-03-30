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
     * a param�terknt megadott player felvesz egy k�telet
     *
     * @param p a player aki felveszi az k�telet
     * @return Result a felv�tel sikeress�g�r�l
     */
    @Override
    public Result pickMeUp(Player p) {
        System.out.println(this.toString() + ".pickMeUp(p);");
        p.addTool(this);
        System.out.println(this.toString() + ".pickMeUp(p) returned res;");
        return null;
    }

    /**
     * Mindig TRUE �rt�kkel t�r vissza (hiszen csak akkor h�v�dik meg, ha egy Rope p�ld�ny
     * szeretn� mag�t �sszehasonl�tani vele).
     *
     * @param r rope p�ld�ny
     * @return true
     */
    public boolean isSame(Rope r) {
        // TODO implement here
        return false;
    }

    /**
     * Megh�vja a param�terk�nt megkapott Player p�ld�ny changeField(Field) met�dus�t, �tadva neki a
     * param�terk�nt a kapott Field p�ld�nyt.
     * A changeField f�ggv�ny visszat�r�si �rt�ke lesz a help f�ggv�ny visszat�r�se is.
     *
     * @param f az a field amire a player l�pni akar
     * @param p az a j�t�kos amelyik a m�sik fieldre l�pne
     * @return
     */
    public Result help(Field f, Player p) {
        System.out.print(this.toString() + ".help(Field f, Player p);\n");
        System.out.print(this.toString() + ".help(Field f, Player p) returned Result r;\n");
        return p.changeField(f);
    }

}