
import java.util.*;

/**
 * Enumeration osztály, amely a meghívott függvények futása alatt bekövetkező eseményeket reprezentálja. A legtöbb függvény visszatérési értéke ezen enumeráció értékei közül vesz fel egyet. 
 */
public class Result {

    /**
     * Default constructor
     */
    public Result() {
    }

    /**
     * Az előző elemek közül egyik sem.
     */
    public void OK;

    /**
     * A függvény futása során megnyerték a játékosok a játékot (összeszerelték és elsütötték a jelzőpisztolyt).
     */
    public void WIN;

    /**
     * A metódus futása során meghalt (legalább egy) játékos, így a játékosok elvesztették a játékot.
     */
    public void DIE;

    /**
     * A függvény eredeti célja szerinti munka nem végződött el (pl.: volt hó a mezőn nem lehetett tárgyat felvenni).
     */
    public void NOTHING;

}