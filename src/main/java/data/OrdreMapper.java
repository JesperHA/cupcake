package data;

import ModelLayer.Cart;
import ModelLayer.Kunder;
import ModelLayer.Ordre;
import ModelLayer.Ordrelinie;

import java.sql.*;
import java.util.ArrayList;

public class OrdreMapper {
    public static void indsætOrdre(Ordre o) {

        Connection connection = null;
        PreparedStatement ps = null;
        String sqlQuery = "INSERT INTO `cupcakes`.`ordre` (`kunde_id`, `dato`, `ialt`) VALUES (?, ?, ?);";

        try {
            connection = ConnectionConfiguration.getConnection();
            ps = connection.prepareStatement(sqlQuery);


            ps.setInt(1, o.getKunde_id());
            ps.setString(2, o.getDato());
            ps.setInt(3, o.getIalt());
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


    public static void indsætOrdreOgOrdrelinier(ArrayList<Cart> cart, int kunde_id, int saldo){


        int ialt = 0;
        for (Cart c: cart) {
            ialt = ialt + c.getPris();
        }


        int orderId = 0;
        long millis=System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);


        Connection connection = null;

        PreparedStatement ps = null;
        ResultSet resultSet = null;
        String sqlOrderQuery = "INSERT INTO `cupcakes`.`ordre` (`kunde_id`, `dato`, `ialt`) values (?,?,?);";

        try {
            connection = ConnectionConfiguration.getConnection();

            ps = connection.prepareStatement(sqlOrderQuery, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, kunde_id);
            ps.setDate(2, date);
            ps.setInt(3, ialt);
            ps.executeUpdate();
            resultSet = ps.getGeneratedKeys();

            if (resultSet.next()) {
                orderId = resultSet.getInt(1);
                String sqlOrderLineQuery = "INSERT INTO `cupcakes`.`ordrelinie` (`ordre_id`, `bottom_id`, `topping_id`, `antal`, `pris`) VALUES (?, ?, ?, ?, ?);";

                for (Cart c: cart) {
                    ps = connection.prepareStatement(sqlOrderLineQuery);
                    ps.setInt(1, orderId);
                    ps.setInt(2, c.getBottom());
                    ps.setInt(3, c.getTop());
                    ps.setInt(4, c.getAntal());
                    ps.setInt(5, c.getPris());
                    ps.executeUpdate();
                }

//                Opdater brugerens wallet

                String sqlCustomerQuery = "UPDATE `cupcakes`.`kunder` SET `saldo` = ? WHERE (`kunde_id` = ?)";
                ps = connection.prepareStatement(sqlCustomerQuery);
                ps.setInt(1, saldo - ialt);
                ps.setInt(2, kunde_id);
                ps.executeUpdate();
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

    }


    public static ArrayList<Ordre> getOrdreList () {

        ArrayList<Ordre> ordreList = new ArrayList<>();

        int ordre_id;
        int kunde_id;
        String dato;
        int ialt;


        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        String sqlQuery = "SELECT * FROM ordre";

        try {
            connection = ConnectionConfiguration.getConnection();
            ps = connection.prepareStatement(sqlQuery);
            resultSet = ps.executeQuery();

            while (resultSet.next()) {

                ordre_id = resultSet.getInt("ordre_id");
                kunde_id = resultSet.getInt("kunde_id");
                dato = resultSet.getString("dato");
                ialt = resultSet.getInt("ialt");


                Ordre ordre = new Ordre(ordre_id, kunde_id, dato, ialt);
                ordreList.add(ordre);

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



        return ordreList;


    }
}
