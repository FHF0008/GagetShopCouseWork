/*
 * GadgetShop Class
 * Represents a gadget shop GUI application for managing mobiles, MP3 players, and their functionalities.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GadgetShop {
    private ArrayList<Gadget> gadgets;
    private JFrame frame;
    private JTextArea displayArea;
    private JTextField modelField, priceField, weightField, sizeField, creditField, memoryField, phoneNumberField, durationField, downloadSizeField, displayNumberField;
    private JButton addMobileButton, addMP3Button, clearButton, displayAllButton, makeCallButton, downloadMusicButton;

    public GadgetShop() {
        gadgets = new ArrayList<>();
        frame = new JFrame("Gadget Shop");
        displayArea = new JTextArea(20, 30);
        JScrollPane scrollPane = new JScrollPane(displayArea);
        modelField = new JTextField(15);
        priceField = new JTextField(10);
        weightField = new JTextField(10);
        sizeField = new JTextField(15);
        creditField = new JTextField(10);
        memoryField = new JTextField(10);
        phoneNumberField = new JTextField(15);
        durationField = new JTextField(10);
        downloadSizeField = new JTextField(10);
        displayNumberField = new JTextField(10);
        addMobileButton = new JButton("Add Mobile");
        addMP3Button = new JButton("Add MP3");
        clearButton = new JButton("Clear");
        displayAllButton = new JButton("Display All");
        makeCallButton = new JButton("Make A Call");
        downloadMusicButton = new JButton("Download Music");

        frame.setLayout(new BorderLayout());
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(new JLabel("Model:"), gbc);
        gbc.gridx = 1;
        inputPanel.add(modelField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        inputPanel.add(new JLabel("Price (in pounds):"), gbc);
        gbc.gridx = 1;
        inputPanel.add(priceField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        inputPanel.add(new JLabel("Weight (in grams):"), gbc);
        gbc.gridx = 1;
        inputPanel.add(weightField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        inputPanel.add(new JLabel("Size:"), gbc);
        gbc.gridx = 1;
        inputPanel.add(sizeField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        inputPanel.add(new JLabel("Initial Credit (for mobile):"), gbc);
        gbc.gridx = 1;
        inputPanel.add(creditField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        inputPanel.add(new JLabel("Initial Available Memory (for MP3):"), gbc);
        gbc.gridx = 1;
        inputPanel.add(memoryField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        inputPanel.add(new JLabel("Phone Number:"), gbc);
        gbc.gridx = 1;
        inputPanel.add(phoneNumberField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        inputPanel.add(new JLabel("Duration (in minutes):"), gbc);
        gbc.gridx = 1;
        inputPanel.add(durationField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        inputPanel.add(new JLabel("Download Size (in MB):"), gbc);
        gbc.gridx = 1;
        inputPanel.add(downloadSizeField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        inputPanel.add(new JLabel("Display Number:"), gbc);
        gbc.gridx = 1;
        inputPanel.add(displayNumberField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        inputPanel.add(addMobileButton, gbc);
        gbc.gridx = 1;
        inputPanel.add(addMP3Button, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        inputPanel.add(clearButton, gbc);
        gbc.gridx = 1;
        inputPanel.add(displayAllButton, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        inputPanel.add(makeCallButton, gbc);
        gbc.gridx = 1;
        inputPanel.add(downloadMusicButton, gbc);

        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        addMobileButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        // Retrieve input values
        String model = getModelFieldText();
        double price = getPriceFieldNumber();
        int weight = getWeightFieldNumber();
        String size = getSizeFieldText();
        int credit = getCreditFieldNumber();

        // Check for valid input
        if (model.isEmpty() || price <= 0 || weight <= 0 || size.isEmpty() || credit <= 0) {
            JOptionPane.showMessageDialog(frame, "Please enter valid values for all fields.",
                    "Invalid Input", JOptionPane.ERROR_MESSAGE);
            return; // Exit function if input is invalid
        }

        // Add the mobile gadget
        gadgets.add(new Mobile(model, price, weight, size, credit));
        clearFields();

        // Provide feedback to the user
        JOptionPane.showMessageDialog(frame, "Mobile gadget added successfully!",
                "Success", JOptionPane.INFORMATION_MESSAGE);
    }
});

    addMP3Button.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        // Retrieve input values
        String model = getModelFieldText();
        double price = getPriceFieldNumber();
        int weight = getWeightFieldNumber();
        String size = getSizeFieldText();
        int memory = getMemoryFieldNumber();

        // Check for valid input
        if (model.isEmpty() || price <= 0 || weight <= 0 || size.isEmpty() || memory <= 0) {
            JOptionPane.showMessageDialog(frame, "Please enter valid values for all fields.",
                    "Invalid Input", JOptionPane.ERROR_MESSAGE);
            return; // Exit function if input is invalid
        }

        // Add the MP3 gadget
        gadgets.add(new MP3(model, price, weight, size, memory));
        clearFields();

        // Provide feedback to the user
        JOptionPane.showMessageDialog(frame, "MP3 gadget added successfully!",
                "Success", JOptionPane.INFORMATION_MESSAGE);
    }
});



        

        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });

        displayAllButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayAllGadgets();
            }
        });

        makeCallButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //int displayNumber = Integer.parseInt(phoneNumberField.getText());
                // if (displayNumber != -1) {
                    // Mobile mobile = (Mobile) gadgets.get(displayNumber);
                    // String phoneNumber = getPhoneNumberFieldText();
                    // int duration = getDurationFieldNumber();
                    // mobile.makeCall(phoneNumber, duration);
                    displayNumberField.setText(phoneNumberField.getText());
                    JOptionPane.showMessageDialog(frame, "Call was successfully.");
                    displayArea.append("Calling " + phoneNumberField.getText() + " for " + durationField.getText() + " minutes.");  
                   System.out.println("Call was successfully.");
                    System.out.println("Calling " + phoneNumberField.getText() + " for " + durationField.getText() + " minutes.");
                    phoneNumberField.setText("");
                    durationField.setText("");
                //}
            }
        });

        downloadMusicButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int displayNumber = getDisplayNumber();
                if (displayNumber != -1) {
                    MP3 mp3 = (MP3) gadgets.get(displayNumber);
                    int downloadSize = getDownloadSizeFieldNumber();
                    mp3.downloadMusic(downloadSize);
                }
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private String getModelFieldText() {
        return modelField.getText();
    }

    private double getPriceFieldNumber() {
        return Double.parseDouble(priceField.getText());
    }

    private int getWeightFieldNumber() {
        return Integer.parseInt(weightField.getText());
    }

    private String getSizeFieldText() {
        return sizeField.getText();
    }

    private int getCreditFieldNumber() {
        return Integer.parseInt(creditField.getText());
    }

    private int getMemoryFieldNumber() {
        return Integer.parseInt(memoryField.getText());
    }

    private String getPhoneNumberFieldText() {
        return phoneNumberField.getText();
    }

    private int getDurationFieldNumber() {
        return Integer.parseInt(durationField.getText());
    }

    private int getDownloadSizeFieldNumber() {
        return Integer.parseInt(downloadSizeField.getText());
    }

    private int getDisplayNumber() {
        int displayNumber = -1;
        try {
            displayNumber = Integer.parseInt(displayNumberField.getText());
            if (displayNumber < 0 || displayNumber >= gadgets.size()) {
                JOptionPane.showMessageDialog(frame, "Display number must be within the range of gadgets.",
                        "Invalid Input", JOptionPane.ERROR_MESSAGE);
                displayNumber = -1;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Please enter a valid display number.",
                    "Invalid Input", JOptionPane.ERROR_MESSAGE);
        }
        return displayNumber;
    }

    private void clearFields() {
        modelField.setText("");
        priceField.setText("");
        weightField.setText("");
        sizeField.setText("");
        creditField.setText("");
        memoryField.setText("");
        phoneNumberField.setText("");
        durationField.setText("");
        downloadSizeField.setText("");
        displayNumberField.setText("");
        displayArea.setText("");
    }

    private void displayAllGadgets() {
        for (int i = 0; i < gadgets.size(); i++) {
            displayArea.append("Gadget Number: " + (i + 1) + "\n" +  gadgets.get(i).display());           
            displayArea.append("\n");
            System.out.println("Gadget Number: " + (i + 1) + "\n" +  gadgets.get(i).display());
        }
    }

    public static void main(String[] args) {
        new GadgetShop();
    }
}
