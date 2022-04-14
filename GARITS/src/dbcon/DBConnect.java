package dbcon;

import java.sql.*;

import static java.sql.Connection.TRANSACTION_SERIALIZABLE;

/**
 * The main instance for the GARITS project to open a connection to the rdbms
 * @since 1
 * @see java.sql
 * @author dylantuckey
 */

public class DBConnect {
    static final private String DB = "jdbc:mariadb://localhost/GARITS";
    static final private String User = "dytu";
    static final private String PWord = "dytu";
    private Connection conDB = null;


    public DBConnect(){}

    /**
     * Opens a Connection to the rdbms
     * @see java.sql.Connection
     * @throws SQLException
     * @since 1
     */
    public Connection open() throws SQLException {
        /*
        conDB = DriverManager.getConnection(DB, User, PWord);
        System.out.println('1');
        try( Statement stmt = conDB.createStatement();
             ResultSet rs = stmt.executeQuery("Select * from Users");) {
            while(rs.next()){
                System.out.println(rs.getInt("id") + " " + rs.getString("role"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
         */
        try{
            conDB = DriverManager.getConnection(DB, User, PWord);
            conDB.setTransactionIsolation(TRANSACTION_SERIALIZABLE);
            System.out.println("connected");
        } catch(SQLException e){
            e.printStackTrace();
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
