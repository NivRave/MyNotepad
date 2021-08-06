package OnclickFunctions;

import java.awt.Font;

import Window.MyJFrame;

public class FormatFunctions {

	// Main frame
	MyJFrame window;
	// Font related variables
	Font arial, timesNewRoman;
	String activeFont;
//	// Word wrap indicator. true=activated, false=not activated.
//	boolean wordWrap;

	// Constructor
	public FormatFunctions(MyJFrame window) {
		this.window = window;
	}

	// Initialize default font - Arial with size 12
	public void initFontData() {
		activeFont = "Arial";
		arial = new Font("Arial", Font.PLAIN, 12);
	}

//	// Word wrap toggler
//	public void wordWrap() {
//		wordWrap = !wordWrap;
//		window.getPanel().toggleWordWrap(wordWrap);
//	}

	// Set current font to the give fontName
	public void setFont(String fontName) {
		activeFont = fontName;
		switch (activeFont) {
		case ("Arial"):
			window.getPanel().setTextFont(arial);
			break;
		case ("Times New Roman"):
			window.getPanel().setTextFont(timesNewRoman);
			break;
		}
	}

	// Set font size and type
	public void setFontSize(int fontSize) {
		arial = new Font("Arial", Font.PLAIN, fontSize);
		timesNewRoman = new Font("Times New Roman", Font.PLAIN, fontSize);
		setFont(activeFont);
	}

	// Toggle text bold/no bold
	public void toggleBoldText() {
		// TODO Auto-generated method stub
		window.getPanel().toggleBoldText();
	}

	// Toggle text italic/no italic
	public void toggleItalicText() {
		window.getPanel().toggleItalicText();
	}

}
