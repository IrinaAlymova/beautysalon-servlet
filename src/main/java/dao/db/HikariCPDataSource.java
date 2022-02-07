package dao.db;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Class implements DataSource interface with pooled connections
 */
public class HikariCPDataSource {

    private static final HikariConfig config = new HikariConfig();
    private static final HikariDataSource ds;

    static {
        Properties properties = new Properties();
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        try(InputStream resourceStream = loader.getResourceAsStream("app.properties")) {
            properties.load(resourceStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        config.setDriverClassName(properties.getProperty("connection.driver"));
        config.setJdbcUrl(properties.getProperty("connection.url"));
        config.setUsername(properties.getProperty("connection.user"));
        config.setPassword(properties.getProperty("connection.password"));
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        ds = new HikariDataSource(config);
    }

    /**
     * @return connection from the connection pool
     */
    public static Connection getConnection() throws SQLException {
        //TODO: fix the connectivity issue
        return ds.getConnection();
    }

    private HikariCPDataSource(){}
}
