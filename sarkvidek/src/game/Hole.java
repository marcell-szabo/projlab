package game;
//**push**
import graphics.Draw;
import graphics.Drawable;

import static game.Result.DIE;
import static game.Result.OK;

/**
 * Lyukak kezel�s�re szolg�l� oszt�ly. A vele kapcsolatos kiment�si k�s�rletet is ez az oszt�ly kezdi meg.
 */
public class Hole extends Field implements Drawable {

    public Hole(int snow, int capacity, String name) {
        super(snow, capacity, name);
    }

    /**
     * A Field oszt�lyban l�v� absztrakt f�ggv�ny megval�s�t�sa. Az adott mez� snow attrib�tum�nak �rt�k�t megn�veli eggyel.
     * Mindig OK-kal t�r vissza.
     *
     * @return OK
     */
    public Result storm() {
        snow++;
        return OK;
    }

    public Igloo getProtection(){
        return null;
    }

    public Item getItem(){return null;}

    @Override
    public void draw(Draw draw, int x, int y) {
        if(this.getSnow() != 0) {
            if(this.getSnow() > 3)
                draw.snowMuchDraw(x, y);
            else
                draw.snowDraw(x, y);
            if(polarbear.actualfield == this)
                polarbear.draw(draw, x, y);
        }else if(polarbear.actualfield == this)
            draw.polarbearHoleDraw(x, y);
        else
            draw.holeDraw(x, y);
    }

    /**
     * A Field oszt�lyban l�v� absztrakt f�ggv�ny megval�s�t�sa.
     * Legel�sz�r megn�zi, hogy tart�zkodik-e az adott mez�n jegesmedve, mivel ha igen, akkor a f�ggv�ny
     * DIE-al t�r vissza (Az �ltalunk kital�lt j�t�kban a jegesmedve �llhat lukon is).
     * Ha ezt a vizsg�latot k�vet�en nem keletkezett visszat�r�si �rt�k, akkor az attrib�tumk�nt kapott Player p�ld�ny helpMe()
     * met�dus�t h�vja meg, majd ennek a visszat�r�si �rt�k�vel t�r vissza a stepOn(Player) f�ggv�ny is.
     *
     * @param p erre a mez�re l�p� Player
     * @return Result, hogy siker�lt-e kimenteni a j�t�kost.
     */
    public Result stepOn(Player p)
    {
        if (this == polarbear.getActualfield())
            return DIE;
        else
            return p.helpMe();
    }

    @Override
    public Result stepOn(PolarBear pb)
    {
        polarbear = pb;
        return  OK;
    }
}