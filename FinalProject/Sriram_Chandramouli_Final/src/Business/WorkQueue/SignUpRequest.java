/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Consumer.Consumer;
import Business.Network.Network;
import Business.Role.Role;
import java.util.Date;

/**
 *
 * @author Sriram
 */
public class SignUpRequest extends WorkRequest{
    
    private String signUpResult;
    private String userName;
    private String passWord;
    private Role role;
    private String firstName;
    private String lastName;
    private String category1;
    private String category2;
    private String category3;
    private int age;
    private String cardNumber;
    private Date expDate;
    private int cvvNumber;
    private float balance;
    private Consumer consumer;
    private String line1Address;
    private String line2Address;
    private String city;
    private String state;
    private int zipCode;
    private Network network;
    

    public String getSignUpResult() {
        return signUpResult;
    }

    public void setSignUpResult(String signUpResult) {
        this.signUpResult = signUpResult;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Network getNetwork() {
        return network;
    }

    public void setNetwork(Network network) {
        this.network = network;
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

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    
    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public int getCvvNumber() {
        return cvvNumber;
    }

    public void setCvvNumber(int cvvNumber) {
        this.cvvNumber = cvvNumber;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public Consumer getConsumer() {
        return consumer;
    }

    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
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
    
    

    
    

    @Override
    public String toString() {
        return userName;
    }
   
    
}
