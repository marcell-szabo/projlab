package graphics;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

public class Assets {

    public static Map<String, BufferedImage> texture = new HashMap<>();

    private static String[] png = {"bear", "breakableshovel", "charge", "divingsuit", "esb", "esg", "eso", "esp", "esr", "esy", "exb", "exg",
            "exo", "exp", "exr", "exy", "flare", "food", "gun", "hole", "holepb", "ice", "iglooice", "igloosnow", "rope", "sea", "shovel",
            "snow", "tent", "tentice", "tentsnow"};


    public static void init(){
        for (int i = 0; i < png.length; i++){
            texture.put(png[i], ImageLoader.loadImage("/textures/" + png[i] + ".png"));
        }
    }
}
