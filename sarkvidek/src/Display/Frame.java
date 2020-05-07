package Display;

import game.Game;

import javax.swing.*;

public class Frame extends JFrame {

    Screen s;
    Game game;

    public Frame(Game game) {

        this.game = game;
        setSize(840, 620);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        init();
    }

    private void init() {
        setLocationRelativeTo(null);

         s = new Screen(game);
         add(s);

         setVisible(true);
    }
}
