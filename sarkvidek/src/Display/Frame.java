package Display;

import controller.Controller;
import game.Game;
import game.Result;
import graphics.Assets;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * magát a játék ablakot megvalósító osztály, amely a JFramebõl származik le
 */
public class Frame extends JFrame implements Runnable{

    /**
     * A JPanel amin a megjelenítés történik.(a screen a jpanelbõl származik le)
     */
    Screen s;

    /**
     * Az aktuális játékot tárolja
     */
    Game game;

    /**
     * konstruktor, beállítja az ablak méretét, címét, az Assets osztály inicializálja, a controllert
     * hozzáadja a játékhoz és önmagát is inicializálja
     * @param game - paraméterként kapott játék
     */
    public Frame(Game game) {
        this.game = game;
        setSize(840, 660);
        setTitle("Icefield");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        game.addController(new Controller(this));
        Assets.init();
        init();
    }

    /**
     * létrehoz egy Screent(ami a JPanelbõl származik le) és hozzáadja önmagához
     */
    private void init() {
        s = new Screen(game);
        add(s);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        start();
    }


    /**
     * újra rajzolja a screen s -en lévõ dolgokat(egész pályát)
     * @param g - Graphics példány
     */
    public void paint(Graphics g) {
        s.repaint();
    }

    /**
     * A bal control billenytû lenyomásakor megjelenít egy ablakot,
     * amely egy súgó az irányításhoz. a ctrl felengedésekor eltûnik az ablak
     */
    public void start(){
        this.paintComponents(this.getGraphics());
        Thread t = new Thread(this);
        t.start();
        this.addKeyListener(new KeyAdapter() {
            JDialog controlsdialog;
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_CONTROL) {
                    controlsdialog = new JDialog();
                    controlsdialog.setModal(true);
                    controlsdialog.setResizable(false);

                    controlsdialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    controlsdialog.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosing(WindowEvent e) {
                            controlsdialog.setVisible(false);
                            controlsdialog.dispose();
                        }
                    });
                    controlsdialog.addKeyListener(new KeyAdapter() {
                        @Override
                        public void keyReleased(KeyEvent e) {
                            if(e.getKeyCode() == KeyEvent.VK_CONTROL)
                                controlsdialog.dispatchEvent(new WindowEvent(controlsdialog, WindowEvent.WINDOW_CLOSING));
                        }
                    });
                    JPanel panel = new JPanel();
                    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
                    panel.add(new JLabel("<html>Moving <br><br>  W - Up <br>  S - Down <br>  A - Left <br>  D - Right" +
                            "<br><br>Actions <br><br>  J - Clean <br>  K - Pickup Item <br>  L - Special Skill (Eskimo)" +
                            "<br> L + Direction - Special skill (Explorer)<br>  I - Assemble Flaregun" +
                            "<br>  M - BuildTent </html>"));
                    controlsdialog.getContentPane().add(panel);
                    controlsdialog.pack();
                    controlsdialog.setVisible(true);
                }
            }

        });
    }

    @Override
    /**
     * A szálon futó játék köreiért felelõs függvény, amely a játék végekor a megfelelõ képet jelenití
     * meg
     */
    public void run() {
        Result endgame = game.mainLoop(this);
        JButton exit = new JButton("Exit");
        Frame frame = this;
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });
        if(endgame == Result.WIN) {
            ImageIcon win = new ImageIcon(this.getClass().getResource("/textures/win.gif"));
            JLabel Win = new JLabel();
            Win.setHorizontalAlignment(JLabel.CENTER);
            Win.setIcon(win);
            this.remove(s);
            this.add(Win);
            this.add(exit, BorderLayout.PAGE_END);
            setVisible(true);
        }else if(endgame == Result.DIE) {
            ImageIcon lose = new ImageIcon(this.getClass().getResource("/textures/lose.gif"));
            JLabel Lose = new JLabel();
            Lose.setHorizontalAlignment(JLabel.CENTER);
            Lose.setIcon(lose);
            this.remove(s);
            this.add(Lose);
            this.add(exit, BorderLayout.PAGE_END);
            setVisible(true);
        }
    }
}
