/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package car.rental;

/**
 *
 * @author William
 */
public class Sedan extends Car{
    private boolean luxuryPackage;
    private boolean sunroof;
    private double trunkCapacity;

    public boolean hasLuxuryPackage() {
        return luxuryPackage;
    }

    public void enableLuxuryPackage() {
        this.luxuryPackage = true;
    }
    
    public void disableLuxuryPackage() {
        this.luxuryPackage = false;
    }

    public boolean isSunroofOpen() {
        return sunroof;
    }

    public void openSunroof() {
        this.sunroof = true;
    }
    
    public void closeSunroof() {
        this.sunroof = false;
    }

    public double getTrunkCapacity() {
        return trunkCapacity;
    }

    public void setTrunkCapacity(double trunkCapacity) {
        this.trunkCapacity = trunkCapacity;
    }

    @Override
    public double calculateRentalFee(int days) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String displayCarInfo() {
        return 
                super.displayCarInfo() + 
                "\nSedan: " + 
                "\nLuxuryPackage: " + luxuryPackage + 
                "\nSunroof: " + sunroof + 
                "\nTrunkCapacity: " + trunkCapacity;
                 // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

}
