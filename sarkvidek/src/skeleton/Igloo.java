package skeleton;

/**
 * Igloo és sátor megkülönböztetésére szolgáló osztály.
 */
public class Igloo {

    /**
     * Default constructor
     */
    public Igloo(){
    }

    /**
     * Virtuális üres függvény, ami csak visszatér OK-kal.
     *
     * @return OK
     */
    public Result aging(){
        return Result.OK;
    }

    /**
     * TRUE értékkel tér vissza, mert megvédi a mezõn tartózkodó embereket a jegesmedvétõl.
     *
     * @return true
     */
    public boolean protectFromBear(){
        return true;
    }
}
