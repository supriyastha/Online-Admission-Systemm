package Frames;

import javax.swing.*;


public class MyFrame extends JFrame {
    public MyFrame() {
        ImageIcon im=new ImageIcon();
        this.setTitle("Online Admission System");
        this.setSize(900, 900);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(im.getImage());
        JLabel lb=new JLabel(im);

    }
}