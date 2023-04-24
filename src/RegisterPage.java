import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegisterPage extends JPanel {
    // create labels, text fields, and button
    JLabel nameLabel,usernameLabel, passwordLabel, emailLabel, phonenoLabel, gpaLabel, addressLabel, gradeLabel,parentsnameLabel;
    JTextField nameField,usernameField, emailField, phonenoField, gpaField, addressField,parentsnameField;
    JPasswordField passwordField;
    JComboBox<String> gradeBox;
    JButton registerButton;
    // constructor
    public RegisterPage() {
        // set up the panel
        setLayout(new GridLayout(11, 2));

        // create labels and text fields for each field
        nameLabel = new JLabel("Name: ");
        nameField = new JTextField();
        usernameLabel=new JLabel("Username");
        usernameField=new JTextField();
        passwordLabel = new JLabel("Password: ");
        passwordField = new JPasswordField();
        emailLabel = new JLabel("Email: ");
        emailField = new JTextField();
        phonenoLabel = new JLabel("Phone no: ");
        phonenoField = new JTextField();
        addressLabel = new JLabel("Address: ");
        addressField = new JTextField();
        parentsnameLabel = new JLabel("Parents Name: ");
        parentsnameField = new JTextField();
        gradeLabel = new JLabel("Grade: ");
        String[] grades = {"1", "2", "3", "4","5","6","7","8","9","10"};
        gradeBox = new JComboBox<>(grades);
        registerButton = new JButton("Register");

        // add components to the panel
        add(nameLabel);
        add(nameField);
        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(emailLabel);
        add(emailField);
        add(phonenoLabel);
        add(phonenoField);
        add(addressLabel);
        add(addressField);
        add(parentsnameLabel);
        add(parentsnameField);
        add(gradeLabel);
        add(gradeBox);
        add(new JLabel(""));
        add(registerButton);
        this.setBackground(new Color(152,175,199));
        registerButton.setForeground(Color.WHITE);
        registerButton.setBackground(new Color(54, 75, 101));
    }
    public JTextField getNameField(){
        return nameField;
    }
    public JTextField getUsernameField(){
        return usernameField;
    }
    public JTextField getAddressField(){
        return addressField;
    }
    public  JTextField getEmailField(){
        return emailField;
    }
    public  JTextField getPhonenoField(){
        return phonenoField;
    }
    public JTextField getGpaField(){
        return gpaField;
    }
    public JPasswordField getPasswordField(){
        return passwordField;
    }
    public JTextField getParentsnameField(){
        return parentsnameField;
    }
    public JButton getRegisterButton(){
        return registerButton;
    }
    public JComboBox<String> getGradeBox() {
        return gradeBox;
    }
}


