package Menu;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import Window.*;
import Handlers.*;

@SuppressWarnings("serial")
public class MyMenu extends JMenuBar {
	// Main frame
	MyJFrame window;
	// Action handler
	MyHandler handler;
	// Menu tabs
	MyJMenuTab _file, _edit, _format, _view;
	// File menu items
	MyJMenuTab _file_info;
	JMenuItem _file_new, _file_open, _file_save, _file_saveAs, _file_print, _file_info_words, _file_info_characters,
			_file_exit;
	// Edit menu items
	JMenuItem _edit_undo, _edit_redo, _format_bold, _format_italic;
	// Format menu items
	JMenuItem _format_font_Arial, _format_font_TimesNewRoman, _format_fontSize_8, _format_fontSize_12,
			_format_fontSize_16, _format_fontSize_20, _format_fontSize_24, _format_fontSize_28, _format_colorBlack,
			__format_colorWhite, _format_colorBlue, _format_colorRed, _format_colorYellow, __format_markText;
	MyJMenuTab _format_font, _format_fontSize, _format_textColor;
	// View menu items
	JMenuItem _view_lightMode, _view_darkMode;

	// Constructor
	public MyMenu(MyJFrame window, MyHandler handler) {
		super();
		this.window = window;
		this.handler = handler;
		initMenuOptions();
		initMenuItems();
	}

	// Initialize menu tabs/options/categories
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

	// Initialize menu items
	public void initMenuItems() {
		initFileMenu();
		initEditMenu();
		initFormatMenu();
		initViewMenu();
	}

	// Initialize file menu items
	public void initFileMenu() {
		_file_new = new MyJMenuItem("New", handler);
		_file.add(_file_new);
		_file_open = new MyJMenuItem("Open", handler);
		_file.add(_file_open);
		_file_save = new MyJMenuItem("Save", handler);
		_file.add(_file_save);
		_file_saveAs = new MyJMenuItem("Save As...", handler);
		_file.add(_file_saveAs);
		_file_print = new MyJMenuItem("Print", handler);
		_file.add(_file_print);
		_file_info = new MyJMenuTab("File info", handler);
		_file.add(_file_info);
		_file_info_words = new MyJMenuItem("Words count", handler);
		_file_info.add(_file_info_words);
		_file_info_characters = new MyJMenuItem("Characters count", handler);
		_file_info.add(_file_info_characters);
		_file_exit = new MyJMenuItem("Exit", handler);
		_file.add(_file_exit);
	}

	// Initialize edit menu items
	public void initEditMenu() {
		_edit_undo = new MyJMenuItem("Undo", handler);
		_edit.add(_edit_undo);
		_edit_redo = new MyJMenuItem("Redo", handler);
		_edit.add(_edit_redo);
	}

	// Initialize format menu items
	public void initFormatMenu() {
		_format_font = new MyJMenuTab("Font", handler);
		_format.add(_format_font);
		_format_fontSize = new MyJMenuTab("Font Size", handler);
		_format.add(_format_fontSize);
		_format_textColor = new MyJMenuTab("Font color", handler);
		_format.add(_format_textColor);
		initFontOptions();
		_format_bold = new MyJMenuItem("Bold", handler);
		_format.add(_format_bold);
		_format_italic = new MyJMenuItem("Italic", handler);
		_format.add(_format_italic);
		__format_markText = new MyJMenuItem("Mark text", handler);
		_format.add(__format_markText);
	}

	// Initialize format-font related items
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
		// Font-color items
		_format_colorBlack = new MyJMenuItem("Black font", handler);
		_format_textColor.add(_format_colorBlack);
		__format_colorWhite = new MyJMenuItem("White font", handler);
		_format_textColor.add(__format_colorWhite);
		_format_colorBlue = new MyJMenuItem("Blue font", handler);
		_format_textColor.add(_format_colorBlue);
		_format_colorRed = new MyJMenuItem("Red font", handler);
		_format_textColor.add(_format_colorRed);
		_format_colorYellow = new MyJMenuItem("Yellow font", handler);
		_format_textColor.add(_format_colorYellow);
	}

	// Initialize view menu items
	public void initViewMenu() {
		_view_lightMode = new MyJMenuItem("lightMode", handler);
		_view.add(_view_lightMode);
		_view_darkMode = new MyJMenuItem("darkMode", handler);
		_view.add(_view_darkMode);
	}
}