package graphics;

import game.Game;

import java.awt.*;

public class Draw {
    Graphics g;
    Game game;

    public Draw(Graphics g, Game game){
        this.g = g;
        this.game = game;
    }

    public void MapDraw(){
        seaDraw();
        var fields = game.getGameboard().getFields();
        for(int y = 0; y < 8; y++ ) {
            for (int x = 0; x < 12; x++) {
                fields.get(12*y + x).draw(this, (x+1) * 60, ((y+1)*60));
            }
        }
    }




    public void seaDraw(){
        for(int x = 0; x < 14; x++)
            g.drawImage(Assets.texture.get("sea"), x*60, 0,null);

        for(int x = 0; x < 14; x++)
            g.drawImage(Assets.texture.get("sea"), x*60, 540,null);

        for(int y = 0; y < 8; y++)
            g.drawImage(Assets.texture.get("sea"), 0, ((y+1)*60),null);

        for(int y = 0; y < 8; y++)
            g.drawImage(Assets.texture.get("sea"), 780, ((y+1)*60),null);

    }


    public void holeDraw(int x, int y) {
        g.drawImage(Assets.texture.get("hole"), x, y, null);
    }

    public void iceDraw(int x, int y) {
        g.drawImage(Assets.texture.get("ice"), x, y, null);
    }

    public void tentOpenDraw(int x, int y) {
        g.drawImage(Assets.texture.get("tentopen"), x, y, null);
    }

    public void iglooDraw(int x, int y) {
        g.drawImage(Assets.texture.get("igloo"), x, y, null);
    }

    public void snowDraw(int x, int y) {
        g.drawImage(Assets.texture.get("snow"), x, y, null);
    }

    public void polarbearHoleDraw(int x, int y) {
        g.drawImage(Assets.texture.get("holepb"), x, y, null);
    }

    public void polarbearDraw(int x, int y) {
        g.drawImage(Assets.texture.get("bear"), x, y, null);
    }

    public void esbDraw(int x, int y) {
        g.drawImage(Assets.texture.get("esb"), x, y, null);
    }

    public void esgDraw(int x, int y) {
        g.drawImage(Assets.texture.get("esg"), x, y, null);
    }

    public void esoDraw(int x, int y) {
        g.drawImage(Assets.texture.get("eso"), x, y, null);
    }

    public void espDraw(int x, int y) {
        g.drawImage(Assets.texture.get("esp"), x, y, null);
    }

    public void esrDraw(int x, int y) {
        g.drawImage(Assets.texture.get("esr"), x, y, null);
    }

    public void esyDraw(int x, int y) {
        g.drawImage(Assets.texture.get("esy"), x, y, null);
    }

    public void exbDraw(int x, int y) {
        g.drawImage(Assets.texture.get("exb"), x, y, null);
    }

    public void exgDraw(int x, int y) {
        g.drawImage(Assets.texture.get("exg"), x, y, null);
    }

    public void exoDraw(int x, int y) {
        g.drawImage(Assets.texture.get("exo"), x, y, null);
    }

    public void expDraw(int x, int y) {
        g.drawImage(Assets.texture.get("exp"), x, y, null);
    }

    public void exrDraw(int x, int y) {
        g.drawImage(Assets.texture.get("exr"), x, y, null);
    }

    public void exyDraw(int x, int y) {
        g.drawImage(Assets.texture.get("exy"), x, y, null);
    }

    public void flareDraw(int x, int y) {
        g.drawImage(Assets.texture.get("flare"), x, y, null);
    }

    public void shovelDraw(int x, int y) {
        g.drawImage(Assets.texture.get("shovel"), x, y, null);
    }

    public void foodDraw(int x, int y) {
        g.drawImage(Assets.texture.get("food"), x, y, null);
    }

    public void gunDraw(int x, int y) {
        g.drawImage(Assets.texture.get("gun"), x, y, null);
    }

    public void ropeDraw(int x, int y) {
        g.drawImage(Assets.texture.get("rope"), x, y, null);
    }

    public void tentDraw(int x, int y) {
        g.drawImage(Assets.texture.get("tent"), x, y, null);
    }

    public void chargeDraw(int x, int y) {
        g.drawImage(Assets.texture.get("charge"), x, y, null);
    }

    public void divingSuitDraw(int x, int y) {
        g.drawImage(Assets.texture.get("divingsuit"), x, y, null);
    }

    public void snowMuchDraw(int x, int y) {
        g.drawImage(Assets.texture.get("muchsnow"), x, y, null);
    }
}
