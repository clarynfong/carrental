/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package car.rental;

/**
 *
 * @author William
 */
public class SUV extends Car{    
    private boolean fourWheelDrive;
    private double groundClearance;
    private boolean roofRack;

    public boolean isFourWheelDrive() {
        return fourWheelDrive;
    }

    public void enableFourWheelDrive() {
        this.fourWheelDrive = true;
    }
    
    public void disableFourWheelDrive() {
        this.fourWheelDrive = false;
    }
    
    public double getGroundClearance() {
        return groundClearance;
    }

    public void setGroundClearance(double groundClearance) {
        this.groundClearance = groundClearance;
    }

    public boolean hasRoofRack() {
        return roofRack;
    }

    public void setRoofRack(boolean roofRack) {
        this.roofRack = roofRack;
    }

    @Override
    public double calculateRentalFee(int days) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String displayCarInfo() {
        return super.displayCarInfo() +
                "\nSUV" + 
                "\nFour Wheel Drive: " + fourWheelDrive + 
                "\nGround Clearance: " + groundClearance + 
                "\nRoof Rack: " + roofRack; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

}
