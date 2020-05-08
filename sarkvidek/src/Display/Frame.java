package Display;

import controller.Controller;
import game.Game;
import graphics.Assets;

import javax.swing.*;

public class Frame extends JFrame {

    Screen s;
    Game game;

    public Frame(Game game) {

        this.game = game;
        setSize(840,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        Assets.init();
        game.addController(new Controller(this));
        init();
        pack();
        setLocationRelativeTo(null);
    }

    private void init() {
        setLocationRelativeTo(null);
        s = new Screen(game);
        add(s);
        //game.mainLoop();
        setVisible(true);
    }

    public void update(){
        s.repaint();
    }
}
