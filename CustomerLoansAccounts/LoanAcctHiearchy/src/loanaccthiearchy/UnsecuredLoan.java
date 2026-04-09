/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loanaccthiearchy;

/**
 *
 * @author Kevin Cai
 */
public class UnsecuredLoan extends LoanAccount{
    //Methods for UnsecuredLoan
    public UnsecuredLoan(double principal, double annualInterestRate, int months) { //constructor
        super(principal, annualInterestRate, months);
    }
    
    /**
     * method toString()
     * @returns A string format of the Unsecured loan
     */
    @Override
    public String toString() {
        return "\nUnsecured Loan with: \n" + super.toString();
    }
}
