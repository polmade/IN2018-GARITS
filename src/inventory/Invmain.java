package inventory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import dbcon.*;

//TODO generate all sql queries that inventory might make
//TODO look at uml package for inv class, generate codefiles

/**
 * The main prep class for the inv package
 * @author dylantuckey
 * @see dbcon.DBConnect
 * @see java.util.Map
 * @since 1.2
 */

public class Invmain {

    protected static List<String> sqlStatements = new ArrayList<String>();
    protected static Map<String, Integer> spareParts = new HashMap<String, Integer>();
    protected static Connection mainCon;
    protected static SQLHelper invHelper = new SQLHelper();

    private void prepare(){
        sqlStatements.add("SELECT * FROM SpareParts");
    }

    protected SQLHelper getInvHelper(){
        return invHelper;
    }

    protected Connection getMainCon(){
        return mainCon;
    }

    public Invmain(Connection Con)  {
        mainCon = Con;
        prepare();
        try {
            updateSparePartsMap();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for(String k : spareParts.keySet()){
            System.out.print(k);
            System.out.println(spareParts.get(k));
        }
    }

    public void updateSparePartsMap() throws SQLException {
        invHelper.addConnection(mainCon);
        ResultSet invRes = invHelper.getQuery(sqlStatements.get(0));
        while(invRes.next()){
            spareParts.put(invRes.getString(1), invRes.getInt(7));
        }
    }

}
