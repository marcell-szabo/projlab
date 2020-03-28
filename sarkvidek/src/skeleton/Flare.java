package skeleton;

import java.util.*;

/**
 * 
 */
public abstract class Flare extends Item {

    /**
     * Default constructor
     */
    public Flare() {
    }

    /**
     * @param p 
     * @return
     */
    public abstract Result pickMeUp(Player p);

}