package dbcon;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;

/**
 * The main instance for the GAITS project to open a connection to the rdbms
 *
 * @author dylantuckey
 */

public class DBConnect {
    static final String DB = "jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/adbs997";
    static final String User = "adbs997";
    static final String PWord = "";

    public DBConnect(){}

    public void open(){
        System.out.println('1');
        try( Connection conn = DriverManager.getConnection(DB, User, PWord);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("Select * from Users");) {
            System.out.println("connection successful");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
