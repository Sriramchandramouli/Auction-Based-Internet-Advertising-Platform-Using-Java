/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import Business.Consumer.ConsumerDirectory;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.ConsumerOrganization;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import Business.UserAccount.UserAccountDirectory;
import Business.WorkQueue.SignUpRequest;
import Business.WorkQueue.WorkRequest;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Sriram
 */
public class SignUpJPanel extends javax.swing.JPanel {

   
    JPanel userProcessContainer;
    UserAccountDirectory userAccountDirectory;
    ConsumerDirectory consumerDirectory;
    ConsumerOrganization consumerOrganization;
    EcoSystem system;
    
   // SignUpRequest sur;
   // Organization organization;
    
    public SignUpJPanel(JPanel upc, UserAccountDirectory ua,ConsumerDirectory consumerDirectory, ConsumerOrganization consumerOrganization, EcoSystem system) {
        initComponents();
        this.userProcessContainer=upc;
        this.userAccountDirectory=ua;
        this.consumerDirectory=consumerDirectory;
        this.consumerOrganization = consumerOrganization;
        this.system = system;
        
        populateConsumerCombobox();
        populateCountryCombobox();
    }
    
    
    private void populateConsumerCombobox() {
        consumerRoleJComboBox.removeAllItems();
        for (Role role : consumerOrganization.getSupportedRole()) {
            consumerRoleJComboBox.addItem(role);
        }
    }
    
    private void populateCountryCombobox() {
        
        networkJComboBox.removeAllItems();
        for (Network network : system.getNetworkList()) {
            networkJComboBox.addItem(network);
        }
    }
    
    private Boolean validation() {
        
        if(firstNameJTextField.getText().equals("") || lastNameJTextField.getText().equals("") || ageJTextField.getText().equals("") || userNameJTextField.getText().equals("") || (cardJTextField1.getText().equals("")) || cardJTextField2.getText().equals("") || cardJTextField3.getText().equals("") || (cardJTextField4.getText().equals("")) || cvvNumberJTextField.getText().equals("") || balanceJTextField.getText().equals("") || line1AddressJTextField.getText().equals("") || line2AddressJTextField.getText().equals("") || cityJTextField.getText().equals("") || stateJTextField.getText().equals("") || zipCodeJTextField.getText().equals("")) {
         JOptionPane.showMessageDialog(null, "Fill in all the fields. Some fields are empty", "Empty Text", JOptionPane.WARNING_MESSAGE);
         return false;
        }
        String firstName = firstNameJTextField.getText();
        for(int i = 0; i <firstName.length();i++){
        char c = firstName.charAt(i);  
        if((c<97 || c>122) && (c<65 || c>90)) {
         JOptionPane.showMessageDialog(null, "Name field should contain only alphabet", "Mismatch", JOptionPane.WARNING_MESSAGE);
         return false;
        }
        }
        
        String lastName = lastNameJTextField.getText();
        for(int i = 0; i <lastName.length();i++){
        char c = lastName.charAt(i);  
        if((c<97 || c>122) && (c<65 || c>90)) {
         JOptionPane.showMessageDialog(null, "Name field should contain only alphabet", "Mismatch", JOptionPane.WARNING_MESSAGE);
         return false;
        }
        }
        
        String age = ageJTextField.getText();
        for(int i = 0; i <age.length();i++){
        char c = age.charAt(i);  
        if((c<48 || c>57))  {
         JOptionPane.showMessageDialog(null, "Age field should contain only number", "Mismatch", JOptionPane.WARNING_MESSAGE);
         return false;
        }
        }
        
        String card1 = cardJTextField1.getText();
        for(int i = 0; i <card1.length();i++){
        char c = card1.charAt(i);  
        if((c<48 || c>57))  {
         JOptionPane.showMessageDialog(null, "Each field in Card should contain only 4 number", "Mismatch", JOptionPane.WARNING_MESSAGE);
         return false;
        }
        }
        
        String card2 = cardJTextField2.getText();
        for(int i = 0; i <card2.length();i++){
        char c = card2.charAt(i);  
        if((c<48 || c>57))  {
         JOptionPane.showMessageDialog(null, "Each field in Card should contain only 4 number", "Mismatch", JOptionPane.WARNING_MESSAGE);
         return false;
        }
        }
        
        String card3 = cardJTextField3.getText();
        for(int i = 0; i <card3.length();i++){
        char c = card3.charAt(i);  
        if((c<48 || c>57))  {
         JOptionPane.showMessageDialog(null, "Each field in Card should contain only 4 number", "Mismatch", JOptionPane.WARNING_MESSAGE);
         return false;
        }
        }
        
        String card4 = cardJTextField4.getText();
        for(int i = 0; i <card4.length();i++){
        char c = card4.charAt(i);  
        if((c<48 || c>57))  {
         JOptionPane.showMessageDialog(null, "Each field in Card should contain only 4 number", "Mismatch", JOptionPane.WARNING_MESSAGE);
         return false;
        }
        }
        
        String cvvNo = cvvNumberJTextField.getText();
        for(int i = 0; i <cvvNo.length();i++){
        char c = cvvNo.charAt(i);  
        if((c<48 || c>57))  {
         JOptionPane.showMessageDialog(null, "CVV Number field should contain only number", "Mismatch", JOptionPane.WARNING_MESSAGE);
         return false;
        }
        }
        
        String balance = balanceJTextField.getText();
        for(int i = 0; i <balance.length();i++){
        char c = balance.charAt(i);  
        if((c!=46 && c<48) || c>57 ) {
         JOptionPane.showMessageDialog(null, "Balance field should contain only number and dot", "Mismatch", JOptionPane.WARNING_MESSAGE);
         return false;
        }
        }
        
        String city = cityJTextField.getText();
        for(int i = 0; i <city.length();i++){
        char c = city.charAt(i);  
        if((c<97 || c>122) && (c<65 || c>90)) {
         JOptionPane.showMessageDialog(null, "City Name field should contain only alphabet", "Mismatch", JOptionPane.WARNING_MESSAGE);
         return false;
        }
        }
        
        String state = stateJTextField.getText();
        for(int i = 0; i <state.length();i++){
        char c = state.charAt(i);  
        if((c<97 || c>122) && (c<65 || c>90)) {
         JOptionPane.showMessageDialog(null, "State Name field should contain only alphabet", "Mismatch", JOptionPane.WARNING_MESSAGE);
         return false;
        }
        }
        
        String zipCode = zipCodeJTextField.getText();
        for(int i = 0; i <zipCode.length();i++){
        char c = zipCode.charAt(i);  
        if((c<48 || c>57))  {
         JOptionPane.showMessageDialog(null, "ZipCode field should contain only number", "Mismatch", JOptionPane.WARNING_MESSAGE);
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

        jLabel1 = new javax.swing.JLabel();
        signUpJButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        userNameJTextField = new javax.swing.JTextField();
        PasswordField = new javax.swing.JPasswordField();
        consumerRoleJComboBox = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        firstNameJTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lastNameJTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        ageJTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        category1JComboBox = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        category2JComboBox = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        category3JComboBox = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cardJTextField1 = new javax.swing.JTextField();
        cardJTextField2 = new javax.swing.JTextField();
        cardJTextField3 = new javax.swing.JTextField();
        cardJTextField4 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        balanceJTextField = new javax.swing.JTextField();
        cvvNumberJTextField = new javax.swing.JTextField();
        cardDetailsJDateChooser = new com.toedter.calendar.JDateChooser();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        zipCodeJTextField = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        line1AddressJTextField = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        line2AddressJTextField = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        cityJTextField = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        stateJTextField = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        networkJComboBox = new javax.swing.JComboBox();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("SIGNUP PANEL");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 11, 157, 25));

        signUpJButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        signUpJButton.setText("SignUp");
        signUpJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpJButtonActionPerformed(evt);
            }
        });
        add(signUpJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 600, 120, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("UserName");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 114, 25));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("PassWord");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, 114, 25));

        userNameJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userNameJTextFieldActionPerformed(evt);
            }
        });
        add(userNameJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 220, 189, 24));
        add(PasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 260, 189, 25));

        add(consumerRoleJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, 189, 24));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("First Name");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 114, 24));
        add(firstNameJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 100, 189, 24));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Last Name");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 114, 25));
        add(lastNameJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 140, 189, 24));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Age");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 114, 25));

        ageJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ageJTextFieldActionPerformed(evt);
            }
        });
        add(ageJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 180, 189, 24));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Role");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 114, 24));

        jLabel8.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel8.setText("Interested Category:");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 300, 200, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Category1");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 340, 130, 30));

        category1JComboBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        category1JComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Gaming", "Watches", "Mobiles", "Shoes", "Television", "Sunglasses" }));
        add(category1JComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 340, 200, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Category2");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 380, 130, 30));

        category2JComboBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        category2JComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Gaming", "Watches", "Mobiles", "Shoes", "Television", "Sunglasses" }));
        category2JComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                category2JComboBoxActionPerformed(evt);
            }
        });
        add(category2JComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 380, 200, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Category3");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 420, 110, 30));

        category3JComboBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        category3JComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Gaming", "Watches", "Mobiles", "Shoes", "Television", "Sunglasses" }));
        add(category3JComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 420, 200, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel12.setText("Address Details:");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 10, 200, 30));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("CardNumber:");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 500, 130, 30));
        add(cardJTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 500, 51, 30));
        add(cardJTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 500, 51, 30));
        add(cardJTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 500, 51, 30));
        add(cardJTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 500, 51, 30));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Expiry Date:");
        add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 540, 130, 30));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Balance:");
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 630, 130, 30));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("CVV Number:");
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 580, 130, 30));
        add(balanceJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 630, 190, 30));
        add(cvvNumberJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 580, 190, 30));
        add(cardDetailsJDateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 540, 190, 30));

        jLabel17.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel17.setText("Card Details:");
        add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 460, 200, 30));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("ZipCode:");
        add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 290, 70, 30));

        jLabel19.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel19.setText("Street Address :");
        add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 50, 120, 30));
        add(zipCodeJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 290, 230, 30));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("Line1 :");
        add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 90, 70, 30));
        add(line1AddressJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 90, 230, 30));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("Line2 :");
        add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 140, 70, 30));

        line2AddressJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                line2AddressJTextFieldActionPerformed(evt);
            }
        });
        add(line2AddressJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 140, 230, 30));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("City:");
        add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 190, 70, 30));
        add(cityJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 190, 230, 30));

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("State:");
        add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 240, 70, 30));
        add(stateJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 240, 230, 30));

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setText("Network:");
        add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 350, 90, 30));

        add(networkJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 350, 220, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void userNameJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userNameJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userNameJTextFieldActionPerformed

    private void signUpJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signUpJButtonActionPerformed
       
        try {
        Boolean flag = validation();
        if(flag) {
            
            
        String no1 = cardJTextField1.getText();
          if(no1.length()!=4)  {
         JOptionPane.showMessageDialog(null, "Card number should contain 4 numbers", "Mismatch", JOptionPane.WARNING_MESSAGE);
         return;
        }
        
          String no2 = cardJTextField2.getText();
          if(no2.length()!=4)  {
         JOptionPane.showMessageDialog(null, "Card number field should contain 4 numbers", "Mismatch", JOptionPane.WARNING_MESSAGE);
         return;
        }
          
          String no3 = cardJTextField3.getText();
          if(no3.length()!=4)  {
         JOptionPane.showMessageDialog(null, "Card number field  should contain 4 numbers", "Mismatch", JOptionPane.WARNING_MESSAGE);
         return;
        }
          
          String no4 = cardJTextField4.getText();
          if(no4.length()!=4)  {
         JOptionPane.showMessageDialog(null, "Card number field should contain 4 numbers", "Mismatch", JOptionPane.WARNING_MESSAGE);
         return;
        }
          
          String no5 = cvvNumberJTextField.getText();
          if(no5.length()!=3)  {
         JOptionPane.showMessageDialog(null, "CVV number field should contain 3 numbers", "Mismatch", JOptionPane.WARNING_MESSAGE);
         return;
        }
          
          
        
        String firstName = firstNameJTextField.getText();
        String lastName = lastNameJTextField.getText();
        int age = Integer.parseInt(ageJTextField.getText());
        
        String userName = userNameJTextField.getText();
        char[] pass = PasswordField.getPassword();
        String pwd = String.valueOf(pass);
        Role r = (Role) consumerRoleJComboBox.getSelectedItem();
        
        String categ1 = String.valueOf(category1JComboBox.getSelectedItem());
        String categ2 = String.valueOf(category2JComboBox.getSelectedItem());
        String categ3 = String.valueOf(category3JComboBox.getSelectedItem());
       
        String c1 = cardJTextField1.getText();
        String c2 = cardJTextField2.getText();
        String c3 = cardJTextField3.getText();
        String c4 = cardJTextField4.getText();
        
        String number = c1+c2+c3+c4;
        Date expiryDate = cardDetailsJDateChooser.getDate();
        int cvvNumber = Integer.parseInt(cvvNumberJTextField.getText());
        float balance = Float.parseFloat(balanceJTextField.getText());
        
        String line1Add = line1AddressJTextField.getText();
        String line2Add = line2AddressJTextField.getText();
        String city = cityJTextField.getText();
        String state = stateJTextField.getText();
        int code = Integer.parseInt(zipCodeJTextField.getText());
        
        Network n = (Network) networkJComboBox.getSelectedItem();
        
        for (Network network : system.getNetworkList()) {
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                  for (UserAccount ua1 : enterprise.getUserAccountDirectory().getUserAccountList()) {
                        if (ua1.getUserName().equals(userName)) {
                            JOptionPane.showMessageDialog(null, "UserName already exists. Please use another name");
                            return;
                        }
                    } 
                
            }
        }
        
        for (UserAccount ua2 : system.getUserAccountDirectory().getUserAccountList()) {
            
            if (ua2.getUserName().equals(userName)) {
                JOptionPane.showMessageDialog(null, "UserName already exists. Please use another name");
                            return;
            }
            
        }
        
        for (Network network : system.getNetworkList()) {
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                for (Organization org : enterprise.getOrganizationDirectory().getOrganizationList()) {
                  for (UserAccount ua1 : org.getUserAccountDirectory().getUserAccountList()) {
                        if (ua1.getUserName().equals(userName)) {
                            JOptionPane.showMessageDialog(null, "UserName already exists. Please use another name");
                            return;
                        }
                    } 
                }
            }
        }
        for (UserAccount ua : userAccountDirectory.getUserAccountList()) {
            if (ua.getUserName().equals("sysadmin")) {
                for (WorkRequest wr : ua.getWorkQueue().getWorkRequestList()) {
                    SignUpRequest req = (SignUpRequest) wr;
                    if ((req.getUserName().equals(userName))) {
                        JOptionPane.showMessageDialog(null, "UserName already exists. Please use another name");
                        return;
                    }
                }
            }
        }
        
      if ((categ1.equals(categ2)) || (categ2.equals(categ3)) || (categ3.equals(categ1))) {
          
          JOptionPane.showMessageDialog(null, "You have repeated categories selected in your category list");
          return;
      }
      
      Date date = new Date();
      if(expiryDate.before(date)) {
          JOptionPane.showMessageDialog(null, "You have entered invalid Expiry Date");
          return;
      }
      
        SignUpRequest sur = new SignUpRequest();
        sur.setUserName(userName);
        sur.setPassWord(pwd);
        sur.setSignUpResult("Sent");
        sur.setMessage("Please Approve");
        sur.setFirstName(firstName);
        sur.setLastName(lastName);
        sur.setAge(age);
        sur.setRole(r);
        sur.setCategory1(categ1);
        sur.setCategory2(categ2);
        sur.setCategory3(categ3);
        sur.setCardNumber(number);
        sur.setExpDate(expiryDate);
        sur.setCvvNumber(cvvNumber);
        sur.setBalance(balance);
        sur.setLine1Address(line1Add);
        sur.setLine2Address(line2Add);
        sur.setCity(city);
        sur.setState(state);
        sur.setZipCode(code);
        sur.setNetwork(n);
      
        for(UserAccount userAccount : userAccountDirectory.getUserAccountList()) {
          
            if(userAccount.getUserName().equals("sysadmin")) {
                 
                userAccount.getWorkQueue().getWorkRequestList().add(sur);
                
            }
        }
    /*    Organization foundOrg = null;
            for(Organization org : enterprise.getOrganizationDirectory().getOrganizationList()) {
                if(org instanceof AdminOrganization) {
                    foundOrg = org;
                    break;
                }
            }
            if(foundOrg !=null) {
                foundOrg.getWorkQueue().getWorkRequestList().add(sur);
          //      userAccount.getWorkQueue().getWorkRequestList().add(aer);
            } else {
                JOptionPane.showMessageDialog(null, "Please create an Admin organization before sending enroll request");
                return;
            }*/
    
            firstNameJTextField.setText("");
            lastNameJTextField.setText("");
            ageJTextField.setText("");
            userNameJTextField.setText("");
            PasswordField.setText("");
            cardJTextField1.setText("");
            cardJTextField2.setText("");
            cardJTextField3.setText("");
            cardJTextField4.setText("");
            cvvNumberJTextField.setText("");
            balanceJTextField.setText("");
            cardDetailsJDateChooser.setDate(null);
            line1AddressJTextField.setText("");
            line2AddressJTextField.setText("");
            cityJTextField.setText("");
            stateJTextField.setText("");
            zipCodeJTextField.setText("");
            
            JOptionPane.showMessageDialog(null, "Request has been submitted for Signup", "Success", JOptionPane.WARNING_MESSAGE);
        }
        } catch(NullPointerException e)
        {
            JOptionPane.showMessageDialog(null, "Please enter valid date");
            return;
        }
    }//GEN-LAST:event_signUpJButtonActionPerformed

    private void ageJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ageJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ageJTextFieldActionPerformed

    private void category2JComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_category2JComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_category2JComboBoxActionPerformed

    private void line2AddressJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_line2AddressJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_line2AddressJTextFieldActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField PasswordField;
    private javax.swing.JTextField ageJTextField;
    private javax.swing.JTextField balanceJTextField;
    private com.toedter.calendar.JDateChooser cardDetailsJDateChooser;
    private javax.swing.JTextField cardJTextField1;
    private javax.swing.JTextField cardJTextField2;
    private javax.swing.JTextField cardJTextField3;
    private javax.swing.JTextField cardJTextField4;
    private javax.swing.JComboBox category1JComboBox;
    private javax.swing.JComboBox category2JComboBox;
    private javax.swing.JComboBox category3JComboBox;
    private javax.swing.JTextField cityJTextField;
    private javax.swing.JComboBox consumerRoleJComboBox;
    private javax.swing.JTextField cvvNumberJTextField;
    private javax.swing.JTextField firstNameJTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField lastNameJTextField;
    private javax.swing.JTextField line1AddressJTextField;
    private javax.swing.JTextField line2AddressJTextField;
    private javax.swing.JComboBox networkJComboBox;
    private javax.swing.JButton signUpJButton;
    private javax.swing.JTextField stateJTextField;
    private javax.swing.JTextField userNameJTextField;
    private javax.swing.JTextField zipCodeJTextField;
    // End of variables declaration//GEN-END:variables
}
