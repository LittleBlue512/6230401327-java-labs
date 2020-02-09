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

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.BoxLayout;

import javax.swing.SwingUtilities;

public class MySimpleWindow extends JFrame {
    // Quick fix warning: Java(536871008) ~ Searched from Google.
    private static final long serialVersionUID = -5235778330626143850L;

    // Constant variables.
    private static final String defaultFrameTitle = "MySimpleWindow Title";
    private static final String cancelButtonString = "Cancel";
    private static final String okButtonString = "Ok";

    // ---------- Components ----------
    protected JPanel mainPanel;
    protected JPanel startPanel;
    protected JPanel centerPanel;
    protected JPanel endPanel;

    protected JPanel buttonPanel;

    protected JButton cancelButton;
    protected JButton okButton;
    // ---------- ---------- ----------

    // A default constructor.
    public MySimpleWindow() {
        super(defaultFrameTitle);
    }

    // A constructor with one parameter: frame's title.
    public MySimpleWindow(String _frameTitle) {
        super(_frameTitle);
    }

    // A method for initializing components
    protected void initComponent() {
        // Create panels.
        this.mainPanel = new JPanel(new BorderLayout());
        this.buttonPanel = new JPanel();

        // Create sub-panels for mainPanel: start, center, end
        // *** I use "BoxLayout" because I can add components to the panel without displacing the old one.
        // BoxLayout.Y_AXIS allows us to align components on the Y-axis.
        this.startPanel = new JPanel();
        this.startPanel.setLayout(new BoxLayout(this.startPanel, BoxLayout.Y_AXIS));
        this.centerPanel = new JPanel();
        this.centerPanel.setLayout(new BoxLayout(this.centerPanel, BoxLayout.Y_AXIS));
        this.endPanel = new JPanel();
        this.endPanel.setLayout(new BoxLayout(this.endPanel, BoxLayout.Y_AXIS));

        // Create buttons.
        this.cancelButton = new JButton(cancelButtonString);
        this.okButton = new JButton(okButtonString);
    }

    protected void addComponents() {
        // Add buttons to buttonPanel.
        buttonPanel.add(this.cancelButton);
        buttonPanel.add(this.okButton);

        // Add buttonPanel to endPanel.
        this.endPanel.add(this.buttonPanel);

        // Add sub-panels to its position in mainPanel.
        this.mainPanel.add(this.startPanel, BorderLayout.PAGE_START);
        this.mainPanel.add(this.centerPanel, BorderLayout.CENTER);
        this.mainPanel.add(this.endPanel, BorderLayout.PAGE_END);

        // Add main panel to the frame.
        this.add(this.mainPanel);
    }

    // A method for setting frame's features.
    protected void setFrameFeatures() {
        // Set the JFrame's sizes automatically by using pack().
        this.pack();
        // Make the JFrame visible.
        this.setVisible(true);
        // The program exit when the user clicks to close a frame.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set the window location at the center of the screen.
        this.setLocationRelativeTo(null);
    }

    public static void createAndShowGUI() {
        final MySimpleWindow msw = new MySimpleWindow("My Simple Window");

        // Initialize components
        msw.initComponent();

        msw.addComponents();
        msw.setFrameFeatures();
    }

    public static void main(final String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
