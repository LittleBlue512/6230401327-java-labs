/**
 * This program is to create a class called PersonFormV1 which extends from class MySimpleWindow.
 * 
 * Author: Chattipoom Sirimul
 * ID: 623040132-7
 * Section: 1
 * Date: January 20, 2020
 */

 package sirimul.chattipoom.lab6;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class PersonFormV1 extends MySimpleWindow {
    // Quick fix warning: Java(536871008) ~ Searched from Google.
    private static final long serialVersionUID = 3116509230184477773L;

    // Constant variables.
    private static final String defaultFrameTitle = "PersonFormV1 Title";
    private static final int textFieldLength = 15;

    // ---------- Components ----------
    protected JLabel nameLabel;
    protected JLabel heightLabel;
    protected JLabel weightLabel;
    protected JLabel dobLabel;
    protected JLabel typeLabel;

    protected JTextField nameTextField;
    protected JTextField heightTextField;
    protected JTextField weightTextField;
    protected JTextField dobTextField;

    protected JRadioButton studentRadioBtn;
    protected JRadioButton teacherRadioBtn;

    protected ButtonGroup radiaButtonGroup;

    protected JPanel radioButtonPanel;
    protected JPanel formPanel;
    // ---------- ---------- ----------

    // A default constructor.
    public PersonFormV1() {
        super(defaultFrameTitle);
    }

    // A constructor with one parameter: frame's title.
    public PersonFormV1(String _frameTitle) {
        super(_frameTitle);
    }

    // Initialize components
    @Override
    protected void createComponents() {
        // Call the super's method.
        super.createComponents();

        // Create labels.
        this.nameLabel = new JLabel("Name:");
        this.heightLabel = new JLabel("Height (cm.):");
        this.weightLabel = new JLabel("Weight (kg.):");
        this.dobLabel = new JLabel("Date of birth(eg.,31-01-1990):");
        this.typeLabel = new JLabel("Type:");

        // Create text fields.
        this.nameTextField = new JTextField(textFieldLength);
        this.heightTextField = new JTextField(textFieldLength);
        this.weightTextField = new JTextField(textFieldLength);
        this.dobTextField = new JTextField(textFieldLength);

        // Create two radio buttons.
        this.studentRadioBtn = new JRadioButton("Student");
        this.teacherRadioBtn = new JRadioButton("Teacher");

        // Create a button group.
        this.radiaButtonGroup = new ButtonGroup();

        // Create a panel for two radio buttons.
        this.radioButtonPanel = new JPanel();

        // Create a form panel
        this.formPanel = new JPanel();
    }

    @Override
    protected void addComponents() {
        // Add two type buttons to the button group.
        this.radiaButtonGroup.add(this.studentRadioBtn);
        this.radiaButtonGroup.add(this.teacherRadioBtn);

        // Add two type buttons to the button panel.
        this.radioButtonPanel.add(this.studentRadioBtn);
        this.radioButtonPanel.add(this.teacherRadioBtn);

        // Set Layout for the form panel.
        this.formPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Add the components to the form panel.
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.formPanel.add(this.nameLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        this.formPanel.add(this.nameTextField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        this.formPanel.add(this.heightLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        this.formPanel.add(this.heightTextField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        this.formPanel.add(this.weightLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        this.formPanel.add(this.weightTextField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        this.formPanel.add(this.dobLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        this.formPanel.add(this.dobTextField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        this.formPanel.add(this.typeLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 4;
        this.formPanel.add(this.radioButtonPanel, gbc);

        // Add from panel to main frame.
        this.mainPanel.add(this.formPanel, BorderLayout.CENTER);

        // Add MySimpleWindow's components to main frame.
        super.addComponents();
    }

    public static void createAndShowGUI() {
        PersonFormV1 personFormV1 = new PersonFormV1("Person form V1");

        // Initialize components.
        personFormV1.createComponents();

        personFormV1.addComponents();
        personFormV1.setFrameFeatures();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}