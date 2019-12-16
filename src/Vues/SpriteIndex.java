package Vues;

import javafx.scene.image.Image;

public class SpriteIndex {

    public static Image solaireIcon;
    public static Image lunaireIcon;
    public static Image gloireIcon;
    public static Image orIcon;


    public static void loadImages(){
        solaireIcon = new Image(SpriteIndex.class.getResource("/Images/solaire.png").toString());
        lunaireIcon = new Image(SpriteIndex.class.getResource("/Images/lunaire.png").toString());
        orIcon = new Image(SpriteIndex.class.getResource("/Images/gold.png").toString());
        gloireIcon = new Image(SpriteIndex.class.getResource("/Images/gloire.png").toString());
    }
}
