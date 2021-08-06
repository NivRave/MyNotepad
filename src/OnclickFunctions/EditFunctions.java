package OnclickFunctions;

import Window.MyJFrame;

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
}