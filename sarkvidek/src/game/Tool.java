package game;


import graphics.Draw;
import graphics.Drawable;

/**
 * Interfész, amely az eszközök felvételének, illetve a velük kapcsolatos interakciók
 * (ásás, köteles kimentés, búvárruha használatával történõ kimenekülés, sátorépítés)
 * kezelésére szolgáló osztály.
 */
public interface Tool<abstarct> extends Item, Drawable {


    /**
	 * Tool felvételéért felelõs függvény.
     * @param p - A Játékos aki felvesz egy Toolt
     * @return Reasult a felvétel sikerességérõl
     */
    Result pickMeUp(Player p);

    /**
     * Megvizsgálja a megkapott eszközre, hogy az adott játékos rendelkezik-e már vele.
     * @param d az összehasonlításhoz szükséges DivingSuit példány
     * @return Az összehasonlítás eredménye
     */
    boolean isSame(DivingSuit d);

    /**
     * Megvizsgálja a megkapott eszközre, hogy az adott játékos rendelkezik-e már vele.
     * @param s az összehasonlításhoz szükséges Shovel példány
     * @return Az összehasonlítás eredménye
     */
    boolean isSame(Shovel s);

    /**
     * Megvizsgálja a megkapott eszközre, hogy az adott játékos rendelkezik-e már vele.
     * @param bs az összehasonlításhoz szükséges BreakableShovel példány
     * @return Az összehasonlítás eredménye
     */
    boolean isSame(BreakableShovel bs);

    /**
     * Megvizsgálja a megkapott eszközre, hogy az adott játékos rendelkezik-e már vele.
     * @param t az összehasonlításhoz szükséges Tent példány
     * @return Az összehasonlítás eredménye
     */
    boolean isSame(Tent t);

    /**
     * Megvizsgálja a megkapott eszközre, hogy az adott játékos rendelkezik-e már vele.
     * @param r az összehasonlításhoz szükséges Rope példány
     * @return Az összehasonlítás eredménye
     */
    boolean isSame(Rope r);

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


}