/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.SupplierRole;

import Business.Product.Product;
import Business.Supplier.Supplier;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sriram
 */
public class ManageProductCatalogJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageProductCatalogJPanel
     */
    JPanel userProcessContainer;
    Supplier supplier;
    public ManageProductCatalogJPanel(JPanel upc, Supplier supplier) {
        initComponents();
        this.userProcessContainer=upc;
        this.supplier=supplier;
        txtName.setText(supplier.getFirstName());
    }
    
    private void populateTable(){
    DefaultTableModel dtm = (DefaultTableModel)productCatalogJTable.getModel();
    dtm.setRowCount(0); 
    
    for(Product product : supplier.getProductCatalog().getProductList()){
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

        btnSearch = new javax.swing.JButton();
        manageProductCatJLabel = new javax.swing.JLabel();
        manageSuppJLabel = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        btnRefresh = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        productCatalogJTable = new javax.swing.JTable();
        deleteProductJButton = new javax.swing.JButton();
        viewProductJButton = new javax.swing.JButton();
        createProductJButton = new javax.swing.JButton();
        backJButton = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSearch.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSearch.setText("Search For Product>>");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, 210, -1));

        manageProductCatJLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        manageProductCatJLabel.setText("MANAGE PRODUCT CATALOG");
        add(manageProductCatJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 11, -1, -1));

        manageSuppJLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        manageSuppJLabel.setText("Supplier:");
        add(manageSuppJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 51, 170, -1));

        txtName.setEditable(false);
        txtName.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        txtName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtName.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, new java.awt.Color(102, 102, 102), null, null));
        add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 71, 150, 30));

        btnRefresh.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnRefresh.setText("Refresh");
        btnRefresh.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnRefresh.setMargin(new java.awt.Insets(2, 1, 2, 1));
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });
        add(btnRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 360, 120, 30));

        productCatalogJTable.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        productCatalogJTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(productCatalogJTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 480, 110));

        deleteProductJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        deleteProductJButton.setText("Delete Product(s)");
        deleteProductJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteProductJButtonActionPerformed(evt);
            }
        });
        add(deleteProductJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 298, -1, -1));

        viewProductJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        viewProductJButton.setText("View Product Details >>");
        viewProductJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewProductJButtonActionPerformed(evt);
            }
        });
        add(viewProductJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(368, 298, -1, -1));

        createProductJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        createProductJButton.setText("Create New Product >>");
        createProductJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createProductJButtonActionPerformed(evt);
            }
        });
        add(createProductJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(368, 358, -1, -1));

        backJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 418, 116, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        SearchForProductJPanel spjp = new SearchForProductJPanel(userProcessContainer,supplier);
        userProcessContainer.add("SearchForProductJPanel",spjp);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        populateTable();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void viewProductJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewProductJButtonActionPerformed
        int selectedRow = productCatalogJTable.getSelectedRow();
        if(selectedRow<0){

            JOptionPane.showMessageDialog(null, "Please select a product to view");
            return;
        }
        Product product =(Product)productCatalogJTable.getValueAt(selectedRow, 0);
        ViewProductDetailJPanel vpdj = new ViewProductDetailJPanel(userProcessContainer,product);
        userProcessContainer.add("ViewProductDetailJPanel",vpdj);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_viewProductJButtonActionPerformed

    private void deleteProductJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteProductJButtonActionPerformed
        int selectedRow = productCatalogJTable.getSelectedRow();
        if(selectedRow>=0){
            int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete", "Warning", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                Product product  =(Product)productCatalogJTable.getValueAt(selectedRow,0);
                supplier.getProductCatalog().deleteProduct(product);
                populateTable();
            }
        }
        else{
            JOptionPane.showMessageDialog(this,"Please select a product to delete");
        }
    }//GEN-LAST:event_deleteProductJButtonActionPerformed

    private void createProductJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createProductJButtonActionPerformed
        CreateNewProductJPanel cnjp = new CreateNewProductJPanel(userProcessContainer,supplier);
        userProcessContainer.add("CreateNewProductsJPanel",cnjp);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_createProductJButtonActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
       userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton createProductJButton;
    private javax.swing.JButton deleteProductJButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel manageProductCatJLabel;
    private javax.swing.JLabel manageSuppJLabel;
    private javax.swing.JTable productCatalogJTable;
    private javax.swing.JTextField txtName;
    private javax.swing.JButton viewProductJButton;
    // End of variables declaration//GEN-END:variables
}
