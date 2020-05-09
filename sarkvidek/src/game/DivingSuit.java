package game;

import graphics.Draw;
import graphics.Drawable;

import java.util.*;
import static game.Result.DIE;


/**
 * A b�v�rruha felv�tel�nek, illetve haszn�lat�nak kezel�s�re szolg�l� oszt�ly.
 */
public class DivingSuit implements Tool, Drawable {

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
        Field field = null;
        while(field == null)
            field = f.checkNeighbour(new Random().nextInt(3));
        return p.changeField(field);
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


    @Override
    public void draw(Draw draw, int x, int y) {
        draw.divingSuitDraw(x, y);
    }
}