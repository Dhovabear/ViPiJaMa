import Exceptions.ValeurNegatifException;
import Exceptions.ValeurTropGrandeException;
import Model.Color;
import Model.Dice;
import Model.Face;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.paint.Paint;

import java.awt.*;
import java.net.URL;
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
    }

    public void rollDice(ActionEvent actionEvent) {
        GraphicsContext g = canva.getGraphicsContext2D();
        g.setFill(javafx.scene.paint.Color.GRAY);
        g.fillRect(0,0,300,300);
        Face goodFace = dee.roll(rng);
        switch (goodFace.getColor()){
            case OR: g.setFill(javafx.scene.paint.Color.YELLOW);break;
            case LUNAIRE: g.setFill(javafx.scene.paint.Color.DARKBLUE);break;
            case SOLAIRE: g.setFill(javafx.scene.paint.Color.ORANGE);break;
        }
        g.fillRect(100,100,50, 50);
        g.setFill(javafx.scene.paint.Color.BLACK);
        g.fillText(Integer.toString(goodFace.getValeur()),130,130);
    }
}
