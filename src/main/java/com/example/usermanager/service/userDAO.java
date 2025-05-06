package com.example.usermanager.service;

import com.example.usermanager.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class userDAO implements IUserDAO {
    private static final String INSERT_USERS_SQL = "INSERT INTO users (name, email, country) VALUES (?, ?, ?);";
    private static final String SELECT_USER_BY_ID = "select id,name,email,country from users where id =?;";
    private static final String SELECT_ALL_USERS = "select * from users;";
    private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
    private static final String UPDATE_USERS_SQL = "update users set name = ?,email= ?, country =? where id = ?;";
    private static final String SORT_BY_NAME = "select * from users where name ? order by name asc;";


//    Sử dụng stored Procedure
    private static final String GET_USER_BY_ID = "{call get_user_by_id(?)}";
    private static final String GET_USER_BY_NAME = "{call insert_user(?, ?, ?)}";
    public userDAO() {

    }

    @Override
    public void insertUser(User user) {
        System.out.println(INSERT_USERS_SQL);
        try (Connection connection = new DBConnection().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            DBConnection.printSQLException(e);
        }
    }


    @Override
    public User selectUser(int id) {
        User user = null;
        try (Connection connection = new DBConnection().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                user = new User(id, name, email, country);
            }
        } catch (SQLException e) {
            DBConnection.printSQLException(e);
        }
        return user;
    }

    @Override
    public List<User> selectAllUser() {
        List<User> users = new ArrayList<>();
        try (Connection connection = new DBConnection().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                users.add(new User(id, name, email, country));
            }
        } catch (SQLException e) {
            DBConnection.printSQLException(e);
        }
        return users;
    }

    @Override
    public boolean deleteUser(int id) {
        boolean rowDeleted = false;
        try (Connection connection = new DBConnection().getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            DBConnection.printSQLException(e);
        }
        return rowDeleted;
    }

    @Override
    public boolean updateUser(User user) {
        boolean rowUpdated = false;
        try (Connection connection = new DBConnection().getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getCountry());
            statement.setInt(4, user.getId());

            rowUpdated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            DBConnection.printSQLException(e);
        }
        return rowUpdated;
    }

    public List<User> SortByName() {
        List<User> users = new ArrayList<>();
        try (Connection connection = new DBConnection().getConnection();
             PreparedStatement ps = connection.prepareStatement(SORT_BY_NAME);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                users.add(new User(id, name, email, country));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    @Override
    public User getUserById(int id) {
        User user = null;
        try (Connection connection = new DBConnection().getConnection();
            CallableStatement callableStatement = connection.prepareCall(GET_USER_BY_ID)) {
            callableStatement.setInt(1, id);

            ResultSet rs = callableStatement.executeQuery();
            while(rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");

                user = new User(id, name, email, country);
            }
        } catch (SQLException e) {
            DBConnection.printSQLException(e);
        }
        return user;
    }

    @Override
    public void insertUserStore(User user) {
        try (Connection connection = new DBConnection().getConnection();
            CallableStatement callableStatement = connection.prepareCall(GET_USER_BY_NAME)) {
            callableStatement.setString(1, user.getName());
            callableStatement.setString(2, user.getEmail());
            callableStatement.setString(3, user.getCountry());
            System.out.println(callableStatement);
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            DBConnection.printSQLException(e);
        }
    }


}
