package ModelLayer;

public class Kunder {
    int kunde_id;
    String navn;
    String email;
    int password;
    int saldo;


    public Kunder(int kunde_id, String navn, String email, int password, int saldo) {
        this.kunde_id = kunde_id;
        this.navn = navn;
        this.email = email;
        this.password = password;
        this.saldo = saldo;
    }

    public int getKunde_id() {
        return kunde_id;
    }

    public String getNavn() {
        return navn;
    }

    public String getEmail() {
        return email;
    }

    public int getPassword() {
        return password;
    }

    public int getSaldo() {
        return saldo;
    }
}
