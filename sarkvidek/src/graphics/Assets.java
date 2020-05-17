package graphics;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

/**
 * A beolvasott k�peket t�rolja
 */
public class Assets {

    /**
     * A beolvasott k�peket t�r�l� map, melyben a k�p nev�vel �rhet� el az adott k�p
     */
    public static Map<String, BufferedImage> texture = new HashMap<>();

    /**
     * a k�pek nev�t tartalmaz� string t�mb.
     * ezalapj�n olvassa az init fv a k�peket
     */
    private static String[] png = {"bear", "charge", "divingsuit", "esb", "esg", "eso", "esp", "esr", "esy",
            "exb", "exg", "exo", "exp", "exr", "exy", "flare", "food", "gun", "hole", "holepb",
            "ice", "igloo", "rope", "sea", "shovel", "snow", "tent", "tentopen", "muchsnow"};


    /**
     * inicializ�l�sn�l beolvassa az �sszes k�pet, ami sz�ks�ges lehet �s elt�rolja egy map-ben
     */
    public static void init(){
        for (int i = 0; i < png.length; i++){
            texture.put(png[i], ImageLoader.loadImage("/textures/" + png[i] + ".png"));
        }
    }
}
