package skeleton;

import java.util.*;

/**
 * A jelz�pisztoly alkot�elemeinek felv�tel�vel foglalkoz� oszt�ly.
 */
public class FlareGun extends Item {

    /**
     * Default constructor
     */
    public FlareGun() {
    }


    /**
     * Attrib�tumk�nt �tadva �nmaga referenci�j�t megh�vja a Player oszt�ly addPart(FlareGun) f�ggv�ny�t.
     *
     * @param p Player
     * @return Result
     */
    public Result pickMeUp(Player p) {
        System.out.println(this.toString() + ".pickMeUp(p);");
        p.addPart(this);
        System.out.println(this.toString() + ".pickMeUp(p) returned Result res;");
        return null;
    }

}