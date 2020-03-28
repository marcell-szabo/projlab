
import java.util.*;

/**
 * 
 */
public abstract class Tool extends Item {

    /**
     * Default constructor
     */
    public Tool() {
    }


    /**
     * @param p 
     * @return
     */
    public Result pickMeUp(Player p) {
        // TODO implement here
        return null;
    }

    /**
     * @param t 
     * @return
     */
    public boolean isSame(Tool t) {
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
     * @param f 
     * @param p 
     * @return
     */
    public Result swim(Field f, Player p) {
        // TODO implement here
        return null;
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