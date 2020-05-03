package gui;

import game.Game;

import java.awt.*;

public class Main {
    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            try {
                Application application = new Application();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
