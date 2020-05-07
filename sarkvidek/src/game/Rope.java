package game;

import graphics.Draw;
import graphics.Drawable;

import java.util.*;

/**
 * A kötél felvételére, illetve a köteles kimentés kezelésére szolgáló osztály.
 */
public class Rope implements Tool, Drawable {

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
    @Override
    public Result pickMeUp(Player p) {
        List<Tool> tools = p.getTools();
        boolean can = true;
        for (int i = 0; i<tools.size(); i++){
            if (tools.get(i).isSame(this)) can = false;
        }
        if(can) p.addTool(this);
        return can? Result.OK : Result.NOTHING;
    }

    /**
     * Mindig FALSE értékkel tér vissza (hiszen csak akkor hívódik meg, ha egy másmilyen példány szeretné magát
     * összehasonlítani vele).
     *
     * @param d az összehasonlításhoz szükséges DivingSuit példány
     * @return false
     */
    @Override
    public boolean isSame(DivingSuit d) {
        return false;
    }

    /**
     * Mindig FALSE értékkel tér vissza (hiszen csak akkor hívódik meg, ha egy másmilyen példány szeretné magát
     * összehasonlítani vele).
     *
     * @param s az összehasonlításhoz szükséges Shovel példány
     * @return false
     */
    @Override
    public boolean isSame(Shovel s) {
        return false;
    }

    /**
     * Mindig FALSE értékkel tér vissza (hiszen csak akkor hívódik meg, ha egy másmilyen példány szeretné magát
     * összehasonlítani vele).
     *
     * @param bs az összehasonlításhoz szükséges BreakableShovel példány
     * @return false
     */
    @Override
    public boolean isSame(BreakableShovel bs) {
        return false;
    }

    /**
     * Mindig FALSE értékkel tér vissza (hiszen csak akkor hívódik meg, ha egy másmilyen példány szeretné magát
     * összehasonlítani vele).
     *
     * @param t az összehasonlításhoz szükséges Tent példány
     * @return false
     */
    @Override
    public boolean isSame(Tent t) {
        return false;
    }

    /**
     * NOTHING értékkel tér vissza .
     * @param f  A mezõ, amin az ásást kell végrehajtani
     * @return Result a lapátolásról
     */
    @Override
    public Result clean(Field f) {
        return Result.NOTHING;
    }

    /**
     * NOTHING értékkel tér vissza.
     * @param f a mezõ (lyuk), amibe beleesett a player
     * @param p melyik játékos esett bele
     * @return Result a kimászásról
     */
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
    @Override
    public Result help(Field f, Player p) {
        p.decreaseHeat();
        return p.changeField(f);
    }

    /**
     * NOTHING értékkel tér vissza.
     * @param f A mezõ, amire sátrat kell építeni
     * @return Result az építésrõl
     */
    @Override
    public Result build(Field f) {
        return Result.NOTHING;
    }

    /**
     *A Rope nevének kiírásáért felelõs függvény
     */
    @Override
    public void namestate(){
        System.out.print("rope");
    }

    @Override
    public void draw(Draw draw, int x, int y) {
        draw.ropeDraw(x, y);
    }
}