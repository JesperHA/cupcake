package data;

import ModelLayer.*;

import java.sql.*;
import java.util.ArrayList;


public class OrdreViewMapper {

public static ArrayList<OrdreView> getOrdreViewList(int id){

    ArrayList<OrdreView> ordreViewList = new ArrayList<>();

    int tempId = id;
    int kunde_id;
    int ordre_id;
    String dato;
    int ialt;

    Connection connection = null;
    PreparedStatement ps = null;
    ResultSet resultSet = null;
    String sqlQuery = "SELECT * FROM cupcakes.ordre_view WHERE kunde_id = ?";

    try {
        connection = ConnectionConfiguration.getConnection();
        ps = connection.prepareStatement(sqlQuery);
        ps.setInt(1, tempId);
        resultSet = ps.executeQuery();

        while (resultSet.next()) {

            kunde_id = resultSet.getInt("kunde_id");
            ordre_id = resultSet.getInt("ordre_id");
            dato = resultSet.getString("dato");
            ialt = resultSet.getInt("ialt");


            OrdreView ordreView = new OrdreView(kunde_id, ordre_id, dato, ialt);
            ordreViewList.add(ordreView);

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





    return ordreViewList;
}
    public static ArrayList<OrdreView> getOrdreViewListByOrdre(int id){

        ArrayList<OrdreView> ordreViewList = new ArrayList<>();

        int tempId = id;
        int kunde_id;
        int ordre_id;
        String dato;
        int ialt;

        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        String sqlQuery = "SELECT * FROM cupcakes.ordre_view WHERE ordre_id = ?";

        try {
            connection = ConnectionConfiguration.getConnection();
            ps = connection.prepareStatement(sqlQuery);
            ps.setInt(1, tempId);
            resultSet = ps.executeQuery();

            while (resultSet.next()) {

                kunde_id = resultSet.getInt("kunde_id");
                ordre_id = resultSet.getInt("ordre_id");
                dato = resultSet.getString("dato");
                ialt = resultSet.getInt("ialt");


                OrdreView ordreView = new OrdreView(kunde_id, ordre_id, dato, ialt);
                ordreViewList.add(ordreView);

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





        return ordreViewList;
    }

}
