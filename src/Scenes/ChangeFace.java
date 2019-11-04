package Scenes;
import Exceptions.ValeurNegatifException;
import Exceptions.ValeurTropGrandeException;
import Model.Color;
import Model.Dice;
import Model.Face;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ChangeFace implements Initializable {
    @FXML
    ComboBox face1Couleur;
    @FXML
    Spinner valeurFace1;

    @FXML
    ComboBox face2Couleur;
    @FXML
    Spinner valeurFace2;

    @FXML
    ComboBox face3Couleur;
    @FXML
    Spinner valeurFace3;

    @FXML
    ComboBox face4Couleur;
    @FXML
    Spinner valeurFace4;

    @FXML
    ComboBox face5Couleur;
    @FXML
    Spinner valeurFace5;

    @FXML
    ComboBox face6Couleur;
    @FXML
    Spinner valeurFace6;

    Dice d;
    public void setDiceToEdit(Dice d){
        this.d = d;
        System.out.println("done");
        setValues();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    private void setValues(){
        try {
            face1Couleur.setValue(d.getFace(0).getColor().toString());
            face2Couleur.setValue(d.getFace(1).getColor().toString());
            face3Couleur.setValue(d.getFace(2).getColor().toString());
            face4Couleur.setValue(d.getFace(3).getColor().toString());
            face5Couleur.setValue(d.getFace(4).getColor().toString());
            face6Couleur.setValue(d.getFace(5).getColor().toString());

            valeurFace1.getValueFactory().setValue(d.getFace(0).getValeur());
            valeurFace2.getValueFactory().setValue(d.getFace(1).getValeur());
            valeurFace3.getValueFactory().setValue(d.getFace(2).getValeur());
            valeurFace4.getValueFactory().setValue(d.getFace(3).getValeur());
            valeurFace5.getValueFactory().setValue(d.getFace(4).getValeur());
            valeurFace6.getValueFactory().setValue(d.getFace(5).getValeur());
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void setChanges(ActionEvent actionEvent) {
        try {
            d.changerFace(0,new Face((int)valeurFace1.getValue(),Color.valueOf(Color.class,(String)face1Couleur.getValue())));
            d.changerFace(1,new Face((int)valeurFace2.getValue(),Color.valueOf(Color.class,(String)face2Couleur.getValue())));
            d.changerFace(2,new Face((int)valeurFace3.getValue(),Color.valueOf(Color.class,(String)face3Couleur.getValue())));
            d.changerFace(3,new Face((int)valeurFace4.getValue(),Color.valueOf(Color.class,(String)face4Couleur.getValue())));
            d.changerFace(4,new Face((int)valeurFace5.getValue(),Color.valueOf(Color.class,(String)face5Couleur.getValue())));
            d.changerFace(5,new Face((int)valeurFace6.getValue(),Color.valueOf(Color.class,(String)face6Couleur.getValue())));
        } catch (Exception e) {}

        Stage s = (Stage)valeurFace1.getScene().getWindow();
        s.close();
    }
}
