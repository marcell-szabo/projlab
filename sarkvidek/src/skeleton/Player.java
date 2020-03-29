package skeleton;

import java.util.*;

import skeleton.Result;

import static skeleton.Result.NOTHING;
import static skeleton.Result.OK;

/**
 * Játékosok kezelésére szolgáló osztály. A játékosok munkájának és testhőjének vizsgálata mellett a körökben elvégezhető cselekvésekkel foglalkozik. Minden játékos köre addig tart, amíg a work attribútumának értéke nem csökken le nullára. Minden cselekvés, ami az adott esetben engedélyezett, az egy egység munkavégzéssel jár (például tárgy felvétele olyan mezőn, amin még van hóréteg nem engedélyezett, és ilyenkor ez nem is jár munkavégzéssel).
 */
public abstract class Player {
    /**
     * Az adott játékos testhő szintjének mennyiségét tárolja.
     */
    protected int heat;

    /**
     * Az adott játékos munkájának (szebben megfogalmazva: munkára fordítható energiájának) egységeit tárolja.
     */
    protected int work;

    /**
     * Tárolja az aktuális játékot.
     */
    private Game game;

    /**
     * Tárolja, hogy az adott játékos melyik mezőn áll.
     */
    protected Field actualfield;

    /**
     * Tárolja a játékosnál található tárgyakat. 
     */
    private List<Tool> tools = new ArrayList<>();

    /**
     * Default constructor
     */
    public Player(Game g, Field actual) {
        game = g;
        actualfield = actual;
    }

    /**
	* Elsőként beállítja a jelenlegi játékos work attribútumának értéket négy egységre, majd végigvárja (egy ciklusban) a játékos lépéseit (míg a work értéke nulla nem lesz, vagy véget nem ér a játék győzelem vagy halál miatt). Futás során az általunk választott cselekvésekhez szükséges függvényeket fogja meghívni. Ha az általa meghívott függvények OK-kal térnek vissza, akkor csökkenti a work értékét eggyel, majd ellenőrzi, hogy ezt követően nem csökkent-e nullára. Amennyiben nem, akkor folytatódik a ciklus futása, ellenben ha ez az érték nullára csökkent, akkor kilép a ciklusból, és a round() metódus OK értékkel tér vissza. Ha futás során bármely függvény DIE vagy WIN visszatérési értékkel rendelkezik, akkor a round() szintén kilép a ciklusából és ugyanazzal fog visszatérni amit kapott. (NOTHING hatására nem csökkenti a work attribútumot, és biztosan benne marad a ciklusban)
     * @return
     */
    public Result round() {
        // TODO implement here
        return null;
    }

    /**
	*Meghívja a Field osztály clean() metódusát. Amennyiben ez OK-kal tér vissza, akkor meghívja a tools attribútumban tárolt összes Tool példány clean(Field) függvényét. Végül visszatér azzal, amivel a Field osztály először meghívott clean() függvénye tért vissza.
     * @return
     */
    public Result clean() {
        System.out.print(this.toString() + ".clean();\n");
        Result r = actualfield.clean();
        if (r == Result.OK) {
            for (Tool t : tools) {
                t.clean(actualfield);
            }
        }
        System.out.print(this.toString() + ".clean() returned Result r;\n");
        return r;
    }

    /**
	*A game attribútumban tárolt Game-re meghívja a getPlayerNumber() függvényt. A visszakapott értéket átadja az általa hívott a haveAllPlayers() metódusnak. Ha ez FALSE értékkel tér vissza, akkor ő OK-kal fog. TRUE esetén viszont meghívja a HaveAllParts() függvényt, amely ha TRUE-val tér vissza, akkor az assemble() WIN-nel fog. Amennyiben a haveAllParts() metódus FALSE értékkel tér vissza, akkor az assemble() OK-kal fog. (Ezekben az esetekben azért tér vissza OK-kal, mert a feleslegesen megpróbált összeszerelés is munkának számít).
     * @return
     */
    public Result assemble() {
        // TODO implement here
        return null;
    }

    /**
	* Absztrakt függvény. Az Eskimo vagy az Explorer osztály specialSkill() függvénye hívódik meg.
     * @return
     */
    public abstract Result specialSkill();

    /**
	* Meghívja az actualfieldben tárolt mezőre a Field osztály leaveField(Player) függvényét.
     * Ezek után beállítja a jelenlegi játékos actualfield nevű attribútumának értékét a megkapott mezőre.
     * Ezt követően meghívja a Field osztály stepOn(Player) függvényét, és azzal fog visszatérni,
     * amivel az általa hívott metódus visszatért.
     * @param f 
     * @return
     */
    public Result changeField(Field f) {
        actualfield.leaveField(this);
        actualfield = f;
        return f.stepOn(this);
    }

    /**
	*Először a swim(Field, Player) metódus kerül meghívásra minden egyes eszközre.
     * Ezt követően a visszatérési értékek kerülnek vizsgálatra.
     * Ha ezek közül bármelyik nem NOTHING értéket vesz fel, akkor azzal az értékkel tér vissza a helpMe() is.
     * Ha pedig mindegyik NOTHING-gal tér vissza, akkor minden irányt megvizsgál a checkNeighbour(Direction) metódussal.
     * Amennyiben a visszatérési érték nem NULL, akkor meghívódik a canHelp() függvény a megkapott referenciára.
     * Ebben az esetben amivel ez a metódus tér vissza, azzal fog a helpMe() is.
     * @return
     */
    public Result helpMe() {
        for (Tool t : tools) {
            if (t.swim(actualfield, this) != Result.NOTHING)
                return t.swim(actualfield, this);
        }
        for (Direction d: Direction.values()) {
            Field i = actualfield.checkNeighbour(d);
            if (i != null){
                return actualfield.checkNeighbour(d).canHelp();
            }
        }
        return NOTHING;
    }

    /**
	 * Csökkenti a játékos heat nevű attribútumának értékét eggyel, majd megvizsgálja, hogy mennyi a heat értéke.
     * Amennyiben ez nullára csökkent, akkor DIE, minden más esetben pedig OK  visszatérési értéke lesz.
     * @return
     */
    public Result decreaseHeat() {
        System.out.print(this.toString() + ".decreaseHeat();\n");
        System.out.print(this.toString() + ".decreaseHeat() returned Result\n");
        return Result.OK;
    }

    /**
	* A listához hozzáadja a megkapott eszközt. 
     * @param t
     */
    public void addTool(Tool t) {
        // TODO implement here
    }

    /**
	* Legelőször a megkapott irányra meghívja a checkNeighbour(Direction) metódust. Ezt követően az előbb hívott függvény visszatérési értékét átadva kerül a changeField(Field) meghívásra. Amivel ez visszatér, azzal fog a move(Direction) is.
     * @param d 
     * @return
     */
    public Result move(Direction d) {
        System.out.print(this.toString() + ".move();\n");
        actualfield.addNeighbour(new Hole(), Direction.RIGHT);
        Field field = actualfield.checkNeighbour(d);
        field.stepOn(this);
        System.out.print(this.toString() + ".move() returned Result r;\n\n\n");
        return NOTHING;
    }

    /**
	* Legelőször megvizsgálja, hogy az adott játékos heat attribútumának értéke a maximális érték alatt van-e. Amennyiben igen, akkor megnöveli eggyel az értékét, majd OK visszatérési értéket ad. Ellenkező esetben kimarad a növelés, és NOTHING értékkel tér vissza.  
     * @return
     */
    public Result increaseHeat() {
        // TODO implement here
        return null;
    }

    /**
	* Meghívja a Game osztály addPart(FlareGun) függvényét.
     * @param f
     */
    public void addPart(FlareGun f) {
        // TODO implement here
    }

    /**
	*Visszaadja az eszközöket tartalmazó listát, tehát a tools attribútumát.
     * @return
     */
    public List<Tool> getTools() {
        // TODO implement here
        return null;
    }

}