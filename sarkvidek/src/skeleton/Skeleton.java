package skeleton;

import javax.print.DocFlavor;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

import static skeleton.Direction.*;

public class Skeleton {
    /**
     * A Skeleton programot futtatja. A standard inputra kiírja a szöveges skeleton menüt majd a felhasználói interakció
     * után az adott mûködést (a szekvenciadiagramokon definiált formában) lefuttatja. Az egyes függvényhívási láncok
     * így láthatók a következõ formátumban: skeleton.Class@objektum_címe.metódus(paraméterek)
     */
    public void runSkeleton() {
        Scanner scan = new Scanner(System.in);
        Player p1 = new Eskimo(new Game(), new IceField());
        Player p2 = new Explorer(new Game(), new IceField());
        Result res;
        boolean exit = false;
        while (exit != true) {
            System.out.println("Sarkvidek Skeleton\nAdja meg a kivant kodot\n" +
                    "1. Helyzetvaltoztatas\n2. Ho eltakaritasa\n3. Targy felvatele, valassza ki mit akar felvenni" +
                    "\n4. Specialis kepesseg hasznalata\n5. Jelzoraketa osszeszereléese és elsutese\n6. Vihar\n7. Kilepes");
            int command = scan.nextInt();
            System.out.println(command);
            switch (command) {
                case 1:
                    System.out.println("A J(jobbra), B(balra), F(fel), L(le) karakterek segitsegevel valasszon," +
                            "mely iranyba szeretne haladni.\nA tesztekben a jobbra lyuk található, " +
                            "felfelé és balra egy stabil mezõ, lefelé pedig egy instabil mezõ.");
                    String c = scan.next();
                    Direction d = UP;
                    switch (c) {
                        case "B":
                            System.out.println("Balra lepes\nStabil mezore lepes.");
                            d = LEFT;
                            p1.move(d);
                            break;
                        case "F":
                            System.out.println("Felfele lepes\nStabil mezore lepes.");
                            d = UP;
                            p1.move(d);
                            break;
                        case "J":
                            System.out.println("Jobbra lepes\nLyukba esett.");
                            d = RIGHT;
                            p1.move(d);
                            break;
                        case "L":
                            System.out.println("Lefele lepes\nInstabil mezore lepes");
                            d = DOWN;
                            p1.move(d);
                            break;
                    }
                    break;
                case 2:
                    p1.clean();
                    break;
                case 3:
                    IceField ice = new IceField();
                    res = ice.pickUp(p1);
                    break;
                case 4:
                    System.out.println("Adja meg a kivant kodot!\n" + "1. Eszkimo iglut epit\n"
                            + "2. Sarkkutato teherbirast vizsgal\n");
                    int special = scan.nextInt();
                    System.out.println(special);
                    switch (special) {
                        case 1:
                            System.out.println("Eszkimo iglut epit\n");
                            res = p1.specialSkill();
                            break;
                        case 2:
                            System.out.println("Sarkkutato teherbirast vizsgal\n");
                            res = p2.specialSkill();
                            break;
                        default:
                            System.out.println("Helytelen ertek!\n");
                            break;
                    }
                    break;
                case 5:
                    p1.assemble();
                    break;
                case 6:
                    GameBoard gb = new GameBoard(5);
                    gb.storm();
                    break;
                case 7:
                    exit = true;
                    break;
                default:
                    System.out.println("Hibas valasz!\n");
                    break;
            }
        }
    }
}