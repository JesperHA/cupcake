package data;

import ModelLayer.Toppings;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TopMapper {
    public static ArrayList<Toppings> getToppingList(){

        ArrayList<Toppings> toppingList = new ArrayList<>();

        int idtoppings;
        String smag;
        int pris;

        Connection connection = null;
        Toppings topping = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        String sqlQuery = "SELECT idtoppings, smag, pris FROM toppings";

        try {
            connection = ConnectionConfiguration.getConnection();
            ps = connection.prepareStatement(sqlQuery);
            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                System.out.println("resultSet" + resultSet.getString("smag"));
                idtoppings = resultSet.getInt("idtoppings");
                smag = resultSet.getString("smag");
                pris = resultSet.getInt("pris");
                System.out.println("resultSet" + resultSet.getString("idtoppings"));
                System.out.println("resultSet" + resultSet.getString("smag"));
                System.out.println("resultSet" + resultSet.getString("pris"));

                topping = new Toppings(idtoppings, smag, pris);
                toppingList.add(topping);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return toppingList;

    }
}
