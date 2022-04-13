package gui;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class editPart {
    public JPanel editPartPanel;
    private JLabel valLabel;
    private JTextField addField;
    private JTextField threshField;
    private JLabel threshLabel;
    private JButton enterButton;
    private JButton goBackButton;
    Connection conn;
    int currThreshInner;
    String partCodeInner;
    int currLevelInner;

    public editPart(Connection con, JFrame prevFrame, JFrame thisFrame, int currThresh, String partCode, int currLevel){
        //thisFrame.setTitle(partCode);
        conn = con;
        currThreshInner = currThresh;
        partCodeInner = partCode;
        currLevelInner = currLevel;
        enterButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                submitChangeDB();
                prevFrame.setVisible(true);
                thisFrame.dispose();
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

    private void submitChangeDB(){
        String sqlPartEdit = "UPDATE SpareParts SET stock_level = ?, min_threshold = ? WHERE part_code = ?";
        try {
            PreparedStatement edited = conn.prepareStatement(sqlPartEdit);
            edited.setInt(1, Integer.valueOf(addField.getText())+currLevelInner);
            if(threshField.getText().isEmpty()){
                edited.setInt(2, currThreshInner);
            }else{
                edited.setInt(2, Integer.valueOf(threshField.getText()));
            }
            edited.setString(3, partCodeInner);
            int submit = edited.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
