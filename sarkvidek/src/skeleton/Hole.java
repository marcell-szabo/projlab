package skeleton;

import java.util.*;

/**
 * Lyukak kezelésére szolgáló osztály. A vele kapcsolatos kimentési kísérletet is ez az osztály kezdi meg.
 */
public class Hole extends Field {

    /**
     * Default constructor
     */
    public Hole() {
    }

    /**
	*A Field osztályban lévő absztrakt függvény megvalósítása. Az adott mező snow attribútumának értékét megnöveli eggyel. Mindig OK-kal tér vissza.
     * @return OK
     */
    public Result storm() {
        System.out.print(this.toString() + ".storm();\n");
        System.out.print(this.toString() + ".storm() returned Result r;\n");
        return null;
    }

    /**
	* A Field osztályban lévő absztrakt függvény megvalósítása.
     * Az attribútumként kapott Player példány helpMe() metódusát hívja meg,
     * majd ennek a visszatérési értékével tér vissza a stepOn(Player) függvény is.
     * @param p erre a mezőre lépő Player
     * @return Result
     */
    public Result stepOn(Player p) {
        System.out.print(this.toString() + ".stepOn(Player p);\n");
        System.out.print(this.toString() + ".stepOn(Player p) returned Result r;\n");
        return p.helpMe();
    }

}