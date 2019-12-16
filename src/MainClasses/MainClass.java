package MainClasses;

import Vues.SpriteIndex;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import models.GameManager;
import models.Joueur;

public class MainClass extends Application {

    public static Canvas cnv;
    public static Stage mainStage;
    public static GameManager gm;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 900, 600));
        primaryStage.show();
        //primaryStage.setResizable(false);

        //création du canvas de jeu
        Canvas nc = new Canvas();
        nc.setHeight(primaryStage.getHeight()-100);
        nc.setWidth(primaryStage.getWidth());
        cnv = nc;

        //on ajoute les events de redimenssionemment
        primaryStage.heightProperty().addListener((obs,oldval,newval)->{
            nc.setHeight(((double)newval)-100);
            nc.getGraphicsContext2D().setFill(Color.WHITE);
            nc.getGraphicsContext2D().fillRect(0,0,nc.getWidth(),nc.getHeight());
        });
        primaryStage.widthProperty().addListener((obs,oldval,newval)->{
            nc.setWidth((double)newval);
        });

        //on ajoute le canvas
        ((BorderPane)primaryStage.getScene().getRoot()).getChildren().add(nc);
        mainStage = primaryStage;

        SpriteIndex.loadImages();
        gm = new GameManager();
        gm.ajouterJoueur(new Joueur("Rémi",Color.RED));
        gm.ajouterJoueur(new Joueur("Robin",Color.BLUE));
        gm.ajouterJoueur(new Joueur("Kilian",Color.YELLOW));
        gm.ajouterJoueur(new Joueur("Maïdine",Color.PINK));
        gm.preparerJeu();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
