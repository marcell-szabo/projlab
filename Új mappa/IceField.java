
import java.util.*;

/**
 * Jégtáblák/Jégmezők kezelésére szolgáló osztály. Egyrészt a jégmezők teherbírásának vizsgálatát végzi el, másrészt pedig vihar esetén kezeli, hogy ha az adott mezőn esik a hó, akkor az milyen kritériumok mellett (van-e igloo vagy nincs) milyen következményekkel jár (mezőn levő hórétegek számát mindig növeljük, viszont a testhő csökkentése csak az iglooval védetlen mezőkön történik meg).
 */
public class IceField extends Field {

    /**
     * Default constructor
     */
    public IceField() {
    }

    /**
     * Megadja, hogy adott mező tartalmaz-e igloot. (Ha tartalmaz, akkor TRUE az értéke)
     */
    private boolean igloo;

    /**
	* A Field osztályban lévő absztrakt függvény megvalósítása. Az adott mező snow attribútumának értékét megnöveli eggyel. Amennyiben az adott mező nem tartalmaz igloo-t, akkor az ilyen mezőn álló játékosokra meghívja a decreaseHeat() metódust. Amivel ez a függvény visszatér, azzal tér vissza a storm() is.
     * @return
     */
    public Result storm() {
        // TODO implement here
        return null;
    }

    /**
	* A Field osztályban lévő absztrakt függvény megvalósítása. OK értékkel tér vissza, ha az adott mezőn lévő játékosok számát még elbírja a jégtábla. Ellenkező esetben pedig DIE értékkel fog visszatérni.
     * @param p 
     * @return
     */
    public Result stepOn(Player p) {
        // TODO implement here
        return null;
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