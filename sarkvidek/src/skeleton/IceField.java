package skeleton;

import java.util.*;

import skeleton.Result;

import static skeleton.Result.OK;

/**
 * Jégtáblák/Jégmezők kezelésére szolgáló osztály. Egyrészt a jégmezők teherbírásának vizsgálatát végzi el, másrészt
 * pedig vihar esetén kezeli, hogy ha az adott mezőn esik a hó, akkor az milyen kritériumok mellett
 * (van-e igloo vagy nincs) milyen következményekkel jár (mezőn levő hórétegek számát mindig növeljük, viszont a
 * testhő csökkentése csak az iglooval védetlen mezőkön történik meg).
 */
public class IceField extends Field {
    /**
     * Megadja, hogy adott mező tartalmaz-e igloot. (Ha tartalmaz, akkor TRUE az értéke)
     */
    private boolean igloo;

    /**
     * Default constructor
     */
    public IceField() {
        super();
    }

    /**
     * A Field osztályban lévő absztrakt függvény megvalósítása. Az adott mező snow attribútumának értékét megnöveli
     * eggyel. Amennyiben az adott mező nem tartalmaz igloo-t, akkor az ilyen mezőn álló játékosokra meghívja a
     * decreaseHeat() metódust. Amivel ez a függvény visszatér, azzal tér vissza a storm() is.
     *
     * @return
     */
    public Result storm() {
        Result r = Result.OK;
        System.out.print(this.toString() + ".storm();\n");
        System.out.print("Van iglu a jégtáblán? i/n \n");
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
     * A Field osztályban lévő absztrakt függvény megvalósítása. OK értékkel tér vissza, ha az adott mezőn lévő
     * játékosok számát még elbírja a jégtábla. Ellenkező esetben pedig DIE értékkel fog visszatérni.
     *
     * @param p
     * @return Result
     */
    public Result stepOn(Player p) {
        // TODO implement here
        return null;
    }

    /**
     * Ha van igloo a mezőn, akkor TRUE-val tér vissza, ellenkező esetben pedig FALSE-szal.
     *
     * @return
     */
    public boolean haveIgloo() {
        // TODO implement here
        return false;
    }

    /**
     * A Field osztály virtuális buildIgloo() metódusának a felüldefiniálása. Akkor hívódik meg, ha egy eszkimó
     * igloot szeretne építeni a jégtáblán. Ha még nem volt igloo a mezőn, akkor az igloo attribútum értékét
     * TRUE-ra állítja, majd OK értékkel tér vissza. Amennyiben volt igloo az adott, mezőn, akkor NOTHING lesz
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
        System.out.println("Adja meg a kívánt kódot\n" + "1. Ásó felvétele\n2. Kötél felvétele\n"
                + "3. Búvárruha felvétele\n4. Étel elfogyasztása\n5. Jelzőrakéta alkatrészének felvétele\n");
        int tool = scan.nextInt();
        System.out.println(tool);
        switch (tool) {
            case 1:
                System.out.println("Ásó felvétele\n");
                System.out.println("1. Van már ásója\n2. Nincs ásója\n");
                int shovel = scan.nextInt();
                System.out.println(shovel);
                switch (shovel) {
                    case 1:
                        System.out.println("Van már ásója\n");
                        System.out.println(this.toString() + ".pickUp(e);");
                        tools = p.getTools();
                        System.out.println("ice.pickUp(e) returned Result res;");
                        break;
                    case 2:
                        System.out.println("Nincs ásója\n");
                        System.out.println(this.toString() + ".pickUp(e);");
                        tools = p.getTools();
                        item = new Shovel();
                        res = item.pickMeUp(p);
                        System.out.println("ice.pickUp(e) returned Result res;");
                        break;
                    default:
                        System.out.println("Helytelen érték\n");
                        break;

                }
                break;
            case 2:
                System.out.println("Kötél felvétele\n");
                System.out.println("1. Van már kötele\n2. Nincs kötele\n");
                int rope = scan.nextInt();
                System.out.println(rope);
                switch (rope) {
                    case 1:
                        System.out.println("Van már kötele\n");
                        System.out.println(this.toString() + ".pickUp(e);");
                        tools = p.getTools();
                        System.out.println("ice.pickUp(e) returned Result res;");
                        break;
                    case 2:
                        System.out.println("Nincs kötele\n");
                        System.out.println(this.toString() + ".pickUp(e);");
                        tools = p.getTools();
                        item = new Rope();
                        res = item.pickMeUp(p);
                        System.out.println("ice.pickUp(e) returned Result res;");
                        break;
                    default:
                        System.out.println("Helytelen érték\n");
                        break;
                }
                break;
            case 3:
                System.out.println("Búvárruha felvétele\n");
                System.out.println("1. Van már búvárruhája\n2. Nincs búvárruhája\n");
                int divingsuit = scan.nextInt();
                System.out.println(divingsuit);
                switch (divingsuit) {
                    case 1:
                        System.out.println("Van már búvárruhája\n");
                        System.out.println(this.toString() + ".pickUp(e);");
                        tools = p.getTools();
                        System.out.println("ice.pickUp(e) returned Result res;");
                        break;
                    case 2:
                        System.out.println("Nincs búvárruhája\n");
                        System.out.println(this.toString() + ".pickUp(e);");
                        tools = p.getTools();
                        item = new DivingSuit();
                        res = item.pickMeUp(p);
                        System.out.println("ice.pickUp(e) returned Result res;");
                        break;
                    default:
                        System.out.println("Helytelen érték\n");
                        break;
                }
                break;
            case 4:
                System.out.println("Étel fogyasztása\n");
                System.out.println("1. A testője maximumon van\n2. Nincs maximumon a testhője\n");
                int food = scan.nextInt();
                System.out.println(food);
                switch (food) {
                    case 1:
                        System.out.println("A testője maximumon van\n");
                        System.out.println(this.toString() + ".pickUp(e);");
                        tools = p.getTools();
                        System.out.println("ice.pickUp(e) returned Result res;");
                        break;
                    case 2:
                        System.out.println("Nincs maximumon a testhője\n");
                        System.out.println(this.toString() + ".pickUp(e);");
                        tools = p.getTools();
                        item = new Food();
                        res = item.pickMeUp(p);
                        System.out.println("ice.pickUp(e) returned Result res;");
                        break;
                    default:
                        System.out.println("Helytelen érték\n");
                        break;
                }
                break;
            case 5:
                System.out.println("Jelzőrakéta alkatrészének felvétele\n");
                System.out.println(this.toString() + ".pickUp(e);");
                tools = p.getTools();
                item = new FlareGun();
                res = item.pickMeUp(p);
                System.out.println("ice.pickUp(e) returned Result res;");
                break;
        }
        return null;
    }


}