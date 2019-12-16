package models;

import exeptions.LimiteAtteinteException;
import exeptions.ValeurNegatifException;
import exeptions.ValeurTropGrandeException;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Joueur {

    //region champs Privés
    private int or, maxOr;
    private int lunaire, solaire, maxLunaire, maxSolaire;
    private int ptVictoire;
    private int nbExtension;
    private String nom;
    private Color couleur;
    private Dee dees[]; //tableau des dées
    private ArrayList<Face> faces; //liste des faces
    //endregion

    public Joueur(String nom, Color couleur){
        this.nom = nom;
        this.couleur = couleur;
        or = 0;
        maxOr = 12;
        lunaire = 0;
        maxLunaire = 6;
        solaire = 0;
        maxSolaire = 6;
        ptVictoire = 0;
        nbExtension =0;

        faces = new ArrayList<Face>();

        //region initialisation des dées
        dees = new Dee[2];
        dees[0] = new Dee();
        dees[1] = new Dee();
        for (int i = 0; i < 6 ; i++ ){
            try {
                dees[0].changerFace(i,new Face(1,FaceColor.Or));
                dees[1].changerFace(i,new Face(1,FaceColor.Or));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            dees[0].changerFace(0,new Face(1,FaceColor.Lunaire));
            dees[1].changerFace(0,new Face(1,FaceColor.Solaire));
        } catch (Exception e) {
            e.printStackTrace();
        }
        //endregion

    }

    //region Fonctions a rémi
    public void addExtension(){
        nbExtension++;
        maxOr += 4;
        maxLunaire += 4;
        maxSolaire +=4;
    }

    public void addOr(int lamoney) throws LimiteAtteinteException {
        if (or+lamoney > maxOr){
            or = getMaxOr();
            throw new LimiteAtteinteException();
        }
        or += lamoney;
    }

    public void payerEnOr(int montant) throws ValeurNegatifException {
        if (or < montant) throw new ValeurNegatifException();
        or -= montant;
    }

    public void addLunaire(int luna) throws LimiteAtteinteException {
        if (lunaire+luna > maxLunaire)throw new LimiteAtteinteException();
        lunaire += luna;
    }

    public void payerEnLunaire(int montant) throws ValeurNegatifException {
        if (lunaire < montant) throw new ValeurNegatifException();
        lunaire -= montant;
    }

    public void addSolaire(int sola) throws LimiteAtteinteException {
        if (solaire+sola > maxSolaire){
            solaire = getMaxSolaire();
            throw new LimiteAtteinteException();
        }
        solaire += sola;
    }

    public void payerEnSolaire(int montant) throws ValeurNegatifException {
        if (solaire < montant) throw new ValeurNegatifException();
        solaire -= montant;
    }

    public void addPtVictoire(int ptVic) throws LimiteAtteinteException {
        ptVictoire += ptVic;
    }
    //endregion

    //region getter and setter

    public int getOr() {
        return or;
    }

    public int getMaxOr() {
        return maxOr;
    }

    public int getLunaire() {
        return lunaire;
    }

    public int getSolaire() {
        return solaire;
    }

    public int getMaxLunaire() {
        return maxLunaire;
    }

    public int getMaxSolaire() {
        return maxSolaire;
    }

    public int getPtVictoire() {
        return ptVictoire;
    }

    public int getNbExtension() {
        return nbExtension;
    }

    public String getNom() {
        return nom;
    }

    public Color getCouleur() {
        return couleur;
    }

    public Dee getDee(int id) {
        return dees[id];
    }

    //endregion
}
