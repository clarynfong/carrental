/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package car.rental;

/**
 *
 * @author William
 */
public abstract class Car implements Rentable{
    protected String plateNo;
    protected String color;
    protected CarType carType;
    protected boolean available;
    protected double dailyRate;

    public Car() {
    }

    public Car(String plateNo, String color, CarType carType, boolean available, double dailyRate) {
        this.plateNo = plateNo;
        this.color = color;
        this.carType = carType;
        this.available = available;
        this.dailyRate = dailyRate;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
    }

    @Override
    public abstract double calculateRentalFee(int days);

    @Override
    public String toString() {
        return "Car" + 
                "plateNo: " + plateNo + 
                "Color: " + color + 
                "CarType: " + carType + 
                "Available: " + available + 
                "DailyRate: " + dailyRate;
    }
    
}
