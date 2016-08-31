/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Advertiser.AdvertiserDirectory;
import Business.Role.AdvertiserRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Sriram
 */
public class AdvertiserOrganization extends Organization{
    
    private AdvertiserDirectory advertiserDirectory;

    public AdvertiserOrganization() {
        super(Organization.Type.Advertiser.getValue());
        advertiserDirectory = new AdvertiserDirectory();
    }

    public AdvertiserDirectory getAdvertiserDirectory() {
        return advertiserDirectory;
    }

    public void setAdvertiserDirectory(AdvertiserDirectory advertiserDirectory) {
        this.advertiserDirectory = advertiserDirectory;
    }
    
    

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> role = new ArrayList<>();
        role.add(new AdvertiserRole());
        return role;
    }
    
}
