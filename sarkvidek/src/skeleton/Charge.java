package skeleton;

import java.util.*;

/**
 * 
 */
public abstract class Charge extends Item {

    /**
     * Default constructor
     */
    public Charge() {
    }

    /**
     * @param p 
     * @return
     */
    public abstract Result pickMeUp(Player p);

}