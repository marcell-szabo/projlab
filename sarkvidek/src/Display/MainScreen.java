package Display;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

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
        frame.setLocationRelativeTo(null);

        JPanel startpanel = new JPanel();
        JPanel settings = new JPanel();
        startpanel.setLayout(new BoxLayout(startpanel, BoxLayout.Y_AXIS));
        startpanel.setBorder(new EmptyBorder(70,20,20,20));
        JLabel gamename = new JLabel("B l o o d y  T e d d y");
        gamename.setFont(new Font("TimesRoman", Font.BOLD, 40));
        gamename.setAlignmentX(Component.CENTER_ALIGNMENT);
        gamename.setBorder(new EmptyBorder(0,0,50,0));
        startpanel.add(gamename);
        JButton startbutton = new JButton("Start New Game");
        startbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(startpanel);
                frame.add(settings);
                frame.setVisible(true);
            }
        });
        startbutton.setAlignmentX(Component.CENTER_ALIGNMENT);
        startpanel.add(startbutton);
        JPanel aboutpanel = new JPanel();
        JButton about = new JButton("About");
        about.setAlignmentX(Component.CENTER_ALIGNMENT);
        about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(startpanel);
                frame.add(aboutpanel);
                frame.setVisible(true);
            }
        });
        startpanel.add(about);
        frame.add(startpanel);

        aboutpanel.setLayout(new BoxLayout(aboutpanel, BoxLayout.PAGE_AXIS));
        JLabel text = new JLabel("<html>Designers and Developers:<br><br>Fábián Csenge<br>Gutai Auguszta<br>Ilosvay Viktoria" +
                "<br>Szabó Kinga<br>Szabó Marcell<br><br>The game is about a small group, which is trapped on the North Pole " +
                "and wants to return home. In order to do this they have to find all 3 components of a flaregun so they can be rescued." +
                " However there are several threats that can kill them (e.g.: storm, polar bear, holes...), so you have to be careful. Their survival is your responsibility." +
                "<br>The characters can be eskimos or explorers. Each of them has some kind of special skill. Also, several items can be found" +
                " on the map, to make your job easier.<br><br>Bring home the group safely and enjoy this game.<br>Huge thanks to " +
                "Berczik Anna for the graphical design.<br><br>2020. May</html>");
        aboutpanel.add(text);
        JButton back = new JButton("Back");
        back.setAlignmentX(Component.CENTER_ALIGNMENT);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(aboutpanel);
                frame.add(startpanel);
                frame.repaint();
            }
        });
        aboutpanel.add(back);


        settings.setLayout(new BoxLayout(settings, BoxLayout.Y_AXIS));
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

        frame.setVisible(true);
    }
}