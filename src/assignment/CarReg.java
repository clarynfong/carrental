/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author yewzhang
 */
public class CarReg {
    private static ArrayList<Car> cars = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    
    public static void initializeCarData(){
        Car iniCar = null;
        iniCar = new Sedan("Proton", "Saga", "VHC9182", 100, 5);
        cars.add(iniCar);
        iniCar = new Sedan("Toyota", "Vios", "ABC1234", 120, 6);
        cars.add(iniCar);
        iniCar = new Sedan("Honda", "City", "XYZ567", 130, 6);
        cars.add(iniCar);
        
        
        iniCar = new SUV("Toyota", "Fortuner", "SUV1234", 250, 180);
        cars.add(iniCar);
        iniCar = new SUV("Honda", "CRV", "SUV5678", 220, 170);
        cars.add(iniCar);
        iniCar = new SUV("Mazda", "CX5", "SUV9012", 230, 175);
        cars.add(iniCar);
        
        
        iniCar = new MPV("Toyota", "Innova", "MPV123", 200, 7);
        cars.add(iniCar);
        iniCar = new MPV("Nissan", "Serena", "MPV456", 210, 8);
        cars.add(iniCar);
        iniCar = new MPV("Perodua", "Alza", "MPV789", 180, 7);
        cars.add(iniCar);

    }
    
    //--------------------------------------------------------------------------
    public void addCar(){
        boolean validInput = false;
        
    // Enter car detail ----------------------------
        System.out.print("Enter car brand: ");
        String brand;
        do {
            brand = sc.nextLine().trim();

            if (brand.isEmpty()) 
                System.out.print("Name cannot be empty! Please re-enter: ");
        } while(brand.isEmpty());
         
        
        System.out.print("Enter car model: ");
        String model;
        do {
            model = sc.nextLine().trim();

            if (model.isEmpty()) 
                System.out.print("Name cannot be empty! Please re-enter: ");
        } while(model.isEmpty());
        
        System.out.print("Enter car plate no.: ");
        String plate;
        do {
            plate = sc.nextLine().trim().toUpperCase();
            if (!plate.matches("^[A-Z]{3}\\d{1,4}$")) {
                System.out.print("Invalid plate number! Please re-enter(e.g. ABC1234): ");
            }
        } while (!plate.matches("^[A-Z]{3}\\d{1,4}$"));

        double rate = 0;
        do{
            try{
                System.out.print("Enter price per day: ");
                rate = sc.nextDouble();
                validInput = true;
            }catch(Exception e){
                System.out.print("Invalid input, please re-enter: ");
                sc.nextLine();
            }
        }while(!validInput);

        sc.nextLine();
        
    // Select car's type ---------------------------------------
        Car cc = null;
        validInput = false;
        System.out.println("Select Car Type:");
        System.out.println("1. Sedan");
        System.out.println("2. SUV");
        System.out.println("3. MPV");
        System.out.print("Enter your choice: ");
        do{
            try{
                int type = sc.nextInt();
                sc.nextLine();

                switch(type){
                    case 1:
                        System.out.print("Enter fuel effiency (L/100km): ");
                        double fuelEfficiency = sc.nextDouble();
                        sc.nextLine();
                        cc = new Sedan(brand, model, plate, rate, fuelEfficiency);
                        validInput = true;
                        break;
                    case 2:
                        System.out.print("Enter horsepower (hp): ");
                        double horsepower = sc.nextDouble();
                        sc.nextLine();
                        cc = new SUV(brand, model, plate, rate, horsepower);
                        validInput = true;
                        break;
                    case 3:
                        System.out.print("Enter number of seats: ");
                        int seats = sc.nextInt();
                        sc.nextLine();
                        cc = new MPV(brand, model, plate, rate, seats);
                        validInput = true;
                        break;
                    default:
                        System.out.print("Invalid choice, please re-enter: ");
                }

            }catch(Exception e){
                System.out.print("Invalid input, please re-enter: ");
                sc.nextLine();
            }
            
        }while(!validInput);
// add into array
        cars.add(cc);
        System.out.print("New car registered");
        System.out.println(cc.toString());
    }
    
    
    //-Display all the cars
    public void displayCars(){
    if (cars.isEmpty()) {
        System.out.println("No record found.");
        return;
    }
        System.out.print("\n=== Registered Cars ===");
        System.out.println("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-6s %-15s %-15s %-10s %-11s %-13s %-7s %-25s %n","Car ID", "Brand", "Model", "Plate No.", "Rate(/day)", "Availablity", "Type", "Key Feature");
        for(Car c: cars){
                System.out.print(c.toString());
        }
    }
    
    //Display only available car
    public static void displayAvailableCars(){
        System.out.println("\n=== Avaiable Cars ===");
        System.out.println("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-6s %-15s %-15s %-10s %-11s %-13s %-7s %-25s %n","Car ID", "Brand", "Model", "Plate No.", "Rate(/day)", "Availablity", "Type", "Key Feature");
        for(Car c: cars){
            if(c.isAvailable()){
                System.out.print(c.toString());
            }
        }
    }
    
    public void sort(){
        if (cars.isEmpty()) {
            System.out.println("No cars yet.");
            return;
        }
        System.out.println("\n--- Display Customers ---");
        System.out.println("1. Sort by ID");
        System.out.println("2. Sort by Daily Rate");
        System.out.print("Enter choice (1-2): ");

        int choice;
        try {
            choice = sc.nextInt();
            sc.nextLine();
        } catch (NumberFormatException e) {
            System.out.println("Invalid input, returning to menu.");
            sc.nextLine();
            return;
        }

        switch (choice) {
            case 1 -> {
                Collections.sort(cars, Comparator.comparingInt(
                        c -> Integer.valueOf(c.getCarId().substring(1))
                ));
                System.out.println("Cars sorted by ID.");
            }
            case 2 -> {
                Collections.sort(cars, Comparator.comparing(Car::getRate));
                
                System.out.println("Customers sorted by DAILY RATE.");
            }
            default -> {
                System.out.println("Invalid choice.");
                return;
            }
        }
        displayCars();
    }

    public static ArrayList<Car> getCars() {
        return cars;
    }
}
