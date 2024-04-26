package randomMode;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainRaceGUI extends JFrame implements ActionListener {
    private JButton customModeButton;
    private JButton randomModeButton;
    private JButton startButton;

    private JTextArea raceResultsTextArea;

    private JTextField cashTextField; 
    private JTextField betAmountTextField;
    private JTextField placedBetTextField; 

    public mainRaceGUI() {
        setTitle("Horse Race Simulation");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create a split pane
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);

        // Create panels for left and right sides
        JPanel leftPanel = new JPanel(new BorderLayout());
        JPanel rightPanel = new JPanel(new BorderLayout());

        // Background
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon icon = new ImageIcon("background.jpg"); 
                g.drawImage(icon.getImage(), 0, 0, getWidth(), getHeight(), null);
            }
        };
        backgroundPanel.setLayout(new BorderLayout());
        backgroundPanel.setOpaque(false); // Make the panel transparent

        // Welcome panel
        JPanel welcomePanel = new JPanel(new BorderLayout());
        JLabel welcomeLabel = new JLabel("Welcome to Horse Race Simulation!");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 30));
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        welcomePanel.add(welcomeLabel, BorderLayout.CENTER);

        // Description panel
        JPanel descriptionPanel = new JPanel(new BorderLayout());
        JTextArea descriptionArea = new JTextArea("This is a horse race simulation game.\n\n" +
                "\n\nTo your <--LEFT is the betting panel and it is a real world horse racing and betting environment where you bet against fellow horse race enthusiasts. " +
                "\n      - Enter how much you have, "+
                "\n      - how much you're willing to bet, " +
                "\n      - select your horse (choose wisely), "+
                "\n      - randomly generate opponent horses" +
                "\n and watch them race! "+
        "\n\n\n*********************************************************************************\n" +
        "\n\nAnd below is 2 game modes to practice and learn, suitable for beginners. " + 
        "\n\nFeel free to play Custom Mode in which you set all attributes of horses freely and have full experimental flexibility (minimum 2 horses) "+
        "\nand play Random Mode in which the number of horses, your specific horse and others are generated randomly." + "\n\nTry enterring Lana, L, 0.5 and Barry, B, 0.8 in custom mode for a start"+
        "\n\nHAVE FUN!"+ "\n\n\n\n\n\n\n\n\n\n\n\nDo you want to play in custom mode or random mode?");

        descriptionArea.setFont(new Font("Arial", Font.PLAIN, 14));
        descriptionArea.setEditable(false);
        descriptionArea.setOpaque(false); // Make the text area transparent
        descriptionPanel.add(descriptionArea, BorderLayout.CENTER);
        descriptionArea.setLineWrap(true);

        // Button panel
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        customModeButton = new JButton("Custom Mode");
        randomModeButton = new JButton("Random Mode");
        buttonPanel.add(customModeButton);
        buttonPanel.add(randomModeButton);
        // Set button colors
        customModeButton.setBackground(Color.GREEN);
        customModeButton.setForeground(Color.BLACK);
        randomModeButton.setBackground(Color.ORANGE);
        randomModeButton.setForeground(Color.BLACK);
        //******************************************Setup panel ******************************************** */
        JPanel setupPanel = new JPanel(new GridLayout(0, 2));

        raceResultsTextArea = new JTextArea(10, 20);
        raceResultsTextArea.setEditable(false);

        startButton = new JButton("View statistics");
        startButton.addActionListener(this);
        startButton.setBackground(Color.YELLOW);
        

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(startButton, BorderLayout.NORTH);
        bottomPanel.add(new JScrollPane(raceResultsTextArea), BorderLayout.CENTER);

        // Add components to left panel
        leftPanel.add(createHorse1Panel(), BorderLayout.CENTER);
        leftPanel.add(bottomPanel, BorderLayout.SOUTH);

        // Add components to right panel
        rightPanel.add(welcomePanel, BorderLayout.NORTH);
        rightPanel.add(descriptionPanel, BorderLayout.CENTER);
        rightPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Set the minimum size of the left and right panels
        leftPanel.setMinimumSize(new Dimension(400, 0));
        rightPanel.setMinimumSize(new Dimension(400, 0));


        // Set the components to the split pane
        splitPane.setLeftComponent(leftPanel);
        splitPane.setRightComponent(rightPanel);
        splitPane.setDividerLocation(400); // Initial divider location

        // Add split pane to background panel
        backgroundPanel.add(splitPane, BorderLayout.CENTER);

        add(backgroundPanel);
        backgroundPanel.add(setupPanel, BorderLayout.SOUTH);

        randomModeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement random mode logic here
                // For now, just print a message
                System.out.println("Random mode started.");
            }
        });

        pack(); // Pack the frame
        setLocationRelativeTo(null); // Center the window
        setVisible(true); // Make the frame visible
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            startRace();
        } else if (e.getActionCommand().equals("PLACE BET")) {
            // Handle place bet action
            String cashStr = cashTextField.getText();
            String betAmountStr = betAmountTextField.getText();
            try {
                double cash = Double.parseDouble(cashStr);
                double betAmount = Double.parseDouble(betAmountStr);
                if (betAmount <= cash) {
                    placedBetTextField.setText(betAmountStr);
                    e.getActionCommand().equals("SELECT A HORSE");{
                        new myHorse();
                    }

                } else {
                    placedBetTextField.setText("Insufficient cash");
                }
            } catch (NumberFormatException ex) {
                placedBetTextField.setText("Invalid input");
            }
        } else if (e.getActionCommand().equals("SELECT A HORSE")) {
            raceResultsTextArea.setText("PLace a bet first");
        }
    }

    private void startRace() {
        // Implement race logic here
        // For now, just print a message
        System.out.println("Race started.");
    }

    private JPanel createHorse1Panel() {
        JPanel horse1Panel = new JPanel(new GridLayout(0, 2));
        horse1Panel.setBorder(BorderFactory.createTitledBorder("Horse 1"));
        horse1Panel.setSize(new Dimension(200, 150));

        JLabel cashLabel = new JLabel("CASH:$");
        JLabel betAmountLabel = new JLabel("BET AMOUNT:$");
        JLabel placedBetLabel = new JLabel("PLACED BET:$");

        cashTextField = new JTextField(); // Initialize cashTextField
        betAmountTextField = new JTextField(); // Initialize betAmountTextField
        placedBetTextField = new JTextField(); // Initialize placedBetTextField

        JButton placeBetButton = new JButton("PLACE BET");
        placeBetButton.setBackground(Color.pink);
        placeBetButton.setForeground(Color.BLACK);

        JButton selectHorseButton = new JButton("SELECT A HORSE");
        selectHorseButton.setBackground(Color.pink);
        selectHorseButton.setForeground(Color.BLACK);


        placeBetButton.addActionListener(this);
        selectHorseButton.addActionListener(this);

        horse1Panel.add(cashLabel);
        horse1Panel.add(cashTextField);
        horse1Panel.add(betAmountLabel);
        horse1Panel.add(betAmountTextField);
        horse1Panel.add(placeBetButton);
        horse1Panel.add(placedBetLabel);
        horse1Panel.add(placedBetTextField);
        horse1Panel.add(selectHorseButton);

        return horse1Panel;
    }

}
