package sirimul.chattipoom.lab10;

import javax.swing.SwingUtilities;

public class PersonFormV14 extends PersonFormV13 {
    private static final long serialVersionUID = 1L;

    public PersonFormV14(String string) {
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
        PersonFormV14 msw = new PersonFormV14("Person Form V14");
        msw.addComponents();
        msw.addMenus();
        msw.addListeners();
        msw.addKeys();
        msw.setFrameFeatures();
    }
}