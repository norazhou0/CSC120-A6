import java.util.ArrayList;

public class House extends Building {

  private ArrayList<String> residents;
  private boolean hasDiningRoom;

  /** Constructor */
  public House(String name, String address, int nFloors, boolean hasDiningRoom) {
    super(name, address, nFloors);
    this.residents = new ArrayList<>();
    this.hasDiningRoom = hasDiningRoom;
    System.out.println("You have built a house: 🏠");
  }

  /**
   * Getter for hasDiningRoom
   * @return whether the house has a dining room
   */
  public boolean hasDiningRoom() {
    return this.hasDiningRoom;
  }

  /*
   * Getter for nResidents
   * @return the number of residents
   */
  public int nResidents() {
    return this.residents.size();
  }

  public void moveIn(String name) {
    // check if already a resident
    if (this.residents.contains(name)) {
      throw new RuntimeException(name + " is already a resident of " + this.name + ".");
    }
    // proceed if not a resident
    this.residents.add(name);
    System.out.println(name + " has moved into house " + this.name + ".");
    System.out.println(this.name + " has " + this.nResidents() + " resident(s).");
  }

  public String moveOut(String name) {
    // check if not in the house
    if (!this.residents.contains(name)){
      throw new RuntimeException(name + " is not in the house " + this.name + ".");
    }
    // proceed if in the house
    this.residents.remove(name);
    System.out.println(name + " has moved out house " + this.name + ".");
    System.out.println(this.name + " has " + this.nResidents() + " resident(s).");
    // return the name of the person who moved out
    return name;
  }

  public boolean isResident(String person) {
    return this.residents.contains(person);
    }

  public static void main(String[] args) {
    House myHouse = new House("Ziskind", "1 Henshaw Ave", 3, true);
    myHouse.moveIn("Nora");
    try {
      myHouse.moveIn("Nora");
    } catch (RuntimeException e) {
        System.out.println(e.getMessage());
    } 
    myHouse.moveOut("Nora");
    try {
      myHouse.moveOut("Alyssa");
    } catch (RuntimeException e) {
        System.out.println(e.getMessage());
    }
  }

}