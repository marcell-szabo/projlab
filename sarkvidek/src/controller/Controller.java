package controller;

import Display.Frame;
import game.Game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Controller
{
    public Controller(Frame f)
    {
        this.f = f;
        Instance = this;
        f.addKeyListener(new KeyAdapter() {
                             @Override
                             public void keyPressed(KeyEvent e) {
                                 if (e.getKeyChar() == 'w' || e.getKeyChar() == 'd' || e.getKeyChar() == 's' ||
                                         e.getKeyChar() == 'a' || e.getKeyChar() == 'j' || e.getKeyChar() == 'k' ||
                                         e.getKeyChar() == 'l' || e.getKeyChar() == 'i' || e.getKeyChar() == 'm')
                                 {
                                     Controller.Instance.setC(e.getKeyChar()); }
                             }
                         });
    }

    public static Frame f;
    public volatile char c;
    public static Controller Instance;

    public synchronized void setC(char cb)
    {
        c = cb;
        this.notify();
    }

    public synchronized char EventHandler()
    {
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return c;
    }

}

