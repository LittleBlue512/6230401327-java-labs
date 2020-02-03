/**
 * This program is to create a class called PersonFormV4 which extends from class PersonFormV3.
 * 
 * Author: Chattipoom Sirimul
 * ID: 623040132-7
 * Section: 1
 * Date: February 3, 2020
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
    protected JMenu newColorMenu;
    protected JMenu newSizeMenu;

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
    protected void initComponent() {
        super.initComponent();

        this.newColorMenu = new JMenu("Color");
        this.newSizeMenu = new JMenu("Size");

        this.redMenuItem = new JMenuItem("Red");
        this.greenMenuItem = new JMenuItem("Green");
        this.blueMenuItem = new JMenuItem("Blue");
        this.size1MenuItem = new JMenuItem("16");
        this.size2MenuItem = new JMenuItem("20");
        this.size3MenuItem = new JMenuItem("24");
    }

    @Override
    protected void addComponents() {
        super.addComponents();
    }

    protected void UpdateMenuIcon() {
        newMenuIcon = new ImageIcon(getClass().getResource("images/newIcon.png"));
        Image imageIcon = newMenuIcon.getImage();
        imageIcon = imageIcon.getScaledInstance(24, 24, Image.SCALE_SMOOTH);
        newMenuIcon = new ImageIcon(imageIcon);

        this.newMenuItem.setIcon(newMenuIcon);
    }

    protected void addSubMenu() {
        this.configMenu.remove(this.colorMenuItem);
        this.configMenu.remove(this.sizeMenuItem);

        this.newColorMenu.add(this.redMenuItem);
        this.newColorMenu.add(this.greenMenuItem);
        this.newColorMenu.add(this.blueMenuItem);
        this.newSizeMenu.add(this.size1MenuItem);
        this.newSizeMenu.add(this.size2MenuItem);
        this.newSizeMenu.add(this.size3MenuItem);

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
