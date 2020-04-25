package skeleton;

import java.util.*;

/**
 * Az �s� felv�tel�nek, illetve az �s�val rendelkez� j�t�kosok h�r�teg ellap�tol�s�nak kezel�s�re szolg�l� oszt�ly.
 */
public class Shovel implements Tool {

    /**
     * Default constructor
     */
    public Shovel() {
    }

    /**
     * Mindig TRUE �rt�kkel t�r vissza (hiszen csak akkor h�v�dik meg, ha egy Toolt implement�l� p�ld�ny szeretn� mag�t
     * �sszehasonl�tani vele).
     * @param s az �sszehasonl�t�shoz sz�ks�ges Shovel p�ld�ny
     * @return true
     */
    public boolean isSame(Shovel s) {
        return false;
    }

    /**
     * Mindig TRUE �rt�kkel t�r vissza (hiszen csak akkor h�v�dik meg, ha egy BreakableShovel p�ld�ny szeretn� mag�t
     * �sszehasonl�tani vele).
     *
     * @param bs az �sszehasonl�t�shoz sz�ks�ges BreakableShovel p�ld�ny
     * @return true
     */
    public boolean isSame(BreakableShovel bs) {
        return false;
    }

    @Override
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
    public Result pickMeUp(Player p) {
        List<Tool> tools = p.getTools();
        boolean can = true;
        for (int i = 0; i<tools.size(); i++){
            if (tools.get(i).isSame(this) == true) can = false;
        }
        if(can == true) p.addTool(this);
        return can? Result.OK : Result.NOTHING;
    }

    @Override
    /**
     * megvizsg�lja a megkapott eszk�zre, hogy az adott j�t�kos rendelkezik-e m�r vele.
     * @param t az �sszehasonl�t�shoz sz�ks�ges Tool p�ld�ny
     * @return
     */
    public boolean isSame(Tool t) {
        return true;
    }

    /**
     * Akkor h�v�dik meg, ha az �s�st v�gz� j�t�kosn�l van �s�. Ekkor ez a f�ggv�ny megh�vja a
     * Field clean() met�dus�t, ezzel m�g egy r�teget ellap�tolva arr�l (persze, ha ez lehets�ges).
     * Void visszat�r�s�, mivel nincs jelent�s�ge, hogy ez a m�velet siker�lt-e vagy sem.
     *
     * @param f A mez�, amin az �s�st kell v�grehajtani
     * @return Result a lap�tol�sr�l
     */
    public Result clean(Field f) {
        f.clean();
        return Result.OK;
    }

    @Override
    public Result swim(Field f, Player p) {
        return Result.NOTHING;
    }

    @Override
    public Result help(Field f, Player p) {
        return Result.NOTHING;
    }

    @Override
    public Result build(Field f) {
        return Result.NOTHING;
    }

}