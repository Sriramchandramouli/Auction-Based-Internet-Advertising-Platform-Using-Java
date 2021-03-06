/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.AdvertiserRole;

import Business.Consumer.ViewHistory;
import Business.Consumer.ViewHistoryList;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Sriram
 */
public class ProductHistoryPerformanceJPanel extends javax.swing.JPanel {

    JPanel userProcessContainer;
    ViewHistoryList viewHistoryList;
    private JFreeChart chart;
    public ProductHistoryPerformanceJPanel(JPanel upc, ViewHistoryList viewHistoryList) {
        initComponents();
        this.userProcessContainer = upc;
        this.viewHistoryList = viewHistoryList;
        displayChart();
    }
    
    private void displayChart() {
        this.chart = createChart(newDataset(viewHistoryList));
        ChartPanel chartPanel = new ChartPanel(chart);  
        this.add(chartPanel);
        
        this.validate();   
    }
    
     private JFreeChart createChart(CategoryDataset dataset) {

        JFreeChart chart = ChartFactory.createBarChart("View Performance", "Product Name", "Count", dataset,PlotOrientation.VERTICAL,true,true,false);
        chart.setBackgroundPaint(Color.blue);

        CategoryPlot plot = (CategoryPlot) chart.getPlot();

        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        BarRenderer renderer = (BarRenderer) plot.getRenderer();
      
        org.jfree.chart.axis.CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryLabelPositions(
                CategoryLabelPositions.createUpRotationLabelPositions(
                        Math.PI / 5.0));
          
        return chart;

    }
     
    private CategoryDataset newDataset(ViewHistoryList vieHis) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for(ViewHistory viewHistory : viewHistoryList.getViewHistoryDirectory()) {

            String prdName = viewHistory.getProduct().getProductName();
            dataset.addValue(viewHistory.getCount(), prdName, prdName);
                 
        }
        return dataset;
    }
    
     

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backJButton = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        backJButton.setText("<<Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    // End of variables declaration//GEN-END:variables
}
