package skeleton;
//**push**
import java.util.*;

import static skeleton.Result.DIE;
import static skeleton.Result.OK;

/**
 * Lyukak kezelésére szolgáló osztály. A vele kapcsolatos kimentési kísérletet is ez az osztály kezdi meg.
 */
public class Hole extends Field {

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
        if (this == polarbear.actualfield)
            return DIE;
        else
            return p.helpMe();
    }

    @Override
    public Result stepOn(Polarbear pb)
    {
        polarbear = pb;
        return  OK;
    }

}