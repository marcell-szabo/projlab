package game;

import graphics.Draw;
import graphics.Drawable;

import java.util.*;

/**
 * Az �s� felv�tel�nek, illetve az �s�val rendelkez� j�t�kosok h�r�teg ellap�tol�s�nak kezel�s�re szolg�l� oszt�ly.
 */
public class Shovel implements Tool, Drawable {

    /**
     * Default constructor
     */
    public Shovel() {
    }

    /**
     * Mindig TRUE �rt�kkel t�r vissza (hiszen csak akkor h�v�dik meg, ha egy Shovel p�ld�ny szeretn� mag�t
     * �sszehasonl�tani vele).
     *
     * @param s az �sszehasonl�t�shoz sz�ks�ges BreakableShovel p�ld�ny
     * @return true
     */
    public boolean isSame(Shovel s) {
        return true;
    }

    /**
     * Mindig TRUE �rt�kkel t�r vissza (hiszen csak akkor h�v�dik meg, ha egy BreakableShovel p�ld�ny szeretn� mag�t
     * �sszehasonl�tani vele).
     *
     * @param bs az �sszehasonl�t�shoz sz�ks�ges BreakableShovel p�ld�ny
     * @return true
     */
    public boolean isSame(BreakableShovel bs) {
        return true;
    }

    /**
     * Mindig FALSE �rt�kkel t�r vissza (hiszen csak akkor h�v�dik meg, ha egy m�smilyen p�ld�ny szeretn� mag�t
     * �sszehasonl�tani vele).
     *
     * @param t az �sszehasonl�t�shoz sz�ks�ges Tent p�ld�ny
     * @return false
     */
    @Override
    public boolean isSame(Tent t) {
        return false;
    }

    /**
     * Mindig FALSE �rt�kkel t�r vissza (hiszen csak akkor h�v�dik meg, ha egy m�smilyen p�ld�ny szeretn� mag�t
     * �sszehasonl�tani vele).
     *
     * @param r az �sszehasonl�t�shoz sz�ks�ges Rope p�ld�ny
     * @return false
     */
    @Override
    public boolean isSame(Rope r) {
        return false;
    }


    /**
     * Mindig FALSE �rt�kkel t�r vissza (hiszen csak akkor h�v�dik meg, ha egy m�smilyen p�ld�ny szeretn� mag�t
     * �sszehasonl�tani vele).
     *
     * @param d az �sszehasonl�t�shoz sz�ks�ges DivingSuit p�ld�ny
     * @return false
     */
    @Override
    public boolean isSame(DivingSuit d) {
        return false;
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
     * Akkor h�v�dik meg, ha az �s�st v�gz� j�t�kosn�l van �s�. Ekkor ez a f�ggv�ny megh�vja a
     * Field clean() met�dus�t, ezzel m�g egy r�teget ellap�tolva arr�l (persze, ha ez lehets�ges).
     * Void visszat�r�s�, mivel nincs jelent�s�ge, hogy ez a m�velet siker�lt-e vagy sem.
     *
     * @param f A mez�, amin az �s�st kell v�grehajtani
     * @return Result a lap�tol�sr�l
     */
    @Override
    public Result clean(Field f) {
        f.clean();
        return Result.OK;
    }

    /**
     * NOTHING �rt�kkel t�r vissza.
     * @param f a mez� (lyuk), amibe beleesett a player
     * @param p melyik j�t�kos esett bele
     * @return Result a kim�sz�sr�l
     */
    @Override
    public Result swim(Field f, Player p) {
        return Result.NOTHING;
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

    /**
     *A Shovel nev�nek ki�r�s��rt felel�s f�ggv�ny
     */
    @Override
    public void namestate(){
        System.out.print("shovel");
    }

    @Override
    public void draw(Draw draw, int x, int y) {

    }
}