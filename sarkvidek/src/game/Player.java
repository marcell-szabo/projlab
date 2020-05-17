package game;

import Display.Frame;
import graphics.Draw;
import graphics.Drawable;

import java.util.*;

import static game.Result.*;

/**
 * Játékosok kezelésére szolgáló osztály. A játékosok munkájának és testhõjének vizsgálata mellett a körökben elvégezhetõ
 * cselekvésekkel foglalkozik. Minden játékos köre addig tart, amíg a work attribútumának értéke nem csökken le nullára.
 * Minden cselekvs, ami az adott esetben engedélyezett, az egy egység munkavégzéssel jár (például tárgy felvétele olyan
 * mezõn, amin még van hóréteg nem engedélyezett, és ilyenkor ez nem is jár munkavégzéssel).
 */
public abstract class Player implements Drawable {

    protected char color;
    /**
     * Az adott játékos testhõ szintjének mennyiségét tárolja.
     */
    protected int heat;

    /**
     * Az adott játékos munkájának egységeit tárolja.
     */
    protected int work = 4;

    /**
     * Tárolja az aktuális játékot.
     */
    protected Game game;

    /**
     * Tárolja, hogy az adott játékos melyik mezõn áll.
     */
    protected Field actualfield;

    /**
     * Tárolja a játékosnál található tárgyakat.
     */
    private List<Tool> tools = new ArrayList<>();

    /**
     * Default constructor
     */
    public Player(Game g, Field actual, char c, int h) {
        game = g;
        actualfield = actual;
        color = c;
        heat = h;
    }

    /**
     * Visszaadja az eszk?z?ket tartalmaz? list?t, teh?t a tools attrib?tum?t.
     *
     * @return eszk?z?ket tartalmaz? lista
     */
    public List<Tool> getTools() {
        return tools;
    }

    /**
     * Elsõként beállítja a jelenlegi játékos work attribútumának értékét négy egységre, majd végigvárja
     * (egy ciklusban) a játékos lépéseit (míg a work értéke nulla nem lesz, vagy véget nem ér a játék gyõzelem vagy
     * halál miatt). Futása során a kontrollertõl kapott billentyûk alapján az adott cselekvéshez szükséges függvényeket
     * fogja meghívni. Ha az általa meghívott függvények OK-kal térnek vissza, akkor csökkenti a work értékét eggyel, majd
     * ellenõrzi hogy nem csökkent-e nullára. A függvény visszatérése OK, ha minden rendben, DIE vagy WIN ha az elvégzett
     * tevékenységgel a játék véget ért gyõzelemmel vagy halállal.
     * @return a körben történt-e win, die
     */
    public Result round(Frame frame) {
        this.work = 4;
        Result result = OK;
        while(work != 0 && result != DIE && result != WIN) {
            char c = game.controller.EventHandler();
            game.examinedField = null;
            game.examinedCapacity = null;
            switch (c) {
                case 'w':
                    result = this.move(0);
                    break;
                case 'd':
                    result = this.move(1);
                    break;
                case 's':
                    result = this.move(2);
                    break;
                case 'a':
                    result = this.move(3);
                    break;
                case 'j':
                    result = this.clean();
                    break;
                case 'k':
                    result = actualfield.pickUp(this);
                    break;
                case 'l':
                    result = this.specialSkill();
                    break;
                case 'i':
                    result = this.assemble();
                    break;
                case 'm':
                    result = this.buildTent();
                default:
                    break;
            }
            if (result == OK) {
                game.actualSnow = Integer.toString(this.actualfield.getSnow());
                work--;
                game.actualWork = Integer.toString(work);
                game.actualHeat = Integer.toString(heat);
                frame.update(frame.getGraphics());
            }
        }
        return result;
    }

    /**
     * Meghívja a tools attribútumban tárolt összes Tool példányra a build(Field)
     * függvényt. Amennyiben bármelyik DISAPPEAR-rel tér vissza, akkor az törlésre kerül a tools tömbbõl,
     * majd a buildTent() metódus visszatérési értéke OK lesz. Abban az esetben viszont,
     * ha egyik sem tér vissza DISAPPEAR-rel, akkor a buildTent() OK helyett NOTHING visszatérési értéket fog adni.
     * @return OK or NOTHING
     */
    private Result buildTent() {
        for (Tool t : tools) {
            if (t.build(actualfield) == DISAPPEAR) {
                tools.remove(t);
                return OK;
            }

        }
        return NOTHING;
    }

    /**
     * Legelõször a megkapott irányra meghívja a checkNeighbour(Direction) metódust.
     * Ezt követõen az elõbb hívott függvény visszatérési értékét átadva kerül a changeField(Field) meghívásra.
     * Amivel ez visszatér, azzal fog a move(Direction) is.
     *
     * @param d mozgásnál preferált irány
     * @return Result a sikerességérõl
     */
    public Result move(int d) {
        Field field = actualfield.checkNeighbour(d);
        if (field != null)
            return this.changeField(field);
        return NOTHING;
    }

    /**
     * Meghívja az actualfieldben tárolt mezõre a Field osztály leaveField(Player) függvényét.
     * Ezek után beállítja a jelenlegi játékos actualfield nevû attribtumának értékét a megkapott mezõre.
     * Ezt követõen meghívja a Field osztály stepOn(Player) függvényét, és azzal fog visszatérni,
     * amivel az általa hívott metódus visszatért.
     * @param f megkapja a mezõt amire lép, ez lesz az actualfield
     * @return Result a sikerességrõl
     */
    public Result changeField(Field f) {
        actualfield.leaveField(this);
        actualfield = f;
        return f.stepOn(this);
    }

    /**
     * Meghívja a Field osztály clean() metódusót. Amennyiben ez OK-kal tér vissza,
     * akkor meghívja a tools attribútumban tárolt összes Tool példány clean(Field) függvényét.
     * Végül visszatür azzal, amivel a Field osztály elõször meghívott clean() függvénye tért vissza.
     * @return Result
     */
    public Result clean() {
        Result r = actualfield.clean();
        if (r == Result.OK) {
            for (Tool t : tools) {
                if(t.clean(actualfield) == DISAPPEAR) {
                    tools.remove(t);
                    return r;
                }

            }
        }
        return r;
    }

    /**
     * A game attribútumban tárolt Game-re meghívja a getPlayerNumber() függvényt.
     * A visszakapott értéket átadja az általa hívott a haveAllPlayers() metódusnak.
     * Ha ez FALSE értékkel tér vissza, akkor OK-kal fog. TRUE esetén viszont meghívja a HaveAllParts() függvényt,
     * amely ha TRUE-val tér vissza, akkor az assemble() WIN-nel fog. Amennyiben a haveAllParts() metódus FALSE értékkel
     * tér vissza, akkor az assemble() OK-kal fog. (Ezekben az esetekben azért tér vissza OK-kal,
     * mert a feleslegesen megpróbált összeszerelés is munkának számít).
     * @return az összeszerelés sikeressége
     */
    public Result assemble() {
        if (actualfield.haveAllPlayer(game.getPlayerNumber()) && game.haveAllParts()) {
            return WIN;
        }
        return OK;
    }

    /**
     * Elõször a swim(Field, Player) metódus kerül meghívásra minden egyes eszközre.
     * Ezt követõen a visszatérési értékek kerülnek vizsgálatra.
     * Ha ezek közül bármelyik nem NOTHING értéket vesz fel, akkor azzal az értékkel tér vissza a helpMe() is.
     * Ha pedig mindegyik NOTHING-gal tér vissza, akkor minden irányt megvizsgál a checkNeighbour(Direction) metódussal.
     * Amennyiben a visszatérési érték nem NULL, akkor meghívódik a canHelp() függvény a megkapott referenciára vagy
     * referenciákra, és ha van olyan mely OK-al tér vissza akkor nem hal meg a játékos
     * Ebben az esetben amivel ez a metódus tér vissza, azzal fog a helpMe() is.
     * @return Result a segítségkérés sikerességével
     */
    public Result helpMe() {
        for (Tool t : tools) {
            Result res = t.swim(actualfield, this);
            if (res != NOTHING)
                return res;
        }
        for (int d = 0; d <= 3; d++) {
            Field field = actualfield.checkNeighbour(d);
            if (field != null)
                if (actualfield.checkNeighbour(d).canHelp(this) == OK)
                    return OK;
        }
        return DIE;
    }

    /**
     * Csökkenti a játékos heat attribútumának értékét eggyel, majd megvizsgálja, hogy mennyi a heat értéke.
     * Amennyiben ez nullára csökkent, akkor DIE, minden más esetben pedig OK  visszatérési értéke lesz.
     * @return a testhõcsökkentés sikerességével tér vissza
     */
    public Result decreaseHeat() {
        heat--;
        if (heat == 0)
            return DIE;
        return OK;
    }

    /**
     * A listához hozzáadja a megkapott eszközt.
     * @param t tool példány
     */
    public void addTool(Tool t) {
        tools.add(t);
        return;
    }

    /**
     * Meghívja a Game osztály addPart(FlareGun) függvényét.
     * @param f jelzõrakéta elem
     */
    public void addPart(FlareGun f) {
        game.addPart(f);
        return;
    }

    /**
     * Abstract fv, vagy az eskimo vagy az explorer increaseHeat() fv-je hívódik meg
     */
    public abstract Result increaseHeat();

    /**
     * Absztrakt függvény. Az Eskimo vagy az Explorer osztály specialSkill() függvénye hívódik meg.
     * @return a képességhasználat eredménye
     */
    public abstract Result specialSkill();

    /**
     * Getter függvény, visszaadja a játékos színét
     * @return játékos színe
     */
    public char getColor(){
        return color;
    }

    /**
     * A Drawable interfészbõl implementált függvény. Meghívja a saját magát kirajzoló függvényt a Draw osztályban.
     * @param draw - Draw osztály példánya amelyben implementálva van a játékost kirajzoló függvény.
     * @param x - kirajzolás helyének X koordinátája
     * @param y - kirajzolás helyének Y koordinátája
     */
    public abstract void draw(Draw draw, int x, int y);



}