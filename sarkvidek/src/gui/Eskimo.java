package gui;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Eskimo {
    final BufferedImage esb = ImageIO.read(getClass().getResource("/Users/kinga/projlab/sarkvidek/src/textures/esb.png"));
    final BufferedImage esg = ImageIO.read(getClass().getResource("/Users/kinga/projlab/sarkvidek/src/textures/esg.png"));
    final BufferedImage eso = ImageIO.read(getClass().getResource("/Users/kinga/projlab/sarkvidek/src/textures/eso.png"));
    final BufferedImage esp = ImageIO.read(getClass().getResource("/Users/kinga/projlab/sarkvidek/src/textures/esp.png"));
    final BufferedImage esr = ImageIO.read(getClass().getResource("/Users/kinga/projlab/sarkvidek/src/textures/esr.png"));
    final BufferedImage esy = ImageIO.read(getClass().getResource("/Users/kinga/projlab/sarkvidek/src/textures/esy.png"));

    public Eskimo() throws IOException {
    }
}
