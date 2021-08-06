package Handlers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import OnclickFunctions.*;
import Window.MyJFrame;

public class MyKeyHandler implements KeyListener {
	// Main frame
	MyJFrame window;
	// Functions objects
	FileFunctions fileFunctionsObj;
	EditFunctions editFunctionsObj;
	FormatFunctions formatFunctionsObj;
	ViewFunctions viewFunctionsObj;

	// Constructor
	public MyKeyHandler(MyJFrame window, FileFunctions fileF, EditFunctions editF, FormatFunctions formatF,
			ViewFunctions viewF) {
		this.window = window;
		fileFunctionsObj = fileF;
		editFunctionsObj = editF;
		formatFunctionsObj = formatF;
		viewFunctionsObj = viewF;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// Ctrl+s = save, Ctrl+Shift+s = save as
		if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_S) {
			if (e.isShiftDown()) {
				fileFunctionsObj.saveFileAs();
			} else
				fileFunctionsObj.saveFile();
		}
		// Ctrl+z = undo
		if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_Z) {
			editFunctionsObj.undo();
		}
		// Ctrl+y = redo
		if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_Y) {
			editFunctionsObj.redo();
		}
		// Ctrl+n = new file
		if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_N) {
			fileFunctionsObj.newFile();
		}
		// Set save state=true if a text-changing key has been pressed
		if (window.getSavedState() == true) {
			if (isChar(e.getKeyCode()) == true)
				window.setSavedState(false);
		}
	}

	// Checks if a keycode index matches a character/actions that changes the
	// document so that save is needed to keep the current text
	private boolean isChar(int keyCode) {
		if ((keyCode >= 8 && keyCode <= 10) || keyCode == 32 || (keyCode >= 44 && keyCode <= 57) || keyCode == 59
				|| keyCode == 61 || (keyCode >= 65 && keyCode <= 93) || (keyCode >= 96 && keyCode <= 111)
				|| keyCode == 127 || (keyCode >= 150 && keyCode <= 153) || keyCode == 157
				|| (keyCode >= 160 && keyCode <= 162) || keyCode == 192 || keyCode == 222
				|| (keyCode >= 512 && keyCode <= 523))
			return true;
		else
			return false;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
