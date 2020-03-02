package sirimul.chattipoom.lab8_imported;

import javax.swing.*;
import java.awt.event.*;

import sirimul.chattipoom.lab6_imported.PersonFormV5;

/**
 * PersonFormV6
 */
public class PersonFormV6 extends PersonFormV5 implements ActionListener {

    public PersonFormV6(String string) {
        super(string);
    }

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    public static void createAndShowGUI() {
        PersonFormV6 msw = new PersonFormV6("Person Form V6");
        msw.addComponents();
        msw.addMenus();
        msw.addListeners();
        msw.setFrameFeatures();
    }

    protected void addListeners() {
        okButton.addActionListener(this);
        cancelButton.addActionListener(this);
    }

    protected String getInfoFromForm() {
        String info;
        info = "Name : " + nameTxtField.getText() + "\n" + "Height (cm) : " + heightTxtField.getText() + "\n"
                + "Weight (kg) : " + weightTxtField.getText() + "\n" + "Date of Birth : " + dobTxtField.getText()
                + "\n";
        if (student.isSelected())
            info += "Type : Student" + "\n";
        else
            info += "Type : Teacher" + "\n";

        info += "Sports : " + typeBox.getSelectedItem().toString() + "\n";

        info += "Hobbies :";
        if (hobbies.isSelectedIndex(0))
            info += " Reading";
        if (hobbies.isSelectedIndex(1))
            info += " Traveling";
        if (hobbies.isSelectedIndex(2))
            info += " Cooking";
        if (hobbies.isSelectedIndex(3))
            info += " Photography";
        info += "\n";
        info += "Note : " + reviewTxtArea.getText();
        return info;
    }

    protected void handleOkButton() {
        String info = getInfoFromForm();
        JOptionPane.showMessageDialog(this, info, "Person Information", JOptionPane.INFORMATION_MESSAGE);
    }

    protected void handleCancelButton() {
        nameTxtField.setText("");
        heightTxtField.setText("");
        weightTxtField.setText("");
        dobTxtField.setText("");
        reviewTxtArea.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        JDialog dialog = new JDialog();
        dialog.setTitle("Person Information");
        if (source == okButton) {
            handleOkButton();
        } else if (source == cancelButton) {
            handleCancelButton();
        }
    }
}