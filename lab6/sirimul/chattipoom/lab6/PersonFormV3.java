/**
 * This program is to create a class called PersonFormV3 which extends from class PersonFormV2.
 * 
 * Author: Chattipoom Sirimul
 * ID: 623040132-7
 * Section: 1
 * Date: January 31, 2020
 */

package sirimul.chattipoom.lab6;

import java.awt.Insets;
import java.awt.GridBagConstraints;

import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

public class PersonFormV3 extends PersonFormV2 {
    // Quick fix warning: Java(536871008)
    private static final long serialVersionUID = 1L;

    // Constant variables.
    private static final String defaultFrameTitle = "PersonFormV3 Title";

    // Class's variables
    protected static String[] hobbies = { "Reading", "Traveling", "Cooking", "Photography" };

    // ---------- Components ----------
    protected JList<String> hobbyList;
    protected JLabel hobbyLabel;
    protected JMenuBar mainMenuBar;
    protected JMenu fileMenu, configMenu;
    protected JMenuItem newMenuItem, openMenuItem, saveMenuItem, exitMenuItem, colorMenuItem, sizeMenuItem;
    // ---------- ---------- ----------

    public PersonFormV3() {
        super(defaultFrameTitle);
    }

    public PersonFormV3(String _frameTitle) {
        super(_frameTitle);
    }

    // A method for adding menus to the window.
    protected void addMenus() {
        // Add MenuItems to Menu
        this.fileMenu.add(this.newMenuItem);
        this.fileMenu.add(this.openMenuItem);
        this.fileMenu.add(this.saveMenuItem);
        this.fileMenu.add(this.exitMenuItem);
        this.configMenu.add(this.colorMenuItem);
        this.configMenu.add(this.sizeMenuItem);

        // Add Menu to MenuBar
        this.mainMenuBar.add(this.fileMenu);
        this.mainMenuBar.add(this.configMenu);

        // Add MenuBar to the frame
        this.setJMenuBar(this.mainMenuBar);
    }

    @Override
    protected void createComponents() {
        super.createComponents();

        this.hobbyList = new JList<String>(hobbies);
        this.hobbyLabel = new JLabel("Hobbies:");
        this.mainMenuBar = new JMenuBar();
        this.fileMenu = new JMenu("File");
        this.configMenu = new JMenu("Config");
        this.newMenuItem = new JMenuItem("New");
        this.openMenuItem = new JMenuItem("Open");
        this.saveMenuItem = new JMenuItem("Save");
        this.exitMenuItem = new JMenuItem("Exit");
        this.colorMenuItem = new JMenuItem("Color");
        this.sizeMenuItem = new JMenuItem("Size");
    }

    @Override
    protected void addComponents() {
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Add hobbyLabel and hobbyList to formPanelV1.
        gbc.gridy = 6;
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.WEST;
        this.formPanelV1.add(this.hobbyLabel, gbc);
        gbc.gridy = 6;
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.EAST;
        this.formPanelV1.add(this.hobbyList, gbc);

        super.addComponents();
    }

    public static void createAndShowGUI() {
        PersonFormV3 personFormV3 = new PersonFormV3("Person form V3");

        // Initialize components.
        personFormV3.createComponents();

        // Add menu
        personFormV3.addMenus();

        personFormV3.addComponents();
        personFormV3.setFrameFeatures();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
