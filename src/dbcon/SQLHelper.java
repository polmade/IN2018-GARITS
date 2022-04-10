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

    public SQLHelper(){}

    public void addConnection(Connection connect) { this.connect = connect;}

    public ResultSet getQuery(String sql) throws SQLException {
        Statement newStatement = connect.createStatement();
        return newStatement.executeQuery(sql);
    }

    public void updateDB(String sql) throws SQLException {
        connect.setAutoCommit(false);
        System.out.println("In");
        Statement newStatement = connect.createStatement();
        System.out.println("Created Statement");
        newStatement.execute(sql);
        System.out.println("Executed");
        connect.commit();
        System.out.println("In commit");
    }



}
