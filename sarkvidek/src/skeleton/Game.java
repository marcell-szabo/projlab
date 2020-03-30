package skeleton;

import java.awt.desktop.SystemSleepEvent;
import java.util.*;

/**
 * A játék elkezdésére/inicializálására, befejezésére, illetve a körök kezelésére szolgáló osztály.
 * A viharok feltámadásnak valószínûségeit, és annak lebonyolításának kezdetét is ez az osztály kezeli.
 */
public class Game {

    /**
     * A játéktáblát tárolja.
     */
    private GameBoard gameboard;

    /**
     * Az adott játékosokat tárolására szolgáló tömb, melynek nagysága 3 és 6 között helyezkedik el
     * (beleértve a határokat is).
     */
    private List<Player> players = new ArrayList<>();

    /**
     * A jelzõrakéta alkotóelemeinek (GUN, FLARE, CHARGE) tárolására szolgál.
     */
    private List<FlareGun> flare_gun = new ArrayList<>();

    /**
     * A játék kezdetekor bekéri a játékosok számát majd sorra azoknak a karaktertípusát.
     * Létrehozza a GameBoard-ot, majd meghívja az osztály init(Player) metódusát átadva neki a játékosok számát.
     * Ezt követõen a bekért adatok alapján létrehozza az eszkimókat illetve a sarkkutatókat
     * reprezentáló osztályokat. Végül meghívja a setActualFields() metódust.
     */
    public Game() {
        gameboard = new GameBoard(2);
        players.add(new Eskimo(this, gameboard.getStartField()));
        players.add(new Explorer(this, gameboard.getStartField()));
    }

    /**
     * A korábban létrehozott Player példányoknak állítja be az actualfield attribútumát.
     * Ehhez lekéri a kezdõ mezõ referenciáját a GameBoard-tól a getStartField() függvény segítségével.
     */
    public void setActualFields() {
        // TODO implement here
    }

    /**
     * Ciklusban hívogatja meg a játékosok köreinek lezajlásáért felelõs függvényeket.
     * A ciklus minden lefutása során elõször egy adott valószínûség alapján eldönti hogy jön-e vihar.
     * Ha jön, akkor meghívja a Gameboard storm() függvényét (ellenkezõ esetben ez a függvényhívás kimarad).
     * Ha ez nem DIE-al tért vissza, akkor meghívja a Player osztály round() metódusát.
     * Amennyiben ez bármikor DIE vagy WIN visszatérési értéket ad, vagy már korábban a storm() DIE-al tért vissza,
     * akkor kilép a ciklusból. (Ciklusban maradáshoz OK visszatérési érték kell. NOTHING-nak itt nincs szerepe.).
     * Végezetül az endGame(Result) függvény kerül meghívásra .
     */
    public void mainLoop() {
        // TODO implement here
    }

    /**
     * A players attribútumban tárolt játékosok számával tér vissza.
     *
     * @return int player száma
     */
    public int getPlayerNumber() {
        System.out.print(this.toString() + ".getPlayerNumber();\n");
        System.out.print(this.toString() + ".getPlayerNumber() returned int n;\n");
        return 0;
    }

    /**
     * A megkapott paraméter alapján eldönti, hogy hogyan végzõdik a játék, majd befejezi azt.
     *
     * @param r Result kapott eredmény, játék kimenetének eldöntéséhez
     */
    public void endGame(Result r) {
        // TODO implement here
    }

    /**
     * A flare_gun attribútum értékét változtatja meg, mégpedig úgy, hogy hozzáad egy új FlareGun példányt a listához.
     *
     * @param f hozzáadandó FlareGun rész
     */
    public void addPart(FlareGun f) {
        System.out.println(this.toString() + ".addPart(f);");
        System.out.println(this.toString() + ".addPart(f) returned;");
        return;
    }

    /**
     * Megvizsgálja, hogy a játékosok összegyûjtötték-e a három szükséges tárgyat (GUN, FLARE, CHARGE),
     * tehát három elemet tartalmaz-e a flare_gun lista. Ha igen, akkor TRUE, máskülönben FALSE értékkel fog visszatérni.
     *
     * @return true or false
     */
    public boolean haveAllParts() {
        System.out.print(this.toString() + ".haveAllParts();\n");
        System.out.print(this.toString() + "haveAllParts() returned boolean b;\n");
        return false;
    }

}