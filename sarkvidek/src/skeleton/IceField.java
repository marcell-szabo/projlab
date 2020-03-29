package skeleton;

import java.util.*;

/**
 * Jégtáblák/Jégmezők kezelésére szolgáló osztály. Egyrészt a jégmezők teherbírásának vizsgálatát végzi el, másrészt pedig vihar esetén kezeli, hogy ha az adott mezőn esik a hó, akkor az milyen kritériumok mellett (van-e igloo vagy nincs) milyen következményekkel jár (mezőn levő hórétegek számát mindig növeljük, viszont a testhő csökkentése csak az iglooval védetlen mezőkön történik meg).
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
    }

    /**
	* A Field osztályban lévő absztrakt függvény megvalósítása. Az adott mező snow attribútumának értékét megnöveli eggyel. Amennyiben az adott mező nem tartalmaz igloo-t, akkor az ilyen mezőn álló játékosokra meghívja a decreaseHeat() metódust. Amivel ez a függvény visszatér, azzal tér vissza a storm() is.
     * @return
     */
    public Result storm() {
        Result r = Result.OK;
        System.out.print(this.toString() + ".storm();\n");
        System.out.print("Van iglu a jégtáblán? i/n \n");
        Scanner scan = new Scanner(System.in);
        char c = scan.next().charAt(0);
        if(c == 'n') {
            Eskimo esk = new Eskimo();
            Explorer exp = new Explorer();
            players.add(esk);
            players.add(exp);
            for(Player p : players) {
                r = p.decreaseHeat();
            }
        }
        System.out.print(this.toString() + ".storm() returned Result r;\n");
        return r;
    }

    /**
	* A Field osztályban lévő absztrakt függvény megvalósítása. OK értékkel tér vissza, ha az adott mezőn lévő játékosok számát még elbírja a jégtábla.
     * Ellenkező esetben pedig DIE értékkel fog visszatérni.
     * @param p 
     * @return
     */
    public Result stepOn(Player p) {
        System.out.print(this.toString() + ".stepOn(Player p);\n");
        if (capacity >= players.size()+1) {
            System.out.print(this.toString() + ".stepOn(Player p) returned Result r;\n");
            return Result.OK;
        }
        System.out.print(this.toString() + ".stepOn(Player p) returned Result r;\n");
        return Result.DIE;
    }

    /**
	* Ha van igloo a mezőn, akkor TRUE-val tér vissza, ellenkező esetben pedig FALSE-szal.
     * @return
     */
    public boolean haveIgloo() {
        // TODO implement here
        return false;
    }

    /**
	*A Field osztály virtuális buildIgloo() metódusának a felüldefiniálása. Akkor hívódik meg, ha egy eszkimó igloot szeretne építeni a jégtáblán. Ha még nem volt igloo a mezőn, akkor az igloo attribútum értékét TRUE-ra állítja, majd OK értékkel tér vissza. Amennyiben volt igloo az adott, mezőn, akkor NOTHING lesz a visszatérési értéke.
     * @return
     */
    public Result buildIgloo() {
        // TODO implement here
        return null;
    }

}