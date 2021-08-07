package Handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import OnclickFunctions.*;
import Window.MyJFrame;

public class MyHandler implements ActionListener {
	// Main frame
	MyJFrame window;
	// Functions objects
	FileFunctions fileFunctionsObj;
	EditFunctions editFunctionsObj;
	FormatFunctions formatFunctionsObj;
	ViewFunctions viewFunctionsObj;

	// Constructor
	public MyHandler(MyJFrame window, FileFunctions fileF, EditFunctions editF, FormatFunctions formatF,
			ViewFunctions viewF) {
		this.window = window;
		fileFunctionsObj = fileF;
		editFunctionsObj = editF;
		formatFunctionsObj = formatF;
		viewFunctionsObj = viewF;
	}

	// Get file functions object
	public FileFunctions getFileObj() {
		return fileFunctionsObj;
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
		case ("Print"):
			fileFunctionsObj.print();
			break;
		case ("Exit"):
			fileFunctionsObj.exit();
			break;
		// Edit events
		case ("Undo"):
			editFunctionsObj.undo();
			break;
		case ("Redo"):
			editFunctionsObj.redo();
			break;
		// Font events
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
		// Font design events
		case ("Bold"):
			formatFunctionsObj.toggleBoldText();
			break;
		case ("Italic"):
			formatFunctionsObj.toggleItalicText();
			break;
		// Font color events
		case ("Black font"):
		case ("White font"):
		case ("Blue font"):
		case ("Red font"):
		case ("Yellow font"):
			formatFunctionsObj.changeFontColor(name);
			break;
		// View mode events
		case ("lightMode"):
		case ("darkMode"):
			viewFunctionsObj.setViewMode(name);
			break;

		}
	}
}
