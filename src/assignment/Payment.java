/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

/**
 *
 * @author yewzhang
 */
public abstract class Payment {
    public enum Status{PENDING, COMPLETED, CANCELED}
    
    protected double amount;
    protected Status status;

    public Payment(double amount) {
        this.amount = amount;
        this.status = Status.PENDING;
    }
    
    public abstract void pay();
    
    public void cancel(){
        this.status = Status.CANCELED;
    }

    public double getAmount() {
        return amount;
    }
    public Status getStatus() { 
        return status; 
    }

    @Override
    public String toString() {
        return "Amount: " + amount + ", Status: " + status;
    }
}
