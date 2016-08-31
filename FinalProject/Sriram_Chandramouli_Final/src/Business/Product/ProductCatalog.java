/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Product;

import java.util.ArrayList;

/**
 *
 * @author Sriram
 */
public class ProductCatalog {
    
    private ArrayList<Product> productList;

    public ProductCatalog() {
        productList = new ArrayList<>();
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }
   
    public Product addProduct() {
        Product product = new Product();
        productList.add(product);
        return product;
    }
    
    public void deleteProduct(Product product) {
        productList.remove(product);
    }
    
    public Product searchProduct(int id) {
        for(Product product : productList) {
            if(product.getModelNumber() == id) {
                return product;
            }
        }
        return null;
    }
}
