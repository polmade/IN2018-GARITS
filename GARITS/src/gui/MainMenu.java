/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import java.awt.CardLayout;
import javax.swing.*;
import java.sql.*;

import dbcon.DBConnect;
import dbcon.SQLHelper;
import user_accounts.User;

/**
 *
 * @author hnaro
 */
public class MainMenu extends javax.swing.JFrame {

    DBConnect conn = new DBConnect();
    Connection con;

    {
        try {
            con =  conn.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    DefaultListModel listmodel = new DefaultListModel();
    User user;
    
    /**
     * Creates new MainMenu form/page.
     * @param 
    */
    public MainMenu(User user) {
        this.user = user;
        initComponents();
        setTitle("Mainmenu | GARITS");
        setVisible(true);
        // if the user is admin, admin menu set to enable and other to disable
        if (user.getRole().equalsIgnoreCase("Administrator")) {
            btadminmenu.setEnabled(true);
            btpartsmenu.setEnabled(false);
            btjobsmenu.setEnabled(false);
            btcustomermenu.setEnabled(false);
        }
        populateAdmin(user);
    }
    
    /**
     * populate MainMenu form
     * @param user
     */
    private void populateAdmin(User user) {
        this.lbluserid.setText(user.getUsername());
        
        // making the menu list to single selection
        jListadmin.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        // admin menu options
        listmodel.addElement("Add User");
        listmodel.addElement("Edit/Delete User");
        listmodel.addElement("Backup/Restore Database");
        jListadmin.setModel(listmodel);
    }

    private void populateParts(User user){
        this.lbluserid.setText(user.getUsername());
        jListadmin.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        partsListModel.clear();
        partsListModel.addElement("View Orders");
        partsListModel.addElement("Create Order");
        jListadmin.setModel(partsListModel);
        partsPanel.add(jListadmin);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        emptyPanel = new javax.swing.JPanel();
        adminPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListadmin = new javax.swing.JList<>();
        partsPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jobsPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        customersPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btpartsmenu = new javax.swing.JButton();
        btjobsmenu = new javax.swing.JButton();
        btcustomermenu = new javax.swing.JButton();
        btlogout = new javax.swing.JButton();
        btview = new javax.swing.JButton();
        lbluserid = new javax.swing.JLabel();
        btadminmenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(900, 500));
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));

        mainPanel.setBackground(new java.awt.Color(204, 204, 204));
        mainPanel.setPreferredSize(new java.awt.Dimension(0, 370));
        mainPanel.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout emptyPanelLayout = new javax.swing.GroupLayout(emptyPanel);
        emptyPanel.setLayout(emptyPanelLayout);
        emptyPanelLayout.setHorizontalGroup(
            emptyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 815, Short.MAX_VALUE)
        );
        emptyPanelLayout.setVerticalGroup(
            emptyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 370, Short.MAX_VALUE)
        );

        mainPanel.add(emptyPanel, "card6");

        adminPanel.setBackground(new java.awt.Color(153, 153, 153));

        jListadmin.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jListadmin);

        javax.swing.GroupLayout adminPanelLayout = new javax.swing.GroupLayout(adminPanel);
        adminPanel.setLayout(adminPanelLayout);
        adminPanelLayout.setHorizontalGroup(
            adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 815, Short.MAX_VALUE)
        );
        adminPanelLayout.setVerticalGroup(
            adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
        );

        mainPanel.add(adminPanel, "adminPanel");
        adminPanel.getAccessibleContext().setAccessibleName("");

        partsPanel.setBackground(new java.awt.Color(153, 153, 153));
        partsPanel.setPreferredSize(new java.awt.Dimension(942, 100));

        jLabel2.setText("");

        javax.swing.GroupLayout partsPanelLayout = new javax.swing.GroupLayout(partsPanel);
        partsPanel.setLayout(partsPanelLayout);
        partsPanelLayout.setHorizontalGroup(
            partsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(partsPanelLayout.createSequentialGroup()
                .addGap(0, 395, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(0, 394, Short.MAX_VALUE))
        );
        partsPanelLayout.setVerticalGroup(
            partsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(partsPanelLayout.createSequentialGroup()
                .addGap(0, 177, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(0, 177, Short.MAX_VALUE))
        );

        mainPanel.add(partsPanel, "partsPanel");

        jobsPanel.setBackground(new java.awt.Color(153, 153, 153));
        jobsPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jobsPanel.setMaximumSize(new java.awt.Dimension(100, 100));
        jobsPanel.setPreferredSize(new java.awt.Dimension(100, 100));

        jLabel3.setText("");

        javax.swing.GroupLayout jobsPanelLayout = new javax.swing.GroupLayout(jobsPanel);
        jobsPanel.setLayout(jobsPanelLayout);
        jobsPanelLayout.setHorizontalGroup(
            jobsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jobsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jobsPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jobsPanelLayout.setVerticalGroup(
            jobsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jobsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jobsPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        mainPanel.add(jobsPanel, "jobsPanel");

        customersPanel.setBackground(new java.awt.Color(153, 153, 153));

        jLabel4.setText("");

        javax.swing.GroupLayout customersPanelLayout = new javax.swing.GroupLayout(customersPanel);
        customersPanel.setLayout(customersPanelLayout);
        customersPanelLayout.setHorizontalGroup(
            customersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 815, Short.MAX_VALUE)
            .addGroup(customersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(customersPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel4)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        customersPanelLayout.setVerticalGroup(
            customersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 370, Short.MAX_VALUE)
            .addGroup(customersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(customersPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel4)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        mainPanel.add(customersPanel, "customersPanel");

        btpartsmenu.setText("Parts Menu");
        btpartsmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btpartsmenuActionPerformed(evt);
            }
        });

        btjobsmenu.setText("Jobs Menu");
        btjobsmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btjobsmenuActionPerformed(evt);
            }
        });

        btcustomermenu.setText("Customers Menu");
        btcustomermenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btcustomermenuActionPerformed(evt);
            }
        });

        btlogout.setText("Logout");
        btlogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btlogoutActionPerformed(evt);
            }
        });

        btview.setText("View");
        btview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btviewActionPerformed(evt);
            }
        });

        lbluserid.setText("UserID");

        btadminmenu.setText("Admin Menu");
        btadminmenu.setEnabled(false);
        btadminmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btadminmenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btpartsmenu, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(btjobsmenu, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(btcustomermenu)
                .addGap(50, 50, 50)
                .addComponent(btadminmenu, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(btlogout))
            .addComponent(lbluserid)
            .addComponent(btview, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btadminmenu, btcustomermenu, btjobsmenu, btlogout, btpartsmenu});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btjobsmenu)
                    .addComponent(btlogout)
                    .addComponent(btpartsmenu)
                    .addComponent(btcustomermenu)
                    .addComponent(btadminmenu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btview)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbluserid))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btpartsmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btpartsmenuActionPerformed
        CardLayout card = (CardLayout)mainPanel.getLayout();
        card.show(mainPanel, "partsPanel");
        mainPanel.setName("partsPanel");
        populateParts(user);
        //card.show(partsPanel, "partsPanel");
        //card.show(jListadmin, "Parts");
    }//GEN-LAST:event_btpartsmenuActionPerformed

    private void btjobsmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btjobsmenuActionPerformed
        CardLayout card = (CardLayout)mainPanel.getLayout();
        card.show(mainPanel, "jobsPanel");
    }//GEN-LAST:event_btjobsmenuActionPerformed

    private void btcustomermenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btcustomermenuActionPerformed
        CardLayout card = (CardLayout)mainPanel.getLayout();
        card.show(mainPanel, "customersPanel");
    }//GEN-LAST:event_btcustomermenuActionPerformed

    private void btviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btviewActionPerformed
        String activePanel = mainPanel.getName();
        String selectedItem = jListadmin.getSelectedValue();
        JFrame frame;
        //System.out.println(activePanel);
        try{
            switch(activePanel){
                case "partsPanel":
                    switch (selectedItem){
                        case "View Orders":
                            //dispose();
                            this.setVisible(false);
                            frame = new JFrame("Order");
                            frame.setContentPane(new viewOrders(con, this, frame).orderView);
                            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            frame.pack();
                            frame.setVisible(true);
                        case "Create Order":
                            this.setVisible(false);
                            frame = new JFrame("Order");
                            frame.setContentPane(new orderForm(con, this, frame).formView);
                            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            frame.pack();
                            frame.setVisible(true);
                    }
            }
            if(selectedItem == "Add User") {
                dispose();
                new AddUser(user);
            }
            if (selectedItem == "Edit/Delete User") {
                dispose();
                new EditDeleteUser(user);
            }
            if (selectedItem == "Backup/Restore Database") {
                dispose();
                new BackupRestoreDB(user);
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        }

    }//GEN-LAST:event_btviewActionPerformed

    private void btlogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btlogoutActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btlogoutActionPerformed

    private void btadminmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btadminmenuActionPerformed
        CardLayout card = (CardLayout)mainPanel.getLayout();
        card.show(mainPanel, "adminPanel");
    }//GEN-LAST:event_btadminmenuActionPerformed


    private DefaultListModel<String> partsListModel = new DefaultListModel<>();

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel adminPanel;
    private javax.swing.JButton btadminmenu;
    private javax.swing.JButton btcustomermenu;
    private javax.swing.JButton btjobsmenu;
    private javax.swing.JButton btlogout;
    private javax.swing.JButton btpartsmenu;
    private javax.swing.JButton btview;
    private javax.swing.JPanel customersPanel;
    private javax.swing.JPanel emptyPanel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JList<String> jListadmin;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jobsPanel;
    private javax.swing.JLabel lbluserid;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel partsPanel;
    // End of variables declaration//GEN-END:variables

}
