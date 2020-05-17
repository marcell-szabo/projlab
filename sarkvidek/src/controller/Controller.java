package controller;

import Display.Frame;
import game.Game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Kontroller osztály. A billentyûzetrõl beolvassa és elküldi a vezérlést.
 */
public class Controller
{
    // Az a frame amin a kontrollert használjuk, azaz amelyre KeyListenert teszünk.
    public static Frame f;
    // Az éppen beolvasott karakter
    public volatile char c;
    /**
     * Konstruktor
     * Létrehoz egy kontrollert. Átvesz egy Frame példányt, ami azt az ablakot szimbolizálja, amire ráteszi a Keylistenert.
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
     * Beállítja a beolvasott karaktert a C tagváltozónak, ha ez megtörtént, azaz van lenyomott billentyû, akkor értesíti
     * a várakozó szálat.
     * @param cb - lenyomott karakter
     */
    public synchronized void setC(char cb)
    {
        c = cb;
        this.notify();
    }

    /**
     * EventHandler függvény. A belépõ szál itt várakozik addig, amíg nincs lenyomott billentyû.
     * Ha van akkor visszatér vele.
     * @return lenyomott billentyû
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

