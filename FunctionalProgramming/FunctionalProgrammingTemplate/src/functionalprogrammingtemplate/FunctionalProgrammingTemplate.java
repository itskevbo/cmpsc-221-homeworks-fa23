/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package functionalprogrammingtemplate;

import java.util.List;
import java.util.Map;
import java.util.Comparator;

/**
 * due 10/26/23
 * @author Kevin Cai
 */
public class FunctionalProgrammingTemplate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // create the ArrayList of Invoices
        List<Invoice> invoices = List.of(
        new Invoice(83,"Electric sander", 7, 57.98),
        new Invoice(24,"Power saw", 18, 99.99),
        new Invoice(7,"Sledge hammer", 11, 21.50),
        new Invoice(77,"Hammer", 76, 11.99),
        new Invoice(39,"Lawn mower", 3, 79.50),
        new Invoice(68,"Screw driver", 106, 6.99),
        new Invoice(56,"Jig saw", 21, 11.00),
        new Invoice(3,"Wrench", 34, 7.50));
        
        //Display the table of invoices using Invoice toString().
        //Print table header.
        System.out.println("Part number\tPart description\tQuantity\tPrice per item\tValue");
        invoices.stream()
                .forEach(System.out::print);
        
        //a)Use streams to sort Invoice object by partDecsription, then display the results.
        //Table Header
        System.out.println("\nInvoices sorted by Part description\nPart number\tPart description\tQuantity\tPrice per item\tValue");
        
        //Use Comparator to print of parts sorted by their part descriptions
        invoices.stream()
                .sorted(Comparator.comparing(Invoice::getPartDescription))
                .forEach(System.out::print);
        
        //b)Use streams to sort Invoice object by price, then display the results.
        //Table Header
        System.out.println("\nInvoices sorted by Price\nPart number\tPart description\tQuantity\tPrice per item\tValue");
        
        //Use Comparator to print out parts sorted by their prices
        invoices.stream()
                .sorted(Comparator.comparing(Invoice::getPricePerItem))
                .forEach(System.out::print);
        
        //c)Use streams to map each Invoice to its partDescription and quantity, then display the results.
        //Table Header
        System.out.println("\nPart Description and Quantity for each Invoice\nPart description\tQuantity");
        
        //Use Map to print out only part descriptions and quantities of Invoice objects
        invoices.stream()
                .map(invoice -> String.format("%-16s\t%d", invoice.getPartDescription(), invoice.getQuantity()))
                .forEach(System.out::println);
                
    }
    
}
