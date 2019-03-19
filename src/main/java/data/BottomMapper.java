package data;

import ModelLayer.Bottom;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BottomMapper {
    public static ArrayList<Bottom> getBottomList(){

        ArrayList<Bottom> bottomList = new ArrayList<>();

        int idbottom;
        String smag;
        int pris;

        Connection connection = null;
        Bottom bund = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        String sqlQuery = "SELECT idbottom, smag, pris FROM bottom";

        try {
            connection = ConnectionConfiguration.getConnection();
            ps = connection.prepareStatement(sqlQuery);
            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                System.out.println("resultSet" + resultSet.getString("smag"));
                idbottom = resultSet.getInt("idbottom");
                smag = resultSet.getString("smag");
                pris = resultSet.getInt("pris");
                System.out.println("resultSet" + resultSet.getString("idbottom"));
                System.out.println("resultSet" + resultSet.getString("smag"));
                System.out.println("resultSet" + resultSet.getString("pris"));

                bund = new Bottom(idbottom, smag, pris);
                bottomList.add(bund);

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
        return bottomList;

    }
}
