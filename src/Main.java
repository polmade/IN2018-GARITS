import dbcon.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) throws SQLException {
        DBConnect db = new DBConnect();
        Connection newcon = db.open();
        SQLHelper sqlh = new SQLHelper(newcon);
        ResultSet newres = sqlh.getQuery("SELECT * FROM Users");
        while(newres.next()){
            System.out.println(newres.getInt("id") + " " + newres.getString("role"));
        }
        db.close();
    }
}
