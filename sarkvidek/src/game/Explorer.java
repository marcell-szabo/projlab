package game;


import graphics.Draw;
import graphics.Drawable;

import static game.Result.*;


/**
 * Sarkkutató karaktertípus esetén megadja a maximális testhõ mértékét,
 * illetve kezeli a sarkkutató különleges képességét, tehát egy szomszédos mezõ teherbírásának vizsgálatát.
 */
public class Explorer extends Player implements Drawable {
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
    public Result specialSkill() {
        char c = game.controller.EventHandler();
        int i = 0;
        switch (c){
            case 'w':
                i = 0;
                break;
            case 'd':
                i = 1;
                break;
            case 's':
                i = 2;
                break;
            case 'a':
                i = 3;
                break;
            default:
                break;
        }
        if(actualfield.checkNeighbour(i) == null)
            return NOTHING;
        int capacity = actualfield.checkNeighbour(i).getCapacity();
        System.out.println("field: " + actualfield.checkNeighbour(i).name);
        System.out.println("capacity:: " + capacity);
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
        System.out.print("actualfield: " );
        actualfield.namestate();
        System.out.println("\n");
    }


    @Override
    public void draw(Draw draw, int x, int y) {
        switch(this.getColor()){
            case 'b':
                draw.exbDraw(x,y);
                break;
            case 'g':
                draw.exgDraw(x,y);
                break;
            case 'o':
                draw.exoDraw(x,y);
                break;
            case 'p':
                draw.expDraw(x,y);
                break;
            case 'r':
                draw.exrDraw(x,y);
                break;
            case 'y':
                draw.exyDraw(x,y);
                break;
            default:
                break;
        }
    }
}


