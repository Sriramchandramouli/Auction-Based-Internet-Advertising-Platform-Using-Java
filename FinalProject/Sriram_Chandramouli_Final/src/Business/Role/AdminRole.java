/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.Consumer.ConsumerDirectory;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.ConsumerOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.AdministrativeRole.AdminWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Sriram
 */
public class AdminRole extends Role{
    ConsumerDirectory consumerDirectory;
    
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount userAccount, Organization organization, Enterprise enterprise, EcoSystem business) {
        
        ConsumerOrganization consumerOrganization;
        for(Organization org : enterprise.getOrganizationDirectory().getOrganizationList()){
            
            if(org.getName().equals(Organization.Type.Consumer.getValue())) {
                
                consumerOrganization = (ConsumerOrganization) org;
                consumerDirectory = consumerOrganization.getConsumerDirectory();
                System.out.println("Inside Admin " + consumerDirectory);
            }
        }
        
                
        return new AdminWorkAreaJPanel(userProcessContainer, enterprise,consumerDirectory, business); 
        
    }

    
    
}
