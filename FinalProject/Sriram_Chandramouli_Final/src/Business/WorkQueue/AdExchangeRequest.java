/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Adspace.Adspace;
import Business.Advertisement.Advertisement;
import Business.Publisher.Publisher;

/**
 *
 * @author Sriram
 */
public class AdExchangeRequest extends WorkRequest{
    
    private String enrollResult;
    private Publisher publisher;
    private Adspace adSpace;
    private float bidRate;
    private Advertisement advertisement;

    public String getEnrollResult() {
        return enrollResult;
    }

    public void setEnrollResult(String enrollResult) {
        this.enrollResult = enrollResult;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Adspace getAdSpace() {
        return adSpace;
    }

    public void setAdSpace(Adspace adSpace) {
        this.adSpace = adSpace;
    }

    
    public float getBidRate() {
        return bidRate;
    }

    public void setBidRate(float bidRate) {
        this.bidRate = bidRate;
    }

    public Advertisement getAdvertisement() {
        return advertisement;
    }

    public void setAdvertisement(Advertisement advertisement) {
        this.advertisement = advertisement;
    }
    
    
    
}
