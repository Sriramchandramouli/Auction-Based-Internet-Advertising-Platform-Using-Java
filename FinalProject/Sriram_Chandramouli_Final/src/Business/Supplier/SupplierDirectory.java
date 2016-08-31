/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Supplier;

import Business.Product.Product;
import java.util.ArrayList;

/**
 *
 * @author Sriram
 */
public class SupplierDirectory {
    
    private ArrayList<Supplier> supplierList;

    public SupplierDirectory() {
        supplierList = new ArrayList<>();
    }

    public ArrayList<Supplier> getSupplierList() {
        return supplierList;
    }

    public void setSupplierList(ArrayList<Supplier> supplierList) {
        this.supplierList = supplierList;
    }
    
    public Supplier addSupplier() {
        Supplier supplier = new Supplier();
        supplierList.add(supplier);
        return supplier;
    }
    
    public void deleteSupplier(Supplier supplier) {
        supplierList.remove(supplier);
    }
    
    public Supplier searchSupplier(String name) {
        for(Supplier supplier : supplierList) {
            if(supplier.getFirstName().equals(name)) {
                return supplier;
            }
        }
        return null;
    }
    
    public Product searchProduct(String name) {
        for(Supplier supplier : supplierList) {
            for(Product product: supplier.getProductCatalog().getProductList()) {
            if(product.getProductName().equals(name)) {
                return product;
            }
        }
        
    }
        return null;
    }
    
}
