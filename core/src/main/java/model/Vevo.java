package model;

public class Vevo {
    private int id;
    private String cim;
    private String telefonSzam;
    private String nev;

    public Vevo(int id, String cim, String telefonSzam, String nev) {
        this.id = id;
        this.cim = cim;
        this.telefonSzam = telefonSzam;
        this.nev = nev;
    }

    public int getId() {
        return id;
    }

    public String getCim() {
        return cim;
    }

    public String getTelefonSzam() {
        return telefonSzam;
    }

    public String getNev() {
        return nev;
    }

}
