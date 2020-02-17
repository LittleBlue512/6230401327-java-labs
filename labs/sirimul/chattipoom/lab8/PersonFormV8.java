package sirimul.chattipoom.lab8;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class PersonFormV8 extends PersonFormV7 implements ActionListener {
    private static final long serialVersionUID = 1L;

    private static final String DEFAULT_FRAME_TITLE = "PersonFormV8 Title";

    public PersonFormV8() {
        super(DEFAULT_FRAME_TITLE);
    }

    public PersonFormV8(String _frameTitle) {
        super(_frameTitle);
    }

    @Override
    protected void addListeners() {
        super.addListeners();

        this.sportComboBox.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);

        Object obj = e.getSource();

        if (obj == this.sportComboBox) {
            // Type casting: Object -> String
            String sportName = (String) this.sportComboBox.getSelectedItem();

            // Create dialog window.
            createDialogFormV8(sportName);
        }
    }

    protected void createDialogFormV8(String sportName) {
        String message = "Your sport is now changed to " + sportName;

        JOptionPane.showMessageDialog(this, message, "Person Information", JOptionPane.INFORMATION_MESSAGE,
                PersonFormV6.icon);
    }

    public static void createAndShowGUI() {
        PersonFormV8 PersonFormV8 = new PersonFormV8("Person form V8");

        PersonFormV8.initComponent();
        PersonFormV8.addMenus();
        PersonFormV8.addListeners();
        PersonFormV8.addComponents();
        PersonFormV8.setFrameFeatures();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}