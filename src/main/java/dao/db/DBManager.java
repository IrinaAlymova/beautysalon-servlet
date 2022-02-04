package dao.db;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBManager {
    private static final Properties properties = new Properties();
    private static final String DATABASE_URL;

    static {
        try (FileReader reader = new FileReader("app.properties")){
            properties.load(reader);
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        DATABASE_URL = properties.getProperty("connection.url");
    }
    private DBManager() {}

    public static Connection getDBConnection() throws SQLException {
        return DriverManager.getConnection(DATABASE_URL);
    }
}
