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
                "\n4. Speciális képesség használata\n5. Jelzőrakéta összeszerelése és elsütése\n6. Vihar\n7. Kilépés");
        Scanner scan = new Scanner(System.in);
        int command = scan.nextInt();
        System.out.println(command);
        Player p1 = new Eskimo();
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
                    System.out.print("Hó eltakaritása");
                    p1.clean();
                    break;
                case 3:
                    System.out.print("Tárgy felvétele");
                    break;
                case 4:
                    System.out.print("Speciális képesség használata");
                    break;
                case 5:
                    System.out.print("Jelzőrakéta összeszerelése");
                    p1.assemble();
                    break;
                case 6: //System.out.print("Vihar");
                    GameBoard gb = new GameBoard(5);
                    gb.storm();
                    break;
                case 7:
                    exit = true;
            }
        }
    }
}