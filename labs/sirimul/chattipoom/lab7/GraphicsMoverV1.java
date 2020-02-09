package sirimul.chattipoom.lab7;

import sirimul.chattipoom.lab6.*;

import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.SwingUtilities;

public class GraphicsMoverV1 extends MySimpleWindow {
    private static final long serialVersionUID = 1L;

    // Constant variables.
    private static final int V_PADDING = 5, H_PADDING = 20;

    // Components
    protected CanvasDrawerV1 topPanel;
    protected JPanel buttomPanel;
    protected JButton moveUp, moveDown, moveLeft, moveRight, resetButton;

    public GraphicsMoverV1(String _frameTitle) {
        super(_frameTitle);
    }

    @Override
    protected void initComponent() {
        this.topPanel = new CanvasDrawerV1();
        this.mainPanel = new JPanel();
        this.buttomPanel = new JPanel();
        this.moveUp = new JButton("Move Up");
        this.moveDown = new JButton("Move Down");
        this.moveLeft = new JButton("Move Left");
        this.moveRight = new JButton("Move Right");
        this.resetButton = new JButton("Reset");

        this.mainPanel.setLayout(new BoxLayout(this.mainPanel, BoxLayout.Y_AXIS));
        this.buttomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, H_PADDING, V_PADDING));
    }

    @Override
    protected void addComponents() {
        this.buttomPanel.add(this.moveUp);
        this.buttomPanel.add(this.moveDown);
        this.buttomPanel.add(this.moveLeft);
        this.buttomPanel.add(this.moveRight);
        this.buttomPanel.add(this.resetButton);

        this.mainPanel.add(this.topPanel);
        this.mainPanel.add(this.buttomPanel);

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