package com.mchiu.midtest.services;

import com.mchiu.midtest.ConnectDB;
import com.mchiu.midtest.model.User;

import java.sql.*;

public class AuthService {
    private Connection getConnection(){
        return new ConnectDB().getConnection();
    }
    private String LOGIN_SQL = "SELECT * FROM users WHERE email=? and password=?;";

    public User login(String email, String password) throws SQLException {
        User user = null;

        Connection conn = this.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(LOGIN_SQL);
        preparedStatement.setString(1, email);
        preparedStatement.setString(2, password);

        System.out.println(preparedStatement);
        ResultSet rs = preparedStatement.executeQuery();

        if(rs.next()) {
            int id = rs.getInt("id");
            String firstName = rs.getString("firstName");
            String lastName = rs.getString("lastName");

            user = new User(id, firstName, lastName, email, password);
        }

        return user;
    }
}
