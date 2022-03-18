package dbcon;

import java.sql.*;

/**
 * The main instance for the GARITS project to open a connection to the rdbms
 * @since 1
 * @see java.sql
 * @author dylantuckey
 */

public class DBConnect {
    static final private String DB = "jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/adbs997";
    static final private String User = "adbs997";
    static final private String PWord = "";
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
