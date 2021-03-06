/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import dbcon.DBConnect;
import dbcon.SQLHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import user_accounts.User;
/**
 *
 * @author hnaro
 */
public class AddUser extends javax.swing.JFrame {
    
    SQLHelper sqlhelper;
    DBConnect conn;
    User user;
    
    /*
     * Creates new AddUser form/page.
     * @param user
     */
    public AddUser(User user) throws SQLException {
        this.user = user;
        initComponents();
        setTitle("Add User | GARITS");
        setVisible(true);
        
        conn = new DBConnect();
        if (conn == null) {
            JOptionPane.showMessageDialog(this, "DB connection failed.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            sqlhelper = new SQLHelper(conn.open());
        }
     
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblpagetitle = new javax.swing.JLabel();
        lblname = new javax.swing.JLabel();
        lblrole = new javax.swing.JLabel();
        lblusername = new javax.swing.JLabel();
        lblpassword = new javax.swing.JLabel();
        tfname = new javax.swing.JTextField();
        cbrole = new javax.swing.JComboBox<>();
        tfusername = new javax.swing.JTextField();
        tfpassword = new javax.swing.JTextField();
        lblhourlyrate = new javax.swing.JLabel();
        tfhourlyrate = new javax.swing.JTextField();
        btcreatenewuser = new javax.swing.JButton();
        btback = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblpagetitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblpagetitle.setText("Add user");

        lblname.setText("Name: ");

        lblrole.setText("Role: ");

        lblusername.setText("Username: ");

        lblpassword.setText("Password: ");

        cbrole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrator", "Franchisee", "Foreperson", "Mechanic", "Receptionist" }));
        cbrole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbroleActionPerformed(evt);
            }
        });

        lblhourlyrate.setText("Hourly Rate: ");

        tfhourlyrate.setEnabled(false);
        tfhourlyrate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfhourlyrateKeyTyped(evt);
            }
        });

        btcreatenewuser.setText("Create New User");
        btcreatenewuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btcreatenewuserActionPerformed(evt);
            }
        });

        btback.setText("Back");
        btback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btback)
                .addGap(92, 92, 92)
                .addComponent(lblpagetitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btcreatenewuser))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblhourlyrate)
                            .addComponent(lblpassword)
                            .addComponent(lblusername)
                            .addComponent(lblrole)
                            .addComponent(lblname))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tfusername, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(cbrole, javax.swing.GroupLayout.Alignment.TRAILING, 0, 120, Short.MAX_VALUE)
                                .addComponent(tfname, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tfhourlyrate)
                                .addComponent(tfpassword)))))
                .addGap(79, 79, 79))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cbrole, tfname, tfpassword});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblpagetitle))
                    .addComponent(btback))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblname)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblrole)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblusername)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblpassword)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblhourlyrate))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tfname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbrole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfusername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfhourlyrate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btcreatenewuser)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbackActionPerformed
        dispose();
        try {
            conn.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        new MainMenu(user);
    }//GEN-LAST:event_btbackActionPerformed

    private void cbroleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbroleActionPerformed
        if(cbrole.getSelectedItem() != null && cbrole.getSelectedItem().toString().equals("Mechanic")) {
            tfhourlyrate.setEnabled(true);
            tfhourlyrate.setText("105");
        }
        else if(cbrole.getSelectedItem() != null && cbrole.getSelectedItem().toString().equals("Foreperson")) {
            tfhourlyrate.setEnabled(true);
            tfhourlyrate.setText("125");
        } else {
            tfhourlyrate.setEnabled(false);
            tfhourlyrate.setText("");
        }
    }//GEN-LAST:event_cbroleActionPerformed

    private void btcreatenewuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btcreatenewuserActionPerformed
        boolean flag = true;
        boolean exists = false;
        // check for empty fields
        if (tfname.getText().isEmpty() || tfusername.getText().isEmpty() || tfpassword.getText().isEmpty()
                || cbrole.getSelectedIndex() == -1) {
            flag = false;
        }
        // check if hourly rate text field is enabled and empty
        else if (tfhourlyrate.isEnabled() && tfhourlyrate.getText().isEmpty()) {
            flag = false;
        } else {
            // create new user
            try {
                ResultSet rs = sqlhelper.getQuery("select * from user");
                while (rs.next()) {
                    String username = rs.getString("username");
                    if (username.equals(tfusername.getText())) {
                        exists = true;
                    }
                }
                if (!exists) {
                    String sql = ("insert into user (name, role, username, password)" 
                            + "values("
                            + "'" + tfname.getText() + "',"
                            + "'" + cbrole.getSelectedItem().toString() + "',"
                            + "'" + tfusername.getText() + "',"
                            + "'" + tfpassword.getText() + "')");
                    sqlhelper.updateTable(sql);
                    
                    // if user == "mechanic" OR "Foreperson"
                    if(cbrole.getSelectedItem() != null && cbrole.getSelectedItem().toString().equals("Mechanic")
                            || cbrole.getSelectedItem().toString().equals("Foreperson")) {
                        try {
                            String sql2 = ("UPDATE user "
                                + "SET hourly_rate='"+tfhourlyrate.getText()+"'"
                                + "WHERE username='"+tfusername.getText()+"';");
                            sqlhelper.updateTable(sql2);
                        } catch(SQLException e) {
                            System.err.println(e.getMessage());
                        }
                    }
                    clearAllFields();
                }
            } catch(SQLException e) {
                System.err.println(e.getMessage());
            }
        }
        
        if (!flag) {
            JOptionPane.showMessageDialog(this, "Please fill in all the boxes", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (exists) {
            JOptionPane.showMessageDialog(this, "Username already exists", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "New user created");
        }
    }//GEN-LAST:event_btcreatenewuserActionPerformed

    private void tfhourlyrateKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfhourlyrateKeyTyped
        // restric user from entering any other character except Double
        if (Character.isLetter(evt.getKeyChar())) {
            evt.consume();
        } else {
            try {
                Double.parseDouble(tfhourlyrate.getText()+evt.getKeyChar());
            } catch (NumberFormatException e) {
                evt.consume();
            }
        }
    }//GEN-LAST:event_tfhourlyrateKeyTyped
    
    /*
     * Clears all fields
     * @param 
     */
    private void clearAllFields() {
        tfname.setText(null);
        cbrole.setSelectedItem(null);
        tfusername.setText(null);
        tfpassword.setText(null);
        tfhourlyrate.setText(null);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btback;
    private javax.swing.JButton btcreatenewuser;
    private javax.swing.JComboBox<String> cbrole;
    private javax.swing.JLabel lblhourlyrate;
    private javax.swing.JLabel lblname;
    private javax.swing.JLabel lblpagetitle;
    private javax.swing.JLabel lblpassword;
    private javax.swing.JLabel lblrole;
    private javax.swing.JLabel lblusername;
    private javax.swing.JTextField tfhourlyrate;
    private javax.swing.JTextField tfname;
    private javax.swing.JTextField tfpassword;
    private javax.swing.JTextField tfusername;
    // End of variables declaration//GEN-END:variables
}
