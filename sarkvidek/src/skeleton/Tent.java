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


}
