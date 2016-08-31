/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Order.MasterOrderCatalog;
import Business.Organization.ConsumerOrganization;
import Business.Organization.Organization;
import Business.Organization.SupplierOrganization;
import Business.Supplier.Supplier;
import Business.UserAccount.UserAccount;
import UserInterface.SupplierRole.SupplierWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Sriram
 */
public class SupplierRole extends Role{
    
    MasterOrderCatalog masterOrderCatalog;

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount userAccount, Organization organization, Enterprise enterprise, EcoSystem business) {
        
        for(Organization org : enterprise.getOrganizationDirectory().getOrganizationList()){
            
            if(org.getName().equals(Organization.Type.Consumer.getValue())) {
                
                ConsumerOrganization consumerOrganization = (ConsumerOrganization) org;
                
                masterOrderCatalog = consumerOrganization.getMasterOrderCatalog();
            }
        }
            SupplierOrganization supplierOrganization = (SupplierOrganization) organization;
            supplierOrganization.getSupplierDirectory();
            Supplier supplier = (Supplier) userAccount.getPerson();
            return new SupplierWorkAreaJPanel(userProcessContainer, supplier, masterOrderCatalog, userAccount);
    }

    
}
