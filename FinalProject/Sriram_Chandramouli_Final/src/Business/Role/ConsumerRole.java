/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.Consumer.Consumer;
import Business.Consumer.ViewHistoryList;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Order.MasterOrderCatalog;
import Business.Organization.ConsumerOrganization;
import Business.Organization.Organization;
import Business.Organization.PublisherOrganization;
import Business.Organization.SupplierOrganization;
import Business.Supplier.SupplierDirectory;
import Business.UserAccount.UserAccount;
import UserInterface.ConsumerRole.ConsumerWorkAreaJPanel;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author Sriram
 */
public class ConsumerRole extends Role{
    
    SupplierDirectory supplierDirectory;
    MasterOrderCatalog masterOrderCatalog;
    Consumer consumer;
    PublisherOrganization publisherOrganization;
    ViewHistoryList viewHistoryList;

    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount userAccount, Organization organization, Enterprise enterprise, EcoSystem business) {
        
        for(Organization org : enterprise.getOrganizationDirectory().getOrganizationList()){
           
            if(org.getName().equals(Organization.Type.Supplier.getValue())) {
               
                SupplierOrganization supplierOrganization = (SupplierOrganization) org;
                supplierDirectory = supplierOrganization.getSupplierDirectory();
                
            }
        }
        
       for(Organization o : enterprise.getOrganizationDirectory().getOrganizationList()){
           
            if(o.getName().equals(Organization.Type.Publisher.getValue())) {
               
                publisherOrganization = (PublisherOrganization) o;
              
            }
        }
            ConsumerOrganization consumerOrganization = (ConsumerOrganization) organization;
            consumerOrganization.getConsumerDirectory();
            masterOrderCatalog = consumerOrganization.getMasterOrderCatalog();
            viewHistoryList = consumerOrganization.getViewHistoryList();
            consumer = (Consumer) userAccount.getConsumer();
            
            
            
        try {
            //  return new CustomerWorkAreaJPanel(userProcessContainer, supplierDirectory, masterOrderCatalog, consumer, publisherOrganization);
            return new ConsumerWorkAreaJPanel(userProcessContainer, supplierDirectory, masterOrderCatalog, consumer, publisherOrganization, userAccount, viewHistoryList);
        } catch (IOException ex) {
            Logger.getLogger(ConsumerRole.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
}
