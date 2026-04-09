/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loanaccthiearchy;

/**
 *
 * @author Kevin Cai
 */
public class LoanAccount {
    // Variables for LoanAccount
    private double principal;
    private double annualInterestRate;
    private int months;
    
    //Methods for LoanAccount
    public LoanAccount(double principal, double annualInterestRate, int months) { //Constructor
        this.principal = principal;
        this.annualInterestRate = annualInterestRate;
        this.months = months;
    }
    
    /**
     * Calculates the monthly payments from the three properties
     * @return monthlyPayment
     */
    public double calculateMonthlyPayment() {
        double monthlyInterest = annualInterestRate / 12 / 100;
        double monthlyPayment = principal * (monthlyInterest / (1 - Math.pow(1 + monthlyInterest, -months)));
        return monthlyPayment;
    }
    
    /**
     * Getters methods
     * @return principal, annualInterestRate, months individually
     */
    public double getPrincipal(){
        return principal;
    }
    
    public double getAnnualInterestRate(){
        return annualInterestRate;
    }
    
    public int getMonths(){
        return months;
    }
    
    /**
     * method toString
     * @return String format of the principle, annualInterestRate, and months
     */
    @Override
    public String toString() {
        return "Principal: " + "$" + String.format("%.2f",principal) 
                + "\nAnnual Interest Rate: " + String.format("%.2f",annualInterestRate) + "%" 
                + "\nTerm of Loan in Months: " + months
                + "\nMonthly Payment: " + "$" + String.format("%.2f",calculateMonthlyPayment());
    }
}
