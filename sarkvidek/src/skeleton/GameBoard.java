package skeleton;

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
    public GameBoard(int allplayer) {
        //csak proba, majd sok objektum lesz
        Hole h = new Hole();
        fields.add(h);
        IceField icef = new IceField();
        fields.add(icef);
        setNeighbours();
    }

    /**
     * A m�r elk�sz�tett Field-eknek be�ll�tja a szomsz�dait a fields t�mb alapj�n.
     */
    public void setNeighbours() {
        fields.get(0).addNeighbour(fields.get(1), Direction.DOWN);
    }

    /**
     * Visszat�r a bal fels� sarokban l�v� Field referenci�j�val. (Err�l a mez�r�l fognak elindulni a j�t�kosok).
     *
     * @return Field-bal fels�
     */
    public Field getStartField() {
        // TODO implement here
        return null;
    }

    /**
     * Eld�nti egy adott val�sz�n�s�g alapj�n minden egyes mez�re, hogy ott j�n-e vihar.
     * Ha j�n, akkor megh�vja annak a mez�nek(Field) a storm() f�ggv�ny�t. Fut�s v�g�n,
     * ha legal�bb egy mez� storm() f�ggv�nye DIE-al t�rt vissza, akkor � is DIE-al fog, k�l�nben pedig OK-kal.
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