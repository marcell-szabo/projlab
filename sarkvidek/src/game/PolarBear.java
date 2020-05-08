package game;

import graphics.Draw;
import graphics.Drawable;

import java.util.Random;

public class PolarBear implements Drawable {
    /**
     * Default constructor
     */
    public PolarBear(Field field){
        setActualfield(field);
    }


    /**
     * Tárolja, hogy a jegesmedve hol található.
     */
    protected Field actualfield;

    public Field getActualfield(){
        return actualfield;
    }

    public void setActualfield(Field f){
        actualfield = f;
    }


    /**Elõször addig hívogatja meg átadva neki random generált irányokat a Field osztály
     * checkNeighbour(int) függvényét, amíg az nem NULL értékkel tér vissza. Ezt követõen
     * szintén a Field osztály, bár most a leaveField() függvénye kerül meghívásra. Végül
     * pedig a stepOn(PolarBear) metódusa hívódik meg. Amivel visszatér, azzal fog a move() is.
     *
     * @return Result
     */
    public Result move()
    {
        Field choosedField = null;
        while(choosedField == null)
        {
            choosedField = actualfield.checkNeighbour(new Random().nextInt(3));
        }
        actualfield.leaveField();
        this.setActualfield(choosedField);
        Result res = choosedField.stepOn(this);

        return res;
    }



    @Override
    public void draw(Draw draw, int x, int y) {
        draw.polarbearDraw(x, y);
    }
}
