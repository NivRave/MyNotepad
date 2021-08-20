package Handlers;

import java.awt.event.*;

import Menu.RightClickMenu;
import Window.MyJFrame;

public class MyMouseListener extends MouseAdapter {
	// Pop-up menu object
	RightClickMenu rcm;
	// Main frame
	MyJFrame window;

	// Constructor
	public MyMouseListener(MyJFrame window) {
		this.window = window;
		rcm = new RightClickMenu(window, window.getHandler());
	}

	// Mouse right-click event
	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON3) {
			showPopup(e);
		}
	}

	// Show pop-up menu on right click location
	private void showPopup(MouseEvent e) {
		rcm.getMenu().show(e.getComponent(), e.getX(), e.getY());
	}

}
