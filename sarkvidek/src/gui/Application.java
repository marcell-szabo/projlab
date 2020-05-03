package gui;

import game.Game;
import gui.MainScreen;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Application {
    private JFrame frame;
    ImageResoucres imageResoucres = new ImageResoucres();
    Game game = new Game();

    public Application(){
        initalize();
        MainScreen mainScreen = new MainScreen(game);
    }

    private void initalize() {
        frame = new JFrame();
        frame.setResizable(false);
        frame.setBounds(100, 100, 840, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(10, 14));

        JLabel[] seaArray = new JLabel[140];

        for(int i = 0; i < 10; i++){
            seaArray[i] = new JLabel(imageResoucres.sea);
            panel.add(seaArray[i]);
        }



        frame.add(panel);
    }

}
