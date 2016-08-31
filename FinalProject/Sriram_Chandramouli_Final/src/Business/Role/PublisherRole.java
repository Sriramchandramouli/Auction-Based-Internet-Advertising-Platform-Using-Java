/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.Advertiser.AdvertiserDirectory;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.AdvertiserOrganization;
import Business.Organization.Organization;
import Business.Organization.PublisherOrganization;
import Business.Publisher.Publisher;
import Business.UserAccount.UserAccount;
import UserInterface.PublisherRole.PublisherWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Sriram
 */
public class PublisherRole extends Role{
    
    AdvertiserDirectory advertiserDirectory;

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount userAccount, Organization organization, Enterprise enterprise, EcoSystem business) {
        
        
         for(Organization org : enterprise.getOrganizationDirectory().getOrganizationList()){
           
            if(org.getName().equals(Organization.Type.Advertiser.getValue())) {
               
                AdvertiserOrganization advertiserOrganization = (AdvertiserOrganization) org;
                advertiserDirectory = advertiserOrganization.getAdvertiserDirectory();
                
            }
        }
        PublisherOrganization publisherOrganization = (PublisherOrganization) organization;
        publisherOrganization.getPublisherDirectory();
        Publisher publisher = (Publisher) userAccount.getPerson();
        return new PublisherWorkAreaJPanel(userProcessContainer,publisher,userAccount,publisherOrganization,advertiserDirectory);
    }

}
