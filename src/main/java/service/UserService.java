package service;

import dao.UserDAO;
import entity.User;

import java.util.List;

public class UserService {

    public List<User> getAllUsers() {
        UserDAO userDAO = new UserDAO();
        return userDAO.getAllUsers();
    }

}
