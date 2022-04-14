package gui;

import dbcon.DBConnect;
import dbcon.SQLHelper;
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
    private JButton addNewPartButton;
    private JButton editPartButton;
    public JPanel sparePanel;
    private JList list1;
    private JButton refetchButton;
    private InvParts parts;
    private List<String[]> mapping = new ArrayList<String[]>();
    private JFrame frame;

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
        editPartButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                thisFrame.setVisible(false);
                frame = new JFrame(mapping.get(list1.getSelectedIndex())[0]);
                frame.setContentPane(new editPart(con, thisFrame, frame,Integer.valueOf(mapping.get(list1.getSelectedIndex())[7]), mapping.get(list1.getSelectedIndex())[0], Integer.valueOf(mapping.get(list1.getSelectedIndex())[6])).editPartPanel);
                /* "hgmj"/*list1.getSelectedValue().toString()/*.substring(0/* list1.getSelectedValue().toString().indexOf(' '))*/
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
                System.out.println(list1.getSelectedValue().toString());
            }
        });
        addNewPartButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                thisFrame.setVisible(false);
                frame = new JFrame("Add Part");
                frame.setContentPane(new addParts(con, thisFrame, frame).addPartPanel);
                /* "hgmj"/*list1.getSelectedValue().toString()/*.substring(0/* list1.getSelectedValue().toString().indexOf(' '))*/
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
                //System.out.println(list1.getSelectedValue().toString());
            }
        });
        refetchButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                SQLHelper sqlHelp = new SQLHelper(con);
                try {
                    ResultSet rs = sqlHelp.getQuery("SELECT * FROM SpareParts");
                    listModel.clear();
                    updateListModel(listModel, rs);
                    thisFrame.repaint();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
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
