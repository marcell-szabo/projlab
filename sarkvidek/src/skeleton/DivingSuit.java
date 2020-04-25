package skeleton;

import java.util.*;

import static skeleton.Direction.*;

/**
 * A b�v�rruha felv�tel�nek, illetve haszn�lat�nak kezel�s�re szolg�l� oszt�ly.
 */
public class DivingSuit extends Tool {

    /**
     * Default constructor
     */
    public DivingSuit() {
    }

    /**
     * Mindig TRUE �rt�kkel t�r vissza (hiszen csak akkor h�v�dik meg, ha egy DivingSuit
     * p�ld�ny szeretn� mag�t �sszehasonl�tani vele).
     *
     * @param d az �sszehasonl�t�shoz sz�ks�ges DivingSuit p�ld�ny
     * @return true
     */
    public boolean isSame(DivingSuit d) {
        return true;
    }

    /**
     * A Tool oszt�ly swim(Field, Player) f�ggv�ny�nek fel�ldefini�l�sa.
     * A j�t�kos �ltal megadott ir�nyt �tadva megh�vja az actualfield checkNeighbour(int) met�dus�t,
     * ami visszat�r az ott tal�lhat� mez� referenci�j�val.
     * Ha ez NULL �rt�k lenne (teh�t arra tenger tal�lhat�), akkor �jra meg kell adni egy ir�nyt.
     * Ha megkaptuk a v�lasztott szomsz�dos mez� referenci�j�t, akkor ezt �tadva megh�v�dik
     * a param�terben megkapott j�t�kos changeField(Field) f�ggv�nye.
     * Ennek a met�dusnak a visszat�r�si �rt�k�vel t�r vissza a swim(Field, Player) f�ggv�ny is.
     *
     * @param f a mez� (lyuk), amibe beleesett a player
     * @param p melyik j�t�kos esett bele
     * @return Result a kim�sz�sr�l
     */
    public Result swim(Field f, Player p) {
        System.out.println("A J(jobbra), B(balra), F(fel), L(le) karakterek seg�ts�g�vel v�lasszon," +
                "mely ir�nyba szeretne kim�szni.");
        Field choosedField = null;
        while (choosedField == null) {
            Scanner sc = new Scanner(System.in);
            String c = sc.next();
            int d = 0;
            switch (c) {
                case "J":
                    d = 0;
                case "B":
                    d = 1;
                case "F":
                    d = 2;
                case "L":
                    d = 3;
            }
            choosedField = f.checkNeighbour(d);
            if (choosedField == null)
                System.out.println("A v�lasztott ir�nyban tenger tal�lhat�, adjon meg �j ir�nyt!");
        }
        return p.changeField(choosedField);
    }
}