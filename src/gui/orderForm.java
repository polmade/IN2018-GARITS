package gui;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import inventory.*;

public class orderForm {
    public JPanel formView;
    private JTextField textField1;
    private JList list1;
    private JButton goBackButton;
    private JButton refetchButton;
    private JButton button3;
    private JButton button4;
    private JButton button5;


    public orderForm(Connection con) {
        try {
            con.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Invmain newmain = new Invmain(con);
        InvOrder newOrder = new InvOrder();
        newOrder.generatePartsToOrder();
        DefaultListModel listModel = new DefaultListModel();
        updateListModel(listModel, newOrder);

        //listModel.addElement("Hello");
        list1.setModel(listModel);

        button5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                newOrder.getPartsToOrder().replace((String) list1.getSelectedValue(), Integer.valueOf(textField1.getText()));
                //newOrder.updateDB(sqlUpdate);
                updateListModel(listModel, newOrder);
            }
        });
        button4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //super.mouseClicked(e);
                try {
                    //con.setAutoCommit(false);
                    //String sqlCreateOrder = "INSERT INTO Orders VALUES (order_no = ?, date = ?, ReceptionistUsersid = ?)";
                    /*
                    PreparedStatement createOrder = con.prepareStatement(sqlCreateOrder);
                    createOrder.setString(1, String.valueOf(1));
                    createOrder.setString(2, "5/4/2022");
                    createOrder.setString(3, String.valueOf(2));
                    System.out.println(createOrder);
                    createOrder.executeUpdate();

                     */
                    String sqlCreateOrder = "INSERT INTO Orders VALUES (order_no = " + String.valueOf(1)  +  ", date = " + 542022 + ", ReceptionistUsersid = " + 2 + ")";
                    //con.commit();
                    //con.setAutoCommit(true);
                    newOrder.updateDB(sqlCreateOrder);
                    System.out.println("Committed");
                            /*
                            String sqlUpdate = "INSERT INTO Purchase_Order VALUES Ordersorder_no = ?, SparePartspart_code = ? , noToOrder = ?";
                    PreparedStatement sqlUpdateStatement = con.prepareStatement(sqlUpdate);
                    sqlUpdateStatement.setString(1, String.valueOf(1));
                    sqlUpdateStatement.setString(2, String.valueOf(list1.getSelectedValue()));
                    sqlUpdateStatement.setString(3, textField1.getText());

                             */
                } catch(SQLException ex){

                }

            }
        });
        list1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                textField1.setText(String.valueOf(newOrder.getPartsToOrder().get(list1.getSelectedValue())));
            }
        });
        textField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    newOrder.getPartsToOrder().replace((String) list1.getSelectedValue(), Integer.valueOf(textField1.getText()));
                    updateListModel(listModel, newOrder);
                }
            }
        });
    }

    private void updateListModel(DefaultListModel listModel, InvOrder order){
        listModel.clear();
        for(String s : order.getPartsToOrder().keySet()){
            //listModel.addElement(s + " " + order.getPartsToOrder().get(s));
            listModel.addElement(s);
        }

    }

    private void createGUIComponents(){}
}
