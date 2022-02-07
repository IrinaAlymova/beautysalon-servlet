package dao.sql;

public class DBConnectionSQL {
    /**
     * SQL requests for User DAO
     */
    public static final String SELECT_ALL_USERS = "SELECT user.id as user_id, user.name as user_name, email, password, created, " +
            "role_id as role_id, role.name as role_name FROM user LEFT JOIN role ON user.role_id = role.id";
    public static final String INSERT_USER = "INSERT INTO user (id, name, email, password, role_id, created) VALUES (DEFAULT, ?, ?, ?, ?, DEFAULT)";
    public static final String GET_USER = "SELECT user.id as user_id, user.name as user_name, email, password, created, " +
            "role_id as role_id, role.name as role_name FROM user LEFT JOIN role ON user.role_id = role.id WHERE email = ?";
    public static final String DELETE_USER = "DELETE FROM users WHERE user.email = ?";
    public static final String SET_ROLE_FOR_USER = "UPDATE user SET role_id ? WHERE user.email = ?";
    public static final String GET_ROLE_FOR_USER = "SELECT role.name as role_name FROM user JOIN role ON user.role_id = role.id WHERE user.email = ?";
    public static final String GET_ROLE_ID_BY_NAME = "SELECT id FROM role WHERE name = ?";

    /**
     * SQL requests for Service DAO
     */
    public static final String SELECT_ALL_SERVICES = "SELECT * FROM service";
}
