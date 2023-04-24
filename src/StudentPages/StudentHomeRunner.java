package StudentPages;

import javax.swing.*;
import java.awt.*;
public class StudentHomeRunner extends JPanel {
    public StudentHomeRunner() {
        JLabel label=new JLabel("Welcome to the Student Portal." );
        Font labelFont = new Font("Serif", Font.BOLD, 40);
        label.setFont(labelFont);
        setBackground(new Color(152,175,199));
        this.add(label);
    }
}
