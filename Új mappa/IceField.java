
import java.util.*;

/**
 * 
 */
public class IceField extends Field {

    /**
     * Default constructor
     */
    public IceField() {
    }

    /**
     * 
     */
    private boolean igloo;

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
    public boolean haveIgloo() {
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    public Result buildIgloo() {
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