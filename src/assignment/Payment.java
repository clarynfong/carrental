/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

import java.util.Scanner;

/**
 *
 * @author yewzhang
 */
public abstract class Payment {
    public enum Status{PENDING, COMPLETED}
    Scanner sc = new Scanner(System.in);
    protected double amount;
    protected Status status;

    public Payment(double amount) {
        this.amount = amount;
        this.status = Status.PENDING;
    }
    
    public abstract void pay();
    
    @Override
    public String toString() {
        return String.format("%-15.2f %-10s ", amount, status);
    }
    
    
    public void processPayment(){
        boolean validRentId = false;
        Rental rental = null;
        do{
            System.out.print("Enter Rental ID: ");
            String rentalId = sc.nextLine();

            for(Rental r: Rental.getRentals()){
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

    public double getAmount() {
        return amount;
    }
    public Status getStatus() { 
        return status; 
    }
}
