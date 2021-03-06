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
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Sriram
 */
public class PublisherWorkAreaJPanel extends javax.swing.JPanel {

   JPanel userProcessContainer;
   Publisher publisher;
   UserAccount userAccount;
   PublisherOrganization publisherOrganization;
   AdvertiserDirectory advertiserDirectory;
   
    public PublisherWorkAreaJPanel(JPanel upc, Publisher publisher, UserAccount userAccount, PublisherOrganization publisherOrganization, AdvertiserDirectory advertiserDirectory) {
        initComponents();
        this.userProcessContainer = upc;
        this.publisher = publisher;
        this.userAccount = userAccount;
        this.publisherOrganization = publisherOrganization;
        this.advertiserDirectory = advertiserDirectory;
        System.out.println("Publisher Finance is" + userAccount.getFinanceDetail().getBalance());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        manageProductJButton1 = new javax.swing.JButton();
        productManagerJLabel = new javax.swing.JLabel();
        enrollAdvertiserJButton = new javax.swing.JButton();
        financeJButton = new javax.swing.JButton();

        manageProductJButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        manageProductJButton1.setText("Manage AdSpace Catalog >>");
        manageProductJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageProductJButton1ActionPerformed(evt);
            }
        });

        productManagerJLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        productManagerJLabel.setText("Publisher Work Area");

        enrollAdvertiserJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        enrollAdvertiserJButton.setText("Enroll Advertiser >>>");
        enrollAdvertiserJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enrollAdvertiserJButtonActionPerformed(evt);
            }
        });

        financeJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        financeJButton.setText("Advertiser Finance Detail >>");
        financeJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                financeJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(productManagerJLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(enrollAdvertiserJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(manageProductJButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(financeJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(209, 209, 209))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(productManagerJLabel)
                .addGap(91, 91, 91)
                .addComponent(manageProductJButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(enrollAdvertiserJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(financeJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(130, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void manageProductJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageProductJButton1ActionPerformed
        ManageAdSpaceJPanel msjp = new ManageAdSpaceJPanel(userProcessContainer, publisher,publisherOrganization);
        userProcessContainer.add("ManageAdSpaceJPanel",msjp);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageProductJButton1ActionPerformed

    private void enrollAdvertiserJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enrollAdvertiserJButtonActionPerformed
        EnrollAdvertiserJPanel eajp = new EnrollAdvertiserJPanel(userProcessContainer,publisherOrganization,userAccount,publisher);
        userProcessContainer.add("EnrollRequestPanel",eajp);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_enrollAdvertiserJButtonActionPerformed

    private void financeJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_financeJButtonActionPerformed
        try {
        WorkRequest wr1 = null;
        WorkRequest wr2 = null;
        int count = 0;
        for (WorkRequest wr : publisherOrganization.getWorkQueue().getWorkRequestList()) {
            if(count == 0) {
                wr1 = wr;
                count++;
            } else {
                wr2 = wr1;
                wr1=wr;
            }
        }
        if(!((wr1==null) && (wr2==null))) {
        AdvertiserFinanceDetailJPanel afjp = new AdvertiserFinanceDetailJPanel(userProcessContainer, advertiserDirectory, publisher, publisherOrganization, userAccount);
        userProcessContainer.add("AdvertiserFinancialPanel",afjp);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        } else {
            JOptionPane.showMessageDialog(null, "You do not have enough advertisers to see financial account");
            return;
        }
        } catch(NullPointerException e)
        {
            JOptionPane.showMessageDialog(null, "You do not have enough advertisers to see financial account");
            return;
        
        }
    }//GEN-LAST:event_financeJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton enrollAdvertiserJButton;
    private javax.swing.JButton financeJButton;
    private javax.swing.JButton manageProductJButton1;
    private javax.swing.JLabel productManagerJLabel;
    // End of variables declaration//GEN-END:variables
}
