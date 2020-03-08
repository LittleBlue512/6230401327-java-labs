/**
 * This class is to validate the inputs.
 * This class is also extended from PersonFormV12.
 * 
 * Author: Chattipoom Sirimul
 * ID: 623040132-7
 * Section: 1
 * Date: March 8, 2020
 */

package sirimul.chattipoom.lab10;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class PersonFormV13 extends PersonFormV12 {
    private static final long serialVersionUID = -350854227662016279L;

    // Constant variables.
    protected static final double MIN_HEIGHT = 100.00f, MAX_HEIGHT = 250.00f, MIN_WEIGHT = 40.00f, MAX_WEIGHT = 150.00f,
            MIN_DAY = 1.00f, MAX_DAY = 31.00f, MIN_MONTH = 1.00f, MAX_MONTH = 12.00f, MIN_YEAR = 1900.00f,
            MAX_YEAR = 2010.00f;

    public PersonFormV13(String string) {
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
        PersonFormV13 msw = new PersonFormV13("Person Form V13");
        msw.addComponents();
        msw.addMenus();
        msw.addListeners();
        msw.addKeys();
        msw.setFrameFeatures();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        // Check inputs.
        if (source == okButton) {
            if (!isInputValid())
                return;
        }

        super.actionPerformed(e);
    }

    protected Boolean isInputValid() {
        String message = "";

        // Check name.
        if (nameTxtField.getText().equals("")) {
            message += "Please enter name.\n";
        }

        // Check height.
        if (heightTxtField.getText().equals("")) {
            message += "Please enter height.\n";
        } else {
            try {
                double height = Double.parseDouble(heightTxtField.getText());

                // Check range of height.
                if (!checkDecimalException(height, MIN_HEIGHT, MAX_HEIGHT))
                    message += String.format("Valid values for height are [%.2f, %.2f]\n", MIN_HEIGHT, MAX_HEIGHT);
            } catch (NumberFormatException ex) {
                message += "Please enter only numeric input for height\n";
            }
        }

        // Check weight.
        if (weightTxtField.getText().equals("")) {
            message += "Please enter weight.\n";
        } else {
            try {
                double weight = Double.parseDouble(weightTxtField.getText());

                // Check range of weight.
                if (!checkDecimalException(weight, MIN_WEIGHT, MAX_WEIGHT))
                    message += String.format("Valid values for weight are [%.2f, %.2f]\n", MIN_WEIGHT, MAX_WEIGHT);
            } catch (NumberFormatException ex) {
                message += "Please enter only numeric input for weight\n";
            }
        }

        // Check date.
        if (dobTxtField.getText().equals("")) {
            message += "Please enter date.\n";
        } else {
            String[] temp = dobTxtField.getText().split("-");

            // Check if the values are numeric.
            try {
                double day = Double.parseDouble(temp[0]);
                double month = Double.parseDouble(temp[1]);
                double year = Double.parseDouble(temp[2]);

                // Check if the values are in range.
                if (!checkDecimalException(day, MIN_DAY, MAX_DAY))
                    message += String.format("Valid values for day are [%.2f, %.2f]\n", MIN_DAY, MAX_DAY);
                if (!checkDecimalException(month, MIN_MONTH, MAX_MONTH))
                    message += String.format("Valid values for month are [%.2f, %.2f]\n", MIN_MONTH, MAX_MONTH);
                if (!checkDecimalException(year, MIN_YEAR, MAX_YEAR))
                    message += String.format("Valid values for year are [%.2f, %.2f]\n", MIN_YEAR, MAX_YEAR);
            } catch (NumberFormatException ex) {
                message += "Date of birth is invalid.\n";
            }
        }

        // Return true if there aren't any errors.
        if (message == "")
            return true;

        JOptionPane.showMessageDialog(this, message);
        return false;
    }

    protected Boolean checkDecimalException(double num, double min, double max) {
        return num >= min && num <= max;
    }
}