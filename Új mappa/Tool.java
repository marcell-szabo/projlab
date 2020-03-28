
import java.util.*;

/**
 * Az eszközök felvételének, illetve a velük kapcsolatos interakciók (ásás, köteles kimentés, búvárruha használatával történő kimenekülés) kezelésére szolgáló osztály.
 */
public abstract class Tool extends Item {

    /**
     * Default constructor
     */
    public Tool() {
    }


    /**
	* Legelőször a Player osztály getTools() függvénye kerül meghívásra, mely a játékosnál lévő eszközöket tartalmazó listával tér vissza. Ezt követően meghívja a lista minden elemére a Tool osztály isSame(Item) metódusát. Ezután ezeknek a visszatérési értékei kerülnek vizsgálat alá. Amennyiben minden függvény hívást követően csak FALSE visszatérési értékeket kapunk, akkor meghívásra kerül a Player osztály addItem(Item) metódusa, majd ezt követően OK-kal tér vissza. Különben pedig NOTHING lesz a visszatérési érték. 
     * @param p 
     * @return
     */
    public Result pickMeUp(Player p) {
        // TODO implement here
        return null;
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
    virtual public void clean(Field f) {
        // TODO implement here
    }

    /**
	* Virtuális függvény, ami NOTHING értékkel tér vissza.
     * @param f 
     * @param p 
     * @return
     */
    virtual public Result swim(Field f, Player p) {
        // TODO implement here
        return null;
    }

    /**
	* Virtuális függvény, ami NOTHING értékkel tér vissza.
     * @param f 
     * @param p 
     * @return
     */
    virtual public Result help(Field f, Player p) {
        // TODO implement here
        return null;
    }

  

}