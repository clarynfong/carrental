/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

/**
 *
 * @author yewzhang
 */
public class Payment {
    public enum PaymentMethod{CASH, EWALLET, CREDIT_CARD, DEBIT_CARD}
    public enum Status{PENDING, COMPLETED, CANCELED}
    
    private double amount;
    private Status status;
    private PaymentMethod method;

    public Payment(double amount) {
        this.amount = amount;
        this.status = Status.PENDING;
    }
    
    public void pay() { 
        this.status = Status.COMPLETED;
    }
    
    public void cancel(){
        this.status = Status.CANCELED;
    }

    public double getAmount() {
        return amount;
    }
    public Status getStatus() { 
        return status; 
    }

    public PaymentMethod getMethod() {
        return method;
    }

    public void setMethod(PaymentMethod method) {
        this.method = method;
    }

    @Override
    public String toString() {
        return "Amount: " + amount + ", Status: " + status;
    }
}
