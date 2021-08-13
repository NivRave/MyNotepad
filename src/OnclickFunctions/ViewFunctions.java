package OnclickFunctions;

import java.awt.Color;

import Window.MyJFrame;

public class ViewFunctions {
	MyJFrame window;

	public ViewFunctions(MyJFrame window) {
		this.window = window;
	}

	public void setViewMode(String mode) {
		switch (mode) {
		case ("lightMode"):
			//window.getContentPane().setBackground(Color.decode("#DDDDDD"));
			window.getPanel().setColors(mode);
			break;
		case ("darkMode"):
			//window.getContentPane().setBackground(Color.decode("#423F3E"));
			window.getPanel().setColors(mode);
			break;
		}
	}
}