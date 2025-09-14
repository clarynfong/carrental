/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author yewzhang
 */
public class CarReg {
    private static ArrayList<Car> cars = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    
    public void addCar(){
        
        System.out.print("Enter vehicle brand: ");
        String brand = sc.nextLine();
        System.out.print("Enter vehicle model: ");
        String model = sc.nextLine();
        System.out.print("Enter price per day: ");
        double rate = sc.nextDouble();
        sc.nextLine();
        
        Car cc = null;
        boolean validInput = false;
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
                        cc = new Sedan(brand, model, rate, fuelEfficiency);
                        validInput = true;
                        break;
                    case 2:
                        System.out.print("Enter horsepower (hp): ");
                        double horsepower = sc.nextDouble();
                        sc.nextLine();
                        cc = new SUV(brand, model, rate, horsepower);
                        validInput = true;
                        break;
                    case 3:
                        System.out.print("Enter number of seats: ");
                        int seats = sc.nextInt();
                        sc.nextLine();
                        cc = new MPV(brand, model, rate, seats);
                        validInput = true;
                        break;
                    default:
                        System.out.print("Invalid choice, please re-enter: ");
                }

            }catch(Exception e){
                System.out.println("Invalid input, please re-enter: ");
                sc.nextLine();
            }
            
        }while(!validInput);

        cars.add(cc);
        System.out.println("New car registered");
        System.out.print(cc.toString());
    }

    public static ArrayList<Car> getCars() {
        return cars;
    }
}
