package model;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class FeltetTest {
    Feltet f;
    String nev;
    int ar;

    @Before
    public void setUp()  {
        nev = "szalami";
        ar = 150;
        f = new Feltet(nev,ar);
    }

    @Test
    public void getNevTest(){
        TestCase.assertEquals(nev, f.getNev());
    }

    @Test
    public void getArTest(){
        TestCase.assertEquals(ar, f.getAr());
    }

    @Test
    public void setNevTest(){
        String ujNev = "Romlott szalami";
        f.setNev(ujNev);

        TestCase.assertEquals(ujNev, f.getNev());
    }

    @Test
    public void setArTest(){
        int ujAr = 100;
        f.setAr(ujAr);

        TestCase.assertEquals(ujAr, f.getAr());
    }
}
