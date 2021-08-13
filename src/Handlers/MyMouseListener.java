package Handlers;

import java.awt.event.*;

import Menu.RightClickMenu;
import OnclickFunctions.*;
import Window.MyJFrame;

public class MyMouseListener extends MouseAdapter {
	RightClickMenu rcm;
	// Main frame
	MyJFrame window;
	// Functions objects
	FileFunctions fileFunctionsObj;
	EditFunctions editFunctionsObj;
	FormatFunctions formatFunctionsObj;
	ViewFunctions viewFunctionsObj;

	public MyMouseListener(MyJFrame window, FileFunctions fileF, EditFunctions editF, FormatFunctions formatF,
			ViewFunctions viewF) {
		this.window = window;
		fileFunctionsObj = fileF;
		editFunctionsObj = editF;
		formatFunctionsObj = formatF;
		viewFunctionsObj = viewF;
		rcm = new RightClickMenu(window, window.getHandler());
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON3) {
			showPopup(e);
		}
	}

	private void showPopup(MouseEvent e) {
			rcm.getMenu().show(e.getComponent(), e.getX(), e.getY());
	}

}
