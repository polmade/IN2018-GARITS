package inventory;

import dbcon.DBConnect;
import dbcon.SQLHelper;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class reports {
    SQLHelper help;

    public reports(DBConnect conn){
        try {
            help = new SQLHelper(conn.open());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ArrayList<String> reports = new ArrayList();
        //insert all relevant sql for report generation into the mapping ArrayList
        reports.add("SELECT part_name, part_code, manufacturer, vehicle_type, year, price, stock_level,\n" +
                "COUNT(Parts_Sale.SparePartspart_code) AS used,\n" +
                "COUNT(Purchase_Order.SparePartspart_code) AS delivery FROM SpareParts, Parts_Sale,\n" +
                "Purchase_Order;");
        reports.add("SELECT DATE_FORMAT(date_booked, '%c') AS MONTH, COUNT(*) AS NUMBER_BOOKED FROM Vehicle_Job GROUP BY date_booked;");
        reports.add("SELECT DATE_FORMAT(date_booked, '%c') AS MONTH, COUNT(*) AS NUMBER_BOOKED FROM Vehicle_Job GROUP BY date_booked;");
        reports.add("SELECT COUNT(*) FROM Vehicle_Job INNER JOIN Vehicle INNER JOIN Customer WHERE Customer.id = Vehicle.Customerid AND Customer.Customer_Accountaccount_id IS NULL;");
        reports.add("SELECT COUNT(*) FROM Vehicle_Job INNER JOIN Vehicle INNER JOIN Customer WHERE Customer.id = Vehicle.Customerid AND Customer.Customer_Accountaccount_id IS NOT NULL;");
        for(String a: reports){
            try {
                ResultSet rs = help.getQuery(a);
                //check if the resultset returned is null, if null print here else open a filewriter to write results to the relevant text file
                if(rs == null){
                    System.out.println("here");
                }
                else {
                    FileWriter myWriter = new FileWriter("/Volumes/DTuckey/GARITS-NEW/GARITS/data/reports.txt");
                    while(rs.next()){
                        myWriter.write(rs.getInt(1));
                    }

                    myWriter.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
