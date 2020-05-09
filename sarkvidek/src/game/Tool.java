package game;


import graphics.Draw;
import graphics.Drawable;

/**
 * Interf�sz, amely az eszk�z�k felv�tel�nek, illetve a vel�k kapcsolatos interakci�k
 * (�s�s, k�teles kiment�s, b�v�rruha haszn�lat�val t�rt�n� kimenek�l�s, s�tor�p�t�s)
 * kezel�s�re szolg�l� oszt�ly.
 */
public interface Tool<abstarct> extends Item, Drawable {


    /**
	 * Tool felv�tel��rt felel�s f�ggv�ny.
     * @param p - A J�t�kos aki felvesz egy Toolt
     * @return Reasult a felv�tel sikeress�g�r�l
     */
    Result pickMeUp(Player p);

    /**
     * Megvizsg�lja a megkapott eszk�zre, hogy az adott j�t�kos rendelkezik-e m�r vele.
     * @param d az �sszehasonl�t�shoz sz�ks�ges DivingSuit p�ld�ny
     * @return Az �sszehasonl�t�s eredm�nye
     */
    boolean isSame(DivingSuit d);

    /**
     * Megvizsg�lja a megkapott eszk�zre, hogy az adott j�t�kos rendelkezik-e m�r vele.
     * @param s az �sszehasonl�t�shoz sz�ks�ges Shovel p�ld�ny
     * @return Az �sszehasonl�t�s eredm�nye
     */
    boolean isSame(Shovel s);

    /**
     * Megvizsg�lja a megkapott eszk�zre, hogy az adott j�t�kos rendelkezik-e m�r vele.
     * @param bs az �sszehasonl�t�shoz sz�ks�ges BreakableShovel p�ld�ny
     * @return Az �sszehasonl�t�s eredm�nye
     */
    boolean isSame(BreakableShovel bs);

    /**
     * Megvizsg�lja a megkapott eszk�zre, hogy az adott j�t�kos rendelkezik-e m�r vele.
     * @param t az �sszehasonl�t�shoz sz�ks�ges Tent p�ld�ny
     * @return Az �sszehasonl�t�s eredm�nye
     */
    boolean isSame(Tent t);

    /**
     * Megvizsg�lja a megkapott eszk�zre, hogy az adott j�t�kos rendelkezik-e m�r vele.
     * @param r az �sszehasonl�t�shoz sz�ks�ges Rope p�ld�ny
     * @return Az �sszehasonl�t�s eredm�nye
     */
    boolean isSame(Rope r);

    /**
	 * Mez� takar�t�s��rt felel�s f�ggv�ny.
     * @param f  A mez�, amin az �s�st kell v�grehajtani
     * @return Result a lap�tol�sr�l
     */
    Result clean(Field f);

    /**
	 * Lyukb�l val� ki�sz�s�rt felel�s f�ggv�ny.
     * @param f a mez� (lyuk), amibe beleesett a player
     * @param p melyik j�t�kos esett bele
     * @return Result a kim�sz�sr�l
     */
    Result swim(Field f, Player p);


    /**
	 * Lyukb�l val� kih�z�s�rt felel�s f�ggv�ny
     * @param f Az a field amire a player l�pni akar
     * @param p Az a j�t�kos amelyik a m�sik fieldre l�pne
     * @return Result a seg�ts�gr�l
     */
    Result help(Field f, Player p);


    /**
     * S�tor�p�t�s�rt felel�s f�ggv�ny.
     * @param f A mez�, amire s�trat kell �p�teni
     * @return Result az �p�t�sr�l
     */
    Result build(Field f);


}