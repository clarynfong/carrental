/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

import java.time.LocalDate;

/**
 *
 * @author yewzhang
 */
public class Rental {
    private String rentalId;
    private static int nextRentalId = 1;
    private Customer customer;
    private Car car;
    private int day;
    private double totalAmount = 0;
    private Payment payment;
    private LocalDate startDate;
    private LocalDate endDate;

    public Rental(Customer customer, Car car, int day, Payment payment) {
        this.rentalId = String.format("R%03d", nextRentalId++);
        this.customer = customer;
        this.car = car;
        this.day = day;
        this.payment = payment;
        this.startDate = LocalDate.now();
        this.endDate = startDate.plusDays(day);
    }

    @Override
    public String toString() {
        return customer.toString() + car.toString() + "Days: " + day + payment.toString();
    }

    public String getRentalId() {
        return rentalId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Car getCar() {
        return car;
    }

    public int getDay() {
        return day;
    }

    public Payment getPayment() {
        return payment;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
}
