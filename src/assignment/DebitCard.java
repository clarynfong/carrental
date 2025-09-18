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
public class DebitCard extends Payment{
    Scanner sc = new Scanner(System.in);
    
    public DebitCard(double amount) {
        super(amount);
    }
    

    @Override
    public void pay() {
        
        System.out.println("Enter card number: ");
        String cardNumber;
        do {
            cardNumber = sc.nextLine().trim();
            if (!cardNumber.matches("\\d{16}"))
                System.out.print("Invalid input! Please enter exactly 16 digits: ");
        } while(!cardNumber.matches("\\d{16}"));

        System.out.println("Credit Card accepted: **** **** **** " + cardNumber.substring(12));
        
        System.out.println("Processing debit card payment...");
       int total = 50;   
        int steps = 100;  

        int prevLen = 0;
        for (int progress = 0; progress <= steps; progress++) {
            int filled = (progress * total) / steps;

            StringBuilder bar = new StringBuilder(total);
            for (int i = 0; i < filled; i++) bar.append("=");
            for (int i = filled; i < total; i++) bar.append(" ");

            String output = "[" + bar + "] " + progress + "%";

            StringBuilder clear = new StringBuilder();
            for (int i = 0; i < prevLen; i++) clear.append(' ');

            System.out.print("\r" + clear.toString() + "\r" + output);
            System.out.flush();

            prevLen = output.length();

            try {
                Thread.sleep(50); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
        
        this.status = Status.COMPLETED;
    }

    @Override
    public String toString() {
        return super.toString() +  (super.getStatus() == Payment.Status.COMPLETED ? "Debit Card": "N/A");
    }
}
