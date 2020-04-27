package skeleton;

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
    public Game(List<String[]> fields, List<String[]> playerdata, String bearstartfield, ArrayList<String[]> neighbours) {
        init(fields, playerdata, bearstartfield, neighbours);
    }

    /*A játék kezdetekor bekéri a játékosok számát majd sorra azoknak a karaktertípusát.
     * Létrehozza a GameBoard-ot, majd meghívja az osztály init(int) metódusát átadva neki a játékosok számát.
     * Ezt követõen a GameBoard getStartField() metódusának segítségével lekéri a játékosok kiindulási mezõjét (bal felsõ).
     * Majd a bekért adatok alapján konstruktorukban átadva a kiindulási mezõjüket létrehozza az eszkimókat,
     * illetve a sarkkutatókat reprezentáló osztályokat.
     * Végül a GameBoard osztály getRandomField() függvényének visszatérését átadva konstruktorban létrehozza a Jegesmedvét,
     * aminek az így kapott mezõ lesz az actualfield-je.
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
     * Ciklusban hívogatja meg a játékosok köreinek lezajlásáért felelõs függvényeket.
     * A ciklus minden lefutása során elõször egy adott valószínûség alapján eldönti hogy jön-e vihar.
     * Ha jön, akkor meghívja a Gameboard storm() függvényét (ellenkezõ esetben ez a függvényhívás kimarad).
     * Ha ez nem DIE-al tért vissza, akkor meghívja a Player osztály round() metódusát.
     * Amennyiben ez bármikor DIE vagy WIN visszatérési értéket ad, vagy már korábban a storm() DIE-al tért vissza,
     * akkor kilép a ciklusból. (Ciklusban maradáshoz OK visszatérési érték kell. NOTHING-nak itt nincs szerepe.).
     * Végezetül az endGame(Result) függvény kerül meghívásra .
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
     * A players attribútumban tárolt játékosok számával tér vissza.
     *
     * @return int player száma
     */
    public int getPlayerNumber() {
        return players.size();
    }

    /**
     * A megkapott paraméter alapján eldönti, hogy hogyan végzõdik a játék, majd befejezi azt.
     *
     * @param r Result kapott eredmény, játék kimenetének eldöntéséhez
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
        return (flare_gun.size() == 3) ? true : false;
    }

}