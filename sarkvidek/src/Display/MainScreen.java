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

/**
 * a kezdõképernyõt megvalósító osztály
 */
public class MainScreen {

    /**
     * JFrame objektum
     */
    protected JFrame frame;

    /**
     * az aktuális játékot tárolja
     */
    private Game game;

    /**
     * konstruktor, létrehozza a JFramet majd inicializálja
     * @param game - az aktuális játékot kapja meg
     */
    public MainScreen(Game game){
        this.game = game;
        frame = new JFrame();
        initialize();
    }

    /**
     * A kezdõképernyõt valósítja meg és a játék beállításait,
     * inicializájlja a játékot a játékosok számának függvényében,
     * majd elindítja magát a játékot.
     */
    private void initialize() {
        ImageIcon backgr = new ImageIcon(this.getClass().getResource("/textures/background.jpg"));
        JLabel background = new JLabel(backgr);
        frame.setResizable(false);
        frame.setSize(600, 400);
        frame.setTitle("Settings");
        frame.setLocationRelativeTo(null);
        frame.setContentPane(background);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();


        JPanel settings = new JPanel();
        JLabel gamename = new JLabel("N o r t h  P o l e");
        c.fill = GridBagConstraints.VERTICAL;
        c.ipady = 40;
        c.gridx = 0;
        c.gridy = 0;
        gamename.setFont(new Font("TimesRoman", Font.BOLD, 40));
        gamename.setForeground(Color.white);
        gamename.setBorder(new EmptyBorder(0,0,100,0));

        frame.getContentPane().add(gamename, c);

        JButton startbutton = new JButton("Start New Game");
        c.fill = GridBagConstraints.VERTICAL;
        c.weightx = 0.5;
        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 1;
        startbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(settings);
                frame.setVisible(true);
            }
        });
        startbutton.setAlignmentX(Component.CENTER_ALIGNMENT);

        frame.add(startbutton, c);

        JPanel aboutpanel = new JPanel();
        JButton about = new JButton("About");
        c.fill = GridBagConstraints.VERTICAL;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 2;
        about.setAlignmentX(Component.CENTER_ALIGNMENT);
        about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(aboutpanel);
                frame.setVisible(true);
            }
        });
        frame.add(about, c);
        aboutpanel.setSize(600, 400);

        aboutpanel.setLayout(new BoxLayout(aboutpanel, BoxLayout.PAGE_AXIS));
        JLabel text = new JLabel("<html>Designers and Developers:<br>Fábián Csenge<br>Gutai Auguszta<br>Ilosvay Viktória" +
                "<br>Szabó Kinga<br>Szabó Marcell<br><br>Huge Thanks to Berczik Anna for the graphical design<br><br>The game is about a small group, which is trapped on the North Pole, " +
                "and wants to return home. In order to do this, they have to find all 3 components of a flaregun, so they can be rescued." +
                " However, there are several threats that can kill them (e.g.: storm, polar bear, holes...), so you have to be careful. Their survival is your responsibility." +
                "<br>The characters can be eskimos or explorers. Each of them has some kind of special skill. Also, several items can be found" +
                " on the map, to make your job easier.<br>Bring home the group safely and enjoy this game. Controls can be checked, if you" +
                " press and hold CTRL button.<br><br>2020. Feb-May</html>");
        aboutpanel.add(text);
        JButton back = new JButton("Back");
        back.setAlignmentX(Component.CENTER_ALIGNMENT);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initialize();
            }
        });
        aboutpanel.add(back);


        settings.setLayout(new BoxLayout(settings, BoxLayout.Y_AXIS));
        String[] numbers = {"3 players", "4 players", "5 players", "6 players"};
        JComboBox number = new JComboBox(numbers);
        settings.add(number);

        String[] characters = {"Eskimo", "Explorer"};
        List<JComboBox> cbl = new ArrayList<>();
        Color ch[] = {Color.magenta, Color.green, new Color(1f,0.9f,0.1f ), Color.orange, Color.red, Color.blue};
        char[] chars = {'p', 'g', 'y', 'o', 'r', 'b'};
        for(int i = 1; i <= 6; i++) {
            cbl.add(new JComboBox(characters));
            cbl.get(cbl.size() - 1).setForeground(ch[i - 1]);
        }

        JButton next = new JButton("Next");
        next.setAlignmentX(Component.CENTER_ALIGNMENT);
        settings.add(next);

        JButton start = new JButton("Start Game");
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
                game.init();
                for(int i = 0; i < n[0]; i++) {
                    if(String.valueOf(cbl.get(i).getSelectedItem()) == "Eskimo")
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