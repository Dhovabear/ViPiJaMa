package Vues;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import models.Joueur;

public class JoueurView {

    private Joueur jToDisp;

    public JoueurView(){

    }

    public void setTarget(Joueur j){
        jToDisp = j;
    }

    public void draw(int x , int y,GraphicsContext g){
        if(jToDisp == null)return;

        g.setFill(jToDisp.getCouleur());
        g.fillRect(x-200,y,200,300);
        g.setFill(Color.BISQUE);
        g.fillRect(x-200+3,y+3,200-6,300-6);

    }
}
