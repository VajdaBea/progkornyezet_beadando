package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VevoTest {
    int id;
    String cim;
    String telefonSzam;
    String nev;
    Vevo vevo;

    @Before
    public void SetUp() {
        id = 1;
        cim = "1234 Budapest, Lovas utca 5";
        nev = "Nagy Endre";
        telefonSzam = "06301234567";
        vevo = new Vevo(id, cim, telefonSzam, nev);
    }

    @Test
    public void getIDTest() {
        assertEquals(id, vevo.getId());
    }

    @Test
    public void getCimTest() {
        assertEquals(cim, vevo.getCim());
    }

    @Test
    public void getTelefonszamTest() {
        assertEquals(telefonSzam, vevo.getTelefonSzam());
    }

    @Test
    public void getNevTest() {
        assertEquals(nev, vevo.getNev());
    }

}
