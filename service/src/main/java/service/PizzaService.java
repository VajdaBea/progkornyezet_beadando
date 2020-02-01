package service;

import exceptions.IlyenFelhasznaloMarVan;
import exceptions.InvalidOsszeg;
import exceptions.SikertelenFizetes;
import extensibility.IPizza_DeliveryDAO;
import model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Logger;

public class PizzaService {
    private IPizza_DeliveryDAO pizza_deliveryDAO;
    private Logger logger = Logger.getLogger(String.valueOf(this.getClass()));

    public PizzaService(IPizza_DeliveryDAO pizza_deliveryDAO) {
        this.pizza_deliveryDAO = pizza_deliveryDAO;
    }

    public void vevoRegisztralas(String nev, String cim, String telefonszam) throws IlyenFelhasznaloMarVan {
        if (pizza_deliveryDAO.getVevoByTelefonszam(telefonszam) != null) {
            throw new IlyenFelhasznaloMarVan(telefonszam);
        }
        Vevo v = new Vevo(pizza_deliveryDAO.getLastVevoId() + 1, cim, telefonszam, nev);
        pizza_deliveryDAO.addVevo(v);
        logger.info("Uj vevo hozzaadva: "+nev);
    }

    public ArrayList<Rendeles> vevoRendelesei(Vevo vevo) {
        ArrayList<Rendeles> vevoRendelesei = new ArrayList<Rendeles>();
        for (Rendeles r : pizza_deliveryDAO.getAllRendeles()) {
            if (r.getVevo().equals(vevo)) {
                vevoRendelesei.add(r);
            }
        }
        return vevoRendelesei;
    }

    public void ujPizza(String nev, PizzaMeret pizzaMeret, int ar) {
        pizza_deliveryDAO.addPizza(new Pizza(nev, pizzaMeret, ar));
    }

    public void ujFeltet(String nev, int ar) {
        pizza_deliveryDAO.addFeltet(new Feltet(nev, ar));
    }

    public void ujRendeles(Vevo vevo, ArrayList<RendeltTetel> rendeltTetelek) throws InvalidOsszeg {
        Rendeles r = new Rendeles(pizza_deliveryDAO.getLastRendelesId() + 1, vevo, LocalDate.now(), rendelesOsszegSzamitasa(rendeltTetelek), false, false);
        pizza_deliveryDAO.addRendeles(r);
    }

    private int rendelesOsszegSzamitasa(ArrayList<RendeltTetel> rendeltTetelek) {
        int osszeg = 0;
        for (RendeltTetel rt : rendeltTetelek) {
            osszeg += rt.getPizza().getAr()
                    + (rt.getFeltet1() != null ? rt.getFeltet1().getAr() : 0)
                    + (rt.getFeltet2() != null ? rt.getFeltet2().getAr() : 0);
        }
        return osszeg;
    }

    public boolean rendelesKifizet(int rendelesId) throws SikertelenFizetes {
        Rendeles foundRendeles = pizza_deliveryDAO.getRendelesById(rendelesId);
        if (foundRendeles == null) {
            throw new SikertelenFizetes("Nem talalhato rendeles!");
        }

        if (foundRendeles.isFizetve()) {
            throw new SikertelenFizetes("A rendeles mar korabban ki lett fizetve!");
        }

        foundRendeles.setFizetve(true);

        return true;
    }

    public boolean rendelesAtadas(int rendelesId) {
        Rendeles foundRendeles = pizza_deliveryDAO.getRendelesById(rendelesId);
        if (foundRendeles == null) {
            return false;
        }
        foundRendeles.setFutarnakAtadva(true);
        return true;
    }

    public Vevo getVevoByNev(String nev) {
        return pizza_deliveryDAO.getVevoByNev(nev);
    }

    public Vevo getVevoById(int id){
        return pizza_deliveryDAO.getVevoById(id);
    }

    public Vevo getVevoByCim(String cim){
        return pizza_deliveryDAO.getVevoByCim(cim);
    }
    public Vevo getVevoByTelefonszam(String telefonszam){
        return pizza_deliveryDAO.getVevoByTelefonszam(telefonszam);
    }

    public Rendeles getRendelesById(int id){
        return pizza_deliveryDAO.getRendelesById(id);
    }

}
