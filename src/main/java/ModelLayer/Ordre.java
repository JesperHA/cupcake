package ModelLayer;

public class Ordre {
    int ordre_id;
    int kunde_id;
    String dato;
    int ialt;

    public Ordre(int ordre_id, int kunde_id, String dato, int ialt) {
        this.ordre_id = ordre_id;
        this.kunde_id = kunde_id;
        this.dato = dato;
        this.ialt = ialt;
    }

    public int getOrdre_id() {
        return ordre_id;
    }

    public int getKunde_id() {
        return kunde_id;
    }

    public String getDato() {
        return dato;
    }

    public int getIalt() {
        return ialt;
    }
}
