package model;

import exceptions.InvalidOsszeg;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Rendeles {

    private int id;
    private Vevo vevo;
    private LocalDate rendelesIdeje;
    private int osszeg;
    private boolean futarnakAtadva;
    private boolean fizetve;
    private ArrayList<RendeltTetel> rendeltTetelek;

    public Rendeles(int id, Vevo vevo, LocalDate rendelesIdeje, int osszeg, boolean futarnakAtadva, boolean fizetve)  throws InvalidOsszeg{
        this.id = id;
        this.vevo = vevo;
        this.rendelesIdeje = rendelesIdeje;
        this.setOsszeg(osszeg);
        this.futarnakAtadva = futarnakAtadva;
        this.fizetve = fizetve;
        this.rendeltTetelek = new ArrayList<RendeltTetel>() ;
    }

    public int getId() {
        return id;
    }

    public Vevo getVevo() {
        return vevo;
    }

    public LocalDate getRendelesIdeje() {
        return rendelesIdeje;
    }

    public int getOsszeg() {
        return osszeg;
    }

    public boolean isFutarnakAtadva() {
        return futarnakAtadva;
    }

    public boolean isFizetve() {
        return fizetve;
    }

    public List<RendeltTetel> getRendeltTetelek() {
        return rendeltTetelek;
    }

    private void setOsszeg(int osszeg) throws InvalidOsszeg {
        if (osszeg >= 0) {
            this.osszeg = osszeg;
        }
        else {
            throw new InvalidOsszeg(osszeg);
        }
    }

    public void setFutarnakAtadva(boolean futarnakAtadva) {
        this.futarnakAtadva = futarnakAtadva;
    }

    public void setFizetve(boolean fizetve) {
        this.fizetve = fizetve;
    }
}
