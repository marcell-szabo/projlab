package skeleton;

import java.util.*;

import skeleton.Result;

import static skeleton.Result.NOTHING;

/**
 * J�t�kosok kezel�s�re szolg�l� oszt�ly. A j�t�kosok munk�j�nak �s testh�j�nek vizsg�lata mellett a k�r�kben elv�gezhet� cselekv�sekkel foglalkozik. Minden j�t�kos k�re addig tart, am�g a work attrib�tum�nak �rt�ke nem cs�kken le null�ra. Minden cselekv�s, ami az adott esetben enged�lyezett, az egy egys�g munkav�gz�ssel j�r (p�ld�ul t�rgy felv�tele olyan mez�n, amin m�g van h�r�teg nem enged�lyezett, �s ilyenkor ez nem is j�r munkav�gz�ssel).
 */
public abstract class Player {
    /**
     * Az adott j�t�kos testh� szintj�nek mennyis�g�t t�rolja.
     */
    protected int heat;

    /**
     * Az adott j�t�kos munk�j�nak (szebben megfogalmazva: munk�ra ford�that� energi�j�nak) egys�geit t�rolja.
     */
    protected int work;

    /**
     * T�rolja az aktu�lis j�t�kot.
     */
    private Game game;

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
    public Player(Game g, Field actual) {
        game = g;
        actualfield = actual;
    }

    /**
     * Els�k�nt be�ll�tja a jelenlegi j�t�kos work attrib�tum�nak �rt�ket n�gy egys�gre, majd v�gigv�rja
     * (egy ciklusban) a j�t�kos l�p�seit (m�g a work �rt�ke nulla nem lesz, vagy v�get nem �r a
     * j�t�k gy�zelem vagy hal�l miatt). Fut�s sor�n az �ltalunk v�lasztott cselekv�sekhez sz�ks�ges
     * f�ggv�nyeket fogja megh�vni. Ha az �ltala megh�vott f�ggv�nyek OK-kal t�rnek vissza, akkor cs�kkenti a
     * work �rt�k�t eggyel, majd ellen�rzi, hogy ezt k�vet�en nem cs�kkent-e null�ra. Amennyiben nem, akkor
     * folytat�dik a ciklus fut�sa, ellenben ha ez az �rt�k null�ra cs�kkent, akkor kil�p a ciklusb�l, �s a round()
     * met�dus OK �rt�kkel t�r vissza. Ha fut�s sor�n b�rmely f�ggv�ny DIE vagy WIN visszat�r�si �rt�kkel rendelkezik,
     * akkor a round() szint�n kil�p a ciklus�b�l �s ugyanazzal fog visszat�rni amit kapott. (NOTHING hat�s�ra nem
     * cs�kkenti a work attrib�tumot, �s biztosan benne marad a ciklusban)
     *
     * @return a k�rben t�rt�nt-e win, die
     */
    public Result round() {
        // TODO implement here
        return null;
    }

    /**
     * Megh�vja a Field oszt�ly clean() met�dus�t. Amennyiben ez OK-kal t�r vissza,
     * akkor megh�vja a tools attrib�tumban t�rolt �sszes Tool p�ld�ny clean(Field) f�ggv�ny�t.
     * V�g�l visszat�r azzal, amivel a Field oszt�ly el�sz�r megh�vott clean() f�ggv�nye t�rt vissza.
     *
     * @return Result
     */
    public Result clean() {
        System.out.print(this.toString() + ".clean();\n");
        Result r = actualfield.clean();
        if (r == Result.OK) {
            for (Tool t : tools) {
                t.clean(actualfield);
            }
        }
        System.out.print(this.toString() + ".clean() returned Result r;\n\n");
        return r;
    }

    /**
     * A game attrib�tumban t�rolt Game-re megh�vja a getPlayerNumber() f�ggv�nyt.
     * A visszakapott �rt�ket �tadja az �ltala h�vott a haveAllPlayers() met�dusnak.
     * Ha ez FALSE �rt�kkel t�r vissza, akkor � OK-kal fog. TRUE eset�n viszont megh�vja a HaveAllParts() f�ggv�nyt,
     * amely ha TRUE-val t�r vissza, akkor az assemble() WIN-nel fog. Amennyiben a haveAllParts() met�dus FALSE �rt�kkel
     * t�r vissza, akkor az assemble() OK-kal fog. (Ezekben az esetekben az�rt t�r vissza OK-kal,
     * mert a feleslegesen megpr�b�lt �sszeszerel�s is munk�nak sz�m�t).
     *
     * @return az �sszeszerel�s sikeress�ge
     */
    public Result assemble() {
        System.out.print(this.toString() + ".assemble();\n");
        actualfield.haveAllPlayer(game.getPlayerNumber());
        System.out.print("Minden jatekos egy mezon tartozkodik? i/n\n");
        Scanner scan = new Scanner(System.in);
        char c1 = scan.next().charAt(0);
        if (c1 == 'i') {
            game.haveAllParts();
            System.out.print("A jatekos es csapata rendelkezik az osszes alkatresszel? i/n\n");
            char c2 = scan.next().charAt(0);
            if(c2 == 'i') {
                System.out.print(this.toString() + ".assemble() returned Result WIN;\n\n");
                return Result.WIN;
            }
        }
        System.out.print(this.toString() + "assemble() returned Result NOTHING\n\n");
        return Result.NOTHING;
    }

    /**
     * Absztrakt f�ggv�ny. Az Eskimo vagy az Explorer oszt�ly specialSkill() f�ggv�nye h�v�dik meg.
     *
     * @return
     */
    public abstract Result specialSkill();

    /**
     * Megh�vja az actualfieldben t�rolt mez�re a Field oszt�ly leaveField(Player) f�ggv�ny�t.
     * Ezek ut�n be�ll�tja a jelenlegi j�t�kos actualfield nev� attrib�tum�nak �rt�k�t a megkapott mez�re.
     * Ezt k�vet�en megh�vja a Field oszt�ly stepOn(Player) f�ggv�ny�t, �s azzal fog visszat�rni,
     * amivel az �ltala h�vott met�dus visszat�rt.
     *
     * @param f megkapja a mez�t amire l�p, ez lesz az actualfield
     * @return Result a sikeress�gr�l
     */
    public Result changeField(Field f) {
        System.out.print(this.toString() + ".changeField(Field f);\n");
        actualfield.leaveField(this);
        actualfield = f;
        f.stepOn(this);
        System.out.print(this.toString() + ".changeField(Field f) returned Result r;\n");
        return NOTHING;
    }

    /**
     * El�sz�r a swim(Field, Player) met�dus ker�l megh�v�sra minden egyes eszk�zre.
     * Ezt k�vet�en a visszat�r�si �rt�kek ker�lnek vizsg�latra.
     * Ha ezek k�z�l b�rmelyik nem NOTHING �rt�ket vesz fel, akkor azzal az �rt�kkel t�r vissza a helpMe() is.
     * Ha pedig mindegyik NOTHING-gal t�r vissza, akkor minden ir�nyt megvizsg�l a checkNeighbour(Direction) met�dussal.
     * Amennyiben a visszat�r�si �rt�k nem NULL, akkor megh�v�dik a canHelp() f�ggv�ny a megkapott referenci�ra.
     * Ebben az esetben amivel ez a met�dus t�r vissza, azzal fog a helpMe() is.
     *
     * @return Result a seg�ts�gk�r�s sikeress�g�vel
     */
    public Result helpMe() {
        System.out.print(this.toString() + ".helpMe();\n");
        for (Tool t : tools) {
            if (t.swim(actualfield, this) != Result.NOTHING) {
                System.out.print(this.toString() + ".helpMe() returned Result r;\n");
                return t.swim(actualfield, this);
            }
        }
        for (Direction d : Direction.values()) {
            Field i = actualfield.checkNeighbour(d);
            if (i != null) {
                System.out.print(this.toString() + ".helpMe() returned Result r;\n");
                return actualfield.checkNeighbour(d).canHelp();
            }
        }
        System.out.print(this.toString() + ".helpMe() returned Result r;\n");
        return NOTHING;
    }

    /**
     * Cs�kkenti a j�t�kos heat nev� attrib�tum�nak �rt�k�t eggyel, majd megvizsg�lja, hogy mennyi a heat �rt�ke.
     * Amennyiben ez null�ra cs�kkent, akkor DIE, minden m�s esetben pedig OK  visszat�r�si �rt�ke lesz.
     *
     * @return a testh�cs�kkent�s sikeress�g�vel t�r vissza
     */
    public Result decreaseHeat() {
        System.out.print(this.toString() + ".decreaseHeat();\n");
        System.out.print(this.toString() + ".decreaseHeat() returned Result\n");
        return Result.OK;
    }

    /**
     * A list�hoz hozz�adja a megkapott eszk�zt.
     *
     * @param t tool p�ld�ny
     */
    public void addTool(Tool t) {
        // TODO implement here
    }

    /**
     * Legel�sz�r a megkapott ir�nyra megh�vja a checkNeighbour(Direction) met�dust.
     * Ezt k�vet�en az el�bb h�vott f�ggv�ny visszat�r�si �rt�k�t �tadva ker�l a changeField(Field) megh�v�sra.
     * Amivel ez visszat�r, azzal fog a move(Direction) is.
     *
     * @param d mozg�sn�l prefer�lt ir�ny
     * @return Result a sikeress�gr�l
     */
    public Result move(Direction d) {
        System.out.print(this.toString() + ".move();\n");
        actualfield.addNeighbour(new Hole(), Direction.RIGHT);
        Field field = actualfield.checkNeighbour(d);
        if (field != null)
            field.stepOn(this);
        System.out.print(this.toString() + ".move() returned Result r;\n\n\n");
        return NOTHING;
    }

    /**
     * Legel�sz�r megvizsg�lja, hogy az adott j�t�kos heat attrib�tum�nak �rt�ke a maxim�lis �rt�k alatt van-e.
     * Amennyiben igen, akkor megn�veli eggyel az �rt�k�t, majd OK visszat�r�si �rt�ket ad.
     * Ellenkez� esetben kimarad a n�vel�s, �s NOTHING �rt�kkel t�r vissza.
     *
     * @return a testh�n�el�ssel visszat�r
     */
    public Result increaseHeat() {
        // TODO implement here
        return null;
    }

    /**
     * Megh�vja a Game oszt�ly addPart(FlareGun) f�ggv�ny�t.
     *
     * @param f jelz�rak�ta elem
     */
    public void addPart(FlareGun f) {
        System.out.println(this.toString() + ".addPart(f);");
        game.addPart(f);
        System.out.println(this.toString() + ".addPart(f) returned;");
        return;
    }

    /**
     * Visszaadja az eszk�z�ket tartalmaz� list�t, teh�t a tools attrib�tum�t.
     *
     * @return eszk�z�ket tartalmaz� lista
     */
    public List<Tool> getTools() {
        // TODO implement here
        return null;
    }

}