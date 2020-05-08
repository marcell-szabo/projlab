package controller;

import Display.Frame;

public class Controller
{
    public Controller(Frame f)
    {
        this.f = f;
        Instance = this;
    }

    public static Frame f; // ez attól függ hol van a frame-ünk
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

    public void update(){
        f.update();
    }

}

