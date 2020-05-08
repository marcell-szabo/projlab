package controller;
import Faszom.GameD;

public class Controller
{
    public Controller(GameD f)
    {
        this.f = f;
        Instance = this;
    }

    public GameD f; // ez att�l f�gg hol van a frame-�nk
    public volatile char c;
    public static Controller Instance;

    public synchronized void setC(char cb, KeyboardEventHandler keh)
    {
        c = cb;
        //f.removeKeyListener(keh);
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

