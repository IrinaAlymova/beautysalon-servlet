package dao.sql;

public class DBConnectionSQL {
    /**
     * SQL requests for User DAO
     */
    public static final String SELECT_ALL_USERS = "SELECT * FROM user JOIN role ON user.role_id = role.id";
    public static final String INSERT_USER = "INSERT INTO user (id, name, email, password, role_id, created) VALUES (DEFAULT, ?, ?, ?, 1, DEFAULT)";
    public static final String GET_USER = "SELECT * FROM user WHERE email = ?";
    public static final String DELETE_USER = "DELETE FROM users WHERE user.email = ?";
    public static final String SET_ROLE_FOR_USER = "UPDATE user SET role_id ? WHERE user.email = ?";
    public static final String GET_ROLE_FOR_USER = "SELECT role.name FROM user JOIN role ON user.role_id = role.id WHERE user.email = ?";
    public static final String GET_ROLE_ID_BY_NAME = "SELECT id FROM role WHERE role_name = ?";
}
