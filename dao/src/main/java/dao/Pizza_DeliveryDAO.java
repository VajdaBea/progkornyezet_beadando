package dao;

import exceptions.RendelesNemTorolheto;
import model.Feltet;
import model.Pizza;
import model.Rendeles;
import model.Vevo;

import java.util.ArrayList;
import org.apache.log4j.Logger;

public class Pizza_DeliveryDAO implements extensibility.IPizza_DeliveryDAO {

    private Logger logger = Logger.getLogger(Pizza_DeliveryDAO.class);

    private Adatbazis adatbazis;

    public Pizza_DeliveryDAO() {
        this.adatbazis = Adatbazis.getAdatbazis();
        logger.info("DAO initialized.");
    }

    public void addPizza(Pizza pizza) {
        adatbazis.pizzak.add(pizza);
    }

    public void addFeltet(Feltet feltet) {
        adatbazis.feltetek.add(feltet);
    }

    public void addVevo(Vevo vevo) {
        adatbazis.vevok.add(vevo);
    }

    public void addRendeles(Rendeles rendeles) {
        adatbazis.rendelesek.add(rendeles);
    }

    public void deletePizza(Pizza pizza) {
        adatbazis.pizzak.remove(pizza);
    }

    public void deleteFeltet(Feltet feltet) {
        adatbazis.feltetek.remove(feltet);
    }

    public void deleteVevo(Vevo vevo) {
        adatbazis.vevok.remove(vevo);
    }

    public void deleteRendeles(Rendeles rendeles) throws RendelesNemTorolheto {

        if (rendeles.isFizetve() == false) {
            adatbazis.rendelesek.remove(rendeles);
        } else {
            throw new RendelesNemTorolheto(rendeles);
        }
    }

    public ArrayList<Vevo> getAllVevok() {
        return adatbazis.vevok;
    }

    public Vevo getVevoByNev(String nev) {
        for (Vevo v : adatbazis.vevok) {
            if (v.getNev().equals(nev)) {
                return v;
            }
        }
        return null;
    }

    public Vevo getVevoById(int id) {
        for (Vevo v : adatbazis.vevok) {
            if (v.getId() == (id)) {
                return v;
            }
        }
        return null;
    }

    public Vevo getVevoByCim(String cim) {
        for (Vevo v : adatbazis.vevok) {
            if (v.getNev().contains(cim)) {
                return v;
            }
        }
        return null;
    }

    public Vevo getVevoByTelefonszam(String telefonszam) {
        for (Vevo v : adatbazis.vevok) {
            if (v.getNev().equals(telefonszam)) {
                return v;
            }
        }
        return null;
    }

    public Rendeles getRendelesById(int id) {

        for (Rendeles r : adatbazis.rendelesek) {
            if (r.getId() == id) {
                return r;
            }
        }
        return null;
    }

    public ArrayList<Rendeles> getAllRendeles() {
        return adatbazis.rendelesek;
    }

    public ArrayList<Pizza> getAllPizza() {
        return adatbazis.pizzak;
    }

    public int getLastVevoId() {
        if (adatbazis.vevok.size() != 0) {
            return adatbazis.vevok.get((adatbazis.vevok.size() - 1)).getId();
        } else {
            return 0;
        }
    }

    public int getLastRendelesId() {
        if (adatbazis.rendelesek.size() != 0) {
            return adatbazis.rendelesek.get((adatbazis.rendelesek.size() - 1)).getId();
        } else {
            return 0;
        }
    }
}
