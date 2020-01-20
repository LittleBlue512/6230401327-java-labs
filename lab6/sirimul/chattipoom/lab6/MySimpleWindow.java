/**
 * This program is to create a class called MySimpleWindow which extends from class JFrame.
 * The class has a panel and two buttons. It also has methods to add components and set the features of the frame.
 * 
 * Author: Chattipoom Sirimul
 * ID: 623040132-7
 * Section: 1
 * Date: January 19, 2020
 */

package sirimul.chattipoom.lab6;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

import javax.swing.SwingUtilities;

public class MySimpleWindow extends JFrame {
    // Quick fix warning: Java(536871008) ~ Searched from Google.
    private static final long serialVersionUID = -5235778330626143850L;

    // Constant variables.
    private static final String defaultFrameTitle = "MySimpleWindow Title";
    private static final String cancelButtonString = "Cancel";
    private static final String okButtonString = "Ok";

    // Title of this class's object.
    protected String frameTitle;

    // ---------- Components ----------
    protected JFrame mainFrame;
    protected JPanel mainPanel;
    protected JButton cancelButton;
    protected JButton okButton;
    // ---------- ---------- ----------

    // A default constructor
    public MySimpleWindow() {
        // Set a default frame's title of this object.
        this.frameTitle = defaultFrameTitle;
        // Create a JFrame for this object.
        this.mainFrame = new JFrame();
    }

    // A constructor with one parameter: frame's title.
    public MySimpleWindow(String _frameTitle) {
        // Set a frame's title of this object.
        this.frameTitle = _frameTitle;
        // Create a JFrame for this object.
        this.mainFrame = new JFrame();
    }

    // A method for adding components to the main frame.
    protected void addComponents() {
        // Create a JPanel for this object.
        this.mainPanel = new JPanel();

        // Create a JButtons for this object.
        this.cancelButton = new JButton(cancelButtonString);
        this.okButton = new JButton(okButtonString);

        // Add the buttons to the main panel.
        this.mainPanel.add(this.cancelButton);
        this.mainPanel.add(this.okButton);

        // Add the main panel to the main frame.
        this.mainFrame.add(this.mainPanel);
    }

    // A method for setting frame's features.
    protected void setFrameFeatures() {
        // Set the JFrame's title.
        this.mainFrame.setTitle(this.frameTitle);
        // Set the JFrame's sizes automatically by using pack().
        this.mainFrame.pack();
        // Make the JFrame visible.
        this.mainFrame.setVisible(true);
        // The program exit when the user clicks to close a frame.
        this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set the window location at the center of the screen.
        this.mainFrame.setLocationRelativeTo(null);
    }

    public static void createAndShowGUI() {
        MySimpleWindow msw = new MySimpleWindow("My Simple Window");
        msw.addComponents();
        msw.setFrameFeatures();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
