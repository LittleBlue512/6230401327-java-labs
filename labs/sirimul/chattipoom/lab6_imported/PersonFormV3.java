package sirimul.chattipoom.lab6_imported;

/**
 * This program MobileDeviceFormV3  which extends from MobileDeviceFormV2 
 *
 * The program should have the following properties:
 * 1) The title of the program should be “Mobile Device Form V3”
 * 2) Add the list with the label “Features:” and the choices 
 * as “Design and build quality”, “Great Camera”, “Screen”, 
 * “Battery Life”
 * 3) Add the menu bar with these two following menus 
 * Menu “File” has four menu items which are “New”, “Open”, “Save”, 
 * and “Exit” 
 * Menu “Config” has two menu items which are “Color”, and “Size” 
 * 
 * @author: Kanda Saikaew
 * @date:  25/02/2017
 * @version: 1.0
 */
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class PersonFormV3 extends PersonFormV2 {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3694909354550437224L;

	protected JList<String> hobbies;
	protected String[] hobbiesValues = { "Reading", "Traveling", "Cooking", "Photography" };
	protected JMenuBar menuBar;
	protected JMenu fileMenu, configMenu;
	protected JMenuItem newMI, openMI, saveMI, exitMI, colorMI, sizeMI;
	protected int NUM_VISIBLE_ROWS = 2;
	protected JPanel hobbiesPanel, comboListPanel;
	protected JLabel hobbiesLabel;

	public PersonFormV3(String title) {
		super(title);
	}

	protected void initComponents() {
		super.initComponents();
		hobbies = new JList<String>(hobbiesValues);
		hobbies.setVisibleRowCount(NUM_VISIBLE_ROWS);
		hobbiesLabel = new JLabel("Hobbies:");
		hobbiesPanel = new JPanel(new GridLayout(1, 2));
		comboListPanel = new JPanel(new GridLayout(2, 1));
	}

	protected void addComponents() {
		super.addComponents();
		hobbiesPanel.add(hobbiesLabel);
		hobbiesPanel.add(hobbies);
		contentPanel.remove(typePanel);
		comboListPanel.add(typePanel);
		comboListPanel.add(hobbiesPanel);
		contentPanel.add(comboListPanel, BorderLayout.CENTER);
	}

	protected void addMenus() {
		menuBar = new JMenuBar();
		fileMenu = new JMenu("File");
		configMenu = new JMenu("Config");
		newMI = new JMenuItem("New");
		openMI = new JMenuItem("Open");
		saveMI = new JMenuItem("Save");
		exitMI = new JMenuItem("Exit");
		colorMI = new JMenuItem("Color");
		sizeMI = new JMenuItem("Size");
		fileMenu.add(newMI);
		fileMenu.add(openMI);
		fileMenu.add(saveMI);
		fileMenu.add(exitMI);
		configMenu.add(colorMI);
		configMenu.add(sizeMI);
		menuBar.add(fileMenu);
		menuBar.add(configMenu);
		setJMenuBar(menuBar);
	}

	public static void createAndShowGUI() {
		PersonFormV3 personForm3 = new PersonFormV3("Person Form V3");
		personForm3.addComponents();
		personForm3.addMenus();
		personForm3.setFrameFeatures();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}
