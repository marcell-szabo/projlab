package graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Egy k�pf�jl beolvas�s��rt felel�s
 */
public class ImageLoader {

    /**
     * beolvassa a param�terk�nt megkapott k�pet egy BufferedImage-be
     * @param path - a k�pf�jl el�r�si �tvonala
     * @return a beolvasott BufferedImageel
     */
    public static BufferedImage loadImage(String path){
        try {
            return ImageIO.read(ImageLoader.class.getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }

}
