package graphics;

import Display.MainScreen;
import game.Game;

import javax.swing.*;


public class Main {
    /**
     * Elindítja az alkalmazást
     * @param args
     */
    public static void main(String[] args){
        Game game = new Game();
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainScreen mainScreen = new MainScreen(game);
            }
        });
    }
}
