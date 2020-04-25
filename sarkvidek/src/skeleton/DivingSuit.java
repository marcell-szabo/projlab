package skeleton;

import java.util.*;

import static skeleton.Direction.*;

/**
 * A búvárruha felvételének, illetve használatának kezelésére szolgáló osztály.
 */
public class DivingSuit implements Tool {

    /**
     * Default constructor
     */
    public DivingSuit() {
    }

    /**
     * Mindig FALSE értékkel tér vissza (hiszen csak akkor hívódik meg, ha egy DivingSuit-tól különbözõ
     * példány szeretné magát összehasonlítani vele).
     *
     * @param t az összehasonlításhoz szükséges Tool példány
     * @return true
     */
    @Override
    public boolean isSame(Tool t) {
        return false;
    }

    /**
     * Mindig TRUE értékkel tér vissza (hiszen csak akkor hívódik meg, ha egy DivingSuit
     * példány szeretné magát összehasonlítani vele).
     *
     * @param d az összehasonlításhoz szükséges DivingSuit példány
     * @return true
     */
    public boolean isSame(DivingSuit d) {
        return true;
    }

    /**
     * Legelõször a Player osztály getTools() függvénye kerül meghívásra,
     * mely a játékosnál lévõ eszközöket tartalmazó listával tér vissza.
     * Ezt követõen meghívja a lista minden elemére a Tool osztály isSame(Tool) metódusát.
     * Ezután ezeknek a visszatérési értékei kerülnek vizsgálat alá.
     * Amennyiben minden függvény hívást követõen csak FALSE visszatérési értékeket kapunk,
     * akkor meghívásra kerül a Player osztály addTool(Tool) metódusa, majd ezt követõen OK-kal tér vissza.
     * Különben pedig NOTHING lesz a visszatérési érték.
     * @param p - A Játékos aki felvesz egy Toolt
     * @return Reasult a felvétel sikerességérõl
     */
    @Override
    public Result pickMeUp(Player p) {
        List<Tool> tools = p.getTools();
        boolean can = true;
        for (int i = 0; i<tools.size(); i++){
            if (tools.get(i).isSame(this)) can = false;
        }
        if(can) p.addTool(this);
        return can? Result.OK : Result.NOTHING;
    }

    /**
     * NOTHING értékkel tér vissza .
     * @param f  A mezõ, amin az ásást kell végrehajtani
     * @return Result a lapátolásról
     */
    @Override
    public Result clean(Field f) {
        return Result.NOTHING;
    }

    /**
     * A Tool osztály swim(Field, Player) függvényének felüldefiniálása.
     * A játékos által megadott irányt átadva meghívja az actualfield checkNeighbour(int) metódusát,
     * ami visszatér az ott található mezõ referenciájával.
     * Ha ez NULL érték lenne (tehát arra tenger található), akkor újra meg kell adni egy irányt.
     * Ha megkaptuk a választott szomszédos mezõ referenciáját, akkor ezt átadva meghívódik
     * a paraméterben megkapott játékos changeField(Field) függvénye.
     * Ennek a metódusnak a visszatérési értékével tér vissza a swim(Field, Player) függvény is.
     *
     * @param f a mezõ (lyuk), amibe beleesett a player
     * @param p melyik játékos esett bele
     * @return Result a kimászásról
     */
    @Override
    public Result swim(Field f, Player p) {
        System.out.println("A J(jobbra), B(balra), F(fel), L(le) karakterek segítségével válasszon," +
                "mely irányba szeretne kimászni.");
        Field choosedField = null;
        while (choosedField == null) {
            Scanner sc = new Scanner(System.in);
            String c = sc.next();
            int d = 0;
            switch (c) {
                case "J":
                    d = 0;
                case "B":
                    d = 1;
                case "F":
                    d = 2;
                case "L":
                    d = 3;
            }
            choosedField = f.checkNeighbour(d);
            if (choosedField == null)
                System.out.println("A választott irányban tenger található, adjon meg új irányt!");
        }
        return p.changeField(choosedField);
    }

    /**
     * NOTHING értékkel tér vissza.
     * @param f Az a field amire a player lépni akar
     * @param p Az a játékos amelyik a másik fieldre lépne
     * @return Result a segítségrõl
     */
    @Override
    public Result help(Field f, Player p) {
        return Result.NOTHING;
    }

    /**
     * NOTHING értékkel tér vissza.
     * @param f A mezõ, amire sátrat kell építeni
     * @return Result az építésrõl
     */
    @Override
    public Result build(Field f) {
        return Result.NOTHING;
    }
}