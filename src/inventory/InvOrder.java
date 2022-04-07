package inventory;

//TODO add appropriate attributes


import dbcon.SQLHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.Math;

/**
 * intended to be the main class for handling new order
 * should be run when updating any table with spareparts, this will then generate an order for the required parts
 * @author dylantuckey
 * @since 1.2
 * @see Invmain
 */

public class InvOrder{
    SQLHelper newHelp = Invmain.invHelper;
    //String is part code, integer is how many of that part that need replacing
    private Map<String, Integer> partsUsed = new HashMap<>();
    private Map<String, Integer> partsToOrder = new HashMap<>();

    /**
     * The main function to prepare the class.
     * Contains prep function calls.
     * @see Invmain
     * @since 1.2
     */
    public InvOrder(){

        try {
            updateUsedPartsMap();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for(String k : partsUsed.keySet()){
            System.out.print("h");
            System.out.println(partsUsed.get(k));
        }
        generatePartsToOrder();
        for(String k : partsToOrder.keySet()){
            System.out.print(k);
            System.out.println(partsToOrder.get(k));
        }
    }

    /**
     * Calculates how many parts are below their threshold level using the Invmain spareParts map and the partsUsed map
     * @since 1.2
     * @see Invmain
     */
    public void generatePartsToOrder(){
        //TODO change the db associated with orders
        for(String k : partsUsed.keySet()){
            int noToOrder = Invmain.spareParts.get(k) - partsUsed.get(k);
            if(noToOrder < 0){
                partsToOrder.put(k, Math.abs(noToOrder));
            }
        }
    }

    //TODO change db schema

    /**
     * Populates the partsUsed hashmap, using jdbc connection
     * @since 1.2
     * @throws SQLException
     */
    public void updateUsedPartsMap() throws SQLException {
        newHelp.addConnection(Invmain.mainCon);
        ResultSet invRes = newHelp.getQuery(Invmain.sqlStatements.get(0));
        while(invRes.next()){
            partsUsed.put(invRes.getString(1), invRes.getInt(8));
        }
    }

    public void updateDB(String sql) throws SQLException{
        newHelp.addConnection(Invmain.mainCon);
        newHelp.updateDB(sql);
    }

    public void addToOrder(String id, int noToOrder){
        partsToOrder.put(id, noToOrder);
    }

    public Map<String, Integer> getPartsToOrder(){
        return partsToOrder;
    }

}

