package data;

import ModelLayer.Kunder;
import ModelLayer.Toppings;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class KundeMapper {
    public static ArrayList<Kunder> getKunderList() {

        ArrayList<Kunder> kunderList = new ArrayList<>();

        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        String sqlQuery = "SELECT * FROM kunder";

        try {
            connection = ConnectionConfiguration.getConnection();
            ps = connection.prepareStatement(sqlQuery);
            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                int kunde_id = resultSet.getInt("kunde_id");
                String navn = resultSet.getString("navn");
                String email = resultSet.getString("email");
                int password = resultSet.getInt("password");
                int saldo = resultSet.getInt("saldo");

                Kunder kunde = new Kunder(kunde_id, navn, email, password, saldo);
                kunderList.add(kunde);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return kunderList;

    }

    public static ArrayList<Kunder> getKunderListById(int id) {

        ArrayList<Kunder> kunderList = new ArrayList<>();

        int temp_id = id;

        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        String sqlQuery = "SELECT * FROM `cupcakes`.`kunder` WHERE (`kunde_id` = ?)";

        try {
            connection = ConnectionConfiguration.getConnection();
            ps = connection.prepareStatement(sqlQuery);
            ps.setInt(1, temp_id);
            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                int kunde_id = resultSet.getInt("kunde_id");
                String navn = resultSet.getString("navn");
                String email = resultSet.getString("email");
                int password = resultSet.getInt("password");
                int saldo = resultSet.getInt("saldo");

                Kunder kunde = new Kunder(kunde_id, navn, email, password, saldo);
                kunderList.add(kunde);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return kunderList;

    }
}
