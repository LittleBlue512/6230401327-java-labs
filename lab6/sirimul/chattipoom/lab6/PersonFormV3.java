/**
 * This program is to create a class called PersonFormV3 which extends from class PersonFormV3.
 * 
 * Author: Chattipoom Sirimul
 * ID: 623040132-7
 * Section: 1
 * Date: January 31, 2020
 */

package sirimul.chattipoom.lab6;

import java.awt.Insets;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class PersonFormV3 extends PersonFormV2 {
    // Quick fix warning: Java(536871008)
    private static final long serialVersionUID = 1L;

    // Constant variables.
    private static final String defaultFrameTitle = "PersonFormV3 Title";

    // ---------- Components ----------

    // ---------- ---------- ----------

    public PersonFormV3() {
        super(defaultFrameTitle);
    }

    public PersonFormV3(String _frameTitle) {
        super(_frameTitle);
    }

    @Override
    protected void createComponents() {

    }

    @Override
    protected void addComponents() {

    }

    public static void createAndShowGUI() {
        PersonFormV3 personFormV3 = new PersonFormV3("Person form V3");

        // Initialize components.
        personFormV3.createComponents();

        personFormV3.addComponents();
        personFormV3.setFrameFeatures();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}