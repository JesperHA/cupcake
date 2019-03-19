package data;


import ModelLayer.Ordrelinie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrdrelinieMapper {

    public static void indsætOrdrelinie(Ordrelinie o){

        Connection connection = null;
        PreparedStatement ps = null;
        String sqlQuery = "INSERT INTO `cupcakes`.`ordrelinie` (`ordre_id`, `bottom_id`, `topping_id`, `antal`, `pris`) VALUES (?, ?, ?, ?, ?);";

        try {
            connection = ConnectionConfiguration.getConnection();
            ps = connection.prepareStatement(sqlQuery);


            ps.setInt(1, o.getOrdre_id());
            ps.setInt(2, o.getBottom_id());
            ps.setInt(3, o.getTopping_id());
            ps.setInt(4, o.getAntal());
            ps.setInt(5, o.getPris());
            ps.executeUpdate();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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
    }

    public static ArrayList<Ordrelinie> getOrdrelinieList(int id){

        ArrayList<Ordrelinie> ordrelinieList = new ArrayList<>();

        int ordrenummer = id;
        int ordrelinie_id;
        int ordre_id;
        int bottom_id;
        int topping_id;
        int antal;
        int pris;


        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        String sqlQuery = "SELECT * FROM cupcakes.ordrelinie WHERE ordre_id = ?";

        try {
            connection = ConnectionConfiguration.getConnection();
            ps = connection.prepareStatement(sqlQuery);
            ps.setInt(1, ordrenummer);
            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                ordrelinie_id = resultSet.getInt("ordrelinie_id");
                ordre_id = resultSet.getInt("ordre_id");
                bottom_id = resultSet.getInt("bottom_id");
                topping_id = resultSet.getInt("topping_id");
                antal = resultSet.getInt("antal");
                pris = resultSet.getInt("pris");


                Ordrelinie ordrelinie = new Ordrelinie(ordrelinie_id, ordre_id, bottom_id, topping_id, antal, pris);
                ordrelinieList.add(ordrelinie);

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
        return ordrelinieList;

    }



    public static void updateOrdrelinie(int ordre_id, int ordrelinie_id){


        Connection connection = null;
        PreparedStatement ps = null;
        String sqlQuery = "UPDATE `cupcakes`.`ordrelinie` SET `ordre_id` = ? WHERE `ordrelinie_id` = ?";

        try {
            connection = ConnectionConfiguration.getConnection();
            ps = connection.prepareStatement(sqlQuery);


            ps.setInt(1, ordre_id);
            ps.setInt(2, ordrelinie_id);

            ps.executeUpdate();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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

    }

}
