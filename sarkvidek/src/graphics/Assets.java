package graphics;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

/**
 * A beolvasott képeket tárolja
 */
public class Assets {

    /**
     * A beolvasott képeket táróló map, melyben a kép nevével érhetõ el az adott kép
     */
    public static Map<String, BufferedImage> texture = new HashMap<>();

    /**
     * a képek nevét tartalmazó string tömb.
     * ezalapján olvassa az init fv a képeket
     */
    private static String[] png = {"bear", "charge", "divingsuit", "esb", "esg", "eso", "esp", "esr", "esy",
            "exb", "exg", "exo", "exp", "exr", "exy", "flare", "food", "gun", "hole", "holepb",
            "ice", "igloo", "rope", "sea", "shovel", "snow", "tent", "tentopen", "muchsnow"};


    /**
     * inicializálásnál beolvassa az összes képet, ami szükséges lehet és eltárolja egy map-ben
     */
    public static void init(){
        for (int i = 0; i < png.length; i++){
            texture.put(png[i], ImageLoader.loadImage("/textures/" + png[i] + ".png"));
        }
    }
}
