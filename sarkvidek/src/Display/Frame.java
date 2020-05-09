package Display;

import controller.Controller;
import game.Game;
import game.Result;
import graphics.Assets;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Frame extends JFrame implements Runnable{

    Screen s;
    Game game;

    public Frame(Game game) {
        this.game = game;
        setSize(840, 660);
        setTitle("Sarkvid�k");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        game.addController(new Controller(this));
        Assets.init();
        init();
    }

    private void init() {
        s = new Screen(game);
        //add(gameMap, BorderLayout.CENTER);
        //statePanel = new StatePanel(game);
        //add(statePanel, BorderLayout.PAGE_END);
        add(s);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        start();
    }


    public void paint(Graphics g) {
        s.repaint();
    }

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
                    //controlsdialog.setLocationRelativeTo(null);

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
                            "<br><br>Actions <br><br>  J - Clean <br>  K - Pickup Item <br>  L - Special Skill <br>  I - Assemble Flaregun" +
                            "<br>  M - BuildTent </html>"));
                    controlsdialog.getContentPane().add(panel);
                    controlsdialog.pack();
                    controlsdialog.setVisible(true);
                }
            }

        });
    }

    @Override
    public void run() {
        Result endgame = game.mainLoop(this);
        /*JButton newgame = new JButton("new game");
        newgame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game = new Game();
                javax.swing.SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new MainScreen(game);
                    }
                });
                dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });*/
        if(endgame == Result.WIN) {
            ImageIcon win = new ImageIcon(this.getClass().getResource("/textures/win.gif"));
            JLabel Win = new JLabel();
            Win.setHorizontalAlignment(JLabel.CENTER);
            Win.setIcon(win);
            this.removeAll();
            this.add(Win);
            //this.add(newgame, BorderLayout.PAGE_END);
            setVisible(true);
        }else if(endgame == Result.DIE) {
            ImageIcon lose = new ImageIcon(this.getClass().getResource("/textures/lose.gif"));
            JLabel Lose = new JLabel();
            Lose.setHorizontalAlignment(JLabel.CENTER);
            Lose.setIcon(lose);
            this.remove(s);
            this.add(Lose);
            //this.add(newgame, BorderLayout.PAGE_END);
            setVisible(true);
        }
    }
}