/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package car.rental;

/**
 *
 * @author William
 */
public class CarType {
    private final static int MAX_CAPACITY = 9;
    private String brand;
    private String model;
    private int capacity;
    private int seatNo;

    public CarType() {
    }

    public CarType(String brand, String model, int capacity, int seatNo) {
        this.brand = brand;
        this.model = model;
        this.capacity = capacity;
        this.seatNo = seatNo;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(int seatNo) {
        if (seatNo >= MAX_CAPACITY && seatNo < 0)
            throw new IllegalArgumentException("No of seat cannot exceed 9");
        this.seatNo = seatNo;
    }

    @Override
    public String toString() {
        return 
                "Car Type" + 
                "brand: " + brand + 
                "Model: " + model + 
                "Capacity: " + capacity + 
                "Seat No: " + seatNo;
    }
    
    
}
