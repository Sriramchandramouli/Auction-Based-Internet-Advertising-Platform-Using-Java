/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.AdministrativeRole;

import Business.Organization.PublisherOrganization;
import Business.Publisher.Publisher;
import Business.Publisher.PublisherDirectory;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sriram
 */
public class ManagePublisherJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManagePublisherJPanel
     */
    JPanel userProcessContainer;
    PublisherOrganization publisherOrganization;
    PublisherDirectory publisherDirectory;
    public ManagePublisherJPanel(JPanel upc, PublisherOrganization publisherOrganization, PublisherDirectory publisherDirectory) {
        initComponents();
        this.userProcessContainer = upc;
        this.publisherOrganization = publisherOrganization;
        this.publisherDirectory = publisherDirectory;
        
    }
    
    private void populatePublisherTable() {
        DefaultTableModel dtm = (DefaultTableModel)publisherJTable.getModel();
        dtm.setRowCount(0);
        
        for (Publisher publisher : publisherDirectory.getPublisherList()) {
            Object row[] = new Object[1];
            row[0] = publisher;
            dtm.addRow(row);
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
        publisherJTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        refreshJButton = new javax.swing.JButton();
        backJButton = new javax.swing.JButton();
        removeJButton = new javax.swing.JButton();
        addPublisherJButton = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        publisherJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Publisher Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(publisherJTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 370, 110));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("MANAGE PUBLISHERS");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 21, -1, -1));

        refreshJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        refreshJButton.setText("Refresh");
        refreshJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshJButtonActionPerformed(evt);
            }
        });
        add(refreshJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 100, 30));

        backJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        backJButton.setText("<<Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 390, 100, 30));

        removeJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        removeJButton.setText("Remove >>");
        removeJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeJButtonActionPerformed(evt);
            }
        });
        add(removeJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, 130, 30));

        addPublisherJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        addPublisherJButton.setText("Add Publisher >>");
        addPublisherJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPublisherJButtonActionPerformed(evt);
            }
        });
        add(addPublisherJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 300, 180, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void addPublisherJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPublisherJButtonActionPerformed
        AddPublisherJPanel ap = new AddPublisherJPanel(userProcessContainer,publisherOrganization,publisherDirectory);
        userProcessContainer.add("AddPublisher",ap);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        
    }//GEN-LAST:event_addPublisherJButtonActionPerformed

    private void removeJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeJButtonActionPerformed
        int selectedRow = publisherJTable.getSelectedRow();
        if(selectedRow>=0){
            int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete", "Warning", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION){
                Publisher publisher = (Publisher)publisherJTable.getValueAt(selectedRow,0);
                publisherDirectory.deletePublisher(publisher);
                populatePublisherTable();
            }
        }
        else{
            JOptionPane.showMessageDialog(this,"Please select a publisher to delete");
        }
    }//GEN-LAST:event_removeJButtonActionPerformed

    private void refreshJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshJButtonActionPerformed
        if(publisherDirectory!=null) {
        populatePublisherTable();
        }
    }//GEN-LAST:event_refreshJButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addPublisherJButton;
    private javax.swing.JButton backJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable publisherJTable;
    private javax.swing.JButton refreshJButton;
    private javax.swing.JButton removeJButton;
    // End of variables declaration//GEN-END:variables
}
