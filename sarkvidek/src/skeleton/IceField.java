package skeleton;

import java.util.*;

import skeleton.Result;

import static skeleton.Result.OK;

/**
 * Jégtáblák/Jégmezõk kezelésére szolgáló osztály. Egyrészt a jégmezõk teherbírásának vizsgálatát végzi el, másrészt
 * pedig vihar esetén kezeli, hogy ha az adott mezõn esik a hó, akkor az milyen kritériumok mellett
 * (van-e igloo vagy nincs) milyen következményekkel jár (mezõn levõ hórétegek számát mindig növeljük, viszont a
 * testhõ csökkentése csak az iglooval védetlen mezõkön történik meg).
 */
public class IceField extends Field {
    /**
     * Megadja, hogy adott mezõ tartalmaz-e igloot. (Ha tartalmaz, akkor TRUE az értéke)
     */
    private boolean igloo;

    /**
     * Default constructor
     */
    public IceField() {
        super();
    }

    /**
     * A Field osztályban lévõ absztrakt függvény megvalósítása. Az adott mezõ snow attribútumának értékét megnöveli
     * eggyel. Amennyiben az adott mezõ nem tartalmaz igloo-t, akkor az ilyen mezõn álló játékosokra meghívja a
     * decreaseHeat() metódust. Amivel ez a függvény visszatér, azzal tér vissza a storm() is.
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
     * A Field osztályban lévõ absztrakt függvény megvalósítása. OK értékkel tér vissza, ha az adott mezõn lévõ
     * játékosok számát még elbírja a jégtábla. Ellenkezõ esetben pedig DIE értékkel fog visszatérni.
     *
     * @param p
     * @return Result
     */
    public Result stepOn(Player p) {
        // TODO implement here
        return null;
    }

    /**
     * Ha van igloo a mezõn, akkor TRUE-val tér vissza, ellenkezõ esetben pedig FALSE-szal.
     *
     * @return
     */
    public boolean haveIgloo() {
        // TODO implement here
        return false;
    }

    /**
     * A Field osztály virtuális buildIgloo() metódusának a felüldefiniálása. Akkor hívódik meg, ha egy eszkimó
     * igloot szeretne építeni a jégtáblán. Ha még nem volt igloo a mezõn, akkor az igloo attribútum értékét
     * TRUE-ra állítja, majd OK értékkel tér vissza. Amennyiben volt igloo az adott, mezõn, akkor NOTHING lesz
     * a visszatérési értéke.
     *
     * @return res Result
     */
    public Result buildIgloo() {
        System.out.println(this.toString() + ".buildIgloo();");
        System.out.println(this.toString() + ".buildIgloo() returned Result res;");
        return null;
    }

    /**
     * Megvizsgálja a rajta található hó mennyiségét. Ha ez nulla, és található rajta jégbe fagyott tárgy,
     * akkor meghívja az Item osztály pickMeUp(Player) függvényét.
     * Sikeres tárgyfelvétel esetén OK-kal tér vissza, egyébként pedig NOTHING-gal.
     *
     * @return REsult az eredménnyel
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