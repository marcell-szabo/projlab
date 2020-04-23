package skeleton;
//**push
import java.util.*;

import static skeleton.Result.OK;

/**
 * Lyukak kezel�s�re szolg�l� oszt�ly. A vele kapcsolatos kiment�si k�s�rletet is ez az oszt�ly kezdi meg.
 */
public class Hole extends Field {

    /**
     * Default constructor
     */
    public Hole() {
    }

    /**
     * A Field oszt�lyban l�v� absztrakt f�ggv�ny megval�s�t�sa. Az adott mez� snow attrib�tum�nak �rt�k�t megn�veli eggyel.
     * Mindig OK-kal t�r vissza.
     *
     * @return OK mindig
     */
    public Result storm() {
        System.out.print(this.toString() + ".storm();\n");
        System.out.print(this.toString() + ".storm() returned Result r;\n");
        return null;
    }

    /**
     * A Field oszt�lyban l�v� absztrakt f�ggv�ny megval�s�t�sa.
     * Az attrib�tumk�nt kapott Player p�ld�ny helpMe() met�dus�t h�vja meg,
     * majd ennek a visszat�r�si �rt�k�vel t�r vissza a stepOn(Player) f�ggv�ny is.
     *
     * @param p erre a mez�re l�p� Player
     * @return Result, hogy siker�lt-e kimenteni a j�t�kost.
     */
    public Result stepOn(Player p) {
        System.out.print(this.toString() + ".stepOn(p1);\n");
        p.helpMe();
        System.out.print(this.toString() + ".stepOn(p1) returned Result r;\n");
        return Result.OK;
    }

}