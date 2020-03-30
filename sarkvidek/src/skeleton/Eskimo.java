package skeleton;

import java.util.*;

/**
 * Eszkim� karaktert�pus eset�n megadja a maxim�lis testh� m�rt�k�t,
 * illetve kezeli az eszkim� k�l�nleges k�pess�g�t, teh�t az igloo �p�t�s�nek menet�t.
 */
public class Eskimo extends Player {
    /**
     * Statikus attrib�tum. Az eszkim� testh� szintj�nek maxim�lis sz�m�t adja meg.
     */
    private static int heatlimit = 5;

    /**
     * Default constructor
     */
    public Eskimo(Game g, Field actual) {
        super(g, actual);
    }

    /**
     * A Player oszt�lyban l�v� absztrakt f�ggv�ny megval�s�t�sa. Megh�vja az actualfield attrib�tumban elt�rolt
     * Field-re a buildIgloo() f�ggv�nyt, majd ennek visszat�r�si �rt�k�vel (OK/ NOTHING) t�r vissza
     * ez a met�dus is.
     */
    public Result specialSkill() {
        System.out.println(this.toString() + ".specialSkill()");
        actualfield.buildIgloo();
        System.out.println(this.toString() + ".specialSkill() returned Result res\n\n");
        return null;
    }

}