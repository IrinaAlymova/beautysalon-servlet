package dao.db;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class HikariCPDataSource {

    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource ds;

    static {
        Properties properties = new Properties();
        try (FileReader reader = new FileReader("app.properties")){
            properties.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        config.setJdbcUrl(properties.getProperty("connection.url"));
        config.setUsername(properties.getProperty("connection.user"));
        config.setPassword(properties.getProperty("connection.password"));
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        ds = new HikariDataSource(config);
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    private HikariCPDataSource(){}

}
