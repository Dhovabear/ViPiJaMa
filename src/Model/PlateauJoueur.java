package Model;


import Exceptions.LimiteAtteinteException;
import Exceptions.ValeurNegatifException;

import java.util.ArrayList;

public class PlateauJoueur {
    private int or, maxOr;
    private int lunaire, solaire, maxLunaire, maxSolaire;
    private int ptVictoire;
    private int nbExtension;

    public static PlateauJoueur joueurCourant;

    public PlateauJoueur(){
        or = 0;
        maxOr = 12;
        lunaire = 0;
        maxLunaire = 6;
        solaire = 0;
        maxSolaire = 6;
        ptVictoire = 0;
        nbExtension = 0;
    }

    public void addExtension(){
        nbExtension++;
        maxOr += 4;
        maxLunaire += 4;
        maxSolaire +=4;
    }

    public void addOr(int lamoney) throws LimiteAtteinteException {
        if (or+lamoney > maxOr)throw new LimiteAtteinteException();
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
        if (solaire+sola > maxSolaire)throw new LimiteAtteinteException();
        solaire += sola;
    }

    public void payerEnSolaire(int montant) throws ValeurNegatifException {
        if (solaire < montant) throw new ValeurNegatifException();
        solaire -= montant;
    }

    public void addPtVictoire(int ptVic) throws LimiteAtteinteException {
        ptVictoire += ptVic;
    }

    public int getOr() {
        return or;
    }
    
    public int getLunaire() {
        return lunaire;
    }

    public int getSolaire() {
        return solaire;
    }

    public int getPtVictoire() {
        return ptVictoire;
    }

    public int getNbExtension() {
        return nbExtension;
    }

    public int getMaxOr() {
        return maxOr;
    }

    public int getMaxLunaire() {
        return maxLunaire;
    }

    public int getMaxSolaire() {
        return maxSolaire;
    }
}
