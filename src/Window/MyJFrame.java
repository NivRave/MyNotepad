package Window;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
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
		setTextFont(new Font("Arial", Font.PLAIN, 12));
	}

	private void initHandler() {
		handler = new MyHandler(this);
	}

	private void initMenu() {
		menuBar = new MyMenu(this, handler);
		this.setJMenuBar(menuBar);
	}

	// Init the window
	private void initWindow() {
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new MyPanel();
		this.add(panel);
	}

	public void newFile() {
		panel.clear();
		setTitle("New File (Unsaved)");
	}

	public void clear() {
		panel.clear();
	}

	@SuppressWarnings("static-access")
	public void append(String string) {
		panel.append(string);
	}

	@SuppressWarnings("static-access")
	public String getText() {
		return panel.getText();
	}

	public void toggleWordWrap(boolean wordWrap) {
		panel.toggleWordWrap(wordWrap);
	}

	public void setTextFont(Font font) {
		panel.setTextFont(font);
	}

	public class MyHandler implements ActionListener {

		MyJFrame window;

		FileFunctions fileFunctionsObj;
		FormatFunctions formatFunctionsObj;

		public MyHandler(MyJFrame window) {
			this.window = window;
			fileFunctionsObj = new FileFunctions(window);
			formatFunctionsObj = new FormatFunctions(window);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			String action = e.getActionCommand();
			setFunctionsObjectType(action);
		}

		private void setFunctionsObjectType(String name) {
			switch (name) {
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
			case ("Word Wrap"):
				formatFunctionsObj.wordWrap();
				break;
			case ("8"):
			case ("12"):
			case ("16"):
			case ("20"):
				formatFunctionsObj.setFontSize(Integer.parseInt(name));
				break;
			case ("Arial"):
			case ("Times New Roman"):
				formatFunctionsObj.setFont(name);
				break;
			}
		}
	}

}