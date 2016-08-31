/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.SupplierRole;

import Business.Product.Product;
import Business.Supplier.Supplier;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Sriram
 */
public class SearchForProductJPanel extends javax.swing.JPanel {

    JPanel userProcessContainer;
    Supplier supplier;
    public SearchForProductJPanel(JPanel upc, Supplier supplier) {
        initComponents();
        this.userProcessContainer=upc;
        this.supplier=supplier;
    }
    
    private Boolean validation() {
        if(idField.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Enter a product ID");
            return false;
        }
        String id = idField.getText();
        for(int i = 0; i <id.length();i++){
        char c = id.charAt(i);  
        if((c<48 || c>57))  {
         JOptionPane.showMessageDialog(null, "ID field should contain only number", "Mismatch", JOptionPane.WARNING_MESSAGE);
         return false;
        }
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        searchProductJLabel = new javax.swing.JLabel();
        productIdJLabel = new javax.swing.JLabel();
        idField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        backproductJButton = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchProductJLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        searchProductJLabel.setText("SEARCH FOR PRODUCT");
        add(searchProductJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, -1, 52));

        productIdJLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        productIdJLabel.setText("Product Id");
        add(productIdJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, -1, -1));

        idField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(idField, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, 202, -1));

        searchButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        searchButton.setText("Search Now >>");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });
        add(searchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 180, 160, -1));

        backproductJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        backproductJButton.setText("<< Back");
        backproductJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backproductJButtonActionPerformed(evt);
            }
        });
        add(backproductJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 270, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        
        Boolean flag = validation();
        if(flag) {
        int productId = Integer.parseInt(idField.getText());
        Product product = supplier.getProductCatalog().searchProduct(productId);
        if(product!=null){ 
        ViewProductDetailJPanel vpdjp = new ViewProductDetailJPanel(userProcessContainer, product);
        userProcessContainer.add("ViewProductDetailJPanelSupplier", vpdjp);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Enter a valid ProductId");
        }
        }
    }//GEN-LAST:event_searchButtonActionPerformed

    private void backproductJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backproductJButtonActionPerformed
        
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backproductJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backproductJButton;
    private javax.swing.JTextField idField;
    private javax.swing.JLabel productIdJLabel;
    private javax.swing.JButton searchButton;
    private javax.swing.JLabel searchProductJLabel;
    // End of variables declaration//GEN-END:variables
}
