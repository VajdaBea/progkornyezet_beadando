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

    public void setId(int id) {
        this.id = id;
    }

    public String getCim() {
        return cim;
    }

    public void setCim(String cim) {
        this.cim = cim;
    }

    public String getTelefonSzam() {
        return telefonSzam;
    }

    public void setTelefonSzam(String telefonSzam) {
        this.telefonSzam = telefonSzam;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }




}
