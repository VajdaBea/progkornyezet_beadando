package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RendeltTetelTest {

    Pizza pizza;
    Feltet feltet1;
    Feltet feltet2;

@Before
    public void SetUp(){
    pizza = new Pizza("pizza15", PizzaMeret.nagy_45, 2000);
    feltet1 = new Feltet("paradicsom", 150);
    feltet2 = new Feltet("kukorica", 50);
}

@Test
    public void getPizzaTest(){
    assertEquals();


}
@Test
    public void getFeltetTest(){

}

}
