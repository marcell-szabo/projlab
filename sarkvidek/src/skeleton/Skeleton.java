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
            case 1: System.out.print("Helyzetváltoztatás");
                    break;
            case 2: System.out.print("Hó eltakaritása");
                    break;
            case 3: System.out.print("Tárgy felvétele");
                    break;
            case 4: System.out.print("Speciális képesség használata");
                    break;
            case 5: System.out.print("Jelzőrakéta összeszerelése");
                    break;
            case 6: //System.out.print("Vihar");
                    GameBoard gb = new GameBoard(5);
                    gb.storm();
                    break;
        }
    }
}
