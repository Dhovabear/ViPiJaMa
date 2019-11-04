package Vues;

import Model.Dice;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class DiceView {

    private Dice dice;

    public DiceView(Dice deeaAfficher){
        this.dice = deeaAfficher;
    }

    public void  changeTarget(Dice ndee){
        this.dice = ndee;
    }

    public void draw(int x, int y , GraphicsContext g){
        //TODO: Optimiser l'utilisation des fonts

        g.setFill(javafx.scene.paint.Color.GRAY);
        g.fillRoundRect(x,y,70,70,10,10);
        switch (dice.getLastRollResult().getColor()){
            case Or: g.setFill(javafx.scene.paint.Color.YELLOW);break;
            case Lunaire: g.setFill(javafx.scene.paint.Color.DARKBLUE);break;
            case Solaire: g.setFill(javafx.scene.paint.Color.ORANGE);break;
            case Gloire: g.setFill(Color.GREEN);break;
        }
        g.fillRect(x+10,y+10,50, 50);
        g.setFill(javafx.scene.paint.Color.BLACK);
        g.setFont(Font.loadFont(getClass().getResourceAsStream("/polices/YARDSALE.TTF"),30.0));
        g.fillText(Integer.toString(dice.getLastRollResult().getValeur()),x+25,y+45);
    }
}
