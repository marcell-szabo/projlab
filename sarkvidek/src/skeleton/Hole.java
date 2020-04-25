package skeleton;
//**push**
import java.util.*;

import static skeleton.Result.DIE;
import static skeleton.Result.OK;

/**
 * Lyukak kezel�s�re szolg�l� oszt�ly. A vele kapcsolatos kiment�si k�s�rletet is ez az oszt�ly kezdi meg.
 */
public class Hole extends Field {

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
        if (this == polarbear.actualfield)
            return DIE;
        else
            return p.helpMe();
    }

    @Override
    public Result stepOn(Polarbear pb)
    {
        polarbear = pb;
        return  OK;
    }

}