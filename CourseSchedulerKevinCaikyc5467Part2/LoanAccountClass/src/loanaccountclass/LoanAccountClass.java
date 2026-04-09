/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package loanaccountclass;

/**
 * Due 9/7/23
 * @author Kevin Cai
 */
public class LoanAccountClass {
    
    private final double principal;
    private static double annualInterestRate;
    public LoanAccountClass(double principal){
        this.principal = principal;
    }
    
    public double calculateMonthlyPayment(int numberOfPayments){
        double monthlyInterest = annualInterestRate / 12;
        numberOfPayments = numberOfPayments * 12;
        double monthlyPayment = principal * (monthlyInterest / (1 - Math.pow(1 + monthlyInterest, -numberOfPayments)));
        return monthlyPayment;
    }
    
    private static void setAnnualInterestRate(double annualInterestRate){
        LoanAccountClass.annualInterestRate = annualInterestRate / 100;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // Instantiate LoanAccountClass amounts
        LoanAccountClass loan1 = new LoanAccountClass(5000);
        LoanAccountClass loan2 = new LoanAccountClass(31000);
        
        //Print 1% Interest rates
        System.out.println("Monthly payments for loan1 of $5000.00 and loan2 of $31000.00 for 3, 5, and 6 year loans at 1% interest.");
        System.out.printf("Loan\t3 years\t5 years\t6 years\n");
        LoanAccountClass.setAnnualInterestRate(1);
        System.out.printf("""
                          Loan1\t%.2f\t%.2f\t%.2f
                          """, loan1.calculateMonthlyPayment(3), loan1.calculateMonthlyPayment(5), loan1.calculateMonthlyPayment(6));
        System.out.printf("""
                          Loan2\t%.2f\t%.2f\t%.2f\n
                          """, loan2.calculateMonthlyPayment(3), loan2.calculateMonthlyPayment(5), loan2.calculateMonthlyPayment(6));
        
        //Print 5% Interest rates
        System.out.println("Monthly payments for loan1 of $5000.00 and loan2 of $31000.00 for 3, 5, and 6 year loans at 5% interest.");
        System.out.printf("Loan\t3 years\t5 years\t6 years\n");
        LoanAccountClass.setAnnualInterestRate(5);
        System.out.printf("""
                          Loan1\t%.2f\t%.2f\t%.2f
                          """, loan1.calculateMonthlyPayment(3), loan1.calculateMonthlyPayment(5), loan1.calculateMonthlyPayment(6));
        System.out.printf("""
                          Loan2\t%.2f\t%.2f\t%.2f\n
                          """, loan2.calculateMonthlyPayment(3), loan2.calculateMonthlyPayment(5), loan2.calculateMonthlyPayment(6));
        
    }
}
