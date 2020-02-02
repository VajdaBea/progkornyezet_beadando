package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RendeltTetelTest {

    Pizza pizza;
    Feltet feltet1;
    Feltet feltet2;
    RendeltTetel rendeltTetel;

    @Before
    public void SetUp() {
        pizza = new Pizza("pizza15", PizzaMeret.nagy_45, 2000);
        feltet1 = new Feltet("paradicsom", 150);
        feltet2 = new Feltet("kukorica", 50);
        rendeltTetel = new RendeltTetel(1, pizza, feltet1, feltet2);
    }

    @Test
    public void getPizzaTest() {
        assertEquals(pizza, rendeltTetel.getPizza());
    }

    @Test
    public void getFeltet1Test() {
        assertEquals(feltet1, rendeltTetel.getFeltet1());
    }

    @Test
    public void getFeltet2Test() {
        assertEquals(feltet2, rendeltTetel.getFeltet2());
    }
}
