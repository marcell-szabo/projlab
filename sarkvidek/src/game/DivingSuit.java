package game;

import graphics.Draw;
import graphics.Drawable;

import java.util.*;
import static game.Result.DIE;


/**
 * A búvárruha felvételének, illetve használatának kezelésére szolgáló osztály.
 */
public class DivingSuit implements Tool, Drawable {

    /**
     * Default constructor
     */
    public DivingSuit() {
    }

    /**
     * Mindig TRUE értékkel tér vissza (hiszen csak akkor hívódik meg, ha egy DivingSuit
     * példány szeretné magát összehasonlítani vele).
     *
     * @param d az összehasonlításhoz szükséges DivingSuit példány
     * @return true
     */
    public boolean isSame(DivingSuit d) {
        return true;
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
     * Mindig FALSE értékkel tér vissza (hiszen csak akkor hívódik meg, ha egy másmilyen példány szeretné magát
     * összehasonlítani vele).
     *
     * @param r az összehasonlításhoz szükséges Rope példány
     * @return false
     */
    @Override
    public boolean isSame(Rope r) {
        return false;
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
     * NOTHING értékkel tér vissza .
     * @param f  A mezõ, amin az ásást kell végrehajtani
     * @return Result a lapátolásról
     */
    @Override
    public Result clean(Field f) {
        return Result.NOTHING;
    }

    /**
     * A Tool osztály swim(Field, Player) függvényének felüldefiniálása.
     * A játékos által megadott irányt átadva meghívja az actualfield checkNeighbour(int) metódusát,
     * ami visszatér az ott található mezõ referenciájával.
     * Ha ez NULL érték lenne (tehát arra tenger található), akkor újra meg kell adni egy irányt.
     * Ha megkaptuk a választott szomszédos mezõ referenciáját, akkor ezt átadva meghívódik
     * a paraméterben megkapott játékos changeField(Field) függvénye.
     * Ennek a metódusnak a visszatérési értékével tér vissza a swim(Field, Player) függvény is.
     *
     * @param f a mezõ (lyuk), amibe beleesett a player
     * @param p melyik játékos esett bele
     * @return Result a kimászásról
     */
    @Override
    public Result swim(Field f, Player p) {
        Field field = null;
        while(field == null)
            field = f.checkNeighbour(new Random().nextInt(3));
        return p.changeField(field);
    }


    /**
     * NOTHING értékkel tér vissza.
     * @param f Az a field amire a player lépni akar
     * @param p Az a játékos amelyik a másik fieldre lépne
     * @return Result a segítségrõl
     */
    @Override
    public Result help(Field f, Player p) {
        return Result.NOTHING;
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


    @Override
    public void draw(Draw draw, int x, int y) {
        draw.divingSuitDraw(x, y);
    }
}