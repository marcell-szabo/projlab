package skeleton;

import java.util.*;

/**
 * Az eszk�z�k felv�tel�nek, illetve a vel�k kapcsolatos interakci�k
 * (�s�s, k�teles kiment�s, b�v�rruha haszn�lat�val t�rt�n� kimenek�l�s) kezel�s�re szolg�l� absztrakt oszt�ly.
 */
public abstract class Tool extends Item {

    /**
     * Default constructor
     */
    public Tool() {
    }

    /**
	 * Legel�sz�r a Player oszt�ly getTools() f�ggv�nye ker�l megh�v�sra,
     * mely a j�t�kosn�l l�v� eszk�z�ket tartalmaz� list�val t�r vissza.
     * Ezt k�vet�en megh�vja a lista minden elem�re a Tool oszt�ly isSame(Item) met�dus�t.
     * Ezut�n ezeknek a visszat�r�si �rt�kei ker�lnek vizsg�lat al�.
     * Amennyiben minden f�ggv�ny h�v�st k�vet�en csak FALSE visszat�r�si �rt�keket kapunk,
     * akkor megh�v�sra ker�l a Player oszt�ly addItem(Item) met�dusa, majd ezt k�vet�en OK-kal t�r vissza.
     * K�l�nben pedig NOTHING lesz a visszat�r�si �rt�k.
     * @param p - A J�t�kos aki felvesz egy Toolt
     * @return
     */
    public Result pickMeUp(Player p) {
        // TODO implement here
        return Result.NOTHING;
    }

    /**
	* Megvizsg�lja a megkapott eszk�zre, hogy az adott j�t�kos rendelkezik-e m�r vele.
     * @param t 
     * @return
     */
    public boolean isSame(Tool t) {
        // TODO implement here
        return false;
    }

    /**
	* Virtu�lis, �res f�ggv�ny.
     * @param f
     */
    public void clean(Field f){}

    /**
	* Virtu�lis f�ggv�ny, ami NOTHING �rt�kkel t�r vissza.
     * @param f 
     * @param p 
     * @return
     */
    public Result swim(Field f, Player p){
        return Result.NOTHING;
    }

    /**
	* Virtu�lis f�ggv�ny, ami NOTHING �rt�kkel t�r vissza.
     * @param f 
     * @param p 
     * @return
     */
    public Result help(Field f, Player p){
        return Result.NOTHING;
    }


}