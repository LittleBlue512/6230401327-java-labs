/**
 * This class is to implement ActionListener by showing a dialog window when the ok button is pressed.
 * And close the window when the cancel button is pressed.
 * 
 * Author: Chattipoom Sirimul
 * ID: 623040132-7
 * Section: 1
 * Date: February 17, 2020
 */

package sirimul.chattipoom.lab8;

import sirimul.chattipoom.lab6.PersonFormV5;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class PersonFormV6 extends PersonFormV5 implements ActionListener {
    private static final long serialVersionUID = 1L;

    // Constant variables.
    private static final String DEFAULT_FRAME_TITLE = "PersonFormV6 Title";

    // Class's variable.
    public static ImageIcon icon;

    public PersonFormV6() {
        super(DEFAULT_FRAME_TITLE);
    }

    public PersonFormV6(String _frameTitle) {
        super(_frameTitle);
    }

    protected void createDialogFormV6() {
        String message = "";

        String name = "Name : " + this.nameTextField.getText();

        String height = "Height (cm) : " + this.heightTextField.getText();

        String weight = "Weight (kg) : " + this.weightTextField.getText();

        String dob = "Date of Birth : " + this.dobTextField.getText();

        String type = "Type : ";
        if (this.studentRadioBtn.isSelected())
            type += "Student";
        else if (this.teacherRadioBtn.isSelected())
            type += "Teacher";

        String sport = "Sport : " + this.sportComboBox.getSelectedItem().toString();

        // Get multiple selected values from JList.
        String hobbies = "Hobbies : ";
        int[] hobbiesIndeces = this.hobbyList.getSelectedIndices();
        for (int index : hobbiesIndeces)
            hobbies += PersonFormV6.hobbies[index] + " ";

        String note = "Note : " + this.noteTextArea.getText();

        message = String.join("\n", name, height, weight, dob, type, sport, hobbies, note);

        JOptionPane.showMessageDialog(this, message, "Person Information", JOptionPane.INFORMATION_MESSAGE, icon);
    }

    protected void clearValues() {
        this.nameTextField.setText("");
        this.heightTextField.setText("");
        this.weightTextField.setText("");
        this.dobTextField.setText("");
        this.noteTextArea.setText("");
    }

    protected void addListeners() {
        this.okButton.addActionListener(this);
        this.cancelButton.addActionListener(this);
    }

    @Override
    protected void initComponent() {
        super.initComponent();

        // Get icon.
        icon = new ImageIcon(getClass().getResource("images/javaIcon.png"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == this.okButton)
            createDialogFormV6();
        else if (obj == this.cancelButton)
            clearValues();
    }

    public static void createAndShowGUI() {
        PersonFormV6 PersonFormV6 = new PersonFormV6("Person form V6");

        PersonFormV6.initComponent();
        PersonFormV6.addMenus();
        PersonFormV6.addListeners();
        PersonFormV6.addComponents();
        PersonFormV6.setFrameFeatures();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}