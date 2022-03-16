import dbcon.*;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        DBConnect db = new DBConnect();
        Connection newcon = db.open();
        db.close();
    }
}
