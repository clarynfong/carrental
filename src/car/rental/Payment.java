/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package car.rental;

import java.util.Date;

/**
 *
 * @author William
 */
public class Payment {
    private enum PaymentMethod {CASH, CREDIT_CARD, DEBIT_CARD, E_WALLET};
    private double amount;
    private Date date;
    private PaymentMethod method;

    public Payment() {
    }

    public Payment(double amount, Date date, PaymentMethod method) {
        this.amount = amount;
        this.date = date;
        this.method = method;
    }

    public double getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    public PaymentMethod getMethod() {
        return method;
    }    
    
    public boolean processPayment(){
        if (amount <= 0){
            System.out.println("Payment failed: Invalid amount.");
            return false;
        }
        System.out.println("Payment of RM" + amount + "processed via " + method);
        return true;
    }

    @Override
    public String toString() {
        return 
                "Payment" + 
                "Amount: " + amount + 
                "Date: " + date + 
                "Method: " + method;
    }
    
    
}
