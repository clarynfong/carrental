/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package car.rental;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class CarRental {

    /**
     * @param args the command line arguments
     */
    //Global State variable
    static boolean isLoggedIn = false;

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        Customer cust = new Customer();
        CarReg carReg = new CarReg();
        CustReg custReg = new CustReg();

        while (true) {
            System.out.print("Welcome to 8auto car rental"
                    + "\n1. Log into existing customer"
                    + "\n2. Register a new customer"
                    + "\n3. Exit program"
                    + "\nOption(1-3): ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    boolean existValid = false;
                    do {
                        System.out.print("Customer Name: ");
                        String existingName = sc.nextLine();
                    } while (!existValid);
                    break;
                case 2:
                    System.out.print("Customer Registration"
                            + "\nName: ");
                    String name = sc.nextLine();
                    sc.nextLine();
                    cust.setName(name);
                    boolean ageValid = false;
                    do {
                        System.out.print("Age: ");
                        int age = sc.nextInt();
                        sc.nextLine();
                        if (age >= 18 && age <= 70) {
                            cust.setAge(age);
                            ageValid = true;
                        } else {
                            System.out.println("Age cannot be below 18 or over 70");
                        }
                    } while (!ageValid);
                    boolean genderValid = false;
                    do {
                        System.out.print("Gender(M/F): ");
                        char g = sc.next().charAt(0);
                        sc.nextLine();
                        char gender = Character.toUpperCase(g);
                        if (gender == 'M' || gender == 'F') {
                            cust.setGender(gender);
                            genderValid = true;
                        } else {
                            System.out.println("Invalid Input");
                        }
                    } while (!genderValid);
                    boolean icValid = false;
                    do {
                        System.out.print("IC number: ");
                        String ic = sc.nextLine();
                        if (ic.length() == 14) {
                            cust.setIc(ic);
                            icValid = true;
                        } else {
                            System.out.println("Invalid IC!!");
                        }
                    } while (!icValid);
                    System.out.print("Contact Nuumber: ");
                    cust.setContactNo(sc.nextLine());
                    System.out.print("Address: ");
                    cust.setAddress(sc.nextLine());
                    break;
                case 3:
                    System.out.print("Goodbye!");
                    System.exit(1);
                    break;
                default:
                    System.out.print("Invalid choice. Please select 1-3.");
            }
        }
    }
}
