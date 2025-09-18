/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author yewzhang
 */
public class Rental {
    private static ArrayList<Rental> rentals = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    
    private String rentalId;
    private static int nextRentalId = 1;
    private Customer customer;
    private Car car;
    private int day;
    private double totalAmount = 0;
    private Payment payment;
    private LocalDate startDate;
    private LocalDate endDate;

    public Rental() {
    }
    
    public Rental(Customer customer, Car car, int day, Payment payment) {
        this.rentalId = String.format("R%03d", nextRentalId++);
        this.customer = customer;
        this.car = car;
        this.day = day;
        this.payment = payment;
        this.startDate = LocalDate.now();
        this.endDate = startDate.plusDays(day);
    }

    @Override
    public String toString() {
        return customer.toString() + car.toString() + "Days: " + day + payment.toString();
    }
    
    public void rentCar(){
        CarReg carReg = new CarReg();
        boolean validCustId = false;
        Customer customer = null;
        do{
            System.out.print("Enter Customer ID: ");
            String customerId = sc.nextLine();

            for(Customer c: CustReg.getCustomers()){
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
        
        carReg.displayAvailableCars();
        
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
        boolean validday = false;
        do{
            try{
                days = sc.nextInt();
                validday = true;
            }catch(Exception e){
                System.out.println("Invalid input, please re-enter: ");
                sc.nextLine();
            }
        
        }while(!validday);
        
        double total = car.getRate() * days;
        Payment payment = new Cash(total); //
        
        Rental rental = new Rental(customer, car, days, payment);
        rentals.add(rental);
        car.setAvailable(false);
        
        System.out.println("Rental created successfully!");
    }
    
    
    public void rentalHistory() {
    if (rentals.isEmpty()) {
        System.out.println("No rental history yet.");
        return;
    }

    System.out.println("\n--- Rental History ---");
    System.out.printf("%-6s %-12s %-12s %-6s %-12s %-12s %-15s %-10s %-15s %n", "ID", "Customer", "Vehicle", "Days", "Start", "End", "Payment Amount", "Status", "Method");

    System.out.println("----------------------------------------------------------------------------------------------------");

    for (Rental r : rentals) {
        Payment p = r.getPayment();
        System.out.printf("%-6s %-12s %-12s %-6d %-12s %-12s %-40s%n",
                r.getRentalId(),
                r.getCustomer().getName(),
                r.getCar().getModel(),
                r.getDay(),
                r.getStartDate(),
                r.getEndDate(),
                p.toString()); 
        }
    }
    
// Getters and setter
    public String getRentalId() {
        return rentalId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Car getCar() {
        return car;
    }

    public int getDay() {
        return day;
    }

    public Payment getPayment() {
        return payment;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
    
    public static ArrayList<Rental> getRentals() {
        return rentals;
    }
    
    public void setPayment(Payment payment) {
        this.payment = payment;
    }

}
