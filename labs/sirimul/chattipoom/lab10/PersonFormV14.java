/**
 * This class is to implement open/save function.
 * The program saves String data to a text file and also read String from a text file.
 * 
 * Author: Chattipoom Sirimul
 * ID: 623040132-7
 * Section: 1
 * Date: March 20, 2020
 */

package sirimul.chattipoom.lab10;

import java.io.File;
import java.util.ArrayList;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;

public class PersonFormV14 extends PersonFormV13 {
    private static final long serialVersionUID = 1L;

    protected static final String FILE_EXTENSION = "well";
    protected static final String FILE_EXTENSION_ERR = "Error: Cannot save file. The selected file must be a \"well\" file.";

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

    @Override
    @SuppressWarnings("unchecked")
    protected void openFileDialog() {
        // Show file chooser open dialog.
        int result = fileChooser.showOpenDialog(this);

        // Check if the user press the "Open" button.
        if (result == JFileChooser.APPROVE_OPTION) {
            // User selected a file.
            File file = fileChooser.getSelectedFile();

            // Check the file's extension.
            String fileExtension = getFileExtension(file);
            if (!fileExtension.equals(FILE_EXTENSION) || fileExtension.equals("")) {
                JOptionPane.showMessageDialog(this, FILE_EXTENSION_ERR);
                return;
            }

            // Show openning message.
            JOptionPane.showMessageDialog(this, String.format("Opening file %s", file.getName()));

            // Read file.
            try {
                FileInputStream fileIn = new FileInputStream(file);
                ObjectInputStream objectIn = new ObjectInputStream(fileIn);
                personList = (ArrayList<Person>) objectIn.readObject();
                objectIn.close();
                fileIn.close();
                System.out.println("File loaded.");

                // Display data.
                showPersonList();
            } catch (Exception ex) {
                System.out.println("Error: cannot read the file.");
            }
        } else if (result == JFileChooser.CANCEL_OPTION) {
            // User cancelled.
            JOptionPane.showMessageDialog(this, "Open commnad cencelled by user.");
        }
    }

    @Override
    protected void saveFileDialog() {
        // Show file chooser save dialog.
        int result = fileChooser.showSaveDialog(this);

        // Check if the user press the "Save" button.
        if (result == JFileChooser.APPROVE_OPTION) {
            // User saved a file.
            File file = fileChooser.getSelectedFile();

            // Check the file's extension.
            String fileExtension = getFileExtension(file);
            if (!fileExtension.equals(FILE_EXTENSION) || fileExtension.equals("")) {
                JOptionPane.showMessageDialog(this, FILE_EXTENSION_ERR);
                return;
            }

            // Show saving message.
            JOptionPane.showMessageDialog(this, String.format("Saving file %s", file.getName()));

            // Write file.
            try {
                FileOutputStream fileOut = new FileOutputStream(file);
                ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
                objectOut.writeObject(personList);
                objectOut.close();
                fileOut.close();
                System.out.println("File saved.");
            } catch (IOException ex) {
                System.out.println("Error: cannot write the file.");
            }
        } else if (result == JFileChooser.CANCEL_OPTION) {
            // User cancelled.
            JOptionPane.showMessageDialog(this, "Save command cancelled by user.");
        }
    }

    protected String getFileExtension(File file) {
        String fileName = file.getName();
        int dotIndex = fileName.lastIndexOf(".");
        if (dotIndex != -1)
            return fileName.substring(dotIndex + 1);
        return "";
    }
}