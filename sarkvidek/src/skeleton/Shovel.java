package skeleton;

import java.util.*;

/**
 * Az ásó felvételének, illetve az ásóval rendelkezõ játékosok hóréteg ellapátolásának kezelésére szolgáló osztály.
 */
public class Shovel implements Tool {

    /**
     * Default constructor
     */
    public Shovel() {
    }

    /**
     * Mindig TRUE értékkel tér vissza (hiszen csak akkor hívódik meg, ha egy Toolt implementáló példány szeretné magát
     * összehasonlítani vele).
     * @param s az összehasonlításhoz szükséges Shovel példány
     * @return true
     */
    public boolean isSame(Shovel s) {
        return false;
    }

    /**
     * Mindig TRUE értékkel tér vissza (hiszen csak akkor hívódik meg, ha egy BreakableShovel példány szeretné magát
     * összehasonlítani vele).
     *
     * @param bs az összehasonlításhoz szükséges BreakableShovel példány
     * @return true
     */
    public boolean isSame(BreakableShovel bs) {
        return false;
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
    /**
     * megvizsgálja a megkapott eszközre, hogy az adott játékos rendelkezik-e már vele.
     * @param t az összehasonlításhoz szükséges Tool példány
     * @return
     */
    public boolean isSame(Tool t) {
        return true;
    }

    /**
     * Akkor hívódik meg, ha az ásást végzõ játékosnál van ásó. Ekkor ez a függvény meghívja a
     * Field clean() metódusát, ezzel még egy réteget ellapátolva arról (persze, ha ez lehetséges).
     * Void visszatérésû, mivel nincs jelentõsége, hogy ez a mûvelet sikerült-e vagy sem.
     *
     * @param f A mezõ, amin az ásást kell végrehajtani
     * @return Result a lapátolásról
     */
    public Result clean(Field f) {
        f.clean();
        return Result.OK;
    }

    @Override
    public Result swim(Field f, Player p) {
        return Result.NOTHING;
    }

    @Override
    public Result help(Field f, Player p) {
        return Result.NOTHING;
    }

    @Override
    public Result build(Field f) {
        return Result.NOTHING;
    }

}