package Display;

import controller.Controller;
import game.Game;
import game.Result;
import graphics.Assets;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * mag�t a j�t�k ablakot megval�s�t� oszt�ly, amely a JFrameb�l sz�rmazik le
 */
public class Frame extends JFrame implements Runnable{

    /**
     * A JPanel amin a megjelen�t�s t�rt�nik.(a screen a jpanelb�l sz�rmazik le)
     */
    Screen s;

    /**
     * Az aktu�lis j�t�kot t�rolja
     */
    Game game;

    /**
     * konstruktor, be�ll�tja az ablak m�ret�t, c�m�t, az Assets oszt�ly inicializ�lja, a controllert
     * hozz�adja a j�t�khoz �s �nmag�t is inicializ�lja
     * @param game - param�terk�nt kapott j�t�k
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
     * l�trehoz egy Screent(ami a JPanelb�l sz�rmazik le) �s hozz�adja �nmag�hoz
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
     * �jra rajzolja a screen s -en l�v� dolgokat(eg�sz p�ly�t)
     * @param g - Graphics p�ld�ny
     */
    public void paint(Graphics g) {
        s.repaint();
    }

    /**
     * A bal control billenyt� lenyom�sakor megjelen�t egy ablakot,
     * amely egy s�g� az ir�ny�t�shoz. a ctrl felenged�sekor elt�nik az ablak
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
     * A sz�lon fut� j�t�k k�rei�rt felel�s f�ggv�ny, amely a j�t�k v�gekor a megfelel� k�pet jelenit�
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
