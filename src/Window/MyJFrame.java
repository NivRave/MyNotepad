package Window;

import java.awt.Font;
import javax.swing.JFrame;
import Handlers.*;
import Menu.*;
import OnclickFunctions.*;

@SuppressWarnings("serial")
public class MyJFrame extends JFrame {

	MyPanel panel;
	MyMenu menuBar;
	MyHandler handler;
	MyKeyHandler keyHandler;

	public MyJFrame(String name) {
		super(name);
		initHandlers();
		initWindow();
		initMenu();
		panel.setTextFont(new Font("Arial", Font.PLAIN, 12));
	}

	private void initHandlers() {
		FileFunctions fileFunctionsObj = new FileFunctions(this);
		EditFunctions editFunctionsObj = new EditFunctions(this);
		FormatFunctions formatFunctionsObj = new FormatFunctions(this);
		ViewFunctions viewFunctionsObj = new ViewFunctions(this);

		handler = new MyHandler(this, fileFunctionsObj, editFunctionsObj, formatFunctionsObj, viewFunctionsObj);
		keyHandler = new MyKeyHandler(this, fileFunctionsObj, editFunctionsObj, formatFunctionsObj, viewFunctionsObj);
	}

	private void initMenu() {
		menuBar = new MyMenu(this, handler);
		setJMenuBar(menuBar);
	}

	// Init the window
	private void initWindow() {
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new MyPanel(keyHandler);
		add(panel);
	}

	public MyPanel getPanel() {
		return panel;
	}

}