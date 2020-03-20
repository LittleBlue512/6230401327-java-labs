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
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
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

    @Override
    protected void openFileDialog() {
        // Show file chooser open dialog.
        int result = fileChooser.showOpenDialog(this);

        // Check if the user press the "Open" button.
        if (result == JFileChooser.APPROVE_OPTION) {
            // User selected a file.
            File file = fileChooser.getSelectedFile();

            // Check if the file is a text file.
            String fileExtension = getFileExtension(file);
            if (!fileExtension.equals("txt") || fileExtension.equals("")) {
                JOptionPane.showMessageDialog(this, "Error: Cannot open file. The selected file must be text file.");
                return;
            }

            // Show openning message.
            JOptionPane.showMessageDialog(this, String.format("Opening file %s", file.getName()));

            try {
                Scanner fileReader = new Scanner(file);
                String data = "";

                // Read file.
                while (fileReader.hasNextLine()) {
                    data += fileReader.nextLine() + "\n";
                }
                fileReader.close();

                // Show data.
                JOptionPane.showMessageDialog(this, data);

            } catch (FileNotFoundException ex) {
                System.out.println("File not found.");
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

            // Check if the file is a text file.
            String fileExtension = getFileExtension(file);
            if (!fileExtension.equals("txt") || fileExtension.equals("")) {
                JOptionPane.showMessageDialog(this, "Error: Cannot save file. The selected file must be text file.");
                return;
            }

            // Show saving message.
            JOptionPane.showMessageDialog(this, String.format("Saving file %s", file.getName()));

            try {
                FileWriter fileWriter = new FileWriter(file);

                // Write file
                for (Person person : personList) {
                    fileWriter.write(person.toString() + "\n");
                }
                fileWriter.close();

                // Create file.
                file.createNewFile();
            } catch (IOException ex) {
                System.out.println("An error occured");
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