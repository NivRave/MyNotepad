package Window;

import java.awt.Color;
import java.awt.print.PrinterException;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

import Handlers.MyKeyHandler;

@SuppressWarnings("serial")
public class MyPanel extends JScrollPane {

	// Singleton instance of a MyJTextArea object
	static MyJTextArea textArea = MyJTextArea.getInstance();
	// UndoManager object
	UndoManager undoManager;

	// Constructor
	public MyPanel(MyKeyHandler keyHandler) {
		super(textArea, VERTICAL_SCROLLBAR_AS_NEEDED, HORIZONTAL_SCROLLBAR_AS_NEEDED);
		addKListener(keyHandler);
		setUndo();
		setBorder(BorderFactory.createEmptyBorder());
	}

	// Add keyHandler as a key listener
	private void addKListener(MyKeyHandler keyHandler) {
		textArea.addKeyListener(keyHandler);
	}

	// Set the undo method. Catch an undo event using UndoableEditListener() if
	// undoableEditHappened() happens in the textArea.
	public void setUndo() {
		undoManager = new UndoManager();
		textArea.getDocument().addUndoableEditListener(new UndoableEditListener() {
			public void undoableEditHappened(UndoableEditEvent e) {
				undoManager.addEdit(e.getEdit());
			}
		});
	}

	// Get undo namager object
	public UndoManager getUndoManager() {
		return undoManager;
	}

	// Clear the text area
	public void clear() {
		textArea.setText("");
	}

	// Append to the text area
	public static void append(String string) {
		textArea.append(string);
	}

	// Get the text in the text area
	public static String getText() {
		return textArea.getText();
	}

	// Set text area active font
	public void setTextFont(String fontName) {
		textArea.setTextFont(fontName);
	}

	// Set view theme
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

	// Toggle typed text bold status. Activated on 'Ctrl+b' or through 'edit' menu
	public void toggleBoldText() {
		textArea.toggleBoldText();
	}

	// Toggle typed text italic status. Activated on 'Ctrl+i' or through 'edit' men
	public void toggleItalicText() {
		textArea.toggleItalicText();
	}

	// Print the file
	public void printContent() {
		try {
			textArea.print();
		} catch (PrinterException e) {
			System.err.format("Printing error!", e.getMessage());
		}
	}

	// Change text color
	public void changeTextColor(Color color) {
		textArea.changeTextColor(color);
	}

	// Change font size
	public void changeFontSize(int fontSize) {
		textArea.changeFontSize(fontSize);
	}

	// Notify if a certain text is selected in the document
	public boolean isSelected() {
		if (textArea.getSelectedText() != null)
			return true;
		else
			return false;
	}

	// Mark text in yellow
	public void markText() {
	textArea.markText();	
	}

	public void noMark() {
		textArea.noMark();
	}
}
