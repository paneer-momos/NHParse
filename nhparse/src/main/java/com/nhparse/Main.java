package com.nhparse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;

public class Main {
    public static void main(String[] args){
        try {
            UIManager.setLookAndFeel( new FlatDarkLaf() );
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize theme. Using fallback." );
        }
        EventQueue.invokeLater(() -> {
            JFrame startFrame = createStartScreen();
            startFrame.setVisible(true);
            startFrame.setSize(1000, 600);
        });
    }

    private static JFrame createStartScreen() {
        JFrame frame = new JFrame("Sentence Parser");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel(new BorderLayout());
       
        Color buttonBackgroundColor = new Color(178, 102, 255);
        Color buttonTextColor = Color.WHITE;

        JLabel titleLabel = new JLabel("UPLOAD NMEA AND HMSA LOG FILES");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 32));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
 
        JButton uploadNmeaButton = new JButton("NMEA");
        uploadNmeaButton.setPreferredSize(new Dimension(100, 40));
        uploadNmeaButton.setBackground(buttonBackgroundColor);
        uploadNmeaButton.setForeground(buttonTextColor);
        uploadNmeaButton.setFocusPainted(false); // Remove focus border
        uploadNmeaButton.setFont(new Font("Arial", Font.BOLD, 16));

        JButton uploadHmsaButton = new JButton("HMSA");
        uploadHmsaButton.setPreferredSize(new Dimension(100, 40));
        uploadHmsaButton.setBackground(buttonBackgroundColor);
        uploadHmsaButton.setForeground(buttonTextColor);
        uploadHmsaButton.setFocusPainted(false); // Remove focus border
        uploadHmsaButton.setFont(new Font("Arial", Font.BOLD, 16));
        
        buttonPanel.add(uploadNmeaButton);
        buttonPanel.add(uploadHmsaButton);
        

        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        uploadHmsaButton.addActionListener(e -> {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedHamsaFile = fileChooser.getSelectedFile();

            HamsaHandler(selectedHamsaFile);

            updateButtonOnUpload(uploadHmsaButton);
        }
    });

        uploadNmeaButton.addActionListener(e -> {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedNmeaFile = fileChooser.getSelectedFile();
            NmeaHandler(selectedNmeaFile);
            updateButtonOnUpload(uploadNmeaButton);
        }
    });

        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        return frame;
    }

    private static void updateButtonOnUpload(JButton button) {
        //button.setEnabled(false); 
        button.setBackground(Color.GREEN); 
        //button.setText(button.); 
    }
    

    private static void NmeaHandler(File selectedNmeaFile) {
        NmeaParse np = new NmeaParse(selectedNmeaFile);
    }

    private static void HamsaHandler(File selectedHamsaFile) {
        HmsaParse hp = new HmsaParse(selectedHamsaFile);
    }
}
