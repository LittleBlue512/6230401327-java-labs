package sirimul.chattipoom.lab8;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class PersonFormV7 extends PersonFormV6 implements ActionListener {
    private static final long serialVersionUID = 1L;

    private static final String DEFAULT_FRAME_TITLE = "PersonFormV7 Title";

    public PersonFormV7() {
        super(DEFAULT_FRAME_TITLE);
    }

    public PersonFormV7(String _frameTitle) {
        super(_frameTitle);
    }

    @Override
    protected void addListeners() {
        super.addListeners();
        this.studentRadioBtn.addActionListener(this);
        this.teacherRadioBtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);

        Object obj = e.getSource();

        if (obj == this.studentRadioBtn)
            createDialogFormV7("Student");
        else if (obj == this.teacherRadioBtn)
            createDialogFormV7("Teacher");
    }

    protected void createDialogFormV7(String buttonName) {
        // Get message.
        String message = "Type : " + buttonName + " has been selected";

        // Get Icon
        ImageIcon icon = new ImageIcon(getClass().getResource("images/javaIcon.png"));

        // Show message dialog.
        JOptionPane.showMessageDialog(this, message, "Person Information", JOptionPane.INFORMATION_MESSAGE, icon);
    }

    public static void createAndShowGUI() {
        PersonFormV7 PersonFormV7 = new PersonFormV7("Person form V7");

        PersonFormV7.initComponent();
        PersonFormV7.addMenus();
        PersonFormV7.addListeners();
        PersonFormV7.addComponents();
        PersonFormV7.setFrameFeatures();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}