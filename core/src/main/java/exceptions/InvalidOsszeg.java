package exceptions;

public class InvalidOsszeg extends Throwable  {
    public InvalidOsszeg(int osszeg) {
        super("Nem megfelelo az adott osszeg: " +osszeg);
    }
}
