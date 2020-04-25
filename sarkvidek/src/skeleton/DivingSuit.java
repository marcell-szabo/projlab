package skeleton;

import java.util.*;

import static skeleton.Direction.*;

/**
 * A búvárruha felvételének, illetve használatának kezelésére szolgáló osztály.
 */
public class DivingSuit extends Tool {

    /**
     * Default constructor
     */
    public DivingSuit() {
    }

    /**
     * Mindig TRUE értékkel tér vissza (hiszen csak akkor hívódik meg, ha egy DivingSuit
     * példány szeretné magát összehasonlítani vele).
     *
     * @param d az összehasonlításhoz szükséges DivingSuit példány
     * @return true
     */
    public boolean isSame(DivingSuit d) {
        return true;
    }

    /**
     * A Tool osztály swim(Field, Player) függvényének felüldefiniálása.
     * A játékos által megadott irányt átadva meghívja az actualfield checkNeighbour(int) metódusát,
     * ami visszatér az ott található mezõ referenciájával.
     * Ha ez NULL érték lenne (tehát arra tenger található), akkor újra meg kell adni egy irányt.
     * Ha megkaptuk a választott szomszédos mezõ referenciáját, akkor ezt átadva meghívódik
     * a paraméterben megkapott játékos changeField(Field) függvénye.
     * Ennek a metódusnak a visszatérési értékével tér vissza a swim(Field, Player) függvény is.
     *
     * @param f a mezõ (lyuk), amibe beleesett a player
     * @param p melyik játékos esett bele
     * @return Result a kimászásról
     */
    public Result swim(Field f, Player p) {
        System.out.println("A J(jobbra), B(balra), F(fel), L(le) karakterek segítségével válasszon," +
                "mely irányba szeretne kimászni.");
        Field choosedField = null;
        while (choosedField == null) {
            Scanner sc = new Scanner(System.in);
            String c = sc.next();
            int d = 0;
            switch (c) {
                case "J":
                    d = 0;
                case "B":
                    d = 1;
                case "F":
                    d = 2;
                case "L":
                    d = 3;
            }
            choosedField = f.checkNeighbour(d);
            if (choosedField == null)
                System.out.println("A választott irányban tenger található, adjon meg új irányt!");
        }
        return p.changeField(choosedField);
    }
}