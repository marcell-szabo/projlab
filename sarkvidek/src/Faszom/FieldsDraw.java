package Faszom;

import game.Field;
import game.Game;
import graphics.Assets;

import java.awt.*;

public class FieldsDraw {
    Graphics g;
    Game game;

    public FieldsDraw(Graphics g, Game game){
        this.g = g;
        this.game = game;
    }

    public void MapDraw(){
        seaDraw();
        int y = 60;
        Field first = game.getStartField();
        Field field = game.getStartField();
        for(int i = 0; i < 8; i++ ) {
            for (int x = 0; x < 12; x++) {
                FieldDraw(field, (x+1) * 60, y);
                if(field.checkNeighbour(1) == null)
                    break;
                field = field.checkNeighbour(1);
            }
            if(first.checkNeighbour(2) == null)
                break;
            first = first.checkNeighbour(2);
            field = first;
            y += 60;
        }
    }

    private void FieldDraw(Field field, int x, int y){
        if(field != null) {
            if (field.getSnow() == 0) {
                if (field.getCapacity() == 0)
                    g.drawImage(Assets.texture.get("hole"), x, y, null);
                else
                    g.drawImage(Assets.texture.get("ice"), x, y, null);

            } else {
                if (field.getProtection() != null && field.getProtection().protectFromBear())
                    g.drawImage(Assets.texture.get("igloosnow"), x, y, null);
                else if (field.getProtection() != null && !field.getProtection().protectFromBear())
                    g.drawImage(Assets.texture.get("tentsnow"), x, y, null);
                else g.drawImage(Assets.texture.get("snow"), x, y, null);
            }
        }

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
}
