package skeleton;

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
     * Mindig TRUE �rt�kkel t�r vissza (hiszen csak akkor h�v�dik meg,
     * ha egy Tent p�ld�ny szeretn� mag�t �sszehasonl�tani vele).
     *
     * @return true
     */
    public boolean isSame(Tent t){
        return true;
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
        Result r = f.buildIgloo(this);
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
     * FALSE �rt�kkel t�r vissza, mert nem v�di meg
     * a mez�n tart�zkod� embereket a jegesmedv�t�l.
     *
     * @return true or false
     */
    public boolean protectFromBear(){
        return false;
    }
}
