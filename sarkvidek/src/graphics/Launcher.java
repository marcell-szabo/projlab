package graphics;

import Display.MainScreen;
import game.Game;


public class Launcher {
    public static void main(String[] args){
        Game game = new Game();
        //game.init(3);
        MainScreen mainScreen = new MainScreen(game);
        //GameD gameD = new GameD("Jégmezõ", 840, 600, game);
        //gameD.start();

    }
}
