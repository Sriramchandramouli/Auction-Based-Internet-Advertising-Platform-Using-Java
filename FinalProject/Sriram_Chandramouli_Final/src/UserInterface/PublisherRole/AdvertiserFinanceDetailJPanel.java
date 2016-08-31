/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.PublisherRole;

import Business.Advertiser.AdvertiserDirectory;
import Business.Organization.PublisherOrganization;
import Business.Publisher.Publisher;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.AdExchangeRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sriram
 */
public class AdvertiserFinanceDetailJPanel extends javax.swing.JPanel {

    JPanel userProcessContainer;
    AdvertiserDirectory advertiserDirectory;
    Publisher publisher;
    PublisherOrganization publisherOrganization;
    WorkRequest workRequest,workRequest2;
    UserAccount userAccount;
    float maxVal = 0;
    float secMaxVal = 0;
        
    public AdvertiserFinanceDetailJPanel(JPanel upc, AdvertiserDirectory advertiserDirectory, Publisher publisher, PublisherOrganization publisherOrganization, UserAccount userAccount) {
        initComponents();
        this.userProcessContainer = upc;
        this.advertiserDirectory = advertiserDirectory;
        this.publisher = publisher;
        this.publisherOrganization = publisherOrganization;
        this.userAccount = userAccount;
        populateTopAdv();
        
        JLabel.setText(workRequest.getSender().getPerson().getFirstName());
        adv2JLabel.setText(workRequest2.getSender().getPerson().getFirstName());
        topAdvJTextField.setText(String.valueOf(maxVal));
        
        secTopJTextField.setText(String.valueOf(secMaxVal));
        
        topproductJTextField.setText(workRequest.getSender().getPerson().getFirstName());
        product2JTextField.setText(workRequest2.getSender().getPerson().getFirstName());
        pubBalanceJTextField.setText(String.valueOf(userAccount.getFinanceDetail().getBalance()));
    }
    
    private void populateTopAdv() {
        int count = 0;
        for (WorkRequest wr : publisherOrganization.getWorkQueue().getWorkRequestList()) {
            AdExchangeRequest req = (AdExchangeRequest) wr;
            if(count == 0){
            if (wr.getSender().getFinanceDetail().getBalance() > maxVal) {
                maxVal = wr.getSender().getFinanceDetail().getBalance();
                workRequest = wr;   
                count++;
            }
            
            }
            else {
                if (wr.getSender().getFinanceDetail().getBalance() > maxVal) {
                    secMaxVal = maxVal;
                    maxVal = wr.getSender().getFinanceDetail().getBalance();
                    workRequest2=workRequest;
                workRequest = wr;  
                
            }
                else {
                    secMaxVal = wr.getSender().getFinanceDetail().getBalance();
                    workRequest2 = wr;
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

        JLabel = new javax.swing.JLabel();
        topproductJTextField = new javax.swing.JTextField();
        adv2JLabel = new javax.swing.JLabel();
        secTopJTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        adv1JLabel1 = new javax.swing.JLabel();
        topAdvJTextField = new javax.swing.JTextField();
        adv1JLabel2 = new javax.swing.JLabel();
        product2JTextField = new javax.swing.JTextField();
        JLabel3 = new javax.swing.JLabel();
        adv1JLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        pubBalanceJTextField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        JLabel.setText("ProductName:");
        add(JLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 430, 140, 27));

        topproductJTextField.setEditable(false);
        topproductJTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(topproductJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 240, 150, 30));

        adv2JLabel.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        adv2JLabel.setText("Advertisement2:");
        add(adv2JLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, 150, 27));

        secTopJTextField.setEditable(false);
        secTopJTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(secTopJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 370, 146, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("FINANCIAL DETAILS");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 350, 25));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Top two Advertisments:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, -1, 29));

        adv1JLabel1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        adv1JLabel1.setText("Advertisement1:");
        add(adv1JLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 150, 27));

        topAdvJTextField.setEditable(false);
        topAdvJTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(topAdvJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(396, 177, 150, 30));

        adv1JLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        adv1JLabel2.setText("Total Earnings:");
        add(adv1JLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, 140, 27));

        product2JTextField.setEditable(false);
        product2JTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(product2JTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 430, 150, 30));

        JLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        JLabel3.setText("ProductName:");
        add(JLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 140, 27));

        adv1JLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        adv1JLabel4.setText("Total Earnings:");
        add(adv1JLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 140, 27));

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel3.setText("Publisher Balance:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 530, 180, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Net Balance:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 590, 140, 30));

        pubBalanceJTextField.setEditable(false);
        add(pubBalanceJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 590, 150, 30));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("<<Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 643, 110, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLabel;
    private javax.swing.JLabel JLabel3;
    private javax.swing.JLabel adv1JLabel1;
    private javax.swing.JLabel adv1JLabel2;
    private javax.swing.JLabel adv1JLabel4;
    private javax.swing.JLabel adv2JLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField product2JTextField;
    private javax.swing.JTextField pubBalanceJTextField;
    private javax.swing.JTextField secTopJTextField;
    private javax.swing.JTextField topAdvJTextField;
    private javax.swing.JTextField topproductJTextField;
    // End of variables declaration//GEN-END:variables
}