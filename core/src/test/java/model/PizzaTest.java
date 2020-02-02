package model;

import org.junit.Before;
import org.junit.Test;
import junit.framework.TestCase;

public class PizzaTest {
    Pizza ujPizza;
    String nev;
    PizzaMeret pizzaMeret;
    int ar;

    @Before
    public void setUp(){
        nev = "Pizza2";
        pizzaMeret = PizzaMeret.kicsi_26;
        ar = 1200;
        ujPizza = new Pizza(nev,pizzaMeret,ar);
    }

    @Test
    public void getNevTest(){
        TestCase.assertEquals(nev, ujPizza.getNev());
    }

    @Test
    public void getArTest(){
        TestCase.assertEquals(ar, ujPizza.getAr());
    }

    @Test
    public void setNevTest(){
        String ujNev = "Pizza3";
        ujPizza.setNev(ujNev);

        TestCase.assertEquals(ujNev, ujPizza.getNev());
    }

    @Test
    public void setArTest(){
        int ujAr = 1250;
        ujPizza.setAr(ujAr);

        TestCase.assertEquals(ujAr, ujPizza.getAr());
    }

    @Test
    public void getPizzaMeretTest() {
        TestCase.assertEquals(pizzaMeret, ujPizza.getPizzaMeret());
    }

    @Test
    public void setPizzaMeretTest() {
        ujPizza.setPizzaMeret(PizzaMeret.nagy_45);
        TestCase.assertEquals(PizzaMeret.nagy_45, ujPizza.getPizzaMeret());
    }
}
