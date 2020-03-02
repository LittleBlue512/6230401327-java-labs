package sirimul.chattipoom.lab8_imported;

import javax.swing.SwingUtilities;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

/**
 * PersonFormV10
 */
public class PersonFormV10 extends PersonFormV9 {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public PersonFormV10(String string) {
        super(string);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    public static void createAndShowGUI() {
        PersonFormV10 msw = new PersonFormV10("Person Form V10");
        msw.addComponents();
        msw.addMenus();
        msw.addListeners();
        msw.addKeys();
        msw.setFrameFeatures();
    }

    protected void addKeys() {
        redMI.setMnemonic(KeyEvent.VK_R);
        greenMI.setMnemonic(KeyEvent.VK_G);
        blueMI.setMnemonic(KeyEvent.VK_B);
        configMenu.setMnemonic(KeyEvent.VK_C);
        colorMenu.setMnemonic(KeyEvent.VK_L);
        sizeMenu.setMnemonic(KeyEvent.VK_Z);
        size16MI.setMnemonic(KeyEvent.VK_1);
        size20MI.setMnemonic(KeyEvent.VK_0);
        size24MI.setMnemonic(KeyEvent.VK_4);

        redMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
        greenMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK));
        blueMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
        size16MI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.CTRL_MASK));
        size20MI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_0, ActionEvent.CTRL_MASK));
        size24MI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4, ActionEvent.CTRL_MASK));
        // openMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
        // ActionEvent.CTRL_MASK));

    }

    @Override
    protected void addListeners() {
        super.addListeners();
        redMI.addActionListener(this);
        greenMI.addActionListener(this);
        blueMI.addActionListener(this);
        size16MI.addActionListener(this);
        size20MI.addActionListener(this);
        size24MI.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        Object source = e.getSource();
        if (source == redMI) {
            changeColor(Color.RED);
        } else if (source == greenMI) {
            changeColor(Color.GREEN);
        } else if (source == blueMI) {
            changeColor(Color.BLUE);
        } else if (source == size16MI) {
            changeSize(16);
        } else if (source == size20MI) {
            changeSize(20);
        } else if (source == size24MI) {
            changeSize(24);
        }
    }

    protected void changeColor(Color c) {
        nameTxtField.setForeground(c);
        heightTxtField.setForeground(c);
        weightTxtField.setForeground(c);
        dobTxtField.setForeground(c);
        reviewTxtArea.setForeground(c);
    }

    protected void changeSize(int size) {
        // Font label = new Font("Serif", Font.PLAIN, size);
        Font text = new Font("Serif", Font.BOLD, size);
        nameTxtField.setFont(text);
        heightTxtField.setFont(text);
        weightTxtField.setFont(text);
        dobTxtField.setFont(text);
        reviewTxtArea.setFont(text);
    }
}