package game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {


    /*kjhgfdsdfghjklélkjhgfdfghjklé*/
    public static void main(String[] args) {
        ArrayList<String[]> fields = new ArrayList<>();
        ArrayList<String[]> players = new ArrayList<>();
        ArrayList<String[]> commands = new ArrayList<>();
        ArrayList<String[]> neighbours = new ArrayList<>();
        String bearStart = "";

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String currentLine;
        try {
            currentLine = br.readLine();
            while (!(currentLine == null) && (!currentLine.equals("")) ) {
                String[] line = currentLine.split(" ");
                if(line[0].equals("setfield"))
                    fields.add(line);
                else if(line[0].equals("addfield"))
                    neighbours.add((line));
                else if(line[0].equals("addplayer"))
                    players.add(line);
                else if(line[0].equals("setbear"))
                    if(line[1].equals("r"))
                        bearStart = null;
                    else
                        bearStart = line[2];
                else if(line[0].equals("state")){
                    commands.add(line);
                }else if(line[0].equals("bear"))
                    commands.add(line);
                else if(line[0].equals("storm"))
                    commands.add(line);
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
                    } else if(line[0].equals("buildtent"))
                        line[0] = "M";
                    else if(line[0].equals("assemble"))
                        line[0] = "I";
                    commands.add(line);
                }
                currentLine = br.readLine();
            }
        }catch(IOException e){
                e.printStackTrace();
        }

        Game game = new Game(fields, players, bearStart, neighbours);
        game.mainLoop(commands);
    }

}