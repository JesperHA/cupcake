package ModelLayer;

public class Cart {

    int bottom = 0;
    int top = 0;
    int antal = 0;
    int pris = 0;

    public Cart(int bottom, int top, int antal, int pris) {
        this.bottom = bottom;
        this.top = top;
        this.antal = antal;
        this.pris = pris;
    }

    public int getBottom() {
        return bottom;
    }

    public int getTop() {
        return top;
    }

    public int getAntal() {
        return antal;
    }

    public int getPris() {
        return pris;
    }
}
