package Model;

import Exceptions.ValeurNegatifException;
import Exceptions.ValeurTropGrandeException;

import java.util.Random;

public class Dice {

    private Face[] faces;

    public Dice(){
        faces = new Face[6];
    }

    public void ajouterFace(Face f) {
        for (int i = 0; i < faces.length; i++) {
            if(faces[i] == null){
                faces[i] = f;
                break;
            }
        }
    }

    public Face getFace(int i) throws ValeurNegatifException, ValeurTropGrandeException {
        if(i < 0)throw new ValeurNegatifException();
        if(i > faces.length-1)throw new ValeurTropGrandeException();
        return faces[i];
    }

    public void changerFace(int num, Face nface) {
        faces[num] = nface;
    }

    public Face roll(Random rng){
        return faces[rng.nextInt(6)];
    }
}
