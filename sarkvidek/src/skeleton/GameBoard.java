package skeleton;

import java.util.*;

/**
 * Létrehozza, inicializálja, összefogja s egyben tárolja az összes mezőt. Ha az adott körben úgy adta a gép, hogy lesz hóvihar, akkor az előzőek mellett kezeli azt is, hogy melyik mezőkre fog leesni egy réteg hó.
 */
public class GameBoard {
	/**
     * A táblához tartozó mezők tárolására szolgál.
     */
    private List<Field> fields = new ArrayList<>();

    /**
     * Default constructor
     */
    public GameBoard(int allplayer) {
        //csak proba, majd sok objektum lesz
        Hole h = new Hole();
        fields.add(h);
        IceField icef = new IceField();
        fields.add(icef);
    }

    /**
	* Az átvett játékos-szám alapján létrehozza a mezőket majd eltárolja azokat fields tömbben. Végül meghívja a setNeighbours() függvényt.
     * @param allplayer összes játékos száma
     */
    public void init(int allplayer) {
        // TODO implement here
    }

    /**
     * A már elkészített Field-eknek beállítja a szomszédait a fields tömb alapján. 
     */
    public void setNeighbours() {
        // TODO implement here
    }

    /**
	* Visszatér a bal felső sarokban lévő Field referenciájával. (Erről a mezőről fognak elindulni a játékosok).
     * @return Field-bal felső
     */
    public Field getStartField() {
        // TODO implement here
        return null;
    }

    /**
	* Eldönti egy adott valószínűség alapján minden egyes mezőre, hogy ott jön-e vihar. Ha jön, akkor meghívja annak a mezőnek(Field) a storm() függvényét. Futás végén, ha legalább egy mező storm() függvénye DIE-al tért vissza, akkor ő is DIE-al fog, különben pedig OK-kal.
     * @return DIE or OK
     */
    public Result storm() {
        System.out.print(this.toString() + ".storm()\n" );
        Result r = Result.OK;
        for (Field f: fields)
            r = f.storm();
        System.out.print(this.toString() + ".storm() returned Result r;\n");
        return r;
    }

}