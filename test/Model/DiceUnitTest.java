package Model;

import Exceptions.ValeurNegatifException;
import Exceptions.ValeurTropGrandeException;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class DiceUnitTest {

    @Test
    public void testAjouterFace()throws Exception{
        Dice d = new Dice();
        Face f = Mockito.mock(Face.class);
        d.ajouterFace(f);
        Assert.assertEquals(d.getFace(0) , f);
    }

    @Test(expected = ValeurNegatifException.class)
    public void testGetFaceEnDesousDe0()throws Exception{
        Dice d = new Dice();
        d.getFace(-1);
    }

    @Test(expected = ValeurTropGrandeException.class)
    public void testGetFaceAvecValeurTropGrande()throws Exception{
        Dice d = new Dice();
        d.getFace(42);
    }

    @Test
    public void testChangerFace()throws Exception{
        Dice d = new Dice();
        Face f1 = Mockito.mock(Face.class);
        Face f2 = Mockito.mock(Face.class);
        d.ajouterFace(f1);
        d.changerFace(0,f2);
        Assert.assertEquals(f2,d.getFace(0));
    }
}