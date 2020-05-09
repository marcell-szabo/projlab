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
     * T�rolja, hogy a jegesmedve hol tal�lhat�.
     */
    protected Field actualfield;

    public Field getActualfield(){
        return actualfield;
    }

    public void setActualfield(Field f){
        actualfield = f;
    }


    /**El�sz�r addig h�vogatja meg �tadva neki random gener�lt ir�nyokat a Field oszt�ly
     * checkNeighbour(int) f�ggv�ny�t, am�g az nem NULL �rt�kkel t�r vissza. Ezt k�vet�en
     * szint�n a Field oszt�ly, b�r most a leaveField() f�ggv�nye ker�l megh�v�sra. V�g�l
     * pedig a stepOn(PolarBear) met�dusa h�v�dik meg. Amivel visszat�r, azzal fog a move() is.
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
