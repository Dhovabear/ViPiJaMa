package Vues;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
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

        g.setFill(Color.BLACK);

        Font fu = new Font(30.0);
        g.setFont(fu);
        g.fillText(jToDisp.getNom(),x-200 + 10,y+3+30);

        g.drawImage(SpriteIndex.orIcon,x-200 + 10,y + 60,40,40);
        g.fillText(" x " + jToDisp.getOr(),x-200 + 60, y + 90);

        g.drawImage(SpriteIndex.lunaireIcon,x-200+10,y+120,40,40);
        g.fillText(" x " + jToDisp.getLunaire(),x-200+60,y+150);

        g.drawImage(SpriteIndex.solaireIcon,x-200+10,y+180,40,40);
        g.fillText(" x " + jToDisp.getSolaire(),x-200+60,y+210);

        g.drawImage(SpriteIndex.gloireIcon,x-200+10,y+240,40,40);
        g.fillText(" x " + jToDisp.getSolaire(),x-200+60,y+270);
    }
}
