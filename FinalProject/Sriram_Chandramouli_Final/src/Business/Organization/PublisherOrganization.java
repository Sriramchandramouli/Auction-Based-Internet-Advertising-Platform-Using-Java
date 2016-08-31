/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Publisher.PublisherDirectory;
import Business.Role.PublisherRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Sriram
 */
public class PublisherOrganization extends Organization{

    private PublisherDirectory publisherDirectory;
    
    public PublisherOrganization() {
        super(Organization.Type.Publisher.getValue());
        publisherDirectory = new PublisherDirectory();
    }

    public PublisherDirectory getPublisherDirectory() {
        return publisherDirectory;
    }

    public void setPublisherDirectory(PublisherDirectory publisherDirectory) {
        this.publisherDirectory = publisherDirectory;
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> role = new ArrayList<>();
       role.add(new PublisherRole());
       return role;
        
    }
    
}
