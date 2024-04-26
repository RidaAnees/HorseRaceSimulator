package customMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import java.lang.Math;
/**
 * A three-horse race, each horse running in its own lane
 * for a given distance
 * 
 * @author Aminath Anees
 * @version 1.0
 */

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
            } catch (Exception e) {}
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
            String result = position + ". " + horse.getName() + " - "  + horse.getDistanceTravelled() + " meters";
            if (position == 1) {
                winner= "The winner is " + horse.getName() + "!";
                raceResults.add(winner);

            }

            raceResults.add(result);
            position++;
        }
        return raceResults;
    }
    private String getWinner() {
        List<Horse> sortedHorses = new ArrayList<>(horses);
        Collections.sort(sortedHorses, (h1, h2) -> Double.compare(h2.getDistanceTravelled(), h1.getDistanceTravelled()));
        if (!sortedHorses.isEmpty()) {
            return sortedHorses.get(0).getName();
        }
        return "No winner";
    }
 
}
