package skeleton;

import java.util.*;

/**
 * ?	Mezõk kezelésére szolgáló absztrakt osztály. Segítségével a játékosok, illetve
 * a vihar által a mezõn végzett tevékenységeket lehet megvalósítani.
 */
public abstract class Field {

    /**
     * Az adott mezõn lévõ hóréteg mennyiségét tárolja.
     */
    private int snow;

    /**
     * Az adott mezõ teherbíró képességét tárolja el. Stabil jégtábla esetén a max játékosok száma,
     * lyuk esetén pedig nulla az értéke.
     */
    protected int capacity;

    /**
     * Tárolja, hogy az adott mezõn melyik játékosok vannak rajta.
     */
    protected List<Player> players = new ArrayList<>();

    /**
     * Tárolja a 4 irányban elhelyezkedõ mezõt.
     */
    private Map<Direction, Field> neighbours = new EnumMap<>(Direction.class);

    /**
     * Tárolja, hogy a mezõn milyen tárgyat lehet felvenni.
     */
    protected Item item;

    /**
     * Default constructor
     */
    public Field() {
    }

    /**
     * Absztrakt függvény. A Hole vagy az IceField osztály storm() függvénye kerül meghívásra.
     *
     * @return Result enum
     */
    public abstract Result storm();

    /**
     * Absztrakt függvény. A Hole vagy az IceField osztály stepOn() függvénye kerül meghívásra.
     *
     * @param p : Player melyik játékos
     * @return Result enum
     */
    public abstract Result stepOn(Player p);

    /**
     * Az átadott irány alapján visszatér az abban az irányban levõ objektum referenciájával.
     * Ha arra tenger van, akkor ez az érték NULL lesz.
     *
     * @param d - Direction, melyik irány
     * @return Field, annak a mezõnek a referenciájával amire lépett
     */
    public Field checkNeighbour(Direction d) {
        System.out.print(this.toString() + ".checkNeighbour(d);\n" + d);
        System.out.print(this.toString() + ".checkNeighbour(d) returned Field field;\n");
        return neighbours.get(d);
    }

    public void addNeighbour(Field f, Direction d) {
        neighbours.put(d, f);
    }

    /**
     * Akkor tér vissza OK értékkel, ha az adott mezõrõl megoldható a vízbe esett játékos vízbõl való kimentése.
     * Ennek eldöntéséhez meghívja sorra összes rajta álló játékos getTools() függvényét,
     * majd a megkapott Tool-okat tartalmazó listákra meghívja a help metódust.
     * Ha legalább egy OK értékkel tér vissza, akkor õ is, különben pedig DIE-al.
     *
     * @return Result OK vagy DIE - attól függõen, hogy ki lehet-e menteni a játékost
     */
    public Result canHelp() {
        System.out.print(this.toString() + ".canHelp();\n");
        for (Player p : players) {
            for (Tool t : p.getTools()) {
                if (t.help(this, p) == Result.OK) {
                    System.out.print(this.toString() + ".canHelp() returned Result r;\n");
                    return Result.OK;
                }
            }
        }
        System.out.print(this.toString() + ".canHelp() returned Result r;\n");
        return Result.DIE;
    }

    /**
     * Megvizsgálja, hogy az adott mezõn áll-e az összes játékos, tehát összehasonlítja a
     * megkapott allplayer attribútumot a rajta állók számával. Ha ez megegyezik, akkor TRUE értékkel,
     * ellenkezõ esetben FALSE értékkel tér vissza.
     *
     * @param allplayer összes játékos száma
     * @return boolean TRUE or FALSE
     */
    public boolean haveAllPlayer(int allplayer) {
        System.out.print(this.toString() +".haveAllPlayers(allplayer);\n");
        System.out.print(this.toString() +".haveAllPlayers(allplayer) returned boolean b;\n");
        return false;
    }

    /**
     * Üres virtuális függvény, nem csinál semmit sem csak visszatér egy OK-al. Ez a függvény nem
     * lesz meghívva a mûködés során, hanem ezen keresztül az IceField osztályban felülírt változata fog meghívódni.
     *
     * @return OK
     */
    public Result buildIgloo() {
        return null;
    }

    /**
     * Az attribútumban megkapott játékost kiveszi a players attribútumban tárolt játékosok referenciái közül (mivel a játékos elmozdult a mezõrõl).
     *
     * @param p mozgatni kívánt Player
     */
    public void leaveField(Player p) {
        System.out.print(this.toString() + ".leaveField(p1);\n");
        players.remove(p);
        System.out.print(this.toString() + ".leaveField(p1) returned;\n");
    }

    /**
     * Megvizsgálja a snow attribútum értékét. Amennyiben ez nem nulla, akkor eggyel csökkenti az értékét, majd pedig OK-kal tér vissza.
     * Ellenkezõ esetben nem történik meg a csökkentés, és a visszatérési érték NOTHING lesz.
     *
     * @return Result OK or NOTHING - attól függõen, hogy van-e még hóréteg a mezõn
     */
    public Result clean() {
        System.out.print(this.toString() + ".clean();\n");
        if (snow != 0) {
            snow--;
            System.out.print(this.toString() + ".clean() returned Result r;\n");
            return Result.OK;
        }
        System.out.print(this.toString() + ".clean() returned Result r;\n");
        return Result.NOTHING;
    }

    /**
     * Megvizsgálja a rajta található hó mennyiségét. Ha ez nulla, és található rajta jégbe fagyott tárgy, akkor meghívja az Item osztály pickMeUp(Player) függvényét. Sikeres tárgyfelvétel esetén OK-kal tér vissza, egyébként pedig NOTHING-gal.
     *
     * @param p mezõn álló Player
     * @return OK or NOTHING
     */
    public Result pickUp(Player p) {
        // TODO implement here
        return null;
    }

    /**
     * Visszaadja az  mezõ teherbíró képességét. (Az elkészült játékban valószínûleg ez a függvény nem fog visszatérni a teherbírás értékével, hanem csak megjeleníti a képernyõn azt. Most a grafikus elemek hiányában illetve a jobb érthetõség kedvéért használjuk ezt a függvényt így.)
     *
     * @return kapacitás
     */
    public int getCapacity() {
        System.out.println(this.toString() + ".getCapacity();");
        System.out.println(this.toString() + ".getCapacity() returned int capacity;");
        return 0;
    }

}