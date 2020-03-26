
import java.util.*;

/**
 * 
 */
public abstract class Field {

    /**
     * Default constructor
     */
    public Field() {
    }

    /**
     * 
     */
    private int snow;

    /**
     * 
     */
    private int capacity;




    /**
     * 
     */
    private Player players;



    /**
     * 
     */
    private Player players;


    /**
     * 
     */
    private Field[] neighbours;







    /**
     * 
     */
    private Field neighbours;





    /**
     * @return
     */
    public abstract Result storm();

    /**
     * @param p 
     * @return
     */
    public abstract Result stepOn(Player p);

    /**
     * @param d 
     * @return
     */
    public Field checkNeighbour(Direction d) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public boolean canHelp() {
        // TODO implement here
        return false;
    }

    /**
     * @param allplayer 
     * @return
     */
    public boolean haveAllPlayer(int allplayer) {
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
     * @param p
     */
    public void leaveField(Player p) {
        // TODO implement here
    }

    /**
     * @return
     */
    public Result clean() {
        // TODO implement here
        return null;
    }

    /**
     * @param p 
     * @return
     */
    public Result pickUp(Player p) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public int getCapacity() {
        // TODO implement here
        return 0;
    }

}