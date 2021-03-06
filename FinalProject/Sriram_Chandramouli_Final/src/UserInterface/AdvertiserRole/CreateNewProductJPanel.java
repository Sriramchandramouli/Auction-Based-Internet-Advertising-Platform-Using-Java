/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.AdvertiserRole;

import Business.Advertiser.Advertiser;
import Business.Product.Product;
import java.awt.CardLayout;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Sriram
 */
public class CreateNewProductJPanel extends javax.swing.JPanel {

    JPanel userProcessContainer;
    Advertiser advertiser;
    String link, picture;
    
    public CreateNewProductJPanel(JPanel upc, Advertiser advertiser) {
        initComponents();
        this.userProcessContainer = upc;
        this.advertiser = advertiser;
    }
    
    private BufferedImage scaleImage(Image img, int width, int height) {
        BufferedImage scaledImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = scaledImage.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(img, 0, 0, width, height, null);
        g2.dispose();
        return scaledImage;
    }
    
    private String picture() throws IOException {
            File file = null;
            JFileChooser chooser = new JFileChooser();
            chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int status = chooser.showOpenDialog(CreateNewProductJPanel.this);
            if(status == JFileChooser.APPROVE_OPTION){
                file = chooser.getSelectedFile();
                
                picture = file.toString();
                System.out.println("Pic is" + picture);
            }
            if(status == JFileChooser.CANCEL_OPTION) {
                JOptionPane.showMessageDialog(null, "You havent attached any picture.");
                return null;
            }
            
            BufferedImage bi = scaleImage(ImageIO.read(file), imageJLabel.getWidth(), imageJLabel.getHeight());
            
            imageJLabel.setIcon(new ImageIcon(bi));
            return picture;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    private Boolean productValidation() {
        if(nameField1.getText().equals("") || priceField1.getText().equals("") || availabilityField1.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Fill in all the fields", "Empty Text", JOptionPane.WARNING_MESSAGE);
         return false;
        }
        String prodName = nameField1.getText();
        for(int i = 0; i <prodName.length();i++){
        char c = prodName.charAt(i);  
        if((c<97 || c>122) && (c<65 || c>90)) {
         JOptionPane.showMessageDialog(null, "Product Name field should contain only alphabet", "Mismatch", JOptionPane.WARNING_MESSAGE);
         return false;
        }
        }
        String prodPrice = priceField1.getText();
        for(int i = 0; i <prodPrice.length();i++){
        char c = prodPrice.charAt(i);  
        if((c!=46 && c<48) || c>57 ) {
         JOptionPane.showMessageDialog(null, "Product price should contain only number and dot", "Mismatch", JOptionPane.WARNING_MESSAGE);
         return false;
        }
        }
        String avail = availabilityField1.getText();
        for(int i = 0; i <avail.length();i++){
        char c = avail.charAt(i);  
        if((c<48 || c>57))  {
         JOptionPane.showMessageDialog(null, "Availability field should contain only number", "Mismatch", JOptionPane.WARNING_MESSAGE);
         return false;
        }
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        createProductNameJLabel = new javax.swing.JLabel();
        nameField1 = new javax.swing.JTextField();
        createProductIDJLabel = new javax.swing.JLabel();
        idField = new javax.swing.JTextField();
        createProductPriceJLabel = new javax.swing.JLabel();
        priceField1 = new javax.swing.JTextField();
        createAvailabilityJLabel = new javax.swing.JLabel();
        availabilityField1 = new javax.swing.JTextField();
        backJButton = new javax.swing.JButton();
        addProductJButton = new javax.swing.JButton();
        createProductNameJLabel1 = new javax.swing.JLabel();
        categoryJComboBox = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        imageJLabel = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Create New Product");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 11, -1, -1));

        createProductNameJLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        createProductNameJLabel.setText("Product Name:");
        add(createProductNameJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 145, -1, 30));

        nameField1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(nameField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(289, 146, 210, -1));

        createProductIDJLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        createProductIDJLabel.setText("Product ID:");
        add(createProductIDJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 193, 117, 30));

        idField.setEditable(false);
        idField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(idField, new org.netbeans.lib.awtextra.AbsoluteConstraints(289, 194, 210, -1));

        createProductPriceJLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        createProductPriceJLabel.setText("Product Price:");
        add(createProductPriceJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 234, 117, 30));

        priceField1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(priceField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(289, 234, 210, 30));

        createAvailabilityJLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        createAvailabilityJLabel.setText("Availability:");
        add(createAvailabilityJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 282, 116, 30));

        availabilityField1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(availabilityField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(289, 282, 210, 30));

        backJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 560, 116, 32));

        addProductJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        addProductJButton.setText("Add Product");
        addProductJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProductJButtonActionPerformed(evt);
            }
        });
        add(addProductJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(299, 560, -1, 32));

        createProductNameJLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        createProductNameJLabel1.setText("Category:");
        add(createProductNameJLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 94, 117, 30));

        categoryJComboBox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        categoryJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Gaming", "Watches", "Mobiles", "Shoes", "Television", "Sunglasses" }));
        categoryJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryJComboBoxActionPerformed(evt);
            }
        });
        add(categoryJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(289, 97, 210, 30));

        jButton1.setText("AddImage");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 369, 115, 34));
        add(imageJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(231, 369, 319, 153));
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void addProductJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProductJButtonActionPerformed
        Boolean flag = productValidation();
        if(flag) {
            Product product = advertiser.getProductCatalog().addProduct();
            String category = String.valueOf(categoryJComboBox.getSelectedItem());
            String prodName = nameField1.getText();
            Float prodPrice = Float.parseFloat(priceField1.getText());
            int availability = Integer.parseInt(availabilityField1.getText());
            product.setProductName(prodName);
            product.setPrice(prodPrice);
            product.setAvailability(availability);
            product.setProductName(nameField1.getText());
            product.setCategory(category);
            product.setProductImage(link);

            System.out.println("Pic in product is" + product.getProductImage());
            
            nameField1.setText("");
            priceField1.setText("");
            availabilityField1.setText("");
            imageJLabel.setText("");
            imageJLabel.setIcon(null);
            link = "";
            JOptionPane.showMessageDialog(null, "Product created successfully", "Success", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_addProductJButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            link = picture();
        } catch (IOException ex) {
            Logger.getLogger(CreateNewProductJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void categoryJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryJComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categoryJComboBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addProductJButton;
    private javax.swing.JTextField availabilityField1;
    private javax.swing.JButton backJButton;
    private javax.swing.JComboBox categoryJComboBox;
    private javax.swing.JLabel createAvailabilityJLabel;
    private javax.swing.JLabel createProductIDJLabel;
    private javax.swing.JLabel createProductNameJLabel;
    private javax.swing.JLabel createProductNameJLabel1;
    private javax.swing.JLabel createProductPriceJLabel;
    private javax.swing.JTextField idField;
    private javax.swing.JLabel imageJLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField nameField1;
    private javax.swing.JTextField priceField1;
    // End of variables declaration//GEN-END:variables
}
