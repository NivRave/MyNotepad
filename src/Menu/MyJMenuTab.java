package Menu;

import javax.swing.JMenu;
import Handlers.*;

@SuppressWarnings("serial")
public class MyJMenuTab extends JMenu {

	// Constructor - Event handler
	public MyJMenuTab(String name, MyHandler handler) {
		super(name);
		this.addActionListener(handler);
		this.setActionCommand(name);
	}

	// Constructor - Mouse handler
	public MyJMenuTab(String name, MyMouseListener handler) {
		super(name);
		this.addMouseListener(handler);
		this.setActionCommand(name);
	}
}
