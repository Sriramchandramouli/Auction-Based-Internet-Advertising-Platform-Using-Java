/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Supplier;

import Business.Person.Person;
import Business.Product.ProductCatalog;

/**
 *
 * @author Sriram
 */
public class Supplier extends Person{
    
    private ProductCatalog productCatalog;

    public Supplier() {
       
        productCatalog = new ProductCatalog();
        
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
