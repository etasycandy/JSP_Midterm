package com.mchiu.midtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    public Connection getConnection(){
        Connection connection = null;
        try {
            String db_url = "jdbc:mysql://localhost:3306/midterm?useSSL=false";
            String username="root";
            String password = "lovemtp12";
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(db_url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return connection;
    }
}
