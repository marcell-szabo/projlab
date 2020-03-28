
import java.util.*;

/**
 * 
 */
public abstract class Hole extends Field {

    /**
     * Default constructor
     */
    public Hole() {
    }

    /**
     * @return
     */
    public Result storm() {
        // TODO implement here
        return null;
    }

    /**
     * @param p 
     * @return
     */
    public Result stepOn(Player p) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public abstract Result storm();

    /**
     * @param p 
     * @return
     */
    public abstract Result stepOn(Player p);

}