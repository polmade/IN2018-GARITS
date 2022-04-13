package gui;

import inventory.InvParts;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class viewSpareParts {
    private JButton goBackButton;
    private JButton button2;
    private JButton editPartButton;
    public JPanel sparePanel;
    private JList list1;
    InvParts parts;
    List<String[]> mapping = new ArrayList<String[]>();

    public viewSpareParts(Connection con, JFrame prevFrame, JFrame thisFrame){

        try {
            parts = new InvParts(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        DefaultListModel<String> listModel = new DefaultListModel();
        /*
        for(String[] a : mapping){
            listModel.addElement(a[0] + " - " + a[1] + " - " + a[6] + " remaining");
        }

         */
        updateListModel(listModel, parts.getRS());
        list1.setModel(listModel);


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
                String[] newArr = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)};
                mapping.add(newArr);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        for(String[] a : mapping){
            listModel.addElement(a[0]+ " - " + a[1] + " - " + a[6] + " remaining");
        }
    }

}
