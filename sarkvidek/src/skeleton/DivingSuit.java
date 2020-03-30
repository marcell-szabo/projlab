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
     * a param�terknt megadott player felvesz egy b�v�rruh�t
     *
     * @param p a player aki felveszi az b�v�rruh�t
     * @return Result a felv�tel sikeress�g�r�l
     */
    @Override
    public Result pickMeUp(Player p) {
        System.out.println(this.toString() + ".pickMeUp(p);");
        p.addTool(this);
        System.out.println(this.toString() + ".pickMeUp(p) returned Result res;");
        return null;
    }

    /**
     * Mindig TRUE �rt�kkel t�r vissza (hiszen csak akkor h�v�dik meg, ha egy DivingSuit
     * p�ld�ny szeretn� mag�t �sszehasonl�tani vele).
     *
     * @param d - egy olyan DivingSuit p�ld�ny amivel �sszehasonl�tja mag�t a f�ggv�ny h�v� p�ld�ny
     * @return true
     */
    public boolean isSame(DivingSuit d) {
        // TODO implement here
        return true;
    }

    /**
     * A Tool oszt�ly swim(Field, Player) f�ggv�ny�nek fel�ldefini�l�sa.
     * A j�t�kos �ltal megadott ir�nyt �tadva megh�vja az actualfield checkNeighbour(Direction) f�ggv�ny�t,
     * ami visszat�r az ott tal�lhat� mez� referenci�j�val. Ha ez NULL �rt�k lenne (teh�t arra tenger van),
     * akkor �jra meg kell adni az ir�nyt.Ha megkaptuk a v�lasztott szomsz�dos mez� referenci�j�t,
     * akkor ezt �tadva megh�v�dik a param�terben megkapott j�t�kos changeField(Field) f�ggv�nye.
     * Ennek a met�dusnak a visszat�r�si �rt�k�vel t�r vissza a swim(Field, Player) f�ggv�ny is.
     *
     * @param h - a lyuk amibe beleesett a player b�v�rruh�ban
     * @param p - melyik j�t�kos esett bele
     * @return Result a kim�sz�sr�l
     */
    private Result swim(Hole h, Player p) {
        System.out.print(this.toString() + ".swim(Hole h, Player p);\n");
        System.out.println("A J(jobbra), B(balra), F(fel), L(le) karakterek seg�ts�g�vel v�lasszon," +
                "mely ir�nyba szeretne kim�szni.");
        Scanner sc = new Scanner(System.in);
        String c = sc.next();
        Direction d = UP;
        switch (c) {
            case "J":
                d = RIGHT;
            case "B":
                d = LEFT;
            case "F":
                d = UP;
            case "L":
                d = DOWN;
        }
        if (h.checkNeighbour(d) == null)
            swim(h, p);
        else {
            System.out.print(this.toString() + ".swim(Hole h, Player p) returned Result r;\n");
            return p.changeField(h.checkNeighbour(d));
        }
        System.out.print(this.toString() + ".swim(Hole h, Player p) returned null;\n");
        return null;
    }

}