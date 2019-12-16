package Controllers;

import MainClasses.MainClass;
import Vues.DiceView;
import Vues.JoueurView;
import com.sun.tools.javac.Main;
import exeptions.LimiteAtteinteException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import models.Dee;
import models.Joueur;
import models.FaceColor;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    @FXML
    Button LancerDee;

    @FXML
    Button bouttonPasseTour;


    private Random rng;

    private DiceView deeDisp;
    private JoueurView jv;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        rng = new Random();
        deeDisp = new DiceView(null);
        jv = new JoueurView();
    }

    public void passerTour(ActionEvent actionEvent) {
        if(!MainClass.gm.animationTourSuivantFini())return;

        MainClass.gm.tourSuivant();

        jv.setTarget(MainClass.gm.getCurrentPlayer());

        //region reset des bouttons
        LancerDee.setDisable(false);
        bouttonPasseTour.setDisable(true);
        //endregion

        GraphicsContext g = MainClass.cnv.getGraphicsContext2D();
        g.setFill(Color.WHITE);
        g.fillRect(0,0,MainClass.cnv.getWidth(),MainClass.cnv.getHeight());

        jv.draw((int)MainClass.cnv.getWidth(),0,MainClass.cnv.getGraphicsContext2D());
    }

    public void lancerDees(ActionEvent actionEvent) throws LimiteAtteinteException {
        LancerDee.setDisable(true);

        //on lance les dées pour tout le monde
        for (Joueur j : MainClass.gm.joueurs) {
            j.getDee(0).roll(rng);
            j.getDee(1).roll(rng);

            for (int i = 0; i < 2; i++){
                switch (j.getDee(i).getLastRollResult().getColor()){
                    case Or:
                        try{j.addOr(j.getDee(i).getLastRollResult().getValeur());}catch(Exception e){}
                        break;
                    case Solaire:
                        try{j.addSolaire(j.getDee(i).getLastRollResult().getValeur());}catch(Exception e){}
                        break;
                    case Lunaire:
                        try{j.addLunaire(j.getDee(i).getLastRollResult().getValeur());}catch(Exception e){}
                        break;
                }
            }
        }


        deeDisp.changeTarget(MainClass.gm.getCurrentPlayer().getDee(0));
        deeDisp.draw(20,(int)MainClass.cnv.getHeight()-80,MainClass.cnv.getGraphicsContext2D());

        deeDisp.changeTarget(MainClass.gm.getCurrentPlayer().getDee(1));
        deeDisp.draw(90,(int)MainClass.cnv.getHeight()-80, MainClass.cnv.getGraphicsContext2D());

        bouttonPasseTour.setDisable(false);
    }
}
