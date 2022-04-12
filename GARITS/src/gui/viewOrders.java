package gui;

import dbcon.SQLHelper;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class viewOrders {
    private JButton goBackButton;
    private JButton printButton;
    private JList list1;
    public JPanel orderView;
    private JButton viewButton;
    ResultSet orderRes;
    List<String[]> mapping = new ArrayList<String[]>();


    public viewOrders(Connection con, JFrame prevFrame, JFrame thisFrame){
        SQLHelper viewHelp = new SQLHelper(con);
        int currDate = 542022;
        String getOrders = "SELECT * FROM Orders WHERE date = " + currDate;
        try{
            orderRes = viewHelp.getQuery(getOrders);
        }catch(SQLException e){
            e.printStackTrace();
        }
        DefaultListModel<Object> listModel = new DefaultListModel<>();
        updateListModel(listModel, orderRes);
        list1.setModel(listModel);

        viewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                JFrame frame = new JFrame("Order" + list1.getSelectedValue().toString());
                frame.setContentPane(new viewPurchOrder(con, list1.getSelectedValue().toString()).purchView);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
        goBackButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                prevFrame.setVisible(true);
                thisFrame.dispose();

            }
        });
    }

    private void updateListModel(DefaultListModel listModel, ResultSet rs){
        listModel.clear();
        try {
            while(rs.next()){
                String[] newArr = {rs.getString(1), rs.getString(2)};
                mapping.add(newArr);
            }

        } catch (SQLException e) {
               e.printStackTrace();
        }
        for(String[] a : mapping){
            listModel.addElement(a[0]);
        }
    }

}
