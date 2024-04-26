package randomMode;
import javax.swing.*;

import customMode.RaceGUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class opponentGUI implements ActionListener {
    java.util.List<Horse2> selectedHorses = new ArrayList<>();

    // Out of 10 horses, 1 belongs to you, 5 are chosen at random to compete with your horse
    Horse2 selectedHorse1;
    Horse2 selectedHorse2;
    Horse2 selectedHorse3;
    Horse2 selectedHorse4;
    Horse2 selectedHorse5;
    JLabel selectedHorseLabel1 = new JLabel("", SwingConstants.CENTER); // To display the selected horse
    JLabel selectedHorseLabel2 = new JLabel("", SwingConstants.CENTER); // To display the selected horse
    JLabel selectedHorseLabel3 = new JLabel("", SwingConstants.CENTER); // To display the selected horse
    JLabel selectedHorseLabel4 = new JLabel("", SwingConstants.CENTER); // To display the selected horse
    JLabel selectedHorseLabel5 = new JLabel("", SwingConstants.CENTER); // To display the selected horse

    // Print a heading for the frame
    JFrame frame = new JFrame("OPPONENTS");
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    ///frame.setSize(screenSize.width, screenSize.height);

    JLabel selectLabel = new JLabel("SELECTING YOUR OPPONENTS....");

    // ASSIGNING VALUES TO CONTESTANTS (9 Different horses)
    // Horse 1:
    JLabel horseLabel1 = new JLabel("Misr");
    ImageIcon horseImage1 = new ImageIcon("part2\\randomMode\\pics\\Horse1.jpg");
    JLabel speedLabel1 = new JLabel("SPEED:50Km/hr", SwingConstants.CENTER);
    JLabel confidenceLabel1 = new JLabel("Confidence: 0.89", SwingConstants.CENTER);

    // Horse 2:
    JLabel horseLabel2 = new JLabel("Elizzy");
    ImageIcon horseImage2 = new ImageIcon("part2\\randomMode\\pics\\Horse2.jpg");
    JLabel speedLabel2 = new JLabel("SPEED:55Km/hr", SwingConstants.CENTER);
    JLabel confidenceLabel2 = new JLabel("Confidence: 0.46", SwingConstants.CENTER);

    // Horse 3:
    JLabel horseLabel3 = new JLabel("Thee");
    ImageIcon horseImage3 = new ImageIcon("part2\\randomMode\\pics\\Horse3.jpg");
    JLabel speedLabel3 = new JLabel("SPEED:20Km/hr", SwingConstants.CENTER);
    JLabel confidenceLabel3 = new JLabel("Confidence: 0.15", SwingConstants.CENTER);

    // Horse 4:
    JLabel horseLabel4 = new JLabel("Lucky");
    ImageIcon horseImage4 = new ImageIcon("part2\\randomMode\\pics\\Horse4.jpg");
    JLabel speedLabel4 = new JLabel("SPEED:20Km/hr", SwingConstants.CENTER);
    JLabel confidenceLabel4 = new JLabel("Confidence: 0.24", SwingConstants.CENTER);

    // Horse 5:
    JLabel horseLabel5 = new JLabel("Jenny");
    ImageIcon horseImage5 = new ImageIcon("part2\\randomMode\\pics\\Horse5.jpg");
    JLabel speedLabel5 = new JLabel("SPEED:20Km/hr", SwingConstants.CENTER);
    JLabel confidenceLabel5 = new JLabel("Confidence: 0.33", SwingConstants.CENTER);

    // Horse 6:
    JLabel horseLabel6 = new JLabel("LeBron");
    ImageIcon horseImage6 = new ImageIcon("part2\\randomMode\\pics\\Horse6.jpg");
    JLabel speedLabel6 = new JLabel("SPEED:20Km/hr", SwingConstants.CENTER);
    JLabel confidenceLabel6 = new JLabel("Confidence: 0.35", SwingConstants.CENTER);

    // Horse 7:
    JLabel horseLabel7 = new JLabel("DelRey");
    ImageIcon horseImage7 = new ImageIcon("part2\\randomMode\\pics\\Horse7.jpg");
    JLabel speedLabel7 = new JLabel("SPEED:20Km/hr", SwingConstants.CENTER);
    JLabel confidenceLabel7 = new JLabel("Confidence: 0.99", SwingConstants.CENTER);

    // Horse 8:
    JLabel horseLabel8 = new JLabel("Nemo");
    ImageIcon horseImage8 = new ImageIcon("part2\\randomMode\\pics\\Horse8.jpg");
    JLabel speedLabel8 = new JLabel("SPEED:20Km/hr", SwingConstants.CENTER);
    JLabel confidenceLabel8 = new JLabel("Confidence: 0.02", SwingConstants.CENTER);

    // Horse 9:
    JLabel horseLabel9 = new JLabel("Orange");
    ImageIcon horseImage9 = new ImageIcon("part2\\randomMode\\pics\\Horse9.jpg");
    JLabel speedLabel9 = new JLabel("SPEED:20Km/hr", SwingConstants.CENTER);
    JLabel confidenceLabel9 = new JLabel("Confidence: 0.55", SwingConstants.CENTER);

    // Horse 10:
    JLabel horseLabel10 = new JLabel("Mamosa");
    ImageIcon horseImage10 = new ImageIcon("part2\\randomMode\\pics\\Horse1.jpg");
    JLabel speedLabel10 = new JLabel("SPEED:20Km/hr", SwingConstants.CENTER);
    JLabel confidenceLabel10 = new JLabel("Confidence: 0.69", SwingConstants.CENTER);


    // Buttons:
    JButton backButton = new JButton("BACK");
    JButton nextButton = new JButton("NEXT");
    JButton randomButton = new JButton("Generate 5 Random Opponents ");

    public opponentGUI() {
        frame.setLayout(null);
        frame.setBounds(2, 2, 1300, 1000);

        selectLabel.setBounds(260, 10, 200, 50);

        horseLabel1.setIcon(new ImageIcon(horseImage1.getImage().getScaledInstance(80, 60, Image.SCALE_SMOOTH)));
        horseLabel2.setIcon(new ImageIcon(horseImage2.getImage().getScaledInstance(80, 60, Image.SCALE_SMOOTH)));
        horseLabel3.setIcon(new ImageIcon(horseImage3.getImage().getScaledInstance(80, 60, Image.SCALE_SMOOTH)));
        horseLabel4.setIcon(new ImageIcon(horseImage4.getImage().getScaledInstance(80, 60, Image.SCALE_SMOOTH)));
        horseLabel5.setIcon(new ImageIcon(horseImage5.getImage().getScaledInstance(80, 60, Image.SCALE_SMOOTH)));
        horseLabel6.setIcon(new ImageIcon(horseImage6.getImage().getScaledInstance(80, 60, Image.SCALE_SMOOTH)));
        horseLabel7.setIcon(new ImageIcon(horseImage7.getImage().getScaledInstance(80, 60, Image.SCALE_SMOOTH))); 
        horseLabel8.setIcon(new ImageIcon(horseImage8.getImage().getScaledInstance(80, 60, Image.SCALE_SMOOTH)));
        horseLabel9.setIcon(new ImageIcon(horseImage9.getImage().getScaledInstance(80, 60, Image.SCALE_SMOOTH)));
        horseLabel10.setIcon(new ImageIcon(horseImage10.getImage().getScaledInstance(80, 60, Image.SCALE_SMOOTH)));

        horseLabel1.setBounds(50, 50, 200, 50);
        speedLabel1.setBounds(20, 100, 200, 50);
        confidenceLabel1.setBounds(20, 150, 200, 50);

        horseLabel2.setBounds(250, 50, 200, 50);
        speedLabel2.setBounds(240, 100, 200, 50);
        confidenceLabel2.setBounds(240, 150, 200, 50);

        horseLabel3.setBounds(500, 50, 200, 50);
        speedLabel3.setBounds(460, 100, 200, 50);
        confidenceLabel3.setBounds(460, 150, 200, 50);

        horseLabel4.setBounds(750, 50, 200, 50);
        speedLabel4.setBounds(680, 100, 200, 50);
        confidenceLabel4.setBounds(680, 150, 200, 50);

        horseLabel5.setBounds(950, 50, 200, 50);
        speedLabel5.setBounds(900, 100, 200, 50);
        confidenceLabel5.setBounds(900, 150, 200, 50);

        horseLabel6.setBounds(50, 300, 200, 50);
        speedLabel6.setBounds(20, 350, 200, 50);
        confidenceLabel6.setBounds(20, 400, 200, 50);

        horseLabel7.setBounds(250, 300, 200, 50);
        speedLabel7.setBounds(240, 350, 200, 50);
        confidenceLabel7.setBounds(240, 400, 200, 50);

        horseLabel8.setBounds(500, 300, 200, 50);
        speedLabel8.setBounds(460, 350, 200, 50);
        confidenceLabel8.setBounds(460, 400, 200, 50);

        
        horseLabel9.setBounds(750, 300, 200, 50);
        speedLabel9.setBounds(680, 350, 200, 50);
        confidenceLabel9.setBounds(680, 400, 200, 50);

        horseLabel10.setBounds(950, 300, 200, 50);
        speedLabel10.setBounds(900, 350, 200, 50);
        confidenceLabel10.setBounds(900, 400, 200, 50);


        selectedHorseLabel1.setBounds(5, 550, 400, 50); 
        selectedHorseLabel2.setBounds(150, 550, 400, 50); 
        selectedHorseLabel3.setBounds(400, 550, 400, 50); 
        selectedHorseLabel4.setBounds(650, 550, 400, 50); 
        selectedHorseLabel5.setBounds(900, 550, 400, 50); 

       
        frame.add(horseLabel1);
        frame.add(horseLabel2);
        frame.add(horseLabel3);
        frame.add(horseLabel4);
        frame.add(horseLabel5);
        frame.add(horseLabel6);
        frame.add(horseLabel7);
        frame.add(horseLabel8);
        frame.add(horseLabel9);
        frame.add(horseLabel10);

        frame.add(confidenceLabel1);
        frame.add(confidenceLabel2);
        frame.add(confidenceLabel3);
        frame.add(confidenceLabel4);
        frame.add(confidenceLabel5);
        frame.add(confidenceLabel6);
        frame.add(confidenceLabel7);
        frame.add(confidenceLabel8);
        frame.add(confidenceLabel9);
        frame.add(confidenceLabel10);


        frame.add(speedLabel1);
        frame.add(speedLabel2);
        frame.add(speedLabel3);
        frame.add(speedLabel4);
        frame.add(speedLabel5);
        frame.add(speedLabel6);
        frame.add(speedLabel7);
        frame.add(speedLabel8);
        frame.add(speedLabel9);
        frame.add(speedLabel10);


        frame.add(selectedHorseLabel1);
        frame.add(selectedHorseLabel2);
        frame.add(selectedHorseLabel3);
        frame.add(selectedHorseLabel4);
        frame.add(selectedHorseLabel5);


        frame.add(selectLabel);
        frame.add(backButton);
        frame.add(nextButton);
        frame.add(randomButton);

        backButton.setBounds(20, 500, 100, 30);
        nextButton.setBounds(580, 500, 100, 30);
        randomButton.setBounds(300, 500, 200, 30);

        backButton.addActionListener(this);
        nextButton.addActionListener(this);
        randomButton.addActionListener(this);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        if (e.getSource() == backButton) {
            frame.dispose();
            new RaceGUI();

        } else if (e.getSource() == randomButton) {

            Random random = new Random();
            Set<Integer> generatedNumbers = new HashSet<>();

            while (selectedHorses.size() < 5) {
                int randomNumber = random.nextInt(10) + 1;
                if (!generatedNumbers.contains(randomNumber)) {
                    generatedNumbers.add(randomNumber);
                    if (randomNumber == 1) {
                        selectedHorses.add(new Horse2("Misr", horseImage1, 0.89));
                    } else if (randomNumber == 2) {
                        selectedHorses.add(new Horse2("Elizzy", horseImage2, 0.46));
                    } else if (randomNumber == 3) {
                        selectedHorses.add(new Horse2("Thee", horseImage3, 0.15));
                    }else if (randomNumber == 4) {
                        selectedHorses.add(new Horse2("Lucky", horseImage3, 0.24));
                    }else if (randomNumber == 5) {
                        selectedHorses.add(new Horse2("Jenny", horseImage3, 0.33));
                    }else if (randomNumber == 6) {
                        selectedHorses.add(new Horse2("LeBron", horseImage3, 0.35));
                    }else if (randomNumber == 7) {
                        selectedHorses.add(new Horse2("DelRey", horseImage3, 0.99));
                    }else if (randomNumber == 8) {
                        selectedHorses.add(new Horse2("Nemo", horseImage3, 0.02));
                    }else if (randomNumber == 9) {
                        selectedHorses.add(new Horse2("Orange", horseImage3, 0.55));
                    }else if (randomNumber == 10) {
                        selectedHorses.add(new Horse2("Mamosa", horseImage3, 0.69));
                    }
                }

            }
            // Store selected horses for later use
            selectedHorse1 = selectedHorses.get(0);
            selectedHorseLabel1.setText(selectedHorse1.getName() + " was selected ");

            selectedHorse2 = selectedHorses.get(1);
            selectedHorseLabel2.setText(selectedHorse2.getName() + " was selected ");

            selectedHorse3 = selectedHorses.get(2);
            selectedHorseLabel3.setText(selectedHorse3.getName() + " was selected ");

            selectedHorse4 = selectedHorses.get(3);
            selectedHorseLabel4.setText(selectedHorse4.getName() + " was selected ");

            selectedHorse5 = selectedHorses.get(4);
            selectedHorseLabel5.setText(selectedHorse5.getName() + " was selected ");

        } else if (e.getSource() == nextButton) {
            frame.dispose();
            new randomRaceGUI();
        }

    }
    
}
