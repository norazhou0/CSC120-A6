import java.util.ArrayList;

public class House extends Building {

  private ArrayList<String> residents;
  private boolean hasDiningRoom;

  /** 
   * Constructor for House
   * @param name of the house
   * @param address of the house
   * @param nFloors number of floors
   * @param hasDiningRoom or not
  */
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

  /**
   * Method for house residents move-in
   * @param name of the residents in the house
   */
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

  /**
   * Method for house residents move-out
   * @param name of the residents in the house
   * @return name of the resident who moved out
   */
  public String moveOut(String name) {
    // check if not in the house
    if (!this.residents.contains(name)){
      throw new RuntimeException(name + " is not in the house " + this.name + ".");
    }
    // proceed if in the house
    this.residents.remove(name);
    System.out.println(name + " has moved out house " + this.name + ".");
    System.out.println(this.name + " has " + this.nResidents() + " resident(s).");
    return name;
  }

  /**
   * Method for checking if the person is a resident
   * @param  person
   * @return if the person is a resident
   */
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