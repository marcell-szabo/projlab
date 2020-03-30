package skeleton;

import java.awt.desktop.SystemSleepEvent;
import java.util.*;

/**
 * A j�t�k elkezd�s�re/inicializ�l�s�ra, befejez�s�re, illetve a k�r�k kezel�s�re szolg�l� oszt�ly.
 * A viharok felt�mad�snak val�sz�n�s�geit, �s annak lebonyol�t�s�nak kezdet�t is ez az oszt�ly kezeli.
 */
public class Game {

    /**
     * A j�t�kt�bl�t t�rolja.
     */
    private GameBoard gameboard;

    /**
     * Az adott j�t�kosokat t�rol�s�ra szolg�l� t�mb, melynek nagys�ga 3 �s 6 k�z�tt helyezkedik el
     * (bele�rtve a hat�rokat is).
     */
    private List<Player> players = new ArrayList<>();

    /**
     * A jelz�rak�ta alkot�elemeinek (GUN, FLARE, CHARGE) t�rol�s�ra szolg�l.
     */
    private List<FlareGun> flare_gun = new ArrayList<>();

    /**
     * A j�t�k kezdetekor bek�ri a j�t�kosok sz�m�t majd sorra azoknak a karaktert�pus�t.
     * L�trehozza a GameBoard-ot, majd megh�vja az oszt�ly init(Player) met�dus�t �tadva neki a j�t�kosok sz�m�t.
     * Ezt k�vet�en a bek�rt adatok alapj�n l�trehozza az eszkim�kat illetve a sarkkutat�kat
     * reprezent�l� oszt�lyokat. V�g�l megh�vja a setActualFields() met�dust.
     */
    public Game() {
        gameboard = new GameBoard(2);
        players.add(new Eskimo(this, gameboard.getStartField()));
        players.add(new Explorer(this, gameboard.getStartField()));
    }

    /**
     * A kor�bban l�trehozott Player p�ld�nyoknak �ll�tja be az actualfield attrib�tum�t.
     * Ehhez lek�ri a kezd� mez� referenci�j�t a GameBoard-t�l a getStartField() f�ggv�ny seg�ts�g�vel.
     */
    public void setActualFields() {
        // TODO implement here
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
    public void mainLoop() {
        // TODO implement here
    }

    /**
     * A players attrib�tumban t�rolt j�t�kosok sz�m�val t�r vissza.
     *
     * @return int player sz�ma
     */
    public int getPlayerNumber() {
        System.out.print(this.toString() + ".getPlayerNumber();\n");
        System.out.print(this.toString() + ".getPlayerNumber() returned int n;\n");
        return 0;
    }

    /**
     * A megkapott param�ter alapj�n eld�nti, hogy hogyan v�gz�dik a j�t�k, majd befejezi azt.
     *
     * @param r Result kapott eredm�ny, j�t�k kimenet�nek eld�nt�s�hez
     */
    public void endGame(Result r) {
        // TODO implement here
    }

    /**
     * A flare_gun attrib�tum �rt�k�t v�ltoztatja meg, m�gpedig �gy, hogy hozz�ad egy �j FlareGun p�ld�nyt a list�hoz.
     *
     * @param f hozz�adand� FlareGun r�sz
     */
    public void addPart(FlareGun f) {
        System.out.println(this.toString() + ".addPart(f);");
        System.out.println(this.toString() + ".addPart(f) returned;");
        return;
    }

    /**
     * Megvizsg�lja, hogy a j�t�kosok �sszegy�jt�tt�k-e a h�rom sz�ks�ges t�rgyat (GUN, FLARE, CHARGE),
     * teh�t h�rom elemet tartalmaz-e a flare_gun lista. Ha igen, akkor TRUE, m�sk�l�nben FALSE �rt�kkel fog visszat�rni.
     *
     * @return true or false
     */
    public boolean haveAllParts() {
        System.out.print(this.toString() + ".haveAllParts();\n");
        System.out.print(this.toString() + "haveAllParts() returned boolean b;\n");
        return false;
    }

}