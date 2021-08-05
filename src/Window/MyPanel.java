package Window;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;

public class MyPanel extends JScrollPane{
	
	//Make sure that static works - used it for the super constructor
	static MyJTextArea textArea = new MyJTextArea();

public MyPanel() {
	super(textArea, VERTICAL_SCROLLBAR_AS_NEEDED, HORIZONTAL_SCROLLBAR_AS_NEEDED);
	setBorder(BorderFactory.createEmptyBorder());
}


}
