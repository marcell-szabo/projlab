package Display;

import game.Game;
import graphics.Assets;
import graphics.Draw;

import javax.swing.*;
import java.awt.*;

public class Screen extends JPanel {
    Game game;
    Draw draw;

    public Screen(Game game){
        setPreferredSize(new Dimension(840,660));
        setMinimumSize(new Dimension(840,660));
        setMaximumSize(new Dimension(840,660));
        this.game = game;
        this.repaint();
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw = new Draw(g, game);
        draw.MapDraw();
        draw.stateDraw();
    }

}

