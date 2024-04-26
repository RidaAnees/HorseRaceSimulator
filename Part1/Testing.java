package Part1;
import customMode.Horse;
import customMode.Race;

public class Testing {
    public static void main(String[] args) {
        // Create a horse object 
        Horse horse = new Horse('H', "Halfs", 0.5);

        System.out.println("\nTesting the getName() method:");
        testGetName(horse);

        System.out.println("\nTesting the setSymbol() and getSymbol() methods:");
        testingSymbol(horse);

        System.out.println("\nTesting the setConfidence() and getConfidence method:");
        testingConfidence(horse);

        System.out.println("\nTesting the getDistanceTravelled(), goBackToStart(), and moveForward() methods:");
        getDistanceTravelled(horse);

        System.out.println("\nTesting the fall() and hasFallen() methods:");
        testFall(horse);
    }

    //1. Testing the getName() method:
    public static void testGetName(Horse horse) {      
        System.out.println("Expected: Halfs");
        System.out.println("Actual: " + horse.getName());
    }

    //2. Testing the setSymbol() and getSymbol() method:
    private static void testingSymbol(Horse horse){
        System.out.println("Initially Expected: H");
        System.out.println("Actual: " + horse.getSymbol());
        horse.setSymbol('9');
        System.out.println("Updated information: ");
        System.out.println( horse.getSymbol());
        horse.setSymbol('*');
        System.out.println("Updated information: ");
        System.out.println( horse.getSymbol());
        horse.setSymbol('@');
        System.out.println("Updated information: ");
        System.out.println( horse.getSymbol());

        //horse.setSymbol('*&ad');

    }

    //3. Testing the setConfidence() and getConfidence() method:
    public static void testingConfidence(Horse horse){
        System.out.println("Initially Expected: 0.5");
        System.out.println("Actual: " + horse.getConfidence());
        System.out.println("Setting the symbol to '0.9'...");
        horse.setConfidence(0.9);
        System.out.println("Updated information: ");
        System.out.println( horse.getConfidence());
    }

    //4. Testing getDistanceTravelled(), goBackToStart(), and moveForward() methods:
    public static void getDistanceTravelled(Horse horse){
        int intialDistance =horse.getDistanceTravelled();
        System.out.println("Initially Expected: 0");
        System.out.println("Actual: " + intialDistance);

        horse.moveForward();
        System.out.println("Expected: 1");
        System.out.println("Actual: " + horse.getDistanceTravelled());

        horse.goBackToStart();
        System.out.println("Expected: 0");
        System.out.println("Actual: " + horse.getDistanceTravelled());
    }

    //5. Testing fall() and hasFallen();
    public static void testFall(Horse horse){
        System.out.println("Initially Expected: false");
        System.out.println("Actual: " + horse.hasFallen());

        System.out.println("Making the horse fall...");
        horse.fall();
        
        System.out.println("Expected: true");
        System.out.println("Actual: " + horse.hasFallen());
    }
}

