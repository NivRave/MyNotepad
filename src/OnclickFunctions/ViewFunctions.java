package OnclickFunctions;

import Window.MyJFrame;

public class ViewFunctions implements FunctionsObject {
	// Main frame
	MyJFrame window;

	// Constructor
	public ViewFunctions(MyJFrame window) {
		this.window = window;
	}

	// Change view mode - light/dark mode
	public void setViewMode(String mode) {
		switch (mode) {
		case ("lightMode"):
			window.getPanel().setColors(mode);
			break;
		case ("darkMode"):
			window.getPanel().setColors(mode);
			break;
		}
	}
}