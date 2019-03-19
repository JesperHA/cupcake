package data;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionConfiguration {
    public static Connection getConnection(){

        Connection connection = null;

        String DB_Url = "jdbc:mysql://157.230.105.102:3306/cupcakes?serverTimezone=UTC";
        String DB_User = "stalin";
        String DB_Password = "1234";
        String DB_Connection_String = DB_Url + "?user=" + DB_User + "&password=" + DB_Password;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DB_Url, DB_User, DB_Password);
        } catch (Exception e){
            e.printStackTrace();
            System.out.println(DB_Connection_String);
        }
        return connection;
    }
}
