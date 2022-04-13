/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import customer_account.Customer;
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
public class EditDeleteCustomer extends javax.swing.JFrame {
    
    User user;
    SQLHelper sqlhelper;
    DBConnect conn;
    DefaultListModel customersListModel = new DefaultListModel();
    Customer customer = new Customer();
    
    /**
     * Creates new form EditDeleteCustomer
     */
    public EditDeleteCustomer(User user) throws SQLException {
        this.user = user;
        initComponents();
        setTitle("Edit/Delete Customer | GARITS");
        setVisible(true);
        
        conn = new DBConnect();
        if (conn == null) {
            JOptionPane.showMessageDialog(this, "DB connection failed.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            sqlhelper = new SQLHelper(conn.open());
        }
        
        UpdateList();
    }
    
    /*
     * update the jListCustomers with all customers in db
     * @param 
    */
    private void UpdateList() {
        // get all customer from table Customer
        try {
            ResultSet rs = sqlhelper.getQuery("select * from Customer");
            // clear current list in jListusers
            jListCustomers.removeAll();
            customersListModel.clear();
            while (rs.next()) {
                String id = rs.getString("id");
                String fname = rs.getString("fname");
                String lname = rs.getString("lname");
                customersListModel.addElement(id + ", " +fname +", "+lname);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        // add list model to jList
        jListCustomers.setModel(customersListModel);
    }
    
    /*
     * Updates customer information with selected customer
     * @param 
    */
    private void SelectedCustomer() {
        if(jListCustomers.getSelectedValue() == null) {
            JOptionPane.showMessageDialog(this, "Please select a customer", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            List<String> splitStr = Arrays.asList(jListCustomers.getSelectedValue().split(","));
            // get selected user
            try {
                ResultSet rs = sqlhelper.getQuery("Select * from Customer where id='"+splitStr.get(0)+"'");
                while (rs.next()) {
                    customer.setID(rs.getString("id"));
                    customer.setFname(rs.getString("fname"));
                    customer.setLname(rs.getString("lname"));
                    customer.setAddress(rs.getString("address"));
                    customer.setPostcode(rs.getString("postcode"));
                    customer.setTelephone(rs.getString("telephone"));
                    customer.setEmail(rs.getString("email"));
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
    }
    
    /**
     * Text fields validations
     */
    private boolean validateFields() {
        boolean validated = false;
        String EMAIL_PATTERN = "^(.+)@(.+)$";
        
        // check for empty fields
        if (tffname.getText().isEmpty() || tflname.getText().isEmpty() || 
                tfaddress.getText().isEmpty() || tfpostcode.getText().isEmpty()
                || tfemail.getText().isEmpty() || tftelephone.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all the boxes", "Error", JOptionPane.ERROR_MESSAGE);
        }
        // email pattern from https://howtodoinjava.com/java/regex/java-regex-validate-email-address/
        else if (!tfemail.getText().matches(EMAIL_PATTERN)){
            JOptionPane.showMessageDialog(this, "Please enter a valid email", "Error", JOptionPane.ERROR_MESSAGE);
        }
        // validating telephone number, must be 11 digits
        else if(!tftelephone.getText().matches("\\d{8}|\\d{11}")) {
            JOptionPane.showMessageDialog(this, "Please enter a valid telephone number", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            validated = true;
        }
        return validated;
    }
    
    /*
     * Clears all fields
     * @param 
    */
    private void clearAllFields() {
        tfid.setText(null);
        tffname.setText(null);
        tflname.setText(null);
        tfaddress.setText(null);
        tfpostcode.setText(null);
        tftelephone.setText(null);
        tfemail.setText(null);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        btback = new javax.swing.JButton();
        lbltitle = new javax.swing.JLabel();
        lblselectcustomer = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListCustomers = new javax.swing.JList<>();
        lblid = new javax.swing.JLabel();
        tfid = new javax.swing.JTextField();
        lblfname = new javax.swing.JLabel();
        tffname = new javax.swing.JTextField();
        lbllname = new javax.swing.JLabel();
        tflname = new javax.swing.JTextField();
        lbladdress = new javax.swing.JLabel();
        tfaddress = new javax.swing.JTextField();
        lblpostcode = new javax.swing.JLabel();
        tfpostcode = new javax.swing.JTextField();
        lbltelephone = new javax.swing.JLabel();
        tftelephone = new javax.swing.JTextField();
        lblemail = new javax.swing.JLabel();
        tfemail = new javax.swing.JTextField();
        btdelete = new javax.swing.JButton();
        btedit = new javax.swing.JButton();
        btconfirm = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btback.setText("Back");
        btback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbackActionPerformed(evt);
            }
        });

        lbltitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbltitle.setText("Edit/Delete Customer");

        lblselectcustomer.setText("Select Customer: ");

        jScrollPane1.setViewportView(jListCustomers);

        lblid.setText("ID: ");

        tfid.setEnabled(false);

        lblfname.setText("First Name: ");

        lbllname.setText("Last Name: ");

        lbladdress.setText("Address: ");

        lblpostcode.setText("Postcode: ");

        lbltelephone.setText("Telephone: ");

        tftelephone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tftelephoneKeyTyped(evt);
            }
        });

        lblemail.setText("Email:");

        btdelete.setText("Delete Customer");
        btdelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btdeleteActionPerformed(evt);
            }
        });

        btedit.setText("Edit Customer");
        btedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bteditActionPerformed(evt);
            }
        });

        btconfirm.setText("Confirm");
        btconfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btconfirmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btback)
                .addGap(50, 50, 50)
                .addComponent(lbltitle)
                .addGap(0, 98, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btedit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btdelete))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblselectcustomer))
                            .addComponent(btconfirm)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblid)
                            .addComponent(lblfname)
                            .addComponent(lbllname)
                            .addComponent(lbladdress)
                            .addComponent(lblpostcode)
                            .addComponent(lbltelephone)
                            .addComponent(lblemail))
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfid, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tffname, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tflname, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfaddress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfpostcode, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tftelephone, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfemail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {tfaddress, tfemail, tffname, tfid, tflname, tfpostcode, tftelephone});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btconfirm, btdelete, btedit});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btback)
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lbltitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(lblselectcustomer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btdelete)
                    .addComponent(btedit))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblid)
                    .addComponent(tfid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblfname)
                    .addComponent(tffname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbllname)
                    .addComponent(tflname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbladdress)
                    .addComponent(tfaddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblpostcode)
                    .addComponent(tfpostcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbltelephone)
                    .addComponent(tftelephone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblemail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btconfirm)
                .addContainerGap(22, Short.MAX_VALUE))
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

    private void btdeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btdeleteActionPerformed
        SelectedCustomer();
        String id = customer.getID();
        if(jListCustomers.getSelectedValue() == null) {
            // do nothing
        } else {
            // remove customer from jlist and db
            int confirm = JOptionPane.showConfirmDialog(null, "Are you Sure you want to delete the user?", "Delete User", JOptionPane.YES_NO_OPTION);
            if(confirm == JOptionPane.YES_OPTION) {
                // delete all vehicles that belong to this customer
                try {
                    String sql = ("DELETE FROM Vehicle WHERE Customerid='"+id+"';");
                    sqlhelper.updateTable(sql);
                } catch (SQLException e) {
                    System.err.println(e.getMessage());
                }
                // delete customer details
                try {
                    String sql = ("DELETE FROM Customer WHERE id='"+id+"';");
                    sqlhelper.updateTable(sql);
                } catch (SQLException e) {
                    System.err.println(e.getMessage());
                }
                UpdateList();
                clearAllFields();
            }
        }
    }//GEN-LAST:event_btdeleteActionPerformed

    private void tftelephoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tftelephoneKeyTyped
        // only numberic input allowed
        char c = evt.getKeyChar();
        if (((c < '0') || (c > '9')) && (c != evt.VK_BACK_SPACE)) {
            evt.consume();
        }
    }//GEN-LAST:event_tftelephoneKeyTyped

    private void bteditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bteditActionPerformed
        SelectedCustomer();
        if (jListCustomers.getSelectedValue() != null) {
            tfid.setText(customer.getID());
            tffname.setText(customer.getFname());
            tflname.setText(customer.getLname());
            tfaddress.setText(customer.getAddress());
            tfpostcode.setText(customer.getPostcode());
            tftelephone.setText(customer.getTelephone());
            tfemail.setText(customer.getEmail());
            jListCustomers.clearSelection();
        }
    }//GEN-LAST:event_bteditActionPerformed

    private void btconfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btconfirmActionPerformed
        if (tfid.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Cannot update customer", "Error", JOptionPane.ERROR_MESSAGE);
        } 
        else if (validateFields() == true) {
            try {
                String sql = ("UPDATE Customer "
                        + "SET fname='" + tffname.getText() + "',"
                        + "lname='" + tflname.getText() + "',"
                        + "address='" + tfaddress.getText() + "',"
                        + "postcode='" + tfpostcode.getText() + "',"
                        + "telephone='" + tftelephone.getText() + "',"
                        + "email='" + tfemail.getText() + "' "
                        + "WHERE id='" + tfid.getText() + "';");
                sqlhelper.updateTable(sql);
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
            clearAllFields();
            JOptionPane.showMessageDialog(this, "Customer updated");
            UpdateList();
        }
    }//GEN-LAST:event_btconfirmActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btback;
    private javax.swing.JButton btconfirm;
    private javax.swing.JButton btdelete;
    private javax.swing.JButton btedit;
    private javax.swing.JButton jButton1;
    private javax.swing.JList<String> jListCustomers;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbladdress;
    private javax.swing.JLabel lblemail;
    private javax.swing.JLabel lblfname;
    private javax.swing.JLabel lblid;
    private javax.swing.JLabel lbllname;
    private javax.swing.JLabel lblpostcode;
    private javax.swing.JLabel lblselectcustomer;
    private javax.swing.JLabel lbltelephone;
    private javax.swing.JLabel lbltitle;
    private javax.swing.JTextField tfaddress;
    private javax.swing.JTextField tfemail;
    private javax.swing.JTextField tffname;
    private javax.swing.JTextField tfid;
    private javax.swing.JTextField tflname;
    private javax.swing.JTextField tfpostcode;
    private javax.swing.JTextField tftelephone;
    // End of variables declaration//GEN-END:variables
}
