package Display;

import game.Game;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    Screen s;
    Game game;
    Canvas canvas;

    public Frame(Game game) {

        this.game = game;
        setSize(840,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        init();
        pack();
        setLocationRelativeTo(null);
    }

    private void init() {
        setLocationRelativeTo(null);
         s = new Screen(game);
         add(s);

         setVisible(true);
    }
}
