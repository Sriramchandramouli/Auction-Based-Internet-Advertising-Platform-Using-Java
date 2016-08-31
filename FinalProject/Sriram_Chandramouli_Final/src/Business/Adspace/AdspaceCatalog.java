/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Adspace;

import java.util.ArrayList;

/**
 *
 * @author Sriram
 */
public class AdspaceCatalog {
    
    private ArrayList<Adspace> adspaceList;

    public AdspaceCatalog() {
        adspaceList = new ArrayList<>();
    }

    public ArrayList<Adspace> getAdspaceList() {
        return adspaceList;
    }

    public void setAdspaceList(ArrayList<Adspace> adspaceList) {
        this.adspaceList = adspaceList;
    }
    
    
    public Adspace addAdspace() {
        Adspace adspace = new Adspace();
        adspaceList.add(adspace);
        return adspace;
    }
    public void deleteAdspace(Adspace adspace) {
        adspaceList.remove(adspace);
    }
}
