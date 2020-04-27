package skeleton;

import java.awt.image.renderable.RenderableImage;
import java.util.*;

/**
 * L�trehozza, inicializ�lja, �sszefogja s egyben t�rolja az �sszes mez�t. Ha az adott k�rben �gy adta a g�p,
 * hogy lesz h�vihar, akkor az el�z�ek mellett kezeli azt is, hogy melyik mez�kre fog leesni egy r�teg h�.
 */
public class GameBoard {
    /**
     * A t�bl�hoz tartoz� mez�k t�rol�s�ra szolg�l.
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
     * A m�r elk�sz�tett Field-eknek be�ll�tja a szomsz�dait a fields t�mb alapj�n.
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
     * Visszat�r a bal fels� sarokban l�v� Field referenci�j�val. (Err�l a mez�r�l fognak elindulni a j�t�kosok).
     *
     * @return Field-bal fels�
     */
    public Field getStartField() {
        return fields.get(0);
    }

    /**
     * Eld�nti egy adott val�sz�n�s�g alapj�n minden egyes mez�re, hogy ott j�n-e vihar.
     * Ha j�n, akkor megh�vja annak a mez�nek(Field) a storm() f�ggv�ny�t. Fut�s v�g�n,
     * ha legal�bb egy mez� storm() f�ggv�nye DIE-al t�rt vissza, akkor � is DIE-al fog, k�l�nben pedig OK-kal.
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
            if(Integer.parseInt(fieldsinput.get(i)[2]) == 0) //teherb�r�sa 0
                fields.add(new Hole(Integer.parseInt(fieldsinput.get(i)[4]), Integer.parseInt(fieldsinput.get(i)[2]))); //h�, teherb�r�s
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