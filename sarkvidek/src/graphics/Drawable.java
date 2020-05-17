package graphics;

/**
 * interf�sz, amely egy kirajzol� fv-vel rendelkezik.
 * Az �sszes olyan oszt�ly implement�lja amely kirajzolhat� a p�ly�ra.
 */
public interface Drawable {
    /**
     * Egy dolog(t�rgy, karakter, mez�) kirajzol�s�t val�s�tja meg
     * @param draw a draw oszt�ly p�ld�nya, mert ez ismeri a graphics g-t, amire rajzol
     * @param x - a rajzol�s hely�nek x koordin�t�ja
     * @param y - a rajzol�s hely�nek y koordin�t�ja
     */
    void draw(Draw draw, int x, int y);
}
