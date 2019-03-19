package ModelLayer;

public class Login {

    int kunde_id;
    String navn;
    String email;
    String password;
    int saldo;

    public Login(int kunde_id, String navn, String email, String password, int saldo) {
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

    public String getPassword() {
        return password;
    }

    public int getSaldo() {
        return saldo;
    }

}

















//
//    public boolean loggedIn = false;
//
//    public boolean login(boolean l) {
////        boolean isLoggedIn = false;
//
//        if(l == true){
//            loggedIn = true;
//        }else{
//            loggedIn = false;
//        }
//
//
//
//        return loggedIn;
//    }
//
//    public boolean isLoggedIn() {
//        return loggedIn;
//    }
//
//    public void setLoggedIn(boolean loggedIn) {
//        if (loggedIn) this.loggedIn = true;
//        else {
//            this.loggedIn = false;
//        }
//    }
//}
