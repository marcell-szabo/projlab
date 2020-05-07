package graphics;

import Display.MainScreen;
import game.Game;

import javax.swing.*;


public class Launcher {
    public static void main(String[] args){
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Game game = new Game();
        //game.init(3);
        MainScreen mainScreen = new MainScreen(game);
        //GameD gameD = new GameD("Jégmezõ", 840, 600, game);
        //gameD.start();


    }
}
