package skeleton;

import java.util.*;

/**
 * �tel felv�tel�nek kezel�s�re szolg�l� oszt�ly.
 */
public class Food extends Item {

    /**
     * Default constructor
     */
    public Food() {
    }

    /**
     * A felvett �tellel n�veli a testh�t
     * Megh�vja a Player oszt�ly increaseHeat() f�ggv�ny�t. Amivel az �ltala h�vott met�dus t�r vissza,
     * az lesz ennek a f�ggv�nynek is a visszat�r�si �rt�ke.
     *
     * @param p az �telt felvev� j�t�kos
     * @return Result az eredm�nnyl visszat�r
     */
    public Result pickMeUp(Player p) {
        System.out.println(this.toString() + ".pickMeUp(p);");
        Result r = p.increaseHeat();
        System.out.println(this.toString() + ".pickMeUp(p) returned Return res;");
        return Result.OK;
    }

}