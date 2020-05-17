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
     * Az adott j�t�kosok t�rol�s�ra szolg�l� t�mb, melynek nagys�ga 3 �s 6 k�z�tt helyezkedik el
     * (bele�rtve a hat�rokat is).
     */
    private List<Player> players = new ArrayList<>();

    /**
     * A jelz�rak�ta alkot�elemeinek (GUN, FLARE, CHARGE) t�rol�s�ra szolg�l.
     */
    private List<FlareGun> flare_gun = new ArrayList<>();

    /**
     * A j�t�k kezdet�n a j�t�kosok kezd�mezeje.
     */
    private Field startField;

    /**
     * Kontroller, ami a lenyomott billenty�kkel val� vez�rl�st v�gzi
     */
    public Controller controller;

    /*
     * A jegesmedv�t t�rolja
     * */
    private PolarBear polarbear;

    //Az �rtes�t�si s�v �rt�keit t�rolja.
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
    public Game() {}

    /**
     * Setter f�ggv�ny, be�ll�tja a kapott kontroller p�ld�nyra az oszt�ly kontroller�t.
     * @param c - Controller p�ld�ny
     */
    public void addController(Controller c){
        controller = c;
    }

    /**
     * Beolvassa a p�ly�t a p�ly�t tartalmaz� f�jlb�l, �s ez alapj�n l�trehozza a mez�ket �s be�ll�tja a szomsz�dokat.
     * Ezut�n megh�vja a GameBoard initj�t, majd be�ll�tja a jegesmedv�t.
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

        //A jegesmedve startmez�j�t �ll�tja be �gy, hogy az v�letlen�l se legyen a j�t�kosok startmezeje.
        Field field = gameboard.getRandomField();
        while(field == startField){
            field = gameboard.getRandomField();
        }
        polarbear = new PolarBear(field);
        field.stepOn(polarbear);
    }

    /**
     * Hozz�ad egy j�t�kost a j�t�kosok t�mbj�hez.
     * @param p - A hozz�adand� j�t�kos.
     */
    public void addPlayer(Player p) {
        players.add(p);
        startField.stepOn(p);
    }

    /**
     * Getter f�ggv�ny, visszaadja a kezd�mez�t.
     * @return
     */
    public Field getStartField() {
        return startField;
    }


    /**
     * Ciklusban hivogatja meg a j�t�kosok k�reinek lezajl�s?��rt felel�s f�ggv�nyeket.
     * A ciklus minden lefut�sa sor�n el�sz�r l�pteti a jegesmedv�t �s egy adott val�szn�s�g alapj�n eld�nti hogy j�n-e vihar.
     * Ha j�n, akkor megh�vja a Gameboard storm() f�ggv�ny�t.
     * Ha ez nem DIE-al t�rt vissza, akkor megh�vja a Player oszt�ly round() met�dus�t.
     * Amennyiben ez b�rmikor DIE vagy WIN visszat�r�si �rt�ket ad, vagy m�r kor�bban a storm() vagy a jegesmedve DIE-al t�rt vissza,
     * akkor kil�p a ciklusb�l. (Ciklusban marad�shoz OK visszat�r�si �rt�k kell. NOTHING-nak itt nincs szerepe.)
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
     * Visszaadja a kapott j�t�kos sz�n�nek stringj�t, ez az �llapots�von fog l�tszani.
     * @param p - a j�t�kos akinek a sz�n�t keress�k
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
     * A players attrib�tumban t�rolt j�t�kosok sz�m�val t�r vissza.
     * @return int player sz�ma
     */
    public int getPlayerNumber() {
        return players.size();
    }

    /**
     * Getter f�ggv�ny, visszaadja a GameBoardot.
     * @return GameBoard objektum
     */
    public GameBoard getGameboard(){
        return gameboard;
    }


    /**
     * A flare_gun attrib�tum �rt�k�t v�ltoztatja meg, m�gpedig �gy, hogy hozz�ad egy �j FlareGun p�ld�nyt a list�hoz.
     * @param f hozz�adand� FlareGun r�sz
     */
    public void addPart(FlareGun f) {
        flare_gun.add(f);
    }

    /**
     * Megvizsg�lja, hogy a j�t�kosok �sszegy�jt�tt�k-e a h�rom sz�ks�ges t�rgyat (GUN, FLARE, CHARGE),
     * teh�t h�rom elemet tartalmaz-e a flare_gun lista. Ha igen, akkor TRUE, m�sk�l�nben FALSE �rt�kkel fog visszat�rni.
     * @return true or false
     */
    public boolean haveAllParts() {
        return flare_gun.size() == 3;
    }

}