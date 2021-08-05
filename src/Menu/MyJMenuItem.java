package Menu;

import javax.swing.JMenuItem;
import Window.MyJFrame.MyHandler;

@SuppressWarnings("serial")
public class MyJMenuItem extends JMenuItem {

	public MyJMenuItem(String name, MyHandler handler) {
		super(name);
		this.addActionListener(handler);
		this.setActionCommand(getName());
		System.out.println(getName());
	}

}
