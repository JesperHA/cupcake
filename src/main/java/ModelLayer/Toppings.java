package ModelLayer;

public class Toppings {
    int idtoppings;
    String smag;
    int pris;

    public Toppings(int idtoppings, String smag, int pris) {
        this.idtoppings = idtoppings;
        this.smag = smag;
        this.pris = pris;
    }

    public int getIdtoppings() {
        return idtoppings;
    }

    public String getSmag() {
        return smag;
    }

    public int getPris() {
        return pris;
    }
}
