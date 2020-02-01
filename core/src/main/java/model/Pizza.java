package model;

public class Pizza {
    private String nev;
    private PizzaMeret pizzaMeret;
    private int ar;

    public Pizza(String nev, PizzaMeret pizzaMeret, int ar) {

        this.nev = nev;
        this.pizzaMeret = pizzaMeret;
        this.ar = ar;
    }


    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public PizzaMeret getPizzaMeret() {
        return pizzaMeret;
    }

    public void setPizzaMeret(PizzaMeret pizzaMeret) {
        this.pizzaMeret = pizzaMeret;
    }

    public int getAr() {
        return ar;
    }

    public void setAr(int ar) {
        this.ar = ar;
    }


}
