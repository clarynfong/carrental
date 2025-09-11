/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package car_rental;

/**
 *
 * @author yewzhang
 */
public class Customer {
    private String name;
    private String custId;
    private static int nextCustId = 1;

    public Customer(String name) {
        this.custId = String.format("C%03d", nextCustId++);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getCustId() {
        return custId;
    }

    @Override
    public String toString() {
        return "\nCustomer ID: " + custId + "\nName: " + name;
    }
    
}
