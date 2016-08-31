/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Consumer.ConsumerDirectory;
import Business.Consumer.ViewHistoryList;
import Business.Order.MasterOrderCatalog;
import Business.Role.ConsumerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Sriram
 */
public class ConsumerOrganization extends Organization{

    private ConsumerDirectory consumerDirectory;
    private MasterOrderCatalog masterOrderCatalog;
    private ViewHistoryList viewHistoryList;
    public ConsumerOrganization() {
        super(Organization.Type.Consumer.getValue());
        consumerDirectory = new ConsumerDirectory();
        masterOrderCatalog = new MasterOrderCatalog();
        viewHistoryList = new ViewHistoryList();
    }

    public ConsumerDirectory getConsumerDirectory() {
        return consumerDirectory;
    }

    public void setConsumerDirectory(ConsumerDirectory consumerDirectory) {
        this.consumerDirectory = consumerDirectory;
    }

    

    public MasterOrderCatalog getMasterOrderCatalog() {
        return masterOrderCatalog;
    }

    public void setMasterOrderCatalog(MasterOrderCatalog masterOrderCatalog) {
        this.masterOrderCatalog = masterOrderCatalog;
    }

    public ViewHistoryList getViewHistoryList() {
        return viewHistoryList;
    }

    
    
    
 
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> role = new ArrayList<>();
        role.add(new ConsumerRole());
        return role;
        
    }
    
}
