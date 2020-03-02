package sirimul.chattipoom.lab6_imported;

/**
 * This program Mobile DeviceFormV2 extends from Mobile DeviceFormV1 
 * The program should have the following properties:
 * 1. The title of the program should be “Mobile Device Form V2”
 * 2. Add the label “Gender”” and two radio buttons “Male and “Female”
 * 3. Add the label “Address:” and the text area with 2 rows and 35 columns.   
 * 4. Create the scroll pane and add the text area in that scroll pane.  
 * 5. Initialize the text area with the content as "Department of Computer Engineering, 
 * Faculty of Engineering, Khon Kaen University, Mittraparp Rd., T. Naimuang, 
 * A. Muang, Khon Kaen, Thailand, 40002"
 * 6. Place the Gender and the Address parts above the two buttons. 
 * 
 * @author: Kanda Saikaew
 * @date:  21/02/2017
 * @version: 1.0
 */
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class PersonFormV2 extends PersonFormV1 {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3694909354550437224L;

	protected JTextArea reviewTxtArea;
	protected JScrollPane reviewScrollPane;
	protected JPanel reviewPanel, contentPanel, typePanel;
	protected JLabel reviewLabel, typeLabel;
	protected JComboBox<String> typeBox;
	protected String[] typesValues = { "Running", "Swimming", "Tennis" };

	public final static int NUM_TXTAREA_ROWS = 2;
	public final static int NUM_TXTAREA_COLS = 35;

	public PersonFormV2(String title) {
		super(title);
	}

	protected void initComponents() {
		super.initComponents();
		reviewTxtArea = new JTextArea(NUM_TXTAREA_ROWS, NUM_TXTAREA_COLS);
		reviewTxtArea.setLineWrap(true);
		reviewTxtArea.setWrapStyleWord(true);
		reviewTxtArea.setText("21st Century skills include");
		reviewTxtArea.append("Critical thinking, Creativity, Collaboration, ");
		reviewTxtArea.append("Communication, etc.");
		reviewScrollPane = new JScrollPane(reviewTxtArea);
		reviewPanel = new JPanel(new BorderLayout());
		contentPanel = new JPanel(new BorderLayout());
		typePanel = new JPanel(new GridLayout(1, 2));
		reviewLabel = new JLabel("Note:");
		typeLabel = new JLabel("Sports:");
		typeBox = new JComboBox<String>(typesValues);
	}

	protected void addComponents() {
		super.addComponents();
		reviewPanel.add(reviewLabel, BorderLayout.NORTH);
		reviewPanel.add(reviewScrollPane, BorderLayout.SOUTH);
		typePanel.add(typeLabel);
		typePanel.add(typeBox);
		contentPanel.add(textsPanel, BorderLayout.NORTH);
		contentPanel.add(typePanel, BorderLayout.CENTER);
		contentPanel.add(reviewPanel, BorderLayout.SOUTH);
		overallPanel.add(contentPanel, BorderLayout.NORTH);
	}

	public static void createAndShowGUI() {
		PersonFormV2 personForm2 = new PersonFormV2("Person Form V2");
		personForm2.addComponents();
		personForm2.setFrameFeatures();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}
