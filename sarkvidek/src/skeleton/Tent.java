package skeleton;

import java.util.List;

/**
 * S�tor elt�n�s�nek, illetve meg�p�t�s�nek kezel�s�re szolg�l� oszt�ly.
 */
public class Tent extends Igloo implements Tool {

    /**
     *  A s�tor fel�ll�t�sa �ta eltelt id�t reprezent�lja.
     *  Meg�p�t�skor megegyezik az �rt�ke a j�t�kosok sz�m�val. Ha lecs�kken null�ra, akkor elt�nik.
     */
    private int timer;

    /**
     * Default constructor
     */
    public Tent(){
    }


    /**
     * FALSE �rt�kkel t�r vissza, mert nem v�di meg
     * a mez�n tart�zkod� embereket a jegesmedv�t�l.
     *
     * @return true or false
     */
    public boolean protectFromBear(){
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
     * Mindig TRUE �rt�kkel t�r vissza (hiszen csak akkor h�v�dik meg, ha egy Toolt implement�l� p�ld�ny szeretn� mag�t
     * �sszehasonl�tani vele).
     *
     * @param t az �sszehasonl�t�shoz sz�ks�ges Tent p�ld�ny
     * @return true
     */
    public boolean isSame(Tent t) {
        return true;
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
     * Megh�vja az attrib�tumk�nt kapott Field oszt�ly build(Igloo) met�dus�t,
     * �tadva neki �nmag�t. Ha ez OK-kal t�r vissza, akkor a build(Field)
     * DlSAPPEAR-rel, k�l�nben pedig NOTHING-gal fog visszat�rni.
     *
     * @param f Field amelyre s�tort akarunk �p�teni
     * @return DISAPPEAR or NOTHING
     */
    @Override
    public Result build(Field f){
        Result r = f.build(this);
        if(r == Result.OK)
            return Result.DISAPPEAR;
        return Result.NOTHING;
    }

    /**
     * Eggyel cs�kkenti a timer attrib�tum�t. Ha �gy null�ra cs�kken,
     * akkor DISAPPEAR-rel t�r vissza, k�l�nben pedig OK-kal.
     *
     * @return DISAPPEAR or OK
     */
    public Result aging(){
        timer--;
        if(timer == 0)
            return Result.DISAPPEAR;
        return Result.OK;
    }

    /**
     *A Tent nev�nek ki�r�s��rt felel�s f�ggv�ny
     */
    @Override
    public void namestate(){
        System.out.print("tent");
    }
}
