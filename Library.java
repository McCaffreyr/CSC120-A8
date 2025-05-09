//overloaded constructor and addTitle

/* This is a stub for the Library class */
import java.util.Hashtable;

public class Library extends Building {

  private Hashtable<String, Boolean> collection;
  private boolean hasElevator;


    /**
     * Constructor for Library Class
     * @param name name of library
     * @param address address of library
     * @param nFloors number of floors in library
     * @param elevator T/F is the building has an elevator
     */
    public Library(String name, String address, int nFloors, Boolean hasElevator) {
      super(name, address, nFloors);
      this.hasElevator = hasElevator;
      System.out.println("You have built a library: 📖");
      this.collection = new Hashtable<>();
    }

    /**
     * Constructor for Library Class
     * @param name name of library
     * @param address address of library
     * @param nFloors number of floors in library
     */
    public Library(String name, String address, int nFloors) {
      super(name, address, nFloors);
      hasElevator = false;
      System.out.println("You have built a library: 📖");
      this.collection = new Hashtable<>();
    }

    /**
     * Constructor for Library Class
     * @param name name of library
     * @param address address of library
     */
    public Library(String name, String address) {
      super(name, address);
      hasElevator = false;
      System.out.println("You have built a library: 📖");
      this.collection = new Hashtable<>();
    }

    /**
     * Default constructor for Library Class
     * @param name name of library
     * @param address address of library
     */
    public Library(String name) {
      super(name);
      hasElevator = false;
      System.out.println("You have built a library: 📖");
      this.collection = new Hashtable<>();
    }

    /**
     * Moves person to a different floor
     * @param floorNum intended floor to go to
     */
    public void goToFloor(int floorNum) {
      if (hasElevator){
        if (this.activeFloor == -1) {
          throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
        }
        if (floorNum < 1 || floorNum > this.nFloors) {
          throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
        }
        System.out.println("You are now on floor #" + floorNum + " of " + this.name);
        this.activeFloor = floorNum;
      }else{
        if ((this.activeFloor - floorNum) < 2 && (this.activeFloor - floorNum) > -2){
          this.activeFloor = floorNum;
        }else{
          System.out.println("You can't skip floors without an elevator. Travel one floor at a time.");
        }
      }
    }
      

    /**
     * Adds a title to the library's collection
     * @param title book title
     */
    public void addTitle(String title){
      collection.put(title, true);
    }

    /**
     * Adds a book to the library's collection
     */
    public void addTitle(){
      collection.put("UNKNOWN BOOK", true);
    }
    
    /**
     * Removes a title from the library's collection
     * @param title book title
     * @return book title
     */
    public String removeTitle(String title){
      collection.remove(title);
      return title;
    }

    /**
     * Checks out a library book
     * @param title book title
     */
    public void checkOut(String title){
      if (collection.containsKey(title)){
        if (collection.get(title) == true){
          collection.put(title,false);
        } else{
          System.out.println("Title unavailable");
        }
      } else {
        System.out.println("Title is not in the library's collection");
      }
    }
    
    /**
     * Returns library book/adds it back to the available books
     * @param title book title
     */
    public void returnBook(String title){
      collection.put(title,true);
    }

    /**
     * Shows whether the library has the book whether or not available
     * @param title book title
     * @return T/F whether the library contains the book
     */
    public boolean containsTitle(String title){
      return collection.contains(title);
    }
    
    /**
     * Shows whether a book is available to be checked out
     * @param title book title
     * @return T/F whether the book is in stock
     */
    public boolean isAvailable(String title){
      return collection.get(title);
    }
    
    /**
     * Shows the collection of all library books
     */
    public void printCollection(){
      for (String key : collection.keySet()) {
        Boolean value = collection.get(key);
        System.out.println("Book: " + key + ", In stock: " + value);
      }
    }

    /**
     * Gives command options
     */
    public void showOptions() {
      super.showOptions();
      System.out.println("checkOut()\n + addTitle()\n + removeTitle()\n + returnBook()\n + containsTitle()\n + isAvailable()\n + printCollection()");
    }
  
    public static void main(String[] args) {
      Library Neilson = new Library("Neilson","7 Bedford Terrace",4, true);
      Neilson.addTitle("The Lorax by Dr. Seuss");
      Neilson.addTitle("Madame Bovery by Gustave Flaubert");
      Neilson.addTitle("The Heart is a Lonely Hunter by Carson McCullers");
      Neilson.printCollection();
      System.out.println(Neilson.isAvailable("The Lorax by Dr. Seuss"));
      Neilson.checkOut("The Lorax by Dr. Seuss");
      Neilson.checkOut("The Lorax by Dr. Seuss");




    }
  
  }