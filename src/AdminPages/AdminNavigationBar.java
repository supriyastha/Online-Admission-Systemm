package AdminPages;


import javax.swing.*;
import java.awt.*;

public class AdminNavigationBar extends JMenuBar {
    JMenuItem  addStudent, viewStudent;
    JMenu home, logout;
    public AdminNavigationBar() {
        home = new JMenu("Home");
        JMenu student = new JMenu("Student");
        logout = new JMenu("Log Out");

        addStudent = new JMenuItem("Add Student");
        viewStudent = new JMenuItem("View Student");
        student.add(addStudent);
        student.add(viewStudent);
        this.add(home);
        this.add(student);
        this.add(logout);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBackground(new Color(54, 75, 101));
        home.setForeground(Color.white);
        student.setForeground(Color.white);
        logout.setForeground(Color.white);
        setPreferredSize(new Dimension(screenSize.width,60));
    }
    public JMenuItem getAddStudent() {
        return addStudent;
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

