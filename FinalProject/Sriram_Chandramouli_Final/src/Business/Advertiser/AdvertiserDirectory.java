/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Advertiser;

import java.util.ArrayList;

/**
 *
 * @author Sriram
 */
public class AdvertiserDirectory {
    
    private ArrayList<Advertiser> advertiserList;

    public AdvertiserDirectory() {
        
        advertiserList = new ArrayList<>();
    }

    public ArrayList<Advertiser> getAdvertiserList() {
        return advertiserList;
    }

    public void setAdvertiserList(ArrayList<Advertiser> advertiserList) {
        this.advertiserList = advertiserList;
    }
    
    public Advertiser addAdvertiser() {
        Advertiser advertiser = new Advertiser();
        advertiserList.add(advertiser);
        return advertiser;
    }
    
    public void deleteAdvertiser(Advertiser advertiser) {
        advertiserList.remove(advertiser);
    }
}
