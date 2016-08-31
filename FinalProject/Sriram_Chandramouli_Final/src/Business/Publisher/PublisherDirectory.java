/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Publisher;

import java.util.ArrayList;

/**
 *
 * @author Sriram
 */
public class PublisherDirectory {
    
    private ArrayList<Publisher> publisherList;

    public PublisherDirectory() {
        
        publisherList = new ArrayList<>();
    }

    public ArrayList<Publisher> getPublisherList() {
        return publisherList;
    }

    public void setPublisherList(ArrayList<Publisher> publisherList) {
        this.publisherList = publisherList;
    }
    
    public Publisher addPublisher(){
        Publisher publisher = new Publisher();
        publisherList.add(publisher);
        return publisher;
    }
    
    public void deletePublisher(Publisher publisher) {
        publisherList.remove(publisher);
    }
    
}
