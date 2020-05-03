package gui;

import game.Game;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        EventQueue.invokeLater(() -> {
            try {
                Application application = new Application(game);
                MainScreen mainScreen = new MainScreen(game);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
