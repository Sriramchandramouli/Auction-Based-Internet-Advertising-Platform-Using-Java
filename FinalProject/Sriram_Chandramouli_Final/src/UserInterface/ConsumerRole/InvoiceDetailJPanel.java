/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.ConsumerRole;

import Business.Consumer.Consumer;
import Business.Order.Order;
import Business.Order.OrderItem;
import java.awt.CardLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sriram
 */
public class InvoiceDetailJPanel extends javax.swing.JPanel {

    JPanel userProcessContainer;
    Order order;
    Consumer consumer;
    float total = 0;
    
    public InvoiceDetailJPanel(JPanel upc, Order order, Consumer consumer) {
        initComponents();
        this.userProcessContainer = upc;
        this.order = order;
        this.consumer = consumer;
        populateOrderTable(order);
        populateInvoiceInfo();
    }
    
    private void populateInvoiceInfo() {
        
        firstNameJLabel.setText(consumer.getFirstName());
        lastNameJLabel.setText(consumer.getLastName());
        line1JLabel1.setText(consumer.getLine1Address());
        line2JLabel.setText(consumer.getLine2Address());
        cityJLabel.setText(consumer.getCity());
        stateJLabel.setText(consumer.getState());
        zipCodeJLabel.setText(String.valueOf(consumer.getZipCode()));
        
        
        DateFormat dateFormat= new SimpleDateFormat("dd/MM/yyyy");

        Calendar c = Calendar.getInstance();    
        c.setTime(new Date());
        c.add(Calendar.DATE, 3);
        System.out.println(dateFormat.format(c.getTime()));
        eShipDateJLabel.setText(dateFormat.format(c.getTime()));
        
        trackingNoJLabel.setText("000127600878" + consumer.getZipCode());
        invoiceJLabel.setText(String.valueOf("00987667093" + consumer.getConsumerId()));
    }
    
    private void populateOrderTable(Order or) {
        DefaultTableModel dtm = (DefaultTableModel)invoiceDetailDetailJTable.getModel();
        dtm.setRowCount(0);
      
        for(OrderItem oi : or.getOrderItemList()) {
            
            Object row[] = new Object[4];
            row[0] = oi;
            row[1] = oi.getProduct().getPrice();
            row[2] = oi.getQuantity();
            row[3] = oi.getQuantity() * oi.getProduct().getPrice();
            dtm.addRow(row);
    
        }
        for(int i=0;i<dtm.getRowCount();i++) {
            float amount = (float) invoiceDetailDetailJTable.getValueAt(i, 3);
            total = amount + total;
            totalBillJLabel.setText(String.valueOf(total));
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
        invoiceDetailDetailJTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lastNameJLabel = new javax.swing.JLabel();
        line2JLabel = new javax.swing.JLabel();
        cityJLabel = new javax.swing.JLabel();
        stateJLabel = new javax.swing.JLabel();
        zipCodeJLabel = new javax.swing.JLabel();
        totalBillJLabel = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        eShipDateJLabel = new javax.swing.JLabel();
        shipDateJLabel = new javax.swing.JLabel();
        trackingNoJLabel = new javax.swing.JLabel();
        line1JLabel1 = new javax.swing.JLabel();
        firstNameJLabel = new javax.swing.JLabel();
        invoiceJLabel = new javax.swing.JLabel();
        viewProductDetailJLabel = new javax.swing.JLabel();
        backJButton = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        invoiceDetailDetailJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Price", "Quantity", "TotalPrice"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Float.class, java.lang.Integer.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(invoiceDetailDetailJTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 240, 450, 110));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Total Bill Amount:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(294, 380, 130, 32));

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel2.setText("SHIPPING INFORMATION:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 200, 22));

        lastNameJLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        add(lastNameJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, 120, 25));

        line2JLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        add(line2JLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 199, 25));

        cityJLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        add(cityJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 93, 25));

        stateJLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        add(stateJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, 84, 25));

        zipCodeJLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        add(zipCodeJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 190, 84, 25));

        totalBillJLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        add(totalBillJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 380, 130, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("InVoice NO:");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 130, 120, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Tracking NO:");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 450, 130, 30));

        eShipDateJLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        add(eShipDateJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 510, 260, 30));

        shipDateJLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        shipDateJLabel.setText("Estimated Ship Date:");
        add(shipDateJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 510, 160, 30));

        trackingNoJLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        add(trackingNoJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 450, 250, 30));

        line1JLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        add(line1JLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 199, 25));

        firstNameJLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        add(firstNameJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 120, 25));

        invoiceJLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        add(invoiceJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 130, 120, 30));

        viewProductDetailJLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        viewProductDetailJLabel.setText("INVOICE DETAIL PANEL");
        add(viewProductDetailJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, 300, -1));

        backJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 560, 120, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JLabel cityJLabel;
    private javax.swing.JLabel eShipDateJLabel;
    private javax.swing.JLabel firstNameJLabel;
    private javax.swing.JTable invoiceDetailDetailJTable;
    private javax.swing.JLabel invoiceJLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lastNameJLabel;
    private javax.swing.JLabel line1JLabel1;
    private javax.swing.JLabel line2JLabel;
    private javax.swing.JLabel shipDateJLabel;
    private javax.swing.JLabel stateJLabel;
    private javax.swing.JLabel totalBillJLabel;
    private javax.swing.JLabel trackingNoJLabel;
    private javax.swing.JLabel viewProductDetailJLabel;
    private javax.swing.JLabel zipCodeJLabel;
    // End of variables declaration//GEN-END:variables
}