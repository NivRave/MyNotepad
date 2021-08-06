package Menu;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import Window.*;
import Handlers.*;

@SuppressWarnings("serial")
public class MyMenu extends JMenuBar {
	MyJMenuTab _file, _edit, _format, _view;
	// File menu items
	JMenuItem _file_new, _file_open, _file_save, _file_saveAs, _file_exit;
	// Format menu items
	JMenuItem _format_wrap, _format_font_Arial, _format_font_TimesNewRoman, _format_fontSize_8, _format_fontSize_12,
			_format_fontSize_16, _format_fontSize_20, _format_fontSize_24, _format_fontSize_28;
	MyJMenuTab _format_font, _format_fontSize;
	// View menu items
	JMenuItem _view_lightMode, _view_darkMode;
	// Edit menu items
	JMenuItem _edit_undo, _edit_redo;

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
		initEditMenu();
		initFormatMenu();
		initViewMenu();
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

	public void initFormatMenu() {
		_format_wrap = new MyJMenuItem("Word Wrap", handler);
		_format.add(_format_wrap);
		_format_font = new MyJMenuTab("Font", handler);
		_format.add(_format_font);
		_format_fontSize = new MyJMenuTab("Font Size", handler);
		_format.add(_format_fontSize);
		initFontOptions();
	}

	public void initFontOptions() {
		// Font-type items
		_format_font_Arial = new MyJMenuItem("Arial", handler);
		_format_font.add(_format_font_Arial);
		_format_font_TimesNewRoman = new MyJMenuItem("Times New Roman", handler);
		_format_font.add(_format_font_TimesNewRoman);
		// Font-size items
		_format_fontSize_8 = new MyJMenuItem("8", handler);
		_format_fontSize.add(_format_fontSize_8);
		_format_fontSize_12 = new MyJMenuItem("12", handler);
		_format_fontSize.add(_format_fontSize_12);
		_format_fontSize_16 = new MyJMenuItem("16", handler);
		_format_fontSize.add(_format_fontSize_16);
		_format_fontSize_20 = new MyJMenuItem("20", handler);
		_format_fontSize.add(_format_fontSize_20);
		_format_fontSize_24 = new MyJMenuItem("24", handler);
		_format_fontSize.add(_format_fontSize_24);
		_format_fontSize_28 = new MyJMenuItem("28", handler);
		_format_fontSize.add(_format_fontSize_28);
	}

	public void initEditMenu() {
		_edit_undo = new MyJMenuItem("Undo", handler);
		_edit.add(_edit_undo);
		_edit_redo = new MyJMenuItem("Redo", handler);
		_edit.add(_edit_redo);
	}

	public void initViewMenu() {
		_view_lightMode = new MyJMenuItem("lightMode", handler);
		_view.add(_view_lightMode);
		_view_darkMode = new MyJMenuItem("darkMode", handler);
		_view.add(_view_darkMode);
	}

}
