package Window;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.undo.UndoManager;

import Menu.*;
import OnclickFunctions.*;

@SuppressWarnings("serial")
public class MyJFrame extends JFrame {

	MyPanel panel;
	MyMenu menuBar;
	MyHandler handler;

	public MyJFrame(String name) {
		super(name);
		initHandler();
		initWindow();
		initMenu();
		panel.setTextFont(new Font("Arial", Font.PLAIN, 12));
	}

	private void initHandler() {
		handler = new MyHandler(this);
	}

	private void initMenu() {
		menuBar = new MyMenu(this, handler);
		setJMenuBar(menuBar);
	}

	// Init the window
	private void initWindow() {
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new MyPanel();
		add(panel);
	}

	public MyPanel getPanel() {
		return panel;
	}

	public class MyHandler implements ActionListener {

		MyJFrame window;

		FileFunctions fileFunctionsObj;
		FormatFunctions formatFunctionsObj;
		ViewFunctions viewFunctionsObj;
		EditFunctions editFunctionsObj;

		public MyHandler(MyJFrame window) {
			this.window = window;
			fileFunctionsObj = new FileFunctions(window);
			formatFunctionsObj = new FormatFunctions(window);
			viewFunctionsObj = new ViewFunctions(window);
			editFunctionsObj = new EditFunctions(window);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			String action = e.getActionCommand();
			handleEvent(action);
		}

		private void handleEvent(String name) {
			switch (name) {
			// File events
			case ("New"):
				fileFunctionsObj.newFile();
				break;
			case ("Open"):
				fileFunctionsObj.openFile();
				break;
			case ("Save As..."):
				fileFunctionsObj.saveFileAs();
				break;
			case ("Save"):
				fileFunctionsObj.saveFile();
				break;
			case ("Exit"):
				fileFunctionsObj.exit();
				break;
			// Font events
			case ("Word Wrap"):
				formatFunctionsObj.wordWrap();
				break;
			// Font size events
			case ("8"):
			case ("12"):
			case ("16"):
			case ("20"):
			case ("24"):
			case ("28"):
				formatFunctionsObj.setFontSize(Integer.parseInt(name));
				break;
			// Font type events
			case ("Arial"):
			case ("Times New Roman"):
				formatFunctionsObj.setFont(name);
				break;
			// View mode events
			case ("lightMode"):
			case ("darkMode"):
				viewFunctionsObj.setViewMode(name);
				break;
			// Edit events
			case ("Undo"):
				editFunctionsObj.undo();
				break;
			case ("Redo"):
				editFunctionsObj.redo();
				break;
			}
		}
	}

}