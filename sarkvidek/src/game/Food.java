package game;

import graphics.Draw;
import graphics.Drawable;


/**
 * Étel felvételének kezelésére szolgáló osztály.
 */
public class Food implements Item, Drawable {

    /**
     * Default constructor
     */
    public Food() {
    }

    /**
     * A felvett étellel növeli a testhõt
     * Meghívja a Player osztály increaseHeat() függvényét. Amivel az általa hívott metódus tér vissza,
     * az lesz ennek a függvénynek is a visszatérési értéke.
     *
     * @param p Ételt felvenni kívánó játékos
     * @return Result az eredménnyel visszatér
     */
    public Result pickMeUp(Player p) {
        return p.increaseHeat();
    }

    /**
     *A Food nevének kiírásáért felelõs függvény
     */
    @Override
    public void namestate(){
        System.out.print("food");
    }

    @Override
    public void draw(Draw draw, int x, int y) {

    }
}