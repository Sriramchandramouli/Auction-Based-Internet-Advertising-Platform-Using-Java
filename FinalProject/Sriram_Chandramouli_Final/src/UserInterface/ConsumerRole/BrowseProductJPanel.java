/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.ConsumerRole;

import Business.Consumer.Consumer;
import Business.Consumer.ViewHistory;
import Business.Consumer.ViewHistoryList;
import Business.Order.MasterOrderCatalog;
import Business.Order.Order;
import Business.Order.OrderItem;
import Business.Organization.PublisherOrganization;
import Business.Product.Product;
import Business.Supplier.Supplier;
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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sriram
 */
public class BrowseProductJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Consumer consumer;
    private SupplierDirectory supplierDirectory;
    private MasterOrderCatalog masterOrderCatalog;
    private ViewHistoryList viewHistoryList;
    private PublisherOrganization publisherOrganization;
    private UserAccount userAccount;
    int count=0;
    Order order;
    private AdExchangeRequest aer,aer1,aer2,aer3;
    private Boolean isCheckedOut = false;
    
    public BrowseProductJPanel(JPanel upc, Consumer consumer, SupplierDirectory supplierDirectory, MasterOrderCatalog masterOrderCatalog, ViewHistoryList viewHistoryList, PublisherOrganization publisherOrganization, UserAccount userAccount) throws IOException {
        initComponents();
        this.userProcessContainer=upc;
        this.consumer = consumer;
        this.supplierDirectory=supplierDirectory;
        this.masterOrderCatalog=masterOrderCatalog;
        this.viewHistoryList = viewHistoryList;
        this.publisherOrganization = publisherOrganization;
        this.userAccount = userAccount;
        consumerNameJTextField.setText(consumer.getFirstName());
       
        populateCombo(); 
        if (!isCheckedOut)
        {
            order = new Order();
        }
        
        populateFavCategory1Advertisement();
        populateFavCategory2Advertisement();
        populateFavCategory3Advertisement();
        populateMostFavouriteCategory();
     /*   if(aer!=null && aer1!=null && aer2!=null) {
        populateMostFavouriteCategory(aer,aer1,aer2);
        } */
    }
    
    private void populateCombo()
    {
        orderJComboBox.removeAllItems();
        for (Supplier supplier: supplierDirectory.getSupplierList()){
            orderJComboBox.addItem(supplier);
        }
        populateProductDetailsTable();
    }

    private void populateProductDetailsTable() {
        
        Supplier supplier = (Supplier)orderJComboBox.getSelectedItem();
        
        if(supplier != null)
        {
        DefaultTableModel dtm = (DefaultTableModel)productDetailJTable.getModel();
        dtm.setRowCount(0);
        
        for ( Product product : supplier.getProductCatalog().getProductList()) {
        
         Object row[]= new Object[4];  
         row[0] = product;   
         row[1] = product.getModelNumber();
         row[2] = product.getPrice();
         row[3] = product.getAvailability();
         dtm.addRow(row);
    }
        }
    }
    
    
   
   private void populateOrderItem(Order or) {
            
            DefaultTableModel dtm = (DefaultTableModel)orderItemJTable.getModel();
            dtm.setRowCount(0);
            
            for (OrderItem oi : or.getOrderItemList()) {
                Object[] obj = new Object[4];
                obj[0] = oi;
                obj[1] = oi.getProduct().getPrice();
                obj[2] = oi.getQuantity();
                obj[3] = oi.getQuantity() * oi.getProduct().getPrice();
                dtm.addRow(obj);
            }
        }
   
   private void populateFavCategory1Advertisement() throws IOException {
        
        try {
        float maxVal = 0;
        for (WorkRequest workRequest : publisherOrganization.getWorkQueue().getWorkRequestList()) {
            AdExchangeRequest req = (AdExchangeRequest) workRequest;
            if((req.getAdSpace().getSpaceName().equals("BackPageAdvertisement")) && (req.getEnrollResult().equals("Approved"))) {
            if(req.getAdvertisement().getProduct().getCategory().equals(consumer.getCategory1())&& (req.getEnrollResult().equals("Approved"))) {
               
                if (req.getBidRate() > maxVal) {
                    maxVal = (float) req.getBidRate();
                    aer = req;
                    
                    System.out.println("The maxval is" + maxVal);
                    System.out.println("The maxval is" + aer.getAdvertisement().getName());
                }
            }
            }
        }
        String fileLoc = aer.getAdvertisement().getProduct().getProductImage();
        File file = new File(fileLoc);
        BufferedImage bi = aer.getAdvertisement().getProduct().scaleImage(ImageIO.read(file), 177, 177);
        favCat1JLabel.setIcon(new ImageIcon(bi));
       // favCat1JLabel.setText(String.valueOf(aer.getAdvertisement().getAd()));
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
            if((req.getAdSpace().getSpaceName().equals("BackPageAdvertisement")) && (req.getEnrollResult().equals("Approved"))) {
            if(req.getAdvertisement().getProduct().getCategory().equals(consumer.getCategory2())&& (req.getEnrollResult().equals("Approved"))) {
               
                if (req.getBidRate() > maxVal) {
                    maxVal = (float) req.getBidRate();
                    aer1 = req;
                    
                    System.out.println("The maxval is" + maxVal);
                    System.out.println("The maxval is" + aer1.getAdvertisement().getName());
                }
            }
            }
        }
        String fileLoc = aer1.getAdvertisement().getProduct().getProductImage();
        File file = new File(fileLoc);
        BufferedImage bi = aer1.getAdvertisement().getProduct().scaleImage(ImageIO.read(file), 177, 177);
        favCat2JLabel.setIcon(new ImageIcon(bi));
      //  favCat2JLabel.setText(String.valueOf(aer1.getAdvertisement().getAd()));
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
            if((req.getAdSpace().getSpaceName().equals("BackPageAdvertisement")) && (req.getEnrollResult().equals("Approved"))) {
            if(req.getAdvertisement().getProduct().getCategory().equals(consumer.getCategory3())&& (req.getEnrollResult().equals("Approved"))) {
               
                if (req.getBidRate() > maxVal) {
                    maxVal = (float) req.getBidRate();
                    aer2 = req;
                    
                    System.out.println("The maxval is" + maxVal);
                    System.out.println("The maxval is" + aer2.getAdvertisement().getName());
                }
            }
            }
        }
        String fileLoc = aer2.getAdvertisement().getProduct().getProductImage();
        File file = new File(fileLoc);
        BufferedImage bi = aer2.getAdvertisement().getProduct().scaleImage(ImageIO.read(file), 177, 177);
        favCat3JLabel.setIcon(new ImageIcon(bi));
      //  favCat3JLabel.setText(String.valueOf(aer2.getAdvertisement().getAd()));
        } catch(NullPointerException e)
        {
            System.out.print("NullPointerException caught");
        }
    }
    
  /*  private void populateMostFavouriteCategory(AdExchangeRequest aer, AdExchangeRequest aer1, AdExchangeRequest aer2) throws IOException {
        
        try {
        if ((aer.getBidRate() > aer1.getBidRate()) && (aer.getBidRate() > aer2.getBidRate())) {
            
            String fileLoc = aer.getAdvertisement().getProduct().getProductImage();
             File file = new File(fileLoc);
             BufferedImage bi = aer.getAdvertisement().getProduct().scaleImage(ImageIO.read(file), 177, 177);
            topPageJLabel.setIcon(new ImageIcon(bi));
        //    topPageJLabel.setText(String.valueOf(aer.getAdvertisement().getAd()));
            aer3 = aer;
            
        } else if ((aer1.getBidRate() > aer.getBidRate()) && (aer1.getBidRate() > aer2.getBidRate())) {
           
            String fileLoc = aer1.getAdvertisement().getProduct().getProductImage();
             File file = new File(fileLoc);
             BufferedImage bi = aer1.getAdvertisement().getProduct().scaleImage(ImageIO.read(file), 177, 177);
            topPageJLabel.setIcon(new ImageIcon(bi));
       //     topPageJLabel.setText(String.valueOf(aer1.getAdvertisement().getAd()));
            aer3 = aer1;
            
        } else if ((aer2.getBidRate() > aer.getBidRate()) && (aer2.getBidRate() > aer1.getBidRate())) {
            
            String fileLoc = aer2.getAdvertisement().getProduct().getProductImage();
             File file = new File(fileLoc);
             BufferedImage bi = aer2.getAdvertisement().getProduct().scaleImage(ImageIO.read(file), 177, 177);
            topPageJLabel.setIcon(new ImageIcon(bi));
         //   topPageJLabel.setText(String.valueOf(aer2.getAdvertisement().getAd()));
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
            if((req.getAdSpace().getSpaceName().equals("BackPageAdvertisement")) && (req.getEnrollResult().equals("Approved"))) {
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
        topPageJLabel.setIcon(new ImageIcon(bi));
      //  favCat3JLabel.setText(String.valueOf(aer2.getAdvertisement().getAd()));
        } catch(NullPointerException e)
        {
            System.out.print("NullPointerException caught");
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        orderJComboBox = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        productDetailJTable = new javax.swing.JTable();
        viewJButton1 = new javax.swing.JButton();
        quantityJSpinner = new javax.swing.JSpinner();
        addCartJButton = new javax.swing.JButton();
        quantityJLabel = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        orderItemJTable = new javax.swing.JTable();
        viewOrderJButton = new javax.swing.JButton();
        removeItemJButton = new javax.swing.JButton();
        modifyQuantityJButton = new javax.swing.JButton();
        modifyJTextField = new javax.swing.JTextField();
        backJButton = new javax.swing.JButton();
        checkOutJButton = new javax.swing.JButton();
        customerNameJLabel1 = new javax.swing.JLabel();
        consumerNameJTextField = new javax.swing.JTextField();
        refreshJButton1 = new javax.swing.JButton();
        favCat3JLabel = new javax.swing.JLabel();
        topPageJLabel = new javax.swing.JLabel();
        viewProductDetailJLabel = new javax.swing.JLabel();
        favCat1JLabel = new javax.swing.JLabel();
        favCat2JLabel = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        orderJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        orderJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderJComboBoxActionPerformed(evt);
            }
        });

        productDetailJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ProductName", "ProductID", "ProductPrice", "ProductAvailability"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Integer.class
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
        jScrollPane1.setViewportView(productDetailJTable);
        if (productDetailJTable.getColumnModel().getColumnCount() > 0) {
            productDetailJTable.getColumnModel().getColumn(0).setResizable(false);
            productDetailJTable.getColumnModel().getColumn(1).setResizable(false);
            productDetailJTable.getColumnModel().getColumn(2).setResizable(false);
            productDetailJTable.getColumnModel().getColumn(3).setResizable(false);
        }

        viewJButton1.setText("ViewProductDetails");
        viewJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewJButton1ActionPerformed(evt);
            }
        });

        addCartJButton.setText("ADD TO CART");
        addCartJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCartJButtonActionPerformed(evt);
            }
        });

        quantityJLabel.setText("Quantity");

        orderItemJTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(orderItemJTable);
        if (orderItemJTable.getColumnModel().getColumnCount() > 0) {
            orderItemJTable.getColumnModel().getColumn(0).setResizable(false);
            orderItemJTable.getColumnModel().getColumn(1).setResizable(false);
            orderItemJTable.getColumnModel().getColumn(2).setResizable(false);
            orderItemJTable.getColumnModel().getColumn(3).setResizable(false);
        }

        viewOrderJButton.setText("ViewOrderItemDetails");
        viewOrderJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewOrderJButtonActionPerformed(evt);
            }
        });

        removeItemJButton.setText("Remove Item");
        removeItemJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeItemJButtonActionPerformed(evt);
            }
        });

        modifyQuantityJButton.setText("ModifyQuantity");
        modifyQuantityJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyQuantityJButtonActionPerformed(evt);
            }
        });

        backJButton.setText("<<Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        checkOutJButton.setText("CheckOut");
        checkOutJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkOutJButtonActionPerformed(evt);
            }
        });

        customerNameJLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        customerNameJLabel1.setText("ConsumerName");

        consumerNameJTextField.setEditable(false);

        refreshJButton1.setText("Refresh");
        refreshJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshJButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(orderJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(customerNameJLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(consumerNameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(viewJButton1)
                                .addGap(74, 74, 74)
                                .addComponent(quantityJLabel)
                                .addGap(18, 18, 18)
                                .addComponent(quantityJSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(addCartJButton))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGap(69, 69, 69)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(viewOrderJButton)
                                            .addComponent(backJButton))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(modifyJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(modifyQuantityJButton))
                                            .addComponent(refreshJButton1))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(checkOutJButton)
                                    .addComponent(removeItemJButton))))
                        .addContainerGap(113, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customerNameJLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(consumerNameJTextField))
                .addGap(18, 18, 18)
                .addComponent(orderJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(viewJButton1)
                    .addComponent(quantityJSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addCartJButton)
                    .addComponent(quantityJLabel))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(viewOrderJButton)
                    .addComponent(modifyQuantityJButton)
                    .addComponent(removeItemJButton)
                    .addComponent(modifyJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backJButton)
                    .addComponent(checkOutJButton)
                    .addComponent(refreshJButton1))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 61, 680, 510));

        favCat3JLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                favCat3JLabelMouseClicked(evt);
            }
        });
        add(favCat3JLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 560, 150, 100));

        topPageJLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                topPageJLabelMouseClicked(evt);
            }
        });
        add(topPageJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 20, 210, 160));

        viewProductDetailJLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        viewProductDetailJLabel.setText("BROWSE PRODUCT PANEL");
        add(viewProductDetailJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        favCat1JLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                favCat1JLabelMouseClicked(evt);
            }
        });
        add(favCat1JLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 210, 190, 170));

        favCat2JLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                favCat2JLabelMouseClicked(evt);
            }
        });
        add(favCat2JLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 370, 210, 200));
    }// </editor-fold>//GEN-END:initComponents

    private void orderJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderJComboBoxActionPerformed
        populateProductDetailsTable();
    }//GEN-LAST:event_orderJComboBoxActionPerformed

    private void viewJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewJButton1ActionPerformed
       
        boolean flag = false;
        int selectedRow = productDetailJTable.getSelectedRow();
        if(selectedRow<0){

            JOptionPane.showMessageDialog(null, "Please select a product to view");
            return;
        }
        Product product = (Product)productDetailJTable.getValueAt(selectedRow, 0);
        
        
        String suppName = String.valueOf(orderJComboBox.getSelectedItem());
        
        for(ViewHistory viewHistory : viewHistoryList.getViewHistoryDirectory()){
            if(viewHistory.getSupplier().equals(suppName)) {
                if(viewHistory.getProduct().equals(product)) {
                    int cnt = viewHistory.getCount();
                    viewHistory.setCount(++cnt);
                    
                    flag = true;
                }
            }
         
        }
        
        if(!flag) {
           ViewHistory viewHistory = viewHistoryList.addViewHistory();
           viewHistory.setSupplier(suppName);
           viewHistory.setProduct(product);
           viewHistory.setCount(1);
          
        }
        ViewProductDetailJPanel vpj = new ViewProductDetailJPanel(userProcessContainer,product);
        userProcessContainer.add("ViewProductDetails",vpj);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        
    }//GEN-LAST:event_viewJButton1ActionPerformed

    private void addCartJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCartJButtonActionPerformed
        int selectedRow = productDetailJTable.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this,"Please select a product to add");
            return;
        }
        Product product =(Product)productDetailJTable.getValueAt(selectedRow, 0);
        int quantity = (Integer) quantityJSpinner.getValue();
        if ((quantity <= 0) || (quantity >product.getAvailability()) )
        {
            JOptionPane.showMessageDialog(null,"The quantity exceeds total available quantity");
            return;
        }

        boolean isIncluded = false;
       
        for (OrderItem oi : order.getOrderItemList())
        {
            
            if (oi.getProduct().getProductName().equals(product.getProductName()))
            {
                
                int newQuantity = (Integer) quantityJSpinner.getValue();
                if(newQuantity > oi.getQuantity() + product.getAvailability())
                {
                    return;
                }
                oi.setQuantity(newQuantity + oi.getQuantity());
                product.setAvailability(product.getAvailability()- quantity);
                isIncluded = true;
            }
        }
        //*  If the order Item is included*/
        if (!isIncluded)
        {
    //        if(order==null) {
    //            order = new Order();
    //        }
            String suppName = String.valueOf(orderJComboBox.getSelectedItem());
            order.addOrderItem(product, quantity, suppName);
            product.setAvailability(product.getAvailability()- quantity);
        }
      
        populateOrderItem(order);
        populateProductDetailsTable();
    }//GEN-LAST:event_addCartJButtonActionPerformed

    private void viewOrderJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewOrderJButtonActionPerformed
        int selectedRow = orderItemJTable.getSelectedRow();
        if(selectedRow<0){

            JOptionPane.showMessageDialog(null, "Please select an order to view");
            return;
        }
        OrderItem orderItem = (OrderItem)orderItemJTable.getValueAt(selectedRow, 0);
        ViewOrderItemJPanel voj = new ViewOrderItemJPanel(userProcessContainer,orderItem);
        userProcessContainer.add("ViewOrderItemDetails",voj);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_viewOrderJButtonActionPerformed

    private void removeItemJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeItemJButtonActionPerformed
        int selectedRow = orderItemJTable.getSelectedRow();
        if(selectedRow<0){

            JOptionPane.showMessageDialog(null, "Please select a product to remove");
            return;
        }
        OrderItem oi =(OrderItem)orderItemJTable.getValueAt(selectedRow, 0);

        for(Supplier supplier : supplierDirectory.getSupplierList() ) {
            for (Product product : supplier.getProductCatalog().getProductList() ) {
                if (oi.getProduct().getModelNumber() == product.getModelNumber()) {
                    product.setAvailability(product.getAvailability()+oi.getQuantity());
                }
            }
        }

        if(selectedRow>=0){
            int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to remove", "Warning", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                
                order.deleteOrderItem(oi);
            }
        }
        else{
            JOptionPane.showMessageDialog(this,"Please select a product to delete");
        }
    }//GEN-LAST:event_removeItemJButtonActionPerformed

    private void modifyQuantityJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyQuantityJButtonActionPerformed
        int selectedRow = orderItemJTable.getSelectedRow();
        if(selectedRow<0){

            JOptionPane.showMessageDialog(null, "Please select an item to modify");
            return;
        }
        OrderItem oi =(OrderItem)orderItemJTable.getValueAt(selectedRow, 0);

        int modifyQuantity = Integer.parseInt(modifyJTextField.getText());

        if (modifyQuantity > ((oi.getQuantity() + oi.getProduct().getAvailability()))) {
            JOptionPane.showMessageDialog(null, "Quantity is wrong");
            return;
        }
        int oldQuantity = oi.getQuantity();
        int oldAvailability = oi.getProduct().getAvailability();
        oi.getProduct().setAvailability(oldQuantity+ oldAvailability- modifyQuantity);
        oi.setQuantity(modifyQuantity);
        modifyJTextField.setText("");
        populateProductDetailsTable();
        populateOrderItem(order);
    }//GEN-LAST:event_modifyQuantityJButtonActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void checkOutJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkOutJButtonActionPerformed
       
    /*    int selectedRow = orderItemJTable.getSelectedRow();
        if(selectedRow<0) {
            JOptionPane.showMessageDialog(null, "Please select an order to checkout");
            return;
        }*/
        
        if(order.getOrderItemList().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please place an order before checkout");
            return;
        }
        order.setConsumerId(consumer.getConsumerId());
        masterOrderCatalog.addOrder(order);
        isCheckedOut = true;
         order = new Order();
         JOptionPane.showMessageDialog(null, "The order has been checked out");
    }//GEN-LAST:event_checkOutJButtonActionPerformed

    private void refreshJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshJButton1ActionPerformed
        populateProductDetailsTable();
        populateOrderItem(order);
        
    }//GEN-LAST:event_refreshJButton1ActionPerformed

    private void topPageJLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topPageJLabelMouseClicked
        
        PurchaseProductJPanel ppjp5 = null;
        try {
            ppjp5 = new PurchaseProductJPanel(userProcessContainer,masterOrderCatalog,aer3,userAccount,consumer);
        } catch (IOException ex) {
            Logger.getLogger(BrowseProductJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        userProcessContainer.add("PurchaseProduct5Panel",ppjp5);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_topPageJLabelMouseClicked

    private void favCat1JLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_favCat1JLabelMouseClicked
        
        PurchaseProductJPanel ppjp6 = null;
        try {
            ppjp6 = new PurchaseProductJPanel(userProcessContainer,masterOrderCatalog,aer,userAccount,consumer);
        } catch (IOException ex) {
            Logger.getLogger(BrowseProductJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        userProcessContainer.add("PurchaseProduct6Panel",ppjp6);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_favCat1JLabelMouseClicked

    private void favCat2JLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_favCat2JLabelMouseClicked
        PurchaseProductJPanel ppjp7 = null;
        try {
            ppjp7 = new PurchaseProductJPanel(userProcessContainer,masterOrderCatalog,aer1,userAccount,consumer);
        } catch (IOException ex) {
            Logger.getLogger(BrowseProductJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        userProcessContainer.add("PurchaseProduct7Panel",ppjp7);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_favCat2JLabelMouseClicked

    private void favCat3JLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_favCat3JLabelMouseClicked
        PurchaseProductJPanel ppjp8 = null;
        try {
            ppjp8 = new PurchaseProductJPanel(userProcessContainer,masterOrderCatalog,aer2,userAccount,consumer);
        } catch (IOException ex) {
            Logger.getLogger(BrowseProductJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        userProcessContainer.add("PurchaseProduct8Panel",ppjp8);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_favCat3JLabelMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addCartJButton;
    private javax.swing.JButton backJButton;
    private javax.swing.JButton checkOutJButton;
    private javax.swing.JTextField consumerNameJTextField;
    private javax.swing.JLabel customerNameJLabel1;
    private javax.swing.JLabel favCat1JLabel;
    private javax.swing.JLabel favCat2JLabel;
    private javax.swing.JLabel favCat3JLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField modifyJTextField;
    private javax.swing.JButton modifyQuantityJButton;
    private javax.swing.JTable orderItemJTable;
    private javax.swing.JComboBox orderJComboBox;
    private javax.swing.JTable productDetailJTable;
    private javax.swing.JLabel quantityJLabel;
    private javax.swing.JSpinner quantityJSpinner;
    private javax.swing.JButton refreshJButton1;
    private javax.swing.JButton removeItemJButton;
    private javax.swing.JLabel topPageJLabel;
    private javax.swing.JButton viewJButton1;
    private javax.swing.JButton viewOrderJButton;
    private javax.swing.JLabel viewProductDetailJLabel;
    // End of variables declaration//GEN-END:variables
}
