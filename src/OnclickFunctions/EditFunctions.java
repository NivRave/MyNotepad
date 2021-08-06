package OnclickFunctions;

import Window.MyJFrame;

public class EditFunctions {
	MyJFrame window;

	public EditFunctions(MyJFrame window) {
		this.window = window;
	}

	public void undo() {
		window.getPanel().getUndoManager().undo();
	}

	public void redo() {
		window.getPanel().getUndoManager().redo();
	}
}
