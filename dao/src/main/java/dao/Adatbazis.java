package dao;

import model.Feltet;
import model.Pizza;
import model.Rendeles;
import model.Vevo;

import java.util.ArrayList;

public final class Adatbazis {
    public ArrayList<Vevo> vevok;
    public ArrayList<Pizza> pizzak;
    public ArrayList<Rendeles> rendelesek;
    public ArrayList<Feltet> feltetek;

    private static Adatbazis adatbazis;

    private Adatbazis() {
        this.vevok = new ArrayList<Vevo>();
        this.pizzak = new ArrayList<Pizza>();
        this.rendelesek=new ArrayList<Rendeles>();
        this.feltetek=new ArrayList<Feltet>();
    }

    public static Adatbazis getAdatbazis() {
        if (adatbazis == null) {
            adatbazis = new Adatbazis();
        }
        return adatbazis;
    }
}
