/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

/**
 *
 * @author yewzhang
 */
public class SUV extends Car{
    private double power = 0;
    
    public SUV(String brand, String model, String plate, double rate, double power) {
        super(brand, model, plate, rate);
        this.power = power;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%-7s %-25s", "SUV", "Horsepower: " + power + "hp");
    }
    
}
