package gui;

import gui.MainScreen;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Application {
    private JFrame frame;
    ImageIcon sea = new ImageIcon("/Users/kinga/projlab/sarkvidek/src/textures/sea.png");

    public Application(){
        initalize();
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
            seaArray[i] = new JLabel(sea);
            panel.add(seaArray[i]);
        }



        frame.add(panel);
    }

}
