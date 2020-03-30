package skeleton;

import java.util.*;

/**
 * Interf�sz, amely a t�rgyak egys�ges kezel�s�t biztos�tja, ez szolg�l a t�rgyak felv�tel�nek kezel�s�re.
 */
public abstract class Item {

    /**
     * Default constructor
     */
    public Item() {
    }


    /**
     * Absztrakt f�ggv�ny. A FlareGun, a Food vagy a Tool oszt�ly pickMeUp(Player) f�ggv�nye ker�l megh�v�sra.
     *
     * @param p
     * @return
     */
    public abstract Result pickMeUp(Player p);

}