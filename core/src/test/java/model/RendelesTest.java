package model;

import exceptions.InvalidOsszeg;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class RendelesTest {
    int id;
    int osszeg;
    Vevo vevo;
    LocalDate rendelesIdeje;
    boolean futarnakAtadva;
    boolean fizetve;
    RendeltTetel tetel1;
    RendeltTetel tetel2;
    Rendeles rendeles;

    @Before
    public void SetUp() throws InvalidOsszeg {
        id=1;
        osszeg=3100;
        vevo = new Vevo(3,"Uj utca 2","+36305623214","Nagy Imre");
        rendelesIdeje = LocalDate.now();
        tetel1 = new RendeltTetel(11, new Pizza("Pizza12",PizzaMeret.kicsi_26,1200), new Feltet("szalami",50), new Feltet("sajt",100));
        tetel2 = new RendeltTetel(12,new Pizza("Pizza19", PizzaMeret.kozepes_32, 1500), new Feltet("kukorica",50), new Feltet("paradicsom", 200));
        rendeles = new Rendeles(id,vevo,rendelesIdeje,osszeg,false,false);
    }
    @Test
    public void getIdTest(){
        assertEquals(id, rendeles.getId());
    }

    @Test
    public void getVevoTest(){
        assertEquals(vevo, rendeles.getVevo());
    }

    @Test(expected = InvalidOsszeg.class)
    public void invalidOsszegTest() throws InvalidOsszeg{
        Rendeles rendeles2 = new Rendeles(id,vevo,rendelesIdeje,-80,true,true);
    }

    @Test
    public void getOsszegTest(){
        assertEquals(osszeg, rendeles.getOsszeg());
    }

    @Test
    public void isFutarnakAtadvaTest(){
        assertEquals(false, rendeles.isFutarnakAtadva());
    }

    @Test
    public void setFutarnakAtadvaTest(){
        rendeles.setFutarnakAtadva(true);
        assertEquals(true, rendeles.isFutarnakAtadva());
    }

    @Test
    public void isFizetveTest(){
        assertFalse(rendeles.isFizetve());
    }

    @Test
    public void setFizetveTest(){
        rendeles.setFizetve(true);
        assertTrue(rendeles.isFizetve());
    }

    @Test
    public void getRendeltTetelekTest(){
        rendeles.getRendeltTetelek().add(tetel1);
        rendeles.getRendeltTetelek().add(tetel2);

        assertEquals(2, rendeles.getRendeltTetelek().size());
    }

    @Test
    public void getRendelesIdejeTest(){
        assertEquals(rendelesIdeje,rendeles.getRendelesIdeje());
    }
}
