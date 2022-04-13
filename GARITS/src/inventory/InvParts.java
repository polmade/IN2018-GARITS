package inventory;

//TODO fill out with attributes
//TODO generate relevant sql

//|THIS SHOULD BE FILLED WITH INFO DURING SELECTION FROM THE GUI

import dbcon.DBConnect;
import dbcon.SQLHelper;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * intended to be the class to hold details about a new part for the db
 */
public class InvParts {
    private List<String[]> partsList = new ArrayList<>();
    SQLHelper sqlHelper = new SQLHelper();
    ResultSet partsRes;

    public InvParts(Connection con) throws SQLException {
        int count = 0;
        String[] tmpList = new String[8];
        sqlHelper.addConnection(con);
        partsRes = sqlHelper.getQuery("SELECT * FROM SpareParts");
        /*
        while(partsRes.next()){
            tmpList[0] = partsRes.getString(1);
            tmpList[1] = partsRes.getString(2);
            tmpList[2] = partsRes.getString(3);
            tmpList[3] = partsRes.getString(4);
            tmpList[4] = partsRes.getString(5);
            tmpList[5] = partsRes.getString(6);
            tmpList[6] = partsRes.getString(7);
            tmpList[7] = partsRes.getString(8);
            partsList.add(tmpList);
            count++;
        }

        while(partsRes.next()){
            System.out.println(partsRes.getString(1));
        }

         */
        for(String[] a: partsList){
            System.out.println(a[0]);
        }


    }

    public List<String[]> getPartsList() {
        return partsList;
    }

    public ResultSet getRS(){
        return partsRes;
    }
}
