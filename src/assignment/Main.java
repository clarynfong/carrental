/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package assignment;

import java.util.Scanner;

/**
 *
 * @author yewzhang
 */
public class Main {

    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {  
        int choice;
        CarReg.initializeCarData();
        do {
            System.out.println("\n--- Car Rental System ---");
            System.out.println("1. Customer Management");
            System.out.println("2. Car Management");
            System.out.println("3. Rental");
            System.out.println("0. Exit");
            System.out.print("Enter your choice (0-3): ");

            choice = mainMenu();

            switch (choice) {
                case 1:
                    custMenu();
                    break;
                case 2:
                    carMenu();
                    break;
                case 3:
                    rentalMenu();
                    break;
                case 0:
                    System.out.println("Exiting system... Goodbye!");
                    break;
            }
        } while (choice != 0);
    }

    private static int mainMenu() {
        while (true) {
            try {
                int choice = sc.nextInt();
                if (choice >= 0 && choice <= 3) {
                    return choice;
                }
                System.out.print("Invalid choice, please re-enter (0-3): ");
            } catch (Exception e) {
                System.out.print("Invalid input, please re-enter (0-3): ");
                sc.nextLine(); // clear invalid input
            }
        }
    }
   
    private static void custMenu() {
        CustReg custReg = new CustReg();
        int choice = 9;
        boolean loop  = true;
        do {
            System.out.println("\n--- Customer Menu ---");
            System.out.println("1. Register Customer");
            System.out.println("2. Display Customers");
            System.out.println("0. Back");
            System.out.print("Enter your choice (0-2): ");

            do {
                try {
                    choice = sc.nextInt();
                    sc.nextLine();
                    switch (choice) {
                        case 1:
                            custReg.registerCustomer();
                            loop = false;
                            break;
                        case 2:
                            custReg.sort();
                            loop = false;
                            break;
                        case 0:
                            loop = false;
                            break;
                        default:
                            System.out.print("Invalid input, please re-enter (0-2): ");
                    }
                } catch (Exception e) {
                    System.out.print("Invalid input, please re-enter (0-2): ");
                    sc.nextLine();
                }
            } while (loop);
        } while (choice != 0);
    }
    
    private static void carMenu(){
        CarReg carReg = new CarReg();
        boolean loop = true;
        int choice = 9;
        do{
            System.out.println("\n--- Car Menu ---");
            System.out.println("1. Register New Car");
            System.out.println("2. Display All Cars");
            System.out.println("0. Back");

            System.out.print("Enter your choice (0-2): ");
        
            do {
                try {
                    choice = sc.nextInt();
                    sc.nextLine();
                    switch (choice) {
                        case 1:
                            carReg.addCar();
                            loop = false;
                            break;
                        case 2:
                            carReg.sort();
                            loop = false;
                            break;
                        case 0:
                            loop = false;
                            break;
                        default:
                            System.out.print("Invalid input, please re-enter (0-2): ");
                    }
                } catch (Exception e) {
                    System.out.print("Invalid input, please re-enter (0-2): ");
                    sc.nextLine();
                }
            } while (loop);
        } while (choice != 0);
    }
    
    private static void rentalMenu(){
        Rental rental = new Rental();
        boolean loop = true;
        int choice = 9;
        do{
            System.out.println("\n--- Rental Menu ---");
            System.out.println("1. Rent a Car");
            System.out.println("2. Process Payment");
            System.out.println("3. Rental History");
            System.out.println("0. Back");

            System.out.print("Enter your choice(0-3): ");
            do {
                try {
                    choice = sc.nextInt();
                    sc.nextLine();
                    switch (choice) {
                        case 1:
                            rental.rentCar();
                            loop = false;
                            break;
                        case 2:
                            new Cash(0).processPayment(); // Payment is abstract class, unable to define a new object to call method, use new [any payment method] create a temporary dummy object
                            loop = false;
                            break;
                        case 3:
                            rental.rentalHistory();
                            loop = false;
                            break;
                        case 0:
                            loop = false;
                            break;
                        default:
                            System.out.print("Invalid input, please re-enter (0-3): ");
                    }
                } catch (Exception e) {
                    System.out.print("Invalid input, please re-enter (0-3): ");
                    sc.nextLine();
                }
            } while (loop);
        } while (choice != 0);
    }

}
