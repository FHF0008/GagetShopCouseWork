/*
 * MP3 Class
 * Represents an MP3 gadget extending the Gadget class with additional attributes and methods.
 */

public class MP3 extends Gadget {
    // Additional attribute
    private int availableMemory; // The available memory in megabytes

    // Constructor
    public MP3(String model, double price, int weight, String size, int availableMemory) {
        super(model, price, weight, size); // Calling the constructor of the superclass
        this.availableMemory = availableMemory;
    }

    /**
     * Retrieves the available memory.
     * @return The available memory in megabytes.
     */
    public int getAvailableMemory() {
        return availableMemory;
    }

    /**
     * Method for downloading music.
     * @param memoryRequired The memory required for downloading music in megabytes.
     */
    public void downloadMusic(int memoryRequired) {
        if (memoryRequired <= availableMemory) {
            availableMemory -= memoryRequired;
            System.out.println("Music downloaded successfully.");
        } else {
            System.out.println("Insufficient memory to download music.");
        }
    }

    /**
     * Method for deleting music and freeing memory.
     * @param memoryFreed The memory freed by deleting music in megabytes.
     */
    public void deleteMusic(int memoryFreed) {
        availableMemory += memoryFreed;
        System.out.println("Music deleted successfully.");
    }

    /**
     * Displays MP3 details including model, price, weight, size, and available memory.
     * @return A string representation of MP3 details.
     */
    @Override
    public String display() {
        return  super.display() + "Available Memory: " + availableMemory + " MB"; // Calling the display method of the superclass
    }

    // Main method for testing
    // public static void main(String[] args) {
        // // Creating an instance of MP3
        // MP3 mp3 = new MP3("Example MP3 Player", 99.99, 50, "50mm x 100mm x 10mm", 200);
        
        // // Displaying MP3 details
        // mp3.display();
        
        // // Downloading music
        // mp3.downloadMusic(50);
        
        // // Displaying updated MP3 details
        // mp3.display();
        
        // // Deleting music
        // mp3.deleteMusic(20);
        
        // // Displaying final MP3 details
        // mp3.display();
    // }
}
