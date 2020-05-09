package Display;

import controller.Controller;
import game.Game;
import game.Result;
import graphics.Assets;
import graphics.ImageLoader;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame implements Runnable{

    Screen s;
    Game game;

    public Frame(Game game) {
        this.game = game;
        setPreferredSize(new Dimension(840, 600));
        setMinimumSize(new Dimension(840, 600));
        setMaximumSize(new Dimension(840, 600));
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
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        Result endgame = game.mainLoop(this);
        if(endgame == Result.WIN) {
            ImageIcon win = new ImageIcon(this.getClass().getResource("/textures/win.gif"));
            JLabel Win = new JLabel();
            Win.setHorizontalAlignment(JLabel.CENTER);
            Win.setIcon(win);
            this.remove(s);
            this.add(Win);
            setVisible(true);
        }else if(endgame == Result.DIE) {
            ImageIcon lose = new ImageIcon(this.getClass().getResource("/textures/lose.gif"));
            JLabel Lose = new JLabel();
            Lose.setHorizontalAlignment(JLabel.CENTER);
            Lose.setIcon(lose);
            this.remove(s);
            this.add(Lose);
            setVisible(true);
        }
    }
}
