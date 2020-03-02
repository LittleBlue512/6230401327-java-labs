package sirimul.chattipoom.lab6_imported;

import java.awt.*;
import javax.swing.*;

public class PersonFormV5 extends PersonFormV4 {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4856657315448982032L;

	/**
	 * 
	 */
	protected Font font14Plain = new Font("Serif", Font.PLAIN, 14);
	protected Font font14Bold = new Font("Serif", Font.BOLD, 14);

	public PersonFormV5(String title) {
		super(title);
	}

	protected void setFonts() {
		nameLabel.setFont(font14Plain);
		heightLabel.setFont(font14Plain);
		weightLabel.setFont(font14Plain);
		dobLabel.setFont(font14Plain);
		typeLabel.setFont(font14Plain);
		reviewLabel.setFont(font14Plain);

		nameTxtField.setFont(font14Bold);
		heightTxtField.setFont(font14Bold);
		weightTxtField.setFont(font14Bold);
		dobTxtField.setFont(font14Bold);

	}

	protected void setColors() {
		cancelButton.setForeground(Color.RED);
		okButton.setForeground(Color.BLUE);
	}

	protected void setValues() {
		nameTxtField.setText("Manee");
		heightTxtField.setText("160");
		weightTxtField.setText("55");
		dobTxtField.setText("02-02-2000");
		student.setSelected(true);
		typeBox.setSelectedIndex(1);
		hobbies.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		int[] selectIndices = { 0, 3 };
		hobbies.setSelectedIndices(selectIndices);
	}

	protected void initComponents() {
		super.initComponents();
		setFonts();
		setColors();
		setValues();
	}

	public static void createAndShowGUI() {
		PersonFormV5 personForm5 = new PersonFormV5("Person Form V5");
		personForm5.addComponents();
		personForm5.addMenus();
		personForm5.setFrameFeatures();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}
