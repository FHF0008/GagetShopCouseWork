/*
 * Mobile Class
 * Represents a mobile gadget extending the Gadget class with additional attributes and methods.
 */

public class Mobile extends Gadget {
    // Additional attribute
    private int callingCredit; // The remaining calling credit in minutes

    // Constructor
    public Mobile(String model, double price, int weight, String size, int callingCredit) {
        super(model, price, weight, size); // Calling the constructor of the superclass
        this.callingCredit = callingCredit;
    }

    /**
     * Retrieves the remaining calling credit.
     * @return The remaining calling credit in minutes.
     */
    public int getCallingCredit() {
        return callingCredit;
    }

    /**
     * Adds calling credit to the mobile.
     * @param credit The amount of calling credit to add.
     */
    public void addCallingCredit(int credit) {
        if (credit > 0) {
            callingCredit += credit;
            System.out.println("Calling credit added successfully.");
        } else {
            System.out.println("Please enter a positive amount to add calling credit.");
        }
    }

    /**
     * Makes a phone call with the given phone number and duration.
     * @param phoneNumber The phone number to call.
     * @param duration The duration of the call in minutes.
     */
    public void makeCall(String phoneNumber, int duration) {
        if (callingCredit >= duration) {
            System.out.println("Calling " + phoneNumber + " for " + duration + " minutes.");
            callingCredit -= duration;
        } else {
            System.out.println("Insufficient calling credit to make the call.");
        }
    }

    /**
     * Displays mobile details including model, price, weight, size, and remaining calling credit.
     * @return A string representation of mobile details.
     */
    @Override
    public String display() {
        return  super.display() + "Calling Credit Remaining: " + callingCredit + " minutes";// Calling the display method of the superclass
    }

    // Main method for testing
    // public static void main(String[] args) {
        // // Creating an instance of Mobile
        // Mobile mobile = new Mobile("Example Mobile", 499.99, 200, "71mm x 137mm x 9mm", 100);
        
        // // Displaying mobile details
        // mobile.display();
        
        // // Adding calling credit
        // mobile.addCallingCredit(50);
        
        // // Making a phone call
        // mobile.makeCall("123456789", 30);
        
        // // Displaying updated mobile details
        // mobile.display();
    // }
}
