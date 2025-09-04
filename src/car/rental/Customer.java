/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package car.rental;

/**
 *
 * @author William
 */
public class Customer{
    private String name;
    private String contactNo;;
    private String ic;
    private char gender;
    private String address;
    private int age;

    public Customer() {
    }

    public Customer(String name, String contactNo, String ic, char gender, String address, int age) {
        this.name = name;
        this.contactNo = contactNo;
        this.ic = ic;
        this.gender = gender;
        this.address = address;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getIc() {
        return ic;
    }

    public void setIc(String ic) {
        this.ic = ic;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return
                "\nCustomer" + 
                "\nName: " + name + 
                "\nContactNo: " + contactNo + 
                "\nIC: " + ic + 
                "\nGender:" + gender + 
                "\nAddress: " + address + 
                "\nAge: " + age;
    }
}
