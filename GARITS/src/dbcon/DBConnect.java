package dbcon;

import java.sql.*;

/**
 * The main instance for the GARITS project to open a connection to the rdbms
 * @since 1
 * @see java.sql
 * @author dylantuckey
 */

public class DBConnect {
    static final private String DB = "jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/adby464";
    static final private String User = "adby464";
    static final private String PWord = "180004355";
    private Connection conDB = null;

    public Connection open() {
        try{
            conDB = DriverManager.getConnection(DB, User, PWord);
            System.out.println("connected");
        } catch(SQLException e){
            e.printStackTrace();
            return null;
        }
        return conDB;
    }

    /**
     * Closes the connection to the rdbms
     * @see java.sql.Connection
     * @throws SQLException Closing a connection might throw an error
     * @since 1
     */
    public void close() throws SQLException {
        conDB.close();
    }

}
