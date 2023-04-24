package StudentPages;

import javax.swing.*;
import java.awt.*;
public class StudentViewStudent extends JPanel {
    JLabel nameDetail, userDetail, positionDetail, phoneDetail, emailDetail,statusDetail;
    public StudentViewStudent(){
        JPanel dashboardPanel = new JPanel();
        JPanel name = new JPanel();
        JPanel user = new JPanel();
        JPanel position = new JPanel();
        JPanel phone = new JPanel();
        JPanel email = new JPanel();
        JPanel status=new JPanel();

        JLabel nameDash = new JLabel("Name : ");
        JLabel userDash = new JLabel("Username : ");
        JLabel positionDash = new JLabel("Position : ");
        JLabel phoneDash = new JLabel("PhoneNo : ");
        JLabel emailDash = new JLabel("Email : ");
        JLabel statusDash=new JLabel("Status : ");

        nameDetail = new JLabel();
        userDetail = new JLabel();
        positionDetail = new JLabel();
        phoneDetail  =new JLabel();
        emailDetail = new JLabel();
        statusDetail=new JLabel();

        name.setLayout(new FlowLayout());
        name.add(nameDash);
        name.add(nameDetail);
        user.setLayout(new FlowLayout());
        user.add(userDash);
        user.add(userDetail);
        position.setLayout(new FlowLayout());
        position.add(positionDash);
        position.add(positionDetail);
        phone.setLayout(new FlowLayout());
        phone.add(phoneDash);
        phone.add(phoneDetail);
        email.setLayout(new FlowLayout());
        email.add(emailDash);
        email.add(emailDetail);
        status.setLayout(new FlowLayout());
        status.add(statusDash);
        status.add(statusDetail);

        dashboardPanel.setLayout(new GridLayout(7, 1));
        dashboardPanel.add(name);
        dashboardPanel.add(user);
        dashboardPanel.add(position);
        dashboardPanel.add(phone);
        dashboardPanel.add(email);
        dashboardPanel.add(status);

        setBackground(new Color(152,175,199));
        // Set preferred size for the dashboardPanel
        dashboardPanel.setPreferredSize(new Dimension(300, 400));

        // Set background color for panels
        name.setBackground(new Color(54, 75, 101));
        user.setBackground(new Color(54, 75, 101));
        position.setBackground(new Color(54, 75, 101));
        phone.setBackground(new Color(54, 75, 101));
        email.setBackground(new Color(54, 75, 101));
        status.setBackground(new Color(54, 75, 101));
        dashboardPanel.setBackground(new Color(54, 75, 101));

        // Set font styles for labels
        Font labelFont = new Font("Arial", Font.BOLD, 16);
        nameDash.setFont(labelFont);
        userDash.setFont(labelFont);
        positionDash.setFont(labelFont);
        phoneDash.setFont(labelFont);
        emailDash.setFont(labelFont);
        statusDash.setFont(labelFont);

        //Set foregroundColor
        nameDash.setForeground(Color.white);
        userDash.setForeground(Color.white);
        positionDash.setForeground(Color.white);
        phoneDash.setForeground(Color.white);
        emailDash.setForeground(Color.white);
        statusDash.setForeground(Color.white);
        nameDetail.setForeground(Color.white);
        userDetail.setForeground(Color.white);
        positionDetail.setForeground(Color.white);
        phoneDetail.setForeground(Color.white);
        emailDetail.setForeground(Color.white);
        statusDetail.setForeground(Color.white);

        // Set font styles for detail labels
        Font detailFont = new Font("Arial", Font.PLAIN, 16);
        nameDetail.setFont(detailFont);
        userDetail.setFont(detailFont);
        positionDetail.setFont(detailFont);
        phoneDetail.setFont(detailFont);
        emailDetail.setFont(detailFont);
        statusDetail.setFont(detailFont);

        // Add the dashboardPanel to the container
        this.setBounds(0, 60, 700, 700);
        this.add(dashboardPanel, BorderLayout.CENTER);
    }
    public JLabel getNameDetail() {
        return nameDetail;}
    public JLabel getUserDetail(){
        return userDetail;
    }
    public JLabel getPositionDetail(){
        return positionDetail;
    }
    public JLabel getPhoneDetail(){
        return phoneDetail;
    }
    public JLabel getEmailDetail(){
        return emailDetail;
    }
    public JLabel getStatusDetail(){
        return statusDetail;
    }
}
