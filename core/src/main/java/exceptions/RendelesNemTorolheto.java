package exceptions;

import model.Rendeles;

public class RendelesNemTorolheto extends Throwable {
    public RendelesNemTorolheto(Rendeles rendeles){
        super("A rendeles nem torolheto, mert mar ki van fizetve");
    }
}
