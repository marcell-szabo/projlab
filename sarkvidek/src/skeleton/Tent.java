package skeleton;

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
     * Mindig TRUE értékkel tér vissza (hiszen csak akkor hívódik meg,
     * ha egy Tent példány szeretné magát összehasonlítani vele).
     *
     * @return true
     */
    public boolean isSame(Tent t){
        return true;
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
        Result r = f.buildIgloo(this);
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
     * FALSE értékkel tér vissza, mert nem védi meg
     * a mezõn tartózkodó embereket a jegesmedvétõl.
     *
     * @return true or false
     */
    public boolean protectFromBear(){
        return false;
    }
}
