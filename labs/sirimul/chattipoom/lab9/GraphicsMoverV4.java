package sirimul.chattipoom.lab9;

import javax.swing.JButton;
import javax.swing.SwingUtilities;

import sirimul.chattipoom.lab7.*;

public class GraphicsMoverV4 extends GraphicsMoverV3 {
    private static final long serialVersionUID = 1L;

    protected CanvasDrawerV2 canvasDrawerV2;

    public GraphicsMoverV4(String _frameTitle) {
        super(_frameTitle);
    }

    @Override
    protected void initComponent() {
        super.initComponent();

        // Change text in the buttons.
        this.moveUp = new JButton("Move Left Up");
        this.moveDown = new JButton("Move Left Down");
        this.moveLeft = new JButton("Move Right Up");
        this.moveRight = new JButton("Move Right Down");

        // Create CanvasDrawerV2;
        this.canvasDrawerV2 = new CanvasDrawerV2();
    }

    @Override
    protected void addComponents() {
        super.addComponents();

        // Remove CanvasDrawerV1.
        this.centerPanel.remove(this.canvasDrawerV1);

        // Add CavasDrawerV2.
        this.centerPanel.add(this.canvasDrawerV2);
    }

    public static void createAndShowGUI() {
        final GraphicsMoverV4 graphicsMoverV4 = new GraphicsMoverV4("Graphics Mover Version 4");

        graphicsMoverV4.initComponent();
        graphicsMoverV4.addComponents();
        graphicsMoverV4.setFrameFeatures();
    }

    public static void main(final String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

}