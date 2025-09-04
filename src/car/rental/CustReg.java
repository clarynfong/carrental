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
public class CustReg {
    private int custRegNo;
    private Date custRegDate;
    private Customer customer;
    private static int nextCustRegNo;
    private static Customer[] registeredCust = new Customer[100];

    public CustReg() {
    }

    public CustReg(int custRegNo, Date custRegDate, Customer customer) {
        this.custRegNo = nextCustRegNo;
        this.custRegDate = custRegDate;
        this.customer = customer;
        nextCustRegNo++;
    }

    public int getCustRegNo() {
        return custRegNo;
    }

    public void setCustRegNo(int custRegNo) {
        this.custRegNo = custRegNo;
    }

    public Date getCustRegDate() {
        return custRegDate;
    }

    public void setCustRegDate(Date custRegDate) {
        this.custRegDate = custRegDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void addCustomer(Customer customer) {
        if (customer == null)
            throw new IllegalArgumentException("Customer cannot be null");
        for (int i = 0; i < registeredCust.length; i++){
            if (registeredCust[i] == null){
                registeredCust[i] = customer;
                return;
            }
        }
        throw new IllegalArgumentException("Customer registry is full");
    }

    @Override
    public String toString() {
        return 
                "CustReg" + 
                "CustRegNo: " + custRegNo + 
                "CustRegDate: " + custRegDate + 
                "Customer: " + customer;
    }
}
