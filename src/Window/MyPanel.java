package Window;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class MyPanel extends JScrollPane {
	// Make sure that static works - used it for the super constructor
	static MyJTextArea textArea = new MyJTextArea();

	public MyPanel() {
		super(textArea, VERTICAL_SCROLLBAR_AS_NEEDED, HORIZONTAL_SCROLLBAR_AS_NEEDED);
		setBorder(BorderFactory.createEmptyBorder());
	}

	public void clear() {
		textArea.setText("");
	}

	public static void append(String string) {
		textArea.append(string);
	}

	public static String getText() {
		return textArea.getText();
	}

}
