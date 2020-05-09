package Display;

import game.Game;
import graphics.Assets;
import graphics.Draw;

import javax.swing.*;
import java.awt.*;

public class Screen extends JPanel{
    Game game;
    Draw draw;

    public Screen(Game game){
        setPreferredSize(new Dimension(840,600));
        setMinimumSize(new Dimension(840,600));
        setMaximumSize(new Dimension(840,600));
        this.game = game;
        this.repaint();
    }

    @Override
    public void paint(Graphics g){
        System.out.println("fing");
        draw = new Draw(g, game);

        draw.MapDraw();
    }

}

