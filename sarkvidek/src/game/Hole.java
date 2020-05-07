package game;
//**push**
import graphics.Draw;
import graphics.Drawable;

import java.util.*;

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

    /**
     * A Hole adatainak kiírásáért felelõs függvény.
     * Megjeleníti a lyukon található hórétegek számát, a lyuk teherbírását (ami mindig 0),
     * a lyukba esett játékosok nevét és hogy található-e jegesmedve a lyukon.
     */
    @Override
    public void state() {
        System.out.println("Hole:");
        System.out.println("snow: " + this.snow);
        System.out.println("capacity: " + this.capacity);
        System.out.print("players: ");
        for (Player p : players) {
            p.namestate();
            System.out.print(", ");
        }
        System.out.print("\n");
        if (polarbear .getActualfield() != this) System.out.println("polarbear: false");
        else System.out.println("polarbear: true");
        System.out.print("\n");
    }
}