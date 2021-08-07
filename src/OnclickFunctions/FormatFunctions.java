package OnclickFunctions;

import java.awt.Color;

import Window.MyJFrame;

public class FormatFunctions {

	// Main frame
	MyJFrame window;

	// Constructor
	public FormatFunctions(MyJFrame window) {
		this.window = window;
	}

	// Set current font to the give fontName
	public void setFont(String fontName) {
		window.getPanel().setTextFont(fontName);
	}

	// Set font size and type
	public void setFontSize(int fontSize) {
		window.getPanel().changeFontSize(fontSize);
	}

	// Toggle text bold/no bold
	public void toggleBoldText() {
		window.getPanel().toggleBoldText();
	}

	// Toggle text italic/no italic
	public void toggleItalicText() {
		window.getPanel().toggleItalicText();
	}

	// Change current text color
	public void changeFontColor(String name) {
		switch (name.substring(0, name.indexOf(" "))) {
		case ("Black"):
			window.getPanel().changeTextColor(Color.black);
			break;
		case ("White"):
			window.getPanel().changeTextColor(Color.white);
			break;
		case ("Blue"):
			window.getPanel().changeTextColor(Color.blue);
			break;
		case ("Red"):
			window.getPanel().changeTextColor(Color.red);
			break;
		case ("Yellow"):
			window.getPanel().changeTextColor(Color.yellow);
			break;
		}
	}
}
