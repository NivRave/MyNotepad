package OnclickFunctions;

import java.awt.Font;

import Window.MyJFrame;

public class FormatFunctions {

	MyJFrame window;
	Font arial, timesNewRoman;
	String activeFont;
	boolean wordWrap;

	public FormatFunctions(MyJFrame window) {
		this.window = window;
	}

	public void initFontData() {
		activeFont="Arial";
		arial = new Font("Arial", Font.PLAIN, 8);
	}

	public void wordWrap() {
		wordWrap = !wordWrap;
		window.toggleWordWrap(wordWrap);
	}

	public void setFont(String fontName) {
		activeFont=fontName;		
		switch(activeFont) {
		case ("Arial"):
			window.setTextFont(arial);
		break;
		case ("Times New Roman"):
			window.setTextFont(timesNewRoman);
		break;
		}
	}

	public void setFontSize(int fontSize) {
		arial = new Font("Arial", Font.PLAIN, fontSize);
		timesNewRoman = new Font("Times New Roman", Font.PLAIN, fontSize);
		setFont(activeFont);
	}
	
	//TODO: add bold method

}
