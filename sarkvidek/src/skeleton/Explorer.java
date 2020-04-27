package skeleton;

import java.util.*;

import static skeleton.Result.*;


/**
 * Sarkkutató karaktertípus esetén megadja a maximális testhõ mértékét,
 * illetve kezeli a sarkkutató különleges képességét, tehát egy szomszédos mezõ teherbírásának vizsgálatát.
 */
public class Explorer extends Player {
    /**
     * Statikus attribútum. A sarkkutató testhõ szintjének maximális számát adja meg.
     */
    private static int heatlimit = 4;

    /**
     * Default constructor
     */
    public Explorer(Game g, Field actual, char c, int h) {
        super(g, actual, c, h);
    }

    @Override
    /**
     * Legelõször megvizsgálja, hogy az adott játékos heat attribútumának értéke a maximális érték alatt van-e.
     *      * Amennyiben igen, akkor megnöveli eggyel az értékét, majd OK visszatérési értéket ad.
     *      * Ellenkezõ esetben kimarad a növelés, és NOTHING értékkel tér vissza.
     */
    public Result increaseHeat() {
        if (heat < heatlimit) {
            heat++;
            return OK;
        }
        return NOTHING;
    }

    @Override
    /**
     * A Player osztályban lévõ absztrakt függvény megvalósítása.
     * Elõször bekér egy irányt, majd erre meghívja a checkNeighbour(Direction) függvényt.
     * A megkapott irányban lévõ szomszéd mezõre meghívja a getCapacity() függvényt.
     * Minden esetben OK-al té vissza.
     *
     * @return Result - minden esetben OK
     */
    public Result specialSkill(String c) {
        int capacity;
        switch (c) {
            case "W":
                if (actualfield.checkNeighbour(0) != null) {
                    capacity = actualfield.checkNeighbour(0).getCapacity();
                    return OK;
                }
                break;
            case "A":
                if (actualfield.checkNeighbour(1) != null) {
                    capacity = actualfield.checkNeighbour(1).getCapacity();
                    return OK;
                }
                break;
            case "S":
                if (actualfield.checkNeighbour(2) != null) {
                    capacity = actualfield.checkNeighbour(2).getCapacity();
                    return OK;
                }
                break;
            case "D":
                if (actualfield.checkNeighbour(3) != null) {
                    capacity = actualfield.checkNeighbour(3).getCapacity();
                    return OK;
                }
                break;
        }
        return OK;
    }

    /**
     * Az Explorer adatainak kiírásáért felelõs függvény.
     * Megjeleníti a sarkkutató nevét, testhõmérsékletét, maradék munkáját,
     * a nála lévõ eszközöket és annak a mezõnek a nevét amelyiken áll.
     */
    @Override
    public void state() {
        System.out.println("Explorer:");
        System.out.println("color: " + this.color);
        System.out.println("heat: " + this.heat);
        System.out.println("work: " + this.work);
        System.out.print("tools: ");
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


