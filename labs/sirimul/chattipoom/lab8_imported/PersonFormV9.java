package sirimul.chattipoom.lab8_imported;

import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import javax.swing.*;

/**
 * PersonFormV9
 */
public class PersonFormV9 extends PersonFormV8 implements ListSelectionListener {

    ListSelectionModel list;
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public PersonFormV9(String string) {
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
        PersonFormV9 msw = new PersonFormV9("Person Form V9");
        msw.addComponents();
        msw.addMenus();
        msw.addListeners();
        msw.setFrameFeatures();
    }

    @Override
    protected void addListeners() {
        super.addListeners();
        list = hobbies.getSelectionModel();
        list.addListSelectionListener(this);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        ListSelectionModel list = (ListSelectionModel) e.getSource();
        boolean isAdjusting = e.getValueIsAdjusting();
        if (!isAdjusting) {
            if (list.isSelectionEmpty()) {
                JOptionPane.showMessageDialog(this, "No hoby is selected", "Person Information",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                String s = "Selected Hobbies : ";
                int min = list.getMinSelectionIndex();
                int max = list.getMaxSelectionIndex();
                for (int i = min; i <= max; i++) {
                    if (hobbies.isSelectedIndex(i))
                        s += hobbies.getModel().getElementAt(i).toString() + " ";
                }
                JOptionPane.showMessageDialog(this, s, "Person Information", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}