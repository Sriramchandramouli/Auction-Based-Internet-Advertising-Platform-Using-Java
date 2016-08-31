/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.Advertiser.Advertiser;
import Business.Consumer.ViewHistoryList;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.AdvertiserOrganization;
import Business.Organization.ConsumerOrganization;
import Business.Organization.Organization;
import Business.Organization.PublisherOrganization;
import Business.Publisher.PublisherDirectory;
import Business.UserAccount.UserAccount;
import UserInterface.AdvertiserRole.AdvertiserWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Sriram
 */
public class AdvertiserRole extends Role{
    
    PublisherOrganization publisherOrganization;
    PublisherDirectory publisherDirectory;
    ViewHistoryList viewHistoryList;

    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount userAccount, Organization organization, Enterprise enterprise, EcoSystem business) {
        
        for(Organization org : enterprise.getOrganizationDirectory().getOrganizationList()){
            
            if(org.getName().equals(Organization.Type.Publisher.getValue())) {
                
                publisherOrganization = (PublisherOrganization) org;
                publisherDirectory = publisherOrganization.getPublisherDirectory();
                
            }
        }
        
        for(Organization org : enterprise.getOrganizationDirectory().getOrganizationList()){
            
            if(org.getName().equals(Organization.Type.Consumer.getValue())) {
                
                ConsumerOrganization consumerOrganization = (ConsumerOrganization) org;
                viewHistoryList = consumerOrganization.getViewHistoryList();
                
            }
        }
        
        AdvertiserOrganization advertiserOrganization = (AdvertiserOrganization) organization;
        advertiserOrganization.getAdvertiserDirectory();
        Advertiser advertiser = (Advertiser) userAccount.getPerson();
        
        return new AdvertiserWorkAreaJPanel(userProcessContainer,advertiser,userAccount,publisherDirectory,enterprise,viewHistoryList,publisherOrganization);
    }

   
}
