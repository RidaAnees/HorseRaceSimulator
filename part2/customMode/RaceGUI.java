package customMode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class RaceGUI extends JFrame {

    private Race race;
    private List<JTextField> horseNameFields;
    private List<JTextField> horseConfidenceFields;
    private List<JTextField> horseSymbolFields;

    private JTextField distanceField;
    private JButton startButton;
    private JTextArea raceResultsTextArea; // To display race results

    public RaceGUI() {
    setTitle("Horse Race Simulation");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());

    JPanel setupPanel = new JPanel(new GridLayout(0, 2));
    JLabel distanceLabel = new JLabel("Enter race distance:");
    distanceField = new JTextField(10);
    setupPanel.add(distanceLabel);
    setupPanel.add(distanceField);

    JLabel horsesLabel = new JLabel("Enter horse details:");
    setupPanel.add(horsesLabel);
    setupPanel.add(new JLabel());
    horseNameFields = new ArrayList<>();
    horseConfidenceFields = new ArrayList<>();
    horseSymbolFields = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
        JTextField horseNameField = new JTextField(10);
        JTextField horseConfidenceField = new JTextField(10);
        JTextField horseSymbolField = new JTextField(10);
        horseNameFields.add(horseNameField);
        horseConfidenceFields.add(horseConfidenceField);
        horseSymbolFields.add(horseSymbolField);
        setupPanel.add(new JLabel("Horse " + (i + 1) + " name:"));
        setupPanel.add(horseNameField);
        setupPanel.add(new JLabel("Horse " + (i + 1) + " Symbol:"));
        setupPanel.add(horseSymbolField);
        setupPanel.add(new JLabel("Horse " + (i + 1) + " confidence:"));
        setupPanel.add(horseConfidenceField);
    }

    startButton = new JButton("Start Race");
    startButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            startRace();
        }
    });

    raceResultsTextArea = new JTextArea(10, 20);
    raceResultsTextArea.setEditable(false);

    JPanel bottomPanel = new JPanel(new BorderLayout());
    bottomPanel.add(startButton, BorderLayout.NORTH);
    bottomPanel.add(new JScrollPane(raceResultsTextArea), BorderLayout.CENTER);

    // Instantiate RaceVisualizer
    RaceVisualizer raceVisualizer = new RaceVisualizer();
    add(raceVisualizer, BorderLayout.WEST); // Add RaceVisualizer to the WEST

    add(setupPanel, BorderLayout.CENTER);
    add(bottomPanel, BorderLayout.SOUTH);

    pack();
    setLocationRelativeTo(null);
}


    public interface GUIRaceVisualizer {
        void updateRaceProgress(List<Horse> horses);
    }
    private void startRace() {
        String distanceText = distanceField.getText();
        try {
            int distance = Integer.parseInt(distanceText);
            race = new Race(distance);

            double maxConfidence = Double.MIN_VALUE;
            String winner = "";

            for (int i = 0; i < horseNameFields.size(); i++) {
                String horseName = horseNameFields.get(i).getText().trim();
                String confidenceText = horseConfidenceFields.get(i).getText().trim();

                if (!horseName.isEmpty() && !confidenceText.isEmpty()) {
                    double horseConfidence = Double.parseDouble(confidenceText);
                    if (horseConfidence > maxConfidence) {
                        maxConfidence = horseConfidence;
                        winner = horseName;
                    }
                    race.addHorse(new Horse(Character.forDigit(i + 1, 10), horseName, horseConfidence), i + 1);
                }
            }

            if (winner.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter at least one horse with confidence level.");
                return;
            }

            // Run the race
            raceResultsTextArea.setText(""); // Clear previous race results
            race.startRace();
            List<String> results = race.getRaceResults();
            for (String result : results) {
                raceResultsTextArea.append(result + "\n"); // Display race results in JTextArea
            }

            // Display the winner
            //showWinner(winner);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter valid numbers.");
        }
    }

    //public void showWinner(String winner) {
    //  JOptionPane.showMessageDialog(this, "The winner is: " + winner, "Race Winner", JOptionPane.INFORMATION_MESSAGE);
    //}

    public void updateRace(List<Horse> horses) {
        // Check if the component is an instance of RaceVisualizer
        Component[] components = getContentPane().getComponents();
        for (Component component : components) {
            if (component instanceof RaceVisualizer) {
                RaceVisualizer raceVisualizer = (RaceVisualizer) component;
                raceVisualizer.updateRaceProgress(horses);
                return; // Stop searching after finding the RaceVisualizer
            }
        }
        // Handle case where RaceVisualizer is not found
        System.err.println("RaceVisualizer component not found in content pane.");
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                RaceGUI raceGUI = new RaceGUI();
                raceGUI.setVisible(true);
            }
        });
    }
}
