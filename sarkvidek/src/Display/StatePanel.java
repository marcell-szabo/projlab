package Display;

import game.Game;
import graphics.Draw;

import javax.swing.*;
import java.awt.*;

public class StatePanel extends JPanel {
    Game game;

    public StatePanel(Game game){
        setSize(840, 60);
        this.game = game;
        this.repaint();
    }

    @Override
    public void paint(Graphics g){
        g.drawString("Aktuális játékos: ", 0, 0);
    }
}
