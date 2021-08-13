package Window;

import java.awt.Color;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

@SuppressWarnings("serial")
public class TextArea extends JTextPane {

	// Singleton instance
	private static TextArea textAreaInstance = null;
	// Attribute objects
	private static SimpleAttributeSet attributes = new SimpleAttributeSet();
	// Text-related state saving variables
	boolean boldState, italicState; // Bold/italic indicator. true=active, false=inactive
	Color bgColor, txtColor; // Current color
	int fontSize; // Current font size
	String fontFamily; // Current font family

	// Private constructor to match the singleton design pattern
	private TextArea() {
		super();
		// bgColor=Color.decode("#DDDDDD");
		// attributes.addAttribute(StyleConstants.Background, bgColor);
		txtColor = Color.decode("#423F3E");
		attributes.addAttribute(StyleConstants.Foreground, txtColor);
		fontSize = 12;
		fontFamily = "Arial";
	}

	// Get/create singleton instance
	public static TextArea getInstance() {
		if (textAreaInstance == null)
			textAreaInstance = new TextArea();
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
		txtColor = color;
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
		attributes.addAttribute(StyleConstants.Foreground, txtColor);
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
		if (getSelectedText() != null) {
			if (attributes.getAttribute(StyleConstants.Background) == Color.yellow) {
				attributes.removeAttribute(StyleConstants.Background);
				// attributes.addAttribute(StyleConstants.Background, Color.yellow);
			} else {
				attributes.removeAttribute(StyleConstants.Background);
				attributes.addAttribute(StyleConstants.Background, Color.yellow);
			}
			setCharacterAttributes(attributes, true);
		}
	}

	// Revert mark text state
	public void noMark() {

//		if (attributes.getAttribute(attributes) == Color.white) {
//			attributes.removeAttribute(StyleConstants.Background);
//			attributes.addAttribute(StyleConstants.Background, Color.yellow);
//		} else {
//			attributes.removeAttribute(StyleConstants.Background);
//			attributes.addAttribute(StyleConstants.Background, Color.white);
//		}
//		setCharacterAttributes(attributes, true);
	}

	// Count words in the text
	public void countWords() {
		StringTokenizer tokens = new StringTokenizer(getText());
		JOptionPane.showMessageDialog(this, "Total words count: " + tokens.countTokens());
	}

	// Count characters in the text
	public void countCharacters() {
		int characters = 0;
		StringTokenizer tokens = new StringTokenizer(getText());
		while (tokens.hasMoreTokens()) {
			characters += tokens.nextToken().length();
		}
		JOptionPane.showMessageDialog(this, "Total characters count: " + characters);
	}

	public void lightMode() {
		bgColor=Color.decode("#DDDDDD");
		txtColor = Color.decode("#423F3E");
		//attributes.removeAttribute(StyleConstants.Background);
		//attributes.addAttribute(StyleConstants.Background, bgColor);
		setBackground(Color.decode("#DDDDDD"));
		//StyleConstants.setBackground(attributes, Color.decode("#DDDDDD"));
		attributes.removeAttribute(StyleConstants.Foreground);
		attributes.addAttribute(StyleConstants.Foreground, txtColor);
		setCharacterAttributes(attributes, true);
	}

	public void darkMode() {
		txtColor = Color.decode("#DDDDDD");
//		bgColor=Color.decode("#423F3E");
//		attributes.removeAttribute(StyleConstants.Background);
//		attributes.addAttribute(StyleConstants.Background, bgColor);
		setBackground(Color.decode("#423F3E"));
//		StyleConstants.setBackground(attributes, Color.decode("#423F3E"));
		attributes.removeAttribute(StyleConstants.Foreground);
		attributes.addAttribute(StyleConstants.Foreground, txtColor);
		setCharacterAttributes(attributes, true);
	}
}