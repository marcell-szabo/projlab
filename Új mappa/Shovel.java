
import java.util.*;

/**
 * 
 */
public class Shovel extends Item {

    /**
     * Default constructor
     */
    public Shovel() {
    }

    /**
     * @param s 
     * @return
     */
    public boolean isSame(Shovel s) {
        // TODO implement here
        return false;
    }

    /**
     * @param f
     */
    public void clean(Field f) {
        // TODO implement here
    }

    /**
     * @param p 
     * @return
     */
    public abstract Result pickMeUp(Player p);

}