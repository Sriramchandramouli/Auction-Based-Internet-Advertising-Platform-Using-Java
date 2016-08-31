/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Consumer;

import Business.Network.Network;
import Business.Person.Person;

/**
 *
 * @author Sriram
 */
public class Consumer extends Person{
    
    private static int count = 0;
    private int consumerId;
    private String category1;
    private String category2;
    private String category3;
    private String line1Address;
    private String line2Address;
    private String city;
    private String state;
    private int zipCode;
    private Network network;
    
    public Consumer() {
        count++;
        consumerId=count;
    }

    public int getConsumerId() {
        return consumerId;
    }

    public String getCategory1() {
        return category1;
    }

    public void setCategory1(String category1) {
        this.category1 = category1;
    }

    public String getCategory2() {
        return category2;
    }

    public void setCategory2(String category2) {
        this.category2 = category2;
    }

    public String getCategory3() {
        return category3;
    }

    public void setCategory3(String category3) {
        this.category3 = category3;
    }

    public String getLine1Address() {
        return line1Address;
    }

    public void setLine1Address(String line1Address) {
        this.line1Address = line1Address;
    }

    public String getLine2Address() {
        return line2Address;
    }

    public void setLine2Address(String line2Address) {
        this.line2Address = line2Address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public Network getNetwork() {
        return network;
    }

    public void setNetwork(Network network) {
        this.network = network;
    }
    
    

    
    @Override
    public String toString() {
        return super.getFirstName(); 
    }
  
}
