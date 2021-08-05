package Menu;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import Window.*;
import Window.MyJFrame.MyHandler;

@SuppressWarnings("serial")
public class MyMenu extends JMenuBar {
	MyJMenuTab _file, _edit, _format, _view;
	JMenuItem _file_new, _file_open, _file_save, _file_saveAs, _file_exit;
	MyJFrame window;
	MyHandler handler;

	public MyMenu(MyJFrame window, MyHandler handler) {
		super();
		this.window = window;
		this.handler = handler;
		initMenuOptions();
		initMenuItems();
	}

	private void initMenuOptions() {
		_file = new MyJMenuTab("File", handler);
		add(_file);
		_edit = new MyJMenuTab("Edit", handler);
		add(_edit);
		_format = new MyJMenuTab("Format", handler);
		add(_format);
		_view = new MyJMenuTab("View", handler);
		add(_view);
	}

	// Init menu tabs items
	public void initMenuItems() {
		initFileMenu();
	}

	// Init file menu items
	public void initFileMenu() {
		_file_new = new MyJMenuItem("New", handler);
		_file.add(_file_new);
		_file_open = new MyJMenuItem("Open", handler);
		_file.add(_file_open);
		_file_save = new MyJMenuItem("Save", handler);
		_file.add(_file_save);
		_file_saveAs = new MyJMenuItem("Save As...", handler);
		_file.add(_file_saveAs);
		_file_exit = new MyJMenuItem("Exit", handler);
		_file.add(_file_exit);
	}

	public void initEditMenu() {

	}

	public void initFormatMenu() {

	}

	public void initViewMenu() {

	}

}
