package game;

import graphics.Draw;
import graphics.Drawable;


/**
 * Étel felvételének kezelésére szolgáló osztály.
 */
public class Food implements Item {

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
     * A Drawable interfészbõl implementált függvény. Meghívja a saját magát kirajzoló függvényt a Draw osztályban.
     * @param draw - Draw osztály példánya amelyben implementálva van az ételt kirajzoló függvény.
     * @param x - kirajzolás helyének X koordinátája
     * @param y - kirajzolás helyének Y koordinátája
     */
    @Override
    public void draw(Draw draw, int x, int y) {
        draw.foodDraw(x, y);
    }
}