package Vues;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import models.Dee;

public class DiceView {

    private Dee dice;


    public DiceView(Dee deeaAfficher){
        this.dice = deeaAfficher;
    }

    public void  changeTarget(Dee ndee){
        this.dice = ndee;
    }

    public void draw(int x, int y , GraphicsContext g){
        //TODO: Optimiser l'utilisation des fonts
        g.setFill(javafx.scene.paint.Color.GRAY);
        g.fillRoundRect(x,y,70,70,10,10);
        g.setFill(Color.BISQUE);
        g.fillRect(x+10,y+10,50, 50);
        Image imgToDraw = null;
        switch (dice.getLastRollResult().getColor()){
            case Or: imgToDraw = SpriteIndex.orIcon ;break;
            case Lunaire: imgToDraw = SpriteIndex.lunaireIcon;break;
            case Solaire: imgToDraw = SpriteIndex.solaireIcon;break;
            case Gloire: imgToDraw = SpriteIndex.gloireIcon;break;
        }
        g.drawImage(imgToDraw,x+10,y+10,50,50);
        g.setFill(javafx.scene.paint.Color.BLACK);
        g.setFont(Font.loadFont(getClass().getResourceAsStream("/polices/YARDSALE.TTF"),30.0));
        g.fillText(Integer.toString(dice.getLastRollResult().getValeur()),x+25,y+45);
    }
}