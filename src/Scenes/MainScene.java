package Scenes;

import Exceptions.ValeurNegatifException;
import Exceptions.ValeurTropGrandeException;
import Model.Color;
import Model.Dice;
import Model.Face;
import Vues.DiceView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

import java.awt.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URI;
import java.sql.Time;
import java.util.Random;
import java.util.ResourceBundle;

public class MainScene implements Initializable {

    @FXML
    private Button rollButton;

    @FXML
    private Button changerFaces;

    @FXML
    private Canvas canva;

    private Dice dee;
    private DiceView dv;
    private Random rng;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        System.out.println("fenetre Chargée");
        dee = new Dice();
        try {
            dee.ajouterFace(new Face(1,Color.OR));
            dee.ajouterFace(new Face(2,Color.OR));
            dee.ajouterFace(new Face(3,Color.LUNAIRE));
            dee.ajouterFace(new Face(4,Color.LUNAIRE));
            dee.ajouterFace(new Face(5,Color.SOLAIRE));
            dee.ajouterFace(new Face(6,Color.SOLAIRE));
        } catch (Exception e){}

        rng = new Random(System.currentTimeMillis());
        dv = new DiceView(dee);

        GraphicsContext g = canva.getGraphicsContext2D();
        g.setFill(javafx.scene.paint.Color.WHEAT);
        g.fillRect(0,0,300,300);

    }

    public void rollDice(ActionEvent actionEvent) {
        GraphicsContext g = canva.getGraphicsContext2D();
        g.setFill(javafx.scene.paint.Color.WHEAT);
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
}
