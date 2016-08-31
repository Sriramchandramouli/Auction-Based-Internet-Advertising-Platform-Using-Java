/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Order;

import java.util.ArrayList;

/**
 *
 * @author Sriram
 */
public class MasterOrderCatalog {
    
    private ArrayList<Order>orderCatalogList;

    public MasterOrderCatalog() {
        orderCatalogList = new ArrayList<>();
        
    }

    public ArrayList<Order> getOrderCatalogList() {
        return orderCatalogList;
    }

    public void setOrderCatalogList(ArrayList<Order> orderCatalogList) {
        this.orderCatalogList = orderCatalogList;
    }
    
    public Order addOrder(Order order) {
        orderCatalogList.add(order);
        return order;
    }
    
}
