/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.PublisherRole;

import Business.Adspace.Adspace;
import Business.Organization.PublisherOrganization;
import Business.Publisher.Publisher;
import Business.WorkQueue.AdExchangeRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sriram
 */
public class ManageAdSpaceJPanel extends javax.swing.JPanel {

    JPanel userProcessContainer;
    Publisher publisher;
    PublisherOrganization publisherOrganization;
    
    public ManageAdSpaceJPanel(JPanel upc, Publisher publisher, PublisherOrganization publisherOrganization) {
        initComponents();
        this.userProcessContainer = upc;
        this.publisher = publisher;
        this.publisherOrganization = publisherOrganization;
        txtName.setText(publisher.getFirstName());
        populateAdSpaceTable();
    }
    
    private void populateAdSpaceTable() {
        DefaultTableModel dtm = (DefaultTableModel)adSpaceCatalogJTable.getModel();
        dtm.setRowCount(0);
        
        for(Adspace adspace : publisher.getAdspaceCatalog().getAdspaceList()) {
            
            Object row[] = new Object[4];
            row[0] = adspace;
            row[1] = adspace.getLocation();
            row[2] = adspace.getBasePrice();
            row[3] = adspace.getSize();
            dtm.addRow(row);
        }
            }
      
    private void populateAdvertiserTable(Adspace a) {
        
        DefaultTableModel dtm = (DefaultTableModel)displayAdvertiserJTable.getModel();
        dtm.setRowCount(0);
         for(WorkRequest workRequest : publisherOrganization.getWorkQueue().getWorkRequestList()) {
                AdExchangeRequest req = (AdExchangeRequest) workRequest;
                if(req.getAdSpace().getSpaceNumber() == a.getSpaceNumber()) {
                    
                   Object row[] = new Object[4];
                   row[0] = req.getAdvertisement();
                   row[1] = req.getBidRate();
                   row[2] = req.getAdSpace();
                   row[3] = req.getAdvertisement().getProduct();
                   dtm.addRow(row);
                }
                    
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

        jPanel1 = new javax.swing.JPanel();
        manageProductCatJLabel = new javax.swing.JLabel();
        manageSuppJLabel = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        btnRefresh = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        adSpaceCatalogJTable = new javax.swing.JTable();
        deleteadSpaceJButton = new javax.swing.JButton();
        viewadSpaceJButton = new javax.swing.JButton();
        createadSpaceJButton = new javax.swing.JButton();
        backJButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        displayAdvertiserJTable = new javax.swing.JTable();
        advertiserJButton = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        manageProductCatJLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        manageProductCatJLabel.setText("Manage Publisher Catalog");
        jPanel1.add(manageProductCatJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 11, -1, -1));

        manageSuppJLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        manageSuppJLabel.setText("Publisher:");
        jPanel1.add(manageSuppJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 51, 170, -1));

        txtName.setEditable(false);
        txtName.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        txtName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtName.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, new java.awt.Color(102, 102, 102), null, null));
        jPanel1.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 71, 150, 30));

        btnRefresh.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnRefresh.setText("Refresh >>");
        btnRefresh.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnRefresh.setMargin(new java.awt.Insets(2, 1, 2, 1));
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });
        jPanel1.add(btnRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 111, -1, 36));

        adSpaceCatalogJTable.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        adSpaceCatalogJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Adspace Name", "Adspace Location", "Base Price", "Ad Size"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Float.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(adSpaceCatalogJTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 165, 480, 110));

        deleteadSpaceJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        deleteadSpaceJButton.setText("Delete AdSpace >>");
        deleteadSpaceJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteadSpaceJButtonActionPerformed(evt);
            }
        });
        jPanel1.add(deleteadSpaceJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 316, -1, -1));

        viewadSpaceJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        viewadSpaceJButton.setText("View AdSpace Details >>");
        viewadSpaceJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewadSpaceJButtonActionPerformed(evt);
            }
        });
        jPanel1.add(viewadSpaceJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 389, -1, -1));

        createadSpaceJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        createadSpaceJButton.setText("Create AdSpace >>");
        createadSpaceJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createadSpaceJButtonActionPerformed(evt);
            }
        });
        jPanel1.add(createadSpaceJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 316, 193, -1));

        backJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        jPanel1.add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 400, 105, -1));

        displayAdvertiserJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Adv Name", "Bid Amount", "Adv Space", "Product Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(displayAdvertiserJTable);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 560, 476, 92));

        advertiserJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        advertiserJButton.setText("View Advertiser for an Adspace>>");
        advertiserJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                advertiserJButtonActionPerformed(evt);
            }
        });
        jPanel1.add(advertiserJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(222, 453, -1, 37));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 638, 758));
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        populateAdSpaceTable();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void deleteadSpaceJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteadSpaceJButtonActionPerformed
        int selectedRow = adSpaceCatalogJTable.getSelectedRow();
        if(selectedRow>=0){
            int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete", "Warning", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                Adspace adspace  =(Adspace)adSpaceCatalogJTable.getValueAt(selectedRow,0);
                publisher.getAdspaceCatalog().deleteAdspace(adspace);
                populateAdSpaceTable();
            }
        }
        else{
            JOptionPane.showMessageDialog(this,"Please select an AdSpace to delete");
        }
    }//GEN-LAST:event_deleteadSpaceJButtonActionPerformed

    private void viewadSpaceJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewadSpaceJButtonActionPerformed
        int selectedRow = adSpaceCatalogJTable.getSelectedRow();
        if(selectedRow<0){

            JOptionPane.showMessageDialog(null, "Please select an AdSpace to view");
            return;
        }
        Adspace adspace =(Adspace)adSpaceCatalogJTable.getValueAt(selectedRow, 0);
        ViewAdSpaceJPanel vajp = new ViewAdSpaceJPanel(userProcessContainer,adspace);
        userProcessContainer.add("ViewAdSpaceJPanel",vajp);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_viewadSpaceJButtonActionPerformed

    private void createadSpaceJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createadSpaceJButtonActionPerformed
        CreateNewAdSpaceJPanel cnajp = new CreateNewAdSpaceJPanel(userProcessContainer,publisher);
        userProcessContainer.add("CreateNewAdSpaceJPanel",cnajp);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_createadSpaceJButtonActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void advertiserJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_advertiserJButtonActionPerformed
        int selectedRow = adSpaceCatalogJTable.getSelectedRow();
        if(selectedRow<0){

            JOptionPane.showMessageDialog(null, "Please select an order to view OrderItem");
            return;
        }
        Adspace adspace = (Adspace) adSpaceCatalogJTable.getValueAt(selectedRow, 0);
        populateAdvertiserTable(adspace);
    }//GEN-LAST:event_advertiserJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable adSpaceCatalogJTable;
    private javax.swing.JButton advertiserJButton;
    private javax.swing.JButton backJButton;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton createadSpaceJButton;
    private javax.swing.JButton deleteadSpaceJButton;
    private javax.swing.JTable displayAdvertiserJTable;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel manageProductCatJLabel;
    private javax.swing.JLabel manageSuppJLabel;
    private javax.swing.JTextField txtName;
    private javax.swing.JButton viewadSpaceJButton;
    // End of variables declaration//GEN-END:variables
}
