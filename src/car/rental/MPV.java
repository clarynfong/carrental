/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package car.rental;

/**
 *
 * @author William
 */
public class MPV extends Car{
    private int slidingDoors;
    private boolean childSafetyLock;
    private int entertainmentScreens;

    public MPV() {
    }

    public MPV(int slidingDoors, boolean childSafetyLock, int entertainmentScreens, String plateNo, String color, CarType carType, boolean available, double dailyRate) {
        super(plateNo, color, carType, available, dailyRate);
        this.slidingDoors = slidingDoors;
        this.childSafetyLock = childSafetyLock;
        this.entertainmentScreens = entertainmentScreens;
    }

    public int getSlidingDoors() {
        return slidingDoors;
    }

    public void setSlidingDoors(int slidingDoors) {
        this.slidingDoors = slidingDoors;
    }

    public boolean isChildSafetyLockActive() {
        return childSafetyLock;
    }

    public void activateChildLock() {
        this.childSafetyLock = true;
    }
    
    public void deactivateChildLock() {
        this.childSafetyLock = false;
    }

    public int getEntertainmentScreens() {
        return entertainmentScreens;
    }

    public void setEntertainmentScreens(int entertainmentScreens) {
        this.entertainmentScreens = entertainmentScreens;
    }

    @Override
    public double calculateRentalFee(int days) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String displayCarInfo() {
        return 
                super.displayCarInfo() + 
                "\nMPV" + 
                "\nSliding Doors: " + slidingDoors + 
                "\nchild Safety Lock: " + childSafetyLock + 
                "\nEntertainment Screens: " + entertainmentScreens; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
}
