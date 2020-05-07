package Faszom;

import Display.Display;
import game.Game;
import graphics.Assets;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class GameD implements Runnable {

    private Display display;
    public int width, height;
    public String title;
    private FieldsDraw fieldsDraw;
    private Game game;

    private boolean running = false;
    private Thread thread;

    private BufferStrategy bs;
    private Graphics g;


    public GameD(String title, int width, int height, Game game){
        this.width = width;
        this.height = height;
        this.title = title;
        this.game = game;
    }

    private void init(){
        display = new Display(title, width, height);
        Assets.init();
    }

    private void tick(){

    }

    private void render(){
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        g.clearRect(0,0,width,height);
        fieldsDraw = new FieldsDraw(g, game);

        seaDraw();
        fieldsDraw.MapDraw();

        bs.show();
        g.dispose();
    }

    public void run(){

        init();

        while(running){
            tick();
            render();
        }

        stop();

    }

    public synchronized void start(){
        if(running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop(){
        if(!running)
            return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void seaDraw(){
        for(int x = 0; x < 14; x++)
            g.drawImage(Assets.texture.get("sea"), x*60, 0,null);

        for(int x = 0; x < 14; x++)
            g.drawImage(Assets.texture.get("sea"), x*60, 540,null);

        for(int y = 0; y < 8; y++)
            g.drawImage(Assets.texture.get("sea"), 0, (y+1)*60,null);

        for(int y = 0; y < 8; y++)
            g.drawImage(Assets.texture.get("sea"), 780, (y+1)*60,null);

    }

}
