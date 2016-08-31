/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Advertiser;

import Business.Advertisement.AdvertisementCatalog;
import Business.Person.Person;
import Business.Product.ProductCatalog;

/**
 *
 * @author Sriram
 */
public class Advertiser extends Person{
    
    private AdvertisementCatalog advertisementCatalog;
    private ProductCatalog productCatalog;

    public Advertiser() {
        
        advertisementCatalog = new AdvertisementCatalog();
        productCatalog = new ProductCatalog();
    }

    
    public AdvertisementCatalog getAdvertisementCatalog() {
        return advertisementCatalog;
    }

    public void setAdvertisementCatalog(AdvertisementCatalog advertisementCatalog) {
        this.advertisementCatalog = advertisementCatalog;
    }

    public ProductCatalog getProductCatalog() {
        return productCatalog;
    }

    public void setProductCatalog(ProductCatalog productCatalog) {
        this.productCatalog = productCatalog;
    }
    

    @Override
    public String toString() {
        return super.getFirstName(); 
    }
    
}
