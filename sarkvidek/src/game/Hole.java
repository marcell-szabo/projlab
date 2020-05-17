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

    /**
     * A Drawable interfészbõl implementált függvény. Meghívja a saját magát kirajzoló függvényt a Draw osztályban, és
     * továbbhívja az esetlegesen rajta lévõ objektumok kirajzoló függvényeit.
     * @param draw - Draw osztály példánya amelyben implementálva van a Hole-t kirajzoló függvény.
     * @param x - kirajzolás helyének X koordinátája
     * @param y - kirajzolás helyének Y koordinátája
     */
    @Override
    public void draw(Draw draw, int x, int y) {
        if(this.getSnow() != 0) {
            if(this.getSnow() > 3)
                draw.snowMuchDraw(x, y);
            else if(this.getSnow() <= 3)
                draw.snowDraw(x, y);
            else if(polarbear.actualfield == this)
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

    /**
     * A Field osztályban lévõ absztrakt függvényt valósítja meg. A jegesmedve lyukra lépését végzi.
     * @param pb - jegesmedve referenciája
     * @return OK
     */
    @Override
    public Result stepOn(PolarBear pb)
    {
        polarbear = pb;
        return  OK;
    }
}