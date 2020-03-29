package skeleton;

import javax.print.DocFlavor;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;
import static skeleton.Direction.*;

public class Skeleton {


    public void runSkeleton() {
        System.out.println("Sarkvidék Skeleton\nAdja meg a kívánt kódot\n" +
                "1. Helyzetváltoztatás\n2. Hó eltakaritása\n3. Tárgy felvétele, válassza ki mit akar felvenni" +
                "\n4. Speciális képesség használata\n5. Jelzőrakéta összeszerelése és elsütése\n6. Vihar");
        Scanner scan = new Scanner(System.in);
        int command = scan.nextInt();
        System.out.println(command);
        Player p1 = new Eskimo(new Game(), new IceField());
        Player p2 = new Explorer(new Game(), new IceField());
        Result res;
        boolean exit = false;
        while (exit != true) {
            switch (command) {
                case 1:
                    System.out.print("Helyzetváltoztatás\n");
                    System.out.println("A J(jobbra), B(balra), F(fel), L(le) karakterek segítségével válasszon," +
                            "mely irányba szeretne haladni.");
                    Scanner sc = new Scanner(System.in);
                    String c = sc.next();
                    Direction d = UP;
                    switch (c) {
                        case "J":
                            d = RIGHT;
                            break;
                        case "B":
                            d = LEFT;
                            break;
                        case "F":
                            d = UP;
                            break;
                        case "L":
                            d = DOWN;
                            break;
                    }
                    p1.move(d);
                    break;
                case 2:
                    System.out.print("Hó eltakaritása\n");
                    p1.clean();
                    break;
                case 3:
                    System.out.print("Tárgy felvétele\n");
                    IceField ice = new IceField();
                    res = ice.pickUp(p1);
                    break;
                case 4:
                    System.out.print("Speciális képesség használata");
                    System.out.println("Adja meg a kívánt kódot!\n" + "1. Eszkimó iglut épít\n"
                            + "2. Sarkkutató teherbírást vizsgál\n");
                    int special = scan.nextInt();
                    System.out.println(special);
                    switch (special) {
                        case 1:
                            System.out.println("Eszkimó iglut épít\n");
                            res = p1.specialSkill();
                            break;
                        case 2:
                            System.out.println("Sarkkutató teherbírást vizsgál\n");
                            res = p2.specialSkill();
                            break;
                        default:
                            System.out.println("Helytelen érték!\n");
                            break;
                    }
                    break;
                case 5:
                    p1.assemble();
                    System.out.print("Jelzőrakéta összeszerelése\n");
                    break;
                case 6:
                    GameBoard gb = new GameBoard(5);
                    gb.storm();
                    break;
                case 7:
                    exit = true;
                default:
                    System.out.println("Hibás válasz!\n");
                    break;
            }
        }
    }
}