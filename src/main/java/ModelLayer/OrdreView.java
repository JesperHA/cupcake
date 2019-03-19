package ModelLayer;

public class OrdreView {
    int kunde_id;
    int ordre_id;
    String dato;
    int ialt;

    public OrdreView(int kunde_id, int ordre_id, String dato, int ialt) {
        this.kunde_id = kunde_id;
        this.ordre_id = ordre_id;
        this.dato = dato;
        this.ialt = ialt;
    }

    public int getKunde_id() {
        return kunde_id;
    }

    public int getOrdre_id() {
        return ordre_id;
    }

    public String getDato() {
        return dato;
    }

    public int getIalt() {
        return ialt;
    }
}
