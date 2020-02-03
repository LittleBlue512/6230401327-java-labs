/**
 * This program is to create a class called PersonFormV4 which extends from class PersonFormV3.
 * 
 * Author: Chattipoom Sirimul
 * ID: 623040132-7
 * Section: 1
 * Date: January 31, 2020
 */

package sirimul.chattipoom.lab6;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import java.awt.Image;

public class PersonFormV4 extends PersonFormV3 {
    // Quick fix warning: Java(536871008)
    private static final long serialVersionUID = 1L;

    // Constant variables.
    private static final String defaultFrameTitle = "PersonFormV4 Title";

    // Class's variables
    protected static ImageIcon newMenuIcon;

    // ---------- Components ----------
    protected JMenuItem redMenuItem;
    protected JMenuItem greenMenuItem;
    protected JMenuItem blueMenuItem;
    protected JMenuItem size1MenuItem;
    protected JMenuItem size2MenuItem;
    protected JMenuItem size3MenuItem;
    // ---------- --------------------

    public PersonFormV4() {
        super(defaultFrameTitle);
    }

    public PersonFormV4(String _frameTitle) {
        super(_frameTitle);
    }

    @Override
    protected void addMenu() {
        this.colorMenuItem = new JMenu("Color");
        this.sizeMenuItem = new JMenu("Size");

        this.colorMenuItem.add(this.redMenuItem);
        this.colorMenuItem.add(this.greenMenuItem);
        this.colorMenuItem.add(this.blueMenuItem);
        this.sizeMenuItem.add(this.size1MenuItem);
        this.sizeMenuItem.add(this.size2MenuItem);
        this.sizeMenuItem.add(this.size3MenuItem);

        super.addMenu();
    }

    @Override
    protected void createComponents() {
        super.createComponents();

        this.redMenuItem = new JMenuItem("Red");
        this.greenMenuItem = new JMenuItem("Green");
        this.blueMenuItem = new JMenuItem("Blue");
        this.size1MenuItem = new JMenuItem("16");
        this.size2MenuItem = new JMenuItem("20");
        this.size3MenuItem = new JMenuItem("24");

        newMenuIcon = new ImageIcon(getClass().getResource("images/newIcon.png"));
        Image imageIcon = newMenuIcon.getImage();
        imageIcon = imageIcon.getScaledInstance(24, 24, Image.SCALE_SMOOTH);
        newMenuIcon = new ImageIcon(imageIcon);

        this.newMenuItem.setIcon(newMenuIcon);
    }

    @Override
    protected void addComponents() {
        super.addComponents();
    }

    public static void createAndShowGUI() {
        PersonFormV4 personFormV4 = new PersonFormV4("Person form V4");

        // Initialize components.
        personFormV4.createComponents();

        // Add menu
        personFormV4.addMenu();

        personFormV4.addComponents();
        personFormV4.setFrameFeatures();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
