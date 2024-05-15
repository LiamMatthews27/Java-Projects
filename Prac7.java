package za.ac.mycput.prac7;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Prac7 extends JFrame implements ActionListener {

    private JLabel departmentLabel = new JLabel("Department");
    private JLabel firstNameLabel = new JLabel("First Name:");
    private JLabel lastNameLabel = new JLabel("Last Name:");
    private JLabel empStatusLabel = new JLabel("Employee Type");

    private JRadioButton radPermanent = new JRadioButton("Permanent");
    private JRadioButton radTemp = new JRadioButton("Temporary");
    private ButtonGroup bGroup = new ButtonGroup();

    private JButton addBtn = new JButton("Add Row");
    private JButton exitBtn = new JButton("Exit");

    private String[] departmentOptions = {"Marketing", "Information Technology", "Civil Engineering", "Graphic Design"};
    private JComboBox<String> departmentComboBox = new JComboBox<>(departmentOptions);

    private JTextField firstNameField = new JTextField();
    private JTextField lastNameField = new JTextField();

    private DefaultTableModel tableModel = new DefaultTableModel();
    private JTable enrollmentTable = new JTable(tableModel);
    private JScrollPane jScp = new JScrollPane(enrollmentTable);

    public Prac7() {
        super("Enrollment Form");
        
        tableModel.addColumn("Department");
        tableModel.addColumn("First Name");
        tableModel.addColumn("Last Name");
        tableModel.addColumn("Employment Type");

        // Set up layout
        JPanel topPanel = new JPanel(new GridLayout(5, 2, 5, 5));
        topPanel.add(departmentLabel);
        topPanel.add(departmentComboBox);
        topPanel.add(firstNameLabel);
        topPanel.add(firstNameField);
        topPanel.add(lastNameLabel);
        topPanel.add(lastNameField);
        topPanel.add(empStatusLabel);
        topPanel.add(radPermanent);
        topPanel.add(new JLabel());   // Empty label for spacing
        topPanel.add(radTemp);

        // Add components to the frame
        add(topPanel, BorderLayout.NORTH);
        add(jScp, BorderLayout.CENTER);

        JPanel bottomPnl = new JPanel(new GridLayout(1, 2, 5, 5));
        bottomPnl.add(addBtn);
        bottomPnl.add(exitBtn);
        add(bottomPnl, BorderLayout.SOUTH);

        bGroup.add(radPermanent);
        bGroup.add(radTemp);

        addBtn.addActionListener(this);
        exitBtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exitBtn) {
            System.exit(0);
        } else if (e.getSource() == addBtn) {
            // Add row functionality
            String[] rowData = {
                    (String) departmentComboBox.getSelectedItem(),
                    firstNameField.getText(),
                    lastNameField.getText(),
                    radPermanent.isSelected() ? "Permanent" : "Temporary"
            };
            tableModel.addRow(rowData);
        }
    }

    
}
