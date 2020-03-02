package sirimul.chattipoom.lab6_imported;

import javax.swing.*;

public class PersonFormV4 extends PersonFormV3 {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	protected JMenu colorMenu, sizeMenu;
	protected JMenuItem redMI, greenMI, blueMI, size16MI, size20MI, size24MI;

	public PersonFormV4(String title) {
		super(title);
	}

	protected void updateMenuIcon() {
		fileMenu.remove(newMI);
		ImageIcon newImgIcon = new ImageIcon("images/new.jpg");
		newMI = new JMenuItem("New", newImgIcon);
		fileMenu.add(newMI);
		fileMenu.remove(openMI);
		fileMenu.add(openMI);
		fileMenu.remove(saveMI);
		fileMenu.add(saveMI);
		fileMenu.remove(exitMI);
		fileMenu.add(exitMI);
	}

	protected void addSubMenus() {
		redMI = new JMenuItem("Red");
		greenMI = new JMenuItem("Green");
		blueMI = new JMenuItem("Blue");

		configMenu.remove(colorMI);
		colorMenu = new JMenu("Color");
		colorMenu.add(redMI);
		colorMenu.add(greenMI);
		colorMenu.add(blueMI);

		size16MI = new JMenuItem("16");
		size20MI = new JMenuItem("20");
		size24MI = new JMenuItem("24");
		configMenu.remove(sizeMI);
		sizeMenu = new JMenu("Size");
		sizeMenu.add(size16MI);
		sizeMenu.add(size20MI);
		sizeMenu.add(size24MI);

		configMenu.add(colorMenu);
		configMenu.add(sizeMenu);
	}

	protected void addMenus() {
		super.addMenus();
		updateMenuIcon();
		addSubMenus();
	}

	public static void createAndShowGUI() {
		PersonFormV4 personForm4 = new PersonFormV4("Person Form V4");
		personForm4.addComponents();
		personForm4.addMenus();
		personForm4.setFrameFeatures();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}
