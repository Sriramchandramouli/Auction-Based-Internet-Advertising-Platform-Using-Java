/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.AdvertiserRole;

import Business.Advertiser.Advertiser;
import Business.Product.Product;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sriram
 */
public class ManageProductJPanel extends javax.swing.JPanel {

    JPanel userProcessContainer;
    Advertiser advertiser;
    public ManageProductJPanel(JPanel upc, Advertiser advertiser) {
        initComponents();
        this.userProcessContainer = upc;
        this.advertiser = advertiser;
        txtName.setText(advertiser.getFirstName());
        populateAdProductTable();
    }
    
    private void populateAdProductTable(){
    DefaultTableModel dtm = (DefaultTableModel)adProductCatalog.getModel();
    dtm.setRowCount(0); 
    
    for(Product product : advertiser.getProductCatalog().getProductList()){
        Object row[]= new Object[3];
        row[0]= product;
        row[1]=product.getModelNumber();
        row[2]=product.getPrice();
        dtm.addRow(row);
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

        manageSuppJLabel = new javax.swing.JLabel();
        manageProductCatJLabel = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        btnRefresh = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        adProductCatalog = new javax.swing.JTable();
        deleteProductJButton = new javax.swing.JButton();
        createProductJButton = new javax.swing.JButton();
        backJButton = new javax.swing.JButton();

        manageSuppJLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        manageSuppJLabel.setText("Advertiser:");

        manageProductCatJLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        manageProductCatJLabel.setText("Manage Product Catalog");

        txtName.setEditable(false);
        txtName.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        txtName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtName.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, new java.awt.Color(102, 102, 102), null, null));

        btnRefresh.setText("Refresh");
        btnRefresh.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnRefresh.setMargin(new java.awt.Insets(2, 1, 2, 1));
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        adProductCatalog.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        adProductCatalog.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Name", "Product ID", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(adProductCatalog);

        deleteProductJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        deleteProductJButton.setText("Delete Product(s)");
        deleteProductJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteProductJButtonActionPerformed(evt);
            }
        });

        createProductJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        createProductJButton.setText("Create New Product >>");
        createProductJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createProductJButtonActionPerformed(evt);
            }
        });

        backJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(manageProductCatJLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(manageSuppJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(deleteProductJButton)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(createProductJButton)))
                            .addComponent(backJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(123, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(manageProductCatJLabel)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(manageSuppJLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addComponent(btnRefresh)
                .addGap(7, 7, 7)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteProductJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(createProductJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(89, 89, 89)
                .addComponent(backJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        populateAdProductTable();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void deleteProductJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteProductJButtonActionPerformed
        int selectedRow = adProductCatalog.getSelectedRow();
        if(selectedRow>=0){
            int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete", "Warning", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                Product product  =(Product)adProductCatalog.getValueAt(selectedRow,0);
                advertiser.getProductCatalog().deleteProduct(product);
                populateAdProductTable();
            }
        }
        else{
            JOptionPane.showMessageDialog(this,"Please select a product to delete");
        }
    }//GEN-LAST:event_deleteProductJButtonActionPerformed

    private void createProductJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createProductJButtonActionPerformed
        CreateNewProductJPanel cnpjp1 = new CreateNewProductJPanel(userProcessContainer,advertiser);
        userProcessContainer.add("CreateProducts",cnpjp1);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_createProductJButtonActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable adProductCatalog;
    private javax.swing.JButton backJButton;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton createProductJButton;
    private javax.swing.JButton deleteProductJButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel manageProductCatJLabel;
    private javax.swing.JLabel manageSuppJLabel;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}