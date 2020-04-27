package skeleton;

import java.awt.image.renderable.RenderableImage;
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

    public List<Field> getFields() {
        return fields;
    }

    /**
     * Default constructor
     */
    public GameBoard() { }

    /**
     * A már elkészített Field-eknek beállítja a szomszédait a fields tömb alapján.
     */
    public void setNeighbours(List<String[]> neighbours) {
        for(String[] i : neighbours) {
            int fieldidx = Integer.parseInt(i[1].substring(1)) - 1;
            for(int j = 2; j < i.length; j++) {
                if(i[j].equals(null))
                    fields.get(fieldidx).addNeighbour(null, j - 2);
                else
                    fields.get(fieldidx).addNeighbour(fields.get(Integer.parseInt(i[j].substring(1)) - 1), j -2);
            }
        }
    }

    /**
     * Visszatér a bal felsõ sarokban lévõ Field referenciájával. (Errõl a mezõrõl fognak elindulni a játékosok).
     *
     * @return Field-bal felsõ
     */
    public Field getStartField() {
        return fields.get(0);
    }

    /**
     * Eldönti egy adott valószínûség alapján minden egyes mezõre, hogy ott jön-e vihar.
     * Ha jön, akkor meghívja annak a mezõnek(Field) a storm() függvényét. Futás végén,
     * ha legalább egy mezõ storm() függvénye DIE-al tért vissza, akkor õ is DIE-al fog, különben pedig OK-kal.
     * @return DIE or OK
     */
    public Result storm(String[] fieldsHitByStorm) {
        Result s_result = Result.OK;
        if(fieldsHitByStorm == null) {
            for(Field f : fields) {
                if(new Random().nextInt(101) < 20) {
                    if(f.storm() == Result.DIE)
                        s_result = Result.DIE;
                }
            }
        } else {
            for(int i = 2; i < fieldsHitByStorm.length; i++) {
                if(fields.get(Integer.parseInt(fieldsHitByStorm[i].substring(1)) - 1).storm() == Result.DIE)
                    s_result = Result.DIE;
            }
        }
        return s_result;
    }

    public void init(int allplayer, List<String[]> fieldsinput, List<String[]> neighbour){
        int i = 0;
        while(fieldsinput.get(i)[0].equals("setfield"))
        {
            if(Integer.parseInt(fieldsinput.get(i)[2]) == 0) //teherbírása 0
                fields.add(new Hole(Integer.parseInt(fieldsinput.get(i)[4]), Integer.parseInt(fieldsinput.get(i)[2]))); //hó, teherbírás
            else {
                Item item = null;
                switch (fieldsinput.get(i)[3]) {
                    case "g": item = new FlareGun();
                        break;
                    case "f": item = new Food();
                        break;
                    case "s": item = new BreakableShovel();
                        break;
                    case "b": item = new Shovel();
                            break;
                    case "r": item = new Rope();
                            break;
                    case "d": item = new DivingSuit();
                        break;
                    case "t": item = new Tent();
                            break;
                }
                 fields.add(new IceField(Integer.parseInt(fieldsinput.get(i)[4]), Integer.parseInt(fieldsinput.get(i)[2]), item));
            }
        }
        setNeighbours(neighbour);
    }

    public Field getRandomField(){
        return fields.get(new Random().nextInt(fields.size()));
    }

    public void aging() {
        for(Field f: fields)
            f.aging();
    }
}