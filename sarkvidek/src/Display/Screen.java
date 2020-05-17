package Display;

import game.Game;
import graphics.Assets;
import graphics.Draw;

import javax.swing.*;
import java.awt.*;

/**
 * A játék ablakának JPanelje
 */
public class Screen extends JPanel {
    /**
     * az aktuális játékot tárolja
     */
    Game game;

    /**
     * A draw osztály példánya
     */
    Draw draw;

    /**
     * konstruktor, beállítja a méretet, majd kirajzolja a pályát
     * @param game - az aktuális játék
     */
    public Screen(Game game){
        setPreferredSize(new Dimension(840,660));
        setMinimumSize(new Dimension(840,660));
        setMaximumSize(new Dimension(840,660));
        this.game = game;
        this.repaint();
    }

    @Override
    /**
     * létrehoz egy draw példányt, majd kirajzolja a pályát és az állapot sort.
     */
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw = new Draw(g, game);
        draw.MapDraw();
        draw.stateDraw();
    }

}

