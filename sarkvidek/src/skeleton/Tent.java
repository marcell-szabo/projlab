package skeleton;

import java.util.List;

/**
 * Sátor eltûnésének, illetve megépítésének kezelésére szolgáló osztály.
 */
public class Tent extends Igloo implements Tool {

    /**
     *  A sátor felállítása óta eltelt idõt reprezentálja.
     *  Megépítéskor megegyezik az értéke a játékosok számával. Ha lecsökken nullára, akkor eltûnik.
     */
    private int timer;

    /**
     * Default constructor
     */
    public Tent(){
    }


    /**
     * FALSE értékkel tér vissza, mert nem védi meg
     * a mezõn tartózkodó embereket a jegesmedvétõl.
     *
     * @return true or false
     */
    public boolean protectFromBear(){
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
     * Mindig TRUE értékkel tér vissza (hiszen csak akkor hívódik meg, ha egy Toolt implementáló példány szeretné magát
     * összehasonlítani vele).
     *
     * @param t az összehasonlításhoz szükséges Tent példány
     * @return true
     */
    public boolean isSame(Tent t) {
        return true;
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
     * Meghívja az attribútumként kapott Field osztály build(Igloo) metódusát,
     * átadva neki önmagát. Ha ez OK-kal tér vissza, akkor a build(Field)
     * DlSAPPEAR-rel, különben pedig NOTHING-gal fog visszatérni.
     *
     * @param f Field amelyre sátort akarunk építeni
     * @return DISAPPEAR or NOTHING
     */
    @Override
    public Result build(Field f){
        Result r = f.build(this);
        if(r == Result.OK)
            return Result.DISAPPEAR;
        return Result.NOTHING;
    }

    /**
     * Eggyel csökkenti a timer attribútumát. Ha így nullára csökken,
     * akkor DISAPPEAR-rel tér vissza, különben pedig OK-kal.
     *
     * @return DISAPPEAR or OK
     */
    public Result aging(){
        timer--;
        if(timer == 0)
            return Result.DISAPPEAR;
        return Result.OK;
    }

    /**
     *A Tent nevének kiírásáért felelõs függvény
     */
    @Override
    public void namestate(){
        System.out.print("tent");
    }
}
