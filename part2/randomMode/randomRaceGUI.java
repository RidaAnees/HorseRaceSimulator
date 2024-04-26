package randomMode;
import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class randomRaceGUI {
    JFrame frame;

    public randomRaceGUI() {
        frame.setLayout(new BorderLayout());
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Generate selected horse
        Horse2 selectedHorse = generateSelectedHorse();

        // Create myHorse instance
        myHorse myHorse = new myHorse();

        // Create Opponents instance

        // Add components to the frame as needed

        frame.setVisible(true);
    }

    // Method to generate a selected horse (for demonstration)
    private Horse2 generateSelectedHorse() {
        // This is just a placeholder. Replace it with your logic to generate a selected horse.
        // For now, let's create a simple horse named "Selected Horse" with some default attributes.
        ImageIcon horseImage = new ImageIcon("pics\\SelectedHorse.jpg");
        return new Horse2("Selected Horse", horseImage, 0.8);
    }

}
