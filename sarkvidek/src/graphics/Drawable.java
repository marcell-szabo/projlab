package graphics;

/**
 * interfész, amely egy kirajzoló fv-vel rendelkezik.
 * Az összes olyan osztály implementálja amely kirajzolható a pályára.
 */
public interface Drawable {
    /**
     * Egy dolog(tárgy, karakter, mezõ) kirajzolását valósítja meg
     * @param draw a draw osztály példánya, mert ez ismeri a graphics g-t, amire rajzol
     * @param x - a rajzolás helyének x koordinátája
     * @param y - a rajzolás helyének y koordinátája
     */
    void draw(Draw draw, int x, int y);
}
