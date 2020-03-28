package skeleton;

import java.util.*;

/**
 * A búvárruha felvételének, illetve használatának kezelésére szolgáló osztály.
 */
public class DivingSuit extends Item {

    /**
     * Default constructor
     */
    public DivingSuit() {
    }

    @Override
    public Result pickMeUp(Player p) {
        return null;
    }

    /**
	* Mindig TRUE értékkel tér vissza (hiszen csak akkor hívódik meg, ha egy DivingSuit példány szeretné magát összehasonlítani vele).
     * @param d - egy olyan DivingSuit példány amivel összehasonlítja magát a függvény hívó példány
     * @return true
     */
    public boolean isSame(DivingSuit d) {
        // TODO implement here
        return true;
    }

    /**
	* A Tool osztály swim(Field, Player) függvényének felüldefiniálása. A játékos által megadott irányt átadva meghívja az actualfield checkNeighbour(Direction) függvényét, ami visszatér az ott található mező referenciájával. Ha ez NULL érték lenne (tehát arra tenger van), akkor újra meg kell adni az irányt. Ha megkaptuk a választott szomszédos mező referenciáját, akkor ezt átadva meghívódik a paraméterben megkapott játékos changeField(Field) függvénye. Ennek a metódusnak a visszatérési értékével tér vissza a swim(Field, Player) függvény is.
     * @param h - a lyuk amibe beleesett a player búvárruhában
     * @param p - melyik játékos esett bele
     * @return Result enum
     */
    public Result swim(Hole h, Player p) {
        // TODO implement here
        return null;
    }

}