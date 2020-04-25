package skeleton;

import java.util.*;

/**
 * Interf�sz, amely az eszk�z�k felv�tel�nek, illetve a vel�k kapcsolatos interakci�k
 * (�s�s, k�teles kiment�s, b�v�rruha haszn�lat�val t�rt�n� kimenek�l�s, s�tor�p�t�s)
 * kezel�s�re szolg�l� oszt�ly.
 */
public interface Tool extends Item {


    /**
	 * Legel�sz�r a Player oszt�ly getTools() f�ggv�nye ker�l megh�v�sra,
     * mely a j�t�kosn�l l�v� eszk�z�ket tartalmaz� list�val t�r vissza.
     * Ezt k�vet�en megh�vja a lista minden elem�re a Tool oszt�ly isSame(Tool) met�dus�t.
     * Ezut�n ezeknek a visszat�r�si �rt�kei ker�lnek vizsg�lat al�.
     * Amennyiben minden f�ggv�ny h�v�st k�vet�en csak FALSE visszat�r�si �rt�keket kapunk,
     * akkor megh�v�sra ker�l a Player oszt�ly addTool(Tool) met�dusa, majd ezt k�vet�en OK-kal t�r vissza.
     * K�l�nben pedig NOTHING lesz a visszat�r�si �rt�k.
     * @param p - A J�t�kos aki felvesz egy Toolt
     * @return Reasult a felv�tel sikeress�g�r�l
     */
    Result pickMeUp(Player p);

    /**
     * megvizsg�lja a megkapott eszk�zre, hogy az adott j�t�kos rendelkezik-e m�r vele.
     * @param t az �sszehasonl�t�shoz sz�ks�ges Tool p�ld�ny
     * @return
     */
    boolean isSame(Tool t);

    /**
	 * NOTHING �rt�kkel t�r vissza, kiv�ve ha a shovel vagy lesz�rmazottj�nak a f�ggv�nye h�v�dik meg
     * @param f  A mez�, amin az �s�st kell v�grehajtani
     * @return Result a lap�tol�sr�l
     */
    Result clean(Field f);

    /**
	* Virtu�lis f�ggv�ny, ami NOTHING �rt�kkel t�r vissza.
     * @param f a mez� (lyuk), amibe beleesett a player
     * @param p melyik j�t�kos esett bele
     * @return Result a kim�sz�sr�l
     */
    Result swim(Field f, Player p);


    /**
	* Virtu�lis f�ggv�ny, ami NOTHING �rt�kkel t�r vissza.
     * @param f Az a field amire a player l�pni akar
     * @param p Az a j�t�kos amelyik a m�sik fieldre l�pne
     * @return Result a seg�ts�gr�l
     */
    Result help(Field f, Player p);


    /**
     * Virtu�lis f�ggv�ny, ami NOTHING �rt�kkel t�r vissza.
     * @param f A mez�, amire s�trat kell �p�teni
     * @return Result az �p�t�sr�l
     */
    Result build(Field f);


}