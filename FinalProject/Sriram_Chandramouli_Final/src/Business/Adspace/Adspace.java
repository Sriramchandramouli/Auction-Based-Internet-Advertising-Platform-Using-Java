/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Adspace;

/**
 *
 * @author Sriram
 */
public class Adspace {
    
    private String spaceName;
    private int size;
    private float basePrice;
    private String location;
    private int spaceNumber;
    private static int countNo = 0;

    public Adspace() {
        
        countNo++;
        spaceNumber = countNo;
    }

    
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getSpaceName() {
        return spaceName;
    }

    public void setSpaceName(String spaceName) {
        this.spaceName = spaceName;
    }

    public float getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(float basePrice) {
        this.basePrice = basePrice;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getSpaceNumber() {
        return spaceNumber;
    }
    
    

    @Override
    public String toString() {
        return spaceName;
    }
    
    
    
}
