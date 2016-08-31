/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.ConsumerRole;

import Business.Product.Product;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author Sriram
 */
public class ViewProductDetailJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Product product;
    public ViewProductDetailJPanel(JPanel upc, Product product) {
        initComponents();
        this.userProcessContainer=upc;
        this.product=product;
        
        poplateProductDetails();
        
    }
    
    private void poplateProductDetails() {
        nameField1.setText(product.getProductName());
        idField.setText(String.valueOf(product.getModelNumber()));
        priceField.setText(String.valueOf(product.getPrice()));
        availabilityJTextField.setText(String.valueOf(product.getAvailability()));
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        prodNameJLabel = new javax.swing.JLabel();
        nameField1 = new javax.swing.JTextField();
        idField = new javax.swing.JTextField();
        prodIdJLabel = new javax.swing.JLabel();
        prodPriceJLabel = new javax.swing.JLabel();
        priceField = new javax.swing.JTextField();
        availabilityJLabel = new javax.swing.JLabel();
        backButton1 = new javax.swing.JButton();
        viewProductDetailJLabel = new javax.swing.JLabel();
        availabilityJTextField = new javax.swing.JTextField();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        prodNameJLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        prodNameJLabel.setText("Product Name:");
        add(prodNameJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, -1, 30));

        nameField1.setEditable(false);
        nameField1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nameField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameField1ActionPerformed(evt);
            }
        });
        add(nameField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 80, 210, -1));

        idField.setEditable(false);
        idField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(idField, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 140, 210, -1));

        prodIdJLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        prodIdJLabel.setText("Product ID:");
        add(prodIdJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 117, 30));

        prodPriceJLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        prodPriceJLabel.setText("Product Price:");
        add(prodPriceJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 117, 30));

        priceField.setEditable(false);
        priceField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(priceField, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 210, 208, 30));

        availabilityJLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        availabilityJLabel.setText("Availability:");
        add(availabilityJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 290, 117, -1));

        backButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        backButton1.setText("<< Back");
        backButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButton1ActionPerformed(evt);
            }
        });
        add(backButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 390, -1, -1));

        viewProductDetailJLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        viewProductDetailJLabel.setText("VIEW PRODUCT DETAIL");
        add(viewProductDetailJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, -1, -1));

        availabilityJTextField.setEditable(false);
        availabilityJTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(availabilityJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 280, 208, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void backButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButton1ActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
     
    }//GEN-LAST:event_backButton1ActionPerformed

    private void nameField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameField1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel availabilityJLabel;
    private javax.swing.JTextField availabilityJTextField;
    private javax.swing.JButton backButton1;
    private javax.swing.JTextField idField;
    private javax.swing.JTextField nameField1;
    private javax.swing.JTextField priceField;
    private javax.swing.JLabel prodIdJLabel;
    private javax.swing.JLabel prodNameJLabel;
    private javax.swing.JLabel prodPriceJLabel;
    private javax.swing.JLabel viewProductDetailJLabel;
    // End of variables declaration//GEN-END:variables
}
