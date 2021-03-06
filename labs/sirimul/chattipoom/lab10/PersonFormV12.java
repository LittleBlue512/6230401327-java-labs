/**
 * This class is to implement the "Data" menu item.
 * This class is also extended from PersonFormV11.
 * 
 * Author: Chattipoom Sirimul
 * ID: 623040132-7
 * Section: 1
 * Date: March 2, 2020
 */

package sirimul.chattipoom.lab10;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.event.ActionEvent;
import java.time.format.DateTimeFormatter;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class PersonFormV12 extends PersonFormV11 {
    private static final long serialVersionUID = 1L;

    protected JMenu dataMenu;
    protected JMenuItem displayMI, sortMI, searchMI, removeMI;
    protected ArrayList<Person> personList;

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
        personList = new ArrayList<Person>();
    }

    @Override
    protected void addMenus() {
        super.addMenus();

        dataMenu = new JMenu("Data");
        displayMI = new JMenuItem("Display");
        sortMI = new JMenuItem("Sort");
        searchMI = new JMenuItem("Search");
        removeMI = new JMenuItem("Remove");

        dataMenu.add(displayMI);
        dataMenu.add(sortMI);
        dataMenu.add(searchMI);
        dataMenu.add(removeMI);

        menuBar.add(dataMenu);
    }

    @Override
    protected void addListeners() {
        super.addListeners();

        displayMI.addActionListener(this);
        sortMI.addActionListener(this);
        searchMI.addActionListener(this);
        removeMI.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        Object source = e.getSource();

        if (source == displayMI) {
            handleDisplayMI();
        } else if (source == sortMI) {
            handleSortMI();
        } else if (source == searchMI) {
            handleSearchMI();
        } else if (source == removeMI) {
            handleRemoveMI();
        }
    }

    @Override
    protected void handleOkButton() {
        String info = getInfoFromForm();

        // Create Person's instance.
        Person person = createPerson();

        // Add person to the list.
        personList.add(person);

        info += "\n\nAdding this person into the list:" + person;

        JOptionPane.showMessageDialog(this, info, "Person Information", JOptionPane.INFORMATION_MESSAGE);
    }

    protected void handleDisplayMI() {
        showPersonList();
    }

    protected void handleSortMI() {
        Collections.sort(personList);
        showPersonList();
    }

    protected void handleSearchMI() {
        String name = JOptionPane.showInputDialog("Please enter a person name to search:");

        // Cancel button was pressed.
        if (name == null) {
            return;
        }

        // Name is empty.
        if (name.equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter the person's name.");
            return;
        }

        Person person = searchPerson(name);
        if (person != null) {
            JOptionPane.showMessageDialog(this, person + " is found.");
        } else {
            JOptionPane.showMessageDialog(this, name + " is not found.");
        }
    }

    protected void handleRemoveMI() {
        String name = JOptionPane.showInputDialog("Please enter a person name to remove.");

        // Cancel button was pressed.
        if (name == null) {
            return;
        }

        // Name is empty.
        if (name.equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter the person's name.");
            return;
        }

        Person person = searchPerson(name);
        if (person != null) {
            personList.remove(person);
            JOptionPane.showMessageDialog(this, person + " is removed.");
        } else {
            JOptionPane.showMessageDialog(this, name + " is not found.");
        }
    }

    protected Person searchPerson(String name) {
        for (Person person : personList) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }

    protected void showPersonList() {
        String message = "";
        for (Person person : personList) {
            message += person + "\n";
        }
        JOptionPane.showMessageDialog(this, message);
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