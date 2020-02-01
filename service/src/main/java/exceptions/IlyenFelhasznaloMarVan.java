package exceptions;

public class IlyenFelhasznaloMarVan extends Throwable {
    public IlyenFelhasznaloMarVan(String telefonSzam) {
        super("Ezzel a telefonszammal: " + telefonSzam + " mar letezik felhasznalo");
    }
}
