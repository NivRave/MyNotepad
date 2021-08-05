import javax.swing.BorderFactory;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Notepad {
	//Create separate classes for each item
	MyJFrame window;
	JTextArea textArea;
	JScrollPane scrollPane;
	JMenuBar menuBar;
	JMenu _file, _edit, _format, _view;
	JMenuItem _file_new, _file_open, _file_save, _file_saveAs, _file_exit;
	
	public static void main(String[] args) {
		
		new Notepad();
	}

	//Default constructor
	public Notepad() {
		initWindow();
		initTextArea();
		initMenuBar();
		window.setVisible(true);
	}
	
	//Create a MyJFrame object and initialize
	public void initWindow() {
		window = new MyJFrame("My Notepad");
	}
	
	//Text area - text edit area
	public void initTextArea() {
		textArea = new JTextArea();
		scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		window.add(scrollPane);
	}
	
	//Init upper menu bar
	public void initMenuBar() {
		menuBar = new JMenuBar();
		window.setJMenuBar(menuBar);
		initMenuOptions();
		initMenuItems();
	}
	
	//Init menu bar tabs
	public void initMenuOptions() {
		_file = new JMenu("File");
		menuBar.add(_file);
		_edit = new JMenu("Edit");
		menuBar.add(_edit);
		_format = new JMenu("Format");
		menuBar.add(_format);
		_view = new JMenu("View");
		menuBar.add(_view);
	}
	//Init menu tabs items
	public void initMenuItems() {
		initFileMenu();
	}
	//Init file menu items
	public void initFileMenu() {
		_file_new=new JMenuItem("New");
		_file.add(_file_new);
		_file_open=new JMenuItem("Open");
		_file.add(_file_open);
		_file_save=new JMenuItem("Save");
		_file.add(_file_save);
		_file_saveAs=new JMenuItem("Save As...");
		_file.add(_file_saveAs);
		_file_exit=new JMenuItem("Exit");
		_file.add(_file_exit);
	}
	public void initEditMenu() {

	}
	public void initFormatMenu() {

	}
	public void initViewMenu() {

	}
}
