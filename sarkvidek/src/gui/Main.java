package gui;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Application application = new Application();
                MainScreen mainScreen = new MainScreen();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
