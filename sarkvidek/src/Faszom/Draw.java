package Faszom;

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
        FieldsDraw fieldsDraw = new FieldsDraw(g, game);
        fieldsDraw.MapDraw();
    }
}
