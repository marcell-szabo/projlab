package gui;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Hole {
    final BufferedImage hole = ImageIO.read(getClass().getResource("/Users/kinga/projlab/sarkvidek/src/textures/hole.png"));
    final BufferedImage snow = ImageIO.read(getClass().getResource("/Users/kinga/projlab/sarkvidek/src/textures/snow.png"));

    public Hole() throws IOException {
    }
}
