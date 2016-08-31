/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.ConsumerRole;

import Business.Consumer.Consumer;
import Business.Consumer.ViewHistoryList;
import Business.Order.MasterOrderCatalog;
import Business.Organization.PublisherOrganization;
import Business.Supplier.SupplierDirectory;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.AdExchangeRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Sriram
 */
public class ConsumerWorkAreaJPanel extends javax.swing.JPanel {

    
    JPanel userProcessContainer;
    SupplierDirectory supplierDirectory;
    MasterOrderCatalog masterOrderCatalog;
    Consumer consumer;
    PublisherOrganization publisherOrganization;
    AdExchangeRequest aer,aer1,aer2,aer3;
    UserAccount userAccount;
    ViewHistoryList viewHistoryList;
    
    public ConsumerWorkAreaJPanel(JPanel upc, SupplierDirectory supplierDirectory, MasterOrderCatalog masterOrderCatalog, Consumer consumer, PublisherOrganization publisherOrganization, UserAccount userAccount, ViewHistoryList viewHistoryList) throws IOException {
        initComponents();
        this.userProcessContainer = upc;
        this.supplierDirectory = supplierDirectory;
        this.masterOrderCatalog = masterOrderCatalog;
        this.consumer = consumer;
        this.publisherOrganization = publisherOrganization;
        this.userAccount = userAccount;
        this.viewHistoryList = viewHistoryList;
     //   populateTopAdvertisement();
     //   populateBottomAdvertisement();
        populateFavCategory1Advertisement();
        populateFavCategory2Advertisement();
        populateFavCategory3Advertisement();
        populateMostFavouriteCategory();
        
     //   if(aer!=null && aer1!=null && aer2!=null) {
     //   populateMostFavouriteCategory(aer,aer1,aer2);
     //   }
    }
    
    private void populateFavCategory1Advertisement() throws IOException {
        
        try {
        float maxVal = 0;
        for (WorkRequest workRequest : publisherOrganization.getWorkQueue().getWorkRequestList()) {
            AdExchangeRequest req = (AdExchangeRequest) workRequest;
            if((req.getAdSpace().getSpaceName().equals("FrontPageAdvertisement")) && (req.getEnrollResult().equals("Approved"))) {
            if(req.getAdvertisement().getProduct().getCategory().equals(consumer.getCategory1())&& (req.getEnrollResult().equals("Approved"))) {
               
                if (req.getBidRate() > maxVal) {
                    maxVal = (float) req.getBidRate();
                    aer = req;
                    
                    System.out.println("The maxval is" + maxVal);
                    System.out.println("The maxval is" + aer.getAdvertisement().getName());
                    System.out.println("link in CWA1 is" + aer.getAdvertisement().getProduct().getProductImage());
                }
            }
            }
        }
        String fileLoc = aer.getAdvertisement().getProduct().getProductImage();
        File file = new File(fileLoc);
        BufferedImage bi = aer.getAdvertisement().getProduct().scaleImage(ImageIO.read(file), 177, 177);
        category1JLabel.setIcon(new ImageIcon(bi));
        //category1JLabel.setText(String.valueOf(aer.getAdvertisement().getAd()));
        } catch(NullPointerException e)
        {
            System.out.print("NullPointerException caught");
        }
    }
    
    private void populateFavCategory2Advertisement() throws IOException {
        
        try {
        float maxVal = 0;
        for (WorkRequest workRequest : publisherOrganization.getWorkQueue().getWorkRequestList()) {
            AdExchangeRequest req = (AdExchangeRequest) workRequest;
            if((req.getAdSpace().getSpaceName().equals("FrontPageAdvertisement")) && (req.getEnrollResult().equals("Approved"))) {
            if(req.getAdvertisement().getProduct().getCategory().equals(consumer.getCategory2())&& (req.getEnrollResult().equals("Approved"))) {
               
                if (req.getBidRate() > maxVal) {
                    maxVal = (float) req.getBidRate();
                    aer1 = req;
                    
                    System.out.println("The maxval is" + maxVal);
                    System.out.println("The maxval is" + aer1.getAdvertisement().getName());
                    System.out.println("link in CWA2 is" + aer1.getAdvertisement().getProduct().getProductImage());
                }
            }
            }
        }
        String fileLoc = aer1.getAdvertisement().getProduct().getProductImage();
        File file = new File(fileLoc);
        BufferedImage bi = aer1.getAdvertisement().getProduct().scaleImage(ImageIO.read(file), 177, 177);
        category2JLabel.setIcon(new ImageIcon(bi));
    //    category2JLabel.setText(String.valueOf(aer1.getAdvertisement().getAd()));
        } catch(NullPointerException e)
        {
            System.out.print("NullPointerException caught");
        }
    }
    
    private void populateFavCategory3Advertisement() throws IOException {
        
        try {
        float maxVal = 0;
        for (WorkRequest workRequest : publisherOrganization.getWorkQueue().getWorkRequestList()) {
            AdExchangeRequest req = (AdExchangeRequest) workRequest;
            if((req.getAdSpace().getSpaceName().equals("FrontPageAdvertisement")) && (req.getEnrollResult().equals("Approved"))) {
            if(req.getAdvertisement().getProduct().getCategory().equals(consumer.getCategory3())&& (req.getEnrollResult().equals("Approved"))) {
               
                if (req.getBidRate() > maxVal) {
                    maxVal = (float) req.getBidRate();
                    aer2 = req;
                    
                    System.out.println("The maxval is" + maxVal);
                    System.out.println("The maxval is" + aer2.getAdvertisement().getName());
                    System.out.println("link in CWA3 is" + aer2.getAdvertisement().getProduct().getProductImage());
                }
            }
            }
        }
        String fileLoc = aer2.getAdvertisement().getProduct().getProductImage();
        File file = new File(fileLoc);
        BufferedImage bi = aer2.getAdvertisement().getProduct().scaleImage(ImageIO.read(file), 177, 177);
        category3JLabel.setIcon(new ImageIcon(bi));
        //category3JLabel.setText(String.valueOf(aer2.getAdvertisement().getAd()));
        } catch(NullPointerException e)
        {
            System.out.print("NullPointerException caught");
        }
    }
    
   /* private void populateMostFavouriteCategory(AdExchangeRequest aer, AdExchangeRequest aer1, AdExchangeRequest aer2) throws IOException {
        
        try {
        if ((aer.getBidRate() > aer1.getBidRate()) && (aer.getBidRate() > aer2.getBidRate())) {
            
            String fileLoc = aer.getAdvertisement().getProduct().getProductImage();
             File file = new File(fileLoc);
             BufferedImage bi = aer.getAdvertisement().getProduct().scaleImage(ImageIO.read(file), 177, 177);
            topPageAdvJLabel.setIcon(new ImageIcon(bi));
         //   topPageAdvJLabel.setText(String.valueOf(aer.getAdvertisement().getAd()));
            aer3 = aer;
            
        } else if ((aer1.getBidRate() > aer.getBidRate()) && (aer1.getBidRate() > aer2.getBidRate())) {
           
            String fileLoc = aer1.getAdvertisement().getProduct().getProductImage();
             File file = new File(fileLoc);
             BufferedImage bi = aer1.getAdvertisement().getProduct().scaleImage(ImageIO.read(file), 177, 177);
            topPageAdvJLabel.setIcon(new ImageIcon(bi));
       //     topPageAdvJLabel.setText(String.valueOf(aer1.getAdvertisement().getAd()));
       //     topPageAdvJLabel.setText(String.valueOf(aer1.getAdvertisement().getAd()));
            aer3 = aer1;
            
        } else if ((aer2.getBidRate() > aer.getBidRate()) && (aer2.getBidRate() > aer1.getBidRate())) {
            
            String fileLoc = aer2.getAdvertisement().getProduct().getProductImage();
             File file = new File(fileLoc);
             BufferedImage bi = aer2.getAdvertisement().getProduct().scaleImage(ImageIO.read(file), 177, 177);
            topPageAdvJLabel.setIcon(new ImageIcon(bi));
        //    topPageAdvJLabel.setText(String.valueOf(aer2.getAdvertisement().getAd()));
          //  topPageAdvJLabel.setText(String.valueOf(aer2.getAdvertisement().getAd()));
            aer3 = aer2;
            
        }
        } catch(NullPointerException e)
        {
            System.out.print("NullPointerException caught");
        }
    } */
    
    private void populateMostFavouriteCategory() throws IOException {
        
        try {
        float maxVal = 0;
        for (WorkRequest workRequest : publisherOrganization.getWorkQueue().getWorkRequestList()) {
            AdExchangeRequest req = (AdExchangeRequest) workRequest;
            if((req.getAdSpace().getSpaceName().equals("FrontPageAdvertisement")) && (req.getEnrollResult().equals("Approved"))) {
    //        if(req.getAdvertisement().getProduct().getCategory().equals(consumer.getCategory3())&& (req.getEnrollResult().equals("Approved"))) {
               
                if (req.getBidRate() > maxVal) {
                    maxVal = (float) req.getBidRate();
                    aer3 = req;
                    
                    System.out.println("The maxval is" + maxVal);
                    System.out.println("The maxval is" + aer3.getAdvertisement().getName());
                }
      //      }
            }
        }
        String fileLoc = aer3.getAdvertisement().getProduct().getProductImage();
        File file = new File(fileLoc);
        BufferedImage bi = aer3.getAdvertisement().getProduct().scaleImage(ImageIO.read(file), 177, 177);
        topPageAdvJLabel.setIcon(new ImageIcon(bi));
      //  favCat3JLabel.setText(String.valueOf(aer2.getAdvertisement().getAd()));
        } catch(NullPointerException e)
        {
            System.out.print("NullPointerException caught");
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

        browseProductJButton = new javax.swing.JButton();
        viewOrderJButton = new javax.swing.JButton();
        topPageAdvJLabel = new javax.swing.JLabel();
        category1JLabel = new javax.swing.JLabel();
        category3JLabel = new javax.swing.JLabel();
        category2JLabel = new javax.swing.JLabel();
        viewProductDetailJLabel = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        browseProductJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        browseProductJButton.setText("BrowseProductCatalog >>");
        browseProductJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseProductJButtonActionPerformed(evt);
            }
        });
        add(browseProductJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 295, 45));

        viewOrderJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        viewOrderJButton.setText("ViewOrderDetails >>");
        viewOrderJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewOrderJButtonActionPerformed(evt);
            }
        });
        add(viewOrderJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 297, 295, 45));

        topPageAdvJLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        topPageAdvJLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                topPageAdvJLabelMouseClicked(evt);
            }
        });
        add(topPageAdvJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 190, 120));

        category1JLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        category1JLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                category1JLabelMouseClicked(evt);
            }
        });
        add(category1JLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 180, 160, 120));

        category3JLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        category3JLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                category3JLabelMouseClicked(evt);
            }
        });
        add(category3JLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 400, 180, 120));

        category2JLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        category2JLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                category2JLabelMouseClicked(evt);
            }
        });
        add(category2JLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 340, 180, 140));

        viewProductDetailJLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        viewProductDetailJLabel.setText("CUSTOMER WORKAREA PANEL");
        add(viewProductDetailJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 14, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void browseProductJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseProductJButtonActionPerformed
      // try {
        
               if (supplierDirectory ==null) {
                  
                   JOptionPane.showMessageDialog(null, "Please create a supplier before proceeding");
             
               } else {
           
        BrowseProductJPanel bpj = null;
                   try {
                       bpj = new BrowseProductJPanel(userProcessContainer,consumer,supplierDirectory,masterOrderCatalog, viewHistoryList, publisherOrganization, userAccount);
                   } catch (IOException ex) {
                       Logger.getLogger(ConsumerWorkAreaJPanel.class.getName()).log(Level.SEVERE, null, ex);
                   }
        userProcessContainer.add("BrowseProductJPanel",bpj);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
               }
       
    //   } catch(NullPointerException e)
    //    {
    //        System.out.print("NullPointerException caught");
    //    }
    }//GEN-LAST:event_browseProductJButtonActionPerformed

    private void viewOrderJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewOrderJButtonActionPerformed
        ViewOrderHistoryJPanel vojp = new ViewOrderHistoryJPanel(userProcessContainer,masterOrderCatalog,consumer);
        userProcessContainer.add("ViewOrderHistory",vojp);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_viewOrderJButtonActionPerformed

    private void topPageAdvJLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topPageAdvJLabelMouseClicked
        PurchaseProductJPanel ppjp = null;
        try {
            ppjp = new PurchaseProductJPanel(userProcessContainer,masterOrderCatalog,aer3,userAccount,consumer);
        } catch (IOException ex) {
            Logger.getLogger(ConsumerWorkAreaJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        userProcessContainer.add("PurchaseProduct1Panel",ppjp);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_topPageAdvJLabelMouseClicked

    private void category3JLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_category3JLabelMouseClicked
        PurchaseProductJPanel ppjp4 = null;
        try {
            ppjp4 = new PurchaseProductJPanel(userProcessContainer,masterOrderCatalog,aer2,userAccount,consumer);
        } catch (IOException ex) {
            Logger.getLogger(ConsumerWorkAreaJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        userProcessContainer.add("PurchaseProduct4Panel",ppjp4);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_category3JLabelMouseClicked

    private void category1JLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_category1JLabelMouseClicked
        PurchaseProductJPanel ppjp2 = null;
        try {
            ppjp2 = new PurchaseProductJPanel(userProcessContainer,masterOrderCatalog,aer,userAccount,consumer);
        } catch (IOException ex) {
            Logger.getLogger(ConsumerWorkAreaJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        userProcessContainer.add("PurchaseProduct2Panel",ppjp2);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_category1JLabelMouseClicked

    private void category2JLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_category2JLabelMouseClicked
        PurchaseProductJPanel ppjp3 = null;
        try {
            ppjp3 = new PurchaseProductJPanel(userProcessContainer,masterOrderCatalog,aer1,userAccount,consumer);
        } catch (IOException ex) {
            Logger.getLogger(ConsumerWorkAreaJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        userProcessContainer.add("PurchaseProduct3Panel",ppjp3);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_category2JLabelMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton browseProductJButton;
    private javax.swing.JLabel category1JLabel;
    private javax.swing.JLabel category2JLabel;
    private javax.swing.JLabel category3JLabel;
    private javax.swing.JLabel topPageAdvJLabel;
    private javax.swing.JButton viewOrderJButton;
    private javax.swing.JLabel viewProductDetailJLabel;
    // End of variables declaration//GEN-END:variables
}
