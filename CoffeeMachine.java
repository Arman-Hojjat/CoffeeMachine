/* A fancy coffee maker.  Makes coffee of varying strengths. */
/**
 *
 * @author RDCOMP
 */
package coffeeklatch;

/**
 *
 * @author gordon.payne
 */
public class CoffeeMachine {

   private String strength;
   private boolean water;
   private boolean beans;
   private boolean beansGround;
   private boolean coffeeBrewed;
   private int level;
   private boolean cupFull;

    public CoffeeMachine() {
        this.water = false;
        this.coffeeBrewed = false;
        this.level = 0;
        this.cupFull = false;
        this.beansGround = false;
        this.beans = false;
        this.strength = "none";
    }

    /**
     * Set the strength of the Coffee to s; affects the fineness of the grind.
     * "Weak", "Regular", "Strong" and "Killer Intense
     *
     * @param s is to be compared to determine the strength of coffee the user
     * wants
     */
    public void setStrength(char s) {
        switch (s) {
            case 's':
                strength = "Strong";
                break;
            case 'w':
                strength = "Weak";
                break;
            case 'r':
                strength = "Regular";
                break;
            case 'k':
                strength = "Killer Intense";
                break;
        }
    }

    /**
     * Grind the beans for the coffee
     */
    public void grindBeans() {
        if (beansGround == true){
            System.out.println("You've already ground the beans");
        } else if (beans == true) {
            beansGround = true; //The machine grinds the beans in the grinder.
            System.out.println("Grinding beans for " + strength + " coffee.");
        } else {
            System.out.println("***PLEASE ADD BEANS FIRST.");
        }
    }

    /**
     * Brew the coffee into given cup c
     *
     * @param c The cup of coffee to be filled
     */
    public void brew(CoffeeCup c) {
        if (water == true) {
            if (beansGround == true) {              
                    System.out.println("Brewing " + strength + " coffee for " + c.getName());
                    coffeeBrewed = true;
            } else {
                System.out.println("***PLEASE GRIND THE BEANS.");
            }
        } else {
            System.out.println("***PLEASE ADD WATER.");
        }

    }

    /**
     * Add water to the machine reservoir
     */
    public void addWater() {
        if (water == true) {
            System.out.println("You've already added water.");
        } else {
            level = 10;      
            water = true;
            System.out.println("Adding Water.");
        }
    }

    /**
     * Add Beans to the Machine
     */
    public void addBeans() {
        if (beans == true) {
            System.out.println("There are already beans in the machine.");
        } else {
            System.out.println("Adding Beans.");
            beans = true;
        }

    }

    /**
     * Pour the brewed coffee into the cup
     *
     * @param c the cup of coffee that is being currently filled
     */
    public void pour(CoffeeCup c) {
        if (coffeeBrewed == true) {
            if (c.isFull()) {
                System.out.println("Your cup is already full!");
            } else if (level >= c.amountDrink()) {
                c.fill();
                level = level - c.amountDrink();
                System.out.println("Pouring a cup of coffee");
            } else if (level > 0) {
                System.out.println("***YOU NEED TO MAKE MORE COFFEE!");
                this.reset();
                c.reset();
            }
        } else {
            System.out.println("***PLEASE BREW COFFEE");
        }

    }

    /**
     * Resets all the values on the machine, so a new batch can be made
     */
    public void reset() {
        water = false;
        beans = false;
        beansGround = false;
        level = 0;
        coffeeBrewed = false;
        cupFull = false;
        System.out.println("Restting flags...");
    }

    /**
     * Returns whether water has been added (true) or not(false);
     *
     * @return is there water in the machine?
     */
    public boolean waterStatus() {
        return water;
    }

    /**
     * Returns whether beans have been added (true) or not(false);
     *
     * @return are there beans in the machine?
     */
    public boolean beanStatus() {
        return beans;
    }

    /**
     * Returns whether the beans have been ground (true) or not(false);
     *
     * @return are the beans ground?
     */
    public boolean grindStatus() {
        return beansGround;
    }

    /**
     * Returns whether the coffee has been brewed (true) or not(false);
     *
     * @return is the coffee ready?
     */
    public boolean brewStatus() {
        return coffeeBrewed;
    }

    /**
     * Returns the level of water left in the machine's tank
     *
     * @return the amount of coffee left as an integer?
     */
    public int levelStatus() {
        return level;
    }

    /**
     * Returns the corresponding strength to the letter the user inputed
     *
     * @return The strength of the coffee
     */
    public String strengthStatus() {
        return strength;
    }

}
