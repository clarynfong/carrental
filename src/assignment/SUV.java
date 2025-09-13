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
    
    public SUV(String brand, String model, double rate, double power) {
        super(brand, model, rate);
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
        return super.toString() + " | Type: SUV | Horsepower: " + power;
    }
    
}
