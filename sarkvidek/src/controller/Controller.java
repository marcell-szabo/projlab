package controller;

import Display.Frame;
import game.Game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Kontroller oszt�ly. A billenty�zetr�l beolvassa �s elk�ldi a vez�rl�st.
 */
public class Controller
{
    // Az a frame amin a kontrollert haszn�ljuk, azaz amelyre KeyListenert tesz�nk.
    public static Frame f;
    // Az �ppen beolvasott karakter
    public volatile char c;
    /**
     * Konstruktor
     * L�trehoz egy kontrollert. �tvesz egy Frame p�ld�nyt, ami azt az ablakot szimboliz�lja, amire r�teszi a Keylistenert.
     *
     * @param f - frame amire a keylistenert teszi
     */
    public Controller(Frame f)
    {
        this.f = f;
        f.addKeyListener(new KeyAdapter() {
                             @Override
                             public void keyPressed(KeyEvent e) {
                                 if (e.getKeyChar() == 'w' || e.getKeyChar() == 'd' || e.getKeyChar() == 's' ||
                                         e.getKeyChar() == 'a' || e.getKeyChar() == 'j' || e.getKeyChar() == 'k' ||
                                         e.getKeyChar() == 'l' || e.getKeyChar() == 'i' || e.getKeyChar() == 'm')
                                 {
                                     setC(e.getKeyChar()); }
                             }
                         });
    }

    /**
     * Be�ll�tja a beolvasott karaktert a C tagv�ltoz�nak, ha ez megt�rt�nt, azaz van lenyomott billenty�, akkor �rtes�ti
     * a v�rakoz� sz�lat.
     * @param cb - lenyomott karakter
     */
    public synchronized void setC(char cb)
    {
        c = cb;
        this.notify();
    }

    /**
     * EventHandler f�ggv�ny. A bel�p� sz�l itt v�rakozik addig, am�g nincs lenyomott billenty�.
     * Ha van akkor visszat�r vele.
     * @return lenyomott billenty�
     */
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

