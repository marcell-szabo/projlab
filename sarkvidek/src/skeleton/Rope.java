package skeleton;

import java.util.*;

/**
 * A kötél felvételére, illetve a köteles kimentés kezelésére szolgáló osztály.
 */
public class Rope implements Tool {

    /**
     * Default constructor
     */
    public Rope() {
    }

    /**
     * Mindig TRUE értékkel tér vissza (hiszen csak akkor hívódik meg, ha egy Rope példány
     * szeretné magát összehasonlítani vele).
     *
     * @param r az összehasonlításhoz szükséges Rope példány
     * @return true
     */
    public boolean isSame(Rope r) {
        return true;
    }

    @Override
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

    @Override
    public boolean isSame(Tool t) {
        return false;
    }

    @Override
    /**
     * NOTHING értékkel tér vissza .
     * @param f  A mezõ, amin az ásást kell végrehajtani
     * @return Result a lapátolásról
     */
    public Result clean(Field f) {
        return Result.NOTHING;
    }

    @Override
    public Result swim(Field f, Player p) {
        return Result.NOTHING;
    }

    /**
     * Meghívja a paraméterként megkapott Player példány changeField(Field) metódusát, átadva neki a
     * paraméterként a kapott Field példányt.
     * A changeField függvény visszatérési értéke lesz a help függvény visszatérése is.
     *
     * @param f Az a field amire a player lépni akar
     * @param p Az a játékos amelyik a másik fieldre lépne
     * @return Result a segítségrõl
     */
    public Result help(Field f, Player p) {
        return p.changeField(f);
    }

    @Override
    public Result build(Field f) {
        return Result.NOTHING;
    }

}