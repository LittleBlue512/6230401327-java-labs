package sirimul.chattipoom.lab8_imported;

import javax.swing.SwingUtilities;

import java.awt.event.*;
import javax.swing.*;

/**
 * PersonFormV7
 */
public class PersonFormV7 extends PersonFormV6 {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public PersonFormV7(String string) {
        super(string);
        // TODO Auto-generated constructor stub
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    public static void createAndShowGUI() {
        PersonFormV7 msw = new PersonFormV7("Person Form V7");
        msw.addComponents();
        msw.addMenus();
        msw.addListeners();
        msw.setFrameFeatures();
    }

    @Override
    protected void addListeners() {
        super.addListeners();
        student.addActionListener(this);
        teacher.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        Object source = e.getSource();
        if (source == student) {
            JOptionPane.showMessageDialog(this, "Type : student has been selected", "Person Information",
                    JOptionPane.INFORMATION_MESSAGE);
        } else if (source == teacher) {
            JOptionPane.showMessageDialog(this, "Type : teacher has been selected", "Person Information",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
}