package sirimul.chattipoom.lab10;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class PersonFormV12 extends PersonFormV11 {
    private static final long serialVersionUID = 1L;

    ArrayList<Person> persons;

    public PersonFormV12(String string) {
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
        PersonFormV12 msw = new PersonFormV12("Person Form V12");
        msw.addComponents();
        msw.addMenus();
        msw.addListeners();
        msw.addKeys();
        msw.setFrameFeatures();
    }

    @Override
    protected void initComponents() {
        super.initComponents();
        persons = new ArrayList<Person>();
    }

    @Override
    protected void handleOkButton() {
        String info = getInfoFromForm();

        // Create Person's instance.
        Person person = createPerson();

        // Add person to the list.
        persons.add(person);

        info += "\n\nAdding this person into the list:" + person;

        JOptionPane.showMessageDialog(this, info, "Person Information", JOptionPane.INFORMATION_MESSAGE);
    }

    protected Person createPerson() {
        // Get info.
        String personName = nameTxtField.getText();
        double personWeight = Double.valueOf(weightTxtField.getText());
        double personHeight = Double.valueOf(heightTxtField.getText());

        // Get Dob.
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate personDob = LocalDate.parse(dobTxtField.getText(), formatter);

        // Return Person's instance.
        return new Person(personName, personWeight, personHeight, personDob);
    }
}