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
public class Cash extends Payment{
    Scanner sc = new Scanner(System.in);
    
    
    public Cash(double amount) {
        super(amount);
    }

    @Override
    public void pay() {
        
        System.out.println("Amount to be paid: " + amount);
        System.out.print("Please enter payment amount: ");
        double cash =  sc.nextDouble();
        boolean paid = false;
        do{
            if (cash == amount){
                System.out.println("Payment recieved.");
                paid = true;
            }
            else if(cash > amount){
                double change = cash - amount;
                System.out.println("Payment received. Changes amount: " + change);
                paid = true;
            }else{
                System.out.print("Insufficient amount paid.");
                sc.nextDouble();
            }
        }while(!paid);
       
        this.status = Status.COMPLETED;
        
    }

    @Override
    public String toString() {
        return super.toString() + (super.getStatus() == Payment.Status.COMPLETED ? String.format("%-15s", "Cash") : String.format("%-15s", "N/A"));
    }
    
    
    
}
