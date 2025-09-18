/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author yewzhang
 */
public class CustReg implements Sortable{
    Scanner sc = new Scanner(System.in);
    private static ArrayList<Customer> customers = new ArrayList<>();
    
    // Add new Customer
    public void registerCustomer(){
        System.out.print("Enter customer name: ");
        String name;
        do {
            name = sc.nextLine().trim().toUpperCase();

            if (name.isEmpty()) {
                System.out.println("Name cannot be empty! Please re-enter.");
            } else if (!name.matches("[A-Z ]+")) { 
                System.out.println("Error! Only letters and spaces are allowed. Please enter again: ");
                name = ""; // reset to empty to loop again
            }
        } while (name.isEmpty());

        
        System.out.print("Enter phone number (e.g. 012-3456789): ");
        String phone;
        do {
            phone = sc.nextLine();
            if (!phone.matches("\\d{3}-\\d{7}")) {
                System.out.print("Invalid phone format! Please re-enter: ");
            }
        } while (!phone.matches("\\d{3}-\\d{7}"));
        
        System.out.print("Enter customer email: ");
        String email;
        do {
            email = sc.nextLine().toLowerCase();

            if (!email.matches("^[\\w._%+-]+@[\\w.-]+\\.[A-Za-z]{2,6}$")) {
                System.out.print("Invalid email format! Please re-enter: ");
            } else {
                break;
            }
        } while (true);
        
        Customer c = new Customer(name, phone, email);
        customers.add(c);
        
        System.out.printf("%-12s %-20s %-12s %-30s%n", "Customer ID", "Customer Name", "Phone No.", "E-mail");
        System.out.println(c.toString());
    }
    
    
    // Show all customers
    public void displayCustomers(){
        System.out.printf("%-26s%-21s%n","","=== Customer Info ===");
        System.out.printf("%-12s %-20s %-12s %-30s%n", "Customer ID", "Customer Name", "Phone No.", "E-mail");
        for(Customer c: customers){
                System.out.print(c.toString());
        }
    }
    
    // sort customer list by id or name before display it
    @Override
    public void sort(){
        if (customers.isEmpty()) {
            System.out.println("No customers yet.");
            return;
        }
        System.out.println("\n--- Display Customers ---");
        System.out.println("1. Sort by ID");
        System.out.println("2. Sort by Name");
        System.out.print("Enter choice (1-2): ");

        int choice;
        try {
            choice = sc.nextInt();
            sc.nextLine();
        } catch (NumberFormatException e) {
            System.out.println("Invalid input, returning to menu.");
            sc.nextLine();
            return;
        }

        switch (choice) {
            case 1 -> {
                Collections.sort(customers, Comparator.comparingInt(
                        c -> Integer.valueOf(c.getCustId().substring(1))
                ));
                System.out.println("Customers sorted by ID.");
            }
            case 2 -> {
                Collections.sort(customers, Comparator.comparing(Customer::getName));
                
                System.out.println("Customers sorted by Name.");
            }
            default -> {
                System.out.println("Invalid choice.");
                return;
            }
        }
        displayCustomers();
    }
    
    public static ArrayList<Customer> getCustomers() {
        return customers;
    }    
}
