package skeleton;

import java.util.*;

/**
 * Az ásó felvételének, illetve az ásóval rendelkező játékosok hóréteg ellapátolásának kezelésére szolgáló osztály.
 */
public class Shovel extends Tool {

    /**
     * Default constructor
     */
    public Shovel() {
    }

    /**
     * a paraméterknt megadott karakter felvesz egy ásót
     * @param p a karakter aki felveszi az ásót
     * @return Result a felvétel sikerességéről
     */
    @Override
    public Result pickMeUp(Player p) {
        System.out.println(this.toString() + ".pickMeUp(p);");
        p.addTool(this);
        System.out.println(this.toString() + ".pickMeUp(p) returned Return res;");
        return null;
    }

    /**
	* Mindig TRUE értékkel tér vissza (hiszen csak akkor hívódik meg, ha egy Shovel példány szeretné magát összehasonlítani vele).
     * @param s 
     * @return
     */
    public boolean isSame(Shovel s) {
        // TODO implement here
        return false;
    }

    /**
	* Akkor hívódik meg, ha az ásást végző játékosnál van ásó. Ekkor ez a függvény meghívja a Field clean() metódusát, ezzel még egy réteget ellapátolva arról (persze, ha ez lehetséges). Void visszatérésű, mivel nincs jelentősége, hogy ez a művelet sikerült-e vagy sem.
     * @param f
     */
    public void clean(Field f) {
        System.out.print(this.toString() + ".clean(Field f);\n");
        f.clean();
    }

}