package skeleton;

import java.util.*;

/**
 * 
 */
public abstract class Gun extends Item {

    /**
     * Default constructor
     */
    public Gun() {
    }

    /**
     * @param p 
     * @return
     */
    public abstract Result pickMeUp(Player p);

}