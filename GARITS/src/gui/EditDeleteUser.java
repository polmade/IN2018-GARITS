/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import dbcon.DBConnect;
import dbcon.SQLHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import user_accounts.User;

/**
 *
 * @author hnaro
 */
public class EditDeleteUser extends javax.swing.JFrame {
    
    SQLHelper sqlhelper;
    DBConnect conn;
    User user;
    User selectedUser = new User();
    DefaultListModel usersListModel;
    
    /*
     * Creates new Edit/Delete User form/page.
     * @param user
     */
    public EditDeleteUser(User user) throws SQLException{
        this.user = user;
        usersListModel = new DefaultListModel();
        initComponents();
        setTitle("Edit/Delete User | GARITS");
        setVisible(true);
        
        conn = new DBConnect();
        if (conn == null) {
            JOptionPane.showMessageDialog(this, "DB connection failed.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            sqlhelper = new SQLHelper(conn.open());
        }
        
        jPaneledituser.setVisible(false);
        
        UpdateList();
    }
    
    /*
     * update the jListuser with all users in db table
     * @param 
    */
    private void UpdateList() {
        // get all user from table user
        try {
            ResultSet rs = sqlhelper.getQuery("select * from user");
            // clear current list in jListusers
            jListusers.removeAll();
            usersListModel.clear();
            while (rs.next()) {
                String username = rs.getString("username");
                String role = rs.getString("role");
                usersListModel.addElement(username+", "+role);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        // add list model to jList
        jListusers.setModel(usersListModel);
    }
    
    /*
     * Updates user information with selected user
     * @param 
    */
    private void SelectedUser() {
        if(jListusers.getSelectedValue() == null) {
            JOptionPane.showMessageDialog(this, "Please select a user", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            List<String> splitStr = Arrays.asList(jListusers.getSelectedValue().split(","));
            // get selected user
            try {
                ResultSet rs = sqlhelper.getQuery("Select * from user where username='"+splitStr.get(0)+"'");
                while (rs.next()) {
                    selectedUser.setName(rs.getString("name"));
                    selectedUser.setRole(rs.getString("role"));
                    selectedUser.setUsername(rs.getString("username"));
                    selectedUser.setPassword(rs.getString("password"));
                    selectedUser.setHourlyRate(rs.getDouble("hourly_rate"));
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
    }
    
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblpagetitle = new javax.swing.JLabel();
        btback = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListusers = new javax.swing.JList<>();
        jPaneledituser = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfname = new javax.swing.JTextField();
        cbrole = new javax.swing.JComboBox<>();
        tfusername = new javax.swing.JTextField();
        tfpassword = new javax.swing.JTextField();
        tfhourlyrate = new javax.swing.JTextField();
        btconfirm = new javax.swing.JButton();
        btdeleteuser = new javax.swing.JButton();
        btedituser = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        lblpagetitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblpagetitle.setText("Edit/Delete User");

        btback.setText("Back");
        btback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbackActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jListusers);

        jLabel1.setText("Name: ");

        jLabel2.setText("Role: ");

        jLabel3.setText("Username: ");

        jLabel4.setText("Password: ");

        jLabel5.setText("Hourly Rate: ");

        cbrole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrator", "Franchisee", "Foreperson", "Mechanic", "Receptionist" }));
        cbrole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbroleActionPerformed(evt);
            }
        });

        tfhourlyrate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfhourlyrateKeyTyped(evt);
            }
        });

        btconfirm.setText("Confirm");
        btconfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btconfirmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPaneledituserLayout = new javax.swing.GroupLayout(jPaneledituser);
        jPaneledituser.setLayout(jPaneledituserLayout);
        jPaneledituserLayout.setHorizontalGroup(
            jPaneledituserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPaneledituserLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPaneledituserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPaneledituserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfhourlyrate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbrole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfusername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfname, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPaneledituserLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btconfirm)
                .addContainerGap())
        );

        jPaneledituserLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3, jLabel4, jLabel5});

        jPaneledituserLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cbrole, tfhourlyrate, tfname, tfpassword, tfusername});

        jPaneledituserLayout.setVerticalGroup(
            jPaneledituserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPaneledituserLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPaneledituserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPaneledituserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbrole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPaneledituserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfusername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPaneledituserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPaneledituserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfhourlyrate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btconfirm)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btdeleteuser.setText("Delete User");
        btdeleteuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btdeleteuserActionPerformed(evt);
            }
        });

        btedituser.setText("Edit User");
        btedituser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btedituserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 53, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btedituser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btdeleteuser))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btback)
                        .addGap(53, 53, 53)
                        .addComponent(lblpagetitle))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jPaneledituser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btdeleteuser, btedituser});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btback)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblpagetitle)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btdeleteuser)
                    .addComponent(btedituser))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPaneledituser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void btconfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btconfirmActionPerformed
        String message = "";
        boolean flag = true;
        if (tfname.getText().isEmpty() || tfusername.getText().isEmpty() || tfpassword.getText().isEmpty()) {
            message = "Please fill in all the boxes";
            flag = false;
        }
        // check if hourly rate text field is enabled and empty
        else if (tfhourlyrate.isEnabled() && tfhourlyrate.getText().isEmpty()) {
            message = "Please fill in all the boxes";
            flag = false;
        } else {
            try {
                ResultSet rs = sqlhelper.getQuery("select * from user");
                while (rs.next()) {
                    String username = rs.getString("username");
                    if (username.equals(tfusername.getText()) && !tfusername.getText().equals(selectedUser.getUsername())) {
                        message = "Username already exists";
                        flag = false;
                    }
                }
            } catch(SQLException e) {
                System.err.println(e.getMessage());
            }
            if (flag) {
                // edit user
                try {
                    String sql = ("UPDATE user "
                            + "SET name='" + tfname.getText() + "',"
                            + "role = '" + cbrole.getSelectedItem().toString() + "',"
                            + "username = '" + tfusername.getText() + "',"
                            + "password = '" + tfpassword.getText() + "'"
                            + "WHERE username = '" +selectedUser.getUsername()+"';");
                    sqlhelper.updateTable(sql);
                } catch(SQLException e) {
                    System.err.println(e.getMessage());
                }

                // if user == "mechanic" OR "Foreperson"
                if(cbrole.getSelectedItem() != null && cbrole.getSelectedItem().toString().equals("Mechanic")
                        || cbrole.getSelectedItem().toString().equals("Foreperson")) {
                    try {
                        String sql = ("UPDATE user "
                                + "SET hourly_rate='"+tfhourlyrate.getText()+"'"
                                + "WHERE username='"+selectedUser.getUsername()+"';");
                        sqlhelper.updateTable(sql);
                    } catch(SQLException e) {
                        System.err.println(e.getMessage());
                    }
                }
                // if selectedUser == "mechanic" OR "Foreperson", UPDATED to other role
                if(cbrole.getSelectedItem() != null && selectedUser.getRole().equals("Mechanic")
                        || cbrole.getSelectedItem().toString().equals("Foreperson")) {
                    try {
                        String sql = ("UPDATE user "
                            + "SET hourly_rate=NULL "
                            + "WHERE username='"+tfusername.getText()+"';");
                        sqlhelper.updateTable(sql);
                    } catch(SQLException e) {
                        System.err.println(e.getMessage());
                    }
                }
                clearAllFields();
            }
        }
        
        if (!flag) {
            JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "User updated");
            UpdateList();
        }
    }//GEN-LAST:event_btconfirmActionPerformed

    private void btedituserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btedituserActionPerformed
        SelectedUser();
        if (jListusers.getSelectedValue() != null) {

            jPaneledituser.setVisible(true);
            tfname.setText(selectedUser.getName());
            cbrole.setSelectedItem(selectedUser.getRole());
            tfusername.setText(selectedUser.getUsername());
            tfpassword.setText(selectedUser.getPassword());
            if(selectedUser.getRole().equals("Mechanic") || selectedUser.getRole().equals("Foreperson")) {
                tfhourlyrate.setEnabled(true);
                tfhourlyrate.setText(Double.toString(selectedUser.getHourlyRate()));
            }
            jListusers.clearSelection();
        }
    }//GEN-LAST:event_btedituserActionPerformed

    private void btdeleteuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btdeleteuserActionPerformed
        SelectedUser();
        String username = selectedUser.getUsername();
        if(username == null || jListusers.getSelectedValue() == null) {
            // do nothing
        } else {
            // remove user from jlist and db
            int confirm = JOptionPane.showConfirmDialog(null, "Are you Sure you want to delete the user?", "Delete User", JOptionPane.YES_NO_OPTION);
            if(confirm == JOptionPane.YES_OPTION) {
                // delete from user
                try {
                    String sql = ("DELETE FROM user WHERE username='"+username+"';");
                    sqlhelper.updateTable(sql);
                } catch (SQLException e) {
                    System.err.println(e.getMessage());
                }
                UpdateList();
                clearAllFields();
            }
        }
    }//GEN-LAST:event_btdeleteuserActionPerformed

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btback;
    private javax.swing.JButton btconfirm;
    private javax.swing.JButton btdeleteuser;
    private javax.swing.JButton btedituser;
    private javax.swing.JComboBox<String> cbrole;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList<String> jListusers;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPaneledituser;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblpagetitle;
    private javax.swing.JTextField tfhourlyrate;
    private javax.swing.JTextField tfname;
    private javax.swing.JTextField tfpassword;
    private javax.swing.JTextField tfusername;
    // End of variables declaration//GEN-END:variables
}
