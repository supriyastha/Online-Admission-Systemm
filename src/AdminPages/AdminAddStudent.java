package AdminPages;

import javax.swing.*;
import java.awt.*;

public class AdminAddStudent extends JPanel {
    private JLabel nameLabel, usernameLabel, passwordLabel, phoneLabel, emailLabel,parentLabel;
    private JTextField nameField, usernameField, passwordField, phoneField, emailField, parentField;
    private JButton submitButton;
    public  AdminAddStudent() {
        this.setLayout(new GridLayout(9, 2, 2,10));
        this.setBackground(new Color(152,175,199));

        nameLabel = new JLabel("Name:");
        add(nameLabel);
        nameField = new JTextField();
        add(nameField);

        usernameLabel = new JLabel("Username:");
        add(usernameLabel);
        usernameField = new JTextField();
        add(usernameField);

        passwordLabel = new JLabel("Password:");
        add(passwordLabel);
        passwordField = new JPasswordField();
        add(passwordField);

        phoneLabel = new JLabel("Phone Number:");
        add(phoneLabel);
        phoneField = new JTextField();
        add(phoneField);

        emailLabel = new JLabel("Email:");
        add(emailLabel);
        emailField = new JTextField();
        add(emailField);

        parentLabel=new JLabel("Parents Name:");
        add(parentLabel);
        parentField=new JTextField();
        add(parentField);
        add(new JLabel(""));

        submitButton = new JButton("Submit");
        add(submitButton);

        // Create a font with desired styles
        Font labelFont = new Font("Arial", Font.BOLD, 14);
        Font textFieldFont = new Font("Arial", Font.PLAIN, 14);
        Font buttonFont = new Font("Arial", Font.BOLD, 16);

        // Set the font for the labels
        nameLabel.setFont(labelFont);
        usernameLabel.setFont(labelFont);
        passwordLabel.setFont(labelFont);
        phoneLabel.setFont(labelFont);
        emailLabel.setFont(labelFont);
        parentField.setFont(labelFont);

        // Set the font for the text fields
        nameField.setFont(textFieldFont);
        usernameField.setFont(textFieldFont);
        passwordField.setFont(textFieldFont);
        phoneField.setFont(textFieldFont);
        emailField.setFont(textFieldFont);
        parentField.setFont(textFieldFont);

        // Set the font for the submit button
        submitButton.setFont(buttonFont);

        // Set foreground color for labels
        nameLabel.setForeground(Color.black);
        usernameLabel.setForeground(Color.black);
        passwordLabel.setForeground(Color.black);
        phoneLabel.setForeground(Color.black);
        emailLabel.setForeground(Color.black);
        parentLabel.setForeground(Color.black);

        // Set foreground color for text fields
        nameField.setForeground(Color.BLACK);
        usernameField.setForeground(Color.BLACK);
        passwordField.setForeground(Color.BLACK);
        phoneField.setForeground(Color.BLACK);
        emailField.setForeground(Color.BLACK);
        parentField.setForeground(Color.BLACK);

        // Set background color for text fields
        nameField.setBackground(Color.WHITE);
        usernameField.setBackground(Color.WHITE);
        passwordField.setBackground(Color.WHITE);
        phoneField.setBackground(Color.WHITE);
        emailField.setBackground(Color.WHITE);
        parentField.setBackground(Color.WHITE);

        // Set foreground and background colors for the submit button
        submitButton.setForeground(Color.WHITE);
        submitButton.setBackground(new Color(54, 75, 101));
    }
    public JTextField getNameField(){
        return nameField;
    }
    public JTextField getUsernameField(){
        return usernameField;
    }
    public JTextField getPasswordField(){
        return passwordField;
    }
    public JTextField getPhoneField(){
        return phoneField;
    }
    public JTextField getEmailField(){
        return emailField;
    }
    public JTextField getParentField(){
        return parentField;
    }
    public JButton getSubmitButton(){
        return submitButton;
    }
}


