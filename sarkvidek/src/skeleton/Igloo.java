package skeleton;

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
     * Virtu�lis �res f�ggv�ny, ami csak visszat�r OK-kal.
     *
     * @return OK
     */
    public Result aging(){
        return Result.OK;
    }

    /**
     * TRUE �rt�kkel t�r vissza, mert megv�di a mez�n tart�zkod� embereket a jegesmedv�t�l.
     *
     * @return true
     */
    public boolean protectFromBear(){
        return true;
    }
}
