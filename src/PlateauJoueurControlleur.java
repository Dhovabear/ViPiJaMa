import Model.PlateauJoueur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseDragEvent;


public class PlateauJoueurControlleur {

    @FXML
    Label lgold;

    @FXML
    Label llunaire;

    @FXML
    Label lsolaire;

    @FXML
    Label lgloire;

    public void RefreshInfo(ActionEvent actionEvent) {
        lgold.setText("x "+PlateauJoueur.joueurCourant.getOr());
        llunaire.setText("x "+PlateauJoueur.joueurCourant.getLunaire());
        lsolaire.setText("x "+PlateauJoueur.joueurCourant.getSolaire());
        lgloire.setText("x "+PlateauJoueur.joueurCourant.getPtVictoire());
    }
}
