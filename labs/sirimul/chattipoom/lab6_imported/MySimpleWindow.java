package sirimul.chattipoom.lab6_imported;

/**
 * This program MySimpleWindow is a superclass for all other classes with these requirements 
 * - Declare three variables (for a panel and two buttons) as instance variables with the 
 *   access level as protected so that these variables can be reused in their subclasses 
 *   which may be  in different packages.
 * - Implement method protected void  addComponents(), you need to add two buttons whose names 
 *   are “Cancel” and “Button” 
 * - Implement method protected  protected void setFrameFeatures()  which performs these tasks
 *     Set the window title with the given title
 *     Set the window location at the center of the screen
 *     Set the window visible
 *     Exit the application using the System exit method when the user initiates a "close" 
 *     on this frame
 *     
 * @author: Kanda Saikaew
 * @date:  19/01/2020
 * @version: 1.0
 */

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MySimpleWindow extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6029172243670358973L;

	protected JButton cancelButton, okButton;
	protected JPanel buttonsPanel;

	public MySimpleWindow(String title) {
		super(title);
	}

	protected void addComponents() {
		cancelButton = new JButton("Cancel");
		okButton = new JButton("OK");
		buttonsPanel = new JPanel();
		buttonsPanel.add(cancelButton);
		buttonsPanel.add(okButton);
		this.setContentPane(buttonsPanel);
	}

	protected void setFrameFeatures() {
		pack();
		setLocationRelativeTo(null);
		setDefaultLookAndFeelDecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

	public static void createAndShowGUI() {
		MySimpleWindow msw = new MySimpleWindow("My Simple Window");
		msw.addComponents();
		msw.setFrameFeatures();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}
