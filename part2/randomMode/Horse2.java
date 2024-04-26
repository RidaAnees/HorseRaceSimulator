package randomMode;
import javax.swing.ImageIcon;

public class Horse2 {
    // Fields of class Horse
    private String name;
    private ImageIcon image;
    private int distanceTravelled;
    private boolean hasFallen;
    private double confidence;

    // Constructor of class Horse
    public Horse2(String horseName, ImageIcon image, double horseConfidence) {
        this.image = image;
        this.name = horseName;
        this.confidence = horseConfidence;
        this.distanceTravelled = 0;
        this.hasFallen = false;
    }
    
    // Get methods:
    public double getConfidence() {
        return this.confidence;
    }

    public int getDistanceTravelled() {
        return this.distanceTravelled;
    }

    public String getName() {
        return this.name;
    }

    public ImageIcon getImage() {
        return this.image;
    }

    public boolean hasFallen() {
        return this.hasFallen;
    }

    //setter methods
    public void setConfidence(double newConfidence) {
        if (Double.isFinite(newConfidence)) {
            if (newConfidence >= 0 && newConfidence <= 1) {
                this.confidence = newConfidence;
            } else {
                System.out.println("ERROR: Confidence value must be between 0 and 1.\n");
            }
        } else {
            System.out.println("ERROR: Invalid confidence value. Please provide a valid number.");
        }
    }
    
    public void setImage(ImageIcon newImage) {
        this.image = newImage;
    }

    // other methods
    public void fall() {
        this.hasFallen = true;
    }

    public void goBackToStart() {
        this.distanceTravelled = 0;
        this.hasFallen = false;
    }

    public void moveForward() {
        if (!this.hasFallen) {
            this.distanceTravelled++;
        }
    }

}
