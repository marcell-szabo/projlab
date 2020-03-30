package skeleton;

import java.util.*;

/**
 * Az eszközök felvételének, illetve a velük kapcsolatos interakciók
 * (ásás, köteles kimentés, búvárruha használatával történõ kimenekülés) kezelésére szolgáló absztrakt osztály.
 */
public abstract class Tool extends Item {

    /**
     * Default constructor
     */
    public Tool() {
    }

    /**
	 * Legelõször a Player osztály getTools() függvénye kerül meghívásra,
     * mely a játékosnál lévõ eszközöket tartalmazó listával tér vissza.
     * Ezt követõen meghívja a lista minden elemére a Tool osztály isSame(Item) metódusát.
     * Ezután ezeknek a visszatérési értékei kerülnek vizsgálat alá.
     * Amennyiben minden függvény hívást követõen csak FALSE visszatérési értékeket kapunk,
     * akkor meghívásra kerül a Player osztály addItem(Item) metódusa, majd ezt követõen OK-kal tér vissza.
     * Különben pedig NOTHING lesz a visszatérési érték.
     * @param p - A Játékos aki felvesz egy Toolt
     * @return
     */
    public Result pickMeUp(Player p) {
        // TODO implement here
        return Result.NOTHING;
    }

    /**
	* Megvizsgálja a megkapott eszközre, hogy az adott játékos rendelkezik-e már vele.
     * @param t 
     * @return
     */
    public boolean isSame(Tool t) {
        // TODO implement here
        return false;
    }

    /**
	* Virtuális, üres függvény.
     * @param f
     */
    public void clean(Field f){}

    /**
	* Virtuális függvény, ami NOTHING értékkel tér vissza.
     * @param f 
     * @param p 
     * @return
     */
    public Result swim(Field f, Player p){
        return Result.NOTHING;
    }

    /**
	* Virtuális függvény, ami NOTHING értékkel tér vissza.
     * @param f 
     * @param p 
     * @return
     */
    public Result help(Field f, Player p){
        return Result.NOTHING;
    }


}