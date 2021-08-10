package Window;

import java.awt.Color;

import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

@SuppressWarnings("serial")
public class MyJTextArea extends JTextPane {

	// Singleton instance
	private static MyJTextArea textAreaInstance = null;
	// Attribute objects
	private static SimpleAttributeSet attributes = new SimpleAttributeSet();
	// Text-related state saving variables
	boolean boldState, italicState; // Bold/italic indicator. true=active, false=inactive
	Color currentColor; // Current color
	int fontSize; // Current font size
	String fontFamily; // Current font family

	// Private constructor to match the singleton design pattern
	private MyJTextArea() {
		super();
		currentColor = Color.black;
		fontSize = 12;
		fontFamily = "Arial";
	}

	// Get/create singleton instance
	public static MyJTextArea getInstance() {
		if (textAreaInstance == null)
			textAreaInstance = new MyJTextArea();
		return textAreaInstance;
	}

	// Append text to the document - used mostly when opening an external text file
	public void append(String string) {
		Document doc = textAreaInstance.getStyledDocument();
		try {
			doc.insertString(doc.getLength(), string, getCharacterAttributes());
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Toggles the written text's bold state
	public void toggleBoldText() {
		boldState = !boldState;
		setAttributes();
	}

	// Toggles the written text's italic state
	public void toggleItalicText() {
		italicState = !italicState;
		setAttributes();
	}

	// Change the written text's color
	public void changeTextColor(Color color) {
		currentColor = color;
		setAttributes();
	}

	// Change the written text's size
	public void changeFontSize(int size) {
		fontSize = size;
		setAttributes();
	}

	// Sets current attribute set according
	private void setAttributes() {
		attributes.addAttribute(StyleConstants.CharacterConstants.Bold, boldState);
		attributes.addAttribute(StyleConstants.CharacterConstants.Italic, italicState);
		attributes.addAttribute(StyleConstants.Foreground, currentColor);
		attributes.addAttribute(StyleConstants.FontSize, fontSize);
		attributes.addAttribute(StyleConstants.FontFamily, fontFamily);
		setCharacterAttributes(attributes, true);
	}

	public void setTextFont(String font) {
		fontFamily = font;
		setAttributes();
	}

	// Mark selected text
	public void markText() {
		attributes.addAttribute(StyleConstants.Background, Color.yellow);
		setCharacterAttributes(attributes, true);
	}

	// Revert mark text state
	public void noMark() {
		attributes.addAttribute(StyleConstants.Background, Color.white);
		setCharacterAttributes(attributes, true);
	}
}