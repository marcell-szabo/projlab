package skeleton;

import java.util.Random;

public class PolarBear {
    /**
     * Default constructor
     */
    public PolarBear(){
    }

    /**
     * Tárolja, hogy a jegesmedve hol található.
     */
    private Field actualfield;

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
        Return actualfield.StepOn(this);
    }
}
