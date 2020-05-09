package graphics;

import Display.MainScreen;
import game.Game;

import javax.swing.*;


public class Main {
    public static void main(String[] args){
        Game game = new Game();
        //game.init(3);
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainScreen mainScreen = new MainScreen(game);
            }
        });

        //GameD gameD = new GameD("Jégmező", 840, 600, game);
        //gameD.start();
    }
}