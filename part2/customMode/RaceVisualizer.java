package customMode;
import javax.swing.*;

import java.awt.*;
import java.util.List;

public class RaceVisualizer extends JPanel {

    private JPanel racePanel;

    public RaceVisualizer() {
        setLayout(new GridLayout(0, 1));

        racePanel = new JPanel();
        racePanel.setLayout(new GridLayout(0, 1));

        JScrollPane scrollPane = new JScrollPane(racePanel);
        add(scrollPane);
    }

    public void updateRaceProgress(List<Horse> horses) {
        racePanel.removeAll(); // Clear the panel
        for (Horse horse : horses) {
            JLabel horseLabel = new JLabel(horse.getName() + ": " + horse.getDistanceTravelled() + " meters");
            racePanel.add(horseLabel);
        }
        revalidate(); // Refresh the panel
        repaint(); // Repaint the panel
    }
}
