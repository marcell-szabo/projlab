package game;
//**push**
import java.util.*;

import static game.Result.DIE;
import static game.Result.OK;

/**
 * Lyukak kezel�s�re szolg�l� oszt�ly. A vele kapcsolatos kiment�si k�s�rletet is ez az oszt�ly kezdi meg.
 */
public class Hole extends Field {

    public Hole(int snow, int capacity, String name) {
        super(snow, capacity, name);
    }

    /**
     * A Field oszt�lyban l�v� absztrakt f�ggv�ny megval�s�t�sa. Az adott mez� snow attrib�tum�nak �rt�k�t megn�veli eggyel.
     * Mindig OK-kal t�r vissza.
     *
     * @return OK
     */
    public Result storm() {
        snow++;
        return OK;
    }

    /**
     * A Field oszt�lyban l�v� absztrakt f�ggv�ny megval�s�t�sa.
     * Legel�sz�r megn�zi, hogy tart�zkodik-e az adott mez�n jegesmedve, mivel ha igen, akkor a f�ggv�ny
     * DIE-al t�r vissza (Az �ltalunk kital�lt j�t�kban a jegesmedve �llhat lukon is).
     * Ha ezt a vizsg�latot k�vet�en nem keletkezett visszat�r�si �rt�k, akkor az attrib�tumk�nt kapott Player p�ld�ny helpMe()
     * met�dus�t h�vja meg, majd ennek a visszat�r�si �rt�k�vel t�r vissza a stepOn(Player) f�ggv�ny is.
     *
     * @param p erre a mez�re l�p� Player
     * @return Result, hogy siker�lt-e kimenteni a j�t�kost.
     */
    public Result stepOn(Player p)
    {
        if (this == polarbear.getActualfield())
            return DIE;
        else
            return p.helpMe();
    }

    @Override
    public Result stepOn(PolarBear pb)
    {
        polarbear = pb;
        return  OK;
    }

    /**
     * A Hole adatainak ki�r�s��rt felel�s f�ggv�ny.
     * Megjelen�ti a lyukon tal�lhat� h�r�tegek sz�m�t, a lyuk teherb�r�s�t (ami mindig 0),
     * a lyukba esett j�t�kosok nev�t �s hogy tal�lhat�-e jegesmedve a lyukon.
     */
    @Override
    public void state() {
        System.out.println("Hole:");
        System.out.println("snow: " + this.snow);
        System.out.println("capacity: " + this.capacity);
        System.out.print("players: ");
        for (Player p : players) {
            p.namestate();
            System.out.print(", ");
        }
        System.out.print("\n");
        if (polarbear .getActualfield() != this) System.out.println("polarbear: false");
        else System.out.println("polarbear: true");
        System.out.print("\n");
    }
}