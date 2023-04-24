package AdminPages;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;


public class AdminViewStudent extends JPanel {
    private JTable table;
    private DefaultTableModel tableModel;
    private JScrollPane scrollPane;
    private JButton removeBtn,verifyBtn;
    public AdminViewStudent() {
        // Create a table model with column names and no data
        String[] columnNames = {"ID", "Name", "Username", "PhoneNo", "Email", "Parent Name", "Status",};

        // Initialize the tablemodel here
        tableModel = new DefaultTableModel(columnNames, 0);
        // Create a table and set the table model
        table = new JTable(tableModel);

        // Create a scroll pane and add the table to it
        scrollPane = new JScrollPane(table);

        //create  a remove Button to the panel
        removeBtn = new JButton("Remove Selected");
        verifyBtn=new JButton("Verify Selected");

        // Add the scroll pane to the frame
        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(scrollPane);
        add(removeBtn);
        add(verifyBtn);
        setBorder(new EmptyBorder(50, 10, 50, 10));
        setBackground(new Color(152,175,199));
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        table.setRowHeight(40);

        // customize the table header
        JTableHeader header = table.getTableHeader();
        header.setBackground(Color.WHITE);
        header.setForeground(Color.BLACK);
        header.setFont(new Font("SansSerif", Font.BOLD, 15));
    }
    public DefaultTableModel getTableModel() {
        return tableModel;
    }
    public JTable getTable() {
        return table;
    }
    public JButton getRemoveBtn() {
        return removeBtn;
    }
    public JButton getVerifyBtn(){
        return verifyBtn;
    }
}

