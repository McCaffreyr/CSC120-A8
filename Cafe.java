//overloaded constructor and sellCoffee

/* This is a stub for the Cafe class */

public class Cafe extends Building{

    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory


    /* Default constructor */
    public Cafe() {
        this("<Name Unknown>", "<Address Unknown>", 1);
    }

    /* Overloaded constructor with address only */
    public Cafe(String address) {
        this(); // Call default constructor
        this.address = address; // Override address
    }

    /* Overloaded constructor with name, address */
    public Cafe(String name, String address) {
        this(name, address, 1); // Call full constructor with hard-coded # floors
    }

    /**
     * Constructor for the Cafe Class
     * @param name name of cafe
     * @param address address of cafe
     * @param nFloors number of floors in cafe
     */
    public Cafe(String name, String address, int nFloors) {
        super(name, address, nFloors);
        System.out.println("You have built a cafe: ☕");
        nCoffeeOunces = 128;
        nSugarPackets = 30;
        nCreams = 50;
        nCups = 30;
    }
    
    public void goToFloor(int floorNum) {
        if ((this.activeFloor - floorNum) < 2 && (this.activeFloor - floorNum) > -2){
            this.activeFloor = floorNum;
        }else{
            System.out.println("You can't skip floors without an elevator. Travel one floor at a time.");
        }
    }

    /**
     * Updates the inventory after selling coffee
     * @param size size in oz of coffee sold
     * @param usedSugarPackets number of sugar packets used
     * @param usedCreams nubmer of creams used
     */
    public void sellCoffee(int size, int usedSugarPackets, int usedCreams){
        nCoffeeOunces -= size;
        nSugarPackets -= usedSugarPackets;
        nCreams -= usedCreams;
        nCups -= 1;
    }

    /**
     * sellCoffee without cream
     * @param size oz of coffee sold
     * @param usedSugarPackets number of sugar packets used
     */
    public void sellCoffee(int size, int usedSugarPackets){
        nCoffeeOunces -= size;
        nSugarPackets -= usedSugarPackets;
        nCups -= 1;
    }

    /**
     * Default version of sellCoffee
     * @param size oz of coffee sold
     */
    public void sellCoffee(int size){
        nCoffeeOunces -= size;
        nCups -= 1;
    }

    /**
     * Restocks the inventory
     * @param nCoffeeOunces2 amount of coffee in oz restocked
     * @param nSugarPackets2 number of sugar packets restocked
     * @param nCreams2 number of creams restocked
     * @param nCups2 nubmer of cups restocked
     */
    private void restock(int nCoffeeOunces2, int nSugarPackets2, int nCreams2, int nCups2){
        nCoffeeOunces += nCoffeeOunces2;
        nSugarPackets += nSugarPackets2;
        nCreams += nCreams2;
        nCups += nCups2;
    }

    /**
     * Shows current inventory
     * @return string giving current inventory of coffee oz, sugar packets, creams, cups
     */
    public String stockcount(){
        return "coffee ounces: " + nCoffeeOunces + ", sugar packets: " + nSugarPackets
         + ", cream: " + nCreams + ", cups: " + nCups;
    }

    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + sellCoffee()");
    }

    public static void main(String[] args) {
        Cafe Compass = new Cafe("Compass", "7 College Lane", 2);

        System.out.println(Compass.stockcount());
        Compass.sellCoffee(12, 1, 1);
        System.out.println(Compass.stockcount());
        Compass.restock(12, 1, 1, 1);
        System.out.println(Compass.stockcount());



    }
    
}
