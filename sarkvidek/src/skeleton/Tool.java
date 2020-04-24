package skeleton;

import java.util.*;

/**
 * Interfész, amely az eszközök felvételének, illetve a velük kapcsolatos interakciók
 * (ásás, köteles kimentés, búvárruha használatával történõ kimenekülés, sátorépítés)
 * kezelésére szolgáló osztály.
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
     * Ezt követõen meghívja a lista minden elemére a Tool osztály isSame(Tool) metódusát.
     * Ezután ezeknek a visszatérési értékei kerülnek vizsgálat alá.
     * Amennyiben minden függvény hívást követõen csak FALSE visszatérési értékeket kapunk,
     * akkor meghívásra kerül a Player osztály addTool(Tool) metódusa, majd ezt követõen OK-kal tér vissza.
     * Különben pedig NOTHING lesz a visszatérési érték.
     * @param p - A Játékos aki felvesz egy Toolt
     * @return Reasult a felvétel sikerességérõl
     */
    public Result pickMeUp(Player p) {
        List<Tool> tools = p.getTools();
        boolean can = true;
        for (int i = 0; i<tools.size(); i++){
            if (tools.get(i).isSame(this) == true) can = false;
        }
        if(can == true) p.addTool(this);
        return can? Result.OK : Result.NOTHING;
    }

    /**
     * Virtuális függvény, amely megvizsgálja a megkapott eszközre, hogy az adott játékos rendelkezik-e már vele.
     * @param t az összehasonlításhoz szükséges Tool példány
     * @return
     */
    public boolean isSame(Tool t) {
        return false;
    }

    /**
	* Virtuális függvény, amely NOTHING értékkel tér vissza.
     * @param f  A mezõ, amin az ásást kell végrehajtani
     * @return Result a lapátolásról
     */
    public Result clean(Field f){
        return Result.NOTHING;
    }

    /**
	* Virtuális függvény, ami NOTHING értékkel tér vissza.
     * @param f a mezõ (lyuk), amibe beleesett a player
     * @param p melyik játékos esett bele
     * @return Result a kimászásról
     */
    public Result swim(Field f, Player p){
        return Result.NOTHING;
    }

    /**
	* Virtuális függvény, ami NOTHING értékkel tér vissza.
     * @param f Az a field amire a player lépni akar
     * @param p Az a játékos amelyik a másik fieldre lépne
     * @return Result a segítségrõl
     */
    public Result help(Field f, Player p){
        return Result.NOTHING;
    }

    /**
     * Virtuális függvény, ami NOTHING értékkel tér vissza.
     * @param f A mezõ, amire sátrat kell építeni
     * @return Result az építésrõl
     */
    public Result build(Field f){
        return Result.NOTHING;
    }

}