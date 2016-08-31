/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.SupplierRole;

import Business.Product.Product;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author Sriram
 */
public class ViewProductDetailJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ViewProductDetailJPanel
     */
    JPanel userProcessContainer;
    Product product;
    public ViewProductDetailJPanel(JPanel upc, Product product) {
        initComponents();
        this.userProcessContainer=upc;
        this.product=product;
        populateProductDetail(product);
    }
    
    private void populateProductDetail(Product product) {
        nameField.setText(product.getProductName());
        idField.setText(String.valueOf(product.getModelNumber()));
        priceField.setText(String.valueOf(product.getPrice()));
        availabilityField.setText(String.valueOf(product.getAvailability()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nameField = new javax.swing.JTextField();
        viewProductDetailJLabel = new javax.swing.JLabel();
        productIdJLabel = new javax.swing.JLabel();
        productPriceJLabel = new javax.swing.JLabel();
        productAvailabilityJLabel = new javax.swing.JLabel();
        availabilityField = new javax.swing.JTextField();
        priceField = new javax.swing.JTextField();
        idField = new javax.swing.JTextField();
        productNameJLabel = new javax.swing.JLabel();
        backJButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        updateJButton = new javax.swing.JButton();

        nameField.setEditable(false);
        nameField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nameField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        viewProductDetailJLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        viewProductDetailJLabel.setText("VIEW PRODUCT DETAIL");

        productIdJLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        productIdJLabel.setText("Product ID:");

        productPriceJLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        productPriceJLabel.setText("Product Price:");

        productAvailabilityJLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        productAvailabilityJLabel.setText("Availability:");

        availabilityField.setEditable(false);
        availabilityField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        availabilityField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        priceField.setEditable(false);
        priceField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        priceField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        idField.setEditable(false);
        idField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        idField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        productNameJLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        productNameJLabel.setText("Product Name:");

        backJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        saveButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        saveButton.setText("SAVE");
        saveButton.setEnabled(false);
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        updateJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        updateJButton.setText("Update Product");
        updateJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(productNameJLabel)
                        .addGap(63, 63, 63)
                        .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(productIdJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63)
                        .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(backJButton)
                                .addGap(58, 58, 58)
                                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(updateJButton))
                            .addComponent(productAvailabilityJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(productPriceJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(availabilityField, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(priceField, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(128, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(viewProductDetailJLabel)
                .addGap(184, 184, 184))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(viewProductDetailJLabel)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(productNameJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(productIdJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(productPriceJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(priceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productAvailabilityJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(availabilityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(131, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed

        product.setPrice(Float.parseFloat(priceField.getText()));
        product.setProductName(nameField.getText());
        product.setAvailability(Integer.parseInt(availabilityField.getText()));
        nameField.setEditable(false);
        priceField.setEditable(false);
        availabilityField.setEditable(false);
        saveButton.setEnabled(false);
    }//GEN-LAST:event_saveButtonActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
       userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void updateJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateJButtonActionPerformed
        nameField.setEditable(true);
        priceField.setEditable(true);
        availabilityField.setEditable(true);
        saveButton.setEnabled(true);
    }//GEN-LAST:event_updateJButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField availabilityField;
    private javax.swing.JButton backJButton;
    private javax.swing.JTextField idField;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField priceField;
    private javax.swing.JLabel productAvailabilityJLabel;
    private javax.swing.JLabel productIdJLabel;
    private javax.swing.JLabel productNameJLabel;
    private javax.swing.JLabel productPriceJLabel;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton updateJButton;
    private javax.swing.JLabel viewProductDetailJLabel;
    // End of variables declaration//GEN-END:variables
}
