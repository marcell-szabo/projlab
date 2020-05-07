package game;

/**
 * Igloo �s s�tor megk�l�nb�ztet�s�re szolg�l� oszt�ly.
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
     * TRUE értékkel tér vissza, mert megvédi a mezőn tartozkodó embereket a jegesmedvétől.
     *
     * @return true
     */
    public boolean protectFromBear(){
        return true;
    }
}
