package skeleton;

import java.util.*;

import skeleton.Result;

import static skeleton.Result.OK;

/**
 * J�gt�bl�k/J�gmez�k kezel�s�re szolg�l� oszt�ly. Egyr�szt a j�gmez�k teherb�r�s�nak vizsg�lat�t v�gzi el, m�sr�szt
 * pedig vihar eset�n kezeli, hogy ha az adott mez�n esik a h�, akkor az milyen krit�riumok mellett
 * (van-e igloo vagy nincs) milyen k�vetkezm�nyekkel j�r (mez�n lev� h�r�tegek sz�m�t mindig n�velj�k, viszont a
 * testh� cs�kkent�se csak az iglooval v�detlen mez�k�n t�rt�nik meg).
 */
public class IceField extends Field {
    /**
     * Megadja, hogy adott mez� tartalmaz-e igloot. (Ha tartalmaz, akkor TRUE az �rt�ke)
     */
    private boolean igloo;

    /**
     * Default constructor
     */
    public IceField() {
        super();
    }

    /**
     * A Field oszt�lyban l�v� absztrakt f�ggv�ny megval�s�t�sa. Az adott mez� snow attrib�tum�nak �rt�k�t megn�veli
     * eggyel. Amennyiben az adott mez� nem tartalmaz igloo-t, akkor az ilyen mez�n �ll� j�t�kosokra megh�vja a
     * decreaseHeat() met�dust. Amivel ez a f�ggv�ny visszat�r, azzal t�r vissza a storm() is.
     *
     * @return
     */
    public Result storm() {
        Result r = Result.OK;
        System.out.print(this.toString() + ".storm();\n");
        System.out.print("Van iglu a jegtablan? i/n \n");
        Scanner scan = new Scanner(System.in);
        char c = scan.next().charAt(0);
        if (c == 'n') {
            //TODO
            Eskimo esk = new Eskimo(new Game(), this);
            Explorer exp = new Explorer(new Game(), this);
            players.add(esk);
            players.add(exp);
            for (Player p : players) {
                r = p.decreaseHeat();
            }
        }
        System.out.print(this.toString() + ".storm() returned Result r;\n");
        return r;
    }

    /**
     * A Field oszt�lyban l�v� absztrakt f�ggv�ny megval�s�t�sa. OK �rt�kkel t�r vissza, ha az adott mez�n l�v�
     * j�t�kosok sz�m�t m�g elb�rja a j�gt�bla. Ellenkez� esetben pedig DIE �rt�kkel fog visszat�rni.
     *
     * @param p
     * @return Result
     */
    public Result stepOn(Player p) {
        // TODO implement here
        return null;
    }

    /**
     * Ha van igloo a mez�n, akkor TRUE-val t�r vissza, ellenkez� esetben pedig FALSE-szal.
     *
     * @return
     */
    public boolean haveIgloo() {
        // TODO implement here
        return false;
    }

    /**
     * A Field oszt�ly virtu�lis buildIgloo() met�dus�nak a fel�ldefini�l�sa. Akkor h�v�dik meg, ha egy eszkim�
     * igloot szeretne �p�teni a j�gt�bl�n. Ha m�g nem volt igloo a mez�n, akkor az igloo attrib�tum �rt�k�t
     * TRUE-ra �ll�tja, majd OK �rt�kkel t�r vissza. Amennyiben volt igloo az adott, mez�n, akkor NOTHING lesz
     * a visszat�r�si �rt�ke.
     *
     * @return res Result
     */
    public Result buildIgloo() {
        System.out.println(this.toString() + ".buildIgloo();");
        System.out.println(this.toString() + ".buildIgloo() returned Result res;");
        return null;
    }

    /**
     * Megvizsg�lja a rajta tal�lhat� h� mennyis�g�t. Ha ez nulla, �s tal�lhat� rajta j�gbe fagyott t�rgy,
     * akkor megh�vja az Item oszt�ly pickMeUp(Player) f�ggv�ny�t.
     * Sikeres t�rgyfelv�tel eset�n OK-kal t�r vissza, egy�bk�nt pedig NOTHING-gal.
     *
     * @return REsult az eredm�nnyel
     */
    public Result pickUp(Player p) {

        List<Tool> tools;
        Result res;
        Scanner scan = new Scanner(System.in);
        System.out.println("Adja meg a kivant kodot\n" + "1. Aso felvetele\n2. Kotel felvetele\n"
                + "3. Buvarruha felvetele\n4. Etel elfogyasztasa\n5. Jelzoraketa alkatreszenek felvetele");
        int tool = scan.nextInt();
        System.out.println(tool);
        switch (tool) {
            case 1:
                System.out.println("Aso felvetele\n");
                System.out.println("1. Van mar asoja\n2. Nincs asoja");
                int shovel = scan.nextInt();
                System.out.println(shovel);
                switch (shovel) {
                    case 1:
                        System.out.println("Van mar asoja");
                        System.out.println(this.toString() + ".pickUp(e);");
                        tools = p.getTools();
                        System.out.println("ice.pickUp(e) returned Result res;\n\n");
                        break;
                    case 2:
                        System.out.println("Nincs asoja");
                        System.out.println(this.toString() + ".pickUp(e);");
                        tools = p.getTools();
                        item = new Shovel();
                        res = item.pickMeUp(p);
                        System.out.println("ice.pickUp(e) returned Result res;\n\n");
                        break;
                    default:
                        System.out.println("Helytelen ertek\n");
                        break;

                }
                break;
            case 2:
                System.out.println("Kotel felvetele\n");
                System.out.println("1. Van mar kotele\n2. Nincs kotele");
                int rope = scan.nextInt();
                System.out.println(rope);
                switch (rope) {
                    case 1:
                        System.out.println("Van mar kotele");
                        System.out.println(this.toString() + ".pickUp(e);");
                        tools = p.getTools();
                        System.out.println("ice.pickUp(e) returned Result res;\n\n");
                        break;
                    case 2:
                        System.out.println("Nincs kotele");
                        System.out.println(this.toString() + ".pickUp(e);");
                        tools = p.getTools();
                        item = new Rope();
                        res = item.pickMeUp(p);
                        System.out.println("ice.pickUp(e) returned Result res;\n\n");
                        break;
                    default:
                        System.out.println("Helytelen ertek\n");
                        break;
                }
                break;
            case 3:
                System.out.println("Buvarruha felvetele\n");
                System.out.println("1. Van mar buvarruhaja\n2. Nincs buvarruhaja");
                int divingsuit = scan.nextInt();
                System.out.println(divingsuit);
                switch (divingsuit) {
                    case 1:
                        System.out.println("Van mar buvarruhaja");
                        System.out.println(this.toString() + ".pickUp(e);");
                        tools = p.getTools();
                        System.out.println("ice.pickUp(e) returned Result res;\n\n");
                        break;
                    case 2:
                        System.out.println("Nincs buvarruhaja");
                        System.out.println(this.toString() + ".pickUp(e);");
                        tools = p.getTools();
                        item = new DivingSuit();
                        res = item.pickMeUp(p);
                        System.out.println("ice.pickUp(e) returned Result res;\n\n");
                        break;
                    default:
                        System.out.println("Helytelen ertek\n");
                        break;
                }
                break;
            case 4:
                System.out.println("Etel fogyasztasa");
                System.out.println("1. A testoje maximumon van\n2. Nincs maximumon a testhoje");
                int food = scan.nextInt();
                System.out.println(food);
                switch (food) {
                    case 1:
                        System.out.println("A testoje maximumon van");
                        System.out.println(this.toString() + ".pickUp(e);");
                        tools = p.getTools();
                        System.out.println("ice.pickUp(e) returned Result res;\n\n");
                        break;
                    case 2:
                        System.out.println("Nincs maximumon a testhoje");
                        System.out.println(this.toString() + ".pickUp(e);");
                        tools = p.getTools();
                        item = new Food();
                        res = item.pickMeUp(p);
                        System.out.println("ice.pickUp(e) returned Result res;\n\n");
                        break;
                    default:
                        System.out.println("Helytelen ertek\n");
                        break;
                }
                break;
            case 5:
                System.out.println("Jelzoraketa alkatreszenek felvetele");
                System.out.println(this.toString() + ".pickUp(e);");
                tools = p.getTools();
                item = new FlareGun();
                res = item.pickMeUp(p);
                System.out.println("ice.pickUp(e) returned Result res;\n\n");
                break;
        }
        return null;
    }


}