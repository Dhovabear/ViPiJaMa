package models;

import exeptions.ValeurNegatifException;
import exeptions.ValeurTropGrandeException;

public class Face {
    private FaceColor couleur;
    private int valeur;

    public Face(int valeur, FaceColor couleur) throws ValeurTropGrandeException, ValeurNegatifException {
        if(valeur > 6)throw new ValeurTropGrandeException();
        if(valeur < 0)throw new ValeurNegatifException();
        this.valeur = valeur;
        this.couleur = couleur;
    }

    public FaceColor getColor() {
        return couleur;
    }

    public int getValeur() {
        return valeur;
    }
}
