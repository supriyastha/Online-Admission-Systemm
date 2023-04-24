
import javax.swing.*;
import java.awt.*;
public class LogIn extends JPanel {
    private JPasswordField passwordField;
    private JTextField textField;
    private JButton loginbutton, button;
    private JLabel label_Username,label_Password,title;
    public LogIn(){
        Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
        int width =(int) screensize.getWidth();
        int height =(int) screensize.getHeight();
        this.setLayout(new BorderLayout());

        JPanel panel=new JPanel();

        title=new JLabel("Online Admission System");
        title.setBounds(220,60,500,40);
        title.setFont(new Font("Serif", Font.BOLD,20));
        title.setForeground(Color.white);
        panel.setLayout(null);
        panel.setBackground(new Color(54, 75, 101));

        label_Username=new JLabel("Username :");
        label_Username.setBounds(100,150,200,40);
        label_Username.setFont(new Font("Serif", Font.BOLD,20));
        label_Username.setForeground(Color.white);

        textField=new JTextField();
        textField.setBounds(210,150,250,40);
        textField.setFont(new Font("Serif", Font.BOLD,20));
        textField.setForeground(Color.black);

        label_Password=new JLabel("Password :");
        label_Password.setBounds(100,250,200,40);
        label_Password.setFont(new Font("Serif",Font.BOLD,20));
        label_Password.setForeground(Color.white);

        passwordField=new JPasswordField();
        passwordField.setBounds(210,250,250,40);
        passwordField.setFont(new Font("Serif", Font.BOLD,20));
        passwordField.setForeground(Color.black);


        loginbutton=new JButton("Login");
        loginbutton.setBounds(220,350,100,30);
        loginbutton.setFont(new Font("Arial", Font.BOLD,20));
        loginbutton.setForeground(Color.black);

        button=new JButton("Register Now");
        button.setBounds(350,350,150,30);
        button.setFont(new Font("Arial", Font.BOLD,15));
        button.setForeground(Color.black);

        panel.add(title);
        panel.add(label_Username);
        panel.add(textField);
        panel.add(label_Password);
        panel.add(passwordField);
        panel.add(loginbutton);
        panel.add(button);

        this.add(panel,BorderLayout.CENTER);
        this.setVisible(true);
    }
    public JTextField getTextField(){
        return textField;
    }
    public JPasswordField getPasswordField(){
        return passwordField;
    }
    public JButton getLoginbutton(){
        return loginbutton;
    }
    public JButton getButton(){
        return button;
    }

}

