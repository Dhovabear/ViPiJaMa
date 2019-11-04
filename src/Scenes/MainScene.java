package Scenes;

import Model.Color;
import Model.Dice;
import Model.Face;
import Vues.DiceView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class MainScene  implements Initializable {

    @FXML
    private Button rollButton;

    @FXML
    private Button changerFaces;

    @FXML
    private Canvas canva;

    private Dice dee;
    private DiceView dv;
    private Random rng;

    public static Stage mainStage;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        System.out.println("fenetre Chargée");
        dee = new Dice();
        try {
            dee.ajouterFace(new Face(1,Color.Or));
            dee.ajouterFace(new Face(2,Color.Or));
            dee.ajouterFace(new Face(3,Color.Lunaire));
            dee.ajouterFace(new Face(4,Color.Lunaire));
            dee.ajouterFace(new Face(5,Color.Solaire));
            dee.ajouterFace(new Face(6,Color.Solaire));
        } catch (Exception e){}

        rng = new Random(System.currentTimeMillis());
        dv = new DiceView(dee);



    }

    public void rollDice(ActionEvent actionEvent) {
        GraphicsContext g = canva.getGraphicsContext2D();
        g.setFill(javafx.scene.paint.Color.WHITE);
        g.fillRect(0,0,300,300);
        dee.roll(rng);
        dv.draw(rng.nextInt(230),rng.nextInt(230),g);
        Media son = null;

        try {
            String yolo = MainScene.class.getResource("/roll2.wav").toURI().toString();
            son = new Media(yolo);

        } catch (Exception e) {
            e.printStackTrace();
        }
        MediaPlayer mp = new MediaPlayer(son);
        mp.play();
    }

    public void openChange(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/changeFace.fxml"));
            /*
             * if "fx:controller" is not set in fxml
             * fxmlLoader.setController(NewWindowController);
             */
            Scene scene = new Scene(fxmlLoader.load(), 900, 100);
            Stage stage = new Stage();
            stage.setTitle("Edit dice");
            stage.setScene(scene);
            fxmlLoader.<ChangeFace>getController().setDiceToEdit(dee);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(mainStage);
            stage.sizeToScene();
            stage.setResizable(false);
            stage.showAndWait();
            System.out.println("fini");
        } catch (IOException e) {}
    }
}
