package gui;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * add part to the database
 * @author dylantuckey
 */
public class addParts {
    private JButton goBackButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    public JPanel addPartPanel;
    private JButton addPartButton;
    private Connection conn;

    public addParts(Connection con, JFrame prevFrame, JFrame thisFrame){
        conn = con;
        addPartButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    submitChangeDB();
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
    //submit changes made to the db
    private void submitChangeDB() throws SQLException {
        String sqlAddPart = "INSERT INTO SpareParts VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement addPart = conn.prepareStatement(sqlAddPart);
        addPart.setString(1, textField1.getText());
        addPart.setString(2, textField2.getText());
        addPart.setString(3, textField3.getText());
        addPart.setString(4, textField4.getText());
        addPart.setString(5, textField5.getText());
        addPart.setInt(6, Integer.valueOf(textField6.getText()));
        addPart.setInt(7, Integer.valueOf(textField7.getText()));
        addPart.setInt(8, Integer.valueOf(textField8.getText()));
        //System.out.println("Here");
        int added = addPart.executeUpdate();
        //System.out.println("Here 2");
    }

}
