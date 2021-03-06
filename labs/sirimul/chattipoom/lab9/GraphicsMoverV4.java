/**
 * This class is to display a yellow ball in the middle of the field using canvasDrawerV2.
 * This class extended from GraphicsMoverV3.
 * 
 * Author: Chattipoom Sirimul
 * ID: 623040132-7
 * Section: 1
 * Date: February 29, 2020
 */

package sirimul.chattipoom.lab9;

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
        this.moveUp.setText("Move Left Up");
        this.moveDown.setText("Move Left Down");
        this.moveLeft.setText("Move Right Up");
        this.moveRight.setText("Move Right Down");

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