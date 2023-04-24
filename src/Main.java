import AdminPages.*;
import Frames.MyFrame;
import Modules.Student;
import StudentPages.StudentHomeRunner;
import StudentPages.StudentNavigationBar;
import StudentPages.StudentViewStudent;
import dbConnect.DoConnection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Main {
    static Connection conn;
    public static void main(String[] args) {
        MyFrame frame = new MyFrame();
        frame.setLayout(new BorderLayout());
        AdminNavigationBar adminNavbar=new AdminNavigationBar();
        StudentNavigationBar studentNavbar=new StudentNavigationBar();

        //these are the objects of admin panel
        AdminHomeRunner adminHome=new AdminHomeRunner();
        AdminAddStudent addStudent=new AdminAddStudent();
        AdminViewStudent viewStudent=new AdminViewStudent();

        //these are the objects of student panel
        StudentHomeRunner studentHome=new StudentHomeRunner();
        StudentViewStudent studentview=new StudentViewStudent();

        //these are the menu item obtained from the adminavigationbar
        JMenu ahome = adminNavbar.getHome();
        JMenu alogout = adminNavbar.getLogout();
         JMenuItem aaddStudent = adminNavbar.getAddStudent();
        JMenuItem aviewStudent = adminNavbar.getViewStudent();

        //these are the menu items obtained from the studentnavigation bar
        JMenu shome = studentNavbar.getHome();
        JMenu slogout = studentNavbar.getLogout();
        JMenuItem sviewstudent = studentNavbar.getViewStudent();

        //these are the detail obtained from the adminhomerunner
        JLabel anameDetail = adminHome.getNameDetail();
        JLabel auserDetail = adminHome.getUserDetail();
        JLabel apositionDetail = adminHome.getPositionDetail();
        JLabel aphoneDetail = adminHome.getPhoneDetail();
        JLabel aemailDetail = adminHome.getEmailDetail();

        //these are the detail obtained from the studentviewstudent
        JLabel snameDetail = studentview.getNameDetail();
        JLabel suserDetail = studentview.getUserDetail();
        JLabel spositionDetail = studentview.getPositionDetail();
        JLabel sphoneDetail = studentview.getPhoneDetail();
        JLabel semailDetail = studentview.getEmailDetail();
        JLabel sstatusDetail= studentview.getStatusDetail();

        //connection here
        DoConnection connect = new DoConnection();
        conn = connect.getConnection();

        //login components
        LogIn l = new LogIn();
        JTextField login_username = l.getTextField();
        JPasswordField login_password = l.getPasswordField();
        JButton btn=l.getLoginbutton();
        frame.add(l);

        //actionlistener on clicking login button
        Connection finalConn = conn;
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Student student;
                try{
                    String sql="SELECT * FROM user";
                    Statement stmt= finalConn.createStatement();
                    ResultSet result= stmt.executeQuery(sql);
                    int ID_value=0;
                    String user_value = null;
                    String name_value=null;
                    String pass_value=null;
                    String usertype = null;
                    String phone_value = null;
                    String email_value=null;
                    String status_value=null;
                    boolean foundMatch = false;
                    while (result.next()) {
                        ID_value = Integer.parseInt(result.getString("ID"));
                        name_value = result.getString("Name");
                        user_value = result.getString("Username");
                        usertype = result.getString("usertype");
                        pass_value = result.getString("Password");
                        phone_value = result.getString("PhoneNo");
                        email_value=result.getString("Email");
                        status_value= result.getString("Status");
                        String password = new String(login_password.getPassword());
                        String username = login_username.getText();
                        if (Objects.equals(user_value, username) && Objects.equals(pass_value, password) && Objects.equals(usertype, "admin")) {
                            login_username.setText("");
                            login_password.setText("");
                            anameDetail.setText(name_value);
                            auserDetail.setText(user_value);
                            apositionDetail.setText(usertype);
                            aphoneDetail.setText(phone_value);
                            aemailDetail.setText(email_value);
                            frame.getContentPane().removeAll();
                            frame.getContentPane().add(adminNavbar, BorderLayout.NORTH);
                            frame.getContentPane().add(adminHome, BorderLayout.CENTER);
                            frame.getContentPane().revalidate();
                            frame.getContentPane().repaint();
                            foundMatch = true;
                        }
                        else if (Objects.equals(user_value, username) && Objects.equals(pass_value, password) && Objects.equals(usertype, "student")) {
                            login_username.setText("");
                            login_password.setText("");
                            student = new Student(ID_value, name_value, user_value, pass_value, phone_value, email_value,status_value);
                            snameDetail.setText(student.getName());
                            suserDetail.setText(student.getUsername());
                            spositionDetail.setText(usertype);
                            sphoneDetail.setText(student.getPhoneNo());
                            semailDetail.setText(student.getEmail());
                            sstatusDetail.setText(student.getStatus());
                            frame.getContentPane().removeAll();
                            frame.getContentPane().add(studentNavbar, BorderLayout.NORTH);
                            frame.getContentPane().add(studentHome, BorderLayout.CENTER);
                            frame.getContentPane().revalidate();
                            frame.getContentPane().repaint();
                            foundMatch = true;
                        }
                    }
                    if (!foundMatch) {
                        login_username.setText("");
                        login_password.setText("");
                        JOptionPane.showMessageDialog(frame, "Username or password incorrect", "Error Message", JOptionPane.ERROR_MESSAGE);
                    }
                    stmt.close();
                    result.close();

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }}
        });

        //register  btn components
        RegisterPage register = new RegisterPage();
        JTextField register_username= register.getUsernameField();
        JTextField register_email= register.getEmailField();
        JTextField register_address =register.getAddressField();
        JTextField register_phoneno=register.getPhonenoField();
        JTextField register_parents=register.getParentsnameField();
        JTextField register_name=register.getNameField();
        JPasswordField register_password=register.getPasswordField();
        JButton register_btn=register.getRegisterButton();
        JComboBox<String> register_grade=register.getGradeBox();

        // event on clicking register button
        JButton apply_btn=l.getButton();
        apply_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add(register);
                frame.getContentPane().revalidate();
                frame.getContentPane().repaint();
            }
        });

        //register button work
        register_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = register_username.getText();
                String email = register_email.getText();
                String address = register_address.getText();
                String phoneNo = register_phoneno.getText();
                String name = register_name.getText();
                String parents = register_parents.getText();
                // Regular expression pattern for email validation
                String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$";

                // Create a Pattern object and compile the regular expression
                Pattern pattern = Pattern.compile(emailRegex);

                // Match the input string with the regular expression pattern
                Matcher matcher = pattern.matcher(email);

                //   float gpa= Float.parseFloat(register_gpa.getText());

                String password = String.valueOf(register_password.getPassword());
                int grade = Integer.parseInt((String) register_grade.getSelectedItem());
                if(username.equals("") || email.equals("") || address.equals("") || phoneNo.equals("") ||  name.equals("") || password.equals("") || String.valueOf(grade).equals("") ){
                    JOptionPane.showMessageDialog(frame, "Content cannot be empty.");
                }else {
                    if (matcher.matches())
                        try {
                            String SQLRegisterInsertUser = "INSERT INTO user(Name, Address, Email, Grade, PhoneNo, Username, Password,usertype) VALUES (?,?,?,?,?,?,?,?)";
                            Connection finalConn = conn;

                            //                        String SQLRegisterInsertUser = "INSERT INTO users(Name,Address,Email,Grade,PhoneNo,Username,Password) VALUES(?,?,?,?,?,?,?,?)";
                            //                        String SQLRegisterInsertStudent = "INSERT INTO student(Name,Address,Email,Grade,PhoneNo,Username) VALUES(?,?,?,?,?,?,?)";
                            PreparedStatement statementInsertUser  = finalConn.prepareStatement(SQLRegisterInsertUser);
                            statementInsertUser.setString(1,name);
                            statementInsertUser.setString(2,address);
                            statementInsertUser.setString(3,email);
                            statementInsertUser.setInt(4,grade);
                            //    statementInsertUser.setFloat(5, gpa);
                            statementInsertUser.setString(5,phoneNo);
                            statementInsertUser.setString(6,username);
                            statementInsertUser.setString(7,password);
                            statementInsertUser.setString(8,"student");
                            System.out.println(password);
                            int rowsAffected1 = statementInsertUser.executeUpdate();
                            String SQLRegisterInsertStudent = "INSERT INTO student(Name, Address, Email, Grade, PhoneNo, Username,ParentsName) VALUES (?,?,?,?,?,?,?)";

                            PreparedStatement statementInsertStudent = finalConn.prepareStatement(SQLRegisterInsertStudent);
                            statementInsertStudent.setString(1,name);
                            statementInsertStudent.setString(2,address);
                            statementInsertStudent.setString(3,email);
                            statementInsertStudent.setInt(4, grade);
                            // statementInsertStudent.setFloat(5, gpa);
                            statementInsertStudent.setString(5,phoneNo);
                            statementInsertStudent.setString(6,username);
                            statementInsertStudent.setString(7,parents);
                            int rowsAffected2 = statementInsertStudent.executeUpdate();

                            if (rowsAffected1 > 0 || rowsAffected2 > 0) {
                                JOptionPane.showMessageDialog(frame, "Inserted successfully");
                                frame.getContentPane().removeAll();
                                frame.getContentPane().add(l);
                                frame.getContentPane().revalidate();
                                frame.getContentPane().repaint();
                            } else {
                                JOptionPane.showMessageDialog(frame, "cannot be inserted");
                            }

                        } catch (SQLException error) {
                            System.out.println(error);
                        }
                }

            }
        });
        //event on clicking home in the admin section
        ahome.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add(adminNavbar, BorderLayout.NORTH);
                frame.getContentPane().add(adminHome, BorderLayout.CENTER);
                frame.getContentPane().revalidate();
                frame.getContentPane().repaint();
            }
        });

        //event on clicking add student in admin section
        aaddStudent.addActionListener(e -> {
            frame.getContentPane().removeAll();
            frame.getContentPane().add(adminNavbar, BorderLayout.NORTH);
            frame.getContentPane().add(addStudent, BorderLayout.CENTER);
            frame.getContentPane().revalidate();
            frame.getContentPane().repaint();
        });

        //event on clicking view student in admin section
        aviewStudent.addActionListener(e -> {
            frame.getContentPane().removeAll();
            frame.getContentPane().add(adminNavbar, BorderLayout.NORTH);
            frame.getContentPane().add(viewStudent, BorderLayout.CENTER);
            frame.getContentPane().revalidate();
            frame.getContentPane().repaint();
        });

        //event on clicking the logout of adminSection
        alogout.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add(l);
                frame.getContentPane().revalidate();
                frame.getContentPane().repaint();
            }
        });

        //event on clicking the home of student Section
        shome.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add(studentNavbar, BorderLayout.NORTH);
                frame.getContentPane().add(studentHome, BorderLayout.CENTER);
                frame.getContentPane().revalidate();
                frame.getContentPane().repaint();
            }
        });

        //event on clicking view student in student section
        sviewstudent.addActionListener(e -> {
            frame.getContentPane().removeAll();
            frame.getContentPane().add(studentNavbar, BorderLayout.NORTH);
            frame.getContentPane().add(studentview, BorderLayout.CENTER);
            frame.getContentPane().revalidate();
            frame.getContentPane().repaint();
        });

        //event on clicking the logout of studentSection
        slogout.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.getContentPane().removeAll();
                frame.getContentPane().add(l);
                frame.getContentPane().revalidate();
                frame.getContentPane().repaint();
            }
        });

        //submit button of addstudent
        JButton assubmitbutton = addStudent.getSubmitButton();
        JTextField asnameField = addStudent.getNameField();
        JTextField asusernameField = addStudent.getUsernameField();
        JTextField aspasswordField = addStudent.getPasswordField();
        JTextField asPhoneField = addStudent.getPhoneField();
        JTextField asemailField = addStudent.getEmailField();
        JTextField parentField=addStudent.getParentField();
        assubmitbutton.addActionListener(e -> {
            String name = asnameField.getText();
            String username = asusernameField.getText();
            String password = aspasswordField.getText();
            String phoneNo = asPhoneField.getText();
            String email = asemailField.getText();
            String parentname =  parentField.getText();
            PreparedStatement stmt = null;
            PreparedStatement stmt1 = null;
            PreparedStatement stmt2 = null;
            // Regular expression pattern for email validation
            String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$";

            // Create a Pattern object and compile the regular expression
            Pattern pattern = Pattern.compile(emailRegex);

            // Match the input string with the regular expression pattern
            Matcher matcher = pattern.matcher(email);

            if (name.equals("") || username.equals("") || password.equals("") || phoneNo.equals("") || email.equals("")|| parentname.equals("") ) {

                JOptionPane.showMessageDialog(frame, "Fields cannot be empty.", "Empty", JOptionPane.WARNING_MESSAGE);
            } else {
                if (matcher.matches()) {
                    try {
                        conn = connect.getConnection();
                        stmt = conn.prepareStatement("INSERT INTO user(Username,Password,Name,PhoneNo,Email,usertype) VALUES(?,?,?,?,?,?) ", Statement.RETURN_GENERATED_KEYS);
                        stmt.setString(1, username);
                        stmt.setString(2, password);
                        stmt.setString(3, name);
                        stmt.setString(4, phoneNo);
                        stmt.setString(5, email);
                        stmt.setString(6,"student");
                        stmt.executeUpdate();

                        stmt1 = conn.prepareStatement("INSERT INTO student(Username,Name,PhoneNo,Email,ParentsName) VALUES(?,?,?,?,?)");
                        stmt1.setString(1, username);
                        stmt1.setString(2, name);
                        stmt1.setString(3, phoneNo);
                        stmt1.setString(4, email);
                        stmt1.setString(5,parentname);
                        stmt1.executeUpdate();

                        JOptionPane.showMessageDialog(frame, "Student inserted into the database", "Insertion Successful.", JOptionPane.INFORMATION_MESSAGE);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    } finally {
                        if (stmt != null) {
                            try {
                                stmt.close();
                            } catch (SQLException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Not a valid email.", "Not Valid", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        //admin view student
        DefaultTableModel tableModelA = viewStudent.getTableModel();
        JTable tableA = viewStudent.getTable();
        JButton removeBtnS = viewStudent.getRemoveBtn();
        JButton verifyBtn =viewStudent.getVerifyBtn();
        Statement stmt = null;
        Statement stmt2 = null;
        try {
            conn = connect.getConnection();
            String sql = "SELECT * FROM student";
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            // Iterate over the result set and add the data to the table model
            while (rs.next()) {
                int ID = rs.getInt("ID");
                String name = rs.getString("Name");
                String username = rs.getString("Username");
                String phoneNo = rs.getString("PhoneNo");
                String email = rs.getString("Email");
                String parentName = rs.getString("ParentsName");
                String status=rs.getString("Status");
                String[] vals = {String.valueOf(ID), name, username, phoneNo, email, parentName,status};
                tableModelA.addRow(vals);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //remove button to delete the data
        removeBtnS.addActionListener(e -> {
            int selectedRow = tableA.getSelectedRow();
            if (selectedRow != -1) {
                String username = (String) tableA.getValueAt(selectedRow, 2);
                try {
                    conn = connect.getConnection();
                    String SQLDeleteUserTable = "DELETE FROM user WHERE username =? ";
                    String SQLDeleteStudentTable = "DELETE FROM student WHERE username=?";

                    PreparedStatement preparedStatementUserTable = conn.prepareStatement(SQLDeleteUserTable);
                    PreparedStatement preparedStatementStudentTable = conn.prepareStatement(SQLDeleteStudentTable);
                    preparedStatementUserTable.setString(1, username);
                    preparedStatementStudentTable.setString(1, username);
                    int rowsAffected1 = preparedStatementUserTable.executeUpdate();
                    int rowsAffected2 = preparedStatementStudentTable.executeUpdate();

                    if (rowsAffected1 > 0 || rowsAffected2 > 0) {
                        JOptionPane.showMessageDialog(frame, "Content deleted successfully.");
                        tableModelA.removeRow(selectedRow);

                    } else {
                        JOptionPane.showMessageDialog(frame, "Content not found for the given ID.");
                    }

                } catch (SQLException error) {
                    throw new RuntimeException(error);
                }
            } else {
                JOptionPane.showMessageDialog(frame, "No content selected");
            }
        });

        //verify button to verify student
        verifyBtn.addActionListener(e ->{
            int selectedRow=tableA.getSelectedRow();
            PreparedStatement p=null;
            PreparedStatement pp=null;
            conn = connect.getConnection();
            boolean accept_value = false;
            if(selectedRow != -1){
                accept_value = true;
                String username = (String) tableA.getValueAt(selectedRow, 2);
                String verifyUser = "update student set status=1 WHERE username =? ";
                String verifyUserr = "update user set status=1 WHERE username =? ";
                try {
                    p=conn.prepareStatement(verifyUser);
                    pp=conn.prepareStatement(verifyUserr);
                    p.setString(1,username);
                    pp.setString(1,username);
                    p.execute();
                    pp.execute();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                JOptionPane.showMessageDialog(frame,"User Accepted.");
            }else{
                JOptionPane.showMessageDialog(frame,"Not selected Data.");
            }
        } );
        frame.setVisible(true);
    }
}
