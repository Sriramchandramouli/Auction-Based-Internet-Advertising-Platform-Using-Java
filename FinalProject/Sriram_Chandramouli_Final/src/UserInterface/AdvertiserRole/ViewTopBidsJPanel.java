/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.AdvertiserRole;

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
public class ViewTopBidsJPanel extends javax.swing.JPanel {

    JPanel userProcessContainer;
    PublisherOrganization publisherOrganization;
    AdExchangeRequest aer;
    
    public ViewTopBidsJPanel(JPanel upc, PublisherOrganization publisherOrganization) {
        initComponents();
        this.userProcessContainer = upc;
        this.publisherOrganization = publisherOrganization;
        
        populateAdspaces();
        //populateTopBids();
    }
    
    private void populateAdspaces() {
        
        DefaultTableModel dtm = (DefaultTableModel) topBidJTable.getModel();
        dtm.setRowCount(0);
        
        for (Publisher publisher : publisherOrganization.getPublisherDirectory().getPublisherList()) {
            for (Adspace adspace : publisher.getAdspaceCatalog().getAdspaceList()) {
            Object row[] = new Object[3];
                   row[0] = publisher;
                   row[1] = adspace;
                   dtm.addRow(row);
                           
          }
            
        }
        
    }
    
    /*private void populateTopBids() {
        
        int selectedRow = topBidJTable.getSelectedRow();
        if(selectedRow<0){

            JOptionPane.showMessageDialog(null, "Please select a publisher to view");
            return;
        }
        
        Publisher publisher = (Publisher) topBidJTable.getValueAt(selectedRow, 0);
            float maxVal = 0;
        for(WorkRequest wr : publisherOrganization.getWorkQueue().getWorkRequestList()) {
            AdExchangeRequest req = (AdExchangeRequest) wr;
            if(req.getPublisher().equals(publisher)) {
                System.out.println("The val of pub is" + req.getPublisher());
                System.out.println("The val of pub is" + publisher);
            for (Adspace adspace : publisher.getAdspaceCatalog().getAdspaceList()) {
                
           //     if ((req.getAdSpace().getSpaceName().equals(adspace.getSpaceName())) && (req.getBidRate() > maxVal)) {
                 if ((req.getAdSpace().getSpaceName().equals("FrontPageAdvertisment")) && (adspace.getSpaceName().equals("FrontPageAdvertisment"))) {
                  
                     if (req.getBidRate() > maxVal) {
                     
             //      System.out.println("The val of space is" + req.getAdSpace()); 
             //      System.out.println("The val of space is" + adspace); 
                    maxVal = req.getBidRate();
                        aer = req;
                        jTextField1.setText(String.valueOf(aer.getBidRate()));
                     } 
                         
                    
                    }
                }
                
            }
            
            }
        }*/
    
    
 /*   private void populateTopBids() {
       
        DefaultTableModel dtm = (DefaultTableModel) topBidJTable.getModel();
        dtm.setRowCount(0);
        
        float maxVal = 0;
        for(WorkRequest wr : publisherOrganization.getWorkQueue().getWorkRequestList()) {
                AdExchangeRequest req = (AdExchangeRequest) wr;
               for (Publisher publisher : publisherOrganization.getPublisherDirectory().getPublisherList()) {
                for (Adspace adspace : publisher.getAdspaceCatalog().getAdspaceList()) {
                    if ((req.getAdSpace().equals(adspace)) && (req.getBidRate() > maxVal)) {
                        
                        System.out.println("The val of req is" + req.getBidRate());
                        maxVal = req.getBidRate();
                        aer = req;
                        System.out.println("The val of aer is" + aer.getBidRate());
                        Object row[] = new Object[3];
                        row[0] = adspace.getSpaceName();
                        row[1] = aer.getBidRate();
                        row[2] = aer.getAdvertisement();
                        dtm.addRow(row);
                    }
                }
                
                    }
        }
    }*/
    
    private void populateTopBids() {
        
        bidAmountJTextField.setText("");
        bidderNameJTextField.setText("");
        int selectedRow = topBidJTable.getSelectedRow();
        if(selectedRow<0){

            JOptionPane.showMessageDialog(null, "Please select a publisher to view");
            return;
        }
        
       Publisher publisher = (Publisher) topBidJTable.getValueAt(selectedRow, 0);
            float maxVal = 0;
        for(WorkRequest wr : publisherOrganization.getWorkQueue().getWorkRequestList()) {
            AdExchangeRequest req = (AdExchangeRequest) wr;
            if(req.getPublisher().equals(publisher)) {
                System.out.println("The val of pub is" + req.getPublisher());
                System.out.println("The val of pub is" + publisher);
            for (Adspace adspace : publisher.getAdspaceCatalog().getAdspaceList()) {
                
           //     if ((req.getAdSpace().getSpaceName().equals(adspace.getSpaceName())) && (req.getBidRate() > maxVal)) {
                 if (req.getAdSpace().getSpaceName().equals(adspace.getSpaceName())){
                     if (req.getBidRate() > maxVal) {
                     
             //      System.out.println("The val of space is" + req.getAdSpace()); 
             //      System.out.println("The val of space is" + adspace); 
                    maxVal = req.getBidRate();
                        aer = req;
                        bidAmountJTextField.setText(String.valueOf(aer.getBidRate()));
                        bidderNameJTextField.setText(aer.getSender().getPerson().getFirstName());
                     }
                }
                
            }
            
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

        jScrollPane1 = new javax.swing.JScrollPane();
        topBidJTable = new javax.swing.JTable();
        topbidJButton = new javax.swing.JButton();
        bidAmountJTextField = new javax.swing.JTextField();
        viewProductDetailJLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        bidderNameJTextField = new javax.swing.JTextField();
        backJButton = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        topBidJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "AdSpace Name", "Advertiser Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(topBidJTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 123, 376, 94));

        topbidJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        topbidJButton.setText("Top Bid >>");
        topbidJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                topbidJButtonActionPerformed(evt);
            }
        });
        add(topbidJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 250, 170, 33));

        bidAmountJTextField.setEditable(false);
        bidAmountJTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(bidAmountJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 320, 130, 33));

        viewProductDetailJLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        viewProductDetailJLabel.setText("VIEW TOP BIDS PANEL");
        add(viewProductDetailJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Bid Amount");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 320, 100, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Bidder Name");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 384, 110, 30));

        bidderNameJTextField.setEditable(false);
        bidderNameJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bidderNameJTextFieldActionPerformed(evt);
            }
        });
        add(bidderNameJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 380, 130, 30));

        backJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        backJButton.setText("<<Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 450, 110, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void topbidJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_topbidJButtonActionPerformed
        populateTopBids();
    }//GEN-LAST:event_topbidJButtonActionPerformed

    private void bidderNameJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bidderNameJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bidderNameJTextFieldActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JTextField bidAmountJTextField;
    private javax.swing.JTextField bidderNameJTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable topBidJTable;
    private javax.swing.JButton topbidJButton;
    private javax.swing.JLabel viewProductDetailJLabel;
    // End of variables declaration//GEN-END:variables
}
