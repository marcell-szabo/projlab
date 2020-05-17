package game;
import graphics.Draw;
import graphics.Drawable;

import static game.Result.*;

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
    public Eskimo(Game g, Field actual, char c, int h) {
        super(g, actual, c, h);
    }

    @Override
    /**
     * Legel�sz�r megvizsg�lja, hogy az adott j�t�kos heat attrib�tum�nak �rt�ke a maxim�lis �rt�k alatt van-e.
     *      * Amennyiben igen, akkor megn�veli eggyel az �rt�k�t, majd OK visszat�r�si �rt�ket ad.
     *      * Ellenkez� esetben kimarad a n�vel�s, �s NOTHING �rt�kkel t�r vissza.
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
     * A Player oszt�lyban l�v� absztrakt f�ggv�ny megval�s�t�sa. Megh�vja az actualfield attrib�tumban elt�rolt
     * Field-re a buildIgloo() f�ggv�nyt, majd ennek visszat�r�si �rt�k�vel (OK/ NOTHING) t�r vissza
     * ez a met�dus is.
     */
    public Result specialSkill() {
        Igloo igloo = new Igloo();
        return actualfield.build(igloo);
    }

    @Override
    public void draw(Draw draw, int x, int y) {
        switch(this.getColor()){
            case 'b':
                draw.esbDraw(x,y);
                break;
            case 'g':
                draw.esgDraw(x,y);
                break;
            case 'o':
                draw.esoDraw(x,y);
                break;
            case 'p':
                draw.espDraw(x,y);
                break;
            case 'r':
                draw.esrDraw(x,y);
                break;
            case 'y':
                draw.esyDraw(x,y);
                break;
            default:
                break;
        }
    }
}