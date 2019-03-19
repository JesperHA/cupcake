package ModelLayer;

public class Ordrelinie {
    int ordrelinie_id;
    int ordre_id;
    int bottom_id;
    int topping_id;
    int antal;
    int pris;

    public Ordrelinie(int ordrelinie_id, int ordre_id, int bottom_id, int topping_id, int antal, int pris) {
        this.ordrelinie_id = ordrelinie_id;
        this.ordre_id = ordre_id;
        this.bottom_id = bottom_id;
        this.topping_id = topping_id;
        this.antal = antal;
        this.pris = pris;
    }

    public int getOrdrelinie_id() {
        return ordrelinie_id;
    }

    public int getOrdre_id() {
        return ordre_id;
    }

    public int getBottom_id() {
        return bottom_id;
    }

    public int getTopping_id() {
        return topping_id;
    }

    public int getAntal() {
        return antal;
    }

    public int getPris() {
        return pris;
    }
}
