import javax.swing.*;

import randomMode.mainRaceGUI;
import randomMode.randomRaceGUI;

public class Main {
    public static void main(String[] args) {
        // Create and display the main GUI for selecting opponents
        SwingUtilities.invokeLater(() -> {
            mainRaceGUI mainRaceGUI = new mainRaceGUI();
            mainRaceGUI.setVisible(true);

        });

        // Create and display the random race GUI
        SwingUtilities.invokeLater(() -> {
            randomRaceGUI randomRaceGUI = new randomRaceGUI();
        });
    }
}
