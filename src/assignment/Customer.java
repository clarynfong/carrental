/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

/**
 *
 * @author yewzhang
 */
public class Customer {
    private String name;
    private String custId;
    private static int nextCustId = 1;
    private String phone;
    private String email;

    public Customer(String name, String phone, String email) {
        this.custId = String.format("C%03d", nextCustId++);
        this.name = name;
        this.phone = phone;
        this.email = email;
    }
    
    public String getName() {
        return name;
    }

    public String getCustId() {
        return custId;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    

    @Override
    public String toString() {
        return String.format("%-12s %-20s %-12s %-30s %n", custId, name, phone, email);
    }
    
}
