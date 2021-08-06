package Window;

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
	// Bold indicator. true=active, false=inactive
	boolean boldState, italicState;

	private MyJTextArea() {
		super();
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

	// Sets current attribute set according to the saved boldState/italicState
	private void setAttributes() {
		attributes.addAttribute(StyleConstants.CharacterConstants.Bold, boldState);
		attributes.addAttribute(StyleConstants.CharacterConstants.Italic, italicState);
		setCharacterAttributes(attributes, true);
	}

}