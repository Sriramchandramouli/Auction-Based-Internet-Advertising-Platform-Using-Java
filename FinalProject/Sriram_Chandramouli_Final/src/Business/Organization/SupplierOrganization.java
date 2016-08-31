/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.Role;
import Business.Role.SupplierRole;
import Business.Supplier.SupplierDirectory;
import java.util.ArrayList;

/**
 *
 * @author Sriram
 */
public class SupplierOrganization extends Organization{

    private SupplierDirectory supplierDirectory;
    
    public SupplierOrganization() {
        super(Organization.Type.Supplier.getValue());
        supplierDirectory = new SupplierDirectory();
    }

    public SupplierDirectory getSupplierDirectory() {
        return supplierDirectory;
    }

    public void setSupplierDirectory(SupplierDirectory supplierDirectory) {
        this.supplierDirectory = supplierDirectory;
    }
    
    

    @Override
    public ArrayList<Role> getSupportedRole() {
       ArrayList<Role> role = new ArrayList<>();
       role.add(new SupplierRole());
       return role;
        
    }
    
}
