package game;

import graphics.Draw;
import graphics.Drawable;

import java.util.*;

/**
 * A k�t�l felv�tel�re, illetve a k�teles kiment�s kezel�s�re szolg�l� oszt�ly.
 */
public class Rope implements Tool, Drawable {

    /**
     * Default constructor
     */
    public Rope() {
    }

    /**
     * Mindig TRUE �rt�kkel t�r vissza (hiszen csak akkor h�v�dik meg, ha egy Rope p�ld�ny
     * szeretn� mag�t �sszehasonl�tani vele).
     *
     * @param r az �sszehasonl�t�shoz sz�ks�ges Rope p�ld�ny
     * @return true
     */
    public boolean isSame(Rope r) {
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
     * Mindig FALSE �rt�kkel t�r vissza (hiszen csak akkor h�v�dik meg, ha egy m�smilyen p�ld�ny szeretn� mag�t
     * �sszehasonl�tani vele).
     *
     * @param s az �sszehasonl�t�shoz sz�ks�ges Shovel p�ld�ny
     * @return false
     */
    @Override
    public boolean isSame(Shovel s) {
        return false;
    }

    /**
     * Mindig FALSE �rt�kkel t�r vissza (hiszen csak akkor h�v�dik meg, ha egy m�smilyen p�ld�ny szeretn� mag�t
     * �sszehasonl�tani vele).
     *
     * @param bs az �sszehasonl�t�shoz sz�ks�ges BreakableShovel p�ld�ny
     * @return false
     */
    @Override
    public boolean isSame(BreakableShovel bs) {
        return false;
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
     * NOTHING �rt�kkel t�r vissza .
     * @param f  A mez�, amin az �s�st kell v�grehajtani
     * @return Result a lap�tol�sr�l
     */
    @Override
    public Result clean(Field f) {
        return Result.NOTHING;
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
     * Megh�vja a param�terk�nt megkapott Player p�ld�ny changeField(Field) met�dus�t, �tadva neki a
     * param�terk�nt a kapott Field p�ld�nyt.
     * A changeField f�ggv�ny visszat�r�si �rt�ke lesz a help f�ggv�ny visszat�r�se is.
     *
     * @param f Az a field amire a player l�pni akar
     * @param p Az a j�t�kos amelyik a m�sik fieldre l�pne
     * @return Result a seg�ts�gr�l
     */
    @Override
    public Result help(Field f, Player p) {
        p.decreaseHeat();
        return p.changeField(f);
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
     *A Rope nev�nek ki�r�s��rt felel�s f�ggv�ny
     */
    @Override
    public void namestate(){
        System.out.print("rope");
    }

    @Override
    public void draw(Draw draw, int x, int y) {
        draw.ropeDraw(x, y);
    }
}