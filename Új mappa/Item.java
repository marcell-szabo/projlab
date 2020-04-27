
import java.util.*;

/**
 * Interfész, amely a tárgyak egységes kezelését biztosítja, ez szolgál a tárgyak felvételének kezelésére.
 */
public abstract class Item {

    /**
     * Default constructor
     */
    public Item() {
    }


    /**
	* Absztrakt függvény. A FlareGun, a Food vagy a Tool osztály pickMeUp(Player) függvénye kerül meghívásra.
     * @param p 
     * @return
     */
    public abstract Result pickMeUp(Player p);

}