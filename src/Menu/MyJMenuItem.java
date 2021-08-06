package Menu;

import javax.swing.JMenuItem;
import Handlers.*;

@SuppressWarnings("serial")
public class MyJMenuItem extends JMenuItem {

	// Constructor
	public MyJMenuItem(String name, MyHandler handler) {
		super(name);
		this.addActionListener(handler);
		this.setActionCommand(getName());
	}

}
