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
        return false;
    }

    @Override
    /**
     * NOTHING �rt�kkel t�r vissza .
     * @param f  A mez�, amin az �s�st kell v�grehajtani
     * @return Result a lap�tol�sr�l
     */
    public Result clean(Field f) {
        return Result.NOTHING;
    }

    @Override
    public Result swim(Field f, Player p) {
        return Result.NOTHING;
    }

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


}
