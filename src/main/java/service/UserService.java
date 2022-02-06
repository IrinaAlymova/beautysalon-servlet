package service;

import dao.UserDAO;
import dto.UserDTO;
import entity.User;

import java.util.List;

public class UserService {
    private final UserDAO userDAO;

    public UserService() {
        this.userDAO = new UserDAO();
    }

    public boolean saveUser(UserDTO userDTO) {
        UserDAO userDAO = new UserDAO();
        User user = User.newBuilder()
                .setName(userDTO.getName())
                .setEmail(userDTO.getEmail())
                .setPassword(userDTO.getPassword())
                .setRole(User.Role.USER)
                .build();
        return userDAO.insertUser(user);
    }

    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    public List<User> getUserByEmail(String email) {
        return userDAO.getUserByEmail(email);
    }

}
