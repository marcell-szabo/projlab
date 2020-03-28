
import java.util.*;

/**
 * 
 */
public class Rope extends Item {

    /**
     * Default constructor
     */
    public Rope() {
    }

    /**
     * @param r 
     * @return
     */
    public boolean isSame(Rope r) {
        // TODO implement here
        return false;
    }

    /**
     * @param f 
     * @param p 
     * @return
     */
    public Result help(Field f, Player p) {
        // TODO implement here
        return null;
    }

    /**
     * @param p 
     * @return
     */
    public abstract Result pickMeUp(Player p);

}