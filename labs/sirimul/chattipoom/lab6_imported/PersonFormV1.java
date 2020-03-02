package sirimul.chattipoom.lab6_imported;

/**
 * This program PersonFormV1 extends from MySimpleWindow 
 * The program should have the following properties:
 * 1) Each line has the following properties: 1)The left part contains 
 * JLabel and then 2) the right part contains 
 * JTextField which its length is 15.  
 * Note that you need to have this value saved in a constant class member. 
 * 2) The first line contains the label which it is set as “Name:”
 * 3) The second line contains the label which it is set as “Height (cm.):”   
 * 4) The third line contains the label which it is set as “Weight (kg.):” 
 * 5) The fourth line contains the label which it is set as “Date of birth (eg., 31-01-1990):”
 * 6) The fifth line contains the radio buttons which are “Student” and “Teacher”.  
 * Only one radio button can be clicked at a time
 * 7) The sixth line contains two buttons which should be named “Cancel” 
 * and “OK” respectively.
 * @author: Kanda Saikaew
 * @date:  19/01/2020
 * @version: 1.0
 */
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class PersonFormV1 extends MySimpleWindow {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3629832942393810272L;
	protected JLabel nameLabel, heightLabel, weightLabel, dobLabel, typeLabel;
	protected JTextField nameTxtField, heightTxtField, weightTxtField, dobTxtField;
	protected JPanel namePanel, heightPanel, weightPanel, dobPanel, typePanel;
	protected JPanel overallPanel, textsPanel, typeChoicesPanel;
	protected JRadioButton student, teacher;
	protected ButtonGroup typeNames;
	public final static int TXTFIELD_WIDTH = 15;

	public PersonFormV1(String title) {
		super(title);
	}

	protected void initComponents() {
		namePanel = new JPanel(new GridLayout(1, 2));
		heightPanel = new JPanel(new GridLayout(1, 2));
		weightPanel = new JPanel(new GridLayout(1, 2));
		dobPanel = new JPanel(new GridLayout(1, 2));
		typePanel = new JPanel(new GridLayout(1, 2));
		typeChoicesPanel = new JPanel();
		nameLabel = new JLabel("Name:");
		nameTxtField = new JTextField(TXTFIELD_WIDTH);
		heightLabel = new JLabel("Height (cm.):");
		heightTxtField = new JTextField(TXTFIELD_WIDTH);
		weightLabel = new JLabel("Weight (kg.):");
		weightTxtField = new JTextField(TXTFIELD_WIDTH);
		dobLabel = new JLabel("Date of birth (eg.,31-01-1990):");
		dobTxtField = new JTextField(TXTFIELD_WIDTH);
		typeLabel = new JLabel("Type:");
		student = new JRadioButton("Student");
		teacher = new JRadioButton("Teacher");
		typeNames = new ButtonGroup();
		typeNames.add(student);
		typeNames.add(teacher);
		textsPanel = new JPanel(new GridLayout(5, 1));
		overallPanel = new JPanel(new BorderLayout());
	}

	protected void setLabelTxtField(JPanel panel, JLabel label, JTextField txtField) {
		panel.add(label);
		panel.add(txtField);
	}

	protected void addComponents() {
		super.addComponents();
		initComponents();
		setLabelTxtField(namePanel, nameLabel, nameTxtField);
		setLabelTxtField(heightPanel, heightLabel, heightTxtField);
		setLabelTxtField(weightPanel, weightLabel, weightTxtField);
		setLabelTxtField(dobPanel, dobLabel, dobTxtField);
		typePanel.add(typeLabel);
		typeChoicesPanel.add(student);
		typeChoicesPanel.add(teacher);
		typePanel.add(typeLabel);
		typePanel.add(typeChoicesPanel);
		textsPanel.add(namePanel);
		textsPanel.add(heightPanel);
		textsPanel.add(weightPanel);
		textsPanel.add(dobPanel);
		textsPanel.add(typePanel);
		overallPanel.add(textsPanel, BorderLayout.NORTH);
		overallPanel.add(buttonsPanel, BorderLayout.SOUTH);
		setContentPane(overallPanel);
	}

	public static void createAndShowGUI() {
		PersonFormV1 PersonFormV1 = new PersonFormV1("Person Form V1");
		PersonFormV1.addComponents();
		PersonFormV1.setFrameFeatures();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}
