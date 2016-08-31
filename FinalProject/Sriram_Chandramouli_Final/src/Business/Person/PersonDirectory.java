/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Person;

import java.util.ArrayList;

/**
 *
 * @author Sriram
 */
public class PersonDirectory {
    
    private ArrayList<Person> personList;

    public PersonDirectory() {
        
        personList = new ArrayList<>();
    }

    public ArrayList<Person> getPersonList() {
        return personList;
    }
    
    public Person createPersonSupplier(String firstName,int age) {
        Person person = new Person();
        person.setFirstName(firstName);
        person.setAge(age);
        personList.add(person);
        return person;
    }
    public Person createPerson(String firstName,String lastName,int age,String countryName) {
        Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setAge(age);
        person.setCountryName(countryName);
        personList.add(person);
        return person;
    }
    
    public Person createEnterprisePerson(String name){
        Person person = new Person();
        person.setFirstName(name);
        personList.add(person);
        return person;
    }
    
    public void deletePerson(Person person) {
        personList.remove(person);
    }
    
}
