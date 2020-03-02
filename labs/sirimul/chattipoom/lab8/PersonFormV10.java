/**
 * This class is to implement ActionListener by changing color and size of text with menuItem.
 * This class is also ingerited from PersonFormV9.
 * 
 * Author: Chattipoom Sirimul
 * ID: 623040132-7
 * Section: 1
 * Date: February 17, 2020
 */

package sirimul.chattipoom.lab8;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

public class PersonFormV10 extends PersonFormV9 {
    private static final long serialVersionUID = 1L;

    private static final String DEFAULT_FRAME_TITLE = "PersonFormV10 Title";

    public PersonFormV10() {
        super(DEFAULT_FRAME_TITLE);
    }

    public PersonFormV10(String _frameTitle) {
        super(_frameTitle);
    }

    @Override
    protected void addListeners() {
        super.addListeners();
        this.redMenuItem.addActionListener(this);
        this.greenMenuItem.addActionListener(this);
        this.blueMenuItem.addActionListener(this);
        this.size16MenuItem.addActionListener(this);
        this.size20MenuItem.addActionListener(this);
        this.size24MenuItem.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        Object obj = e.getSource();

        // Color changing handler.
        if (obj == this.redMenuItem) {
            setFontColor(Color.RED);
        } else if (obj == this.greenMenuItem) {
            setFontColor(Color.GREEN);
        } else if (obj == this.blueMenuItem) {
            setFontColor(Color.BLUE);
        }

        // Size changing handler.
        if (obj == this.size16MenuItem) {
            setFontSize(16);
        } else if (obj == this.size20MenuItem) {
            setFontSize(20);
        } else if (obj == this.size24MenuItem) {
            setFontSize(24);
        }
    }

    protected void setFontColor(Color color) {
        this.nameTextField.setForeground(color);
        this.heightTextField.setForeground(color);
        this.weightTextField.setForeground(color);
        this.dobTextField.setForeground(color);
        this.noteTextArea.setForeground(color);
    }

    protected void setFontSize(int size) {
        Font font = new Font(Font.SERIF, Font.BOLD, size);

        this.nameTextField.setFont(font);
        this.heightTextField.setFont(font);
        this.weightTextField.setFont(font);
        this.dobTextField.setFont(font);
        this.noteTextArea.setFont(font);
    }

    protected void addKeys() {
        // Setting the accelerator.
        this.redMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
        this.greenMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK));
        this.blueMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
        this.size16MenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.CTRL_MASK));
        this.size20MenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_0, ActionEvent.CTRL_MASK));
        this.size24MenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4, ActionEvent.CTRL_MASK));

        // Setting the mnemonic.
        this.redMenuItem.setMnemonic(KeyEvent.VK_R);
        this.greenMenuItem.setMnemonic(KeyEvent.VK_G);
        this.blueMenuItem.setMnemonic(KeyEvent.VK_B);
        this.configMenu.setMnemonic(KeyEvent.VK_C);
        this.newColorMenu.setMnemonic(KeyEvent.VK_L);
        this.newSizeMenu.setMnemonic(KeyEvent.VK_Z);
        this.size16MenuItem.setMnemonic(KeyEvent.VK_1);
        this.size20MenuItem.setMnemonic(KeyEvent.VK_0);
        this.size24MenuItem.setMnemonic(KeyEvent.VK_4);

    }

    public static void createAndShowGUI() {
        PersonFormV10 PersonFormV10 = new PersonFormV10("Person form V10");

        PersonFormV10.initComponent();
        PersonFormV10.addMenus();
        PersonFormV10.addListeners();
        PersonFormV10.addComponents();
        PersonFormV10.addKeys();
        PersonFormV10.setFrameFeatures();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}