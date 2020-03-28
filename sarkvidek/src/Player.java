
import java.util.*;

/**
 * 
 */
public abstract class Player {

    /**
     * Default constructor
     */
    public Player() {
    }

    /**
     * 
     */
    private int heat;

    /**
     * 
     */
    private int work;






    /**
     * 
     */
    private Game game;

    /**
     * 
     */
    private Field actualfireld;



    /**
     * 
     */
    private Field actualfield;

    /**
     * 
     */
    private Tool tools;

    /**
     * @return
     */
    public Result round() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Result clean() {
        // TODO implement here
        return null;
    }

    /**
     * 
     */
    public void haveHeat() {
        // TODO implement here
    }

    /**
     * @return
     */
    public Result assemble() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public abstract Result specialSkill();

    /**
     * @param f 
     * @return
     */
    public Result changeField(Field f) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Result helpMe() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Result decreaseHeat() {
        // TODO implement here
        return null;
    }

    /**
     * @param t
     */
    public void addTool(Tool t) {
        // TODO implement here
    }

    /**
     * @param d 
     * @return
     */
    public Result move(Direction d) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Result increaseHeat() {
        // TODO implement here
        return null;
    }

    /**
     * @param f
     */
    public void addPart(FlareGun f) {
        // TODO implement here
    }

    /**
     * @return
     */
    public List<Tool> getTools() {
        // TODO implement here
        return null;
    }

}