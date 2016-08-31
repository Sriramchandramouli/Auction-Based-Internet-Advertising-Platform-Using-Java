/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.ConsumerRole;


import Business.Consumer.Consumer;
import Business.Order.MasterOrderCatalog;
import Business.Order.Order;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sriram
 */
public class ViewOrderHistoryJPanel extends javax.swing.JPanel {

    JPanel userProcessContainer;
    MasterOrderCatalog masterOrderCatalog;
    Consumer consumer;
    public ViewOrderHistoryJPanel(JPanel upc,MasterOrderCatalog masterOrderCatalog,Consumer consumer) {
        initComponents();
        this.userProcessContainer=upc;
        this.masterOrderCatalog=masterOrderCatalog;
        this.consumer=consumer;
        populateTable();
        
    }
    
    private void populateTable() {
        DefaultTableModel dtm = (DefaultTableModel)viewOrderJTable.getModel();
        dtm.setRowCount(0);
        
        for(Order order : masterOrderCatalog.getOrderCatalogList()) {
            if(consumer.getConsumerId() == order.getConsumerId()) {
            Object row[] = new Object[2];
            row[0] = order;
            row[1] = order.getConsumerId();
            dtm.addRow(row);
        
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

        jScrollPane2 = new javax.swing.JScrollPane();
        viewOrderJTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        invoiceJButton = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        viewOrderJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order", "CustomerId"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(viewOrderJTable);
        if (viewOrderJTable.getColumnModel().getColumnCount() > 0) {
            viewOrderJTable.getColumnModel().getColumn(0).setResizable(false);
            viewOrderJTable.getColumnModel().getColumn(1).setResizable(false);
        }

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 396, 84));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("<<Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 380, 110, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("VIEW ORDER DETAILS");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(221, 11, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel2.setText("OrderHistory:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 140, -1));

        invoiceJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        invoiceJButton.setText("Invoice/OrderDetail >>");
        invoiceJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invoiceJButtonActionPerformed(evt);
            }
        });
        add(invoiceJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 380, 220, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void invoiceJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invoiceJButtonActionPerformed
        int selectedRow = viewOrderJTable.getSelectedRow();
        if(selectedRow<0){

            JOptionPane.showMessageDialog(null, "Please select an order to view Invoice detail");
            return;
        }
        Order order = (Order)viewOrderJTable.getValueAt(selectedRow, 0);
        InvoiceDetailJPanel iojp = new InvoiceDetailJPanel(userProcessContainer, order, consumer);
        userProcessContainer.add("InVoiceDetailJPanel", iojp);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_invoiceJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton invoiceJButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable viewOrderJTable;
    // End of variables declaration//GEN-END:variables
}
