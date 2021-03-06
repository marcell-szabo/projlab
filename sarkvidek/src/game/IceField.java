package game;

import graphics.Draw;
import graphics.Drawable;

import static game.Result.*;

/**
 * J�gt�bl�k/J�gmez�k kezel�s�re szolg�l� oszt�ly. Egyr�szt a j�gmez�k teherb�r�s�nak vizsg�lat�t v�gzi el, m�sr�szt
 * pedig vihar eset�n kezeli, hogy ha az adott mez�n esik a h�, akkor az milyen krit�riumok mellett
 * (van-e igloo vagy nincs) milyen k�vetkezm�nyekkel j�r (mez�n lev� h�r�tegek sz�m�t mindig n�velj�k, viszont a
 * testh� cs�kkent�se csak az iglooval v�detlen mez�k�n t�rt�nik meg).
 */
public class IceField extends Field implements Drawable {
    /**
     * Megadja, hogy adott j�gmez�re (icefield-re) van-e �p�tve b�rmi.
     */
    protected Igloo protection;
    /**
     * T�rolja, hogy a mez�n milyen t�rgyat lehet felvenni.
     */
    protected Item item;


    /**
     * Default constructor
     */
    public IceField(int snow, int capacity, Item item, String name) {
        super(snow, capacity, name);
        this.item = item;
    }

    /**
     * A Field oszt�lyban l�v� absztrakt f�ggv�ny megval�s�t�sa. Az adott mez� snow attrib�tum�nak �rt�k�t megn�veli
     * eggyel. Amennyiben az adott mez� nem tartalmaz igloo-t, akkor az ilyen mez�n �ll� j�t�kosokra megh�vja a
     * decreaseHeat() met�dust. Amivel ez a f�ggv�ny visszat�r, azzal t�r vissza a storm() is.
     *
     * @return
     */
    public Result storm()
    {
        snow++;
        Result r = NOTHING;
        if (protection == null)
        {
            for (Player ps : players)
            {
                r = ps.decreaseHeat();
                if (r == DIE)
                    return r;
            }
        }
        return r;
    }

    /**
     * A Field oszt�lyban tal�lhat� absztrakt f�ggv�ny megval�s�t�sa.
     * Legel�sz�r megn�zi, hogy tart�zkodik-e az adott mez�n jegesmedve, ha igen, megn�zi, hogy a rajta lev� igloo megv�di-e t�le,
     * ha nem, akkor a f�ggv�ny DIE-al t�r vissza.
     * Ha ezt a vizsg�latot k�vet�en nem keletkezett visszat�r�si �rt�k, akkor az adott
     * mez�n l�v� j�t�kosok sz�ma ker�l vizsg�latra. Amennyiben elb�rja az ott tart�zkod� karaktereket a
     * j�gt�bla, akkor OK, ellenkez� esetben DIE �rt�kkel t�r vissza a met�dus.
     *
     * @param p
     * @return Result
     */
    public Result stepOn(Player p)
    {
        players.add(p);
        if(protection != null)
            if (polarbear.getActualfield() == this && !protection.protectFromBear())
                return  DIE;
       else if(protection == null)
           return DIE;
        if (players.size() > capacity)
            return  DIE;
        return OK;
    }

    /**
     * A Field oszt�ly virtu�lis build(Igloo) met�dus�nak a fel�ldefini�l�sa. Megvizsg�lja, hogy a mez�n, tal�lhat�-e �p�tm�ny(s�tor vagy igloo).
     * Ha igen, akkor visszat�r NOTHING-gal, k�l�nben pedig OK-kal
     *
     * @return res Result
     */
    public Result build(Igloo i)
    {
        if (protection == null) {
            protection = i;
            return OK;
        }
        return NOTHING;
    }

    /**
     * Megvizsg�lja a rajta tal�lhat� h� mennyis�g�t. Ha ez nulla, �s tal�lhat� rajta j�gbe fagyott t�rgy,
     * akkor megh�vja az Item oszt�ly pickMeUp(Player) f�ggv�ny�t.
     * Sikeres t�rgyfelv�tel eset�n OK-kal t�r vissza, egy�bk�nt pedig NOTHING-gal.
     *
     * @return Result az eredm�nnyel
     */
    public Result pickUp(Player p)
    {
        if(snow == 0 && item != null)
        {
            Result result = item.pickMeUp(p);
            if(result == OK)
                item = null;
            return result;
        }
        return NOTHING;
    }

    /**
     * Visszaadja a mez�n l�v� esetleges v�delmet (iglu vagy s�tor).
     * @return iglu vagy s�tor
     */
    public Igloo getProtection(){
        return protection;
    }

    /**
     * Getter f�ggv�ny, visszaadja az esetlegesen a mez�n l�v� t�rgyat.
     * @return t�rgy
     */
    public Item getItem(){return item; }

    /**
     * A Drawable interf�szb�l implement�lt f�ggv�ny. Megh�vja a saj�t mag�t kirajzol� f�ggv�nyt a Draw oszt�lyban, �s
     * tov�bbh�vja az esetlegesen rajta l�v� objektumok kirajzol� f�ggv�nyeit.
     * @param draw - Draw oszt�ly p�ld�nya amelyben implement�lva van a IceField-t kirajzol� f�ggv�ny.
     * @param x - kirajzol�s hely�nek X koordin�t�ja
     * @param y - kirajzol�s hely�nek Y koordin�t�ja
     */
    @Override
    public void draw(Draw draw, int x, int y) {
        if(this.getSnow() != 0) {
            if (this.getProtection() == null) {
                if(this.getSnow() > 3)
                    draw.snowMuchDraw(x,y);
                else
                    draw.snowDraw(x,y);
            }else if(this.getProtection() != null) {
                if(this.getSnow() > 3)
                    draw.snowMuchDraw(x,y);
                else
                    draw.snowDraw(x,y);
                this.getProtection().draw(draw, x, y);
            }
            if(polarbear.actualfield == this)
                polarbear.draw(draw, x, y);
            if(this.players.size() > 0){
                for(Player p : players)
                    p.draw(draw, x, y);
            }
        } else {
            if(this.getItem() != null){
                this.getItem().draw(draw, x, y);
                if(this.getProtection() != null) {
                    draw.iceDraw(x, y);
                    if (this.getProtection().protectFromBear())
                        draw.iglooDraw(x, y);
                    else
                        draw.tentOpenDraw(x, y);
                }
            }
            else if (this.getProtection() == null) {
                draw.iceDraw(x,y);
            }else if(this.getProtection() != null){
                draw.iceDraw(x,y);
                if(this.getProtection().protectFromBear())
                    draw.iglooDraw(x, y);
                else
                    draw.tentOpenDraw(x, y);
            }
            if(polarbear.actualfield == this)
                polarbear.draw(draw, x, y);
            if(this.players.size() > 0){
                for(Player p : players)
                    p.draw(draw, x, y);
            }
        }
    }

    /**
     * Field oszt�lyban l�v� absztrakt f�ggv�ny megval�s�t�sa. A jegesmedve mez�re l�p�s�t v�gzi. Ha nincs v�delem �s j�t�kos
     * tart�zkodik a mez�n akkor v�ge a j�t�knak, ekkor DIE-al t�r vissza, k�l�nben OK-al.
     * @param pb - jegesmedve referenci�ja
     * @return a jegesmedve mez�re l�p�s�nek v�geredm�nye
     */
    @Override
    public Result stepOn(PolarBear pb)
    {
        polarbear = pb;
        if(players.size() == 0)
            return OK;
        else if (protection == null)
            return  DIE;
        else if (protection.protectFromBear())
            return  OK;
        return DIE;
    }

    /**
     * A mez�n esetlegesen l�v� s�tor �reg�t�se.
     */
    public void aging()
    {
        if (protection != null)
        {
            if (protection.aging() == DISAPPEAR)
                protection = null;
        }
    }
}
