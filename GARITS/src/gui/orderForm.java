package gui;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import dbcon.SQLHelper;
import inventory.*;
import java.math.*;
import java.util.Random;



public class orderForm {
    public JPanel formView;
    private JTextField textField1;
    private JList list1;
    private JButton goBackButton;
    private JButton refetchButton;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    SQLHelper formHelp = new SQLHelper();
    int randOrderNo;
    static Random rand = new Random();

    public orderForm(Connection con, JFrame prevFrame, JFrame thisFrame) {
        /*try {
            con.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        formHelp.addConnection(con);
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
                int newRand = rand.nextInt();
                //super.mouseClicked(e);extInt()
                try {
                    con.setAutoCommit(false);
                    String sqlCreateOrder = "INSERT INTO Orders VALUES (?, ?);";
                    String sqlPurchaseOrder = "INSERT INTO Purchase_Order VALUES (?, ?, ?);";
                    PreparedStatement createOrder = con.prepareStatement(sqlCreateOrder);
                    createOrder.setInt(1, newRand);
                    createOrder.setInt(2, 542022);
                    int rs = createOrder.executeUpdate();
                    PreparedStatement purchaseOrder = con.prepareStatement(sqlPurchaseOrder);
                    int listSize = listModel.size();
                    for(int i = 0; i < listSize; i++){
                        purchaseOrder.setInt(1, newRand);
                        purchaseOrder.setString(2, listModel.get(i).toString());
                        purchaseOrder.setInt(3, newOrder.getPartsToOrder().get(listModel.get(i).toString()));
                        int com = purchaseOrder.executeUpdate();
                    }
                    con.commit();

                } catch(SQLException ex){
                    System.out.println(ex.getErrorCode());
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
        refetchButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    newOrder.updateUsedPartsMap();
                    newOrder.generatePartsToOrder();
                    updateListModel(listModel, newOrder);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

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

    private void updateListModel(DefaultListModel listModel, InvOrder order){
        listModel.clear();
        for(String s : order.getPartsToOrder().keySet()){
            //listModel.addElement(s + " " + order.getPartsToOrder().get(s));
            listModel.addElement(s);
        }

    }



    private void createGUIComponents(){}
}
