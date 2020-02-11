/**
 * This class is to draw several shapes according to lab7 instructions. This
 * class is extended from GraphicsMoverV2.
 * 
 * Author: Chattipoom Sirimul ID: 623040132-7 Section: 1 Date: February 11, 2020
 */

package sirimul.chattipoom.lab7;

import java.awt.Image;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

public class GraphicsMoverV3 extends GraphicsMoverV2 {
    private static final long serialVersionUID = 1L;

    // Components
    protected JMenuBar mainMenuBar;
    protected JMenu fileMenu;
    protected JMenuItem openMenuItem, saveMenuItem, quitMenuItem;
    protected ImageIcon openImageIcon;

    public GraphicsMoverV3(String _frameTitle) {
        super(_frameTitle);
    }

    private void addMenu() {
        // Add MenuItem to Menu
        this.fileMenu.add(this.openMenuItem);
        this.fileMenu.add(this.saveMenuItem);
        this.fileMenu.add(this.quitMenuItem);

        // Add Menu to MenuBar
        this.mainMenuBar.add(this.fileMenu);

        // Set MenuBar
        this.setJMenuBar(this.mainMenuBar);
    }

    private void UpdateMenuIcon() {
        // Get ImageIcon.
        openImageIcon = new ImageIcon(getClass().getResource("images/openIcon.png"));
        // Get Image from ImageIcon.
        Image imageIcon = openImageIcon.getImage();
        // Scale the Image down.
        imageIcon = imageIcon.getScaledInstance(24, 24, Image.SCALE_SMOOTH);
        // Set new Image for ImageIcon.
        openImageIcon = new ImageIcon(imageIcon);
        // Set Icon for "Open" MenuItem.
        this.openMenuItem.setIcon(openImageIcon);
    }

    @Override
    protected void initComponent() {
        super.initComponent();

        this.mainMenuBar = new JMenuBar();
        this.fileMenu = new JMenu("File");
        this.openMenuItem = new JMenuItem("Open");
        this.saveMenuItem = new JMenuItem("Save");
        this.quitMenuItem = new JMenuItem("Quit");
    }

    @Override
    protected void addComponents() {
        super.addComponents();
        this.UpdateMenuIcon();
        this.addMenu();
    }

    public static void createAndShowGUI() {
        final GraphicsMoverV3 GraphicsMoverV3 = new GraphicsMoverV3("Graphics Mover Version 3");

        GraphicsMoverV3.initComponent();
        GraphicsMoverV3.addComponents();
        GraphicsMoverV3.setFrameFeatures();
    }

    public static void main(final String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}