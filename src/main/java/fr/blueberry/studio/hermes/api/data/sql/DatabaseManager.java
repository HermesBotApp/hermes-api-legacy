package fr.blueberry.studio.hermes.api.data.sql;

import java.sql.Connection;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 * 
 */
public interface DatabaseManager {
    /**
     * Create a connection pool with default configuration.
     * @param name - The name of the connection.
     * @param credentials - The credentials of the connection to authenticate to database.
     * @return - The HikariDataSource of the connection
     */
    HikariDataSource createConnectionPool(String name, DatabaseCredentials credentials);
    
    /**
     * Create a connection pool with custom configuration.
     * @param name - The name of the connection.
     * @param credentials - The credentials of the connection to authenticate to database.
     * @param config - The configuration of the database pool.
     * @return - The HikariDataSource of the connection
     */
    HikariDataSource createConnectionPool(String name, DatabaseCredentials credentials, HikariConfig config);

    /**
     * Close a connection silently
     * @param connection
     */
    void closeSilently(Connection connection);
}