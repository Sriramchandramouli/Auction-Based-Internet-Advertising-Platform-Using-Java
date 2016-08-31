/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Consumer.Consumer;
import Business.Person.Person;
import Business.Role.Role;
import Business.WorkQueue.WorkQueue;

/**
 *
 * @author Sriram
 */
public class UserAccount {
    
    private String userName;
    private String password;
    private Person person;
    private Role role;
    private WorkQueue workQueue;
    private Consumer consumer;
    private FinanceDetail financeDetail;

    public UserAccount() {
        
        workQueue = new WorkQueue();
        financeDetail = new FinanceDetail();
        financeDetail.setBalance(0);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    public Consumer getConsumer() {
        return consumer;
    }

    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }

    public FinanceDetail getFinanceDetail() {
        return financeDetail;
    }

    
    

    @Override
    public String toString() {
        return userName;
    }
    
    
}
