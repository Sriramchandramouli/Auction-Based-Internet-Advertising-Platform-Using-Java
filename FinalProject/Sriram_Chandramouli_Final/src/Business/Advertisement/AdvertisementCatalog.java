/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Advertisement;

import java.util.ArrayList;

/**
 *
 * @author Sriram
 */
public class AdvertisementCatalog {
    
    private ArrayList<Advertisement> advertisementList;

    public AdvertisementCatalog() {
        
        advertisementList = new ArrayList<>();
    }

    public ArrayList<Advertisement> getAdvertisementList() {
        return advertisementList;
    }

    public void setAdvertisementList(ArrayList<Advertisement> advertisementList) {
        this.advertisementList = advertisementList;
    }
    
    public Advertisement addAdvertisement() {
       
        Advertisement advertisement = new Advertisement();
        advertisementList.add(advertisement);
        return advertisement;
    }
    
    public void removeAdvertisement(Advertisement advertisement) {
        advertisementList.remove(advertisement);
    }
}
