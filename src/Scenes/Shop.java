package Scenes;

import Exceptions.LimiteAtteinteException;
import Exceptions.ValeurNegatifException;
import Exceptions.ValeurTropGrandeException;
import Model.Color;
import Model.Face;
import Model.PlateauJoueur;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

public class Shop implements Initializable {

    @FXML
    ComboBox<Integer> prix;

    @FXML
    VBox listArticles;

    @FXML
    Label orDisplayer;

    HashMap<Integer,List<Face>> magasin;



    public void Buy(ActionEvent actionEvent) throws LimiteAtteinteException {
        HBox b = (HBox)((Node)actionEvent.getSource()).getParent();
        int idToBuy = Integer.parseInt(b.getId());
        System.out.println("idTo>Buy="+idToBuy);
        int currentPrix = prix.getValue();
        PlateauJoueur.joueurCourant.addOr(-currentPrix);
        magasin.get(currentPrix).remove(magasin.get(currentPrix).get(idToBuy));
        updateArt(actionEvent);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("protoooot");
        magasin = new HashMap<Integer, List<Face>>();
        //TODO: ajouter les articles avec la liste et l'associer a un prix
        List<Face> list1 = new ArrayList<Face>();
        try {
            list1.add(new Face(5, Color.Or));
            list1.add(new Face(6, Color.Lunaire));
            list1.add(new Face(4, Color.Gloire));
            list1.add(new Face(2, Color.Solaire));

        } catch (Exception e) {}
        magasin.put(2,list1);
        List<Face> list2 = new ArrayList<Face>();
        try {
            list2.add(new Face(1, Color.Solaire));
            list2.add(new Face(6, Color.Lunaire));
            list2.add(new Face(1, Color.Gloire));
            list2.add(new Face(2, Color.Solaire));
            list2.add(new Face(2, Color.Gloire));
            list2.add(new Face(2, Color.Solaire));

        } catch (Exception e) {}
        magasin.put(3,list2);
        magasin.put(4,new ArrayList<>());
        magasin.put(5,new ArrayList<>());
        magasin.put(6,new ArrayList<>());
        magasin.put(8,new ArrayList<>());
        magasin.put(12,new ArrayList<>());
        Thread cDegeuMaisGPaLeChoa = new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(300);
                    updateArt(new ActionEvent());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        cDegeuMaisGPaLeChoa.start();
    }

    public void updateArt(ActionEvent actionEvent) {
        int prixn = prix.getValue();
        listArticles.getChildren().clear();
        orDisplayer.setText("Or: " + PlateauJoueur.joueurCourant.getOr());
        if(magasin.get(prixn).isEmpty() || !magasin.containsKey(prixn)){
            Label l2 = new Label();
            l2.setStyle("-fx-background-color: red");
            l2.setText("Aucun article disponible pour le moment");
            listArticles.getChildren().add(l2);
            return;
        }
        for (Face f : magasin.get(prixn)){

            Label l = new Label();
            l.setText(f.getColor().toString() +"\t"+ f.getValeur());
            l.setLineSpacing(100);
            l.setMinWidth(200);
            l.setTextAlignment(TextAlignment.CENTER);

            Button bt = new Button();
            bt.setText("Buy");
            if(prixn > PlateauJoueur.joueurCourant.getOr()){bt.setDisable(true);}
            else{bt.setDisable(false);}
            bt.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    try {
                        Buy(actionEvent);
                    } catch (LimiteAtteinteException e) {
                        e.printStackTrace();
                    }
                }
            });

            HBox hb = new HBox();
            hb.setStyle("-fx-background-color: beige");
            hb.getChildren().add(l);
            hb.getChildren().add(bt);
            hb.setId(Integer.toString(magasin.get(prixn).indexOf(f)));

            listArticles.getChildren().add(hb);
        }
    }
}
