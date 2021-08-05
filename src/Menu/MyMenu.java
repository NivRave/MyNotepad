package Menu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import Window.*;

public class MyMenu extends JMenuBar{
	MyJMenuTab _file, _edit, _format, _view;
	JMenuItem _file_new, _file_open, _file_save, _file_saveAs, _file_exit;
	MyJFrame window;

	public MyMenu(MyJFrame window) {
		super();
		this.window=window;
		initMenuOptions();
		initMenuItems();
	}
	
	private void initMenuOptions() {
		_file = new MyJMenuTab("File");
		add(_file);
		_edit = new MyJMenuTab("Edit");
		add(_edit);
		_format = new MyJMenuTab("Format");
		add(_format);
		_view = new MyJMenuTab("View");
		add(_view);
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
		
		/*On-click action methods*/
		public void newFile() {
			
		}
		
}
