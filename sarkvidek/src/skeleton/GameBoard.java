package skeleton;

import java.util.*;

/**
 * Létrehozza, inicializálja, összefogja s egyben tárolja az összes mezőt. Ha az adott körben úgy adta a gép, hogy lesz hóvihar, akkor az előzőek mellett kezeli azt is, hogy melyik mezőkre fog leesni egy réteg hó.
 */
public class GameBoard {

    /**
     * Default constructor
     */
    public GameBoard() {
    }

	/**
     * A táblához tartozó mezők tárolására szolgál.
     */
    private Field[] fields;

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
        // TODO implement here
        return null;
    }

}