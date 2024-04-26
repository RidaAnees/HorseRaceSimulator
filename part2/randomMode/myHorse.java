package randomMode;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class myHorse implements ActionListener {
    public Horse2 myHorse; // Store the selected horse

    JFrame frame = new JFrame("HORSE RACE");
    JLabel selectLabel = new JLabel("SELECT A HORSE FOR YOURSELF : ");
    JLabel horseLabel1 = new JLabel("Arabian horse, Dalie");
    JLabel horseLabel2 = new JLabel("Mustang, Maya");
    JLabel horseLabel3 = new JLabel("Appaloosa, Luna");

    JLabel speedLabel1 = new JLabel("SPEED:50Km/hr", SwingConstants.CENTER);
    JLabel speedLabel2 = new JLabel("SPEED:55Km/hr", SwingConstants.CENTER);
    JLabel speedLabel3 = new JLabel("SPEED:20Km/hr", SwingConstants.CENTER);

    JLabel confidenceLabel1 = new JLabel("Confidence: 0.9", SwingConstants.CENTER);
    JLabel confidenceLabel2 = new JLabel("Confidence: 0.4", SwingConstants.CENTER);
    JLabel confidenceLabel3 = new JLabel("Confidence: 0.5", SwingConstants.CENTER);

    JButton backButton = new JButton("BACK");
    JButton nextButton = new JButton("NEXT");

    JRadioButton horse1Button = new JRadioButton("Horse no:1");
    JRadioButton horse2Button = new JRadioButton("Horse no:2");
    JRadioButton horse3Button = new JRadioButton("Horse no:3");
    ButtonGroup group = new ButtonGroup();

    ImageIcon horseImage1 = new ImageIcon("part2\\randomMode\\pics\\Horse1.jpg");
    ImageIcon horseImage2 = new ImageIcon("part2\\randomMode\\pics\\Horse2.jpg");
    ImageIcon horseImage3 = new ImageIcon("part2\\randomMode\\pics\\Horse3.jpg");

    public myHorse() {
        frame.setLayout(null);
        frame.setBounds(10, 10, 1000, 600);

        selectLabel.setBounds(260, 20, 200, 50);

        horseLabel1.setBounds(20, 100, 200, 50);
        horseLabel2.setBounds(270, 100, 200, 50);
        horseLabel3.setBounds(520, 100, 200, 50);

        speedLabel1.setBounds(20, 150, 200, 50);
        speedLabel2.setBounds(270, 150, 200, 50);
        speedLabel3.setBounds(520, 150, 200, 50);

        confidenceLabel1.setBounds(20, 200, 200, 50);
        confidenceLabel2.setBounds(270, 200, 200, 50);
        confidenceLabel3.setBounds(520, 200, 200, 50);

        horse1Button.setBounds(20, 300, 200, 50);
        horse2Button.setBounds(270, 300, 200, 50);
        horse3Button.setBounds(520, 300, 200, 50);

        backButton.setBounds(20, 500, 100, 30);
        nextButton.setBounds(580, 500, 100, 30);

        horseLabel1.setIcon(new ImageIcon(horseImage1.getImage().getScaledInstance(80, 60, Image.SCALE_SMOOTH)));
        horseLabel2.setIcon(new ImageIcon(horseImage2.getImage().getScaledInstance(80, 60, Image.SCALE_SMOOTH)));
        horseLabel3.setIcon(new ImageIcon(horseImage3.getImage().getScaledInstance(80, 60, Image.SCALE_SMOOTH)));

        frame.add(selectLabel);
        frame.add(horseLabel1);
        frame.add(horseLabel2);
        frame.add(horseLabel3);
        frame.add(speedLabel1);
        frame.add(speedLabel2);
        frame.add(speedLabel3);
        frame.add(backButton);
        frame.add(nextButton);
        frame.add(horse1Button);
        frame.add(horse2Button);
        frame.add(horse3Button);
        frame.add(confidenceLabel1);
        frame.add(confidenceLabel2);
        frame.add(confidenceLabel3);

        group.add(horse1Button);
        group.add(horse2Button);
        group.add(horse3Button);

        horse1Button.addActionListener(this);
        horse2Button.addActionListener(this);
        horse3Button.addActionListener(this);
        backButton.addActionListener(this);
        nextButton.addActionListener(this);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            frame.dispose();
            new randomRaceGUI();
        } else if (e.getSource() == nextButton) {
            frame.dispose();
            // Pass the selected horse to the opponentGUI constructor
            new opponentGUI();
        } else {
            if (horse1Button.isSelected()) {
                myHorse = new Horse2("Dalie", horseImage1, 0.9);
            } else if (horse2Button.isSelected()) {
                myHorse = new Horse2("Maya", horseImage2, 0.4);
            } else if (horse3Button.isSelected()) {
                myHorse = new Horse2("Luna", horseImage3, 0.5);
            }
        }
    }
}

