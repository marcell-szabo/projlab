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

    /**
     * Getter f�ggv�ny, visszaadja a jegesmedve jelenlegi mezej�t.
     * @return jelenlegi mez�
     */
    public Field getActualfield(){
        return actualfield;
    }

    /**
     * Setter f�ggv�ny, be�ll�tja a jegesmedve mezej�t a param�terk�nt kapott mez�re.
     * @param f - a be�ll�tand� mez�
     */
    public void setActualfield(Field f){
        actualfield = f;
    }


    /**El�sz�r addig h�vogatja meg �tadva neki random gener�lt ir�nyokat a Field oszt�ly
     * checkNeighbour(int) f�ggv�ny�t, am�g az nem NULL �rt�kkel t�r vissza. Ezt k�vet�en
     * szint�n a Field oszt�ly, b�r most a leaveField() f�ggv�nye ker�l megh�v�sra. V�g�l
     * pedig a stepOn(PolarBear) met�dusa h�v�dik meg. Amivel visszat�r, azzal fog a move() is.
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

    /**
     * A Drawable interf�szb�l implement�lt f�ggv�ny. Megh�vja a saj�t mag�t kirajzol� f�ggv�nyt a Draw oszt�lyban.
     * @param draw - Draw oszt�ly p�ld�nya amelyben implement�lva van a jegesmedv�t kirajzol� f�ggv�ny.
     * @param x - kirajzol�s hely�nek X koordin�t�ja
     * @param y - kirajzol�s hely�nek Y koordin�t�ja
     */
    @Override
    public void draw(Draw draw, int x, int y) {
        draw.polarbearDraw(x, y);
    }
}
