package skeleton;
import static skeleton.Result.*;

/**
 * Eszkimó karaktertípus esetén megadja a maximális testhõ mértékét,
 * illetve kezeli az eszkimó különleges képességét, tehát az igloo építésének menetét.
 */
public class Eskimo extends Player {
    /**
     * Statikus attribútum. Az eszkimó testhõ szintjének maximális számát adja meg.
     */
    private static int heatlimit = 5;

    /**
     * Default constructor
     */
    public Eskimo(Game g, Field actual, char c, int h) {
        super(g, actual, c, h);
    }

    @Override
    /**
     * Legelõször megvizsgálja, hogy az adott játékos heat attribútumának értéke a maximális érték alatt van-e.
     *      * Amennyiben igen, akkor megnöveli eggyel az értékét, majd OK visszatérési értéket ad.
     *      * Ellenkezõ esetben kimarad a növelés, és NOTHING értékkel tér vissza.
     */
    public Result increaseHeat() {
        if(heat < heatlimit) {
            heat++;
            return OK;
        }
        return NOTHING;
    }

    @Override
    /**
     * A Player osztályban lévõ absztrakt függvény megvalósítása. Meghívja az actualfield attribútumban eltárolt
     * Field-re a buildIgloo() függvényt, majd ennek visszatérési értékével (OK/ NOTHING) tér vissza
     * ez a metódus is.
     */
    public Result specialSkill(String c) {
        Igloo igloo = new Igloo();
        return actualfield.build(igloo);
    }

    /**
     * Az Eskimo adatainak kiírásáért felelõs függvény.
     * Megjeleníti az eszkimó nevét, testhõmérsékletét, maradék munkáját,
     * a nála lévõ eszközöket és annak a mezõnek a nevét amelyiken áll.
     */
    @Override
    public void state(){
        System.out.println("Eskimo:");
        System.out.println("color: " + this.color);
        System.out.println("heat: " + this.heat);
        System.out.println("work: " + this.work);
        System.out.println("tools: ");
        for(Tool t: getTools()) {
            t.namestate();
            System.out.print(", ");
        }
        System.out.print("\n");
        System.out.print("Actualfield: " );
        actualfield.namestate();
        System.out.print("\n");
    }

}