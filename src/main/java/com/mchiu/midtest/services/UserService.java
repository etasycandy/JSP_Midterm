package com.mchiu.midtest.services;

import com.mchiu.midtest.ConnectDB;
import com.mchiu.midtest.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    private String INSERT_SQL = "INSERT INTO users (firstName, lastName, email, password) VALUES (?,?,?,?);";
    private String SELECT_ALL_SQL = "SELECT * FROM users;";
    private String SELECT_BY_ID_SQL = "SELECT  * FROM users WHERE id=?";
    private String UPDATE_SQL = "UPDATE users SET firstName=? , lastName=?, email=?, password=? WHERE id=?;";
    private String DELETE_SQL = "DELETE FROM users WHERE id=?;";

    private Connection getConnection(){
        return new ConnectDB().getConnection();
    }

    public void createUser(User user) throws SQLException {
        Connection conn = this.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(INSERT_SQL);
        preparedStatement.setString(1, user.getFirstName());
        preparedStatement.setString(2, user.getLastName());
        preparedStatement.setString(3, user.getEmail());
        preparedStatement.setString(4, user.getPassword());

        System.out.println(preparedStatement);
        preparedStatement.executeUpdate();
    }

    public List<User> getUsers() throws SQLException {
        Connection conn  = this.getConnection();
        ArrayList<User> users = new ArrayList<>();

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(SELECT_ALL_SQL);

        while (rs.next())
        {
            int id = rs.getInt("id");
            String fistName = rs.getString("firstName");
            String lastName = rs.getString("lastName");
            String email = rs.getString("email");
            String password = rs.getString("password");

            users.add(new User(id, fistName, lastName, email, password));
        }

        st.close();
        return users;
    }

    public User getUserById(int userId) throws SQLException{
        User user = null;
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID_SQL);
        preparedStatement.setInt(1, userId);
        System.out.println(preparedStatement);

        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            String firstName = rs.getString("firstName");
            String lastName = rs.getString("lastName");
            String email = rs.getString("email");
            String password = rs.getString("password");

            user = new User(userId, firstName, lastName, email, password);
        }

        return user;
    }

    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdated = false;
        Connection conn = getConnection();
        PreparedStatement statement = conn.prepareStatement(UPDATE_SQL);

        statement.setString(1, user.getFirstName());
        statement.setString(2, user.getLastName());
        statement.setString(3, user.getEmail());
        statement.setString(4, user.getPassword());
        statement.setInt(5, user.getId());

        rowUpdated = statement.executeUpdate() > 0;

        return rowUpdated;
    }

    public boolean deleteUser(int userId) throws SQLException {
        boolean rowDeleted = false;
        Connection conn = getConnection();
        PreparedStatement statement = conn.prepareStatement(DELETE_SQL);

        statement.setInt(1, userId);

        rowDeleted = statement.executeUpdate() > 0;

        return rowDeleted;
    }
}
