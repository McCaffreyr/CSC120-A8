//overloaded movein and constructor

/* This is a stub for the House class */
import java.util.ArrayList;

public class House extends Building{

  private ArrayList<Student> residents;
  private boolean hasDiningRoom;
  private boolean hasElevator;

  /**
   * Complete constructor for the House Class
   * @param name name of house
   * @param address address of house
   * @param nFloors number of floors in house
   * @param hasDiningRoom whether the house has a dining room
   * @param hasElevator whether the house has an elevator
   */
  public House(String name, String address, int nFloors, Boolean hasDiningRoom, Boolean hasElevator){
    super(name, address, nFloors);
    this.hasDiningRoom = hasDiningRoom;
    this.hasElevator = hasElevator;
    residents = new ArrayList<Student>();
    System.out.println("You have built a house: 🏠");
  }

  /**
   * Constructor for the House Class
   * @param name name of house
   * @param address address of house
   * @param nFloors number of floors in house
   * @param hasDiningRoom whether the house has a dining room
   */
  public House(String name, String address, int nFloors, Boolean hasDiningRoom){
    super(name, address, nFloors);
    this.hasDiningRoom = hasDiningRoom;
    hasElevator = false;
    residents = new ArrayList<Student>();
    System.out.println("You have built a house: 🏠");
  }
  
  /**
   * Constructor for the House Class
   * @param name name of house
   * @param address address of house
   * @param nFloors number of floors in house
   */
  public House(String name, String address, int nFloors){
    super(name, address, nFloors);
    hasDiningRoom = false;
    hasElevator = false;
    residents = new ArrayList<Student>();
    System.out.println("You have built a house: 🏠");
  }

  /**
   * Constructor for the House Class
   * @param name name of house
   * @param address address of house
   */
  public House(String name, String address){
    super(name, address);
    hasDiningRoom = false;
    hasElevator = false;
    residents = new ArrayList<Student>();
    System.out.println("You have built a house: 🏠");
  }

  /**
   * Default constructor for the House Class
   * @param name name of house
   */
  public House(String name){
    super(name);
    hasDiningRoom = false;
    hasElevator = false;
    residents = new ArrayList<Student>();
    System.out.println("You have built a house: 🏠");
  }
  
  /**
   * Moves person to a specfic floor
   * @param floorNum intended floor number to travel to
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
   * Shows whether the house has a dining room
   * @return T/F depending on if the house has a dining room
   */
  public boolean hasDiningRoom() {
    return this.hasDiningRoom;
  }

  /**
   * Shows number of residents in house
   * @return number of residents
   */
  public int nResidents(){
    if (residents == null){
      return 0;
    } else{
      return residents.size();
    }
  }

  /**
   * Adds a student to the house's list of residents
   * @param s student moving into the house
   */
  public void moveIn(Student s){
    residents.add(s);
  }

  /**
   * Default version of moveIn
   */
  public void moveIn(){
    Student noName = new Student("No Name", "No ID", 0000);
    residents.add(noName);
  }

  /**
   * Removes a student from the house's list of residents
   * @param s student moving out of the house
   * @return student name
   */
  public Student moveOut(Student s){
    residents.remove(s);
    return s;
  }

  /**
   * Says whether a student is a resident of a house
   * @param s student in question
   * @return T/F if they are a house resident
   */
  public boolean isResident(Student s){
    return residents.contains(s);
  }

  /**
   * Gives command options
   */
  public void showOptions() {
    super.showOptions();
    System.out.println("moveIn()\n + moveOut()\n + isResident()");
  }

  public static void main(String[] args) {
    House Albright = new House("Albright","7 Bedford Terrace", 4, false, false);
    System.out.println(Albright);
    Student abby = new Student("Abby","991473910",2028);
    Albright.moveIn(abby);

    Albright.showOptions();



  }

}