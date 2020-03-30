package skeleton;

import java.util.*;

/**
 * Eszkimó karaktertípus esetén megadja a maximális testhő mértékét,
 * illetve kezeli az eszkimó különleges képességét, tehát az igloo építésének menetét.
 */
public class Eskimo extends Player {
    /**
     * Statikus attribútum. Az eszkimó testhő szintjének maximális számát adja meg.
     */
    private static int heatlimit = 5;

    /**
     * Default constructor
     */
    public Eskimo(Game g, Field actual) {
        super(g, actual);
    }

    /**
     * A Player osztályban lévő absztrakt függvény megvalósítása. Meghívja az actualfield attribútumban eltárolt
     * Field-re a buildIgloo() függvényt, majd ennek visszatérési értékével (OK/ NOTHING) tér vissza
     * ez a metódus is.
     */
    public Result specialSkill() {
        System.out.println(this.toString() + ".specialSkill()");
        actualfield.buildIgloo();
        System.out.println(this.toString() + ".specialSkill() returned Result res\n\n");
        return null;
    }

}