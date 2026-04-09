/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loanaccthiearchy;
import java.util.ArrayList;

/**
 * Due 9/21/23
 * @author Kevin Cai
 */
public class Customer {
    //Properties
    private final String firstName;
    private final String lastName;
    private final String ssN;
    ArrayList<LoanAccount> loanAccounts = new ArrayList<>();

    //Methods
    public Customer(String firstName, String lastName, String ssN) { //Constructor
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssN = ssN;
    }
    
    /**
     * Getter methods
     * @return firstName, lastName, SSN
     */
    public String getFirst() {
        return firstName;
    }
    
    public String getLast() {
        return lastName;
    }
    
    public String getSSN() {
        return ssN;
    }
    
    /**
     * @method addLoanAccount adds a loan to the array list of loans for this customer
     * @param account
     */
    public void addLoanAccount(LoanAccount account) {
        loanAccounts.add(account);
    }
    
    /**
     * @method printMonthlyReport() prints all the information for all the accounts of this Customer. 
     * Utilizes the toString() method of the corresponding loan class.
     */
    public void printMonthlyReport() {
        System.out.println("\nAccount Report for Customer: " + firstName + " " + lastName + " with SSN " + ssN);
        System.out.println();
        
        for (LoanAccount account : loanAccounts) { //Iterates through all the accounts mentioned
            System.out.print(account + "\n");
        }
    }
}
