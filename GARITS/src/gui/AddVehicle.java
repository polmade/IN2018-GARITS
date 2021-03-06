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
public class AddVehicle extends javax.swing.JFrame {
    
    User user;
    SQLHelper sqlhelper;
    DBConnect conn;
    DefaultListModel customersListModel = new DefaultListModel();
    Customer customer = new Customer();
    
    /**
     * Creates new form EditDeleteCustomer
     */
    public AddVehicle(User user) throws SQLException {
        this.user = user;
        initComponents();
        setTitle("Vehicle | GARITS");
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
    
    /*
     * Clears all fields
     * @param 
    */
    private void clearAllFields() {
        tfcustomerid.setText(null);
        tfregno.setText(null);
        tfmake.setText(null);
        tfmodel.setText(null);
        tfengineno.setText(null);
        tfchassisno.setText(null);
        tfcolour.setText(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btback = new javax.swing.JButton();
        lbltitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListCustomers = new javax.swing.JList<>();
        lblselectcustomer = new javax.swing.JLabel();
        lblregistrationno = new javax.swing.JLabel();
        lblmake = new javax.swing.JLabel();
        lblmodel = new javax.swing.JLabel();
        lblengineno = new javax.swing.JLabel();
        lblchassisno = new javax.swing.JLabel();
        lblcolour = new javax.swing.JLabel();
        tfregno = new javax.swing.JTextField();
        tfmake = new javax.swing.JTextField();
        tfmodel = new javax.swing.JTextField();
        tfengineno = new javax.swing.JTextField();
        tfchassisno = new javax.swing.JTextField();
        tfcolour = new javax.swing.JTextField();
        btadd = new javax.swing.JButton();
        btselect = new javax.swing.JButton();
        lblcustomerid = new javax.swing.JLabel();
        tfcustomerid = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        btback.setText("Back");
        btback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbackActionPerformed(evt);
            }
        });

        lbltitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbltitle.setText("Add Vehicle");

        jScrollPane1.setViewportView(jListCustomers);

        lblselectcustomer.setText("Select Customer: ");

        lblregistrationno.setText("Registration No: ");

        lblmake.setText("Make: ");

        lblmodel.setText("Model: ");

        lblengineno.setText("Engine Serial No: ");

        lblchassisno.setText("Chassis No: ");

        lblcolour.setText("Colour: ");

        btadd.setText("Add Vehicle");
        btadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btaddActionPerformed(evt);
            }
        });

        btselect.setText("Select Customer");
        btselect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btselectActionPerformed(evt);
            }
        });

        lblcustomerid.setText("Customer ID: ");

        tfcustomerid.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btback)
                .addGap(115, 115, 115)
                .addComponent(lbltitle)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblregistrationno)
                            .addComponent(lblmake)
                            .addComponent(lblmodel)
                            .addComponent(lblengineno)
                            .addComponent(lblchassisno)
                            .addComponent(lblcolour)
                            .addComponent(lblcustomerid))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfengineno)
                            .addComponent(tfchassisno)
                            .addComponent(tfcolour)
                            .addComponent(tfmodel)
                            .addComponent(tfmake)
                            .addComponent(tfregno, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(tfcustomerid)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btadd)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblselectcustomer))
                            .addComponent(btselect))))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {tfchassisno, tfcolour, tfengineno, tfmake, tfmodel, tfregno});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btadd, btselect});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btback)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbltitle)))
                .addGap(8, 8, 8)
                .addComponent(lblselectcustomer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btselect)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfcustomerid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblcustomerid))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblregistrationno)
                    .addComponent(tfregno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblmake)
                    .addComponent(tfmake, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblmodel)
                    .addComponent(tfmodel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblengineno)
                    .addComponent(tfengineno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblchassisno)
                    .addComponent(tfchassisno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblcolour)
                    .addComponent(tfcolour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btadd)
                .addContainerGap(27, Short.MAX_VALUE))
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

    private void btselectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btselectActionPerformed
        SelectedCustomer();
        if (jListCustomers.getSelectedValue() != null) {
            tfcustomerid.setText(customer.getID());
        }
    }//GEN-LAST:event_btselectActionPerformed

    private void btaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btaddActionPerformed
        String message = "Vehicle added";
        boolean error = false;
        try {
            ResultSet rs = sqlhelper.getQuery("select * from Vehicle");
            while (rs.next()) {
                String regNo = rs.getString("reg_no");
                if (regNo.equals(tfregno.getText())) {
                    error = true;
                    message = "Vehicle already exists";
                }
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        
        if (!error) {
            // Regex from stackoverflow.com, search Regex for UK registration number
            if (tfcustomerid.getText().isEmpty()) {
                error = true;
                message = "Please select a customer";
            }else if (tfregno.getText().isEmpty() || tfmake.getText().isEmpty() || 
                    tfmodel.getText().isEmpty() || tfengineno.getText().isEmpty()
                    || tfchassisno.getText().isEmpty() || tfcolour.getText().isEmpty()) {
                error = true;
                message = "Please fill in all the boxes";
            } else if (!tfregno.getText().matches("^(?=.{1,7})(([a-zA-Z]?){1,3}(\\d){1,3}([a-zA-Z]?){1,3})$")) {
                error = true;
                message = "Invalid registration number";
            } else {
                try {
                    String sql = ("INSERT INTO Vehicle (reg_no, make, model, engine_serial, "
                                + "vin, color, Customerid) "
                                + "VALUES ('" + tfregno.getText() + "', "
                                + "'" + tfmake.getText() + "', "
                                + "'" + tfmodel.getText() + "', "
                                + "'" + tfengineno.getText() + "', "
                                + "'" + tfchassisno.getText() + "', "
                                + "'" + tfcolour.getText() + "', "
                                + "'" + customer.getID() + "')");
                    sqlhelper.updateTable(sql);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        
        if (error) {
            JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, message);
            clearAllFields();
        }   
    }//GEN-LAST:event_btaddActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btadd;
    private javax.swing.JButton btback;
    private javax.swing.JButton btselect;
    private javax.swing.JList<String> jListCustomers;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblchassisno;
    private javax.swing.JLabel lblcolour;
    private javax.swing.JLabel lblcustomerid;
    private javax.swing.JLabel lblengineno;
    private javax.swing.JLabel lblmake;
    private javax.swing.JLabel lblmodel;
    private javax.swing.JLabel lblregistrationno;
    private javax.swing.JLabel lblselectcustomer;
    private javax.swing.JLabel lbltitle;
    private javax.swing.JTextField tfchassisno;
    private javax.swing.JTextField tfcolour;
    private javax.swing.JTextField tfcustomerid;
    private javax.swing.JTextField tfengineno;
    private javax.swing.JTextField tfmake;
    private javax.swing.JTextField tfmodel;
    private javax.swing.JTextField tfregno;
    // End of variables declaration//GEN-END:variables
}
