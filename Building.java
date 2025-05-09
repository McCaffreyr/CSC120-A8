public class Building {

    protected String name;
    protected String address;
    protected int nFloors;
    protected int activeFloor = -1; // Default value indicating we are not inside this building

    /**
     * Default constructor for the Building class
     */
    public Building() {
        this("<Name Unknown>", "<Address Unknown>", 1);
    }

    /**
     * Overloaded building constructor with name only
     * @param name name of building (string) 
     */
    public Building(String name) {
        this(); // Call default constructor
        this.name = name;
    }

    /**
     * Overloaded building constructor with name and address 
     * @param name name of building
     * @param address address of building
     */
    public Building(String name, String address) {
        this(name, address, 1); // Call full constructor with hard-coded # floors
    }

    /**
     * Complete constructor for building class
     * @param name name of building
     * @param address address of building
     * @param nFloors number of floors the building has
     */
    public Building(String name, String address, int nFloors) {
        if (name != null) { this.name = name; }
        if (address != null) { this.address = address; } 
        if (nFloors < 1) {
            throw new RuntimeException("Cannot construct a building with fewer than 1 floor.");
        }
        this.nFloors = nFloors;
    }

    /**
     * Checks for the name of the building
     * @return name of building
     */
    public String getName() {
        return this.name;
    }

    /**
     * Checks for the address of the building
     * @return address of building
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * Checks for the number of floors the building has
     * @return number of floors in the building
     */
    public int getFloors() {
        return this.nFloors;
    }

    /**
     * Changes location to inside the building on floor 1
     * @return building info (toString)
     */
    public Building enter() {
        if (activeFloor != -1) {
            throw new RuntimeException("You are already inside this Building.");
        }
        this.activeFloor = 1;
        System.out.println("You are now inside " + this.name + " on the ground floor.");
        return this;
    }

    /**
     * Changes location to outside of the building
     * @return sentence "saying you have left x building."
     */
    public String exit() {
        if (this.activeFloor == -1) {
            throw new RuntimeException("You are not inside this Building. Must call enter() before exit().");
        }
        if (this.activeFloor > 1) {
            throw new RuntimeException("You have fallen out a window from floor #" +this.activeFloor + "!");
        }
        this.activeFloor = -1;
        return "You have left " + this.name + ".";
    }

    /**
     * Changes what floor the user is on
     * @param floorNum the number floor intended to visit
     */
    public void goToFloor(int floorNum) {
        if (this.activeFloor == -1) {
            throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
        }
        if (floorNum < 1 || floorNum > this.nFloors) {
            throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
        }
        System.out.println("You are now on floor #" + floorNum + " of " + this.name);
        this.activeFloor = floorNum;
    }

    /**
     * Goes up one floor
     */
    public void goUp() {
        this.goToFloor(this.activeFloor + 1);
    }

    /**
     * Goes down one floor
     */
    public void goDown() {
        this.goToFloor(this.activeFloor - 1);
    }

    /**
     * Shows the movement/action options
     */
    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)");
    }

    /**
     * Gives information about the building
     */
    public String toString() {
        return this.name + " is a " + this.nFloors + "-story building located at " + this.address + ".";
    }

    public static void main(String[] args) {
        System.out.println("------------------------------------");
        System.out.println("Test of Building constructor/methods");
        System.out.println("------------------------------------");
        
        Building fordHall = new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4);
        System.out.println(fordHall);
        fordHall.showOptions();

        System.out.println("-----------------------------------");
        System.out.println("Demonstrating enter/exit/navigation");
        System.out.println("-----------------------------------");
        fordHall.enter();
        fordHall.goUp();
        fordHall.goDown();
        fordHall.exit();
    }

}
