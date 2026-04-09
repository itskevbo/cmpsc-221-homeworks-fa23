/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loanaccthiearchy;

/**
 *
 * @author Kevin Cai
 */
public class PrimaryMortgage extends LoanAccount {
    //Variables for PrimaryMortgage
    private double PMIMonthlyAmount;
    private Address address;

    //Methods for PrimaryMortgage
    public PrimaryMortgage(double principal, double annualInterestRate, int months, double PMIMonthlyAmount, Address address) { //Constructor
        super(principal, annualInterestRate, months);
        this.PMIMonthlyAmount = PMIMonthlyAmount;
        this.address = address;
    }
        
    /**
     * method toString
     * @returns a string format of the PMI monthly amount and the address
     */
    @Override
    public String toString() {
        return "\nPrimary Mortgage Loan with: \n"
                + super.toString()
                + "\nPMI Monthly Amount: " + PMIMonthlyAmount 
                + "\nProperty Address: " + address  + "\n";
    }
}
