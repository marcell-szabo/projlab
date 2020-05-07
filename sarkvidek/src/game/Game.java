package game;

import java.io.*;
import java.util.*;

import static game.Result.*;

/**
 * A j�t�k elkezd�s�re/inicializ�l�s�ra, befejez�s�re, illetve a k�r�k kezel�s�re szolg�l� oszt�ly.
 * A viharok felt�mad�snak val�sz�n�s�geit, �s annak lebonyol�t�s�nak kezdet�t is ez az oszt�ly kezeli.
 */
public class Game {

    /**
     * A j�t�kt�bl�t t�rolja.
     */
    private GameBoard gameboard = new GameBoard();

    /**
     * Az adott j�t�kosokat t�rol�s�ra szolg�l� t�mb, melynek nagys�ga 3 �s 6 k�z�tt helyezkedik el
     * (bele�rtve a hat�rokat is).
     */
    private List<Player> players = new ArrayList<>();

    /**
     * A jelz�rak�ta alkot�elemeinek (GUN, FLARE, CHARGE) t�rol�s�ra szolg�l.
     */
    private List<FlareGun> flare_gun = new ArrayList<>();

    private Field startField;

    /*
     * A jegesmedv�t t�rolja
     * */
    private PolarBear polarbear;

    /**
     * A j�t�k kezdetekor bek�ri a j�t�kosok sz�m�t majd sorra azoknak a karaktert�pus�t.
     * L�trehozza a GameBoard-ot, majd megh�vja az oszt�ly init(Player) met�dus�t �tadva neki a j�t�kosok sz�m�t.
     * Ezt k�vet�en a bek�rt adatok alapj�n l�trehozza az eszkim�kat illetve a sarkkutat�kat
     * reprezent�l� oszt�lyokat. V�g�l megh�vja a setActualFields() met�dust.
     */
    public Game() {
    }

    /*A j�t�k kezdetekor bek�ri a j�t�kosok sz�m�t majd sorra azoknak a karaktert�pus�t.
     * L�trehozza a GameBoard-ot, majd megh�vja az oszt�ly init(int) met�dus�t �tadva neki a j�t�kosok sz�m�t.
     * Ezt k�vet�en a GameBoard getStartField() met�dus�nak seg�ts�g�vel lek�ri a j�t�kosok kiindul�si mez�j�t (bal fels�).
     * Majd a bek�rt adatok alapj�n konstruktorukban �tadva a kiindul�si mez�j�ket l�trehozza az eszkim�kat,
     * illetve a sarkkutat�kat reprezent�l� oszt�lyokat.
     * V�g�l a GameBoard oszt�ly getRandomField() f�ggv�ny�nek visszat�r�s�t �tadva konstruktorban l�trehozza a Jegesmedv�t,
     * aminek az �gy kapott mez� lesz az actualfield-je.
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
        polarbear = new PolarBear(field);
        field.stepOn(polarbear);
    }

    public void addPlayer(Player p) {
        players.add(p);
    }

    public Field getStartField() {
        return startField;
    }


    /**
     * Ciklusban h�vogatja meg a j�t�kosok k�reinek lezajl�s��rt felel�s f�ggv�nyeket.
     * A ciklus minden lefut�sa sor�n el�sz�r egy adott val�sz�n�s�g alapj�n eld�nti hogy j�n-e vihar.
     * Ha j�n, akkor megh�vja a Gameboard storm() f�ggv�ny�t (ellenkez� esetben ez a f�ggv�nyh�v�s kimarad).
     * Ha ez nem DIE-al t�rt vissza, akkor megh�vja a Player oszt�ly round() met�dus�t.
     * Amennyiben ez b�rmikor DIE vagy WIN visszat�r�si �rt�ket ad, vagy m�r kor�bban a storm() DIE-al t�rt vissza,
     * akkor kil�p a ciklusb�l. (Ciklusban marad�shoz OK visszat�r�si �rt�k kell. NOTHING-nak itt nincs szerepe.).
     * V�gezet�l az endGame(Result) f�ggv�ny ker�l megh�v�sra .
     */
    public void mainLoop(ArrayList<String[]> activities) {
        Result lastResult = NOTHING;
        for (int i = 0; i < activities.size(); i++) {
            String[] command = activities.get(i);
            Player player;
            switch (command[0]) {
                case "state":
                    switch (command[1]) {
                        case "p":
                            player = which('p');
                            player.state();
                            break;
                        case "b":
                            player = which('b');
                            player.state();
                            break;
                        case "g":
                            player = which('g');
                            player.state();
                            break;
                        case "y":
                            player = which('y');
                            player.state();
                            break;
                        case "o":
                            player = which('o');
                            player.state();
                            break;
                        case "r":
                            player = which('r');
                            player.state();
                            break;
                        default:
                            if (command[1].charAt(0) == 'f') {
                                for (Field f : gameboard.getFields()) {
                                    if (f.name.equals(command[1])) {
                                        f.state();
                                        break;
                                    }
                                }
                                break;
                            } else if (command[1].equals("polarbear")) {
                                polarbear.state();
                                break;
                            } else if (command[1].equals("game")) {
                                this.state();
                                break;
                            }
                            break;

                    }
                    break;
                case "bear":
                    if (command[1].equals("r")) {
                        lastResult = polarbear.move();
                        break;
                    } else {
                        lastResult = polarbear.move(Integer.parseInt(command[2]));
                        break;
                    }
                case "storm":
                    if (command[1].equals("r")) {
                        lastResult = gameboard.storm(null);
                        break;
                    } else {
                        ArrayList<String> stormfield = new ArrayList<>();
                        for (String s : command)
                            if (s.charAt(0) == 'f')
                                stormfield.add(s);
                        lastResult = gameboard.storm(stormfield);
                        break;
                    }
                case "lastresult":
                    System.out.println(lastResult);
                    break;
                default:
                    player = which(command[1].charAt(0));
                    lastResult = player.round(command);
                    break;
            }
            if (lastResult == DIE) {
                this.endGame(lastResult);
                break;
            } else if (lastResult == WIN) {
                this.endGame(lastResult);
                break;
            }
        }

    }

    public Player which(char c) {
        for (Player p : players)
            if (p.color == c)
                return p;
        return null;
    }

    /**
     * A players attrib�tumban t�rolt j�t�kosok sz�m�val t�r vissza.
     *
     * @return int player sz�ma
     */
    public int getPlayerNumber() {
        return players.size();
    }

    /**
     * A megkapott param�ter alapj�n eld�nti, hogy hogyan v�gz�dik a j�t�k, majd befejezi azt.
     *
     * @param r Result kapott eredm�ny, j�t�k kimenet�nek eld�nt�s�hez
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
     * A flare_gun attrib�tum �rt�k�t v�ltoztatja meg, m�gpedig �gy, hogy hozz�ad egy �j FlareGun p�ld�nyt a list�hoz.
     *
     * @param f hozz�adand� FlareGun r�sz
     */
    public void addPart(FlareGun f) {
        flare_gun.add(f);
    }

    /**
     * Megvizsg�lja, hogy a j�t�kosok �sszegy�jt�tt�k-e a h�rom sz�ks�ges t�rgyat (GUN, FLARE, CHARGE),
     * teh�t h�rom elemet tartalmaz-e a flare_gun lista. Ha igen, akkor TRUE, m�sk�l�nben FALSE �rt�kkel fog visszat�rni.
     *
     * @return true or false
     */
    public boolean haveAllParts() {
        return flare_gun.size() == 3;
    }

    /**
     * A Game adatainak ki�r�s��rt felel�s f�ggv�ny.
     * Megjelen�ti a j�t�k sor�n m�r �sszegy�jt�tt FlareGun r�szeket �s a j�t�k �sszes j�t�kos�nak nev�t.
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