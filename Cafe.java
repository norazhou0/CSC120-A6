
public class Cafe extends Building {

    private int nCoffeeOunces;
    private int nSugarPackets; 
    private int nCreams; 
    private int nCups; 

    /** Constructor */
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        System.out.println("You have built a cafe: ☕");
    }
    
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

    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
        System.out.println("Successfully restocked. Current inventory: ");
        System.out.println("Coffee: " + this.nCoffeeOunces + " oz, Sugar: " + this.nSugarPackets + " packet(s), Cream: " + this.nCreams + ", Cup(s): " + this.nCups);
    }



    public static void main(String[] args) {
        Cafe SmithCafe = new Cafe("Compass", "7 Neilson Drive", 1, 100, 50, 50, 15);
        SmithCafe.sellCoffee(50, 25, 25);
        SmithCafe.sellCoffee(50, 25, 25);
        SmithCafe.sellCoffee(50, 25, 25);
        SmithCafe.sellCoffee(200, 100, 100);
    }
    
}
