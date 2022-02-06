package service;

import dao.UserDAO;
import entity.User;

import java.util.List;

public class UserService {
    private final UserDAO userDAO;

    public UserService() {
        this.userDAO = new UserDAO();
    }

    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    public List<User> getUserByEmail(String email) {
        return userDAO.getUserByEmail(email);
    }

}
