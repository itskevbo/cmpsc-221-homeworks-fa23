/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loanaccthiearchy;

/**
 *
 * @author Kevin Cai
 */
public class Address {
    //Variables for Address
    private String street;
    private String city;
    private String state;
    private String zipcode;
    
    //Methods for Address
    public Address(String street, String city, String state, String zipcode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }
    
    /**
     * Getters methods
     * @return street, city, state, zipcode
     */
    public String getStreet() {
        return street;
    }
    
    public String getCity() {
        return city;
    }
    
    public String getState() {
        return state;
    }
    
    public String getZip() {
        return zipcode;
    }
    
    /**
     * method toString
     * @return String format for the address
     */    
    @Override
    public String toString() {
        return "\n\t" + street + "\n\t" + city + ", " + state + ' ' + zipcode;
    }
}
