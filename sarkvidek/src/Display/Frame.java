package Display;

import controller.Controller;
import game.Game;
import graphics.Assets;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    Screen s;
    Game game;
    boolean run = false;

    public Frame(Game game) {
        this.game = game;
        setSize(840, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        game.addController(new Controller(this));

        Assets.init();
        init();
        pack();
        setLocationRelativeTo(null);
    }

    private void init() {
        s = new Screen(game);
        add(s);
        setLocationRelativeTo(null);
        setVisible(true);
        start();
    }


    public void paint(Graphics g) {
        s.update(this.getGraphics());
    }

    public void start(){
        this.update(this.getGraphics());
        game.mainLoop(this);
    }

}
