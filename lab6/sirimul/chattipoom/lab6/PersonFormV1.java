package sirimul.chattipoom.lab6;

import java.awt.GridLayout;

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

    protected ButtonGroup typeButtonGroup;
    // ---------- ---------- ----------

    // A default constructor.
    public PersonFormV1() {
        super();
        this.setTitle(defaultFrameTitle);
    }

    // A constructor with one parameter: frame's title.
    public PersonFormV1(String _frameTitle) {
        super(_frameTitle);
    }

    @Override
    protected void addComponents() {
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
        this.typeButtonGroup = new ButtonGroup();

        // Add two type buttons to the button group.
        this.typeButtonGroup.add(this.studentRadioBtn);
        this.typeButtonGroup.add(this.teacherRadioBtn);

        // Create panel for two type buttons.
        JPanel typeButtonPanel = new JPanel();

        // Add the buttons to the type button panel.
        typeButtonPanel.add(this.studentRadioBtn);
        typeButtonPanel.add(this.teacherRadioBtn);

        // Set layout
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(0, 2));

        this.mainPanel.setLayout(new BoxLayout(this.mainPanel, BoxLayout.Y_AXIS));

        // Add the components to the form panel.
        formPanel.add(this.nameLabel);
        formPanel.add(this.nameTextField);
        formPanel.add(this.heightLabel);
        formPanel.add(this.heightTextField);
        formPanel.add(this.weightLabel);
        formPanel.add(this.weightTextField);
        formPanel.add(this.dobLabel);
        formPanel.add(this.dobTextField);
        formPanel.add(this.typeLabel);
        formPanel.add(typeButtonPanel);

        this.mainPanel.add(formPanel);

        super.addComponents();
    }

    public static void createAndShowGUI() {
        PersonFormV1 personFormV1 = new PersonFormV1("Person form V1");
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