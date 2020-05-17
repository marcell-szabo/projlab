package game;

import Display.Frame;
import controller.Controller;

import java.io.*;
import java.util.*;

import static game.Result.*;

/**
 * A játék elkezdésére/inicializálására, befejezésére, illetve a körök kezelésére szolgáló osztály.
 * A viharok feltámadásnak valószínûségeit, és annak lebonyolításának kezdetét is ez az osztály kezeli.
 */
public class Game {

    /**
     * A játéktáblát tárolja.
     */
    private GameBoard gameboard = new GameBoard();

    /**
     * Az adott játékosok tárolására szolgáló tömb, melynek nagysága 3 és 6 között helyezkedik el
     * (beleértve a határokat is).
     */
    private List<Player> players = new ArrayList<>();

    /**
     * A jelzõrakéta alkotóelemeinek (GUN, FLARE, CHARGE) tárolására szolgál.
     */
    private List<FlareGun> flare_gun = new ArrayList<>();

    /**
     * A játék kezdetén a játékosok kezdõmezeje.
     */
    private Field startField;

    /**
     * Kontroller, ami a lenyomott billentyûkkel való vezérlést végzi
     */
    public Controller controller;

    /*
     * A jegesmedvét tárolja
     * */
    private PolarBear polarbear;

    //Az értesítési sáv értékeit tárolja.
    public String actualPlayer = null;
    public String actualSnow  = null;
    public String actualWork = null;
    public String actualHeat = null;
    public String examinedField = null;
    public String examinedCapacity = null;
    /**
     * A játék kezdetekor bekéri a játékosok számát majd sorra azoknak a karaktertípusát.
     * Létrehozza a GameBoard-ot, majd meghívja az osztály init(Player) metódusát átadva neki a játékosok számát.
     * Ezt követõen a bekért adatok alapján létrehozza az eszkimókat illetve a sarkkutatókat
     * reprezentáló osztályokat. Végül meghívja a setActualFields() metódust.
     */
    public Game() {}

    /**
     * Setter függvény, beállítja a kapott kontroller példányra az osztály kontrollerét.
     * @param c - Controller példány
     */
    public void addController(Controller c){
        controller = c;
    }

    /**
     * Beolvassa a pályát a pályát tartalmazó fájlból, és ez alapján létrehozza a mezõket és beállítja a szomszédokat.
     * Ezután meghívja a GameBoard initjét, majd beállítja a jegesmedvét.
     */
    public void init() {
        ArrayList<String[]> fields = new ArrayList<>();
        ArrayList<String[]> neighbours = new ArrayList<>();
        try {
            InputStream in = getClass().getResourceAsStream("/map.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String currentLine = reader.readLine();
            while (currentLine != null) {
                String[] line = currentLine.split(" ");
                if (line[0].equals("setfield"))
                    fields.add(line);
                else if (line[0].equals("addfield"))
                    neighbours.add((line));
                currentLine = reader.readLine();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        gameboard.init(fields, neighbours);
        startField = gameboard.getStartField();

        //A jegesmedve startmezõjét állítja be úgy, hogy az véletlenül se legyen a játékosok startmezeje.
        Field field = gameboard.getRandomField();
        while(field == startField){
            field = gameboard.getRandomField();
        }
        polarbear = new PolarBear(field);
        field.stepOn(polarbear);
    }

    /**
     * Hozzáad egy játékost a játékosok tömbjéhez.
     * @param p - A hozzáadandó játékos.
     */
    public void addPlayer(Player p) {
        players.add(p);
        startField.stepOn(p);
    }

    /**
     * Getter függvény, visszaadja a kezdõmezõt.
     * @return
     */
    public Field getStartField() {
        return startField;
    }


    /**
     * Ciklusban hivogatja meg a játékosok köreinek lezajlás?áért felelõs függvényeket.
     * A ciklus minden lefutása során elõször lépteti a jegesmedvét és egy adott valósznûség alapján eldönti hogy jön-e vihar.
     * Ha jön, akkor meghívja a Gameboard storm() függvényét.
     * Ha ez nem DIE-al tért vissza, akkor meghívja a Player osztály round() metódusát.
     * Amennyiben ez bármikor DIE vagy WIN visszatérési értéket ad, vagy már korábban a storm() vagy a jegesmedve DIE-al tért vissza,
     * akkor kilép a ciklusból. (Ciklusban maradáshoz OK visszatérési érték kell. NOTHING-nak itt nincs szerepe.)
     */
    public Result mainLoop(Frame frame) {
        Result lastResult = NOTHING;
        while(lastResult != DIE && lastResult != WIN) {
            lastResult = polarbear.move();
            if(lastResult == DIE)
                return DIE;
            gameboard.aging();
            frame.update(frame.getGraphics());
            if (new Random().nextInt(5) < 1) {
                lastResult = gameboard.storm();
            }
            frame.update(frame.getGraphics());
            for (int i = 0; i < players.size() && lastResult != DIE && lastResult != WIN; i++) {
                actualPlayer = which(players.get(i));
                lastResult = players.get(i).round(frame);
            }
        }
        if (lastResult == DIE) {
            return DIE;
        }else if (lastResult == WIN) {
            return WIN;
        }
        return NOTHING;
    }

    /**
     * Visszaadja a kapott játékos színének stringjét, ez az állapotsávon fog látszani.
     * @param p - a játékos akinek a színét keressük
     * @return
     */
    public String which(Player p) {
        switch (p.getColor()){
            case 'p':
                return "Purple";
            case 'b':
                return "Blue";
            case 'g':
                return "Green";
            case 'o':
                return "Orange";
            case 'y':
                return "Yellow";
            case 'r':
                return "Red";
            default:
                return null;
        }

    }

    /**
     * A players attribútumban tárolt játékosok számával tér vissza.
     * @return int player száma
     */
    public int getPlayerNumber() {
        return players.size();
    }

    /**
     * Getter függvény, visszaadja a GameBoardot.
     * @return GameBoard objektum
     */
    public GameBoard getGameboard(){
        return gameboard;
    }


    /**
     * A flare_gun attribútum értékét változtatja meg, mégpedig úgy, hogy hozzáad egy új FlareGun példányt a listához.
     * @param f hozzáadandó FlareGun rész
     */
    public void addPart(FlareGun f) {
        flare_gun.add(f);
    }

    /**
     * Megvizsgálja, hogy a játékosok összegyûjtötték-e a három szükséges tárgyat (GUN, FLARE, CHARGE),
     * tehát három elemet tartalmaz-e a flare_gun lista. Ha igen, akkor TRUE, máskülönben FALSE értékkel fog visszatérni.
     * @return true or false
     */
    public boolean haveAllParts() {
        return flare_gun.size() == 3;
    }

}