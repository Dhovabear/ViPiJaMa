package Model;

import Exceptions.LimiteAtteinteException;
import Exceptions.ValeurNegatifException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class PlateauJoueurUnitTest {

    @Test
    public void testAddExtention(){
        PlateauJoueur plat = new PlateauJoueur();
        plat.addExtension();
        Assert.assertEquals(plat.getNbExtension(),1);
        Assert.assertEquals(plat.getMaxOr(),16);
        Assert.assertEquals(plat.getMaxLunaire(),10);
        Assert.assertEquals(plat.getMaxSolaire(),10);
    }

    @Rule
    public ExpectedException ecouteurDexception = ExpectedException.none();
    @Test
    public void testAddOr() throws Exception{
        PlateauJoueur plat = new PlateauJoueur();
        plat.addOr(5);
        Assert.assertEquals(plat.getOr(),5);
        ecouteurDexception.expect(LimiteAtteinteException.class);
        plat.addOr(9);
    }

    @Test
    public void testAddLunaire() throws Exception{
        PlateauJoueur plat = new PlateauJoueur();
        plat.addLunaire(5);
        Assert.assertEquals(plat.getLunaire(),5);
        ecouteurDexception.expect(LimiteAtteinteException.class);
        plat.addLunaire(9);
    }

    @Test
    public void testAddSolaire() throws Exception{
        PlateauJoueur plat = new PlateauJoueur();
        plat.addSolaire(5);
        Assert.assertEquals(plat.getSolaire(),5);
        ecouteurDexception.expect(LimiteAtteinteException.class);
        plat.addSolaire(9);
    }

    @Test
    public void testAddPtVictoire() throws Exception{
        PlateauJoueur plat = new PlateauJoueur();
        plat.addPtVictoire(15);
        Assert.assertEquals(plat.getPtVictoire(),15);
    }

    @Test
    public void testPayerEnOr() throws Exception{
        PlateauJoueur plat = new PlateauJoueur();
        plat.addOr(5);
        plat.payerEnOr(3);
        Assert.assertEquals(plat.getOr(),2);
        ecouteurDexception.expect(ValeurNegatifException.class);
        plat.payerEnOr(9);
    }

    @Test
    public void testPayerEnLunaire() throws Exception{
        PlateauJoueur plat = new PlateauJoueur();
        plat.addLunaire(5);
        plat.payerEnLunaire(3);
        Assert.assertEquals(plat.getLunaire(),2);
        ecouteurDexception.expect(ValeurNegatifException.class);
        plat.payerEnLunaire(9);
    }

    @Test
    public void testPayerEnSolaire() throws Exception{
        PlateauJoueur plat = new PlateauJoueur();
        plat.addSolaire(5);
        plat.payerEnSolaire(3);
        Assert.assertEquals(plat.getSolaire(),2);
        ecouteurDexception.expect(ValeurNegatifException.class);
        plat.payerEnSolaire(9);
    }
}
