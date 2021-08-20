package OnclickFunctions;

import Window.MyJFrame;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import javax.swing.text.BadLocationException;

public class EditFunctions implements FunctionsObject {
	// Main frame
	MyJFrame window;

	// Constructor
	public EditFunctions(MyJFrame window) {
		this.window = window;
	}

	// Undo method
	public void undo() {
		window.getPanel().undo();
	}

	// Redo method
	public void redo() {
		window.getPanel().redo();
	}

	// Right click menu copy method
	public void copy() {
		if (window.getPanel().getSelectedText() != null) {
			StringSelection stringSelection = new StringSelection(window.getPanel().getSelectedText());
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(stringSelection, null);
		}
	}

	// Right click menu cut method
	public void cut() {
		if (window.getPanel().getSelectedText() != null) {
			StringSelection stringSelection = new StringSelection(window.getPanel().getSelectedText());
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(stringSelection, null);

			int startPosition = window.getPanel().getTextArea().getSelectionStart();
			int endPosition = window.getPanel().getTextArea().getSelectionEnd();
			try {
				window.getPanel().getTextArea().getDocument().remove(startPosition, endPosition - startPosition);
			} catch (BadLocationException e) {
				e.printStackTrace();
			}
		}
	}

	// Right click menu paste method
	public void paste() {
		Clipboard c = Toolkit.getDefaultToolkit().getSystemClipboard();
		Transferable t = c.getContents(this);
		if (t == null)
			return;
		try {
			window.getPanel().getTextArea().getDocument().insertString(
					window.getPanel().getTextArea().getCaretPosition(),
					(String) t.getTransferData(DataFlavor.stringFlavor), null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}