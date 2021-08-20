package Menu;

import javax.swing.JMenuItem;
import Handlers.*;

@SuppressWarnings("serial")
public class MyJMenuItem extends JMenuItem {

	// Constructor - Event handler
	public MyJMenuItem(String name, MyHandler handler) {
		super(name);
		this.addActionListener(handler);
		this.setActionCommand(getName());
	}

	// Constructor - Mouse handler
	public MyJMenuItem(String name, MyMouseListener handler) {
		super(name);
		this.addMouseListener(handler);
		this.setActionCommand(getName());
	}
}