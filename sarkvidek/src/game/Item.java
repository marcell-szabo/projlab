package game;

import graphics.Drawable;

import java.util.*;

/**
 * Interf�sz, amely a t�rgyak egys�ges kezel�s�t biztos�tja, ez szolg�l a t�rgyak felv�tel�nek kezel�s�re.
 */
public interface Item extends Drawable {
    /**
     * Absztrakt f�ggv�ny. A FlareGun, a Food vagy a Tool oszt�ly pickMeUp(Player) f�ggv�nye ker�l megh�v�sra.
     *
     * @param p T�rgyat felvenni k�v�n� szem�ly
     */
    Result pickMeUp(Player p);

    /**
     *Az Item nev�nek ki�r�s��rt felel�s f�ggv�ny
     */
    void namestate();
}