package gui;

import game.Game;
import javax.swing.*;
import java.awt.*;


public class Application {
    private JFrame frame;
    private JPanel panel;
    int i = 10, j = 14;
    private Cell[][] cell =  new Cell[10][10];
    JLayeredPane layers;
    ImageResoucres imageResoucres = new ImageResoucres();
    Game game;

    public Application(){
        initialize();
        game = new Game();
        new MainScreen(this, game);
    }

    private void initialize() {
        frame = new JFrame();
        frame.setResizable(false);
        frame.setBounds(100, 100, 840, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        /*layers = new JLayeredPane();
        layers.setPreferredSize(new Dimension(840,600));
        layers.setLayout(new GridLayout(i, j));*/

        panel = new JPanel();
        panel.setLayout(new GridLayout(i,j));
        frame.add(panel);
    }

    public void draw(){
        for(int m = 0; m < i; m++) {
            for (int n = 0; n < j; n++) {
                label[m][n] = new JLabel();
                panel.add(label[m][n]);
            }
        }

        for(int m = 0; m < i; m++) {
            for (int n = 0; n < j; n++) {
                panel = (label[m][n].add(new JLabel(imageResoucres.sea)));
            }
        }

        //panel.add(new JLabel(imageResoucres.esp));

        frame.add(panel);

        frame.repaint();
        frame.revalidate();
    }

}
