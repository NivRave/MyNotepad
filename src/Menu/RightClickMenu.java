package Menu;

import java.awt.event.*;
import javax.swing.JPopupMenu;

import Handlers.MyHandler;
import Window.MyJFrame;

public class RightClickMenu extends MouseAdapter {
	JPopupMenu _menu;
	MyJMenuItem _pop_copy, _pop_cut, _pop_paste, _pop_bold, _pop_mark;
	// Main frame
	MyJFrame window;
	// Action handler
	MyHandler handler;

	public RightClickMenu(MyJFrame window, MyHandler handler) {
		_menu = new JPopupMenu();
		this.window = window;
		this.handler = handler;
		initRcMenu();
	}

	private void initRcMenu() {
		_pop_copy=new MyJMenuItem("Copy",handler);
		_menu.add(_pop_copy);
		_pop_cut=new MyJMenuItem("Cut",handler);
		_menu.add(_pop_cut);
		_pop_paste=new MyJMenuItem("Paste",handler);
		_menu.add(_pop_paste);
		_pop_bold=new MyJMenuItem("Bold",handler);
		_menu.add(_pop_bold);
		_pop_mark=new MyJMenuItem("Mark text",handler);
		_menu.add(_pop_mark);
	}

	public JPopupMenu getMenu() {
		return _menu;
	}
	
}
