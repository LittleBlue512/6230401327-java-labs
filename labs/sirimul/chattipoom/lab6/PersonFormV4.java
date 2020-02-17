/**
 * This program is to create a class called PersonFormV4 which extends from class PersonFormV3.
 * 
 * Author: Chattipoom Sirimul
 * ID: 623040132-7
 * Section: 1
 * Date: February 3, 2020
 */

package sirimul.chattipoom.lab6;

import java.awt.Image;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

public class PersonFormV4 extends PersonFormV3 {
    // Quick fix warning: Java(536871008)
    private static final long serialVersionUID = 1L;

    // Constant variables.
    private static final String DEFAULT_FRAME_TITLE = "PersonFormV4 Title";

    // Class's variables
    protected static ImageIcon newMenuIcon;

    // ---------- Components ----------
    protected JMenu newColorMenu, newSizeMenu;
    protected JMenuItem redMenuItem, greenMenuItem, blueMenuItem, size16MenuItem, size20MenuItem, size24MenuItem;
    // ---------- --------------------

    public PersonFormV4() {
        super(DEFAULT_FRAME_TITLE);
    }

    public PersonFormV4(String _frameTitle) {
        super(_frameTitle);
    }

    @Override
    protected void initComponent() {
        super.initComponent();

        // Create new menus for "Config" menu.
        this.newColorMenu = new JMenu("Color");
        this.newSizeMenu = new JMenu("Size");

        // Create MenuItems for the new menus (Color and Size).
        this.redMenuItem = new JMenuItem("Red");
        this.greenMenuItem = new JMenuItem("Green");
        this.blueMenuItem = new JMenuItem("Blue");
        this.size16MenuItem = new JMenuItem("16");
        this.size20MenuItem = new JMenuItem("20");
        this.size24MenuItem = new JMenuItem("24");
    }

    @Override
    protected void addComponents() {
        super.addComponents();
    }

    protected void UpdateMenuIcon() {
        // Get ImageIcon.
        newMenuIcon = new ImageIcon(getClass().getResource("images/newIcon.png"));
        // Get Image from ImageIcon.
        Image imageIcon = newMenuIcon.getImage();
        // Scale the Image down.
        imageIcon = imageIcon.getScaledInstance(24, 24, Image.SCALE_SMOOTH);
        // Set new Image for ImageIcon.
        newMenuIcon = new ImageIcon(imageIcon);
        // Set Icon for "New" MenuItem.
        this.newMenuItem.setIcon(newMenuIcon);
    }

    protected void addSubMenu() {
        // Remove "Color" and "Size" from "Config" menu.
        this.configMenu.remove(this.colorMenuItem);
        this.configMenu.remove(this.sizeMenuItem);

        // Add MenuItems to the new menus.
        this.newColorMenu.add(this.redMenuItem);
        this.newColorMenu.add(this.greenMenuItem);
        this.newColorMenu.add(this.blueMenuItem);
        this.newSizeMenu.add(this.size16MenuItem);
        this.newSizeMenu.add(this.size20MenuItem);
        this.newSizeMenu.add(this.size24MenuItem);

        // Add new menus to "Config" menu.
        this.configMenu.add(this.newColorMenu);
        this.configMenu.add(this.newSizeMenu);
    }

    protected void addMenus() {
        super.addMenus();
        UpdateMenuIcon();
        addSubMenu();
    }

    public static void createAndShowGUI() {
        PersonFormV4 personFormV4 = new PersonFormV4("Person form V4");

        // Initialize components.
        personFormV4.initComponent();

        // Add menu
        personFormV4.addMenus();

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
