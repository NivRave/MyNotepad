package OnclickFunctions;

import Window.MyJFrame;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class EditFunctions {

	// Main frame
	MyJFrame window;

	// Constructor
	public EditFunctions(MyJFrame window) {
		this.window = window;
	}

	// Undo method
	public void undo() {
		window.getPanel().getUndoManager().undo();
	}

	// Redo method
	public void redo() {
		window.getPanel().getUndoManager().redo();
	}

	// Copy selected text method
	public void copy() {
		StringSelection stringSelection = new StringSelection(window.getPanel().getSelectedText());
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);
	}

	public void cut() {
		// TODO Auto-generated method stub
	}

	public void paste() {
		// TODO Auto-generated method stub
	}

}