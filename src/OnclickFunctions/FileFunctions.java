package OnclickFunctions;

import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import Window.MyJFrame;

public class FileFunctions {

	// Main frame
	MyJFrame window;
	// Current file name/path
	String fileName;
	String filePath;

	// Constructor
	public FileFunctions(MyJFrame window) {
		this.window = window;
	}

	// Create a new file method. Activated by key-binding 'Ctrl+n'
	public void newFile() {
		window.getPanel().clear();
		window.setTitle("New File (Unsaved)");
		window.setSavedState(false);
		fileName = null;
		filePath = null;
	}

	// Open a local file from file explorer using fileDialog
	@SuppressWarnings("static-access")
	public void openFile() {
		FileDialog fileDialog = new FileDialog(window, "Open", FileDialog.LOAD);
		fileDialog.setVisible(true);

		if (fileDialog.getFile() != null) {
			fileName = fileDialog.getFile();
			filePath = fileDialog.getDirectory();
			window.setTitle(fileName);
		}
		try {
			BufferedReader bufferReader = new BufferedReader(new FileReader(filePath + fileName));
			window.getPanel().clear();
			String line;

			while ((line = bufferReader.readLine()) != null) {
				window.getPanel().append(line + "\n");
			}
			bufferReader.close();
		} catch (Exception e) {
			// CREATE SPECIAL EXCEPTION
		}
	}

	//Save current file. If the file is a new file activates save as. Activated by key-binding 'Ctrl+s'
	@SuppressWarnings("static-access")
	public void saveFile() {
		if (fileName != null) {
			try {
				System.out.println(filePath + fileName);
				FileWriter fileWriter = new FileWriter(filePath + fileName);
				fileWriter.write(window.getPanel().getText());
				fileWriter.close();
			} catch (Exception e) {
				// CREATE SPECIAL EXCEPTION
			}
		} else {
			saveFileAs();
		}
		window.setSavedState(true);
	}

	//Save-as method. Lets the user save the file to a desired location with a custom name. Activated by key-binding 'Ctrl+Shift++s' 
	@SuppressWarnings("static-access")
	public void saveFileAs() {
		FileDialog fileDialog = new FileDialog(window, "Save", FileDialog.SAVE);
		fileDialog.setVisible(true);

		if (fileDialog.getFile() != null) {
			fileName = fileDialog.getFile();
			filePath = fileDialog.getDirectory();
			window.setTitle(fileName);
		}
		try {
			FileWriter fileWriter = new FileWriter(filePath + fileName + ".txt");
			fileWriter.write(window.getPanel().getText());
			fileWriter.close();
		} catch (Exception e) {
			// CREATE SPECIAL EXCEPTION
		}
	}
	
	//Exit without saving
	public void exit() {
		System.exit(0);
	}
}