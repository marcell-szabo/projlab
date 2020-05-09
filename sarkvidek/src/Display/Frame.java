package Display;

import controller.Controller;
import game.Game;
import graphics.Assets;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.invoke.ConstantBootstraps;
import java.sql.JDBCType;

public class Frame extends JFrame implements Runnable{

    Screen s;
    Game game;
    boolean run = false;

    public Frame(Game game) {
        this.game = game;
        setSize(840, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        game.addController(new Controller(this));

        Assets.init();
        init();
        pack();
        setLocationRelativeTo(null);
    }

    private void init() {
        s = new Screen(game);
        add(s);
        setLocationRelativeTo(null);
        setVisible(true);
        start();
    }


    public void paint(Graphics g) {
        s.update(this.getGraphics());
    }

    public void start(){
        this.update(this.getGraphics());
        Thread t = new Thread(this);
        t.start();
        this.addKeyListener(new KeyAdapter() {
            JDialog controlsdialog;
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_CONTROL) {
                    controlsdialog = new JDialog();
                    controlsdialog.setModal(true);
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
        game.mainLoop(this);
    }
}
