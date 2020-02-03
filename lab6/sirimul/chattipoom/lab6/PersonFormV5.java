/**
 * This program is to create a class called PersonFormV5 which extends from class PersonFormV4.
 * 
 * Author: Chattipoom Sirimul
 * ID: 623040132-7
 * Section: 1
 * Date: February 3, 2020
 */

package sirimul.chattipoom.lab6;

import java.awt.Font;
import java.awt.Color;

import javax.swing.SwingUtilities;

public class PersonFormV5 extends PersonFormV4 {
    // Quick fix warning: Java(536871008)
    private static final long serialVersionUID = 1L;

    // Constant variables.
    private static final String defaultFrameTitle = "PersonFormV5 Title";

    // Class's variables
    protected Font serifPlain14 = new Font(Font.SERIF, Font.PLAIN, 14);
    protected Font serifBold14 = new Font(Font.SERIF, Font.BOLD, 14);

    // ---------- Components ----------

    // ---------- --------------------

    public PersonFormV5() {
        super(defaultFrameTitle);
    }

    public PersonFormV5(String _frameTitle) {
        super(_frameTitle);
    }

    protected void setFonts() {
        this.nameLabel.setFont(serifPlain14);
        this.heightLabel.setFont(serifPlain14);
        this.weightLabel.setFont(serifPlain14);
        this.dobLabel.setFont(serifPlain14);
        this.typeLabel.setFont(serifPlain14);
        this.sportLabel.setFont(serifPlain14);
        this.hobbyLabel.setFont(serifPlain14);
        this.noteLabel.setFont(serifPlain14);

        this.teacherRadioBtn.setFont(serifPlain14);
        this.studentRadioBtn.setFont(serifPlain14);

        this.sportComboBox.setFont(serifPlain14);
        this.hobbyList.setFont(serifPlain14);

        this.nameTextField.setFont(serifBold14);
        this.heightTextField.setFont(serifBold14);
        this.weightTextField.setFont(serifBold14);
        this.dobTextField.setFont(serifBold14);

        this.noteTextArea.setFont(serifBold14);
    }

    protected void setColors() {
        this.okButton.setForeground(Color.BLUE);
        this.cancelButton.setForeground(Color.RED);
    }

    protected void setValues() {
        this.nameTextField.setText("Manee");
        this.heightTextField.setText("160");
        this.weightTextField.setText("55");
        this.dobTextField.setText("02-02-2000");

        this.studentRadioBtn.setSelected(true);

        this.sportComboBox.setSelectedIndex(1);

        this.hobbyList.setSelectedIndices(new int[] { 0, 3 });
    }

    @Override
    protected void initComponent() {
        super.initComponent();
        setFonts();
        setColors();
        setValues();
    }

    @Override
    protected void addComponents() {
        super.addComponents();
    }

    public static void createAndShowGUI() {
        PersonFormV5 personFormV5 = new PersonFormV5("Person form V5");

        // Initialize components.
        personFormV5.initComponent();

        // Add menu
        personFormV5.addMenus();

        personFormV5.addComponents();
        personFormV5.setFrameFeatures();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
