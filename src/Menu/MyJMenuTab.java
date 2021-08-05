package Menu;

import javax.swing.JMenu;
import Window.MyJFrame.MyHandler;

@SuppressWarnings("serial")
public class MyJMenuTab extends JMenu {
	public MyJMenuTab(String name, MyHandler handler) {
		super(name);
		this.addActionListener(handler);
		this.setActionCommand(name);
	}

}
