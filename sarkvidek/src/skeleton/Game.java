package skeleton;

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
    public Game(List<String[]> fields, List<String[]> playerdata, String bearstartfield, ArrayList<String[]> neighbours) {
        init(fields, playerdata, bearstartfield, neighbours);
    }

    /*A j�t�k kezdetekor bek�ri a j�t�kosok sz�m�t majd sorra azoknak a karaktert�pus�t.
     * L�trehozza a GameBoard-ot, majd megh�vja az oszt�ly init(int) met�dus�t �tadva neki a j�t�kosok sz�m�t.
     * Ezt k�vet�en a GameBoard getStartField() met�dus�nak seg�ts�g�vel lek�ri a j�t�kosok kiindul�si mez�j�t (bal fels�).
     * Majd a bek�rt adatok alapj�n konstruktorukban �tadva a kiindul�si mez�j�ket l�trehozza az eszkim�kat,
     * illetve a sarkkutat�kat reprezent�l� oszt�lyokat.
     * V�g�l a GameBoard oszt�ly getRandomField() f�ggv�ny�nek visszat�r�s�t �tadva konstruktorban l�trehozza a Jegesmedv�t,
     * aminek az �gy kapott mez� lesz az actualfield-je.
     */
    public void init(List<String[]> fields, List<String[]> playerdata, String bearstartfield, ArrayList<String[]> neighbours) {  //szin tipus kezdomezo
        gameboard.init(playerdata.size(), fields, neighbours);
        for (String[] i : playerdata) {
            String[] player = i;
            if (player[2].equals("ex")){
                Field field = null;
                for(Field f : gameboard.getFields())
                    if(f.name.equals(player[3]))
                        field = f;
                players.add(new Explorer(this, field , player[1].charAt(0)));
            }else {
                Field field = null;
                for (Field f : gameboard.getFields())
                    if (f.name.equals(player[3]))
                        field = f;
                players.add(new Eskimo(this, field, player[1].charAt(0)));
            }
        }
        if(bearstartfield != null){
            Field field = null;
            for (Field f : gameboard.getFields())
                if (f.name.equals(bearstartfield))
                    field = f;
            polarbear = new PolarBear(field);
        } else
            polarbear = new PolarBear(gameboard.getRandomField());
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
        int i = 0;
        while(!activities.get(i).equals("")){
            String[] string = activities.get(i);
            switch(string[0]){
                case "state":
                    switch (string[1]){
                        case "p":
                            for(Player p : players)
                                if(p.color == 'p')
                                    p.state();
                        case "b":
                            for(Player p : players)
                                if(p.color == 'b')
                                    p.state();
                        case "g":
                            for(Player p : players)
                                if(p.color == 'g')
                                    p.state();
                        case "y":
                            for(Player p : players)
                                if(p.color == 'y')
                                    p.state();
                        case "o":
                            for(Player p : players)
                                if(p.color == 'o')
                                    p.state();
                        case "r":
                            for(Player p : players)
                                if(p.color == 'r')
                                    p.state();
                    }
                case "bear":
                    polarbear.state();
                case "storm":
                case "W":
                case "D":
                case "S":
                case "A":
                case "J":
                case "K":
                case "L":
                case "M":
                case "I":
            }
        }





        Result p_result = Result.OK, quitresult = Result.OK;
        int activity_idx = 0, bearmove_idx = 0;
        boolean hasSomeOneDiedOrWon = false;
        while(!hasSomeOneDiedOrWon && p_result == Result.OK) {

            p_result = polarbear.move(bearmove.get(bearmove_idx++));

            ListIterator<Player> i = players.listIterator();
            Result s_result = Result.OK, r_result = Result.OK;
            while(i.hasNext() &&  s_result == Result.OK && r_result == Result.OK) {
                gameboard.aging();
                if(randomstorm) {
                    if(new Random().nextInt(101) < 33)
                        s_result = gameboard.storm(null);
                }else
                    s_result = gameboard.storm(fields);

                if(s_result != Result.DIE) {
                    r_result = players.get(i.nextIndex()).round(activities.get(activity_idx++));
                    i.next();
                }
            }
            if(s_result != Result.OK) {
                hasSomeOneDiedOrWon = true;
                quitresult = s_result;
            } else if(r_result != Result.OK) {
                hasSomeOneDiedOrWon = true;
                quitresult = r_result;
            } else if(p_result != Result.OK) {
                hasSomeOneDiedOrWon = true;
                quitresult = p_result;
            }
        }
        endGame(quitresult);
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
            case WIN: System.out.print("Victory");
                break;
            case DIE: System.out.print("Game Over");
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
        return (flare_gun.size() == 3) ? true : false;
    }

}