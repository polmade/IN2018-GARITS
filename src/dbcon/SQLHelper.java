package dbcon;

import java.sql.*;

/**
 * Modular SQL Helper to allow easier queries from the database
 * @since 1.1
 * @author dylantuckey
 * @see java.sql
 */

public class SQLHelper {
    private Connection connect;
    private String sql;

    public SQLHelper(Connection connect){
        this.connect = connect;
    }

    public ResultSet getQuery(String sql) throws SQLException {
        Statement newStatement = connect.createStatement();
        return newStatement.executeQuery(sql);

    }

}
