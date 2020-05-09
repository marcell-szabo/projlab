package game;


import graphics.Draw;
import graphics.Drawable;

import static game.Result.*;


/**
 * Sarkkutat� karaktert�pus eset�n megadja a maxim�lis testh� m�rt�k�t,
 * illetve kezeli a sarkkutat� k�l�nleges k�pess�g�t, teh�t egy szomsz�dos mez� teherb�r�s�nak vizsg�lat�t.
 */
public class Explorer extends Player implements Drawable {
    /**
     * Statikus attrib�tum. A sarkkutat� testh� szintj�nek maxim�lis sz�m�t adja meg.
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
     * Legel�sz�r megvizsg�lja, hogy az adott j�t�kos heat attrib�tum�nak �rt�ke a maxim�lis �rt�k alatt van-e.
     *      * Amennyiben igen, akkor megn�veli eggyel az �rt�k�t, majd OK visszat�r�si �rt�ket ad.
     *      * Ellenkez� esetben kimarad a n�vel�s, �s NOTHING �rt�kkel t�r vissza.
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
     * A Player oszt�lyban l�v� absztrakt f�ggv�ny megval�s�t�sa.
     * El�sz�r bek�r egy ir�nyt, majd erre megh�vja a checkNeighbour(Direction) f�ggv�nyt.
     * A megkapott ir�nyban l�v� szomsz�d mez�re megh�vja a getCapacity() f�ggv�nyt.
     * Minden esetben OK-al t� vissza.
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
        //int capacity = actualfield.checkNeighbour(i).getCapacity();
        //game.examinedField = actualfield.checkNeighbour(i).name;
        //game.examinedCapacity = Integer.toString(capacity);
        return OK;
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


