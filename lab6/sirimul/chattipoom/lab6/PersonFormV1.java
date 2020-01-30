/**
 * This program is to create a class called PersonFormV1 which extends from class MySimpleWindow.
 * 
 * Author: Chattipoom Sirimul
 * ID: 623040132-7
 * Section: 1
 * Date: January 20, 2020
 */

package sirimul.chattipoom.lab6;

import java.awt.GridLayout;

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

        // Create panels
        this.radioButtonPanel = new JPanel();
        this.formPanel = new JPanel();
    }

    @Override
    protected void addComponents() {
        // Add two radio buttons to the button group.
        this.radiaButtonGroup.add(this.studentRadioBtn);
        this.radiaButtonGroup.add(this.teacherRadioBtn);

        // Add two radio buttons to the button panel.
        this.radioButtonPanel.add(this.studentRadioBtn);
        this.radioButtonPanel.add(this.teacherRadioBtn);

        // Set Layout for the form panel.
        this.formPanel.setLayout(new GridLayout(0, 2));

        // Add the components to the form panel.
        this.formPanel.add(this.nameLabel);
        this.formPanel.add(this.nameTextField);
        this.formPanel.add(this.heightLabel);
        this.formPanel.add(this.heightTextField);
        this.formPanel.add(this.weightLabel);
        this.formPanel.add(this.weightTextField);
        this.formPanel.add(this.dobLabel);
        this.formPanel.add(this.dobTextField);
        this.formPanel.add(this.typeLabel);
        this.formPanel.add(this.radioButtonPanel);

        // Add from panel to center panel.
        this.centerPanel.add(this.formPanel);

        // Call super's method.
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