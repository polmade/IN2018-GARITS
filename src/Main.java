import dbcon.*;
import gui.orderForm;
import gui.viewOrders;
import inventory.InvOrder;
import inventory.Invmain;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        DBConnect db = new DBConnect();
        Connection newcon = db.open();
        SQLHelper sqlh = new SQLHelper(newcon);
       /* ResultSet newres = sqlh.getQuery("SELECT * FROM Users");
        while(newres.next()){
            System.out.println(newres.getInt("id") + " " + newres.getString("role"));
        }

        */
        Invmain newMain = new Invmain(newcon);
        InvOrder newo = new InvOrder();


        JFrame frame = new JFrame("Order");
        frame.setContentPane(new viewOrders(newcon).orderView);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        //db.close();
    }
}
