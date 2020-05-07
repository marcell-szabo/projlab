package Display;

import javax.swing.*;

import Display.Display;
import Faszom.GameD;
import game.*;
import game.Eskimo;
import game.Explorer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

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
        frame.setLocationRelativeTo(null);


        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        JPanel settings = new JPanel();
        settings.setLayout(new BoxLayout(settings, BoxLayout.PAGE_AXIS));

        String[] numbers = {"3 játékos", "4 játékos", "5 játékos", "6 játékos"};
        JComboBox number = new JComboBox(numbers);

        settings.add(number);

        String[] characters = {"Eszkimó", "Sarkkutató"};
        JComboBox first = new JComboBox(characters);
        first.setForeground(Color.magenta);
        JComboBox second = new JComboBox(characters);
        second.setForeground(Color.green);
        JComboBox third = new JComboBox(characters);
        third.setForeground(new Color(1f,0.9f,0.1f ));
        JComboBox fourth = new JComboBox(characters);
        fourth.setForeground(Color.orange);
        JComboBox fifth = new JComboBox(characters);
        fifth.setForeground(Color.red);
        JComboBox sixth = new JComboBox(characters);
        sixth.setForeground(Color.blue);


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

                switch (n[0]){
                    case 3:
                        settings.add(first);
                        settings.add(second);
                        settings.add(third);
                        break;
                    case 4:
                        settings.add(first);
                        settings.add(second);
                        settings.add(third);
                        settings.add(fourth);
                        break;
                    case 5:
                        settings.add(first);
                        settings.add(second);
                        settings.add(third);
                        settings.add(fourth);
                        settings.add(fifth);
                        break;
                    case 6:
                        settings.add(first);
                        settings.add(second);
                        settings.add(third);
                        settings.add(fourth);
                        settings.add(fifth);
                        settings.add(sixth);
                        break;
                    default:
                        break;
                }

                settings.add(start);
                settings.repaint();
                settings.revalidate();
            }
        });

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                switch (n[0]){
                    case 3:
                        if(String.valueOf(first.getSelectedItem()) == "Eszkimó")
                            game.addPlayer(new Eskimo(game, game.getStartField(), 'p', 5));
                        else
                            game.addPlayer(new Explorer(game,game.getStartField(), 'p', 4));
                        if(String.valueOf(second.getSelectedItem()) == "Eszkimó")
                            game.addPlayer(new Eskimo(game, game.getStartField(), 'g', 5));
                        else
                            game.addPlayer(new Explorer(game,game.getStartField(), 'g', 4));
                        if(String.valueOf(third.getSelectedItem()) == "Eszkimó")
                            game.addPlayer(new Eskimo(game, game.getStartField(), 'y', 5));
                        else
                            game.addPlayer(new Explorer(game,game.getStartField(), 'y', 4));
                        break;
                    case 4:
                        if(String.valueOf(first.getSelectedItem()) == "Eszkimó")
                            game.addPlayer(new Eskimo(game, game.getStartField(), 'p', 5));
                        else
                            game.addPlayer(new Explorer(game,game.getStartField(), 'p', 4));
                        if(String.valueOf(second.getSelectedItem()) == "Eszkimó")
                            game.addPlayer(new Eskimo(game, game.getStartField(), 'g', 5));
                        else
                            game.addPlayer(new Explorer(game,game.getStartField(), 'g', 4));
                        if(String.valueOf(third.getSelectedItem()) == "Eszkimó")
                            game.addPlayer(new Eskimo(game, game.getStartField(), 'y', 5));
                        else
                            game.addPlayer(new Explorer(game,game.getStartField(), 'y', 4));
                        if(String.valueOf(fourth.getSelectedItem()) == "Eszkimó")
                            game.addPlayer(new Eskimo(game, game.getStartField(), 'o', 5));
                        else
                            game.addPlayer(new Explorer(game,game.getStartField(), 'o', 4));
                        break;
                    case 5:
                        if(String.valueOf(first.getSelectedItem()) == "Eszkimó")
                            game.addPlayer(new Eskimo(game, game.getStartField(), 'p', 5));
                        else
                            game.addPlayer(new Explorer(game,game.getStartField(), 'p', 4));
                        if(String.valueOf(second.getSelectedItem()) == "Eszkimó")
                            game.addPlayer(new Eskimo(game, game.getStartField(), 'g', 5));
                        else
                            game.addPlayer(new Explorer(game,game.getStartField(), 'g', 4));
                        if(String.valueOf(third.getSelectedItem()) == "Eszkimó")
                            game.addPlayer(new Eskimo(game, game.getStartField(), 'y', 5));
                        else
                            game.addPlayer(new Explorer(game,game.getStartField(), 'y', 4));
                        if(String.valueOf(fourth.getSelectedItem()) == "Eszkimó")
                            game.addPlayer(new Eskimo(game, game.getStartField(), 'o', 5));
                        else
                            game.addPlayer(new Explorer(game,game.getStartField(), 'o', 4));
                        if(String.valueOf(fifth.getSelectedItem()) == "Eszkimó")
                            game.addPlayer(new Eskimo(game, game.getStartField(), 'r', 5));
                        else
                            game.addPlayer(new Explorer(game,game.getStartField(), 'r', 4));
                        break;
                    case 6:

                        if(String.valueOf(first.getSelectedItem()) == "Eszkimó")
                            game.addPlayer(new Eskimo(game, game.getStartField(), 'p', 5));
                        else
                            game.addPlayer(new Explorer(game,game.getStartField(), 'p', 4));
                        if(String.valueOf(second.getSelectedItem()) == "Eszkimó")
                            game.addPlayer(new Eskimo(game, game.getStartField(), 'g', 5));
                        else
                            game.addPlayer(new Explorer(game,game.getStartField(), 'g', 4));
                        if(String.valueOf(third.getSelectedItem()) == "Eszkimó")
                            game.addPlayer(new Eskimo(game, game.getStartField(), 'y', 5));
                        else
                            game.addPlayer(new Explorer(game,game.getStartField(), 'y', 4));
                        if(String.valueOf(fourth.getSelectedItem()) == "Eszkimó")
                            game.addPlayer(new Eskimo(game, game.getStartField(), 'o', 5));
                        else
                            game.addPlayer(new Explorer(game,game.getStartField(), 'o', 4));
                        if(String.valueOf(fifth.getSelectedItem()) == "Eszkimó")
                            game.addPlayer(new Eskimo(game, game.getStartField(), 'r', 5));
                        else
                            game.addPlayer(new Explorer(game,game.getStartField(), 'r', 4));
                        if(String.valueOf(sixth.getSelectedItem()) == "Eszkimó")
                            game.addPlayer(new Eskimo(game, game.getStartField(), 'b', 5));
                        else
                            game.addPlayer(new Explorer(game,game.getStartField(), 'b', 4));
                        break;
                    default:
                        break;
                }
                game.init(n[0]);
                GameD gameD = new GameD("Jégmezõ", 840, 600, game);
                gameD.start();
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });

        panel.add(settings);
        frame.add(panel);
        frame.setVisible(true);
    }
}
