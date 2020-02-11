/**
 * This program is to show GUIs according to lab7 instructions.
 * 
 * Author: Chattipoom Sirimul
 * ID: 623040132-7
 * Section: 1
 * Date: February 9, 2020
 */

package sirimul.chattipoom.lab7;

import sirimul.chattipoom.lab6.*;

import java.awt.FlowLayout;
import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.SwingUtilities;

public class GraphicsMoverV1 extends MySimpleWindow {
    private static final long serialVersionUID = 1L;

    // Constant variables.
    protected static final int V_PADDING = 5, H_PADDING = 20;

    // Components
    protected CanvasDrawerV1 canvasDrawerV1;
    protected JPanel buttonPanel, topPanel, centerPanel, bottomPanel;
    protected JButton moveUp, moveDown, moveLeft, moveRight, resetButton;

    public GraphicsMoverV1(String _frameTitle) {
        super(_frameTitle);
    }

    private void setComponentLayout() {
        // Use BorderLayout in mainPanel.
        this.mainPanel.setLayout(new BorderLayout());

        // Set top, center, bottom panel's layout to BoxLayout.
        this.topPanel.setLayout(new BoxLayout(this.topPanel, BoxLayout.Y_AXIS));
        this.centerPanel.setLayout(new BoxLayout(this.centerPanel, BoxLayout.Y_AXIS));
        this.bottomPanel.setLayout(new BoxLayout(this.bottomPanel, BoxLayout.Y_AXIS));

        // Add horizontal and vertical padding to the components in bottomPanel.
        this.buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, H_PADDING, V_PADDING));
    }

    @Override
    protected void initComponent() {
        this.canvasDrawerV1 = new CanvasDrawerV1();
        this.mainPanel = new JPanel();
        this.buttonPanel = new JPanel();
        this.topPanel = new JPanel();
        this.centerPanel = new JPanel();
        this.bottomPanel = new JPanel();
        this.moveUp = new JButton("Move Up");
        this.moveDown = new JButton("Move Down");
        this.moveLeft = new JButton("Move Left");
        this.moveRight = new JButton("Move Right");
        this.resetButton = new JButton("Reset");

        this.setComponentLayout();
    }

    @Override
    protected void addComponents() {
        // Add buttons to buttonPanel.
        this.buttonPanel.add(this.moveUp);
        this.buttonPanel.add(this.moveDown);
        this.buttonPanel.add(this.moveLeft);
        this.buttonPanel.add(this.moveRight);
        this.buttonPanel.add(this.resetButton);

        // Add canvasDrawerV1 to centerPanel. Add buttonPanel to bottomPanel.
        this.centerPanel.add(this.canvasDrawerV1);
        this.bottomPanel.add(this.buttonPanel);

        // Add top, center, and bottom Panel to their position in the mainPanel.
        this.mainPanel.add(this.topPanel, BorderLayout.PAGE_START);
        this.mainPanel.add(this.centerPanel, BorderLayout.CENTER);
        this.mainPanel.add(this.bottomPanel, BorderLayout.PAGE_END);

        this.add(this.mainPanel);
    }

    @Override
    protected void setFrameFeatures() {
        this.setContentPane(this.mainPanel);
        super.setFrameFeatures();
    }

    public static void createAndShowGUI() {
        final GraphicsMoverV1 graphicsMoverV1 = new GraphicsMoverV1("Graphics Mover Version 1");

        graphicsMoverV1.initComponent();
        graphicsMoverV1.addComponents();
        graphicsMoverV1.setFrameFeatures();
    }

    public static void main(final String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}