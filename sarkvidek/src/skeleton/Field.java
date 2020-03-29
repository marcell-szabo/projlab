package skeleton;

import java.util.*;

/**
 * ●	Mezők kezelésére szolgáló absztrakt osztály. Segítségével a játékosok, illetve a vihar által a mezőn végzett tevékenységeket lehet megvalósítani.
 */
public abstract class Field {

    /**
     * Az adott mezőn lévő hóréteg mennyiségét tárolja.
     */
    private int snow;

    /**
     * Az adott mező teherbíró képességét tárolja el. Stabil jégtábla esetén a max játékosok száma, lyuk esetén pedig nulla az értéke.
     */
    protected int capacity;

    /**
     * Tárolja, hogy az adott mezőn melyik játékosok vannak rajta.
     */
    protected List<Player> players = new ArrayList<>();

    /**
     * Tárolja a 4 irányban elhelyezkedő mezőt.
     */
    private Map<Direction, Field>  neighbours;

	/**
     * Tárolja, hogy a mezőn milyen tárgyat lehet felvenni. 
     */
    protected Item item;

    /**
     * Default constructor
     */
    public Field() {
    }

    /**
	* Absztrakt függvény. A Hole vagy az IceField osztály storm() függvénye kerül meghívásra.
     * @return Result enum
     */
    public abstract Result storm();

    /**
	* Absztrakt függvény. A Hole vagy az IceField osztály stepOn() függvénye kerül meghívásra.
     * @param p : Player melyik játékos
     * @return Result enum
     */
    public abstract Result stepOn(Player p);

    /**
	* Az átadott irány alapján visszatér az abban az irányban levő objektum referenciájával. Ha arra tenger van, akkor ez az érték NULL lesz.
     * @param d - Direction, melyik irány
     * @return Field, annak a mezőnek a referenciájával amire lépett
     */
    public Field checkNeighbour(Direction d) {
        // TODO implement here
        return null;
    }

    /**
	* Akkor tér vissza OK értékkel, ha az adott mezőről megoldható a vízbe esett játékos vízből való kimentése. Ennek eldöntéséhez meghívja sorra összes rajta álló játékos getTools() függvényét, majd a megkapott Tool-okat tartalmazó listákra meghívja a help metódust. Ha legalább egy OK értékkel tér vissza, akkor ő is, különben pedig DIE-al.
     * @return Result OK vagy DIE
     */
    public Result canHelp() {
        // TODO implement here
        return null;
    }

    /**
	* Megvizsgálja, hogy az adott mezőn áll-e az összes játékos, tehát összehasonlítja a megkapott allplayer attribútumot a rajta állók számával. Ha ez megegyezik, akkor TRUE értékkel, ellenkező esetben FALSE értékkel tér vissza. 
     * @param allplayer összes játékos száma
     * @return boolean TRUE or FALSE
     */
    public boolean haveAllPlayer(int allplayer) {
        // TODO implement here
        return false;
    }

    /**
	* Üres virtuális függvény, nem csinál semmit sem csak visszatér egy OK-al. Ez a függvény nem lesz meghívva a működés során, hanem ezen keresztül az IceField osztályban felülírt változata fog meghívódni. 
     * @return OK
     */
    public Result buildIgloo() {
        // TODO implement here
        return null;
    }

    /**
	* Az attribútumban megkapott játékost kiveszi a players attribútumban tárolt játékosok referenciái közül (mivel a játékos elmozdult a mezőről).
     * @param p mozgatni kívánt Player
     */
    public void leaveField(Player p) {
        // TODO implement here
    }

    /**
	* Megvizsgálja a snow attribútum értékét. Amennyiben ez nem nulla, akkor eggyel csökkenti az értékét, majd pedig OK-kal tér vissza. Ellenkező esetben nem történik meg a csökkentés, és a visszatérési érték NOTHING lesz.  
     * @return OK or NOTHING
     */
    public Result clean() {
        // TODO implement here
        return null;
    }

    /**
	* Megvizsgálja a rajta található hó mennyiségét. Ha ez nulla, és található rajta jégbe fagyott tárgy, akkor meghívja az Item osztály pickMeUp(Player) függvényét. Sikeres tárgyfelvétel esetén OK-kal tér vissza, egyébként pedig NOTHING-gal.
     * @param p mezőn álló Player
     * @return OK or NOTHING
     */
    public Result pickUp(Player p) {
        // TODO implement here
        return null;
    }

    /**
	* Visszaadja az  mező teherbíró képességét. (Az elkészült játékban valószínűleg ez a függvény nem fog visszatérni a teherbírás értékével, hanem csak megjeleníti a képernyőn azt. Most a grafikus elemek hiányában illetve a jobb érthetőség kedvéért használjuk ezt a függvényt így.) 
     * @return kapacitás
     */
    public int getCapacity() {
        // TODO implement here
        return 0;
    }

}