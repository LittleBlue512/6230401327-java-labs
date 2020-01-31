/**
 * This program is to create a class called PersonFormV2 which extends from class PersonFormV1.
 * 
 * Author: Chattipoom Sirimul
 * ID: 623040132-7
 * Section: 1
 * Date: January 30, 2020
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

public class PersonFormV2 extends PersonFormV1 {
    // Quick fix warning: Java(536871008)
    private static final long serialVersionUID = 1L;

    // Constant variables.
    private static final String defaultFrameTitle = "PersonFormV2 Title";

    // Class's variables
    private static String[] sports = { "Running", "Swimimg", "Tennis" }; // <----- Will make this editable!!!

    // ---------- Components ----------
    protected JComboBox<String> sportComboBox;
    protected JLabel sportLabel;
    protected JLabel noteLabel;
    protected JTextArea noteTextArea;
    protected JPanel formPanelV2;
    protected JPanel notePanel;
    protected JScrollPane noteScrollPane;
    // ---------- ---------- ----------

    public PersonFormV2() {
        super(defaultFrameTitle);
    }

    public PersonFormV2(String _frameTitle) {
        super(_frameTitle);
    }

    @Override
    protected void createComponents() {
        super.createComponents();

        this.sportComboBox = new JComboBox<String>(sports);
        this.sportLabel = new JLabel("Sports:");
        this.noteLabel = new JLabel("Note:");
        this.formPanelV2 = new JPanel(new GridBagLayout());
        this.notePanel = new JPanel(new GridBagLayout());
        this.noteTextArea = new JTextArea(2, 35);
        this.noteScrollPane = new JScrollPane(this.noteTextArea);

        this.noteTextArea.setLineWrap(true);
        this.noteTextArea.setWrapStyleWord(true);
    }

    @Override
    protected void addComponents() {
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.weighty = 1.0;
        gbc.weightx = 1.0;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Add noteLabel and noteScrollPane to notePanel.
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridy = 0;
        gbc.gridx = 0;
        this.notePanel.add(this.noteLabel, gbc);
        gbc.gridy = 1;
        gbc.gridx = 0;
        this.notePanel.add(this.noteScrollPane, gbc);

        // Add notePanel to end panel.
        this.endPanel.add(this.notePanel);

        super.addComponents();

        // Add sportLabel and sportComboBox to fromPanelV2.
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.WEST;
        this.formPanelV2.add(this.sportLabel, gbc);
        gbc.gridy = 0;
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.EAST;
        this.formPanelV2.add(this.sportComboBox, gbc);

        // Add from panel to center panel.
        this.centerPanel.add(this.formPanelV2);
    }

    public static void createAndShowGUI() {
        PersonFormV2 personFormV2 = new PersonFormV2("Person form V2");

        // Initialize components.
        personFormV2.createComponents();

        personFormV2.addComponents();
        personFormV2.setFrameFeatures();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}