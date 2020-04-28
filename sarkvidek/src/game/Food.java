package game;

import java.util.*;

/**
 * �tel felv�tel�nek kezel�s�re szolg�l� oszt�ly.
 */
public class Food implements Item {

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
     * @param p �telt felvenni k�v�n� j�t�kos
     * @return Result az eredm�nnyel visszat�r
     */
    public Result pickMeUp(Player p) {
        return p.increaseHeat();
    }

    /**
     *A Food nev�nek ki�r�s��rt felel�s f�ggv�ny
     */
    @Override
    public void namestate(){
        System.out.print("food");
    }

}