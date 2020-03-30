package skeleton;

import java.util.*;

/**
 * Létrehozza, inicializálja, összefogja s egyben tárolja az összes mezõt. Ha az adott körben úgy adta a gép,
 * hogy lesz hóvihar, akkor az elõzõek mellett kezeli azt is, hogy melyik mezõkre fog leesni egy réteg hó.
 */
public class GameBoard {
    /**
     * A táblához tartozó mezõk tárolására szolgál.
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
        setNeighbours();
    }

    /**
     * A már elkészített Field-eknek beállítja a szomszédait a fields tömb alapján.
     */
    public void setNeighbours() {
        fields.get(0).addNeighbour(fields.get(1), Direction.DOWN);
    }

    /**
     * Visszatér a bal felsõ sarokban lévõ Field referenciájával. (Errõl a mezõrõl fognak elindulni a játékosok).
     *
     * @return Field-bal felsõ
     */
    public Field getStartField() {
        // TODO implement here
        return null;
    }

    /**
     * Eldönti egy adott valószínûség alapján minden egyes mezõre, hogy ott jön-e vihar.
     * Ha jön, akkor meghívja annak a mezõnek(Field) a storm() függvényét. Futás végén,
     * ha legalább egy mezõ storm() függvénye DIE-al tért vissza, akkor õ is DIE-al fog, különben pedig OK-kal.
     *
     * @return DIE or OK
     */
    public Result storm() {
        System.out.print(this.toString() + ".storm()\n");
        Result r = Result.OK;
        for (Field f : fields)
            r = f.storm();
        System.out.print(this.toString() + ".storm() returned Result r;\n\n");
        return r;
    }

}