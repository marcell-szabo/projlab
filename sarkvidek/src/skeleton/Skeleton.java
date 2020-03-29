package skeleton;

import javax.print.DocFlavor;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

public class Skeleton {

    public void runSkeleton() {
        System.out.println("Sarkvidék Skeleton\nAdja meg a kívánt kódot\n" +
                            "1. Helyzetváltoztatás\n2. Hó eltakaritása\n3. Tárgy felvétele, válassza ki mit akar felvenni" +
                            "\n4. Speciális képesség használata\n5. Jelzőrakéta összeszerelése és elsütése\n6. Vihar");
        Scanner scan = new Scanner(System.in);
        int command = scan.nextInt();
        System.out.println(command);
        switch (command) {
            case 1:
                System.out.print("Helyzetváltoztatás\n");
                break;
            case 2:
                System.out.print("Hó eltakaritása\n");
                break;
            case 3:
                System.out.print("Tárgy felvétele\n");
                IceField ice = new IceField();
                Eskimo e = new Eskimo();
                Result res = ice.pickUp(e);
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
                        break;
                    case 2:
                        System.out.println("Sarkkutató teherbírást vizsgál\n");
                        break;
                    default:
                        System.out.println("Helytelen érték!\n");
                        break;
                }
                break;
            case 5:
                System.out.print("Jelzőrakéta összeszerelése\n");
                break;
            case 6:
                System.out.print("Vihar\n");
                break;
            default:
                System.out.println("Hibás válasz!\n");
                break;
        }
    }
}
