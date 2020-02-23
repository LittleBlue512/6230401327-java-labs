/**
 * This class is to implement ListSelectionListener by showing a dialog window when the List is being selected.
 * This class is also ingerited from PersonFormV8.
 * 
 * Author: Chattipoom Sirimul
 * ID: 623040132-7
 * Section: 1
 * Date: February 17, 2020
 */

package sirimul.chattipoom.lab8;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class PersonFormV9 extends PersonFormV8 implements ListSelectionListener {
    private static final long serialVersionUID = 1L;

    private static final String DEFAULT_FRAME_TITLE = "PersonFormV9 Title";

    public PersonFormV9() {
        super(DEFAULT_FRAME_TITLE);
    }

    public PersonFormV9(String _frameTitle) {
        super(_frameTitle);
    }

    @Override
    protected void addListeners() {
        super.addListeners();
        this.hobbyList.addListSelectionListener(this);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        Object obj = e.getSource();
        if (obj == this.hobbyList) {
            // Check if the specified event is the final one in the chain.
            // I want "mouse up" event, not "mouse down" event.
            if (!e.getValueIsAdjusting()) {
                createDialogFormV9();
            }
        }
    }

    protected void createDialogFormV9() {
        String message = "Selected Hobbies : ";

        // Get selected indices.
        int[] hobbiesIndices = this.hobbyList.getSelectedIndices();

        // Loop through each index in selected indices.
        for (int index : hobbiesIndices)
            message += hobbies[index] + " ";

        JOptionPane.showMessageDialog(this, message, "Person Information", JOptionPane.INFORMATION_MESSAGE,
                PersonFormV6.icon);
    }

    public static void createAndShowGUI() {
        PersonFormV9 PersonFormV9 = new PersonFormV9("Person form V9");

        PersonFormV9.initComponent();
        PersonFormV9.addMenus();
        PersonFormV9.addListeners();
        PersonFormV9.addComponents();
        PersonFormV9.setFrameFeatures();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}