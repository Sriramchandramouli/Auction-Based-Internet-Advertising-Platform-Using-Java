/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Sriram
 */
public class InternetEnterprise extends Enterprise{

    public InternetEnterprise(String name) {
        super(name, EnterpriseType.Internet);
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
     return null;   
    }
    
}
