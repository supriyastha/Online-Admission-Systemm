package StudentPages;

import javax.swing.*;
import java.awt.*;

public class StudentNavigationBar extends JMenuBar {
    JMenuItem   viewStudent;
    JMenu home, logout;
    public StudentNavigationBar() {
        home = new JMenu("Home");
        JMenu forms = new JMenu("Form");
        logout = new JMenu("Log Out");
        viewStudent = new JMenuItem("View Form");

        forms.add(viewStudent);
        this.add(home);
        this.add(forms);
        this.add(logout);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBackground(new Color(54, 75, 101));
        home.setForeground(Color.white);
        forms.setForeground(Color.white);
        logout.setForeground(Color.white);
        setPreferredSize(new Dimension(screenSize.width,60));
    }
    public JMenuItem getViewStudent() {
        return viewStudent;
    }
    public JMenu getHome(){
        return home;
    }
    public JMenu getLogout(){
        return logout;
    }
}

