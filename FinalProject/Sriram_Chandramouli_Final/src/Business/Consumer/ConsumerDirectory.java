/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Consumer;

import java.util.ArrayList;

/**
 *
 * @author Sriram
 */
public class ConsumerDirectory {
    
    private ArrayList<Consumer> consumerList;

    public ConsumerDirectory() {
        consumerList = new ArrayList<>();
    }

    public ArrayList<Consumer> getConsumerList() {
        return consumerList;
    }
    
    public Consumer addConsumer() {
        Consumer consumer = new Consumer();
        consumerList.add(consumer);
        return consumer;
    }
    
    public void removeConsumer(Consumer consumer) {
        consumerList.remove(consumer);
    }
}
