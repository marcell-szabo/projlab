package graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Egy képfájl beolvasásáért felelõs
 */
public class ImageLoader {

    /**
     * beolvassa a paraméterként megkapott képet egy BufferedImage-be
     * @param path - a képfájl elérési útvonala
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
