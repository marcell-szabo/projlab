package game;
//**push**
import graphics.Draw;
import graphics.Drawable;

import static game.Result.DIE;
import static game.Result.OK;

/**
 * Lyukak kezelésére szolgáló osztály. A vele kapcsolatos kimentési kísérletet is ez az osztály kezdi meg.
 */
public class Hole extends Field implements Drawable {

    public Hole(int snow, int capacity, String name) {
        super(snow, capacity, name);
    }

    /**
     * A Field osztályban lévõ absztrakt függvény megvalósítása. Az adott mezõ snow attribútumának értékét megnöveli eggyel.
     * Mindig OK-kal tér vissza.
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
     * A Field osztályban lévõ absztrakt függvény megvalósítása.
     * Legelõször megnézi, hogy tartózkodik-e az adott mezõn jegesmedve, mivel ha igen, akkor a függvény
     * DIE-al tér vissza (Az általunk kitalált játékban a jegesmedve állhat lukon is).
     * Ha ezt a vizsgálatot követõen nem keletkezett visszatérési érték, akkor az attribútumként kapott Player példány helpMe()
     * metódusát hívja meg, majd ennek a visszatérési értékével tér vissza a stepOn(Player) függvény is.
     *
     * @param p erre a mezõre lépõ Player
     * @return Result, hogy sikerült-e kimenteni a játékost.
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