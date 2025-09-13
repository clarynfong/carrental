/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

/**
 *
 * @author yewzhang
 */
public class MPV extends Car{
    private int seats = 0;
    
    public MPV(String brand, String model, double rate, int seats) {
        super(brand, model, rate);
        this.seats = seats;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return super.toString() + " | Type: MPV | Seats: " + seats;
    }
}
