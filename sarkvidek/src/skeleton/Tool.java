package skeleton;

import java.util.*;

/**
 * Interfész, amely az eszközök felvételének, illetve a velük kapcsolatos interakciók
 * (ásás, köteles kimentés, búvárruha használatával történõ kimenekülés, sátorépítés)
 * kezelésére szolgáló osztály.
 */
public interface Tool extends Item {


    /**
	 * Legelõször a Player osztály getTools() függvénye kerül meghívásra,
     * mely a játékosnál lévõ eszközöket tartalmazó listával tér vissza.
     * Ezt követõen meghívja a lista minden elemére a Tool osztály isSame(Tool) metódusát.
     * Ezután ezeknek a visszatérési értékei kerülnek vizsgálat alá.
     * Amennyiben minden függvény hívást követõen csak FALSE visszatérési értékeket kapunk,
     * akkor meghívásra kerül a Player osztály addTool(Tool) metódusa, majd ezt követõen OK-kal tér vissza.
     * Különben pedig NOTHING lesz a visszatérési érték.
     * @param p - A Játékos aki felvesz egy Toolt
     * @return Reasult a felvétel sikerességérõl
     */
    Result pickMeUp(Player p);

    /**
     * megvizsgálja a megkapott eszközre, hogy az adott játékos rendelkezik-e már vele.
     * @param t az összehasonlításhoz szükséges Tool példány
     * @return
     */
    boolean isSame(Tool t);

    /**
	 * NOTHING értékkel tér vissza, kivéve ha a shovel vagy leszármazottjának a függvénye hívódik meg
     * @param f  A mezõ, amin az ásást kell végrehajtani
     * @return Result a lapátolásról
     */
    Result clean(Field f);

    /**
	* Virtuális függvény, ami NOTHING értékkel tér vissza.
     * @param f a mezõ (lyuk), amibe beleesett a player
     * @param p melyik játékos esett bele
     * @return Result a kimászásról
     */
    Result swim(Field f, Player p);


    /**
	* Virtuális függvény, ami NOTHING értékkel tér vissza.
     * @param f Az a field amire a player lépni akar
     * @param p Az a játékos amelyik a másik fieldre lépne
     * @return Result a segítségrõl
     */
    Result help(Field f, Player p);


    /**
     * Virtuális függvény, ami NOTHING értékkel tér vissza.
     * @param f A mezõ, amire sátrat kell építeni
     * @return Result az építésrõl
     */
    Result build(Field f);


}