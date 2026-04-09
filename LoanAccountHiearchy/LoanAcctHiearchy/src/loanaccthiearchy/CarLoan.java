/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loanaccthiearchy;

/**
 *
 * @author Kevin Cai
 */
public class CarLoan extends LoanAccount {
    // Variables for CarLoan
    private String vehicleVin;
    
    // Methods for CarLoan
    public CarLoan(double principal, double annualInterestRate, int months, String vehicleVin) { //Constructor
        super(principal, annualInterestRate, months);
        this.vehicleVin = vehicleVin;
    }
    
    /**
     * 
     * @return String for the vehicle VIN number
     */
    @Override
    public String toString() {
        return "Car Loan with: \n"
                + super.toString() 
                + "\nVehicle VIN: " + vehicleVin + "\n";
    }
}
