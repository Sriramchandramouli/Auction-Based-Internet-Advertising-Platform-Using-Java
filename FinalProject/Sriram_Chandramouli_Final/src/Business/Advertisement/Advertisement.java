/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Advertisement;

import Business.Product.Product;

/**
 *
 * @author Sriram
 */
public class Advertisement {
    
    private String name;
    private String ad;
    private Product product;
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    
    @Override
    public String toString() {
        return name;
    }
    
    
}
