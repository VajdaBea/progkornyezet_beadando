package extensibility;

import exceptions.RendelesNemTorolheto;
import model.Feltet;
import model.Pizza;
import model.Rendeles;
import model.Vevo;

import java.util.ArrayList;

public interface IPizza_DeliveryDAO {
    void addPizza(Pizza pizza);

    void addFeltet(Feltet feltet);

    void addVevo(Vevo vevo);

    void addRendeles(Rendeles rendeles);

    void deletePizza(Pizza pizza);

    void deleteFeltet(Feltet feltet);

    void deleteVevo(Vevo vevo);

    void deleteRendeles(Rendeles rendeles) throws RendelesNemTorolheto;

    ArrayList<Vevo> getAllVevok();

    Vevo getVevoByNev(String nev);

    Vevo getVevoById(int id);

    Vevo getVevoByCim(String cim);

    Vevo getVevoByTelefonszam(String telefonszam);

    Rendeles getRendelesById(int id);

    ArrayList<Rendeles> getAllRendeles();

    ArrayList<Pizza> getAllPizza();

    int getLastVevoId();
    int getLastRendelesId();
}
