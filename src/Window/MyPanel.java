package Window;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

import Handlers.MyKeyHandler;

@SuppressWarnings("serial")
public class MyPanel extends JScrollPane {
	// Make sure that static works - used it for the super constructor
	static MyJTextArea textArea = new MyJTextArea();
	UndoManager undoManager;

	public MyPanel(MyKeyHandler keyHandler) {
		super(textArea, VERTICAL_SCROLLBAR_AS_NEEDED, HORIZONTAL_SCROLLBAR_AS_NEEDED);
		addKListener(keyHandler);
		setUndo();
		setBorder(BorderFactory.createEmptyBorder());
	}

	private void addKListener(MyKeyHandler keyHandler) {
		textArea.addKeyListener(keyHandler);
	}

	public void setUndo() {
		undoManager = new UndoManager();
		textArea.getDocument().addUndoableEditListener(new UndoableEditListener() {
			public void undoableEditHappened(UndoableEditEvent e) {
				undoManager.addEdit(e.getEdit());
			}
		});
	}

	public UndoManager getUndoManager() {
		return undoManager;
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

	public void toggleWordWrap(boolean wordWrap) {
		textArea.setLineWrap(wordWrap);
		textArea.setWrapStyleWord(wordWrap);
	}

	public void setTextFont(Font font) {
		textArea.setFont(font);
	}

	public void setColors(String mode) {
		switch (mode) {
		case ("lightMode"):
			textArea.setBackground(Color.decode("#DDDDDD"));
			textArea.setForeground(Color.decode("#423F3E"));
			break;
		case ("darkMode"):
			textArea.setBackground(Color.decode("#423F3E"));
			textArea.setForeground(Color.decode("#DDDDDD"));
			break;
		}
	}

}
