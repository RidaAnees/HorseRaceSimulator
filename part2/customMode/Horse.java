/**
 * This class represents a horse in a virtual racing game.
 * Each horse has a name, a symbol, a distance travelled, a confidence level, 
 * and a boolean indicating whether it has fallen.
 * 
 * This class provides methods to initialize and manipulate the state of a horse,

 * @author Aminath Anees 
 * @version Version 2 
 */

package customMode;

public class Horse {

    // Fields of class Horse
    private String name;
    private char symbol;
    private int distanceTravelled;
    private boolean hasFallen;
    private double confidence;

    // Constructor of class Horse
    public Horse(char horseSymbol, String horseName, double horseConfidence) {
        this.symbol = horseSymbol;
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
    public char getSymbol() {
        return this.symbol;
    }
    public boolean hasFallen() {
        return this.hasFallen;
    }

    //setter methods
    public void setConfidence(double newConfidence) {
        if (newConfidence >= 0 && newConfidence <= 1) {
            this.confidence = newConfidence;
        } else {
            System.out.println("Confidence value must be between 0 and 1.");
        }
    }

    public void setSymbol(char newSymbol) {
        this.symbol = newSymbol;
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
