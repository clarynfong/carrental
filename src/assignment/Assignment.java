/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package assignment;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author yewzhang
 */
public class Assignment {

    private static ArrayList<Customer> customers = new ArrayList<>();
    
    private static ArrayList<Rental> rentals = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        CarReg carReg = new CarReg();
        
        while(true){
            int choice = mainMenu();
            sc.nextLine();

            switch (choice){
                case 1:
                    registerCustomer(); 
                    break;
                case 2: 
                    carReg.addCar();
                    break;
                case 3: 
                    displayCar(); 
                    break;
                case 4: 
                    rentCar(); 
                    break;
                case 5: 
                    processPayment(); 
                    break;
                case 6:
                    cancelRental();
                    break;
                case 7: 
                    rentalHistory(); 
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice, pls choose agn...");

            }
        }
        
        
    }
    
    public static int mainMenu(){
        boolean loop = true;
        int choice = 0;
        System.out.println("\n--- Car Rental System ---");
        System.out.println("1. Register Customer");
        System.out.println("2. Add Car");
        System.out.println("3. Display Available Cars");
        System.out.println("4. Rent a Car");
        System.out.println("5. Process Payment");
        System.out.println("6. Cancel Rental");        
        System.out.println("7. Rental History");
        System.out.println("0. Exit");

        System.out.print("Enter your choice: ");
        do{
            try{
                choice = sc.nextInt();
                loop = false;
            }catch(Exception e){
                System.out.println("Invalid input, please re-enter: ");
                sc.nextLine();
            }
        }while(loop);
        
        return choice;
    }
    
    public static void registerCustomer(){
        System.out.print("Enter customer name: ");
        String name = sc.nextLine();
        Customer c = new Customer(name);
        customers.add(c);
        System.out.println("New customer registered");
        System.out.print(c.toString());
    }
    
    
    
    public static void displayCar(){
        System.out.print("\n=== Avaiable Cars ===");
        for(Car c: CarReg.getCars()){
            if(c.isAvailable()){
                System.out.print(c.toString());
            }
        }
    }
    
    public static void rentCar(){
        boolean validCustId = false;
        Customer customer = null;
        do{
            System.out.print("Enter Customer ID: ");
            String customerId = sc.nextLine();

            for(Customer c: customers){
                if(c.getCustId().equals(customerId)){
                    customer = c;
                    validCustId = true;
                    break;
                }
            }
            if (customer == null){
                System.out.println("Customer not found!");
            }
        }while(!validCustId);
        
        displayCar();
        
        boolean validCarId = false;
        Car car = null;
        do{
            System.out.print("\nEnter Car ID: ");
            String carId = sc.nextLine();

            for(Car c: CarReg.getCars()){
                if(c.getCarId().equals(carId) && c.isAvailable()){
                    car = c;
                    validCarId = true;
                    break;
                }
            }
            if (car == null){
                System.out.println("Car not found or unavailable!");
            }
        }while(!validCarId);
        
        System.out.print("Enter number of days: ");
        int days = 1;
        try{
            days = sc.nextInt();
        }catch(Exception e){
            System.out.println("Invalid input, please re-enter: ");
            sc.nextLine();
        }
        
        double total = car.getRate() * days;
        Payment payment = new Cash(total); 
        
        Rental rental = new Rental(customer, car, days, payment);
        rentals.add(rental);
        car.setAvailable(false);
        
        System.out.println("Rental created successfully!");
    }
    
    public static void processPayment(){
        boolean validRentId = false;
        Rental rental = null;
        do{
            System.out.print("Enter Rental ID: ");
            String rentalId = sc.nextLine();

            for(Rental r: rentals){
                if(r.getRentalId().equals(rentalId)){
                    rental = r;
                    validRentId = true;
                    break;
                }
            }
            if (rental == null){
                System.out.println("Record not found!");
            }
        }while(!validRentId);
        
        Payment p = rental.getPayment();
        int choice = 0;
        
        if(p.getStatus() == Payment.Status.PENDING){
            System.out.println("Select Payment Method: ");
            System.out.println("1. Cash");
            System.out.println("2. E-Wallet");
            System.out.println("3. Credit Card");
            System.out.println("4. Debit Card");
            System.out.print("Enter your choice: ");
        }
        
        try{
            choice = sc.nextInt();
        }catch(Exception e){
            System.out.println("Invalid input, please re-enter: ");
            sc.nextLine();
        }
        
        Payment paymentM = switch(choice){
            case 1 -> new Cash(p.getAmount());
            case 2 -> new Ewallet(p.getAmount());
            case 3 -> new CreditCard(p.getAmount());
            case 4 -> new DebitCard(p.getAmount());
            default -> new Cash(p.getAmount());
        };
        
        rental.setPayment(paymentM); 
        paymentM.pay();
        rental.getCar().setAvailable(true);
        System.out.println("Payment completed");
        
    }
    
    public static void cancelRental() {
        System.out.print("Enter Rental ID to cancel: ");
        String rentalId = sc.nextLine();

        for (Rental r : rentals) {
            if (r.getRentalId().equals(rentalId)) {
                Payment p = r.getPayment();
                Car v = r.getCar();

                if (p.getStatus() == Payment.Status.PENDING) {
                    if (r.getStartDate().isAfter(LocalDate.now())) {
                        p.cancel();
                        v.setAvailable(true);
                        System.out.println("Rental canceled. Vehicle is now available.");
                    } else {
                        System.out.println("Cannot cancel. Rental already started or overdue.");
                    }
                } else {
                    System.out.println("Cannot cancel. Rental payment status is: " + p.getStatus());
                }
                return;
            }
        }
        System.out.println("Rental ID not found!");
    }
    
    public static void rentalHistory() {
    if (rentals.isEmpty()) {
        System.out.println("No rental history yet.");
        return;
    }

    
    System.out.println("\n--- Rental History ---");
    System.out.printf("%-6s %-12s %-12s %-6s %-12s %-12s %-15s %-10 %-15 %n", "ID", "Customer", "Vehicle", "Days", "Start", "End", "Payment Amount", "Status", "Method");

    System.out.println("----------------------------------------------------------------------------------------------------");

    for (Rental r : rentals) {
        Payment p = r.getPayment();
        System.out.printf("%-6s %-12s %-12s %-6d %-12s %-12s %-30s%n",
                r.getRentalId(),
                r.getCustomer().getName(),
                r.getCar().getModel(),
                r.getDay(),
                r.getStartDate(),
                r.getEndDate(),
                p.toString()); 
        }
    }
    
    
}
