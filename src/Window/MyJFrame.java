package Window;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Handlers.*;
import Menu.*;
import OnclickFunctions.*;

@SuppressWarnings("serial")
public class MyJFrame extends JFrame {
	// Panel and menu
	Panel panel;
	MyMenu menuBar;
	// Handlers
	MyHandler handler;
	MyKeyHandler keyHandler;
	MyMouseListener mouseHandler;
	// Save state indicator - true=file is saved, false=file is unsaved
	boolean savedState;

	// Constructor
	public MyJFrame(String name) {
		super(name);
		initHandlers();
		initWindow();
		initMenu();
		savedState = true;
	}

	// Initialize the handlers and functions objects
	private void initHandlers() {
		// Init functions objects
		FunctionsObjectFactory factory = new FunctionsObjectFactory();
		FunctionsObject fileFunctionsObj = factory.getObject("file", this);
		FunctionsObject editFunctionsObj = factory.getObject("edit", this);
		FunctionsObject formatFunctionsObj = factory.getObject("format", this);
		FunctionsObject viewFunctionsObj = factory.getObject("view", this);
		// Previous creation method - pre-factory
//		FileFunctions fileFunctionsObj = new FileFunctions(this);
//		EditFunctions editFunctionsObj = new EditFunctions(this);
//		FormatFunctions formatFunctionsObj = new FormatFunctions(this);
//		ViewFunctions viewFunctionsObj = new ViewFunctions(this);
		// Init handlers
		handler = new MyHandler(this, fileFunctionsObj, editFunctionsObj, formatFunctionsObj, viewFunctionsObj);
		keyHandler = new MyKeyHandler(this, fileFunctionsObj, editFunctionsObj, formatFunctionsObj, viewFunctionsObj);
		mouseHandler = new MyMouseListener(this);
	}

	// Initialize the window and panel
	private void initWindow() {
		setSize(800, 600);
		setCloseMethod();
		panel = new Panel(keyHandler, mouseHandler);
		add(panel);
	}

	// Initialize the menu bar
	private void initMenu() {
		menuBar = new MyMenu(this, handler);
		setJMenuBar(menuBar);
	}

	// Get the used panel
	public Panel getPanel() {
		return panel;
	}

	// Get current handler
	public MyHandler getHandler() {
		return handler;
	}

	// Get saved state status
	public boolean getSavedState() {
		return savedState;
	}

	// Set save state to true/false
	public void setSavedState(boolean state) {
		savedState = state;
	}

	// Custom frame closing window. When a windowClosing event is caught the program
	// will check if the file is saved. If not - it will alert with a confirmDialog
	// that will allow the user to save by clicking 'Yes', exit by clicking 'No' and
	// cancel by clicking 'Cancel'. If savedState = true the program will simply
	// exit with no dialog shown.
	private void setCloseMethod() {
		setDefaultCloseOperation(MyJFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				MyJFrame frame = (MyJFrame) e.getSource();
				if (savedState == false) {
					int result = JOptionPane.showConfirmDialog(frame,
							"There are unsaved changes, would you like to save before exiting?", "Exit Application",
							JOptionPane.YES_NO_CANCEL_OPTION);
					if (result == JOptionPane.NO_OPTION)
						frame.setDefaultCloseOperation(MyJFrame.EXIT_ON_CLOSE);
					if (result == JOptionPane.YES_OPTION) {
						handler.getFileObj().saveFile();
						frame.setDefaultCloseOperation(MyJFrame.EXIT_ON_CLOSE);
					}
				} else {
					frame.setDefaultCloseOperation(MyJFrame.EXIT_ON_CLOSE);
				}
			}
		});
	}
}