/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Publisher;

import Business.Adspace.AdspaceCatalog;
import Business.Person.Person;

/**
 *
 * @author Sriram
 */
public class Publisher extends Person{
    
    private AdspaceCatalog adspaceCatalog;

    public Publisher() {
        
        adspaceCatalog = new AdspaceCatalog();
        
    }

    public AdspaceCatalog getAdspaceCatalog() {
        return adspaceCatalog;
    }

    public void setAdspaceCatalog(AdspaceCatalog adspaceCatalog) {
        this.adspaceCatalog = adspaceCatalog;
    }

    @Override
    public String toString() {
        return super.getFirstName();
    }
    
    
    
}
