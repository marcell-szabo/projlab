package gui;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class IceField {
    final BufferedImage snow = ImageIO.read(getClass().getResource("/Users/kinga/projlab/sarkvidek/src/textures/snow.png"));
    final BufferedImage ice = ImageIO.read(getClass().getResource("/Users/kinga/projlab/sarkvidek/src/textures/ice.png"));
    final BufferedImage tentice = ImageIO.read(getClass().getResource("/Users/kinga/projlab/sarkvidek/src/textures/tentice.png"));
    final BufferedImage tentsnow = ImageIO.read(getClass().getResource("/Users/kinga/projlab/sarkvidek/src/textures/tentsnow.png"));
    final BufferedImage iglooice = ImageIO.read(getClass().getResource("/Users/kinga/projlab/sarkvidek/src/textures/iglooice.png"));
    final BufferedImage igloosnow = ImageIO.read(getClass().getResource("/Users/kinga/projlab/sarkvidek/src/textures/igloosnow.png"));


    public IceField() throws IOException {
    }
}
