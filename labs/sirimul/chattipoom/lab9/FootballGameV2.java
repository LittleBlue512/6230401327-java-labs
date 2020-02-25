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
    }

    protected void addListeners() {
        this.addKeyListener(this);

        this.moveUp.addActionListener(this);
        this.moveDown.addActionListener(this);
        this.moveLeft.addActionListener(this);
        this.moveRight.addActionListener(this);
    }

    @Override
    protected void setFrameFeatures() {
        super.setFrameFeatures();

        // Sets the focusable state of this Component to true.
        this.setFocusable(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object object = e.getSource();

        if (object == this.moveUp) {
            // Move left keeper up.
            this.canvasDrawerV3.keeperLeft.moveUp();
        } else if (object == this.moveDown) {
            // Move left keeper down.
            this.canvasDrawerV3.keeperLeft.moveDown();
        } else if (object == this.moveLeft) {
            // Move right keeper up.
            this.canvasDrawerV3.keeperRight.moveUp();
        } else if (object == this.moveRight) {
            // Move right keeper down.
            this.canvasDrawerV3.keeperRight.moveDown();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
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