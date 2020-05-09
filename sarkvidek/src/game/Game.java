package game;

import Display.Frame;
import controller.Controller;

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

    public Controller controller;

    /*
     * A jegesmedv�t t�rolja
     * */
    private PolarBear polarbear;

    public String actualPlayer = null;
    public String actualSnow  = null;
    public String actualWork = null;
    public String actualHeat = null;
    public String examinedField = null;
    public String examinedCapacity = null;
    /**
     * A j�t�k kezdetekor bek�ri a j�t�kosok sz�m�t majd sorra azoknak a karaktert�pus�t.
     * L�trehozza a GameBoard-ot, majd megh�vja az oszt�ly init(Player) met�dus�t �tadva neki a j�t�kosok sz�m�t.
     * Ezt k�vet�en a bek�rt adatok alapj�n l�trehozza az eszkim�kat illetve a sarkkutat�kat
     * reprezent�l� oszt�lyokat. V�g�l megh�vja a setActualFields() met�dust.
     */
    public Game() {
    }

    public void addController(Controller c){
        controller = c;
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

        String file = Objects.requireNonNull(getClass().getClassLoader().getResource("pickupsame.txt")).getFile();
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
     * Ciklusban h�vogatja meg a j�t�kosok k�reinek lezajl�s��rt felel�s f�ggv�nyeket.
     * A ciklus minden lefut�sa sor�n el�sz�r egy adott val�sz�n�s�g alapj�n eld�nti hogy j�n-e vihar.
     * Ha j�n, akkor megh�vja a Gameboard storm() f�ggv�ny�t (ellenkez� esetben ez a f�ggv�nyh�v�s kimarad).
     * Ha ez nem DIE-al t�rt vissza, akkor megh�vja a Player oszt�ly round() met�dus�t.
     * Amennyiben ez b�rmikor DIE vagy WIN visszat�r�si �rt�ket ad, vagy m�r kor�bban a storm() DIE-al t�rt vissza,
     * akkor kil�p a ciklusb�l. (Ciklusban marad�shoz OK visszat�r�si �rt�k kell. NOTHING-nak itt nincs szerepe.).
     * V�gezet�l az endGame(Result) f�ggv�ny ker�l megh�v�sra .
     */
    public Result mainLoop(Frame frame) {
        Result lastResult = NOTHING;
        while(lastResult != DIE && lastResult != WIN) {
            lastResult = polarbear.move();
            gameboard.aging();
            frame.paintComponents(frame.getGraphics());
            if (new Random().nextInt(5) < 1) {
                lastResult = gameboard.storm();
            }
            frame.paintComponents(frame.getGraphics());
            for (int i = 0; i < players.size() && lastResult != DIE && lastResult != WIN; i++) {
                //actualPlayer = which(players.get(i));
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
     * A players attrib�tumban t�rolt j�t�kosok sz�m�val t�r vissza.
     *
     * @return int player sz�ma
     */
    public int getPlayerNumber() {
        return players.size();
    }

    public GameBoard getGameboard(){
        return gameboard;
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

}