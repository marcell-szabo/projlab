package skeleton;

import java.util.*;

/**
 * A jelzõpisztoly alkotóelemeinek felvételével foglalkozó osztály.
 */
public class FlareGun extends Item {

    /**
     * Default constructor
     */
    public FlareGun() {
    }


    /**
     * Attribútumként átadva önmaga referenciáját meghívja a Player osztály addPart(FlareGun) függvényét.
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