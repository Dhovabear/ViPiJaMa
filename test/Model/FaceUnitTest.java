package Model;

import Exceptions.ValeurNegatifException;
import Exceptions.ValeurTropGrandeException;
import org.junit.Assert;
import org.junit.Test;

public class FaceUnitTest {

    @Test
    public void testGetCouleurFace() throws Exception{
        Face f = new Face(0,Color.Or);
        Assert.assertTrue(f.getColor() == Color.Or);
    }

    @Test
    public void testGetValeur()throws Exception{
        Face f = new Face(6,Color.Solaire);
        Assert.assertTrue(f.getValeur() == 6);
    }

    @Test(expected = ValeurTropGrandeException.class)
    public void testValeurTropGrandeExeption()throws Exception{
        Face f = new Face(12,Color.Lunaire);
    }

    @Test(expected = ValeurNegatifException.class)
    public void testValeurNegatif()throws Exception{
        Face f = new Face(-5,Color.Or);
    }
}