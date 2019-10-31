package Model;

import Exceptions.ValeurNegatifException;
import Exceptions.ValeurTropGrandeException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class FaceUnitTest {

    @Test
    public void testGetCouleurFace() throws Exception{
        Face f = new Face(0,Color.OR);
        Assert.assertTrue(f.getColor() == Color.OR);
    }

    @Test
    public void testGetValeur()throws Exception{
        Face f = new Face(6,Color.SOLAIRE);
        Assert.assertTrue(f.getValeur() == 6);
    }

    @Test(expected = ValeurTropGrandeException.class)
    public void testValeurTropGrandeExeption()throws Exception{
        Face f = new Face(12,Color.LUNAIRE);
    }

    @Test(expected = ValeurNegatifException.class)
    public void testValeurNegatif()throws Exception{
        Face f = new Face(-5,Color.OR);
    }
}