package game;

import Display.Screen;
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
     * Az adott játékosokat tárolására szolgáló tömb, melynek nagysága 3 és 6 között helyezkedik el
     * (beleértve a határokat is).
     */
    private List<Player> players = new ArrayList<>();

    /**
     * A jelzõrakéta alkotóelemeinek (GUN, FLARE, CHARGE) tárolására szolgál.
     */
    private List<FlareGun> flare_gun = new ArrayList<>();

    private Field startField;

    public Controller controller;

    /*
     * A jegesmedvét tárolja
     * */
    private PolarBear polarbear;

    /**
     * A játék kezdetekor bekéri a játékosok számát majd sorra azoknak a karaktertípusát.
     * Létrehozza a GameBoard-ot, majd meghívja az osztály init(Player) metódusát átadva neki a játékosok számát.
     * Ezt követõen a bekért adatok alapján létrehozza az eszkimókat illetve a sarkkutatókat
     * reprezentáló osztályokat. Végül meghívja a setActualFields() metódust.
     */
    public Game() {
    }

    public void addController(Controller c){
        controller = c;
    }

    /*A játék kezdetekor bekéri a játékosok számát majd sorra azoknak a karaktertípusát.
     * Létrehozza a GameBoard-ot, majd meghívja az osztály init(int) metódusát átadva neki a játékosok számát.
     * Ezt követõen a GameBoard getStartField() metódusának segítségével lekéri a játékosok kiindulási mezõjét (bal felsõ).
     * Majd a bekért adatok alapján konstruktorukban átadva a kiindulási mezõjüket létrehozza az eszkimókat,
     * illetve a sarkkutatókat reprezentáló osztályokat.
     * Végül a GameBoard osztály getRandomField() függvényének visszatérését átadva konstruktorban létrehozza a Jegesmedvét,
     * aminek az így kapott mezõ lesz az actualfield-je.
     */
    public void init(int n) {  //szin tipus kezdomezo

        String file = "/Users/kinga/IdeaProjects/projlab/sarkvidek/src/game/pickupsame.txt";
        FileReader fr = null;
        BufferedReader br = null;
        ArrayList<String[]> fields = new ArrayList<>();
        ArrayList<String[]> neighbours = new ArrayList<>();
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String currentLine = br.readLine();
            while (currentLine != null) {
                String[] line = currentLine.split(" ");
                if (line[0].equals("setfield"))
                    fields.add(line);
                else if (line[0].equals("addfield"))
                    neighbours.add((line));
                currentLine = br.readLine();
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        gameboard.init(fields, neighbours);
        Field field;
        startField = gameboard.getStartField();

        field = gameboard.getRandomField();
        while(field == startField){
            field = gameboard.getRandomField();
        }
        polarbear = new PolarBear(field);
        field.stepOn(polarbear);
    }

    public void addPlayer(Player p) {
        players.add(p);
        startField.stepOn(p);
    }

    public Field getStartField() {
        return startField;
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
        Result lastResult = NOTHING;
        while(lastResult != DIE && lastResult != WIN) {
            lastResult = polarbear.move();
            this.controller.update();
            for (int i = 0; i < players.size() && lastResult != DIE && lastResult != WIN; i++) {
                gameboard.aging();
                this.controller.f.update();
                if (new Random().nextInt(2) < 1) {
                   lastResult = gameboard.storm();
                    this.controller.f.update();
                }
                if(lastResult != DIE && lastResult != WIN) {
                    lastResult = players.get(i).round();
                    this.controller.f.update();
                }
            }
        }
        if (lastResult == DIE) {
            this.endGame(lastResult);
        }else if (lastResult == WIN) {
            this.endGame(lastResult);
        }
    }

    public Player which(char c) {
        for (Player p : players)
            if (p.color == c)
                return p;
        return null;
    }

    /**
     * A players attribútumban tárolt játékosok számával tér vissza.
     *
     * @return int player száma
     */
    public int getPlayerNumber() {
        return players.size();
    }

    public GameBoard getGameboard(){
        return gameboard;
    }

    /**
     * A megkapott paraméter alapján eldönti, hogy hogyan végzõdik a játék, majd befejezi azt.
     *
     * @param r Result kapott eredmény, játék kimenetének eldöntéséhez
     */
    public void endGame(Result r) {
        switch (r) {
            case WIN:
                System.out.print("Victory");

                break;
            case DIE:
                System.out.print("Game Over");
                break;
        }
    }

    /**
     * A flare_gun attribútum értékét változtatja meg, mégpedig úgy, hogy hozzáad egy új FlareGun példányt a listához.
     *
     * @param f hozzáadandó FlareGun rész
     */
    public void addPart(FlareGun f) {
        flare_gun.add(f);
    }

    /**
     * Megvizsgálja, hogy a játékosok összegyûjtötték-e a három szükséges tárgyat (GUN, FLARE, CHARGE),
     * tehát három elemet tartalmaz-e a flare_gun lista. Ha igen, akkor TRUE, máskülönben FALSE értékkel fog visszatérni.
     *
     * @return true or false
     */
    public boolean haveAllParts() {
        return flare_gun.size() == 3;
    }

    /**
     * A Game adatainak kiírásáért felelõs függvény.
     * Megjeleníti a játék során már összegyûjtött FlareGun részeket és a játék összes játékosának nevét.
     */
    public void state() {
        System.out.println("Game:");
        System.out.print("flaregun: ");
        for (FlareGun f : flare_gun) {
            f.namestate();
            System.out.print(", ");
        }
        System.out.print("\n");
        System.out.print("players: ");
        for (Player p : players) {
            p.namestate();
            System.out.print(", ");
        }
        System.out.println("\n");
    }
}