package skeleton;

import java.util.*;

import static skeleton.Direction.*;

/**
 * A b�v�rruha felv�tel�nek, illetve haszn�lat�nak kezel�s�re szolg�l� oszt�ly.
 */
public class DivingSuit implements Tool {

    /**
     * Default constructor
     */
    public DivingSuit() {
    }

    /**
     * Mindig FALSE �rt�kkel t�r vissza (hiszen csak akkor h�v�dik meg, ha egy DivingSuit-t�l k�l�nb�z�
     * p�ld�ny szeretn� mag�t �sszehasonl�tani vele).
     *
     * @param t az �sszehasonl�t�shoz sz�ks�ges Tool p�ld�ny
     * @return true
     */
    @Override
    public boolean isSame(Tool t) {
        return false;
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
     * Legel�sz�r a Player oszt�ly getTools() f�ggv�nye ker�l megh�v�sra,
     * mely a j�t�kosn�l l�v� eszk�z�ket tartalmaz� list�val t�r vissza.
     * Ezt k�vet�en megh�vja a lista minden elem�re a Tool oszt�ly isSame(Tool) met�dus�t.
     * Ezut�n ezeknek a visszat�r�si �rt�kei ker�lnek vizsg�lat al�.
     * Amennyiben minden f�ggv�ny h�v�st k�vet�en csak FALSE visszat�r�si �rt�keket kapunk,
     * akkor megh�v�sra ker�l a Player oszt�ly addTool(Tool) met�dusa, majd ezt k�vet�en OK-kal t�r vissza.
     * K�l�nben pedig NOTHING lesz a visszat�r�si �rt�k.
     * @param p - A J�t�kos aki felvesz egy Toolt
     * @return Reasult a felv�tel sikeress�g�r�l
     */
    @Override
    public Result pickMeUp(Player p) {
        List<Tool> tools = p.getTools();
        boolean can = true;
        for (int i = 0; i<tools.size(); i++){
            if (tools.get(i).isSame(this)) can = false;
        }
        if(can) p.addTool(this);
        return can? Result.OK : Result.NOTHING;
    }

    /**
     * NOTHING �rt�kkel t�r vissza .
     * @param f  A mez�, amin az �s�st kell v�grehajtani
     * @return Result a lap�tol�sr�l
     */
    @Override
    public Result clean(Field f) {
        return Result.NOTHING;
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
    @Override
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

    /**
     * NOTHING �rt�kkel t�r vissza.
     * @param f Az a field amire a player l�pni akar
     * @param p Az a j�t�kos amelyik a m�sik fieldre l�pne
     * @return Result a seg�ts�gr�l
     */
    @Override
    public Result help(Field f, Player p) {
        return Result.NOTHING;
    }

    /**
     * NOTHING �rt�kkel t�r vissza.
     * @param f A mez�, amire s�trat kell �p�teni
     * @return Result az �p�t�sr�l
     */
    @Override
    public Result build(Field f) {
        return Result.NOTHING;
    }
}