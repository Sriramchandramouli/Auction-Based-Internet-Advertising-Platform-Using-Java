/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;



import Business.Organization.Organization.Type;
import java.util.ArrayList;

/**
 *
 * @author Sriram
 */
public class OrganizationDirectory {
    
    private ArrayList<Organization> organizationList;
    
    public OrganizationDirectory() {
        
        organizationList = new ArrayList<>();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization (Type type) {
      Organization organization = null;
    /*  if(type.getValue().equals(Organization.Type.Admin.getValue())) {
           organization = new AdminOrganization();
           organizationList.add(organization);
        } else */
         if(type.getValue().equals(Organization.Type.Supplier.getValue())) {
           organization = new SupplierOrganization();
           organizationList.add(organization);
   /*     } else if(type.getValue().equals(Organization.Type.Consumer.getValue())) {
           organization = new ConsumerOrganization();
           organizationList.add(organization); */
       } else if(type.getValue().equals(Organization.Type.Publisher.getValue())) {
           organization = new PublisherOrganization();
           organizationList.add(organization);
       } else if(type.getValue().equals(Organization.Type.Advertiser.getValue())) {
           organization = new AdvertiserOrganization();
           organizationList.add(organization);
       }
       return organization; 
    }
    
    public void deleteOrganization(Organization org){
        organizationList.remove(org);
    }
    
}
