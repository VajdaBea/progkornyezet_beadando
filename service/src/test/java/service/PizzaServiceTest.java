package service;

import exceptions.IlyenFelhasznaloMarVan;
import exceptions.InvalidOsszeg;
import exceptions.SikertelenFizetes;
import extensibility.IPizza_DeliveryDAO;
import model.Rendeles;
import model.Vevo;
import org.junit.Test;
import org.mockito.Mockito;

import org.junit.Before;

import java.time.LocalDate;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;
import static org.mockito.Matchers.any;

public class PizzaServiceTest {
    PizzaService service;
    IPizza_DeliveryDAO dao = Mockito.mock(IPizza_DeliveryDAO.class);
    Vevo vevo;

    @Before
    public void setUp() throws Exception, IlyenFelhasznaloMarVan {
        service = new PizzaService(dao);
        vevo = new Vevo(123, "J utca 12", "+3612365987", "Kiss Anna");
        Mockito.when(dao.getVevoById(vevo.getId())).thenReturn(vevo);
    }

    @Test
    public void testServiceCallsDao() throws IlyenFelhasznaloMarVan {
        Mockito.when(dao.getLastVevoId()).thenReturn(2);
        service.vevoRegisztralas("Elek", "Elek utca 5", "1365742");
        Mockito.verify(dao, Mockito.times(1)).addVevo(any());
    }

    @Test(expected = SikertelenFizetes.class)
    public void testNoDoublePayments() throws SikertelenFizetes, InvalidOsszeg {
        int rendelesId = 2;
        Rendeles rendeles = new Rendeles(rendelesId, vevo, LocalDate.now(), 5600, false, true);
        Mockito.when(dao.getRendelesById(rendelesId)).thenReturn(rendeles);
        service.rendelesKifizet(rendelesId);
    }

    @Test
    public void testRendelesAtadva() throws InvalidOsszeg {
        int rendelesId = 2;
        Rendeles rendeles = new Rendeles(rendelesId, vevo, LocalDate.now(), 5600, false, true);
        Mockito.when(dao.getRendelesById(rendelesId)).thenReturn(rendeles);
        boolean rendelesAtadva = service.rendelesAtadas(rendelesId);
        assertTrue(rendelesAtadva);
    }

    @Test
    public void testgetVevoByTelefonszam() {
        Mockito.when(dao.getVevoByTelefonszam(vevo.getTelefonSzam())).thenReturn(vevo);
        assertEquals(vevo, service.getVevoByTelefonszam("+3612365987"));
    }
}
