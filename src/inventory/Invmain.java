package inventory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import dbcon.*;


public class Invmain {
    private static List<String> sqlStatements = new ArrayList<String>();
    private static Map<String, Integer> spareParts;
    private Connection mainCon;
    SQLHelper invHelper;

    private void prepare(){
        sqlStatements.add("SELECT * FROM SpareParts");
    }


    public Invmain(Connection mainCon) throws SQLException {
        this.mainCon = mainCon;
        prepare();
        invHelper = new SQLHelper(mainCon);
        ResultSet invRes = invHelper.getQuery(sqlStatements.get(0));
        while(invRes.next()){
            System.out.println(invRes.getString(6));
        }
    }


}
