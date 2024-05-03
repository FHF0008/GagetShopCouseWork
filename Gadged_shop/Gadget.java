/*
 * Gadget Class
 * Represents a Gadget with attributes such as model, price, weight, and size.
 */

public class Gadget {
    // Attributes
    private String model;    // The model of the gadget
    private double price;    // The price of the gadget in pounds
    private int weight;      // The weight of the gadget in grams
    private String size;     // The size of the gadget (e.g., "71mm x 137mm x 9mm")

    /**
     * Constructs a Gadget object with specified attributes.
     * @param model The model of the gadget.
     * @param price The price of the gadget in pounds.
     * @param weight The weight of the gadget in grams.
     * @param size The size of the gadget.
     */
    public Gadget(String model, double price, int weight, String size) {
        this.model = model;
        this.price = price;
        this.weight = weight;
        this.size = size;
    }

    /**
     * Retrieves the model of the gadget.
     * @return The model of the gadget.
     */
    public String getModel() {
        return model;
    }

    /**
     * Retrieves the price of the gadget.
     * @return The price of the gadget in pounds.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Retrieves the weight of the gadget.
     * @return The weight of the gadget in grams.
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Retrieves the size of the gadget.
     * @return The size of the gadget.
     */
    public String getSize() {
        return size;
    }

    /**
     * Displays information about the gadget, including its model, price, weight, and size.
     */
    public String display() 
    {
          return "Model: " + model + "Price: £" + price + "Weight: " + weight + " grams" + "Size: " + size;
    }

    /**
     * Main method for testing the Gadget class.
     * @param args Command-line arguments (not used).
     */
    // public static void main(String[] args) {
        // // Creating an instance of Gadget
        // Gadget gadget = new Gadget("Example Gadget", 299.99, 150, "71mm x 137mm x 9mm");
        
        // // Displaying gadget information
        // gadget.display();
    // }
}
