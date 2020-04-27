package skeleton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<String[]> setfields = new ArrayList<>();
        ArrayList<String[]> addfields = new ArrayList<>();
        ArrayList<String[]> players = new ArrayList<>();
        ArrayList<String[]> commands = new ArrayList<>();
        String bearStart = "";
        /*
        setfield, addfield game->gameboard
        0-fel, 1-jobbra, 2-le, 3-balra
        move-clean-pickup-build billentyûre átalakítás
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String currentLine;
        try {
            currentLine = br.readLine();
            while (!(currentLine == null) && (!currentLine.equals("")) ) {
                String[] line = currentLine.split(" ");
                if(line[0].equals("fieldnumber") || line[0].equals("setfield"))
                    setfields.add(line);
                else if (line[0].equals("addfield"))
                    addfields.add(line);
                else if(line[0].equals("addplayer"))
                    players.add(line);
                else if(line[0].equals("setbear"))
                    bearStart = line[2];
                else if(line[0].equals("state")){
                    commands.add(line);
                }
                else{
                    if(line[0].equals("move")){
                        switch (Integer.parseInt(line[2])){
                            case 0:
                                line[0] = "W"; break;
                            case 1:
                                line[0] = "D"; break;
                            case 2:
                                line[0] = "S"; break;
                            case 3:
                                line[0] = "A"; break;
                            default: break;
                        }
                    } else if(line[0].equals("clean"))
                        line[0] = "J";
                    else if(line[0].equals("pickup"))
                        line[0] = "K";
                    else if(line[0].equals("buildigloo"))
                        line[0] = "L";
                    else if(line[0].equals("examine")){
                        line[0] = "L";
                        switch (Integer.parseInt(line[2])){
                            case 0:
                                line[0] = "W"; break;
                            case 1:
                                line[0] = "D"; break;
                            case 2:
                                line[0] = "S"; break;
                            case 3:
                                line[0] = "A"; break;
                            default: break;
                        }
                    } else if(line[0].equals("buildtent"))
                        line[0] = "M";
                    else if(line[0].equals("assemble"))
                        line[0] = "I";
                    commands.add(line);
                }

            }
        }catch(IOException e){
                e.printStackTrace();
        }

        Game game = new Game(setfields, addfields, players, bearStart);
        game.mainLoop(commands);
    }

}