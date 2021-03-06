package game;

import Display.Frame;
import graphics.Draw;
import graphics.Drawable;

import java.util.*;

import static game.Result.*;

/**
 * J�t�kosok kezel�s�re szolg�l� oszt�ly. A j�t�kosok munk�j�nak �s testh�j�nek vizsg�lata mellett a k�r�kben elv�gezhet�
 * cselekv�sekkel foglalkozik. Minden j�t�kos k�re addig tart, am�g a work attrib�tum�nak �rt�ke nem cs�kken le null�ra.
 * Minden cselekvs, ami az adott esetben enged�lyezett, az egy egys�g munkav�gz�ssel j�r (p�ld�ul t�rgy felv�tele olyan
 * mez�n, amin m�g van h�r�teg nem enged�lyezett, �s ilyenkor ez nem is j�r munkav�gz�ssel).
 */
public abstract class Player implements Drawable {

    protected char color;
    /**
     * Az adott j�t�kos testh� szintj�nek mennyis�g�t t�rolja.
     */
    protected int heat;

    /**
     * Az adott j�t�kos munk�j�nak egys�geit t�rolja.
     */
    protected int work = 4;

    /**
     * T�rolja az aktu�lis j�t�kot.
     */
    protected Game game;

    /**
     * T�rolja, hogy az adott j�t�kos melyik mez�n �ll.
     */
    protected Field actualfield;

    /**
     * T�rolja a j�t�kosn�l tal�lhat� t�rgyakat.
     */
    private List<Tool> tools = new ArrayList<>();

    /**
     * Default constructor
     */
    public Player(Game g, Field actual, char c, int h) {
        game = g;
        actualfield = actual;
        color = c;
        heat = h;
    }

    /**
     * Visszaadja az eszk?z?ket tartalmaz? list?t, teh?t a tools attrib?tum?t.
     *
     * @return eszk?z?ket tartalmaz? lista
     */
    public List<Tool> getTools() {
        return tools;
    }

    /**
     * Els�k�nt be�ll�tja a jelenlegi j�t�kos work attrib�tum�nak �rt�k�t n�gy egys�gre, majd v�gigv�rja
     * (egy ciklusban) a j�t�kos l�p�seit (m�g a work �rt�ke nulla nem lesz, vagy v�get nem �r a j�t�k gy�zelem vagy
     * hal�l miatt). Fut�sa sor�n a kontrollert�l kapott billenty�k alapj�n az adott cselekv�shez sz�ks�ges f�ggv�nyeket
     * fogja megh�vni. Ha az �ltala megh�vott f�ggv�nyek OK-kal t�rnek vissza, akkor cs�kkenti a work �rt�k�t eggyel, majd
     * ellen�rzi hogy nem cs�kkent-e null�ra. A f�ggv�ny visszat�r�se OK, ha minden rendben, DIE vagy WIN ha az elv�gzett
     * tev�kenys�ggel a j�t�k v�get �rt gy�zelemmel vagy hal�llal.
     * @return a k�rben t�rt�nt-e win, die
     */
    public Result round(Frame frame) {
        this.work = 4;
        Result result = OK;
        while(work != 0 && result != DIE && result != WIN) {
            char c = game.controller.EventHandler();
            game.examinedField = null;
            game.examinedCapacity = null;
            switch (c) {
                case 'w':
                    result = this.move(0);
                    break;
                case 'd':
                    result = this.move(1);
                    break;
                case 's':
                    result = this.move(2);
                    break;
                case 'a':
                    result = this.move(3);
                    break;
                case 'j':
                    result = this.clean();
                    break;
                case 'k':
                    result = actualfield.pickUp(this);
                    break;
                case 'l':
                    result = this.specialSkill();
                    break;
                case 'i':
                    result = this.assemble();
                    break;
                case 'm':
                    result = this.buildTent();
                default:
                    break;
            }
            if (result == OK) {
                game.actualSnow = Integer.toString(this.actualfield.getSnow());
                work--;
                game.actualWork = Integer.toString(work);
                game.actualHeat = Integer.toString(heat);
                frame.update(frame.getGraphics());
            }
        }
        return result;
    }

    /**
     * Megh�vja a tools attrib�tumban t�rolt �sszes Tool p�ld�nyra a build(Field)
     * f�ggv�nyt. Amennyiben b�rmelyik DISAPPEAR-rel t�r vissza, akkor az t�rl�sre ker�l a tools t�mbb�l,
     * majd a buildTent() met�dus visszat�r�si �rt�ke OK lesz. Abban az esetben viszont,
     * ha egyik sem t�r vissza DISAPPEAR-rel, akkor a buildTent() OK helyett NOTHING visszat�r�si �rt�ket fog adni.
     * @return OK or NOTHING
     */
    private Result buildTent() {
        for (Tool t : tools) {
            if (t.build(actualfield) == DISAPPEAR) {
                tools.remove(t);
                return OK;
            }

        }
        return NOTHING;
    }

    /**
     * Legel�sz�r a megkapott ir�nyra megh�vja a checkNeighbour(Direction) met�dust.
     * Ezt k�vet�en az el�bb h�vott f�ggv�ny visszat�r�si �rt�k�t �tadva ker�l a changeField(Field) megh�v�sra.
     * Amivel ez visszat�r, azzal fog a move(Direction) is.
     *
     * @param d mozg�sn�l prefer�lt ir�ny
     * @return Result a sikeress�g�r�l
     */
    public Result move(int d) {
        Field field = actualfield.checkNeighbour(d);
        if (field != null)
            return this.changeField(field);
        return NOTHING;
    }

    /**
     * Megh�vja az actualfieldben t�rolt mez�re a Field oszt�ly leaveField(Player) f�ggv�ny�t.
     * Ezek ut�n be�ll�tja a jelenlegi j�t�kos actualfield nev� attribtum�nak �rt�k�t a megkapott mez�re.
     * Ezt k�vet�en megh�vja a Field oszt�ly stepOn(Player) f�ggv�ny�t, �s azzal fog visszat�rni,
     * amivel az �ltala h�vott met�dus visszat�rt.
     * @param f megkapja a mez�t amire l�p, ez lesz az actualfield
     * @return Result a sikeress�gr�l
     */
    public Result changeField(Field f) {
        actualfield.leaveField(this);
        actualfield = f;
        return f.stepOn(this);
    }

    /**
     * Megh�vja a Field oszt�ly clean() met�dus�t. Amennyiben ez OK-kal t�r vissza,
     * akkor megh�vja a tools attrib�tumban t�rolt �sszes Tool p�ld�ny clean(Field) f�ggv�ny�t.
     * V�g�l visszat�r azzal, amivel a Field oszt�ly el�sz�r megh�vott clean() f�ggv�nye t�rt vissza.
     * @return Result
     */
    public Result clean() {
        Result r = actualfield.clean();
        if (r == Result.OK) {
            for (Tool t : tools) {
                if(t.clean(actualfield) == DISAPPEAR) {
                    tools.remove(t);
                    return r;
                }

            }
        }
        return r;
    }

    /**
     * A game attrib�tumban t�rolt Game-re megh�vja a getPlayerNumber() f�ggv�nyt.
     * A visszakapott �rt�ket �tadja az �ltala h�vott a haveAllPlayers() met�dusnak.
     * Ha ez FALSE �rt�kkel t�r vissza, akkor OK-kal fog. TRUE eset�n viszont megh�vja a HaveAllParts() f�ggv�nyt,
     * amely ha TRUE-val t�r vissza, akkor az assemble() WIN-nel fog. Amennyiben a haveAllParts() met�dus FALSE �rt�kkel
     * t�r vissza, akkor az assemble() OK-kal fog. (Ezekben az esetekben az�rt t�r vissza OK-kal,
     * mert a feleslegesen megpr�b�lt �sszeszerel�s is munk�nak sz�m�t).
     * @return az �sszeszerel�s sikeress�ge
     */
    public Result assemble() {
        if (actualfield.haveAllPlayer(game.getPlayerNumber()) && game.haveAllParts()) {
            return WIN;
        }
        return OK;
    }

    /**
     * El�sz�r a swim(Field, Player) met�dus ker�l megh�v�sra minden egyes eszk�zre.
     * Ezt k�vet�en a visszat�r�si �rt�kek ker�lnek vizsg�latra.
     * Ha ezek k�z�l b�rmelyik nem NOTHING �rt�ket vesz fel, akkor azzal az �rt�kkel t�r vissza a helpMe() is.
     * Ha pedig mindegyik NOTHING-gal t�r vissza, akkor minden ir�nyt megvizsg�l a checkNeighbour(Direction) met�dussal.
     * Amennyiben a visszat�r�si �rt�k nem NULL, akkor megh�v�dik a canHelp() f�ggv�ny a megkapott referenci�ra vagy
     * referenci�kra, �s ha van olyan mely OK-al t�r vissza akkor nem hal meg a j�t�kos
     * Ebben az esetben amivel ez a met�dus t�r vissza, azzal fog a helpMe() is.
     * @return Result a seg�ts�gk�r�s sikeress�g�vel
     */
    public Result helpMe() {
        for (Tool t : tools) {
            Result res = t.swim(actualfield, this);
            if (res != NOTHING)
                return res;
        }
        for (int d = 0; d <= 3; d++) {
            Field field = actualfield.checkNeighbour(d);
            if (field != null)
                if (actualfield.checkNeighbour(d).canHelp(this) == OK)
                    return OK;
        }
        return DIE;
    }

    /**
     * Cs�kkenti a j�t�kos heat attrib�tum�nak �rt�k�t eggyel, majd megvizsg�lja, hogy mennyi a heat �rt�ke.
     * Amennyiben ez null�ra cs�kkent, akkor DIE, minden m�s esetben pedig OK  visszat�r�si �rt�ke lesz.
     * @return a testh�cs�kkent�s sikeress�g�vel t�r vissza
     */
    public Result decreaseHeat() {
        heat--;
        if (heat == 0)
            return DIE;
        return OK;
    }

    /**
     * A list�hoz hozz�adja a megkapott eszk�zt.
     * @param t tool p�ld�ny
     */
    public void addTool(Tool t) {
        tools.add(t);
        return;
    }

    /**
     * Megh�vja a Game oszt�ly addPart(FlareGun) f�ggv�ny�t.
     * @param f jelz�rak�ta elem
     */
    public void addPart(FlareGun f) {
        game.addPart(f);
        return;
    }

    /**
     * Abstract fv, vagy az eskimo vagy az explorer increaseHeat() fv-je h�v�dik meg
     */
    public abstract Result increaseHeat();

    /**
     * Absztrakt f�ggv�ny. Az Eskimo vagy az Explorer oszt�ly specialSkill() f�ggv�nye h�v�dik meg.
     * @return a k�pess�ghaszn�lat eredm�nye
     */
    public abstract Result specialSkill();

    /**
     * Getter f�ggv�ny, visszaadja a j�t�kos sz�n�t
     * @return j�t�kos sz�ne
     */
    public char getColor(){
        return color;
    }

    /**
     * A Drawable interf�szb�l implement�lt f�ggv�ny. Megh�vja a saj�t mag�t kirajzol� f�ggv�nyt a Draw oszt�lyban.
     * @param draw - Draw oszt�ly p�ld�nya amelyben implement�lva van a j�t�kost kirajzol� f�ggv�ny.
     * @param x - kirajzol�s hely�nek X koordin�t�ja
     * @param y - kirajzol�s hely�nek Y koordin�t�ja
     */
    public abstract void draw(Draw draw, int x, int y);



}