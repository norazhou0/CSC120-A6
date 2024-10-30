import java.util.Hashtable;

public class Library extends Building {

  private Hashtable<String, Boolean> collection; 

  /** 
   * Constructor for Library
   * @param name of the library
   * @param address of the library
   * @param nFloors number of floors
  */
  public Library(String name, String address, int nFloors) {
    super(name, address, nFloors);
    this.collection = new Hashtable<>();
    System.out.println("You have built a library: 📖");
  }

  /**
   * Method to add books to the collection
   * @param title of the book
   */
  public void addTitle(String title) {
    // check if the book exists
    if (this.collection.containsKey(title)) {
      throw new RuntimeException("The book " + title + " already exists in " + this.name + ".");
    }
    // proceed if doesn't exist
    this.collection.put(title, true);
    System.out.println("The book " + title + " has been added to " + this.name + ".");
  }

  /**
   * Method to remove books from the collection
   * @param title of the book
   * @return the book got removed
   */
  public String removeTitle(String title) {
    // check if the book doesn't exist
    if (!this.collection.containsKey(title)) {
      throw new RuntimeException("The book " + title + " doesn't exist in " + this.name + ".");
    }
    // proceed if exists
    this.collection.remove(title);
    System.out.println("The book " + title + " has been removed from " + this.name + ".");
    return title;
  }

  /**
   * Method to check out books
   * @param title of the book
   */
  public void checkOut(String title) {
    // check if the book doesn't exist
    if (!this.collection.containsKey(title)) {
      throw new RuntimeException("The book " + title + " doesn't exist in " + this.name + ".");
    }
    // check if the book has been checked out
    if (!this.collection.get(title)) {
      throw new RuntimeException("The book " + title + " has already been checked out from " + this.name + ".");
    }
    // proceed if still available
    this.collection.put(title, false);
    System.out.println("The book " + title + " has been successfully checked out from " + this.name + ".");
  }

  /**
   * Method to return books
   * @param title of the book
   */
  public void returnBook(String title) {
    // check if the book doesn't exist
    if (!this.collection.containsKey(title)) {
      throw new RuntimeException("The book " + title + " doesn't exist in " + this.name + ".");
    }
    // check if the book is available
    if (this.collection.get(title)) {
      throw new RuntimeException("The book " + title + " has not been checked out yet from" + this.name + ".");
    }
    // proceed if not available
    this.collection.put(title, true);
    System.out.println("The book " + title + " has been successfully returned to " + this.name + ".");
  }

  /**
   * Method to check if the collection contains the book
   * @return if the collection contains the book
   */
  public boolean containsTitle(String title) {
    // returns true if the title appears as a key in the Libary's collection, false otherwise
    return this.collection.containsKey(title);
  }

  /**
   * Method to check if the book is available 
   * @return if the book is abailable
   */
  public boolean isAvailable(String title) {
    // check if the book doesn't exist
    if (!this.collection.containsKey(title)) {
      throw new RuntimeException("The book " + title + " does not exist in " + this.name + ".");
    }
    // returns true if the title is currently available, false otherwise
    return this.collection.get(title);
  }

  /**
   * Method for printing out the collection
   */
  public void printCollection() {
    // prints out the entire collection in an easy-to-read way (including checkout status)
    System.out.println("The collection in " + this.name + ":");
    for (String title : this.collection.keySet()) {
      boolean isAvailable = this.collection.get(title);
      System.out.println("-" + title + ":" + isAvailable);
    }
  }

  public static void main(String[] args) {
    Library SmithLibrary = new Library("Neilson", "7 Neilson Drive", 4);
    SmithLibrary.addTitle("The Computer Science by Dr. A");
    SmithLibrary.addTitle("The Economics by Dr. B");
    SmithLibrary.addTitle("The Psychology by Dr. C");
    SmithLibrary.printCollection();
    SmithLibrary.removeTitle("The Psychology by Dr. C");
    try {
      SmithLibrary.returnBook("The Psychology by Dr. C");
    } catch (RuntimeException e) {
        System.out.println(e.getMessage());
    } 
    SmithLibrary.checkOut("The Economics by Dr. B");
    try {
      SmithLibrary.checkOut("The Economics by Dr. B");
    } catch (RuntimeException e) {
        System.out.println(e.getMessage());
    }
  }

}

