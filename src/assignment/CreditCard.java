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
public class CreditCard extends Payment{
    Scanner sc = new Scanner(System.in);
    
    public CreditCard(double amount) {
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
        
        System.out.println("Processing credit card payment...");
        int total = 50;   // bar length
        int steps = 100;  // percent steps from 0..100

        int prevLen = 0;
        for (int progress = 0; progress <= steps; progress++) {
            int filled = (progress * total) / steps;

            StringBuilder bar = new StringBuilder(total);
            for (int i = 0; i < filled; i++) bar.append("=");
            for (int i = filled; i < total; i++) bar.append(" ");

            String output = "[" + bar + "] " + progress + "%";

            // Clear previous content, so only 1 progress bar will be shown
            StringBuilder clear = new StringBuilder();
            for (int i = 0; i < prevLen; i++) clear.append(' ');

            System.out.print("\r" + clear.toString() + "\r" + output);
            System.out.flush();

            prevLen = output.length();

            try {
                Thread.sleep(50); // simulated work
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
        
        this.status = Status.COMPLETED;
    }

    @Override
    public String toString() {
        return super.toString() + " | Method: " +  (super.getStatus() == Payment.Status.COMPLETED ? "Credit Card": "N/A");
    }
    
}
