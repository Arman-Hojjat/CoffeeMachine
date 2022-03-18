/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffeeklatch;

import java.util.Scanner;

// The purpose of this program is to create a virtual coffee machine that follows all of the conventions of a real coffee machine
//Arman Hojjatoleslami
public class CoffeeKlatch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        char choice;
// Declare a reference to a CoffeeMachine.
        CoffeeMachine machine = new CoffeeMachine();
// Create a new CoffeeCup and make the variable refer to it.        
        CoffeeCup cup = new CoffeeCup();
        boolean newUser = false;
        System.out.println("**************");
        System.out.println("*THE JAVA HUT*");
        System.out.println("**************");
        do {// repeat until the user choses 'x' to exit
            boolean rightFormat = false;

            do { // Loop repeats itself until the correct values are entered

                System.out.printf("%50s%31s%-10s%-10s%-20s\n", "MACHINE", "Cup Size: ", cup.getSize(), "Customer:", cup.getName()); // This displays the current status of all the parts of the machine                
                System.out.printf("\t\t\t%-10s%-10s%-10s%-17s%-20s%-15s%-20s\n", "Water", "Level", "Beans", "Beans Ground", "Coffee Brewed", "Cup Full", "Strength");
                System.out.printf("\t\t\t%-10s%-10s%-10s%-17s%-20s%-15s%-20s\n", machine.waterStatus(), machine.levelStatus(), machine.beanStatus(), machine.grindStatus(), machine.brewStatus(), cup.isFull(), machine.strengthStatus());
                System.out.println("(n)new customer \n(w)add water \n(b)add beans \n(g)grind beans \n(r)brew coffee \n(p)pour cup \n(d)drink cup \n(x) exit "); // taking input for mode to choose
                System.out.print("Your option: ");
                choice = keyboard.nextLine().toLowerCase().charAt(0);
                System.out.println(" ");

                if (choice == 'w' || choice == 'b' || choice == 'g' || choice == 'r' || choice == 'p' || choice == 'd' || choice == 'n' || choice == 'x') {//Checking to see if the letter typed corresponds to a mode
                    rightFormat = true;
                } else { // if the letter entered is not what it wants it asks again
                    System.out.println("Please enter a valid mode ");
                }
            } while (rightFormat != true);

            rightFormat = false;

            switch (choice) { //takes the mode the user inputed and acts on it
                case 'n': // new user
                    char size;
                    char strength;
                    machine.reset(); // calls the method to reset all the values on the machine
                    cup.reset();// resests the cup full to false
                    cup.setName(); // set the name for the user
                    do { // Loop repeats itself until the correct values are entered
                        System.out.print("What size would you like (s)mall, (m)edium, (l)arge: "); // asks the user for the cup they want
                        size = keyboard.nextLine().charAt(0);
                        size = Character.toLowerCase(size);
                        if (size == 's' || size == 'm' || size == 'l') {// only allows the user to enter the desired values
                            rightFormat = true;
                        } else {
                            System.out.println("Please enter a valid cup size");
                        }
                    } while (rightFormat != true);

                    cup.setSize(size); // creates a size from the letter that the user entered

                    rightFormat = false;
                    do { // Loop repeats itself until the correct values are entered
                        System.out.print("How do you like your coffee? (w)eak, (r)egular, (s)trong, (k)iller intense: "); // asks the user to input the strength of coffee they want
                        strength = keyboard.nextLine().charAt(0);
                        System.out.println(" ");
                        strength = Character.toLowerCase(strength);
                        if (strength == 'w' || strength == 'r' || strength == 's' || strength == 'k') {// only allows the user to enter the desired values
                            rightFormat = true;
                        } else {
                            System.out.println("Please enter a valid strength");
                        }
                    } while (rightFormat != true);
                    machine.setStrength(strength);// creates a string value of the strength from the letter entered by the user
                    newUser = true;
                    break;

                case 'w':
                    if (newUser == true) { // only allows the user to do this step if they initialized a user to start from
                        machine.addWater();// Add water to the CoffeeMachine.
                    } else {
                        System.out.println("***PLEASE CREATE A USER FIRST");
                    }
                    break;

                case 'b':
                    if (newUser == true) {// only allows the user to do this step if they initialized a user to start from
                        machine.addBeans();// Add beans to the CoffeeMachine.
                    } else {
                        System.out.println("***PLEASE CREATE A USER FIRST");
                    }
                    break;
                case 'g':
                    if (newUser == true) {// only allows the user to do this step if they initialized a user to start from
                        machine.grindBeans();// Grind the beans.
                    } else {
                        System.out.println("***PLEASE CREATE A USER FIRST");
                    }
                    break;
                case 'r':
                    if (newUser == true) {// only allows the user to do this step if they initialized a user to start from
                        machine.brew(cup);  // Have your CoffeeMachine brew coffee
                    } else {
                        System.out.println("***PLEASE CREATE A USER FIRST");
                    }
                    break;
                case 'p':
                    if (newUser == true) {// only allows the user to do this step if they initialized a user to start from
                        machine.pour(cup);// Pour the coffee into the cup
                    } else {
                        System.out.println("***PLEASE CREATE A USER FIRST");
                    }
                    break;
                case 'd':
                    if (newUser == true) {// only allows the user to do this step if they initialized a user to start from
                        cup.drink(); // drink the coffee from the cup
                    } else {
                        System.out.println("***PLEASE CREATE A USER FIRST");
                    }
                    break;

            }
        } while (choice != 'x');

    }

}
