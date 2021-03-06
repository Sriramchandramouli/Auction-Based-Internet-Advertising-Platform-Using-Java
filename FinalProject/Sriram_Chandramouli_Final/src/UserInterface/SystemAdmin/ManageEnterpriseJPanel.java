/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.SystemAdmin;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sriram
 */
public class ManageEnterpriseJPanel extends javax.swing.JPanel {

    JPanel userProcessContainer;
    EcoSystem system;
    
    public ManageEnterpriseJPanel(JPanel upc, EcoSystem system) {
        initComponents();
        
        this.userProcessContainer = upc;
        this.system = system;
        populateEnterpriseTable();
        populateComboBoxes();
    }
    
    private void populateEnterpriseTable() {
        
        DefaultTableModel dtm = (DefaultTableModel) enterpriseJTable.getModel();
        dtm.setRowCount(0);
        
        for (Network network : system.getNetworkList()) {
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                Object row[] = new Object[3];
                row[0] = enterprise;
                row[1] = network.getName();
                row[2] = enterprise.getEnterpriseType().getValue();
                
                dtm.addRow(row);
            }
        }
        
    }
    
    private void populateComboBoxes(){
        networkJComboBox.removeAllItems();
        enterpriseTypeJComboBox.removeAllItems();
        
        for (Network network : system.getNetworkList()){
            networkJComboBox.addItem(network);
        }
        
        for (Enterprise.EnterpriseType type : Enterprise.EnterpriseType.values()){
            enterpriseTypeJComboBox.addItem(type);
        }
        
    }
    
    private Boolean validation() {
        
        String name = nameJTextField.getText();
        for(int i = 0; i <name.length();i++){
        char c = name.charAt(i);  
        if((c<97 || c>122) && (c<65 || c>90)) {
         JOptionPane.showMessageDialog(null, "Enterprise Name field should contain only alphabet", "Mismatch", JOptionPane.WARNING_MESSAGE);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        enterpriseJTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        networkJComboBox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        enterpriseTypeJComboBox = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        nameJTextField = new javax.swing.JTextField();
        backJButton = new javax.swing.JButton();
        submitJButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        deleteEnterpriseJButton = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        enterpriseJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Enterprise Name", "Network", "Type"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(enterpriseJTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 95, 469, 91));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Network");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 220, 123, 25));

        networkJComboBox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(networkJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(423, 220, 149, 25));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Enterprise Type");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 271, -1, 26));

        enterpriseTypeJComboBox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(enterpriseTypeJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(423, 267, 150, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Name");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 325, 123, 26));

        nameJTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(nameJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(423, 325, 160, 30));

        backJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 424, -1, -1));

        submitJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        submitJButton.setText("Submit >>");
        submitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitJButtonActionPerformed(evt);
            }
        });
        add(submitJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 430, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setText("MANAGE ENTERPRISE PANEL");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 390, 26));

        deleteEnterpriseJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        deleteEnterpriseJButton.setText("Delete Enterprise >>");
        deleteEnterpriseJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteEnterpriseJButtonActionPerformed(evt);
            }
        });
        add(deleteEnterpriseJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 490, 210, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void submitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitJButtonActionPerformed

         Boolean flag = validation();
         if(flag) {
        Network network = (Network) networkJComboBox.getSelectedItem();
        Enterprise.EnterpriseType type = (Enterprise.EnterpriseType)enterpriseTypeJComboBox.getSelectedItem();

        if (network == null || type == null || nameJTextField.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Invalid Input!. Please fill in all the fileds");
            return;
        }
        
        for (Enterprise ent : network.getEnterpriseDirectory().getEnterpriseList()) {
            if (ent!=null) {
                JOptionPane.showMessageDialog(null, "Enterprise already exists. There can be only one enterprise.");
                return;
            }
        }

        String name = nameJTextField.getText();
        
        for (Enterprise e : network.getEnterpriseDirectory().getEnterpriseList()) {
            if (e.getName().equals(name)) {
                JOptionPane.showMessageDialog(null, "Enterprise name already exists. Please use different name");
                return;
            }
        }

        Enterprise enterprise = network.getEnterpriseDirectory().createAndAddEnterprise(name, type);

        populateEnterpriseTable();
        
        nameJTextField.setText("");
        JOptionPane.showMessageDialog(null, "Enterprise has been created successfully", "Success", JOptionPane.WARNING_MESSAGE);
        
         }

    }//GEN-LAST:event_submitJButtonActionPerformed

    private void deleteEnterpriseJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteEnterpriseJButtonActionPerformed

        int selectedRow = enterpriseJTable.getSelectedRow();
        if(selectedRow>=0){
            int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete", "Warning", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                Enterprise enterprise  =(Enterprise)enterpriseJTable.getValueAt(selectedRow,0);
                Network network = (Network) networkJComboBox.getSelectedItem();
                network.getEnterpriseDirectory().deleteEnterprise(enterprise);
                populateEnterpriseTable();
            }
        }
        else{
            JOptionPane.showMessageDialog(this,"Please select an Enterprise to delete");
        }

    }//GEN-LAST:event_deleteEnterpriseJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JButton deleteEnterpriseJButton;
    private javax.swing.JTable enterpriseJTable;
    private javax.swing.JComboBox enterpriseTypeJComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameJTextField;
    private javax.swing.JComboBox networkJComboBox;
    private javax.swing.JButton submitJButton;
    // End of variables declaration//GEN-END:variables
}
