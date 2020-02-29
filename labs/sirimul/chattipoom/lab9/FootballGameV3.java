/**
 * This class is to allow the user to reset the score and the ball's position.
 * This class extended from FootballGameV2.
 * 
 * Author: Chattipoom Sirimul
 * ID: 623040132-7
 * Section: 1
 * Date: February 29, 2020
 */

package sirimul.chattipoom.lab9;

import java.awt.event.ActionEvent;

import javax.swing.SwingUtilities;

public class FootballGameV3 extends FootballGameV2 {
    private static final long serialVersionUID = 1L;

    public FootballGameV3(String _frameTitle) {
        super(_frameTitle);
    }

    @Override
    protected void initComponent() {
        super.initComponent();

        // Change from CanvasDrawerV4 to CanvasDrawerV5.
        this.canvasDrawerFBG = new CanvasDrawerV5();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        Object object = e.getSource();

        if (object == this.resetButton) {
            resetScore();

            // The method resetBall() is in canvasDrawerV3.
            this.canvasDrawerFBG.resetBall();
        }
    }

    protected void resetScore() {
        this.blueScore.setText("0");
        this.redScore.setText("0");
    }

    public static void createAndShowGUI() {
        final FootballGameV3 footballGameV3 = new FootballGameV3("Football Game V3");

        footballGameV3.initComponent();
        footballGameV3.addComponents();
        footballGameV3.addListeners();
        footballGameV3.setFrameFeatures();
    }

    public static void main(final String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}