package models;

import MainClasses.MainClass;
import exeptions.PasAssezDeJoueurException;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;

public class GameManager {

    public ArrayList<Joueur> joueurs;

    private int currentPlayer = -1;
    private boolean animFini = false;
    private Pane tourJ;
    private Text t;

    public GameManager(){
        joueurs = new ArrayList<Joueur>();
    }

    public void preparerJeu()throws PasAssezDeJoueurException {
        if(joueurs.size() < 2) throw new PasAssezDeJoueurException();
        tourSuivant();
    }

    public Joueur getCurrentPlayer(){
        return joueurs.get(currentPlayer);
    }

    public boolean animationTourSuivantFini(){
        return animFini;
    }

    public void tourSuivant(){
        currentPlayer++;
        if(currentPlayer >= joueurs.size()) currentPlayer =0;
        GraphicsContext g = MainClass.cnv.getGraphicsContext2D();
        Pane p = (Pane)(MainClass.mainStage.getScene().getRoot());

        tourJ = new Pane();
        tourJ.setLayoutY(MainClass.mainStage.getHeight());
        tourJ.setLayoutX(MainClass.mainStage.getWidth()/2 - 100);
            t =  new Text(" Au tour de  " + joueurs.get(currentPlayer).getNom());
            t.setFont(Font.font(20.0f));
            tourJ.getChildren().add(t);

        p.getChildren().add(tourJ);
        animFini = false;
        TranslateTransition tt = new TranslateTransition(Duration.millis(1000),tourJ);
        tt.setByY(-(MainClass.mainStage.getHeight()/2) - 100);
        tt.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("yo");

                tourJ.setLayoutY(MainClass.mainStage.getHeight());
                Thread d = new Thread(){
                    @Override
                    public void run() {
                        try {
                            sleep(500);
                            animFini = true;
                            tourJ.setVisible(false);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                };
                d.run();

            }
        });
        tt.play();

    }

    public void ajouterJoueur(Joueur j) {
        joueurs.add(j);
    }

    //region infoDuTour

    //endregion


}
