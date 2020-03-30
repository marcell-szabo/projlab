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
     * a paraméterknt megadott player felvesz egy búvárruhát
     *
     * @param p a player aki felveszi az búvárruhát
     * @return Result a felvétel sikerességéről
     */
    @Override
    public Result pickMeUp(Player p) {
        System.out.println(this.toString() + ".pickMeUp(p);");
        p.addTool(this);
        System.out.println(this.toString() + ".pickMeUp(p) returned Result res;");
        return null;
    }

    /**
     * Mindig TRUE értékkel tér vissza (hiszen csak akkor hívódik meg, ha egy DivingSuit
     * példány szeretné magát összehasonlítani vele).
     *
     * @param d - egy olyan DivingSuit példány amivel összehasonlítja magát a függvény hívó példány
     * @return true
     */
    public boolean isSame(DivingSuit d) {
        // TODO implement here
        return true;
    }

    /**
     * A Tool osztály swim(Field, Player) függvényének felüldefiniálása.
     * A játékos által megadott irányt átadva meghívja az actualfield checkNeighbour(Direction) függvényét,
     * ami visszatér az ott található mező referenciájával. Ha ez NULL érték lenne (tehát arra tenger van),
     * akkor újra meg kell adni az irányt.Ha megkaptuk a választott szomszédos mező referenciáját,
     * akkor ezt átadva meghívódik a paraméterben megkapott játékos changeField(Field) függvénye.
     * Ennek a metódusnak a visszatérési értékével tér vissza a swim(Field, Player) függvény is.
     *
     * @param h - a lyuk amibe beleesett a player búvárruhában
     * @param p - melyik játékos esett bele
     * @return Result a kimászásról
     */
    private Result swim(Hole h, Player p) {
        System.out.print(this.toString() + ".swim(Hole h, Player p);\n");
        System.out.println("A J(jobbra), B(balra), F(fel), L(le) karakterek segítségével válasszon," +
                "mely irányba szeretne kimászni.");
        Scanner sc = new Scanner(System.in);
        String c = sc.next();
        Direction d = UP;
        switch (c) {
            case "J":
                d = RIGHT;
            case "B":
                d = LEFT;
            case "F":
                d = UP;
            case "L":
                d = DOWN;
        }
        if (h.checkNeighbour(d) == null)
            swim(h, p);
        else {
            System.out.print(this.toString() + ".swim(Hole h, Player p) returned Result r;\n");
            return p.changeField(h.checkNeighbour(d));
        }
        System.out.print(this.toString() + ".swim(Hole h, Player p) returned null;\n");
        return null;
    }

}