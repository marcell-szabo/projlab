
import java.util.*;

/**
 * 
 */
public class DivingSuit extends Item {

    /**
     * Default constructor
     */
    public DivingSuit() {
    }

    /**
     * @param d 
     * @return
     */
    public boolean isSame(DivingSuit d) {
        // TODO implement here
        return false;
    }

    /**
     * @param f 
     * @param p 
     * @return
     */
    public Result swim(Field f, Player p) {
        // TODO implement here
        return null;
    }

    /**
     * @param p 
     * @return
     */
    public abstract Result pickMeUp(Player p);

}