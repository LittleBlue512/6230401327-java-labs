package sirimul.chattipoom.lab9;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

public class FootballGameV2 extends FootballGameV1 implements ActionListener, KeyListener {
    private static final long serialVersionUID = 1L;

    public FootballGameV2(String _frameTitle) {
        super(_frameTitle);

        // Sets the focusable state of this Component to true.
        this.setFocusable(true);
        this.requestFocus();
    }

    protected void addListeners() {
        // Add ActionListener to all the buttons.
        this.moveUp.addActionListener(this);
        this.moveDown.addActionListener(this);
        this.moveLeft.addActionListener(this);
        this.moveRight.addActionListener(this);
        this.resetButton.addActionListener(this);

        this.addKeyListener(this);
    }

    @Override
    protected void initComponent() {
        super.initComponent();

        // Change from CanvasDrawerV3 to CanvasDrawerV4.
        this.canvasDrawerFBG = new CanvasDrawerV4();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object object = e.getSource();

        if (object == this.moveUp) {
            canvasDrawerFBG.keeperLeft.moveUp();
        } else if (object == this.moveDown) {
            canvasDrawerFBG.keeperLeft.moveDown();
        } else if (object == this.moveLeft) {
            canvasDrawerFBG.keeperRight.moveUp();
        } else if (object == this.moveRight) {
            canvasDrawerFBG.keeperRight.moveDown();
        }

        // Give focus back to "this".
        this.requestFocus();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        // Move right keeper using "UP" and "DOWN".
        if (keyCode == KeyEvent.VK_UP) {
            // Move right keeper up.
            canvasDrawerFBG.keeperRight.moveUp();
        } else if (keyCode == KeyEvent.VK_DOWN) {
            // Move right keeper down.
            canvasDrawerFBG.keeperRight.moveDown();
        }

        // Move left keeper using "W" and "S".
        if (keyCode == KeyEvent.VK_W) {
            // Move left keeper up.
            canvasDrawerFBG.keeperLeft.moveUp();
        } else if (keyCode == KeyEvent.VK_S) {
            // Move left keeper down.
            canvasDrawerFBG.keeperLeft.moveDown();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    public static void createAndShowGUI() {
        final FootballGameV2 footballGameV2 = new FootballGameV2("Football Game V2");

        footballGameV2.initComponent();
        footballGameV2.addComponents();
        footballGameV2.addListeners();
        footballGameV2.setFrameFeatures();
    }

    public static void main(final String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}