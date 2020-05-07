package graphics;

import game.Field;
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
                fields.get(12*y + x).draw(this, (x+1) * 60, (y+1)*60);
            }
        }
    }

    public void IceFieldDraw(int x, int y){
        g.drawImage(Assets.texture.get("ice"), x, y, null);
    }


    public void seaDraw(){
        for(int x = 0; x < 14; x++)
            g.drawImage(Assets.texture.get("sea"), x*60, 0,null);

        for(int x = 0; x < 14; x++)
            g.drawImage(Assets.texture.get("sea"), x*60, 540,null);

        for(int y = 0; y < 8; y++)
            g.drawImage(Assets.texture.get("sea"), 0, (y+1)*60,null);

        for(int y = 0; y < 8; y++)
            g.drawImage(Assets.texture.get("sea"), 780, (y+1)*60,null);

    }

    public void holeDraw(int x, int y) {
        g.drawImage(Assets.texture.get("hole"), x, y, null);
    }

    public void tentDraw(int x, int y) {
        g.drawImage(Assets.texture.get("tentsnow"), x, y, null);
    }
}
