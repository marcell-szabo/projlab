package Display;

import javax.swing.*;

import game.*;
import game.Eskimo;
import game.Explorer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class MainScreen {

    protected JDialog frame;
    private Game game;

    public MainScreen(Game game){
        this.game = game;
        initialize();
    }

    private void initialize() {
        frame = new JDialog();
        frame.setResizable(false);
        frame.setSize(600, 400);
        frame.setTitle("beállítások");
        frame.setLocationRelativeTo(null);

        JPanel settings = new JPanel();
        settings.setLayout(new BoxLayout(settings, BoxLayout.PAGE_AXIS));

        String[] numbers = {"3 játékos", "4 játékos", "5 játékos", "6 játékos"};
        JComboBox number = new JComboBox(numbers);

        settings.add(number);

        String[] characters = {"Eszkimó", "Sarkkutató"};
        List<JComboBox> cbl = new ArrayList<>();
        Color c[] = {Color.magenta, Color.green, new Color(1f,0.9f,0.1f ), Color.orange, Color.red, Color.blue};
        char[] chars = {'p', 'g', 'y', 'o', 'r', 'b'};
        for(int i = 1; i <= 6; i++) {
            cbl.add(new JComboBox(characters));
            cbl.get(cbl.size() - 1).setForeground(c[i - 1]);
        }

        JButton next = new JButton("Következõ");
        next.setAlignmentX(Component.CENTER_ALIGNMENT);
        settings.add(next);

        JButton start = new JButton("Játék indítása");
        start.setAlignmentX(Component.CENTER_ALIGNMENT);


        final int[] n = {0};
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                n[0] = number.getSelectedIndex() + 3;
                settings.removeAll();
                for(int i = 0; i < n[0]; i++) {
                    settings.add(cbl.get(i));
                }
                settings.add(start);
                settings.repaint();
                settings.revalidate();

            }
        });

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                game.init(n[0]);
                for(int i = 0; i < n[0]; i++) {
                    if(String.valueOf(cbl.get(i).getSelectedItem()) == "Eszkimó")
                        game.addPlayer(new Eskimo(game, game.getStartField(), chars[i], 5));
                    else
                        game.addPlayer(new Explorer(game,game.getStartField(), chars[i], 4));
                }
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                new Frame(game);


            }
        });

        frame.add(settings);
        frame.setVisible(true);
    }
}