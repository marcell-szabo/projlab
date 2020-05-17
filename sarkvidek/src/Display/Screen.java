package Display;

import game.Game;
import graphics.Assets;
import graphics.Draw;

import javax.swing.*;
import java.awt.*;

/**
 * A j�t�k ablak�nak JPanelje
 */
public class Screen extends JPanel {
    /**
     * az aktu�lis j�t�kot t�rolja
     */
    Game game;

    /**
     * A draw oszt�ly p�ld�nya
     */
    Draw draw;

    /**
     * konstruktor, be�ll�tja a m�retet, majd kirajzolja a p�ly�t
     * @param game - az aktu�lis j�t�k
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
     * l�trehoz egy draw p�ld�nyt, majd kirajzolja a p�ly�t �s az �llapot sort.
     */
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw = new Draw(g, game);
        draw.MapDraw();
        draw.stateDraw();
    }

}

