/**
 * This program is to create a class called PersonFormV1 which extends from class MySimpleWindow.
 * 
 * Author: Chattipoom Sirimul
 * ID: 623040132-7
 * Section: 1
 * Date: January 20, 2020
 */

package sirimul.chattipoom.lab6;

import java.awt.Insets;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class PersonFormV1 extends MySimpleWindow {
    // Quick fix warning: Java(536871008)
    private static final long serialVersionUID = 1L;

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
    protected JPanel formPanelV1;
    // ---------- ---------- ----------

    // A default constructor.
    public PersonFormV1() {
        super(defaultFrameTitle);
    }

    // A constructor with one parameter: frame's title.
    public PersonFormV1(String _frameTitle) {
        super(_frameTitle);
    }

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
        this.formPanelV1 = new JPanel(new GridBagLayout());
    }

    @Override
    protected void addComponents() {
        // Call super's method.
        super.addComponents();

        // Add two radio buttons to the button group.
        this.radiaButtonGroup.add(this.studentRadioBtn);
        this.radiaButtonGroup.add(this.teacherRadioBtn);

        // Add two radio buttons to the button panel.
        this.radioButtonPanel.add(this.studentRadioBtn);
        this.radioButtonPanel.add(this.teacherRadioBtn);

        // Set Layout for the form panel.
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.weighty = 1.0;
        gbc.weightx = 1.0;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Add the components to the form panel.
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.WEST;
        this.formPanelV1.add(this.nameLabel, gbc);
        gbc.gridy = 0;
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.EAST;
        this.formPanelV1.add(this.nameTextField, gbc);
        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.WEST;
        this.formPanelV1.add(this.heightLabel, gbc);
        gbc.gridy = 1;
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.EAST;
        this.formPanelV1.add(this.heightTextField, gbc);
        gbc.gridy = 2;
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.WEST;
        this.formPanelV1.add(this.weightLabel, gbc);
        gbc.gridy = 2;
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.EAST;
        this.formPanelV1.add(this.weightTextField, gbc);
        gbc.gridy = 3;
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.WEST;
        this.formPanelV1.add(this.dobLabel, gbc);
        gbc.gridy = 3;
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.EAST;
        this.formPanelV1.add(this.dobTextField, gbc);
        gbc.gridy = 4;
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.WEST;
        this.formPanelV1.add(this.typeLabel, gbc);
        gbc.gridy = 4;
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.EAST;
        this.formPanelV1.add(this.radioButtonPanel, gbc);

        // Add from panel to center panel.
        this.centerPanel.add(this.formPanelV1);
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