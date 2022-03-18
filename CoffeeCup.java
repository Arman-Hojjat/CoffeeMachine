/**
 * A coffee cup
 * In part 2, additional information will be added to this cup
 *
 * @author RD
 */
package coffeeklatch;

import java.util.Scanner;

/**
 *
 * @author gordon.payne
 */
public class CoffeeCup {

    Scanner keyboard = new Scanner(System.in);
    // Is this cup full?  Default value false.
    public boolean isFull;  
    private String name ;
    private String size;
    private int amount ;

    public CoffeeCup() {
        this.isFull = false;
        this.size = "none";
        this.name = "none";
    }

    /**
     * Sets the customers name to the cup
     */
    public void setName() {
        System.out.print("What is your name? ");
        name = keyboard.nextLine();
    }

    /**
     * Returns the name the user inputed
     *
     * @return What is the name for the cup?
     */
    public String getName() {
        return name;
    }

    /**
     * Takes the size the user inputed and assigns it to it's corresponding
     * string
     *
     * @param s This character is compared to assign a string
     */
    public void setSize(char s) {
        switch (s) {
            case 's':
                size = "small";
                break;
            case 'm':
                size = "medium";
                break;
            case 'l':
                size = "large";
                break;
        }
    }

    /**
     * Returns the corresponding string to the letter the user inputed
     *
     * @return what size drink do they want?
     */
    public String getSize() {
        return size;
    }

    /**
     * Determines the number of units to reduce the level by based on the cup
     * the customer chose
     *
     * @return How many units to subtract from the coffee brewed, an integer
     */
    public int amountDrink() {
        switch (size) {
            case "small":
                amount = 2;
                break;
            case "medium":
                amount = 3;
                break;
            case "large":
                amount = 4;
                break;
        }
        return amount;
    }

    /**
     * Returns whether this cup is full (true) or empty(false);
     *
     * @return is this cup full?
     */
    public boolean isFull() {
        return isFull;
    }

    /**
     * Fill this cup to the top
     */
    public void fill() {
        isFull = true;
    }

    /**
     * Drink this cup entirely if there is coffee
     * @return Returns whether or not there is coffee to drink
     */
    public boolean drink() {
        if (isFull == true) {
            System.out.println(name + ", you glug the coffee down.");
            isFull = false;
            return true;
        } else {
            System.out.println(name + ", you sip furiously, but only suck air.");
            return false;
        }

    }
    /**
     * Resets all the values on the machine, so a new batch can be made
     */
    public void reset() {
        isFull = false;
    }
}
