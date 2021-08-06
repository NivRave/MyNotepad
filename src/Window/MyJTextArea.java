package Window;

import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class MyJTextArea extends JTextArea {
	
	// Singleton instance
	private static MyJTextArea textAreaInstance = null;

	private MyJTextArea() {
		super();
	}
	
	//Get/create singleton instance
	public static MyJTextArea getInstance() {
		if (textAreaInstance == null)
			textAreaInstance = new MyJTextArea();
		return textAreaInstance;
	}
}