package dao;

import dao.db.DBManager;
import entity.User;
import static dao.sql.DBConnectionSQL.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * User DAO
 */
public class UserDAO {

    /**
     * @return list consisting of one User object corresponding to the email passed as a parameter,
     * or an empty List if no such user found
     */
    public List<User> getUserByEmail(String email) {
        List<User> userList = new ArrayList<>();
        try (Connection connection = DBManager.getDBConnection();
             PreparedStatement statement = connection.prepareStatement(GET_USER)) {
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            User user = mapUser(resultSet);
            userList.add(user);
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }


    /**
     * Adds new user to a database, updates "id" and "created" fields for current User object
     * @return true if the user was successfully added, or false if such user already exists in a database
     */
    public boolean insertUser(User user) {
        List<User> userInDb = getUserByEmail(user.getEmail());
        if (userInDb.size() > 0) {
            return false;
        }
        try (Connection connection = DBManager.getDBConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_USER, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getRole().name());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                user.setId(resultSet.getInt(1));
                user.setCreated(resultSet.getTimestamp("created").toLocalDateTime());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * Deletes the user passed as a parameter from the database
     * @return true if the user was deleted, or false if there was no such user in a database
     */
    public boolean deleteUsers(User user) {
        int rowsAffected = 0;
        try (Connection connection = DBManager.getDBConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_USER)) {
            statement.setString(1, user.getEmail());
            rowsAffected = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsAffected > 0;
    }

    /**
     * Sets the specified role to the specified user, admin feature
     */
    public boolean setRoleForUser(User user, User.Role role) {
        long roleId = 0;
        int rowsAffected = 0;
        try (Connection connection = DBManager.getDBConnection();
             PreparedStatement statement = connection.prepareStatement(SET_ROLE_FOR_USER)) {
            roleId = getRoleIdByName(role.name());
            statement.setLong(1, roleId);
            statement.setString(2, user.getEmail());
            rowsAffected = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (roleId != 0 && rowsAffected != 0);
    }

    /**
     * @return the list consisting on one Role object corresponding to the user passed as a parameter,
     * or an empty list if no such user was found
     */
    public List<User.Role> getRoleForUser(User user) {
        List<User.Role> result = new ArrayList<>();
        try (Connection connection = DBManager.getDBConnection();
             PreparedStatement statement = connection.prepareStatement(GET_ROLE_FOR_USER)) {
            statement.setString(1, user.getEmail());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                result.add(User.Role.valueOf(resultSet.getString("role_name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * @return list of all users in database or an empty list if no users found
     */
    public List<User> getAllUsers() {
        List<User> allUsers = new ArrayList<>();
        try (Connection connection = DBManager.getDBConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_USERS)){
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User user = mapUser(resultSet);
                allUsers.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allUsers;
    }

    /**
     * @return role id by its name, or 0 if no such role found
     */
    public long getRoleIdByName(String name) {
        try (Connection connection = DBManager.getDBConnection();
             PreparedStatement statement = connection.prepareStatement(GET_ROLE_ID_BY_NAME)) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getLong("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * Maps current resultSet line into a User object
     */
    private User mapUser(ResultSet resultSet) {
        try {
            return User.newBuilder()
                    .setId(resultSet.getLong("id"))
                    .setName(resultSet.getString("name"))
                    .setEmail(resultSet.getString("email"))
                    .setPassword(resultSet.getString("password"))
                    .setRole(User.Role.valueOf(resultSet.getString("role_name")))
                    .setCreated(resultSet.getTimestamp("created").toLocalDateTime())
                    .build();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
