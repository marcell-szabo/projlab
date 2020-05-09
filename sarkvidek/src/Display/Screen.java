package Display;

import game.Game;
import graphics.Assets;
import graphics.Draw;

import javax.swing.*;
import java.awt.*;

public class Screen extends JPanel {
    Game game;

    public Screen(Game game){
        setPreferredSize(new Dimension(840,600));
        this.game = game;

        repaint();

    }

    @Override
    public void paint(Graphics g){
        System.out.println("fing");
        Draw draw = new Draw(g, game);

        draw.MapDraw();
    }

}

