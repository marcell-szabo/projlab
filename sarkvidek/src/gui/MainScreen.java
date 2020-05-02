package gui;

import javax.swing.*;
import game.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class MainScreen {

    protected JDialog dialog;

    public MainScreen(){
        initalize();
    }

    private void initalize() {
        dialog = new JDialog();
        dialog.setResizable(false);
        dialog.setBounds(220, 200, 600, 400);
        dialog.setVisible(true);


        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        JPanel settings = new JPanel();
        settings.setLayout(new BoxLayout(settings, BoxLayout.PAGE_AXIS));

        JPanel players = new JPanel();
        players.setLayout(new BoxLayout(players, BoxLayout.PAGE_AXIS));
        String[] numbers = {"3 játékos", "4 játékos", "5 játékos", "6 játékos"};
        JComboBox number = new JComboBox(numbers);

        JPanel colors = new JPanel();
        colors.setLayout(new BoxLayout(colors, BoxLayout.PAGE_AXIS));
        String[] characters = {"Eszkimó", "Sarkkutató"};
        JComboBox first = new JComboBox(characters);
        first.setBackground(Color.magenta);
        JComboBox second = new JComboBox(characters);
        second.setBackground(Color.green);
        JComboBox third = new JComboBox(characters);
        third.setBackground(Color.yellow);
        JComboBox fourth = new JComboBox(characters);
        fourth.setBackground(Color.orange);
        JComboBox fifth = new JComboBox(characters);
        fifth.setBackground(Color.red);
        JComboBox sixth = new JComboBox(characters);
        sixth.setBackground(Color.blue);


        players.add(number);
        settings.add(players);

        JButton next = new JButton("Következõ");
        next.setAlignmentX(Component.CENTER_ALIGNMENT);
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
                        colors.add(first);
                        colors.add(second);
                        colors.add(third);
                        break;
                    case 4:
                        colors.add(first);
                        colors.add(second);
                        colors.add(third);
                        colors.add(fourth);
                        break;
                    case 5:
                        colors.add(first);
                        colors.add(second);
                        colors.add(third);
                        colors.add(fourth);
                        colors.add(fifth);
                        break;
                    case 6:
                        colors.add(first);
                        colors.add(second);
                        colors.add(third);
                        colors.add(fourth);
                        colors.add(fifth);
                        colors.add(sixth);
                        break;
                    default:
                        break;
                }
                settings.add(colors);
                settings.add(start);
                panel.add(settings);
                dialog.add(panel);
                dialog.setVisible(true);
            }
        });

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Game game = null;
                switch (n[0]){
                    case 3:
                        try {
                            game = new Game(n[0]);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if(String.valueOf(first.getSelectedItem()) == "Eszkimó")
                            game.addPlayer(new game.Eskimo(game, game.getStartField(), 'p', 5));
                        else
                            game.addPlayer(new game.Explorer(game,game.getStartField(), 'p', 4));
                        if(String.valueOf(second.getSelectedItem()) == "Eszkimó")
                            game.addPlayer(new game.Eskimo(game, game.getStartField(), 'g', 5));
                        else
                            game.addPlayer(new game.Explorer(game,game.getStartField(), 'g', 4));
                        if(String.valueOf(third.getSelectedItem()) == "Eszkimó")
                            game.addPlayer(new game.Eskimo(game, game.getStartField(), 'y', 5));
                        else
                            game.addPlayer(new game.Explorer(game,game.getStartField(), 'y', 4));
                        break;
                    case 4:
                        try {
                            game = new Game(n[0]);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if(String.valueOf(first.getSelectedItem()) == "Eszkimó")
                            game.addPlayer(new game.Eskimo(game, game.getStartField(), 'p', 5));
                        else
                            game.addPlayer(new game.Explorer(game,game.getStartField(), 'p', 4));
                        if(String.valueOf(second.getSelectedItem()) == "Eszkimó")
                            game.addPlayer(new game.Eskimo(game, game.getStartField(), 'g', 5));
                        else
                            game.addPlayer(new game.Explorer(game,game.getStartField(), 'g', 4));
                        if(String.valueOf(third.getSelectedItem()) == "Eszkimó")
                            game.addPlayer(new game.Eskimo(game, game.getStartField(), 'y', 5));
                        else
                            game.addPlayer(new game.Explorer(game,game.getStartField(), 'y', 4));
                        if(String.valueOf(fourth.getSelectedItem()) == "Eszkimó")
                            game.addPlayer(new game.Eskimo(game, game.getStartField(), 'o', 5));
                        else
                            game.addPlayer(new game.Explorer(game,game.getStartField(), 'o', 4));
                        break;
                    case 5:
                        try {
                            game = new Game(n[0]);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if(String.valueOf(first.getSelectedItem()) == "Eszkimó")
                            game.addPlayer(new game.Eskimo(game, game.getStartField(), 'p', 5));
                        else
                            game.addPlayer(new game.Explorer(game,game.getStartField(), 'p', 4));
                        if(String.valueOf(second.getSelectedItem()) == "Eszkimó")
                            game.addPlayer(new game.Eskimo(game, game.getStartField(), 'g', 5));
                        else
                            game.addPlayer(new game.Explorer(game,game.getStartField(), 'g', 4));
                        if(String.valueOf(third.getSelectedItem()) == "Eszkimó")
                            game.addPlayer(new game.Eskimo(game, game.getStartField(), 'y', 5));
                        else
                            game.addPlayer(new game.Explorer(game,game.getStartField(), 'y', 4));
                        if(String.valueOf(fourth.getSelectedItem()) == "Eszkimó")
                            game.addPlayer(new game.Eskimo(game, game.getStartField(), 'o', 5));
                        else
                            game.addPlayer(new game.Explorer(game,game.getStartField(), 'o', 4));
                        if(String.valueOf(fifth.getSelectedItem()) == "Eszkimó")
                            game.addPlayer(new game.Eskimo(game, game.getStartField(), 'r', 5));
                        else
                            game.addPlayer(new game.Explorer(game,game.getStartField(), 'r', 4));
                        break;
                    case 6:
                        try {
                            game = new Game(n[0]);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if(String.valueOf(first.getSelectedItem()) == "Eszkimó")
                            game.addPlayer(new game.Eskimo(game, game.getStartField(), 'p', 5));
                        else
                            game.addPlayer(new game.Explorer(game,game.getStartField(), 'p', 4));
                        if(String.valueOf(second.getSelectedItem()) == "Eszkimó")
                            game.addPlayer(new game.Eskimo(game, game.getStartField(), 'g', 5));
                        else
                            game.addPlayer(new game.Explorer(game,game.getStartField(), 'g', 4));
                        if(String.valueOf(third.getSelectedItem()) == "Eszkimó")
                            game.addPlayer(new game.Eskimo(game, game.getStartField(), 'y', 5));
                        else
                            game.addPlayer(new game.Explorer(game,game.getStartField(), 'y', 4));
                        if(String.valueOf(fourth.getSelectedItem()) == "Eszkimó")
                            game.addPlayer(new game.Eskimo(game, game.getStartField(), 'o', 5));
                        else
                            game.addPlayer(new game.Explorer(game,game.getStartField(), 'o', 4));
                        if(String.valueOf(fifth.getSelectedItem()) == "Eszkimó")
                            game.addPlayer(new game.Eskimo(game, game.getStartField(), 'r', 5));
                        else
                            game.addPlayer(new game.Explorer(game,game.getStartField(), 'r', 4));
                        if(String.valueOf(sixth.getSelectedItem()) == "Eszkimó")
                            game.addPlayer(new game.Eskimo(game, game.getStartField(), 'b', 5));
                        else
                            game.addPlayer(new game.Explorer(game,game.getStartField(), 'b', 4));
                        break;
                    default:
                        break;
                }

                dialog.dispatchEvent(new WindowEvent(dialog, WindowEvent.WINDOW_CLOSING));
            }
        });

        settings.add(next);

        panel.add(settings);
        dialog.add(panel);
        dialog.setVisible(true);

    }
}
