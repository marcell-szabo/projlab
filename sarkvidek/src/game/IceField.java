package game;

import graphics.Draw;
import graphics.Drawable;

import static game.Result.*;

/**
 * Jégtáblák/Jégmezõk kezelésére szolgáló osztály. Egyrészt a jégmezõk teherbírásának vizsgálatát végzi el, másrészt
 * pedig vihar esetén kezeli, hogy ha az adott mezõn esik a hó, akkor az milyen kritériumok mellett
 * (van-e igloo vagy nincs) milyen következményekkel jár (mezõn levõ hórétegek számát mindig növeljük, viszont a
 * testhõ csökkentése csak az iglooval védetlen mezõkön történik meg).
 */
public class IceField extends Field implements Drawable {
    /**
     * Megadja, hogy adott jégmezõre (icefield-re) van-e építve bármi.
     */
    protected Igloo protection;
    /**
     * Tárolja, hogy a mezõn milyen tárgyat lehet felvenni.
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
     * A Field osztályban lévõ absztrakt függvény megvalósítása. Az adott mezõ snow attribútumának értékét megnöveli
     * eggyel. Amennyiben az adott mezõ nem tartalmaz igloo-t, akkor az ilyen mezõn álló játékosokra meghívja a
     * decreaseHeat() metódust. Amivel ez a függvény visszatér, azzal tér vissza a storm() is.
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
     * A Field osztályban található absztrakt függvény megvalósítása.
     * Legelõször megnézi, hogy tartózkodik-e az adott mezõn jegesmedve, ha igen, megnézi, hogy a rajta levõ igloo megvédi-e tõle,
     * ha nem, akkor a függvény DIE-al tér vissza.
     * Ha ezt a vizsgálatot követõen nem keletkezett visszatérési érték, akkor az adott
     * mezõn lévõ játékosok száma kerül vizsgálatra. Amennyiben elbírja az ott tartózkodó karaktereket a
     * jégtábla, akkor OK, ellenkezõ esetben DIE értékkel tér vissza a metódus.
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
        if (players.size() > capacity)
            return  DIE;
        return OK;
    }

    /**
     * A Field osztály virtuális build(Igloo) metódusának a felüldefiniálása. Megvizsgálja, hogy a mezõn, található-e építmény(sátor vagy igloo).
     * Ha igen, akkor visszatér NOTHING-gal, különben pedig OK-kal
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
     * Megvizsgálja a rajta található hó mennyiségét. Ha ez nulla, és található rajta jégbe fagyott tárgy,
     * akkor meghívja az Item osztály pickMeUp(Player) függvényét.
     * Sikeres tárgyfelvétel esetén OK-kal tér vissza, egyébként pedig NOTHING-gal.
     *
     * @return Result az eredménnyel
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

    public Igloo getProtection(){
        return protection;
    }

    public Item getItem(){return item; }

    @Override
    public void draw(Draw draw, int x, int y) {
        if(this.getSnow() != 0) {
            if (this.getProtection() == null) {
                if(this.getSnow() > 3)
                    draw.snowMuchDraw(x,y);
                else
                    draw.snowDraw(x,y);
            }else {
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
            }
            else if (this.getProtection() == null) {
                draw.iceDraw(x,y);
            }else {
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

    public void aging()
    {
        if (protection != null)
        {
            if (protection.aging() == DISAPPEAR)
                protection = null;
        }
    }
}
