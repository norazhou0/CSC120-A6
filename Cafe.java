public class Cafe extends Building {

    private int nCoffeeOunces;
    private int nSugarPackets;
    private int nCreams;
    private int nCups;
  
    /** 
     * Constructor for Cafe
     * @param name of the cafe
     * @param address of the cafe
     * @param nFloors number of floors of the cafe
     * @param nCoffeeOunces number of ounces of coffee remaining in inventory
     * @param nSugarPackets number of sugar packets remaining in inventory
     * @param nCreams number of "splashes" of cream remaining in inventory
     * @param nCups number of cups remaining in inventory
     */
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
      super(name, address, nFloors);
      this.nCoffeeOunces = nCoffeeOunces;
      this.nSugarPackets = nSugarPackets;
      this.nCreams = nCreams;
      this.nCups = nCups;
      System.out.println("You have built a cafe: ☕");
    }
    
    /** 
     * Method for selling coffee
     * @param size needed
     * @param the number of sugar packets needed
     * @param the number of creams needed
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
      // restock if insufficient inventory
      if (this.nCoffeeOunces < size || this.nSugarPackets < nSugarPackets || this.nCreams < nCreams || this.nCups < 1) {
        System.out.println("Oops, not enough inventory at " + this.name + ".");
        restock(size, nSugarPackets, nCreams, 1);
      }
      // proceed to sell after restocking
      this.nCoffeeOunces -= size;
      this.nSugarPackets -= nSugarPackets;
      this.nCreams -= nCreams;
      this.nCups -= 1;
      System.out.println("Coffee has been sold. Remaining inventory: ");
      System.out.println("Coffee: " + this.nCoffeeOunces + " oz, Sugar: " + this.nSugarPackets + " packet(s), Cream: " + this.nCreams + ", Cup(s): " + this.nCups);
    }
    
    /** 
     * Method for restocking
     * @param the number of ounces of coffee for restocking
     * @param the number of sugar packets for restocking
     * @param the number of creas for restocking
     * @param the number of cups for restocking
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
      this.nCoffeeOunces += nCoffeeOunces;
      this.nSugarPackets += nSugarPackets;
      this.nCreams += nCreams;
      this.nCups += nCups;
      System.out.println("Successfully restocked. Current inventory: ");
      System.out.println("Coffee: " + this.nCoffeeOunces + " oz, Sugar: " + this.nSugarPackets + " packet(s), Cream: " + this.nCreams + ", Cup(s): " + this.nCups);
    }
  
    public static void main(String[] args) {
      Cafe smithCafe = new Cafe("Compass", "7 Neilson Drive", 1, 100, 50, 50, 15);
      smithCafe.sellCoffee(50, 25, 25);
      smithCafe.sellCoffee(50, 25, 25);
      smithCafe.sellCoffee(50, 25, 25);
      smithCafe.sellCoffee(200, 100, 100);
    }
  
  }