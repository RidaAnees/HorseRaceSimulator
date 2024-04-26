package Part1;
/**
 * This class represents a Race between three horses.
 * 
 * @author Aminath Anees 
 * @version Version 2 
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class Race {
    private int raceLength;
    private List<Horse> horses;

    public Race(int distance) {
        raceLength = distance;
        horses = new ArrayList<>();
    }

    public void addHorse(Horse horse, int laneNumber) {
        horses.add(horse);
    }

    public void startRace() {
        boolean finished = false;
        for (Horse horse : horses) {
            horse.goBackToStart();
        }
        while (!finished) {
            for (Horse horse : horses) {
                moveHorse(horse);
            }
            printRace();
            if (raceWonBy()) {
                finished = true;
            }

            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        List<String> raceResults = getRaceResults();
        for (String result : raceResults) {
            System.out.println(result);
        }
    }

    private void moveHorse(Horse theHorse) {
        if (!theHorse.hasFallen()) {
            if (Math.random() < theHorse.getConfidence()) {
                theHorse.moveForward();
            }
            // Adjust the probability of falling based on the number of fallen horses
            int fallenHorsesCount = countFallenHorses();
            double fallProbability = (0.1 * theHorse.getConfidence() * theHorse.getConfidence()) * (1 - fallenHorsesCount / (double) horses.size());
            if (Math.random() < fallProbability) {
                theHorse.fall();
            }
        }
    }

    private int countFallenHorses() {
        int count = 0;
        for (Horse horse : horses) {
            if (horse.hasFallen()) {
                count++;
            }
        }
        return count;
    }

    private boolean raceWonBy() {
        for (Horse theHorse : horses) {
            if (theHorse.getDistanceTravelled() == raceLength) {
                return true;
            }
        }
        return false;
    }

    private void printRace() {
        System.out.println("\033[H\033[2J");
        multiplePrint('=', raceLength + 3);
        System.out.println();
        for (Horse horse : horses) {
            printLane(horse);
            System.out.println();
        }
        multiplePrint('=', raceLength + 3);
        System.out.println();
    }

    private void printLane(Horse theHorse) {
        int spacesBefore = theHorse.getDistanceTravelled();
        int spacesAfter = raceLength - theHorse.getDistanceTravelled();
        System.out.print('|');
        multiplePrint(' ', spacesBefore);
        if (theHorse.hasFallen()) {
            System.out.print('X');
        } else {
            System.out.print(theHorse.getSymbol());
        }
        multiplePrint(' ', spacesAfter);
        System.out.print('|');
    }

    private void multiplePrint(char aChar, int times) {
        for (int i = 0; i < times; i++) {
            System.out.print(aChar);
        }
    }

    public List<String> getRaceResults() {
        List<Horse> sortedHorses = new ArrayList<>(horses);
        Collections.sort(sortedHorses, (h1, h2) -> Double.compare(h2.getDistanceTravelled(), h1.getDistanceTravelled()));
        List<String> raceResults = new ArrayList<>();
        String winner = "";
        int position = 1;

        raceResults.add("LEADERBOARD: ");
        for (Horse horse : sortedHorses) {
            String result = position + ". " + horse.getName() + " - " + horse.getDistanceTravelled() + " meters";
            if (position == 1) {
                winner = "The winner is " + horse.getName() + "!";
                raceResults.add(winner);
            }

            raceResults.add(result);
            position++;
        }
        return raceResults;
    }

    private static boolean isValidConfidence(double confidence) {
        return confidence >= 0.0 && confidence <= 1.0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Race race = new Race(20);

        try {
            for (int i = 1; i <= 3; i++) {
                System.out.println("Enter details for horse " + i + ":");
                String name;
                do {
                    name = input(scanner, "Name: ");
                    if (name.isEmpty()) {
                        System.out.println("Name cannot be empty.");
                    } else if (!name.matches("[a-zA-Z]+")) {
                        System.out.println("Name can only contain letters.");
                    } else if (name.length() > 10) {
                        System.out.println("Name cannot be longer than 10 characters.");
                    }
                } while (name.isEmpty() || !name.matches("[a-zA-Z]+") || name.length() > 10);

                System.out.print("Symbol: ");
                char symbol = scanner.next().charAt(0);

                double confidence;
                do {
                    System.out.print("Confidence level (0.0 - 1.0): ");
                    confidence = scanner.nextDouble();
                } while (!isValidConfidence(confidence));

                scanner.nextLine(); // consume newline
                Horse horse = new Horse(symbol, name, confidence);
                race.addHorse(horse, i); // Add the horse to the race with the specified lane number
            }

            // Start the race
            race.startRace();
        } catch (NullPointerException e) {
            System.out.println("Error: One or more horses were not added to the race lanes.");
            System.out.println("Please make sure to add all horses before starting the race.");
        } finally {
            scanner.close(); // Close the scanner to release resources
        }
    }

    private static String input(Scanner scanner, String message) {
        System.out.println(message);
        return scanner.nextLine();
    }
}
