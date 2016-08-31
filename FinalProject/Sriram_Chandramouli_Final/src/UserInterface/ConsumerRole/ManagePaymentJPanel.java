/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.ConsumerRole;

import Business.Consumer.Consumer;
import Business.Order.MasterOrderCatalog;
import Business.Order.Order;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.AdExchangeRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Sriram
 */
public class ManagePaymentJPanel extends javax.swing.JPanel {

    JPanel userProcessContainer;
    AdExchangeRequest aer;
    UserAccount userAccount;
    Order order;
    MasterOrderCatalog masterOrderCatalog;
    Consumer consumer;
    
    public ManagePaymentJPanel(JPanel upc, AdExchangeRequest aer, UserAccount userAccount, Order order, MasterOrderCatalog masterOrderCatalog, Consumer consumer) {
        initComponents();
        this.userProcessContainer = upc;
        this.aer = aer;
        this.userAccount = userAccount;
        this.order = order;
        this.masterOrderCatalog = masterOrderCatalog;
        this.consumer = consumer;
        
        populateCardDetails();
        makePaymentJButton.setEnabled(true);
    }
    
    private void populateCardDetails() {
        
        cardNumberJTextField.setText(userAccount.getFinanceDetail().getCardNumber());
        cardNameJTextField.setText(userAccount.getFinanceDetail().getName());
        expiryDateJTextField.setText(String.valueOf(userAccount.getFinanceDetail().getExpiryDate()));
        cvvNumberJTextField.setText(String.valueOf(userAccount.getFinanceDetail().getCvvNumber()));
        balanceJTextField.setText(String.valueOf(userAccount.getFinanceDetail().getBalance()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cardNumberJTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cardNameJTextField = new javax.swing.JTextField();
        expiryDateJTextField = new javax.swing.JTextField();
        cvvNumberJTextField = new javax.swing.JTextField();
        makePaymentJButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        balanceJTextField = new javax.swing.JTextField();
        backJButton = new javax.swing.JButton();
        imageJLabel = new javax.swing.JLabel();
        viewProductDetailJLabel = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Card Number :");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 83, 130, 30));

        cardNumberJTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(cardNumberJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(359, 83, 150, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Name On the Card :");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 137, -1, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Expiry Date :");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 195, 120, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("CVV :");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 255, 120, 30));

        cardNameJTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(cardNameJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(359, 137, 148, 30));

        expiryDateJTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(expiryDateJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 200, 148, 30));

        cvvNumberJTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(cvvNumberJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 260, 148, 30));

        makePaymentJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        makePaymentJButton.setText("Confirm Payment >>");
        makePaymentJButton.setEnabled(false);
        makePaymentJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makePaymentJButtonActionPerformed(evt);
            }
        });
        add(makePaymentJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 390, -1, 33));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Balance :");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 120, 30));

        balanceJTextField.setEditable(false);
        balanceJTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        balanceJTextField.setEnabled(false);
        balanceJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                balanceJTextFieldActionPerformed(evt);
            }
        });
        add(balanceJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 310, 150, 30));

        backJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        backJButton.setText("<<Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 390, 110, 33));
        add(imageJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, 160, 160));

        viewProductDetailJLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        viewProductDetailJLabel.setText("MANAGE PAYMENT PANEL");
        add(viewProductDetailJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void makePaymentJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makePaymentJButtonActionPerformed
        
        if (userAccount.getFinanceDetail().getBalance() - ((aer.getAdvertisement().getProduct().getPrice()) * (aer.getAdvertisement().getProduct().getPurchasedQuantity())) <= 0) {
            aer.getAdvertisement().getProduct().setAvailability(aer.getAdvertisement().getProduct().getAvailability() + aer.getAdvertisement().getProduct().getPurchasedQuantity());
            JOptionPane.showMessageDialog(null, "You do not have sufficient balance to buy the product");
            return;
        }
        userAccount.getFinanceDetail().setBalance(userAccount.getFinanceDetail().getBalance() - ((aer.getAdvertisement().getProduct().getPrice()) * (aer.getAdvertisement().getProduct().getPurchasedQuantity())));
        aer.getSender().getFinanceDetail().setBalance((float) ((aer.getSender().getFinanceDetail().getBalance()) + (0.80 * (aer.getAdvertisement().getProduct().getPrice() * aer.getAdvertisement().getProduct().getPurchasedQuantity()))));
        aer.getReceiver().getFinanceDetail().setBalance((float) ((aer.getReceiver().getFinanceDetail().getBalance()) + (0.20 *(aer.getAdvertisement().getProduct().getPrice() * aer.getAdvertisement().getProduct().getPurchasedQuantity()))));
        
        balanceJTextField.setText(String.valueOf(userAccount.getFinanceDetail().getBalance()));
        
        System.out.println("Adv balance is" + aer.getSender().getFinanceDetail().getBalance());
         System.out.println("Adv  is" + aer.getSender().getPerson().getFirstName());
        System.out.println("Pub balance is" + aer.getReceiver().getFinanceDetail().getBalance());
         System.out.println("Pub is" + aer.getReceiver().getPerson().getFirstName());
        order.setConsumerId(consumer.getConsumerId());
        masterOrderCatalog.addOrder(order);
        
      //  order = new Order();
        makePaymentJButton.setEnabled(false);
        JOptionPane.showMessageDialog(null, "The Payment has been completed");
    }//GEN-LAST:event_makePaymentJButtonActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void balanceJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_balanceJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_balanceJTextFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JTextField balanceJTextField;
    private javax.swing.JTextField cardNameJTextField;
    private javax.swing.JTextField cardNumberJTextField;
    private javax.swing.JTextField cvvNumberJTextField;
    private javax.swing.JTextField expiryDateJTextField;
    private javax.swing.JLabel imageJLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton makePaymentJButton;
    private javax.swing.JLabel viewProductDetailJLabel;
    // End of variables declaration//GEN-END:variables
}
