/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package car.rental;

import java.util.Date;

/**
 *
 * @author William
 */
public class CarReg {
    private int carRegNo;
    private Date carRegDate;
    private Car car;
    private static int nextCarRegNo = 1001;
    private static Car[] registeredCars = new Car[100];

    public CarReg() {
    }

    public CarReg(int carRegNo, Date dateReg, Car car, Car[] registeredCars) {
        this.carRegNo = nextCarRegNo;
        this.carRegDate = dateReg;
        this.car = car;
        this.registeredCars = registeredCars;
        nextCarRegNo++;
    }

    public int getCarRegNo() {
        return carRegNo;
    }

    public void setCarRegNo(int carRegNo) {
        this.carRegNo = nextCarRegNo;
        nextCarRegNo++;
    }

    public Date getCarRegDate() {
        return carRegDate;
    }

    public void setCarRegDate(Date carRegDate) {
        this.carRegDate = carRegDate;
    }

    public Car getCar() {
        return car;
    }

    public void addCar(Car car) {
        if (car == null)
            throw new IllegalArgumentException("Car cannot be null");
        for (int i = 0; i < registeredCars.length; i++){
            if (registeredCars[i] == null){
                registeredCars[i] = car;
            return;
            }
        }
        throw new IllegalArgumentException("Car registry is full");
    }
    
    @Override
    public String toString() {
        return 
                "CarReg" + 
                "CarRegNo: " + carRegNo + 
                "DateReg: " + carRegDate + 
                "Car: " + car;
    }
}
