package Handlers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import OnclickFunctions.*;
import Window.MyJFrame;

public class MyKeyHandler implements KeyListener {
	MyJFrame window;

	FileFunctions fileFunctionsObj;
	EditFunctions editFunctionsObj;
	FormatFunctions formatFunctionsObj;
	ViewFunctions viewFunctionsObj;

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
		//Ctrl+n = new file
		if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_N) {
			fileFunctionsObj.newFile();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
