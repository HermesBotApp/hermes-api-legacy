package fr.blueberry.studio.hermes.api.data.sql;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.HashSet;

public class QueryHandler {
    private final Connection connection;

    public QueryHandler(Connection connection) {
        this.connection = connection;
    }

    /**
     * Execute an update with given data
     * @param query - The query to execute
     * @param data - The data of the query
     * @return - The result of the query
     * @throws SQLException - If something went wrong from Database
     */
    public ResultSet executeUpdate(String query, Object[] data) throws SQLException {
        final PreparedStatement statement = this.connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

        for(int i = 0; i < data.length; i++) {
            bindData(statement, i + 1, data[i]);
        }
        
        statement.executeUpdate();

        return statement.getGeneratedKeys();
    }

    /**
     * Construct and execute a batch for the same query
     * @param query - The query to batch
     * @param data - the data to bind
     * @return - The count holding the returned values
     * @throws SQLException - If something went wrong from Database
     */
    public int[] executeBatch(String query, Object[][] data) throws SQLException {
        final PreparedStatement statement = this.connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        int[] count;

        connection.setAutoCommit(false);

        for(int i = 0; i < data.length; i++) {
            for(int j = 0; j < data[i].length; j++) {
                bindData(statement, j + 1, data[i][j]);
            }
            
            statement.addBatch();
        }

        count = statement.executeBatch();
        connection.commit();
        connection.setAutoCommit(true);

        return count;
    }

    /**
     * Execute a query without binding data
     * @param query - The query to execute
     * @return - The result of the query
     * @throws SQLException - If something went wrong from Database
     */
    public ResultSet executeQuery(String query) throws SQLException {
        return executeQuery(query, null);
    }

    /**
     * Execute a query with given data
     * @param query - The query to execute
     * @param data - The data of the query
     * @return - The result of the query
     * @throws SQLException - If something went wrong from Database
     */
    public ResultSet executeQuery(String query, Object[] data) throws SQLException {
        final PreparedStatement statement = this.connection.prepareStatement(query);

        if(data != null) {
            for(int i = 0; i < data.length; i++) {
                bindData(statement, i + 1, data[i]);
            }
        }

        return statement.executeQuery();
    }

    /**
     * Execute a grouped sql commit
     * @param queries - The queries to perform
     * @throws SQLException - If something went wrong from Database 
     */
    public void executeCommit(String[] queries, Object[][] data) throws SQLException {
        final PreparedStatement[] preparedStatements = new PreparedStatement[queries.length];

        connection.setAutoCommit(false);

        for(int i = 0; i < queries.length; i++) {
            preparedStatements[i] = connection.prepareStatement(queries[i]);
        }

        for(int i = 0; i < preparedStatements.length; i++) {
            if(data != null) {
                for(int j = 0; j < data[i].length; j++) {
                    bindData(preparedStatements[i], j + 1, data[i][j]);
                }
            }
            preparedStatements[i].execute();
        }

        connection.commit();
        connection.setAutoCommit(true);
    }

    /**
     * Check for a table existences in database
     * @param table - The table to check
     * @return - True if a table is found in database
     * @throws SQLException - If something went wrong from Database 
     */
    public boolean tableExists(String table) throws SQLException {
        final ResultSet tables = this.executeQuery("SHOW TABLES");
        final HashSet<String> tablesName = new HashSet<>();

        while(tables.next()) {
            tablesName.add(tables.getString(1));
        }

        return tablesName.contains(table);
    }

    /**
     * Bind a sql data to a prepared statement with given index.
     * @param statement - The sql statement where to parse data
     * @param index - The index of the statement where to bind data
     * @param primitive - The primitive data to bind
     * @throws SQLException - If something went wrong from Database
     */
    private void bindData(PreparedStatement statement, int index, Object primitive) throws SQLException {
        if(primitive instanceof Integer) {
            statement.setInt(index, (Integer)primitive);
        } else if(primitive instanceof Long) {
            statement.setLong(index, (Long)primitive);
        } else if(primitive instanceof String) {
            statement.setString(index, (String)primitive);
        } else if(primitive instanceof Boolean) {
            statement.setBoolean(index, (Boolean)primitive);
        } else if(primitive instanceof Timestamp) {
            statement.setTimestamp(index, (Timestamp)primitive);
        } else if(primitive instanceof Byte) {
            statement.setByte(index, (Byte)primitive);
        } else if(primitive instanceof Date) {
            statement.setDate(index, (Date)primitive);
        } else if(primitive instanceof Double) {
            statement.setDouble(index, (Double)primitive);
        } else if(primitive instanceof Float) {
            statement.setFloat(index, (Float)primitive);
        } else if(primitive instanceof BigDecimal) {
            statement.setBigDecimal(index, (BigDecimal)primitive);
        } else if(primitive == null) {
            statement.setNull(index, Types.NULL);
        } else {
            statement.setObject(index, primitive);
        }
    }

    /**
     * Compact a list a query as argument in a java array.
     * @param query - The queries inlined as args.
     * @return - The queries in an array
     */
    public String[] compactQueries(String... query) {
        return query;
    }

    /**
     * Compact a list of data (Java objects) in a java array.
     * @param o - The data inlined as args in Java Object type.
     * @return - The data in an array.
     */
    public Object[] compactData(Object... o) {
        return o;
    }

    /**
     * Close the connection associated to this query handler
     * @throws SQLException - If something is wrong with SQL 
     */
    public void close() throws SQLException {
        if(this.connection != null) {
            this.connection.close();
        }
    }
}