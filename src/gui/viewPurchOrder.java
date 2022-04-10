package gui;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class viewPurchOrder {
    public JPanel purchView;
    private JList list1;
    ResultSet rs;
    DefaultListModel<Object> listModel = new DefaultListModel<>();

    public viewPurchOrder(Connection con, String order_no){
        String sqlPurchOrder = "SELECT * FROM Purchase_Order WHERE Ordersorder_no = ?";
        try {
            PreparedStatement purchStatement = con.prepareStatement(sqlPurchOrder);
            purchStatement.setString(1, order_no);
            rs = purchStatement.executeQuery();
            con.commit();
            while(rs.next()){
                listModel.addElement(rs.getString(2) + " " + rs.getString(3));
            }
            list1.setModel(listModel);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
