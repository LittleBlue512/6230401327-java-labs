/**
 * This class is to change the text fields color by choosing a color from the color chooser.
 * This class also extended from PersonFormV10.
 * 
 * Author: Chattipoom Sirimul
 * ID: 623040132-7
 * Section: 1
 * Date: March 2, 2020
 */

package sirimul.chattipoom.lab10;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JMenuItem;
import javax.swing.BorderFactory;
import javax.swing.JColorChooser;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import sirimul.chattipoom.lab8_imported.PersonFormV10;

public class PersonFormV11 extends PersonFormV10 implements ChangeListener {
    private static final long serialVersionUID = 1L;

    protected JMenuItem customMI;
    protected JColorChooser colorChooser;
    protected JDialog chooserDialog;
    protected ActionListener okListener, cancelListener;

    public PersonFormV11(String string) {
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
        PersonFormV11 msw = new PersonFormV11("Person Form V11");
        msw.addComponents();
        msw.addMenus();
        msw.addListeners();
        msw.addKeys();
        msw.setFrameFeatures();
    }

    @Override
    protected void initComponents() {
        super.initComponents();
        customMI = new JMenuItem("Custom");
        colorChooser = new JColorChooser(Color.BLACK);

        // Create color chooser.
        colorChooser = new JColorChooser(Color.black);
        colorChooser.getSelectionModel().addChangeListener(this);
        colorChooser.setBorder(BorderFactory.createTitledBorder("Color Chooser"));

        // Create listeners.
        okListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle the "OK" button in the color chooser.
                System.out.println("OK Button");
            }
        };

        cancelListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle the "Cancel" button in the color chooser.
                System.out.println("Cancel Button");
            }
        };

        // Create dialog.
        chooserDialog = JColorChooser.createDialog(this, "Color Chooser", false, colorChooser, okListener,
                cancelListener);
    }

    @Override
    protected void addSubMenus() {
        super.addSubMenus();
        colorMenu.add(customMI);
    }

    @Override
    protected void addListeners() {
        super.addListeners();
        customMI.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        Object source = e.getSource();
        if (source == customMI) {
            // Show color chooser dialog.
            chooserDialog.setVisible(true);
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        // Get the selected color from the color chooser.
        Color selectedColor = colorChooser.getColor();

        // Change the text fields color.
        changeColor(selectedColor);
    }
}