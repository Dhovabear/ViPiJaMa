package Model;

import Exceptions.ValeurNegatifException;
import Exceptions.ValeurTropGrandeException;

public class Face {

    private Color couleur;
    private int valeur;

    public Face(int valeur, Color couleur) throws ValeurTropGrandeException, ValeurNegatifException {
        if(valeur > 6)throw new ValeurTropGrandeException();
        if(valeur < 0)throw new ValeurNegatifException();
        this.valeur = valeur;
        this.couleur = couleur;
    }

    public Color getColor() {
        return couleur;
    }

    public int getValeur() {
        return valeur;
    }
}
