/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Order;

import Business.Product.Product;
import java.util.ArrayList;

/**
 *
 * @author Sriram
 */
public class Order {
    
    private ArrayList<OrderItem> orderItemList;
    private static int count = 0;
    private int orderNumber;
    private int consumerId;
    
    public Order() {
        count++;
        orderNumber = count;
        orderItemList = new ArrayList<>();
    }

    public ArrayList<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(ArrayList<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public int getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(int consumerId) {
        this.consumerId = consumerId;
    }

    
    
     public void addOrderItem(Product p, int quantity, String suppName) {
      OrderItem orderItem = new OrderItem();
      orderItem.setProduct(p);
      orderItem.setQuantity(quantity);
      orderItem.setSupplierName(suppName);
      orderItemList.add(orderItem);
              
    }
     
     public void addAdvOrderItem(Product p, int quantity, String advName, String consumer) {
      OrderItem orderItem = new OrderItem();
      orderItem.setProduct(p);
      orderItem.setQuantity(quantity);
      orderItem.setAdvName(advName);
      orderItem.setCustomerName(consumer);
      orderItemList.add(orderItem);
              
    }
    
    public void deleteOrderItem(OrderItem oi) {
        orderItemList.remove(oi);
    }

    @Override
    public String toString() {
        return String.valueOf(orderNumber);
    }
}
