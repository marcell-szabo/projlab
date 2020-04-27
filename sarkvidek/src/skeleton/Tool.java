package skeleton;

import java.util.*;

/**
 * Interfész, amely az eszközök felvételének, illetve a velük kapcsolatos interakciók
 * (ásás, köteles kimentés, búvárruha használatával történõ kimenekülés, sátorépítés)
 * kezelésére szolgáló osztály.
 */
public interface Tool extends Item {


    /**
	 * Tool felvételéért felelõs függvény.
     * @param p - A Játékos aki felvesz egy Toolt
     * @return Reasult a felvétel sikerességérõl
     */
    Result pickMeUp(Player p);

    /**
     * Megvizsgálja a megkapott eszközre, hogy az adott játékos rendelkezik-e már vele.
     * @param t az összehasonlításhoz szükséges Tool példány
     * @return Az összehasonlítás eredménye
     */
    boolean isSame(Tool t);

    /**
	 * Mezõ takarításáért felelõs függvény.
     * @param f  A mezõ, amin az ásást kell végrehajtani
     * @return Result a lapátolásról
     */
    Result clean(Field f);

    /**
	 * Lyukból való kiúszásért felelõs függvény.
     * @param f a mezõ (lyuk), amibe beleesett a player
     * @param p melyik játékos esett bele
     * @return Result a kimászásról
     */
    Result swim(Field f, Player p);


    /**
	 * Lyukból való kihúzásért felelõs függvény
     * @param f Az a field amire a player lépni akar
     * @param p Az a játékos amelyik a másik fieldre lépne
     * @return Result a segítségrõl
     */
    Result help(Field f, Player p);


    /**
     * Sátorépítésért felelõs függvény.
     * @param f A mezõ, amire sátrat kell építeni
     * @return Result az építésrõl
     */
    Result build(Field f);

    /**
     *A Tool nevének kiírásáért felelõs függvény
     */
    @Override
    void namestate();
}