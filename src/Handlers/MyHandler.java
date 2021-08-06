package Handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import OnclickFunctions.*;
import Window.MyJFrame;

public class MyHandler implements ActionListener {

	MyJFrame window;

	FileFunctions fileFunctionsObj;
	EditFunctions editFunctionsObj;
	FormatFunctions formatFunctionsObj;
	ViewFunctions viewFunctionsObj;

	public MyHandler(MyJFrame window, FileFunctions fileF, EditFunctions editF, FormatFunctions formatF,
			ViewFunctions viewF) {
		this.window = window;
		fileFunctionsObj = fileF;
		editFunctionsObj = editF;
		formatFunctionsObj = formatF;
		viewFunctionsObj = viewF;
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
		// Edit events
		case ("Undo"):
			editFunctionsObj.undo();
			break;
		case ("Redo"):
			editFunctionsObj.redo();
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

		}
	}
}