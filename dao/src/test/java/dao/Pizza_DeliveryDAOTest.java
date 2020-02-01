package dao;

import model.Pizza;
import model.PizzaMeret;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class Pizza_DeliveryDAOTest {
Pizza_DeliveryDAO pizza_deliveryDAO;

    @Before
    public void setUp()  {
        pizza_deliveryDAO = new Pizza_DeliveryDAO();
    }

    @Test
    public void testPizzaAdded() {
        pizza_deliveryDAO.addPizza(new Pizza("Pizza1", PizzaMeret.kozepes_32, 256000));
        assertEquals(1, pizza_deliveryDAO.getAllPizza().size());
    }
}
