package gui;

import game.Game;
import javax.swing.*;
import java.awt.*;


public class Application {
    private JFrame frame;
    private JPanel panel;
    int i = 10, j = 14;
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

        layers = new JLayeredPane();
        layers.setPreferredSize(new Dimension(840,600));
        layers.setLayout(new GridLayout(i, j));

        frame.add(layers);
    }

    public void draw(){
        JLabel[] seaArray = new JLabel[140];

        for(int m = 0; m < i; m++) {
            for (int n = 0; n < j; n++) {
                layers.add(new JLabel(imageResoucres.sea),1, 0);
                layers.add(new JLabel(imageResoucres.esp), 1, 1);
            }
        }


        frame.add(layers);

        frame.repaint();
        frame.revalidate();
    }

}
