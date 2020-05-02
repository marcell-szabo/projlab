package gui;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Explorer {
    final BufferedImage exb = ImageIO.read(getClass().getResource("/Users/kinga/projlab/sarkvidek/src/textures/exb.png"));
    final BufferedImage exg = ImageIO.read(getClass().getResource("/Users/kinga/projlab/sarkvidek/src/textures/exg.png"));
    final BufferedImage exo = ImageIO.read(getClass().getResource("/Users/kinga/projlab/sarkvidek/src/textures/exo.png"));
    final BufferedImage exp = ImageIO.read(getClass().getResource("/Users/kinga/projlab/sarkvidek/src/textures/exp.png"));
    final BufferedImage exr = ImageIO.read(getClass().getResource("/Users/kinga/projlab/sarkvidek/src/textures/exr.png"));
    final BufferedImage exy = ImageIO.read(getClass().getResource("/Users/kinga/projlab/sarkvidek/src/textures/exy.png"));

    public Explorer() throws IOException {
    }
}
