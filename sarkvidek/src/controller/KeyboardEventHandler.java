package controller;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class KeyboardEventHandler implements KeyListener
{
    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyPressed(KeyEvent e)
    {
        if (e.getKeyChar() == 'w' || e.getKeyChar() == 'd' || e.getKeyChar() == 's' ||
                e.getKeyChar() == 'a' || e.getKeyChar() == 'j' || e.getKeyChar() == 'k' ||
                e.getKeyChar() == 'l' || e.getKeyChar() == 'i' || e.getKeyChar() == 'm')
        { Controller.Instance.setC(e.getKeyChar());
            Controller.f.removeKeyListener(this);
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {}
}
