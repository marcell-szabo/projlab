package game;

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

    /**
     * Default constructor
     */
    public GameBoard() {
    }

    /**
     * Getter f�ggv�ny, visszaadja a j�t�kt�bla mez�it.
     * @return j�t�kt�bla mez�i
     */
    public List<Field> getFields() {
        return fields;
    }

    /**
     * Be�ll�tja a mez�k szomsz�dait.
     * @param neighbours - a mez�k szomsz�dai
     */
    public void setNeighbours(List<String[]> neighbours) {
        for (String[] i : neighbours) {
            int fieldidx = Integer.parseInt(i[1].substring(1)) - 1;
            for (int j = 2; j < i.length; j++) {
                if (i[j].equals("null"))
                    fields.get(fieldidx).addNeighbour(null, j - 2);
                else
                    fields.get(fieldidx).addNeighbour(fields.get(Integer.parseInt(i[j].substring(1)) - 1), j - 2);
            }
        }
    }

    /**
     * Visszat�r a bal fels� sarokban l�v� Field referenci�j�val. (Err�l a mez�r�l fognak elindulni a j�t�kosok).
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
    public Result storm() {
        Result s_result = Result.OK;
        for (Field f : fields) {
            if (new Random().nextInt(6) < 1) {
                if (f.storm() == Result.DIE)
                    s_result = Result.DIE;
            }
        }

        return s_result;
    }

    /**
     * Inicializ�lja a j�t�kt�bl�t, az attrib�tumk�nt kapott fieldsinput �s neighbour stringt�mb list�k alapj�n l�trehozza
     * �s be�ll�tja az egyes mez�ket �s azok tulajdons�gait.
     * @param fieldsinput - a mez�ket le�r� bemeneti nyelv parancsai
     * @param neighbour - a mez� szomsz�dos mez�i
     */
    public void init(List<String[]> fieldsinput, List<String[]> neighbour) {
        for (String[] s : fieldsinput) {
            if (Integer.parseInt(s[2]) == 0)
                fields.add(new Hole(Integer.parseInt(s[4]), Integer.parseInt(s[2]), s[1]));
            else {
                Item item = null;
                switch (s[3]) {
                    case "c":
                        item = new Charge();
                        break;
                    case "fl":
                        item = new Flare();
                        break;
                    case "g":
                        item = new Gun();
                        break;
                    case "f":
                        item = new Food();
                        break;
                    case "b":
                        item = new BreakableShovel();
                        break;
                    case "s":
                        item = new Shovel();
                        break;
                    case "r":
                        item = new Rope();
                        break;
                    case "d":
                        item = new DivingSuit();
                        break;
                    case "t":
                        item = new Tent();
                        break;
                }
                fields.add(new IceField(Integer.parseInt(s[4]), Integer.parseInt(s[2]), item, s[1]));
            }
        }
        setNeighbours(neighbour);
    }

    /**
     * Getter f�ggv�ny, visszaad egy random mez�t a j�t�kt�bl�r�l.
     * @return random mez�
     */
    public Field getRandomField() {
        return fields.get(new Random().nextInt(fields.size()));
    }

    /**
     * �reg�ti a j�t�kt�bl�t.
     */
    public void aging() {
        for (Field f : fields)
            f.aging();
    }
}