import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;

    /**
     * Default constructor, initializes empty ArrayList
     */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    /**
     * Shows the building options
     * @return list of buildings in the map
     */
    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street, Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court, Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Albright", "9 Bedford Terrace, Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Stoddard"));
        myMap.addBuilding(new Building("CC", "100 Elm St, Northampton, MA 01063"));
        myMap.addBuilding(new Building("Hatfield"));
        myMap.addBuilding(new Building("Neilson Library"));
        myMap.addBuilding(new Building("Art Musuem", "20 Elm St, Northampton, MA 01063", 3));
        myMap.addBuilding(new Building("Hillyer"));
        myMap.addBuilding(new Building("Burton"));
        myMap.addBuilding(new Building("McConnell", "01063, 2 Tyler Ct, Northampton, MA 01060"));
        myMap.addBuilding(new Building("DTI"));
        System.out.println(myMap);

        Library Neilson = new Library("Neilson","7 Bedford Terrace",4, true);
        Neilson.addTitle("The Lorax by Dr. Seuss");
        Neilson.addTitle();
        System.out.println(Neilson);

        Cafe Compass = new Cafe("Compass", "7 College Lane", 2);
        Compass.sellCoffee(12, 1);
        System.out.println(Compass.stockCount());

        House Albright = new House("Albright","7 Bedford Terrace", 4, false, false);
        Student abby = new Student("Abby","991473910",2028);
        Albright.moveIn(abby);
        Albright.moveIn();
        System.out.println(Albright.nResidents());




    }
    
}
