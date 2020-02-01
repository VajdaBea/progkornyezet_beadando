package model;

public class RendeltTetel {

    private Pizza pizza;
    private Feltet feltet1;
    private Feltet feltet2;

    public RendeltTetel(int id, Pizza pizza, Feltet feltet1, Feltet feltet2) {
        this.pizza = pizza;
        this.feltet1 = feltet1;
        this.feltet2 = feltet2;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public Feltet getFeltet1() {
        return feltet1;
    }

    public Feltet getFeltet2() {
        return feltet2;
    }
}
