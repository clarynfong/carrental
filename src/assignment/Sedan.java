/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

/**
 *
 * @author yewzhang
 */
public class Sedan extends Car{
    private double fuelEfficiency;

    public Sedan(String brand, String model, String plate, double rate, double fuelEfficiency) {
        super(brand, model, plate, rate);
        this.fuelEfficiency = fuelEfficiency;
    }

    public double getFuelEfficiency() {
        return fuelEfficiency;
    }

    public void setFuelEfficiency(double fuelEfficiency) {
        this.fuelEfficiency = fuelEfficiency;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%-7s %-25s", "Sedan", "Fuel efficiency: " + fuelEfficiency + "L/100km");
    }
    
}
