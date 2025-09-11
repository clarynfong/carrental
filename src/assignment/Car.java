/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

/**
 *
 * @author yewzhang
 */
public class Car {
    private String carId;
    private String brand, model, plate;
    private double rate;
    private boolean available;
    private static int nextCarId = 1;

    public Car(String brand, String model, String plate, double rate) {
        this.brand = brand;
        this.model = model;
        this.plate = plate;
        this.rate = rate;
        this.carId = String.format("V%03d", nextCarId++);
        this.available = true;
    }

    public String getCarId() {
        return carId;
    }
    
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getPlate() {
        return plate;
    }

    public double getRate() {
        return rate;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "\nCar ID: " + carId + " | Brand: " + brand + " | Model: " + model + " | Plate Number: " + plate + " | Rate: " + rate + "per day"+ " | Available: " + available;
    }
    
    
}
